package com.fincatto.documentofiscal.mdfe3.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.mdfe3.MDFeConfig;
import com.fincatto.documentofiscal.mdfe3.classes.MDFAutorizador3;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFe;
import com.fincatto.documentofiscal.mdfe3.classes.nota.envio.MDFEnvioRetorno;
import com.fincatto.documentofiscal.mdfe3.classes.nota.envio.MDFEnvioRetornoDados;
import com.fincatto.documentofiscal.mdfe3.webservices.recepcao.MDFeRecepcaoSincStub;
import com.fincatto.documentofiscal.mdfe3.webservices.recepcao.MDFeRecepcaoStub;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;
import java.io.ByteArrayOutputStream;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Iterator;
import java.util.zip.GZIPOutputStream;

class WSRecepcaoSinc implements DFLog {
    
    private static final String MDFE_ELEMENTO = "MDFe";
    private final MDFeConfig config;
    
    WSRecepcaoSinc(final MDFeConfig config) {
        this.config = config;
    }
    
    public MDFEnvioRetornoDados envioRecepcaoSinc(MDFe mdfeRecepcao) throws Exception {
        //assina o mdfe
        final String documentoAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(mdfeRecepcao.toString(), "infMDFe");
        final MDFe mdfeAssinado = this.config.getPersister().read(MDFe.class, documentoAssinado);
        
        //comunica o mdfe
        final MDFEnvioRetorno retorno = comunicaSinc(documentoAssinado);
        return new MDFEnvioRetornoDados(retorno, mdfeAssinado);
    }
    
    private MDFEnvioRetorno comunicaSinc(final String mdfeAssinadoXml) throws Exception {
        //devido a limitacao padrao de 5000 da jdk
        //veja em https://docs.oracle.com/javase/7/docs/api/javax/xml/XMLConstants.html#FEATURE_SECURE_PROCESSING
        System.setProperty("jdk.xml.maxOccurLimit", "10000");
        //valida o mdfe assinado, para verificar se o xsd foi satisfeito, antes de comunicar com a sefaz
        DFXMLValidador.validaMDFe(mdfeAssinadoXml);
        
        String mdfeAssinadoXmlGZip = encodeXmlToGZip(mdfeAssinadoXml);
        
        //adiciona o XML do MDFe assinado e compactado ao envelope de envio do Soap
        final MDFeRecepcaoSincStub.MdfeDadosMsg dados = new MDFeRecepcaoSincStub.MdfeDadosMsg();
        dados.setExtraElement(mdfeAssinadoXmlGZip);
        
        final MDFAutorizador3 autorizador = MDFAutorizador3.valueOfCodigoUF(this.config.getCUF());
        final String endpoint = autorizador.getMDFeRecepcaoSinc(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Recepcao do MDFe, autorizador " + autorizador.name() + ", UF " + this.config.getCUF().name());
        }
        
        final MDFeRecepcaoSincStub.MdfeRecepcaoSincResult autorizacaoResult = new MDFeRecepcaoSincStub(endpoint, config).mdfeRecepcaoSinc(dados);
        final MDFEnvioRetorno retorno = this.config.getPersister().read(MDFEnvioRetorno.class, autorizacaoResult.getExtraElement().toString());
        this.getLogger().debug(retorno.toString());
        return retorno;
    }
    
    private MDFeRecepcaoStub.MdfeCabecMsgE getCabecalhoSOAP() {
        final MDFeRecepcaoStub.MdfeCabecMsg cabecalho = new MDFeRecepcaoStub.MdfeCabecMsg();
        cabecalho.setCUF(this.config.getCUF().getCodigoIbge());
        cabecalho.setVersaoDados(MDFeConfig.VERSAO);
        final MDFeRecepcaoStub.MdfeCabecMsgE cabecalhoSOAP = new MDFeRecepcaoStub.MdfeCabecMsgE();
        cabecalhoSOAP.setMdfeCabecMsg(cabecalho);
        return cabecalhoSOAP;
    }
    
    private OMElement mdfeToOMElement(final String documento) throws XMLStreamException {
        final XMLInputFactory factory = XMLInputFactory.newInstance();
        factory.setProperty(XMLInputFactory.IS_COALESCING, false);
        XMLStreamReader reader = factory.createXMLStreamReader(new StringReader(documento));
        StAXOMBuilder builder = new StAXOMBuilder(reader);
        final OMElement ome = builder.getDocumentElement();
        final Iterator<?> children = ome.getChildrenWithLocalName(WSRecepcaoSinc.MDFE_ELEMENTO);
        while (children.hasNext()) {
            final OMElement omElement = (OMElement) children.next();
            if ((omElement != null) && (WSRecepcaoSinc.MDFE_ELEMENTO.equals(omElement.getLocalName()))) {
                omElement.addAttribute("xmlns", MDFeConfig.NAMESPACE, null);
            }
        }
        return ome;
    }
    
    private static String encodeXmlToGZip(final String stringXml) throws Exception {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
             try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream)) {
                 gzipOutputStream.write(stringXml.getBytes(StandardCharsets.UTF_8));
             }
            return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
        }
    }
}
