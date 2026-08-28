package com.fincatto.documentofiscal.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Monta e desempacota o envelope SOAP 1.2: um unico elemento "wrapper"
 * (ex.: {@code nfeDadosMsg}/{@code nfeResultMsg}) dentro de {@code soap:Body}, contendo o
 * XML de negocio (ja serializado pelo Simple XML Framework) como filho direto.
 * <p>
 */
public final class DFSoapEnvelope {

    private static final String SOAP12_NS = "http://www.w3.org/2003/05/soap-envelope";
    private static final String ATRIBUTO_XMLNS = " xmlns=\"";

    private DFSoapEnvelope() {
    }

    /**
     * Envelopa o XML de negocio dentro de {@code soap:Envelope/soap:Body/wrapperElemento}.
     *
     * @param wrapperNamespace namespace do elemento wrapper, definido pelo WSDL do servico (ex.: {@code .../wsdl/NFeStatusServico4}).
     * @param wrapperElemento nome local do elemento wrapper (ex.: {@code nfeDadosMsg}).
     * @param xmlNegocio XML de negocio ja serializado (ex.: {@code consStatServ}), com seu proprio namespace.
     * @return o envelope SOAP 1.2 completo, pronto para ser enviado no corpo da requisicao HTTP.
     */
    public static String envelopar(final String wrapperNamespace, final String wrapperElemento, final String xmlNegocio) {
        return "<soap:Envelope xmlns:soap=\"" + SOAP12_NS + "\">"
                + "<soap:Body>"
                + "<" + wrapperElemento + ATRIBUTO_XMLNS + wrapperNamespace + "\">" + xmlNegocio + "</" + wrapperElemento + ">"
                + "</soap:Body>"
                + "</soap:Envelope>";
    }

    /**
     * Envelopa o XML de negocio dentro de {@code soap:Envelope/soap:Body/wrapperElemento}, com
     * um {@code soap:Header} adicional - usado por WSDLs que exigem cabecalho (ex.: o
     * {@code cteCabecMsg} de todo webservice do cte300, com {@code cUF}/{@code versaoDados|).
     * Overload aditivo: nao afeta {@link #envelopar(String, String, String)}, usado por
     * servicos sem cabecalho (nfe400, cte400).
     *
     * @param namespace namespace do elemento de cabecalho e do elemento wrapper do corpo (o
     * mesmo, conforme o WSDL da operacao).
     * @param headerElemento nome local do elemento de cabecalho (ex.: {@code cteCabecMsg}).
     * @param headerXml XML do cabecalho ja serializado (ex.: {@code <cUF>35</cUF><versaoDados>3.00</versaoDados>}).
     * @param bodyElemento nome local do elemento wrapper do corpo (ex.: {@code cteDadosMsg}).
     * @param xmlNegocio XML de negocio ja serializado, com seu proprio namespace.
     * @return o envelope SOAP 1.2 completo, pronto para ser enviado no corpo da requisicao HTTP.
     */
    public static String envelopar(final String namespace, final String headerElemento, final String headerXml, final String bodyElemento, final String xmlNegocio) {
        return "<soap:Envelope xmlns:soap=\"" + SOAP12_NS + "\">"
                + "<soap:Header>"
                + "<" + headerElemento + ATRIBUTO_XMLNS + namespace + "\">" + headerXml + "</" + headerElemento + ">"
                + "</soap:Header>"
                + "<soap:Body>"
                + "<" + bodyElemento + ATRIBUTO_XMLNS + namespace + "\">" + xmlNegocio + "</" + bodyElemento + ">"
                + "</soap:Body>"
                + "</soap:Envelope>";
    }

    /**
     * Desempacota a resposta SOAP 1.2 devolvida pela SEFAZ, retornando o XML de negocio
     * (o filho do elemento wrapper, ex.: {@code retConsStatServ}) pronto para ser lido pelo
     * {@link org.simpleframework.xml.core.Persister}.
     *
     * @param respostaXml corpo da resposta HTTP, um envelope SOAP 1.2 completo.
     * @return o XML de negocio de dentro do wrapper.
     * @throws DFSoapFaultException se a resposta for um {@code soap:Fault}.
     */
    public static String desempacotar(final String respostaXml) throws DFSoapFaultException {
        return DFSoapEnvelope.desempacotar(respostaXml, 1);
    }

    /**
     * Variante de {@link #desempacotar(String)} para operacoes cujo WSDL aninha o XML de
     * negocio dentro de mais de um elemento wrapper (ex.: NFeDistribuicaoDFe, cujo corpo SOAP e
     * {@code nfeDistDFeInteresseResponse > NFeDistDFeInteresseResult > <retDistDFeInt>...},
     * dois niveis de wrapper em vez de um).
     *
     * @param niveisDeWrapper quantidade de elementos wrapper entre {@code soap:Body} e o XML de
     * negocio (1 para o caso comum, coberto pelo overload de um argumento).
     * @throws IllegalArgumentException se {@code niveisDeWrapper} for menor que 1.
     */
    public static String desempacotar(final String respostaXml, final int niveisDeWrapper) throws DFSoapFaultException {
        if (niveisDeWrapper < 1) {
            throw new IllegalArgumentException("niveisDeWrapper deve ser no minimo 1, recebido: " + niveisDeWrapper);
        }
        try {
            final Document documento = criarDocumentBuilderFactory().newDocumentBuilder().parse(new InputSource(new StringReader(respostaXml)));

            final Element body = (Element) documento.getElementsByTagNameNS(SOAP12_NS, "Body").item(0);
            Element wrapperAtual = primeiroElementoFilho(body);

            if ("Fault".equals(wrapperAtual.getLocalName())) {
                throw new DFSoapFaultException(textoDoFault(wrapperAtual));
            }

            // desce um nivel de wrapper por vez ate sobrar so o penultimo, cujo filho e o XML de negocio
            for (int nivel = 1; nivel < niveisDeWrapper; nivel++) {
                wrapperAtual = primeiroElementoFilho(wrapperAtual);
            }

            return serializar(primeiroElementoFilho(wrapperAtual));
        } catch (final DFSoapFaultException e) {
            throw e;
        } catch (final Exception e) {
            throw new IllegalStateException("Resposta da SEFAZ nao e um envelope SOAP 1.2 valido", e);
        }
    }

    /**
     * Tenta reconhecer um {@code soap:Fault} no corpo de uma resposta HTTP de erro (codigo HTTP
     * &gt;= 300) - a SEFAZ por vezes devolve o Fault dentro de um envelope SOAP 1.2 valido sob um
     * codigo de erro (tipicamente HTTP 500). Ao contrario de {@link #desempacotar}, nunca lanca excecao: um corpo
     * que nao seja um envelope SOAP 1.2 valido, ou cujo {@code soap:Body} nao comece com
     * {@code soap:Fault}, simplesmente nao e reconhecido como Fault.
     *
     * @param respostaXml corpo da resposta HTTP.
     * @return a excecao representando o Fault reconhecido, ou {@code null} se o corpo nao for um
     * {@code soap:Fault} reconhecivel.
     */
    static DFSoapFaultException tentarReconhecerFault(final String respostaXml) {
        try {
            final Document documento = criarDocumentBuilderFactory().newDocumentBuilder().parse(new InputSource(new StringReader(respostaXml)));
            final Element body = (Element) documento.getElementsByTagNameNS(SOAP12_NS, "Body").item(0);
            if (body == null) {
                return null;
            }
            final Element primeiroFilho = primeiroElementoFilho(body);
            return "Fault".equals(primeiroFilho.getLocalName()) ? new DFSoapFaultException(textoDoFault(primeiroFilho)) : null;
        } catch (final Exception e) {
            return null;
        }
    }

    /**
     * DocumentBuilderFactory endurecido contra XXE (entidades externas/DTD) - a resposta e um
     * XML vindo pela rede (o webservice da SEFAZ), entao nao deve ser tratada como confiavel
     * por padrao para fins de parsing.
     */
    private static DocumentBuilderFactory criarDocumentBuilderFactory() throws javax.xml.parsers.ParserConfigurationException {
        return DFXmlSeguro.documentBuilderFactory();
    }

    private static Element primeiroElementoFilho(final Element pai) {
        Node filho = pai.getFirstChild();
        while (filho != null && filho.getNodeType() != Node.ELEMENT_NODE) {
            filho = filho.getNextSibling();
        }
        if (filho == null) {
            throw new IllegalStateException("Elemento <" + pai.getLocalName() + "> nao tem filho");
        }
        return (Element) filho;
    }

    private static String textoDoFault(final Element fault) {
        final org.w3c.dom.NodeList textos = fault.getElementsByTagNameNS(SOAP12_NS, "Text");
        return textos.getLength() > 0 ? textos.item(0).getTextContent() : fault.getTextContent();
    }

    private static String serializar(final Element elemento) throws javax.xml.transform.TransformerException {
        final Transformer transformer = DFXmlSeguro.transformerFactory().newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        final StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(elemento), new StreamResult(writer));
        return writer.toString();
    }
}
