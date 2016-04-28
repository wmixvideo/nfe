package com.fincatto.nfe310.webservices;

import java.math.BigDecimal;
import java.rmi.RemoteException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.axis2.AxisFault;
import org.apache.log4j.Logger;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.classes.NFAutorizador31;
import com.fincatto.nfe310.classes.NFModelo;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;
import com.fincatto.nfe310.classes.lote.consulta.NFLoteConsulta;
import com.fincatto.nfe310.classes.lote.consulta.NFLoteConsultaRetorno;
import com.fincatto.nfe310.transformers.NFRegistryMatcher;
import com.fincatto.nfe310.webservices.gerado.NfeRetAutorizacaoStub;
import com.fincatto.nfe310.webservices.gerado.NfeRetAutorizacaoStub.NfeRetAutorizacaoLoteResult;

class WSLoteConsulta {

	final private static Logger LOG = Logger.getLogger(WSLoteConsulta.class);
	private final NFeConfig config;

	public WSLoteConsulta(final NFeConfig config) {
		this.config = config;
	}

	public NFLoteConsultaRetorno consultaLote(final String numeroRecibo, final NFModelo modelo) throws Exception {
		final OMElement omElementConsulta = AXIOMUtil.stringToOM(this.gerarDadosConsulta(numeroRecibo).toString());
		WSLoteConsulta.LOG.info(omElementConsulta);

		final OMElement omElementResult = this.efetuaConsulta(omElementConsulta, this.config.getCUF(), modelo);
		WSLoteConsulta.LOG.info(omElementResult);

		return new Persister(new NFRegistryMatcher(), new Format(0)).read(NFLoteConsultaRetorno.class, omElementResult.toString());
	}

	private OMElement efetuaConsulta(final OMElement omElement, final NFUnidadeFederativa uf, final NFModelo modelo) throws AxisFault, RemoteException {
		final NfeRetAutorizacaoStub.NfeCabecMsg cabec = new NfeRetAutorizacaoStub.NfeCabecMsg();
		cabec.setCUF(uf.getCodigoIbge());
		cabec.setVersaoDados(NFeConfig.VERSAO_NFE);

		final NfeRetAutorizacaoStub.NfeCabecMsgE cabecE = new NfeRetAutorizacaoStub.NfeCabecMsgE();
		cabecE.setNfeCabecMsg(cabec);

		final NfeRetAutorizacaoStub.NfeDadosMsg dados = new NfeRetAutorizacaoStub.NfeDadosMsg();
		dados.setExtraElement(omElement);

		final NFAutorizador31 autorizador = NFAutorizador31.valueOfCodigoUF(uf);
		final String urlWebService = NFModelo.NFCE.equals(modelo) ? autorizador.getNfceRetAutorizacao(this.config.getAmbiente()) : autorizador.getNfeRetAutorizacao(this.config.getAmbiente());
		if (urlWebService == null) {
			throw new IllegalArgumentException("Nao foi possivel encontrar URL para RetAutorizacao " + modelo.name() + ", autorizador " + autorizador.name());
		}

		final NfeRetAutorizacaoLoteResult autorizacaoLoteResult = new NfeRetAutorizacaoStub(urlWebService).nfeRetAutorizacaoLote(dados, cabecE);
		return autorizacaoLoteResult.getExtraElement();
	}

	private NFLoteConsulta gerarDadosConsulta(final String numeroRecibo) {
		final NFLoteConsulta consulta = new NFLoteConsulta();
		consulta.setRecibo(numeroRecibo);
		consulta.setAmbiente(this.config.getAmbiente());
		consulta.setVersao(new BigDecimal(NFeConfig.VERSAO_NFE));
		return consulta;
	}
}