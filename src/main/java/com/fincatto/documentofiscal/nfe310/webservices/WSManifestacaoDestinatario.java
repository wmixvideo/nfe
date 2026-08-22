package com.fincatto.documentofiscal.nfe310.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe310.classes.NFAutorizador31;
import com.fincatto.documentofiscal.nfe310.classes.evento.NFEnviaEventoRetorno;
import com.fincatto.documentofiscal.nfe310.classes.evento.manifestacaodestinatario.*;
import com.fincatto.documentofiscal.nfe310.parsers.NotaFiscalChaveParser;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;
import com.fincatto.documentofiscal.utils.DFSocketFactory;

import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.time.ZonedDateTime;
import java.util.Collections;

public class WSManifestacaoDestinatario implements DFLog, Closeable {

    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("1.00");
    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/nfe/wsdl/RecepcaoEvento";
    private static final String SOAP_ACTION = WSManifestacaoDestinatario.NAMESPACE_WSDL + "/nfeRecepcaoEvento";

    private final NFeConfig config;
    // DFHttpClient recebido do WSFacade (compartilhado com os demais servicos migrados) quando
    // esta classe e construida atraves dele; fica null quando construida via
    // WSManifestacaoDestinatario(NFeConfig) diretamente por codigo externo.
    private final DFHttpClient httpClientCompartilhado;
    // Criado sob demanda (lazy) apenas quando ninguem injetou um DFHttpClient - so na primeira
    // chamada de rede, nunca no construtor, preservando o comportamento anterior a esta
    // migracao (o construtor publico de 1 argumento nao pode declarar as excecoes checked de
    // KeyStore/SSL sem quebrar quem ja o chama hoje).
    private DFHttpClient httpClientProprio;

    public WSManifestacaoDestinatario(final NFeConfig config) {
        this(config, null);
    }

    WSManifestacaoDestinatario(final NFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClientCompartilhado = httpClient;
    }

    private synchronized DFHttpClient getHttpClient() throws KeyManagementException, UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException {
        if (this.httpClientCompartilhado != null) {
            return this.httpClientCompartilhado;
        }
        if (this.httpClientProprio == null) {
            final DFSocketFactory socketFactory = new DFSocketFactory(this.config);
            this.httpClientProprio = new DFHttpClient(socketFactory.getSslContext(), this.config);
        }
        return this.httpClientProprio;
    }

    /**
     * Libera o pool de conexoes do {@link DFHttpClient} proprio, se algum tiver sido criado
     * (isto e, se esta instancia foi construida via {@link #WSManifestacaoDestinatario(NFeConfig)}
     * e chegou a fazer alguma chamada de rede). Nao fecha o {@link DFHttpClient} compartilhado
     * recebido do {@link WSFacade} - quem o criou e responsavel por fecha-lo (ver
     * {@link WSFacade#close()}).
     */
    @Override
    public synchronized void close() throws IOException {
        if (this.httpClientProprio != null) {
            this.httpClientProprio.close();
        }
    }

    NFEnviaEventoRetorno manifestaDestinatarioNotaAssinada(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        final String xmlResultado = this.efetuaManifestacaoDestinatario(eventoAssinadoXml, chaveAcesso);
        return this.config.getPersister().read(NFEnviaEventoRetorno.class, xmlResultado);
    }

    NFEnviaEventoRetorno manifestaDestinatarioNota(final String chaveAcesso, final NFTipoEventoManifestacaoDestinatario tipoEvento, final String motivo, final String cnpj) throws Exception {
        final String manifestacaoDestinatarioNotaXML = this.gerarDadosManifestacaoDestinatario(chaveAcesso, tipoEvento, motivo, cnpj).toString();
        final String xmlAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(manifestacaoDestinatarioNotaXML);
        final String xmlResultado = this.efetuaManifestacaoDestinatario(xmlAssinado, chaveAcesso);
        return this.config.getPersister().read(NFEnviaEventoRetorno.class, xmlResultado);
    }

    private String efetuaManifestacaoDestinatario(final String xmlAssinado, final String chaveAcesso)
            throws IOException, DFSoapFaultException, KeyManagementException, UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException {
        final NotaFiscalChaveParser parser = new NotaFiscalChaveParser(chaveAcesso);
        final NFAutorizador31 autorizador = NFAutorizador31.valueOfChaveAcesso(chaveAcesso);
        final String urlWebService = autorizador.getRecepcaoEventoAN(this.config.getAmbiente());
        if (urlWebService == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para RecepcaoEvento " + parser.getModelo().name() + ", autorizador " + autorizador.name());
        }

        final String cabecalho = "<cUF>" + this.config.getCUF().getCodigoIbge() + "</cUF><versaoDados>" + WSManifestacaoDestinatario.VERSAO_LEIAUTE.toPlainString() + "</versaoDados>";
        final String envelope = DFSoapEnvelope.envelopar(WSManifestacaoDestinatario.NAMESPACE_WSDL, "nfeCabecMsg", cabecalho, "nfeDadosMsg", xmlAssinado);
        final String resposta = this.getHttpClient().postSoap(urlWebService, WSManifestacaoDestinatario.SOAP_ACTION, envelope);
        return DFSoapEnvelope.desempacotar(resposta);
    }

    private NFEnviaEventoManifestacaoDestinatario gerarDadosManifestacaoDestinatario(final String chaveAcesso, final NFTipoEventoManifestacaoDestinatario tipoEvento, final String motivo, final String cnpj) {
        final NFInfoManifestacaoDestinatario manifestacaoDestinatario = new NFInfoManifestacaoDestinatario();
        manifestacaoDestinatario.setDescricaoEvento(tipoEvento.getDescricao());
        manifestacaoDestinatario.setVersao(WSManifestacaoDestinatario.VERSAO_LEIAUTE);
        manifestacaoDestinatario.setJustificativa(motivo);

        final NFInfoEventoManifestacaoDestinatario infoEvento = new NFInfoEventoManifestacaoDestinatario();
        infoEvento.setAmbiente(this.config.getAmbiente());
        infoEvento.setChave(chaveAcesso);
        infoEvento.setCnpj(cnpj);
        infoEvento.setDataHoraEvento(ZonedDateTime.now(config.getTimeZone().toZoneId()));
        infoEvento.setId(String.format("ID%s%s0%s", tipoEvento.getCodigo(), chaveAcesso, "1"));
        infoEvento.setNumeroSequencialEvento(1);
        infoEvento.setOrgao(DFUnidadeFederativa.RFB);
        infoEvento.setCodigoEvento(tipoEvento.getCodigo());
        infoEvento.setVersaoEvento(WSManifestacaoDestinatario.VERSAO_LEIAUTE);
        infoEvento.setManifestacaoDestinatario(manifestacaoDestinatario);

        final NFEventoManifestacaoDestinatario evento = new NFEventoManifestacaoDestinatario();
        evento.setInfoEvento(infoEvento);
        evento.setVersao(WSManifestacaoDestinatario.VERSAO_LEIAUTE);

        final NFEnviaEventoManifestacaoDestinatario enviaEvento = new NFEnviaEventoManifestacaoDestinatario();
        enviaEvento.setEvento(Collections.singletonList(evento));
        enviaEvento.setIdLote(Long.toString(ZonedDateTime.now(this.config.getTimeZone().toZoneId()).toInstant().toEpochMilli()));
        enviaEvento.setVersao(WSManifestacaoDestinatario.VERSAO_LEIAUTE);
        return enviaEvento;
    }
}
