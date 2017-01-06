package com.fincatto.cte200.webservices;

import java.rmi.RemoteException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fincatto.cte200.CTeConfig;
import com.fincatto.cte200.classes.CTAutorizador;
import com.fincatto.cte200.classes.statusservico.consulta.CTStatusServicoConsulta;
import com.fincatto.cte200.classes.statusservico.consulta.CTStatusServicoConsultaRetorno;
import com.fincatto.cte200.transformers.CTRegistryMatcher;
import com.fincatto.cte200.webservices2.statusservico.consulta.CteStatusServicoStub;
import com.fincatto.dfe.classes.DFUnidadeFederativa;
import com.fincatto.dfe.classes.DFModelo;

class WSStatusConsulta {

	private static final String NOME_SERVICO = "STATUS";
	private static final Logger LOGGER = LoggerFactory.getLogger(WSStatusConsulta.class);
	private final CTeConfig config;

	WSStatusConsulta(final CTeConfig config) {
		this.config = config;
	}

	CTStatusServicoConsultaRetorno consultaStatus(final DFUnidadeFederativa uf, final DFModelo modelo) throws Exception {
		final OMElement omElementConsulta = AXIOMUtil.stringToOM(this.gerarDadosConsulta().toString());
		WSStatusConsulta.LOGGER.debug(omElementConsulta.toString());

		final OMElement omElementResult = this.efetuaConsultaStatus(omElementConsulta, uf, modelo);
		WSStatusConsulta.LOGGER.debug(omElementResult.toString());

		return new Persister(new CTRegistryMatcher(), new Format(0)).read(CTStatusServicoConsultaRetorno.class, omElementResult.toString());
	}

	private CTStatusServicoConsulta gerarDadosConsulta() {
		final CTStatusServicoConsulta consStatServ = new CTStatusServicoConsulta();
		consStatServ.setAmbiente(this.config.getAmbiente());
		consStatServ.setVersao(CTeConfig.VERSAO_CTE);
		consStatServ.setServico(WSStatusConsulta.NOME_SERVICO);
		return consStatServ;
	}

	private OMElement efetuaConsultaStatus(final OMElement omElement, final DFUnidadeFederativa unidadeFederativa, final DFModelo modelo) throws RemoteException {
		final CteStatusServicoStub.CteCabecMsg cabec = new CteStatusServicoStub.CteCabecMsg();
		cabec.setCUF(unidadeFederativa.getCodigoIbge());
		cabec.setVersaoDados(CTeConfig.VERSAO_CTE);

		final CteStatusServicoStub.CteCabecMsgE cabecEnv = new CteStatusServicoStub.CteCabecMsgE();
		cabecEnv.setCteCabecMsg(cabec);

		final CteStatusServicoStub.CteDadosMsg dados = new CteStatusServicoStub.CteDadosMsg();
		dados.setExtraElement(omElement);

		final CTAutorizador autorizador = CTAutorizador.valueOfCodigoUF(unidadeFederativa);
		final String endpoint = autorizador.getCteStatusServico(this.config.getAmbiente());
		if (endpoint == null) {
			throw new IllegalArgumentException("Nao foi possivel encontrar URL para StatusServico " + modelo.name() + ", autorizador " + autorizador.name() + ", UF " + unidadeFederativa.name());
		}

		final CteStatusServicoStub.CteStatusServicoCT2Result result = new CteStatusServicoStub(endpoint).cteStatusServicoCT2(dados, cabecEnv);
		return result.getExtraElement();
	}
}