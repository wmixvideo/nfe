package com.fincatto.documentofiscal.mdfe3.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.mdfe3.MDFeConfig;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoModalRodoviarioInfPag;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoModalRodoviarioInfViagens;
import com.fincatto.documentofiscal.mdfe3.classes.nota.evento.*;
import com.fincatto.documentofiscal.mdfe3.classes.parsers.MDFChaveParser;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.utils.DFHttpClient;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created by Eldevan Nery Junior on 17/11/17.
 */
class WSPagamentoTransporte implements DFLog {

    private static final String DESCRICAO_EVENTO = "Pagamento Operação MDF-e";
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("3.00");
    private static final String EVENTO_ENCERRAMENTO = "110116";
    private final MDFeConfig config;
    private final DFHttpClient httpClient;

    WSPagamentoTransporte(final MDFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    MDFeRetorno pagamentoAssinado(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        final String xmlResultado = WSTransporteEvento.enviarEvento(this.httpClient, this.config, eventoAssinadoXml, chaveAcesso, WSPagamentoTransporte.VERSAO_LEIAUTE);
        return this.config.getPersister().read(MDFeRetorno.class, xmlResultado);
    }

    MDFeRetorno pagamento(final String chaveAcesso, final String nProt, final List<MDFInfoModalRodoviarioInfPag> infPag, final List<MDFInfoModalRodoviarioInfViagens> infViagens) throws Exception {
        final String encerramentoNotaXML = this.gerarDadosEncerramento(chaveAcesso, nProt, infPag, infViagens).toString();
        final String xmlAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(encerramentoNotaXML);
        final String xmlResultado = WSTransporteEvento.enviarEvento(this.httpClient, this.config, xmlAssinado, chaveAcesso, WSPagamentoTransporte.VERSAO_LEIAUTE);
        return this.config.getPersister().read(MDFeRetorno.class, xmlResultado);
    }

    private MDFeEvento gerarDadosEncerramento(final String chaveAcesso, final String nProt, final List<MDFInfoModalRodoviarioInfPag> infPag, final List<MDFInfoModalRodoviarioInfViagens> infViagens) {
        final MDFChaveParser chaveParser = new MDFChaveParser(chaveAcesso);

        final MDFeEnviaEventoPagamento pagamento = new MDFeEnviaEventoPagamento();
        pagamento.setDescricaoEvento(WSPagamentoTransporte.DESCRICAO_EVENTO);
        pagamento.setNProt(nProt);
        pagamento.setInfPag(infPag);
        pagamento.setInfViagens(infViagens);

        final MDFeDetalhamentoEvento mdFeDetalhamentoEvento = new MDFeDetalhamentoEvento();
        mdFeDetalhamentoEvento.setEnviaEventoPagamento(pagamento);
        mdFeDetalhamentoEvento.setVersaoEvento(WSPagamentoTransporte.VERSAO_LEIAUTE);

        final MDFeInfoEvento infoEvento = new MDFeInfoEvento();
        infoEvento.setAmbiente(this.config.getAmbiente());
        infoEvento.setChave(chaveAcesso);
        infoEvento.setCnpj(chaveParser.getCnpjEmitente());
        infoEvento.setDataHoraEvento(ZonedDateTime.now(this.config.getTimeZone().toZoneId()));
        infoEvento.setId(String.format("ID%s%s0%s", WSPagamentoTransporte.EVENTO_ENCERRAMENTO, chaveAcesso, "1"));
        infoEvento.setNumeroSequencialEvento(1);
        infoEvento.setOrgao(chaveParser.getNFUnidadeFederativa().getCodigoIbge());
        infoEvento.setCodigoEvento(WSPagamentoTransporte.EVENTO_ENCERRAMENTO);
        infoEvento.setDetEvento(mdFeDetalhamentoEvento);

        final MDFeEvento mdfeEventoEncerramento = new MDFeEvento();
        mdfeEventoEncerramento.setInfoEvento(infoEvento);
        mdfeEventoEncerramento.setVersao(WSPagamentoTransporte.VERSAO_LEIAUTE);
        return mdfeEventoEncerramento;
    }
}
