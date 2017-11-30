package com.fincatto.documentofiscal.mdfe3.webservices;

import com.fincatto.documentofiscal.mdfe3.MDFeConfig;
import com.fincatto.documentofiscal.mdfe3.classes.MDFAutorizador3;
import com.fincatto.documentofiscal.mdfe3.classes.consultanaoencerrados.MDFeConsultaNaoEncerrados;
import com.fincatto.documentofiscal.mdfe3.classes.consultanaoencerrados.MDFeConsultaNaoEncerradosRetorno;
import com.fincatto.documentofiscal.mdfe3.webservices.consultanaoencerrado.MDFeConsNaoEncStub;
import com.fincatto.documentofiscal.transformers.DFRegistryMatcher;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.rmi.RemoteException;

/**
 * Created by Eldevan Nery Junior on 22/11/17.
 *
 * Classe para envio do pedido de Consulta  do Serviço de  MDF-e's não encerrados.
 *
 */
class WSConsultaNaoEncerrados {

	private static final String NOME_SERVICO = "CONSULTAR NÃO ENCERRADOS";
	private static final Logger LOGGER = LoggerFactory.getLogger(WSConsultaNaoEncerrados.class);
	private final MDFeConfig config;

	WSConsultaNaoEncerrados(final MDFeConfig config) {
		this.config = config;
	}

	MDFeConsultaNaoEncerradosRetorno consultaNaoEncerrados(final String cnpj) throws Exception {
		final OMElement omElementConsulta = AXIOMUtil.stringToOM(this.gerarDadosConsulta(cnpj).toString());
		WSConsultaNaoEncerrados.LOGGER.info(omElementConsulta.toString());

		final OMElement omElementResult = this.efetuaConsultaStatus(omElementConsulta);
		WSConsultaNaoEncerrados.LOGGER.info(omElementResult.toString());

		return new Persister(new DFRegistryMatcher(), new Format(0)).read(MDFeConsultaNaoEncerradosRetorno.class, omElementResult.toString());
	}

	private MDFeConsultaNaoEncerrados gerarDadosConsulta(final String cnpj) {
		final MDFeConsultaNaoEncerrados encerrados = new MDFeConsultaNaoEncerrados();
		encerrados.setAmbiente(this.config.getAmbiente());
		encerrados.setVersao(MDFeConfig.VERSAO);
		encerrados.setCnpj(cnpj);
		encerrados.setServico(WSConsultaNaoEncerrados.NOME_SERVICO);
		return encerrados;
	}

	private OMElement efetuaConsultaStatus(final OMElement omElement) throws RemoteException {
		final MDFeConsNaoEncStub.MdfeCabecMsg cabec = new MDFeConsNaoEncStub.MdfeCabecMsg();
		cabec.setCUF(this.config.getCUF().getCodigoIbge());
		cabec.setVersaoDados(MDFeConfig.VERSAO);

		final MDFeConsNaoEncStub.MdfeCabecMsgE cabecEnv = new MDFeConsNaoEncStub.MdfeCabecMsgE();
		cabecEnv.setMdfeCabecMsg(cabec);

		final MDFeConsNaoEncStub.MdfeDadosMsg dados = new MDFeConsNaoEncStub.MdfeDadosMsg();
		dados.setExtraElement(omElement);

		final MDFAutorizador3 autorizador = MDFAutorizador3.valueOfCodigoUF(this.config.getCUF());
		final String endpoint = autorizador.getMDFeConsNaoEnc(this.config.getAmbiente());
		if (endpoint == null) {
			throw new IllegalArgumentException("Nao foi possivel encontrar URL para CONSULTAR NÃO ENCERRADOS, autorizador " + autorizador.name() + ", UF " + this.config.getCUF().name());
		}
		WSConsultaNaoEncerrados.LOGGER.info(endpoint);
		final MDFeConsNaoEncStub.MdfeConsNaoEncResult result = new MDFeConsNaoEncStub(endpoint).mdfeConsNaoEnc(dados, cabecEnv);
		return result.getExtraElement();
	}
}
