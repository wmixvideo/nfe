package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.NotaFiscalChaveParser;
import com.fincatto.documentofiscal.nfe400.classes.NFAutorizador400;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEnviaEventoRetorno;
import com.fincatto.documentofiscal.nfe400.classes.evento.manifestacaodestinatario.*;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.time.ZonedDateTime;
import java.util.Collections;

public class WSManifestacaoDestinatario implements DFLog {

    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("1.00");
    private final NFeConfig config;
    private final DFHttpClient httpClient;

    WSManifestacaoDestinatario(final NFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
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

        return AbstractWSEvento.enviarEvento(this.httpClient, urlWebService, xmlAssinado);
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
