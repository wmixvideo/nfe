package com.fincatto.documentofiscal.cte300.webservices;

import java.rmi.RemoteException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fincatto.documentofiscal.cte300.CTeConfig;
import com.fincatto.documentofiscal.cte300.classes.CTAutorizador31;
import com.fincatto.documentofiscal.cte300.classes.enviolote.consulta.CTeConsultaRecLote;
import com.fincatto.documentofiscal.cte300.classes.enviolote.consulta.CTeConsultaRecLoteRet;
import com.fincatto.documentofiscal.cte300.webservices.retrecepcao.CteRetRecepcaoStub;
import com.fincatto.documentofiscal.cte300.webservices.retrecepcao.CteRetRecepcaoStub.CteRetRecepcaoResult;
import com.fincatto.documentofiscal.transformers.DFRegistryMatcher;

public class WSRecepcaoLoteRetorno {

	private static final Logger LOGGER = LoggerFactory.getLogger(WSRecepcaoLoteRetorno.class);
	private final CTeConfig config;
	
	WSRecepcaoLoteRetorno(final CTeConfig config){
		this.config = config;
	}
	
	CTeConsultaRecLoteRet consultaLote(final String numeroRecibo) throws Exception {
		final OMElement omElementConsulta = AXIOMUtil.stringToOM(this.gerarDadosConsulta(numeroRecibo).toString());
		WSRecepcaoLoteRetorno.LOGGER.info(omElementConsulta.toString());

		final OMElement omElementResult = this.efetuaConsulta(omElementConsulta);
		WSRecepcaoLoteRetorno.LOGGER.info(omElementResult.toString());

		return new Persister(new DFRegistryMatcher(), new Format(0)).read(CTeConsultaRecLoteRet.class, omElementResult.toString());
	}

	private OMElement efetuaConsulta(final OMElement omElement) throws RemoteException {
		
		final CteRetRecepcaoStub.CteCabecMsg cabec = new CteRetRecepcaoStub.CteCabecMsg();
		cabec.setCUF(this.config.getCUF().getCodigoIbge());
		cabec.setVersaoDados(CTeConfig.VERSAO);

		final CteRetRecepcaoStub.CteCabecMsgE cabecE = new CteRetRecepcaoStub.CteCabecMsgE();
		cabecE.setCteCabecMsg(cabec);

		final CteRetRecepcaoStub.CteDadosMsg dados = new CteRetRecepcaoStub.CteDadosMsg();
		dados.setExtraElement(omElement);

		final CTAutorizador31 autorizador = CTAutorizador31.valueOfCodigoUF(this.config.getCUF());
		final String endpoint = autorizador.getCteRetRecepcao(this.config.getAmbiente());
		if (endpoint == null) {
			throw new IllegalArgumentException("Nao foi possivel encontrar URL para RetRecepcao, autorizador " + autorizador.name() + ", UF " + this.config.getCUF().name());
		}
		WSRecepcaoLoteRetorno.LOGGER.info(endpoint);

		final CteRetRecepcaoResult autorizacaoLoteResult = new CteRetRecepcaoStub(endpoint).cteRetRecepcao(dados, cabecE);
		
		return autorizacaoLoteResult.getExtraElement();
	}

	private CTeConsultaRecLote gerarDadosConsulta(final String numeroRecibo) {
		final CTeConsultaRecLote consulta = new CTeConsultaRecLote();
		consulta.setNumeroRecebimento(numeroRecibo);
		consulta.setAmbiente(this.config.getAmbiente());
		consulta.setVersao(CTeConfig.VERSAO);
		return consulta;
	}
}
