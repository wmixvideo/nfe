//package com.fincatto.documentofiscal.mdfe3.webservices;
//
//import com.fincatto.documentofiscal.assinatura.AssinaturaDigital;
//import com.fincatto.documentofiscal.mdfe3.classes.lote.envio.MDFLoteEnvio;
//import com.fincatto.documentofiscal.mdfe300.MDFeConfig;
//import com.fincatto.documentofiscal.mdfe300.classes.CTAutorizador31;
//import com.fincatto.documentofiscal.mdfe300.classes.enviolote.MDFLoteEnvio;
//import com.fincatto.documentofiscal.mdfe300.classes.enviolote.MDFeEnvioLoteRetorno;
//import com.fincatto.documentofiscal.mdfe300.classes.enviolote.MDFeEnvioLoteRetornoDados;
//import com.fincatto.documentofiscal.mdfe300.webservices.recepcao.MDFeRecepcaoStub;
//import com.fincatto.documentofiscal.mdfe300.webservices.recepcao.MDFeRecepcaoStub.MDFeCabecMsg;
//import com.fincatto.documentofiscal.mdfe300.webservices.recepcao.MDFeRecepcaoStub.MDFeCabecMsgE;
//import com.fincatto.documentofiscal.mdfe300.webservices.recepcao.MDFeRecepcaoStub.MDFeDadosMsg;
//import com.fincatto.documentofiscal.mdfe300.webservices.recepcao.MDFeRecepcaoStub.MDFeRecepcaoLoteResult;
//import com.fincatto.documentofiscal.mdfe3.MDFeConfig;
//import com.fincatto.documentofiscal.parsers.DFParser;
//import com.fincatto.documentofiscal.persister.DFPersister;
//import com.fincatto.documentofiscal.validadores.xsd.XMLValidador;
//import org.apache.axiom.om.OMElement;
//import org.apache.axiom.om.impl.builder.StAXOMBuilder;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.xml.stream.XMLInputFactory;
//import javax.xml.stream.XMLStreamException;
//import javax.xml.stream.XMLStreamReader;
//import java.io.StringReader;
//import java.util.Iterator;
//
//class WSRecepcaoLote {
//
//	private static final String MDFE_ELEMENTO = "MDFe";
//	private static final Logger LOGGER = LoggerFactory.getLogger(WSRecepcaoLote.class);
//	private final MDFeConfig config;
//
//	WSRecepcaoLote(final MDFeConfig config){
//		this.config = config;
//	}
//
//	public MDFeEnvioLoteRetornoDados envioRecepcao(MDFLoteEnvio mdfeRecepcaoLote) throws Exception {
//		//assina o lote
//		final String documentoAssinado = new AssinaturaDigital(this.config).assinarDocumento(mdfeRecepcaoLote.toString(), "infMDFe");
//		final MDFLoteEnvio loteAssinado = new DFParser().mdfeRecepcaoParaObjeto(documentoAssinado);
//
//		//comunica o lote
//		final MDFeEnvioLoteRetorno retorno = comunicaLote(documentoAssinado);
//		return new MDFeEnvioLoteRetornoDados(retorno, loteAssinado);
//	}
//
//	private MDFeEnvioLoteRetorno comunicaLote(final String loteAssinadoXml) throws Exception {
//		//valida o lote assinado, para verificar se o xsd foi satisfeito, antes de comunicar com a sefaz
//		XMLValidador.validaLoteMDFe(loteAssinadoXml);
//
//		//envia o lote para a sefaz
//		final OMElement omElement = this.mdfeToOMElement(loteAssinadoXml);
//
//        final MDFeDadosMsg dados = new MDFeDadosMsg();
//        dados.setExtraElement(omElement);
//
//        final MDFeCabecMsgE cabecalhoSOAP = this.getCabecalhoSOAP();
//        WSRecepcaoLote.LOGGER.info(omElement.toString());
//
//		final CTAutorizador31 autorizador = CTAutorizador31.valueOfTipoEmissao(this.config.getTipoEmissao(), this.config.getCUF());
//		final String endpoint = autorizador.getMDFeRecepcao(this.config.getAmbiente());
//		if (endpoint == null) {
//			throw new IllegalArgumentException("Nao foi possivel encontrar URL para Recepcao, autorizador " + autorizador.name() + ", UF " + this.config.getCUF().name());
//		}
//		WSRecepcaoLote.LOGGER.info(endpoint);
//		final MDFeRecepcaoLoteResult autorizacaoLoteResult = new MDFeRecepcaoStub(endpoint).mdfeRecepcaoLote(dados, cabecalhoSOAP);
//		final MDFeEnvioLoteRetorno retorno = new DFPersister().read(MDFeEnvioLoteRetorno.class,
//                autorizacaoLoteResult.getExtraElement().toString());
//		WSRecepcaoLote.LOGGER.info(retorno.toString());
//		return retorno;
//	}
//
//    private MDFeCabecMsgE getCabecalhoSOAP() {
//        final MDFeCabecMsg cabecalho = new MDFeCabecMsg();
//        cabecalho.setCUF(this.config.getCUF().getCodigoIbge());
//        cabecalho.setVersaoDados(MDFeConfig.VERSAO);
//        final MDFeCabecMsgE cabecalhoSOAP = new MDFeCabecMsgE();
//        cabecalhoSOAP.setMDFeCabecMsg(cabecalho);
//        return cabecalhoSOAP;
//    }
//
//	private OMElement mdfeToOMElement(final String documento) throws XMLStreamException {
//        final XMLInputFactory factory = XMLInputFactory.newInstance();
//        factory.setProperty(XMLInputFactory.IS_COALESCING, false);
//        XMLStreamReader reader = factory.createXMLStreamReader(new StringReader(documento));
//        StAXOMBuilder builder = new StAXOMBuilder(reader);
//        final OMElement ome = builder.getDocumentElement();
//        final Iterator<?> children = ome.getChildrenWithLocalName(WSRecepcaoLote.MDFE_ELEMENTO);
//        while (children.hasNext()) {
//            final OMElement omElement = (OMElement) children.next();
//            if ((omElement != null) && (WSRecepcaoLote.MDFE_ELEMENTO.equals(omElement.getLocalName()))) {
//                omElement.addAttribute("xmlns", MDFeConfig.NAMESPACE, null);
//            }
//        }
//        return ome;
//	}
//}
