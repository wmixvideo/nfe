package com.fincatto.documentofiscal.nfe400.webservices;

import java.math.BigDecimal;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.commons.lang3.StringUtils;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.NFAutorizador400;
import com.fincatto.documentofiscal.nfe400.classes.evento.inutilizacao.NFEnviaEventoInutilizacao;
import com.fincatto.documentofiscal.nfe400.classes.evento.inutilizacao.NFEventoInutilizacaoDados;
import com.fincatto.documentofiscal.nfe400.classes.evento.inutilizacao.NFRetornoEventoInutilizacao;
import com.fincatto.documentofiscal.nfe400.webservices.gerado.NFeInutilizacao4Stub;
import com.fincatto.documentofiscal.nfe400.webservices.gerado.NFeInutilizacao4Stub.NfeResultMsg;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;

class WSInutilizacao implements DFLog {

	private static final String VERSAO_SERVICO = "4.00";
	private static final String NOME_SERVICO = "INUTILIZAR";
	private final NFeConfig config;

	WSInutilizacao(final NFeConfig config) {
		this.config = config;
	}

	NFRetornoEventoInutilizacao inutilizaNotaAssinada(final String eventoAssinadoXml, final DFModelo modelo)
			throws Exception {
		final OMElement omElementResult = this.efetuaInutilizacao(eventoAssinadoXml, modelo);
		return this.config.getPersister().read(NFRetornoEventoInutilizacao.class, omElementResult.toString());
	}

	NFRetornoEventoInutilizacao inutilizaNota(final int anoInutilizacaoNumeracao, final String cnpjEmitente,
			final String serie, final String numeroInicial, final String numeroFinal, final String justificativa,
			final DFModelo modelo) throws Exception {
		final String inutilizacaoXML = this.geraDadosInutilizacao(anoInutilizacaoNumeracao, cnpjEmitente, serie,
				numeroInicial, numeroFinal, justificativa, modelo).toString();
		final String inutilizacaoXMLAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(inutilizacaoXML);
		final OMElement omElementResult = this.efetuaInutilizacao(inutilizacaoXMLAssinado, modelo);
		return this.config.getPersister().read(NFRetornoEventoInutilizacao.class, omElementResult.toString());
	}

	private OMElement efetuaInutilizacao(final String inutilizacaoXMLAssinado, final DFModelo modelo) throws Exception {
		final NFeInutilizacao4Stub.NfeDadosMsg dados = new NFeInutilizacao4Stub.NfeDadosMsg();
		final OMElement omElement = AXIOMUtil.stringToOM(inutilizacaoXMLAssinado);
		this.getLogger().debug(omElement.toString());
		dados.setExtraElement(omElement);

		final NFAutorizador400 autorizador = NFAutorizador400.valueOfCodigoUF(this.config.getCUF());
		final String urlWebService = DFModelo.NFE.equals(modelo)
				? autorizador.getNfeInutilizacao(this.config.getAmbiente())
				: autorizador.getNfceInutilizacao(this.config.getAmbiente());
		final NfeResultMsg nf4Result = new NFeInutilizacao4Stub(urlWebService, config).nfeInutilizacaoNF(dados);
		final OMElement dadosRetorno = nf4Result.getExtraElement();
		this.getLogger().debug(dadosRetorno.toString());
		return dadosRetorno;
	}

	private NFEnviaEventoInutilizacao geraDadosInutilizacao(final int anoInutilizacaoNumeracao, final String cpfOuCnpj,
			final String serie, final String numeroInicial, final String numeroFinal, final String justificativa,
			final DFModelo modelo) {
		final NFEnviaEventoInutilizacao inutilizacao = new NFEnviaEventoInutilizacao();
		final NFEventoInutilizacaoDados dados = new NFEventoInutilizacaoDados();
		dados.setAmbiente(this.config.getAmbiente());
		dados.setAno(anoInutilizacaoNumeracao);

		if (cpfOuCnpj.length() == 11) {
			dados.setCpf(cpfOuCnpj);
		} else {
			dados.setCnpj(cpfOuCnpj);
		}

		dados.setJustificativa(justificativa);
		dados.setModeloDocumentoFiscal(modelo.getCodigo());
		dados.setNomeServico(WSInutilizacao.NOME_SERVICO);
		dados.setNumeroNFInicial(numeroInicial);
		dados.setNumeroNFFinal(numeroFinal);
		dados.setSerie(serie);
		dados.setUf(this.config.getCUF());
		final String numeroInicialTamanhoMaximo = StringUtils.leftPad(numeroInicial, 9, "0");
		final String numeroFinalTamanhoMaximo = StringUtils.leftPad(numeroFinal, 9, "0");
		final String serieTamanhoMaximo = StringUtils.leftPad(serie, 3, "0");
		final String docCpfOuCnpj = StringUtils.leftPad(cpfOuCnpj, 14, "0");
		dados.setIdentificador("ID" + this.config.getCUF().getCodigoIbge() + anoInutilizacaoNumeracao + docCpfOuCnpj
				+ modelo.getCodigo() + serieTamanhoMaximo + numeroInicialTamanhoMaximo + numeroFinalTamanhoMaximo);
		inutilizacao.setVersao(new BigDecimal(WSInutilizacao.VERSAO_SERVICO));
		inutilizacao.setDados(dados);
		return inutilizacao;
	}
}
