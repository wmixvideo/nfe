package com.fincatto.documentofiscal.nfe400.webservices;

import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.time.ZonedDateTime;
import java.util.Collections;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.NotaFiscalChaveParser;
import com.fincatto.documentofiscal.nfe400.classes.NFAutorizador400;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEnviaEventoRetorno;
import com.fincatto.documentofiscal.nfe400.classes.evento.manifestacaodestinatario.NFEnviaEventoManifestacaoDestinatario;
import com.fincatto.documentofiscal.nfe400.classes.evento.manifestacaodestinatario.NFEventoManifestacaoDestinatario;
import com.fincatto.documentofiscal.nfe400.classes.evento.manifestacaodestinatario.NFInfoEventoManifestacaoDestinatario;
import com.fincatto.documentofiscal.nfe400.classes.evento.manifestacaodestinatario.NFInfoManifestacaoDestinatario;
import com.fincatto.documentofiscal.nfe400.classes.evento.manifestacaodestinatario.NFProtocoloEventoManifestacaoDestinatario;
import com.fincatto.documentofiscal.nfe400.classes.evento.manifestacaodestinatario.NFTipoEventoManifestacaoDestinatario;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;
import com.fincatto.documentofiscal.utils.DFSocketFactory;

public class WSManifestacaoDestinatario implements DFLog, Closeable {

    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("1.00");
    private final NFeConfig config;
    // DFHttpClient recebido do WSFacade (compartilhado com os demais servicos migrados) quando
    // esta classe e construida atraves dele; fica null quando construida via
    // WSManifestacaoDestinatario(NFeConfig) diretamente por codigo externo.
    private final DFHttpClient httpClientCompartilhado;
    // Criado sob demanda (lazy) apenas quando ninguem injetou um DFHttpClient - so na primeira
    // chamada de rede, nunca no construtor. Isso preserva o comportamento anterior a esta
    // migracao, em que problemas de certificado/SSL so apareciam ao efetivamente chamar a
    // SEFAZ, nunca ao instanciar a classe (o construtor publico de 1 argumento nao pode
    // declarar as excecoes checked de KeyStore/SSL sem quebrar quem ja o chama hoje).
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

    NFProtocoloEventoManifestacaoDestinatario manifestaDestinatarioNotaProtocolo(final String chaveAcesso, final NFTipoEventoManifestacaoDestinatario tipoEvento, final String motivo, final String cnpj) throws Exception {
        final String manifestacaoDestinatarioNotaXML = this.gerarDadosManifestacaoDestinatario(chaveAcesso, tipoEvento, motivo, cnpj).toString();

        final String xmlAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(manifestacaoDestinatarioNotaXML);
        final String xmlResultado = this.efetuaManifestacaoDestinatario(xmlAssinado, chaveAcesso);

        final NFEnviaEventoManifestacaoDestinatario evento = this.config.getPersister().read(NFEnviaEventoManifestacaoDestinatario.class, xmlAssinado);
        final NFEnviaEventoRetorno retorno = this.config.getPersister().read(NFEnviaEventoRetorno.class, xmlResultado);

        // Excessao se o codigo status do retorno diferente de 128 - Lote de Evento Processado
        if (retorno.getCodigoStatusReposta() != 128) {
            throw new RuntimeException("Status: " + retorno.getCodigoStatusReposta() + " - Motivo: " + retorno.getMotivo());
        }

        NFProtocoloEventoManifestacaoDestinatario nfProtocoloEventoManifestacaoDestinatario = new NFProtocoloEventoManifestacaoDestinatario();
        nfProtocoloEventoManifestacaoDestinatario.setVersao(evento.getVersao());
        nfProtocoloEventoManifestacaoDestinatario.setEvento(evento.getEvento().get(0));
        nfProtocoloEventoManifestacaoDestinatario.setEventoRetorno(retorno.getEventoRetorno().get(0));
        return nfProtocoloEventoManifestacaoDestinatario;
    }

    /**
     * Envia o evento de manifestacao do destinatario assinado para a SEFAZ e devolve o XML de
     * negocio da resposta. Diferente dos demais servicos de evento, o endpoint aqui e o do
     * Ambiente Nacional (getRecepcaoEventoAN), sem bifurcacao NFe/NFCe; o envio em si e
     * compartilhado com os demais servicos de evento via {@link AbstractWSEvento#enviarEvento}
     * (ver spec da migracao).
     */
    private String efetuaManifestacaoDestinatario(final String xmlAssinado, final String chaveAcesso)
            throws IOException, DFSoapFaultException, KeyManagementException, UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException {
        final NotaFiscalChaveParser parser = new NotaFiscalChaveParser(chaveAcesso);
        final NFAutorizador400 autorizador = NFAutorizador400.valueOfChaveAcesso(chaveAcesso);
        final String urlWebService = autorizador.getRecepcaoEventoAN(this.config.getAmbiente());
        if (urlWebService == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para RecepcaoEvento " + parser.getModelo().name() + ", autorizador " + autorizador.name());
        }

        return AbstractWSEvento.enviarEvento(this.getHttpClient(), urlWebService, xmlAssinado);
    }

    private NFEnviaEventoManifestacaoDestinatario gerarDadosManifestacaoDestinatario(final String chaveAcesso, final NFTipoEventoManifestacaoDestinatario tipoEvento, final String motivo, final String cpfOuCnpj) {
        final NFInfoManifestacaoDestinatario manifestacaoDestinatario = new NFInfoManifestacaoDestinatario();
        manifestacaoDestinatario.setDescricaoEvento(tipoEvento.getDescricao());
        manifestacaoDestinatario.setVersao(WSManifestacaoDestinatario.VERSAO_LEIAUTE);
        manifestacaoDestinatario.setJustificativa(motivo);

        final NFInfoEventoManifestacaoDestinatario infoEvento = new NFInfoEventoManifestacaoDestinatario();
        infoEvento.setAmbiente(this.config.getAmbiente());
        infoEvento.setChave(chaveAcesso);
        if (cpfOuCnpj.length() == 11) {
            infoEvento.setCpf(cpfOuCnpj);
        } else {
            infoEvento.setCnpj(cpfOuCnpj);
        }
        infoEvento.setDataHoraEvento(ZonedDateTime.now(this.config.getTimeZone().toZoneId()));
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
