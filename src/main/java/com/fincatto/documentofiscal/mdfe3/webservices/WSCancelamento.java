package com.fincatto.documentofiscal.mdfe3.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.mdfe3.MDFeConfig;
import com.fincatto.documentofiscal.mdfe3.classes.nota.evento.MDFeDetalhamentoEvento;
import com.fincatto.documentofiscal.mdfe3.classes.nota.evento.MDFeEvento;
import com.fincatto.documentofiscal.mdfe3.classes.nota.evento.MDFeInfoEvento;
import com.fincatto.documentofiscal.mdfe3.classes.nota.evento.MDFeRetorno;
import com.fincatto.documentofiscal.mdfe3.classes.nota.evento.cancelamento.MDFeEnviaEventoCancelamento;
import com.fincatto.documentofiscal.mdfe3.classes.parsers.MDFChaveParser;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.utils.DFHttpClient;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * Created by Eldevan Nery Junior on 17/11/17.
 */
class WSCancelamento implements DFLog {

    private static final String DESCRICAO_EVENTO = "Cancelamento";
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("3.00");
    private static final String EVENTO_CANCELAMENTO = "110111";
    private final MDFeConfig config;
    private final DFHttpClient httpClient;

    WSCancelamento(final MDFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    MDFeRetorno cancelaNotaAssinada(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        final String xmlResultado = WSTransporteEvento.enviarEvento(this.httpClient, this.config, eventoAssinadoXml, chaveAcesso, WSCancelamento.VERSAO_LEIAUTE);
        return this.config.getPersister().read(MDFeRetorno.class, xmlResultado);
    }

    MDFeRetorno cancelaNota(final String chaveAcesso, final String numeroProtocolo, final String motivo) throws Exception {
        final String cancelamentoNotaXML = this.gerarDadosCancelamento(chaveAcesso, numeroProtocolo, motivo).toString();
        final String xmlAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(cancelamentoNotaXML);
        final String xmlResultado = WSTransporteEvento.enviarEvento(this.httpClient, this.config, xmlAssinado, chaveAcesso, WSCancelamento.VERSAO_LEIAUTE);
        return this.config.getPersister().read(MDFeRetorno.class, xmlResultado);
    }

    private MDFeEvento gerarDadosCancelamento(final String chaveAcesso, final String numeroProtocolo, final String motivo) {
        final MDFChaveParser chaveParser = new MDFChaveParser(chaveAcesso);

        final MDFeEnviaEventoCancelamento cancelamento = new MDFeEnviaEventoCancelamento();
        cancelamento.setDescricaoEvento(WSCancelamento.DESCRICAO_EVENTO);
        cancelamento.setJustificativa(motivo.trim());
        cancelamento.setProtocoloAutorizacao(numeroProtocolo);

        MDFeDetalhamentoEvento mdFeDetalhamentoEvento = new MDFeDetalhamentoEvento();
        mdFeDetalhamentoEvento.setMdFeEnviaEventoCancelamento(cancelamento);
        mdFeDetalhamentoEvento.setVersaoEvento(WSCancelamento.VERSAO_LEIAUTE);

        final MDFeInfoEvento infoEvento = new MDFeInfoEvento();
        infoEvento.setAmbiente(this.config.getAmbiente());
        infoEvento.setChave(chaveAcesso);
        infoEvento.setCpf(chaveParser.getCpfEmitente());
        infoEvento.setCnpj(chaveParser.getCnpjEmitente());
        infoEvento.setDataHoraEvento(ZonedDateTime.now(this.config.getTimeZone().toZoneId()));
        infoEvento.setId(String.format("ID%s%s0%s", WSCancelamento.EVENTO_CANCELAMENTO, chaveAcesso, "1"));
        infoEvento.setNumeroSequencialEvento(1);
        infoEvento.setOrgao(chaveParser.getNFUnidadeFederativa().getCodigoIbge());
        infoEvento.setCodigoEvento(WSCancelamento.EVENTO_CANCELAMENTO);
        infoEvento.setDetEvento(mdFeDetalhamentoEvento);

        MDFeEvento mdfeEventoCancelamento = new MDFeEvento();
        mdfeEventoCancelamento.setInfoEvento(infoEvento);
        mdfeEventoCancelamento.setVersao(WSCancelamento.VERSAO_LEIAUTE);

        return mdfeEventoCancelamento;
    }
}
