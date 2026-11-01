package com.fincatto.documentofiscal.nfe310.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe310.classes.NFAutorizador31;
import com.fincatto.documentofiscal.nfe310.classes.evento.NFEnviaEventoRetorno;
import com.fincatto.documentofiscal.nfe310.classes.evento.NFEvento;
import com.fincatto.documentofiscal.nfe310.classes.evento.NFInfoEvento;
import com.fincatto.documentofiscal.nfe310.classes.evento.NFTipoEvento;
import com.fincatto.documentofiscal.nfe310.classes.evento.cartacorrecao.NFEnviaEventoCartaCorrecao;
import com.fincatto.documentofiscal.nfe310.parsers.NotaFiscalChaveParser;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Collections;

class WSCartaCorrecao implements DFLog {

    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("1.00");
    private static final String EVENTO_CODIGO = "110110";
    private static final String EVENTO_DESCRICAO = "Carta de Correcao";
    private static final String EVENTO_CONDICAO_USO = "A Carta de Correcao e disciplinada pelo paragrafo 1o-A do art. 7o do Convenio S/N, de 15 de dezembro de 1970 e pode ser utilizada para regularizacao de erro ocorrido na emissao de documento fiscal, desde que o erro nao esteja relacionado com: I - as variaveis que determinam o valor do imposto tais como: base de calculo, aliquota, diferenca de preco, quantidade, valor da operacao ou da prestacao; II - a correcao de dados cadastrais que implique mudanca do remetente ou do destinatario; III - a data de emissao ou de saida.";
    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/nfe/wsdl/RecepcaoEvento";
    private static final String SOAP_ACTION = WSCartaCorrecao.NAMESPACE_WSDL + "/nfeRecepcaoEvento";
    private final NFeConfig config;
    private final DFHttpClient httpClient;

    WSCartaCorrecao(final NFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    NFEnviaEventoRetorno corrigeNota(final String chaveAcesso, final String textoCorrecao, final int numeroSequencialEvento) throws Exception {
        final String cartaCorrecaoXML = this.gerarDadosCartaCorrecao(chaveAcesso, textoCorrecao, numeroSequencialEvento).toString();
        final String xmlAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(cartaCorrecaoXML);
        final String xmlResultado = this.efetuaCorrecao(xmlAssinado, chaveAcesso);
        return this.config.getPersister().read(NFEnviaEventoRetorno.class, xmlResultado);
    }

    NFEnviaEventoRetorno corrigeNotaAssinada(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        final String xmlResultado = this.efetuaCorrecao(eventoAssinadoXml, chaveAcesso);
        return this.config.getPersister().read(NFEnviaEventoRetorno.class, xmlResultado);
    }

    private String efetuaCorrecao(final String xmlAssinado, final String chaveAcesso) throws IOException, DFSoapFaultException {
        final NotaFiscalChaveParser parser = new NotaFiscalChaveParser(chaveAcesso);

        // resolve pelo autorizador da chave de acesso (e nao pela UF do config) para funcionar
        // tambem com notas emitidas em contingencia SVC-RS/SVC-AN, como faz o WSCancelamento
        final NFAutorizador31 autorizacao = NFAutorizador31.valueOfChaveAcesso(chaveAcesso);
        final String urlWebService = DFModelo.NFCE.equals(parser.getModelo()) ? autorizacao.getNfceRecepcaoEvento(this.config.getAmbiente()) : autorizacao.getRecepcaoEvento(this.config.getAmbiente());
        if (urlWebService == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para RecepcaoEvento " + parser.getModelo().name() + ", autorizador " + autorizacao.name());
        }

        final String envelope = WSCartaCorrecao.montarEnvelope(this.config.getCUF(), xmlAssinado);
        final String resposta = this.httpClient.postSoap(urlWebService, WSCartaCorrecao.SOAP_ACTION, envelope);
        return DFSoapEnvelope.desempacotar(resposta);
    }

    /**
     * Monta o envelope SOAP 1.2 desta operacao, com o {@code nfeCabecMsg} (exigido pelo WSDL
     * {@code RecepcaoEvento} da NF-e 3.10, ao contrario do {@code NFeRecepcaoEvento4} da NF-e
     * 4.00 usado pelo nfe400 - ver {@code AbstractWSEvento.enviarEvento}) contendo
     * {@code cUF}/{@code versaoDados}. O {@code cUF} e o configurado em {@link NFeConfig#getCUF()}
     * (a UF autorizadora do emitente), nao a UF da chave de acesso da nota. Extraido de
     * {@link #efetuaCorrecao} como metodo puro (sem I/O) para poder ser pinado por teste sem
     * precisar de servidor HTTP.
     */
    static String montarEnvelope(final DFUnidadeFederativa cUF, final String xmlAssinado) {
        final String cabecalho = "<cUF>" + cUF.getCodigoIbge() + "</cUF><versaoDados>" + WSCartaCorrecao.VERSAO_LEIAUTE.toPlainString() + "</versaoDados>";
        return DFSoapEnvelope.envelopar(WSCartaCorrecao.NAMESPACE_WSDL, "nfeCabecMsg", cabecalho, "nfeDadosMsg", xmlAssinado);
    }

    private NFEnviaEventoCartaCorrecao gerarDadosCartaCorrecao(final String chaveAcesso, final String textoCorrecao, final int numeroSequencialEvento) {
        final NotaFiscalChaveParser chaveParser = new NotaFiscalChaveParser(chaveAcesso);

        final NFTipoEvento cartaCorrecao = new NFTipoEvento();
        cartaCorrecao.setVersao(WSCartaCorrecao.VERSAO_LEIAUTE);
        cartaCorrecao.setDescricaoEvento(WSCartaCorrecao.EVENTO_DESCRICAO);
        cartaCorrecao.setCondicaoUso(WSCartaCorrecao.EVENTO_CONDICAO_USO);
        cartaCorrecao.setTextoCorrecao(textoCorrecao);

        final NFInfoEvento infoEvento = new NFInfoEvento();
        infoEvento.setAmbiente(this.config.getAmbiente());
        infoEvento.setDadosEvento(cartaCorrecao);
        infoEvento.setChave(chaveAcesso);
        infoEvento.setCnpj(chaveParser.getCnpjEmitente());
        infoEvento.setDataHoraEvento(ZonedDateTime.now(this.config.getTimeZone().toZoneId()));
        infoEvento.setId(String.format("ID%s%s%02d", WSCartaCorrecao.EVENTO_CODIGO, chaveAcesso, numeroSequencialEvento));
        infoEvento.setNumeroSequencialEvento(numeroSequencialEvento);
        infoEvento.setOrgao(chaveParser.getNFUnidadeFederativa());
        infoEvento.setTipoEvento(WSCartaCorrecao.EVENTO_CODIGO);
        infoEvento.setVersaoEvento(WSCartaCorrecao.VERSAO_LEIAUTE);

        final NFEvento evento = new NFEvento();
        evento.setInfoEvento(infoEvento);
        evento.setVersao(WSCartaCorrecao.VERSAO_LEIAUTE);

        final NFEnviaEventoCartaCorrecao enviaEvento = new NFEnviaEventoCartaCorrecao();
        enviaEvento.setEvento(Collections.singletonList(evento));
        enviaEvento.setIdLote(Long.toString(ZonedDateTime.now(this.config.getTimeZone().toZoneId()).toInstant().toEpochMilli()));
        enviaEvento.setVersao(WSCartaCorrecao.VERSAO_LEIAUTE);
        return enviaEvento;
    }
}
