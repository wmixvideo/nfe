package com.fincatto.nfe310.webservices;

import java.util.Iterator;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.log4j.Logger;
import org.simpleframework.xml.core.Persister;

import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.assinatura.AssinaturaDigital;
import com.fincatto.nfe310.classes.NFAutorizador31;
import com.fincatto.nfe310.classes.NFModelo;
import com.fincatto.nfe310.classes.lote.envio.NFLoteEnvio;
import com.fincatto.nfe310.classes.lote.envio.NFLoteEnvioRetorno;
import com.fincatto.nfe310.classes.nota.NFNota;
import com.fincatto.nfe310.classes.nota.NFNotaInfo;
import com.fincatto.nfe310.classes.nota.NFNotaInfoSuplementar;
import com.fincatto.nfe310.parsers.NotaParser;
import com.fincatto.nfe310.transformers.NFRegistryMatcher;
import com.fincatto.nfe310.utils.NFGeraChave;
import com.fincatto.nfe310.utils.NFGeraQRCode;
import com.fincatto.nfe310.webservices.gerado.NfeAutorizacaoStub;
import com.fincatto.nfe310.webservices.gerado.NfeAutorizacaoStub.NfeAutorizacaoLoteResult;
import com.fincatto.nfe310.webservices.gerado.NfeAutorizacaoStub.NfeCabecMsg;
import com.fincatto.nfe310.webservices.gerado.NfeAutorizacaoStub.NfeCabecMsgE;
import com.fincatto.nfe310.webservices.gerado.NfeAutorizacaoStub.NfeDadosMsg;

class WSLoteEnvio {

	private static final String NFE_ELEMENTO = "NFe";
	private static final Logger LOG = Logger.getLogger(WSLoteEnvio.class);
	private final NFeConfig config;

	public WSLoteEnvio(final NFeConfig config) {
		this.config = config;
	}

	public NFLoteEnvioRetorno enviaLote(final NFLoteEnvio lote, final NFModelo modelo) throws Exception {
		//se for nfe, adiciona a chave e o dv antes de assinar
		if (NFModelo.NFE.equals(modelo)) {
			for (final NFNota nota : lote.getNotas()) {
				final NFGeraChave geraChave = new NFGeraChave(nota);
				final NFNotaInfo notaInfo = nota.getInfo();
				notaInfo.setIdentificador(geraChave.getChaveAcesso());
				notaInfo.getIdentificacao().setDigitoVerificador(geraChave.getDV());
			}
		}

		//assina o lote
		final String documentoAssinado = new AssinaturaDigital(this.config).assinarDocumento(lote.toString());
		final NFLoteEnvio loteAssinado = new NotaParser().loteParaObjeto(documentoAssinado);

		//se for nfce, adiciona o qrcode apos assinar
		if (NFModelo.NFCE.equals(modelo)) {
			for (final NFNota nota : loteAssinado.getNotas()) {
				final NFGeraQRCode geraQRCode = new NFGeraQRCode(nota, this.config);
				nota.setInfoSuplementar(new NFNotaInfoSuplementar());
				nota.getInfoSuplementar().setQrCode(geraQRCode.getQRCode());
			}
		}

		//comunica o lote
		final String xml = loteAssinado.toString();
		final OMElement omElement = this.nfeToOMElement(xml);

		final NfeDadosMsg dados = new NfeDadosMsg();
		dados.setExtraElement(omElement);

		final NfeCabecMsgE cabecalhoSOAP = this.getCabecalhoSOAP();
		WSLoteEnvio.LOG.info(omElement);

		final NFAutorizador31 autorizador = NFAutorizador31.valueOfCodigoUF(this.config.getCUF());
		final String endpoint = NFModelo.NFE.equals(modelo) ? autorizador.getNfeAutorizacao(this.config.getAmbiente()) : autorizador.getNfceAutorizacao(this.config.getAmbiente());
		if (endpoint == null) {
			throw new IllegalArgumentException("Nao foi possivel encontrar URL para Autorizacao " + lote.getNotas().get(0).getInfo().getIdentificacao().getModelo().name() + ", autorizador " + autorizador.name());
		}

		final NfeAutorizacaoLoteResult autorizacaoLoteResult = new NfeAutorizacaoStub(endpoint).nfeAutorizacaoLote(dados, cabecalhoSOAP);
		final Persister persister = new Persister(new NFRegistryMatcher());
		final NFLoteEnvioRetorno loteEnvioRetorno = persister.read(NFLoteEnvioRetorno.class, autorizacaoLoteResult.getExtraElement().toString());
		WSLoteEnvio.LOG.info(loteEnvioRetorno.toString());
		return loteEnvioRetorno;
	}

	private NfeCabecMsgE getCabecalhoSOAP() {
		final NfeCabecMsg cabecalho = new NfeCabecMsg();
		cabecalho.setCUF(this.config.getCUF().getCodigoIbge());
		cabecalho.setVersaoDados(NFeConfig.VERSAO_NFE);
		final NfeCabecMsgE cabecalhoSOAP = new NfeCabecMsgE();
		cabecalhoSOAP.setNfeCabecMsg(cabecalho);
		return cabecalhoSOAP;
	}

	private OMElement nfeToOMElement(final String documento) throws XMLStreamException {
		final OMElement ome = AXIOMUtil.stringToOM(documento);
		final Iterator<?> children = ome.getChildrenWithLocalName(WSLoteEnvio.NFE_ELEMENTO);
		while (children.hasNext()) {
			final OMElement omElement = (OMElement) children.next();
			if ((omElement != null) && (WSLoteEnvio.NFE_ELEMENTO.equals(omElement.getLocalName()))) {
				omElement.addAttribute("xmlns", NFeConfig.NFE_NAMESPACE, null);
			}
		}
		return ome;
	}
}