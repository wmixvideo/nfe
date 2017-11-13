package com.fincatto.documentofiscal.mdfe3.webservices;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.mdfe3.MDFeConfig;
import com.fincatto.documentofiscal.mdfe3.classes.MDFAutorizador3;
import com.fincatto.documentofiscal.mdfe3.classes.consultastatusservico.MDFeConsStatServ;
import com.fincatto.documentofiscal.mdfe3.classes.consultastatusservico.MDFeConsStatServRet;
import com.fincatto.documentofiscal.mdfe3.webservices.statusservico.MDFeStatusServicoStub;
import com.fincatto.documentofiscal.transformers.DFRegistryMatcher;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.rmi.RemoteException;

/**
 * Created by Eldevan Nery Junior on 10/11/17.
 *
 * Classe para envio do pedido de Consulta do Status do Serviço MDF-e.
 *
 */
class WSStatusConsulta {

	private static final String NOME_SERVICO = "STATUS";
	private static final Logger LOGGER = LoggerFactory.getLogger(WSStatusConsulta.class);
	private final MDFeConfig config;

	WSStatusConsulta(final MDFeConfig config) {
		this.config = config;
	}

	MDFeConsStatServRet consultaStatus(final DFUnidadeFederativa uf) throws Exception {
		final OMElement omElementConsulta = AXIOMUtil.stringToOM(this.gerarDadosConsulta(uf).toString());
		WSStatusConsulta.LOGGER.info(omElementConsulta.toString());

		final OMElement omElementResult = this.efetuaConsultaStatus(omElementConsulta, uf);
		WSStatusConsulta.LOGGER.info(omElementResult.toString());

		return new Persister(new DFRegistryMatcher(), new Format(0)).read(MDFeConsStatServRet.class, omElementResult.toString());
	}

	private MDFeConsStatServ gerarDadosConsulta(final DFUnidadeFederativa unidadeFederativa) {
		final MDFeConsStatServ consStatServ = new MDFeConsStatServ();
		consStatServ.setAmbiente(this.config.getAmbiente());
		consStatServ.setVersao(MDFeConfig.VERSAO);
		consStatServ.setServico(WSStatusConsulta.NOME_SERVICO);
		return consStatServ;
	}

	private OMElement efetuaConsultaStatus(final OMElement omElement, final DFUnidadeFederativa unidadeFederativa) throws RemoteException {
		final MDFeStatusServicoStub.MdfeCabecMsg cabec = new MDFeStatusServicoStub.MdfeCabecMsg();
		cabec.setCUF(unidadeFederativa.getCodigoIbge());
		cabec.setVersaoDados(MDFeConfig.VERSAO);

		final MDFeStatusServicoStub.MdfeCabecMsgE cabecEnv = new MDFeStatusServicoStub.MdfeCabecMsgE();
		cabecEnv.setMdfeCabecMsg(cabec);

		final MDFeStatusServicoStub.MdfeDadosMsg dados = new MDFeStatusServicoStub.MdfeDadosMsg();
		dados.setExtraElement(omElement);

		final MDFAutorizador3 autorizador = MDFAutorizador3.valueOfCodigoUF(unidadeFederativa);
		final String endpoint = autorizador.getMDFeStatusServico(this.config.getAmbiente());
		if (endpoint == null) {
			throw new IllegalArgumentException("Nao foi possivel encontrar URL para StatusServico, autorizador " + autorizador.name() + ", UF " + unidadeFederativa.name());
		}
		WSStatusConsulta.LOGGER.info(endpoint);
		final MDFeStatusServicoStub.MdfeStatusServicoMDFResult result = new MDFeStatusServicoStub(endpoint).mdfeStatusServicoMDF(dados, cabecEnv);
		return result.getExtraElement();
	}
}
