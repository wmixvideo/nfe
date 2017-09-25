package com.fincatto.documentofiscal.cte300.webservices;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.cte300.CTeConfig;
import com.fincatto.documentofiscal.cte300.classes.CTAutorizador31;
import com.fincatto.documentofiscal.cte300.classes.consultastatusservico.CTeConsStatServ;
import com.fincatto.documentofiscal.cte300.classes.consultastatusservico.CTeConsStatServRet;
import com.fincatto.documentofiscal.cte300.webservices.statusservico.CteStatusServicoStub;
import com.fincatto.documentofiscal.transformers.DFRegistryMatcher;

import java.rmi.RemoteException;

class WSStatusConsulta {

	private static final String NOME_SERVICO = "STATUS";
	private static final Logger LOGGER = LoggerFactory.getLogger(WSStatusConsulta.class);
	private final CTeConfig config;

	WSStatusConsulta(final CTeConfig config) {
		this.config = config;
	}

	CTeConsStatServRet consultaStatus(final DFUnidadeFederativa uf) throws Exception {
		final OMElement omElementConsulta = AXIOMUtil.stringToOM(this.gerarDadosConsulta(uf).toString());
		WSStatusConsulta.LOGGER.info(omElementConsulta.toString());

		final OMElement omElementResult = this.efetuaConsultaStatus(omElementConsulta, uf);
		WSStatusConsulta.LOGGER.info(omElementResult.toString());

		return new Persister(new DFRegistryMatcher(), new Format(0)).read(CTeConsStatServRet.class, omElementResult.toString());
	}

	private CTeConsStatServ gerarDadosConsulta(final DFUnidadeFederativa unidadeFederativa) {
		final CTeConsStatServ consStatServ = new CTeConsStatServ();
		consStatServ.setAmbiente(this.config.getAmbiente());
		consStatServ.setVersao(CTeConfig.VERSAO);
		consStatServ.setServico(WSStatusConsulta.NOME_SERVICO);
		return consStatServ;
	}

	private OMElement efetuaConsultaStatus(final OMElement omElement, final DFUnidadeFederativa unidadeFederativa) throws RemoteException {
		final CteStatusServicoStub.CteCabecMsg cabec = new CteStatusServicoStub.CteCabecMsg();
		cabec.setCUF(unidadeFederativa.getCodigoIbge());
		cabec.setVersaoDados(CTeConfig.VERSAO);

		final CteStatusServicoStub.CteCabecMsgE cabecEnv = new CteStatusServicoStub.CteCabecMsgE();
		cabecEnv.setCteCabecMsg(cabec);

		final CteStatusServicoStub.CteDadosMsg dados = new CteStatusServicoStub.CteDadosMsg();
		dados.setExtraElement(omElement);

		final CTAutorizador31 autorizador = CTAutorizador31.valueOfCodigoUF(unidadeFederativa);
		final String endpoint = autorizador.getCteStatusServico(this.config.getAmbiente());
		if (endpoint == null) {
			throw new IllegalArgumentException("Nao foi possivel encontrar URL para StatusServico, autorizador " + autorizador.name() + ", UF " + unidadeFederativa.name());
		}
		WSStatusConsulta.LOGGER.info(endpoint);
		final CteStatusServicoStub.CteStatusServicoCTResult result = new CteStatusServicoStub(endpoint).cteStatusServicoCT(dados, cabecEnv);
		return result.getExtraElement();
	}
}
