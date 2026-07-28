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
 * Monta e desempacota o envelope SOAP 1.2 no mesmo formato que os stubs gerados pelo Axis2
 * (via WSDL2Java) produziam para os webservices da SEFAZ: um unico elemento "wrapper"
 * (ex.: {@code nfeDadosMsg}/{@code nfeResultMsg}) dentro de {@code soap:Body}, contendo o
 * XML de negocio (ja serializado pelo Simple XML Framework) como filho direto.
 * <p>
 * Substitui a montagem via {@code Axiom}/{@code ADBBean} por concatenacao de texto na ida
 * (o XML de negocio ja chega pronto como {@code String}) e parsing DOM na volta.
 * @author Marcos Lombardi de Andrade
 */
public final class DFSoapEnvelope {

    private static final String SOAP12_NS = "http://www.w3.org/2003/05/soap-envelope";

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
                + "<" + wrapperElemento + " xmlns=\"" + wrapperNamespace + "\">" + xmlNegocio + "</" + wrapperElemento + ">"
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
        try {
            final Document documento = criarDocumentBuilderFactory().newDocumentBuilder().parse(new InputSource(new StringReader(respostaXml)));

            final Element body = (Element) documento.getElementsByTagNameNS(SOAP12_NS, "Body").item(0);
            final Element primeiroFilho = primeiroElementoFilho(body);

            if ("Fault".equals(primeiroFilho.getLocalName())) {
                throw new DFSoapFaultException(textoDoFault(primeiroFilho));
            }

            // primeiroFilho = elemento wrapper (ex.: nfeResultMsg); o filho dele e o XML de negocio
            return serializar(primeiroElementoFilho(primeiroFilho));
        } catch (final DFSoapFaultException e) {
            throw e;
        } catch (final Exception e) {
            throw new IllegalStateException("Resposta da SEFAZ nao e um envelope SOAP 1.2 valido", e);
        }
    }

    /**
     * DocumentBuilderFactory endurecido contra XXE (entidades externas/DTD) - a resposta e um
     * XML vindo pela rede (o webservice da SEFAZ), entao nao deve ser tratada como confiavel
     * por padrao para fins de parsing.
     */
    private static DocumentBuilderFactory criarDocumentBuilderFactory() throws javax.xml.parsers.ParserConfigurationException {
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        factory.setXIncludeAware(false);
        factory.setExpandEntityReferences(false);
        return factory;
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

    private static String serializar(final Element elemento) throws Exception {
        final TransformerFactory transformerFactory = TransformerFactory.newInstance();
        // Hardening extra contra XXE (defesa em profundidade - o elemento aqui ja vem de um DOM
        // parseado com o DocumentBuilderFactory endurecido em criarDocumentBuilderFactory(), entao
        // nao ha DTD/stylesheet externo a resolver neste transform). Alguns providers JAXP alternativos
        // (ex.: o Xalan empacotado pelo WildFly/JBoss, diferente do Xalan interno do JDK) nao suportam
        // esses atributos e lancam IllegalArgumentException - nesse caso, seguimos sem eles.
        try {
            transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
        } catch (final IllegalArgumentException e) {
            // provider JAXP nao suporta o atributo - segue com o comportamento padrao dele
        }
        final Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        final StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(elemento), new StreamResult(writer));
        return writer.toString();
    }
}
