package com.fincatto.documentofiscal.mdfe3.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.mdfe3.MDFeConfig;
import com.fincatto.documentofiscal.mdfe3.classes.nota.evento.*;
import com.fincatto.documentofiscal.mdfe3.classes.parsers.MDFChaveParser;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.utils.DFHttpClient;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;

/**
 * Created by Eldevan Nery Junior on 17/11/17.
 */
class WSEncerramento implements DFLog {

    private static final String DESCRICAO_EVENTO = "Encerramento";
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("3.00");
    private static final String EVENTO_ENCERRAMENTO = "110112";
    private final MDFeConfig config;
    private final DFHttpClient httpClient;

    WSEncerramento(final MDFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    MDFeRetorno encerramentoMdfeAssinado(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        final String xmlResultado = WSTransporteEvento.enviarEvento(this.httpClient, this.config, eventoAssinadoXml, chaveAcesso, WSEncerramento.VERSAO_LEIAUTE);
        return this.config.getPersister().read(MDFeRetorno.class, xmlResultado);
    }

    MDFeRetorno encerraMdfe(final String chaveAcesso, final String numeroProtocolo, final String codigoMunicipio, final LocalDate dataEncerramento, final DFUnidadeFederativa unidadeFederativa) throws Exception {
        final String encerramentoNotaXML = this.gerarDadosEncerramento(chaveAcesso, numeroProtocolo, codigoMunicipio, dataEncerramento, unidadeFederativa).toString();
        final String xmlAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(encerramentoNotaXML);
        final String xmlResultado = WSTransporteEvento.enviarEvento(this.httpClient, this.config, xmlAssinado, chaveAcesso, WSEncerramento.VERSAO_LEIAUTE);
        return this.config.getPersister().read(MDFeRetorno.class, xmlResultado);
    }

    private MDFeEvento gerarDadosEncerramento(final String chaveAcesso, final String numeroProtocolo, final String codigoMunicipio, final LocalDate dataEncerramento, final DFUnidadeFederativa unidadeFederativa) {
        final MDFeEnviaEventoEncerramento encerramento = new MDFeEnviaEventoEncerramento();
        encerramento.setDescricaoEvento(WSEncerramento.DESCRICAO_EVENTO);
        encerramento.setCodigoMunicipio(codigoMunicipio);
        encerramento.setDataEncerramento(dataEncerramento);
        encerramento.setUf(unidadeFederativa);
        encerramento.setProtocoloAutorizacao(numeroProtocolo);

        final MDFeDetalhamentoEvento mdFeDetalhamentoEvento = new MDFeDetalhamentoEvento();
        mdFeDetalhamentoEvento.setEnviaEventoEncerramento(encerramento);
        mdFeDetalhamentoEvento.setVersaoEvento(WSEncerramento.VERSAO_LEIAUTE);

        final MDFChaveParser chaveParser = new MDFChaveParser(chaveAcesso);
        final MDFeInfoEvento infoEvento = new MDFeInfoEvento();
        infoEvento.setAmbiente(this.config.getAmbiente());
        infoEvento.setChave(chaveAcesso);
        infoEvento.setCpf(chaveParser.getCpfEmitente());
        infoEvento.setCnpj(chaveParser.getCnpjEmitente());
        infoEvento.setDataHoraEvento(ZonedDateTime.now(this.config.getTimeZone().toZoneId()));
        infoEvento.setId(String.format("ID%s%s0%s", WSEncerramento.EVENTO_ENCERRAMENTO, chaveAcesso, "1"));
        infoEvento.setNumeroSequencialEvento(1);
        infoEvento.setOrgao(chaveParser.getNFUnidadeFederativa().getCodigoIbge());
        infoEvento.setCodigoEvento(WSEncerramento.EVENTO_ENCERRAMENTO);
        infoEvento.setDetEvento(mdFeDetalhamentoEvento);

        final MDFeEvento mdfeEventoEncerramento = new MDFeEvento();
        mdfeEventoEncerramento.setInfoEvento(infoEvento);
        mdfeEventoEncerramento.setVersao(WSEncerramento.VERSAO_LEIAUTE);
        return mdfeEventoEncerramento;
    }
}
