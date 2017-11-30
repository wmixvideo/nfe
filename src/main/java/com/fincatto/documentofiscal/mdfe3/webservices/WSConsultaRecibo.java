package com.fincatto.documentofiscal.mdfe3.webservices;

import com.fincatto.documentofiscal.mdfe3.MDFeConfig;
import com.fincatto.documentofiscal.mdfe3.classes.MDFAutorizador3;
import com.fincatto.documentofiscal.mdfe3.classes.consultaRecibo.MDFeConsultaRecibo;
import com.fincatto.documentofiscal.mdfe3.classes.consultaRecibo.MDFeConsultaReciboRetorno;
import com.fincatto.documentofiscal.mdfe3.webservices.retornorecepcao.MDFeRetRecepcaoStub;
import com.fincatto.documentofiscal.transformers.DFRegistryMatcher;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.rmi.RemoteException;

/**
 * Created by Eldevan Nery Junior on 30/11/17.
 *
 * Classe para envio do pedido de Consulta do recibo MDF-e.
 *
 */
class WSConsultaRecibo {

	private static final Logger LOGGER = LoggerFactory.getLogger(WSConsultaRecibo.class);
	private final MDFeConfig config;

	WSConsultaRecibo(final MDFeConfig config) {
		this.config = config;
	}

	MDFeConsultaReciboRetorno consultaRecibo(final String numeroRecibo) throws Exception {
		final OMElement omElementConsulta = AXIOMUtil.stringToOM(this.gerarDadosConsulta(numeroRecibo).toString());
		WSConsultaRecibo.LOGGER.info(omElementConsulta.toString());

		final OMElement omElementResult = this.efetuaConsultaRecibo(omElementConsulta);
		WSConsultaRecibo.LOGGER.info(omElementResult.toString());

		return new Persister(new DFRegistryMatcher(), new Format(0)).read(MDFeConsultaReciboRetorno.class, omElementResult.toString());
	}

	private MDFeConsultaRecibo gerarDadosConsulta(final String numeroRecibo) {
		final MDFeConsultaRecibo consultaRecibo = new MDFeConsultaRecibo();
		consultaRecibo.setNumeroRecibo(numeroRecibo);
		consultaRecibo.setAmbiente(this.config.getAmbiente());
		consultaRecibo.setVersao(MDFeConfig.VERSAO);
		return consultaRecibo;
	}

	private OMElement efetuaConsultaRecibo(final OMElement omElement) throws RemoteException {
		final MDFeRetRecepcaoStub.MdfeCabecMsg cabec = new MDFeRetRecepcaoStub.MdfeCabecMsg();
		cabec.setCUF(this.config.getCUF().getCodigoIbge());
		cabec.setVersaoDados(MDFeConfig.VERSAO);

		final MDFeRetRecepcaoStub.MdfeCabecMsgE cabecEnv = new MDFeRetRecepcaoStub.MdfeCabecMsgE();
		cabecEnv.setMdfeCabecMsg(cabec);

		final MDFeRetRecepcaoStub.MdfeDadosMsg dados = new MDFeRetRecepcaoStub.MdfeDadosMsg();
		dados.setExtraElement(omElement);

		final MDFAutorizador3 autorizador = MDFAutorizador3.valueOfCodigoUF(this.config.getCUF());
		final String endpoint = autorizador.getMDFeRetornoRecepcao(this.config.getAmbiente());
		if (endpoint == null) {
			throw new IllegalArgumentException("Nao foi possivel encontrar URL para Consulta Recibo, autorizador " + autorizador.name() + ", UF " + this.config.getCUF().name());
		}
		WSConsultaRecibo.LOGGER.info(endpoint);
		final MDFeRetRecepcaoStub.MdfeRetRecepcaoResult result = new MDFeRetRecepcaoStub(endpoint).mdfeRetRecepcao(dados, cabecEnv);
		return result.getExtraElement();
	}
}
