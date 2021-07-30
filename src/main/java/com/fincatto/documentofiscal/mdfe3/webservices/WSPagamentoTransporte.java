package com.fincatto.documentofiscal.mdfe3.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.mdfe3.MDFeConfig;
import com.fincatto.documentofiscal.mdfe3.classes.MDFAutorizador3;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoModalRodoviarioInfPag;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoModalRodoviarioInfViagens;
import com.fincatto.documentofiscal.mdfe3.classes.nota.evento.*;
import com.fincatto.documentofiscal.mdfe3.classes.parsers.MDFChaveParser;
import com.fincatto.documentofiscal.mdfe3.webservices.recepcaoevento.MDFeRecepcaoEventoStub;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;

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

    WSPagamentoTransporte(final MDFeConfig config) {
        this.config = config;
    }

    MDFeRetorno pagamentoAssinado(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        final OMElement omElementResult = this.efetuaPagamento(eventoAssinadoXml, chaveAcesso);
        return this.config.getPersister().read(MDFeRetorno.class, omElementResult.toString());
    }

    MDFeRetorno pagamento(final String chaveAcesso, final String nProt, final List<MDFInfoModalRodoviarioInfPag> infPag, final List<MDFInfoModalRodoviarioInfViagens> infViagens) throws Exception {
        final String encerramentoNotaXML = this.gerarDadosEncerramento(chaveAcesso, nProt, infPag, infViagens).toString();
        final String xmlAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(encerramentoNotaXML);
        final OMElement omElementResult = this.efetuaPagamento(xmlAssinado, chaveAcesso);
        return this.config.getPersister().read(MDFeRetorno.class, omElementResult.toString());
    }

    private OMElement efetuaPagamento(final String xmlAssinado, final String chaveAcesso) throws Exception {
        final MDFChaveParser mdfChaveParser = new MDFChaveParser(chaveAcesso);
        final MDFeRecepcaoEventoStub.MdfeCabecMsg cabec = new MDFeRecepcaoEventoStub.MdfeCabecMsg();
        cabec.setCUF(mdfChaveParser.getNFUnidadeFederativa().getCodigoIbge());
        cabec.setVersaoDados(DFBigDecimalValidador.tamanho5Com2CasasDecimais(WSPagamentoTransporte.VERSAO_LEIAUTE, "Versao do Evento"));

        final MDFeRecepcaoEventoStub.MdfeCabecMsgE cabecE = new MDFeRecepcaoEventoStub.MdfeCabecMsgE();
        cabecE.setMdfeCabecMsg(cabec);

        final MDFeRecepcaoEventoStub.MdfeDadosMsg dados = new MDFeRecepcaoEventoStub.MdfeDadosMsg();
        final OMElement omElementXML = AXIOMUtil.stringToOM(xmlAssinado);
        this.getLogger().debug(omElementXML.toString());
        dados.setExtraElement(omElementXML);

        final MDFAutorizador3 autorizador = MDFAutorizador3.valueOfCodigoUF(mdfChaveParser.getNFUnidadeFederativa());
        final String urlWebService = autorizador.getMDFeRecepcaoEvento(this.config.getAmbiente());
        if (urlWebService == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para RecepcaoEvento " + mdfChaveParser.getModelo().name() + ", autorizador " + autorizador.name());
        }
        final MDFeRecepcaoEventoStub.MdfeRecepcaoEventoResult mdfeRecepcaoEventoResult = new MDFeRecepcaoEventoStub(urlWebService, config).mdfeRecepcaoEvento(dados, cabecE);
        final OMElement omElementResult = mdfeRecepcaoEventoResult.getExtraElement();
        this.getLogger().debug(omElementResult.toString());
        return omElementResult;
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
