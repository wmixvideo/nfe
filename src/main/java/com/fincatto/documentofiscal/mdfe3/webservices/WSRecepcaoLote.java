package com.fincatto.documentofiscal.mdfe3.webservices;

import com.fincatto.documentofiscal.assinatura.AssinaturaDigital;
import com.fincatto.documentofiscal.mdfe3.classes.MDFAutorizador3;
import com.fincatto.documentofiscal.mdfe3.classes.lote.envio.MDFEnvioLote;
import com.fincatto.documentofiscal.mdfe3.classes.lote.envio.MDFEnvioLoteRetorno;
import com.fincatto.documentofiscal.mdfe3.classes.lote.envio.MDFEnvioLoteRetornoDados;
import com.fincatto.documentofiscal.mdfe3.webservices.recepcao.MDFeRecepcaoStub;
import com.fincatto.documentofiscal.mdfe3.MDFeConfig;
import com.fincatto.documentofiscal.mdfe3.classes.parsers.MDFeParser;
import com.fincatto.documentofiscal.persister.DFPersister;
import com.fincatto.documentofiscal.validadores.xsd.XMLValidador;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.StringReader;
import java.util.Iterator;

class WSRecepcaoLote {

	private static final String MDFE_ELEMENTO = "MDFe";
	private static final Logger LOGGER = LoggerFactory.getLogger(WSRecepcaoLote.class);
	private final MDFeConfig config;

	WSRecepcaoLote(final MDFeConfig config){
		this.config = config;
	}

	public MDFEnvioLoteRetornoDados envioRecepcao(MDFEnvioLote mdfeRecepcaoLote) throws Exception {
		//assina o lote
		final String documentoAssinado = new AssinaturaDigital(this.config).assinarDocumento(mdfeRecepcaoLote.toString(), "infMDFe");
		final MDFEnvioLote loteAssinado = new MDFeParser().mdfeRecepcaoParaObjeto(documentoAssinado);

		//comunica o lote
		final MDFEnvioLoteRetorno retorno = comunicaLote(documentoAssinado);
		return new MDFEnvioLoteRetornoDados(retorno, loteAssinado);
	}

	private MDFEnvioLoteRetorno comunicaLote(final String loteAssinadoXml) throws Exception {
	    //devido a limitação padrao de 5000 da jdk
        //veja em https://docs.oracle.com/javase/7/docs/api/javax/xml/XMLConstants.html#FEATURE_SECURE_PROCESSING
        System.setProperty("jdk.xml.maxOccurLimit", "10000");
        //valida o lote assinado, para verificar se o xsd foi satisfeito, antes de comunicar com a sefaz
		XMLValidador.validaLoteMDFe(loteAssinadoXml);

		//envia o lote para a sefaz
		final OMElement omElement = this.mdfeToOMElement(loteAssinadoXml);

        final MDFeRecepcaoStub.MdfeDadosMsg dados = new MDFeRecepcaoStub.MdfeDadosMsg();
        dados.setExtraElement(omElement);

        final MDFeRecepcaoStub.MdfeCabecMsgE cabecalhoSOAP = this.getCabecalhoSOAP();
        WSRecepcaoLote.LOGGER.info(omElement.toString());

		final MDFAutorizador3 autorizador = MDFAutorizador3.valueOfCodigoUF(this.config.getCUF());
		final String endpoint = autorizador.getMDFeRecepcao(this.config.getAmbiente());
		if (endpoint == null) {
			throw new IllegalArgumentException("Nao foi possivel encontrar URL para Recepcao do MDFe, autorizador " + autorizador.name() + ", UF " + this.config.getCUF().name());
		}
		WSRecepcaoLote.LOGGER.info(endpoint);
		final MDFeRecepcaoStub.MdfeRecepcaoLoteResult autorizacaoLoteResult = new MDFeRecepcaoStub(endpoint).mdfeRecepcaoLote(dados, cabecalhoSOAP);
		final MDFEnvioLoteRetorno retorno = new DFPersister().read(MDFEnvioLoteRetorno.class,
                autorizacaoLoteResult.getExtraElement().toString());
		WSRecepcaoLote.LOGGER.info(retorno.toString());
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
        final Iterator<?> children = ome.getChildrenWithLocalName(WSRecepcaoLote.MDFE_ELEMENTO);
        while (children.hasNext()) {
            final OMElement omElement = (OMElement) children.next();
            if ((omElement != null) && (WSRecepcaoLote.MDFE_ELEMENTO.equals(omElement.getLocalName()))) {
                omElement.addAttribute("xmlns", MDFeConfig.NAMESPACE, null);
            }
        }
        return ome;
	}
}
