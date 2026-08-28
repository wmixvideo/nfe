package com.fincatto.documentofiscal.cte300.webservices;

import java.io.IOException;
import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte300.classes.CTAutorizador31;
import com.fincatto.documentofiscal.cte300.classes.evento.inutilizacao.CTEnviaEventoInutilizacao;
import com.fincatto.documentofiscal.cte300.classes.evento.inutilizacao.CTEventoInutilizacaoDados;
import com.fincatto.documentofiscal.cte300.classes.evento.inutilizacao.CTeRetornoEventoInutilizacao;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;

class WSInutilizacao {

    private static final String VERSAO_SERVICO = "3.00";
    private static final String NOME_SERVICO = "INUTILIZAR";
    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/cte/wsdl/CteInutilizacao";
    private static final String SOAP_ACTION = WSInutilizacao.NAMESPACE_WSDL + "/cteInutilizacaoCT";
    private static final Logger LOGGER = LoggerFactory.getLogger(WSInutilizacao.class);
    private final CTeConfig config;
    private final DFHttpClient httpClient;

    WSInutilizacao(final CTeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    CTeRetornoEventoInutilizacao inutilizaNotaAssinada(final String eventoAssinadoXml) throws Exception {
        final String xmlResultado = this.efetuaInutilizacao(eventoAssinadoXml);
        return this.config.getPersister().read(CTeRetornoEventoInutilizacao.class, xmlResultado);
    }

    CTeRetornoEventoInutilizacao inutilizaNota(final int anoInutilizacaoNumeracao, final String cnpjEmitente, final String serie, final String numeroInicial, final String numeroFinal, final String justificativa, final DFModelo modelo) throws Exception {
        final String inutilizacaoXMLAssinado = getXmlAssinado(anoInutilizacaoNumeracao, cnpjEmitente, serie, numeroInicial, numeroFinal, justificativa, modelo);
        final String xmlResultado = this.efetuaInutilizacao(inutilizacaoXMLAssinado);
        return this.config.getPersister().read(CTeRetornoEventoInutilizacao.class, xmlResultado);
    }

    String getXmlAssinado(final int anoInutilizacaoNumeracao, final String cnpjEmitente, final String serie, final String numeroInicial, final String numeroFinal, final String justificativa, final DFModelo modelo) throws Exception {
    	final String inutilizacaoXML = this.geraDadosInutilizacao(anoInutilizacaoNumeracao, cnpjEmitente, serie, numeroInicial, numeroFinal, justificativa, modelo).toString();
        return new DFAssinaturaDigital(this.config).assinarDocumento(inutilizacaoXML);
    }

    private String efetuaInutilizacao(final String inutilizacaoXMLAssinado) throws IOException, DFSoapFaultException {
        WSInutilizacao.LOGGER.debug(inutilizacaoXMLAssinado);
        final String cabecalho = "<cUF>" + this.config.getCUF().getCodigoIbge() + "</cUF><versaoDados>" + WSInutilizacao.VERSAO_SERVICO + "</versaoDados>";

        final CTAutorizador31 autorizador = CTAutorizador31.valueOfCodigoUF(this.config.getCUF());
        final String urlWebService = autorizador.getCteInutilizacao(this.config.getAmbiente());
        if (urlWebService == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Inutilizacao, autorizador " + autorizador.name());
        }

        final String envelope = DFSoapEnvelope.envelopar(WSInutilizacao.NAMESPACE_WSDL, "cteCabecMsg", cabecalho, "cteDadosMsg", inutilizacaoXMLAssinado);
        final String resposta = this.httpClient.postSoap(urlWebService, WSInutilizacao.SOAP_ACTION, envelope);
        final String xmlResultado = DFSoapEnvelope.desempacotar(resposta);
        WSInutilizacao.LOGGER.debug(xmlResultado);
        return xmlResultado;
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
        dados.setNumeroCTInicial(numeroInicial);
        dados.setNumeroCTFinal(numeroFinal);
        dados.setSerie(serie);
        dados.setUf(this.config.getCUF());
        final String numeroInicialTamanhoMaximo = StringUtils.leftPad(numeroInicial, 9, "0");
        final String numeroFinalTamanhoMaximo = StringUtils.leftPad(numeroFinal, 9, "0");
        final String serieTamanhoMaximo = StringUtils.leftPad(serie, 3, "0");
        dados.setIdentificador("ID" + this.config.getCUF().getCodigoIbge() + anoInutilizacaoNumeracao + cnpjEmitente + modelo.getCodigo() + serieTamanhoMaximo + numeroInicialTamanhoMaximo + numeroFinalTamanhoMaximo);
        inutilizacao.setVersao(new BigDecimal(WSInutilizacao.VERSAO_SERVICO));
        inutilizacao.setDados(dados);
        return inutilizacao;
    }
}
