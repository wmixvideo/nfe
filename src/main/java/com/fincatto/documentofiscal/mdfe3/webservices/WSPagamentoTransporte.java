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
    private static final String EVENTO_PAGAMENTO = "110116";
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
        return this.pagamento(chaveAcesso, nProt, infPag, infViagens, 1);
    }

    MDFeRetorno pagamento(final String chaveAcesso, final String nProt, final List<MDFInfoModalRodoviarioInfPag> infPag, final List<MDFInfoModalRodoviarioInfViagens> infViagens, final int numeroSequencialEvento) throws Exception {
        final String pagamentoXML = this.gerarDadosPagamento(chaveAcesso, nProt, infPag, infViagens, numeroSequencialEvento).toString();
        final String xmlAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(pagamentoXML);
        final String xmlResultado = WSTransporteEvento.enviarEvento(this.httpClient, this.config, xmlAssinado, chaveAcesso, WSPagamentoTransporte.VERSAO_LEIAUTE);
        return this.config.getPersister().read(MDFeRetorno.class, xmlResultado);
    }

    private MDFeEvento gerarDadosPagamento(final String chaveAcesso, final String nProt, final List<MDFInfoModalRodoviarioInfPag> infPag, final List<MDFInfoModalRodoviarioInfViagens> infViagens, final int numeroSequencialEvento) {
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
        infoEvento.setCpf(chaveParser.getCpfEmitente());
        infoEvento.setCnpj(chaveParser.getCnpjEmitente());
        infoEvento.setDataHoraEvento(ZonedDateTime.now(this.config.getTimeZone().toZoneId()));
        infoEvento.setId(String.format("ID%s%s%02d", WSPagamentoTransporte.EVENTO_PAGAMENTO, chaveAcesso, numeroSequencialEvento));
        infoEvento.setNumeroSequencialEvento(numeroSequencialEvento);
        infoEvento.setOrgao(chaveParser.getNFUnidadeFederativa().getCodigoIbge());
        infoEvento.setCodigoEvento(WSPagamentoTransporte.EVENTO_PAGAMENTO);
        infoEvento.setDetEvento(mdFeDetalhamentoEvento);

        final MDFeEvento mdfeEventoPagamento = new MDFeEvento();
        mdfeEventoPagamento.setInfoEvento(infoEvento);
        mdfeEventoPagamento.setVersao(WSPagamentoTransporte.VERSAO_LEIAUTE);
        return mdfeEventoPagamento;
    }
}
