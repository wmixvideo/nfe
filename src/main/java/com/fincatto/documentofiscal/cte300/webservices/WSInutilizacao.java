package com.fincatto.documentofiscal.cte300.webservices;

import java.math.BigDecimal;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.assinatura.AssinaturaDigital;
import com.fincatto.documentofiscal.cte300.CTeConfig;
import com.fincatto.documentofiscal.cte300.classes.CTAutorizador31;
import com.fincatto.documentofiscal.cte300.webservices.inutilizacao.CTeInutilizacaoStub;
import com.fincatto.documentofiscal.cte300.classes.evento.inutilizacao.CTEnviaEventoInutilizacao;
//import com.fincatto.documentofiscal.cte300.classes.evento.inutilizacao.CTEventoInutilizacaoDados;
//import com.fincatto.documentofiscal.cte300.classes.evento.inutilizacao.CTERetornoEventoInutilizacao;


import com.fincatto.documentofiscal.cte300.webservices.gerado.CTeInutilizacao4Stub;
import com.fincatto.documentofiscal.cte300.webservices.gerado.CTeInutilizacao4Stub.CTeResultMsg;
import com.fincatto.documentofiscal.persister.DFPersister;

class WSInutilizacao {

    private static final String VERSAO_SERVICO = "3.00";
    private static final String NOME_SERVICO = "INUTILIZAR";
    private static final Logger LOGGER = LoggerFactory.getLogger(WSInutilizacao.class);
    private final CTeConfig config;

    WSInutilizacao(final CTeConfig config) {
        this.config = config;
    }

    CTERetornoEventoInutilizacao inutilizaNotaAssinada(final String eventoAssinadoXml, final DFModelo modelo) throws Exception {
        final OMElement omElementResult = this.efetuaInutilizacao(eventoAssinadoXml, modelo);
        return new DFPersister().read(CTERetornoEventoInutilizacao.class, omElementResult.toString());
    }

    CTRetornoEventoInutilizacao inutilizaNota(final int anoInutilizacaoNumeracao, final String cnpjEmitente, final String serie, final String numeroInicial, final String numeroFinal, final String justificativa, final DFModelo modelo) throws Exception {
        final String inutilizacaoXML = this.geraDadosInutilizacao(anoInutilizacaoNumeracao, cnpjEmitente, serie, numeroInicial, numeroFinal, justificativa, modelo).toString();
        final String inutilizacaoXMLAssinado = new AssinaturaDigital(this.config).assinarDocumento(inutilizacaoXML);
        final OMElement omElementResult = this.efetuaInutilizacao(inutilizacaoXMLAssinado, modelo);
        return new DFPersister().read(NFRetornoEventoInutilizacao.class, omElementResult.toString());
    }

    private OMElement efetuaInutilizacao(final String inutilizacaoXMLAssinado, final DFModelo modelo) throws Exception {
        final NFeInutilizacao4Stub.NfeDadosMsg dados = new NFeInutilizacao4Stub.NfeDadosMsg();
        final OMElement omElement = AXIOMUtil.stringToOM(inutilizacaoXMLAssinado);
        WSInutilizacao.LOGGER.debug(omElement.toString());
        dados.setExtraElement(omElement);

        final CTAutorizador31 autorizador = CTAutorizador31.valueOfCodigoUF(this.config.getCUF());
        final String urlWebService = DFModelo.CTE.equals(modelo) ? autorizador.getCteInutilizacao(this.config.getAmbiente()) : autorizador.getNfceInutilizacao(this.config.getAmbiente());
        final CTeResultMsg nf4Result = new CTeInutilizacaoStub(urlWebService).cteInutilizacaoCT(dados);
        final OMElement dadosRetorno = nf4Result.getExtraElement();
        WSInutilizacao.LOGGER.debug(dadosRetorno.toString());
        return dadosRetorno;
    }

    private CTEnviaEventoInutilizacao geraDadosInutilizacao(final int anoInutilizacaoNumeracao, final String cnpjEmitente, final String serie, final String numeroInicial, final String numeroFinal, final String justificativa, final DFModelo modelo) {
        final CTEnviaEventoInutilizacao inutilizacao = new CTEnviaEventoInutilizacao();
        final CTEventoInutilizacaoDados dados = new CTEventoInutilizacaoDados();
        dados.setAmbiente(this.config.getAmbiente());
        dados.setAno(anoInutilizacaoNumeracao);
        dados.setCnpj(cnpjEmitente);
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
        dados.setIdentificador("ID" + this.config.getCUF().getCodigoIbge() + String.valueOf(anoInutilizacaoNumeracao) + cnpjEmitente + modelo.getCodigo() + serieTamanhoMaximo + numeroInicialTamanhoMaximo + numeroFinalTamanhoMaximo);
        inutilizacao.setVersao(new BigDecimal(WSInutilizacao.VERSAO_SERVICO));
        inutilizacao.setDados(dados);
        return inutilizacao;
    }
}
