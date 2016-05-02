package com.fincatto.nfe310.webservices;

import java.math.BigDecimal;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.assinatura.AssinaturaDigital;
import com.fincatto.nfe310.classes.NFAutorizador31;
import com.fincatto.nfe310.classes.evento.inutilizacao.NFEnviaEventoInutilizacao;
import com.fincatto.nfe310.classes.evento.inutilizacao.NFEventoCancelamentoDados;
import com.fincatto.nfe310.classes.evento.inutilizacao.NFRetornoEventoInutilizacao;
import com.fincatto.nfe310.persister.NFPersister;
import com.fincatto.nfe310.webservices.gerado.NfeInutilizacao2Stub;
import com.fincatto.nfe310.webservices.gerado.NfeInutilizacao2Stub.NfeCabecMsg;
import com.fincatto.nfe310.webservices.gerado.NfeInutilizacao2Stub.NfeCabecMsgE;
import com.fincatto.nfe310.webservices.gerado.NfeInutilizacao2Stub.NfeDadosMsg;
import com.fincatto.nfe310.webservices.gerado.NfeInutilizacao2Stub.NfeInutilizacaoNF2Result;

class WSInutilizacao {

    private static final String VERSAO_SERVICO = "3.10";
    private static final String NOME_SERVICO = "INUTILIZAR";
    private static final String MODELO_DOCUMENTO = "55";
    private final NFeConfig config;
    private static final Logger LOG = Logger.getLogger(WSInutilizacao.class);

    public WSInutilizacao(final NFeConfig config) {
        this.config = config;
    }

    public NFRetornoEventoInutilizacao inutilizaNotaAssinada(final String eventoAssinadoXml) throws Exception {
        final OMElement omElementResult = this.efetuaInutilizacao(eventoAssinadoXml);
        return new NFPersister().read(NFRetornoEventoInutilizacao.class, omElementResult.toString());
    }

    public NFRetornoEventoInutilizacao inutilizaNota(final int anoInutilizacaoNumeracao, final String cnpjEmitente, final String serie, final String numeroInicial, final String numeroFinal, final String justificativa) throws Exception {
        final String inutilizacaoXML = this.geraDadosInutilizacao(anoInutilizacaoNumeracao, cnpjEmitente, serie, numeroInicial, numeroFinal, justificativa).toString();
        final String inutilizacaoXMLAssinado = new AssinaturaDigital(this.config).assinarDocumento(inutilizacaoXML);
        final OMElement omElementResult = this.efetuaInutilizacao(inutilizacaoXMLAssinado);

        return new NFPersister().read(NFRetornoEventoInutilizacao.class, omElementResult.toString());
    }

    private OMElement efetuaInutilizacao(final String inutilizacaoXMLAssinado) throws Exception {
        final NfeInutilizacao2Stub.NfeCabecMsg cabecalho = new NfeCabecMsg();
        cabecalho.setCUF(this.config.getCUF().getCodigoIbge());
        cabecalho.setVersaoDados(WSInutilizacao.VERSAO_SERVICO);

        final NfeInutilizacao2Stub.NfeCabecMsgE cabecalhoE = new NfeCabecMsgE();
        cabecalhoE.setNfeCabecMsg(cabecalho);

        final NfeInutilizacao2Stub.NfeDadosMsg dados = new NfeDadosMsg();
        final OMElement omElement = AXIOMUtil.stringToOM(inutilizacaoXMLAssinado);
        WSInutilizacao.LOG.debug(omElement);
        dados.setExtraElement(omElement);

        final String urlWebService = NFAutorizador31.valueOfCodigoUF(this.config.getCUF()).getNfeInutilizacao(this.config.getAmbiente());
        final NfeInutilizacaoNF2Result nf2Result = new NfeInutilizacao2Stub(urlWebService).nfeInutilizacaoNF2(dados, cabecalhoE);
        final OMElement dadosRetorno = nf2Result.getExtraElement();
        WSInutilizacao.LOG.debug(dadosRetorno);
        return dadosRetorno;
    }

    private NFEnviaEventoInutilizacao geraDadosInutilizacao(final int anoInutilizacaoNumeracao, final String cnpjEmitente, final String serie, final String numeroInicial, final String numeroFinal, final String justificativa) {
        final NFEnviaEventoInutilizacao inutilizacao = new NFEnviaEventoInutilizacao();
        final NFEventoCancelamentoDados dados = new NFEventoCancelamentoDados();
        dados.setAmbiente(this.config.getAmbiente());
        dados.setAno(anoInutilizacaoNumeracao);
        dados.setCnpj(cnpjEmitente);
        dados.setJustificativa(justificativa);
        dados.setModeloDocumentoFiscal(WSInutilizacao.MODELO_DOCUMENTO);
        dados.setNomeServico(WSInutilizacao.NOME_SERVICO);
        dados.setNumeroNFInicial(numeroInicial);
        dados.setNumeroNFFinal(numeroFinal);
        dados.setSerie(serie);
        dados.setUf(this.config.getCUF());
        final String numeroInicialTamanhoMaximo = StringUtils.leftPad(numeroInicial, 9, "0");
        final String numeroFinalTamanhoMaximo = StringUtils.leftPad(numeroFinal, 9, "0");
        final String serieTamanhoMaximo = StringUtils.leftPad(serie, 3, "0");
        dados.setIdentificador("ID" + this.config.getCUF().getCodigoIbge() + String.valueOf(anoInutilizacaoNumeracao) + cnpjEmitente + WSInutilizacao.MODELO_DOCUMENTO + serieTamanhoMaximo + numeroInicialTamanhoMaximo + numeroFinalTamanhoMaximo);

        inutilizacao.setVersao(new BigDecimal(WSInutilizacao.VERSAO_SERVICO));
        inutilizacao.setDados(dados);
        return inutilizacao;
    }
}