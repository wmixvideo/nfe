package com.fincatto.documentofiscal.cte300.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.cte300.CTeConfig;
import com.fincatto.documentofiscal.cte300.classes.CTAutorizador31;
import com.fincatto.documentofiscal.cte300.classes.evento.*;
import com.fincatto.documentofiscal.cte300.parsers.CTChaveParser;
import com.fincatto.documentofiscal.cte300.webservices.recepcaoevento.RecepcaoEventoStub;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

abstract class WSRecepcaoEvento implements DFLog {

    protected final CTeConfig config;

    WSRecepcaoEvento(CTeConfig config) {
        this.config = config;
    }

    protected OMElement efetuaEvento(final String xmlAssinado, final String chaveAcesso, final BigDecimal versao) throws Exception {
        final CTChaveParser ctChaveParser = new CTChaveParser(chaveAcesso);
        final RecepcaoEventoStub.CteCabecMsg cabec = new RecepcaoEventoStub.CteCabecMsg();
        cabec.setCUF(ctChaveParser.getNFUnidadeFederativa().getCodigoIbge());
        cabec.setVersaoDados(DFBigDecimalValidador.tamanho5Com2CasasDecimais(versao, "Versao do Evento"));

        final RecepcaoEventoStub.CteCabecMsgE cabecE = new RecepcaoEventoStub.CteCabecMsgE();
        cabecE.setCteCabecMsg(cabec);

        final RecepcaoEventoStub.CteDadosMsg dados = new RecepcaoEventoStub.CteDadosMsg();
        final OMElement omElementXML = AXIOMUtil.stringToOM(xmlAssinado);
        this.getLogger().debug(omElementXML.toString());
        dados.setExtraElement(omElementXML);

        final CTAutorizador31 autorizador = CTAutorizador31.valueOfChaveAcesso(chaveAcesso);
        final String urlWebService = autorizador.getRecepcaoEvento(this.config.getAmbiente());
        if (urlWebService == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para RecepcaoEvento " + ctChaveParser.getModelo().name() + ", autorizador " + autorizador.name());
        }

        RecepcaoEventoStub.CteRecepcaoEventoResult cteRecepcaoEventoResult = new RecepcaoEventoStub(urlWebService, config).cteRecepcaoEvento(dados, cabecE);
        final OMElement omElementResult = cteRecepcaoEventoResult.getExtraElement();
        this.getLogger().debug(omElementResult.toString());
        return omElementResult;
    }

    protected CTeEvento gerarEvento(String chaveAcesso, BigDecimal versao, CTeTipoEvento evento, String codigoEvento, String cpfOuCnpj, int sequencialEvento) {
        final CTChaveParser chaveParser = new CTChaveParser(chaveAcesso);

        CTeDetalhamentoEvento cteDetalhamentoEventoCancelamento = new CTeDetalhamentoEvento();
        cteDetalhamentoEventoCancelamento.setVersaoEvento(versao);
        cteDetalhamentoEventoCancelamento.setEvento(evento);

        final CTeInfoEvento infoEvento = new CTeInfoEvento();
        infoEvento.setAmbiente(this.config.getAmbiente());
        infoEvento.setChave(chaveAcesso);

        if (cpfOuCnpj != null) {
            if (cpfOuCnpj.length() == 11) {
                infoEvento.setCpf(cpfOuCnpj);
            } else {
                infoEvento.setCnpj(cpfOuCnpj);
            }
        } else {
            infoEvento.setCnpj(chaveParser.getCnpjEmitente());
        }

        infoEvento.setDataHoraEvento(ZonedDateTime.now(this.config.getTimeZone().toZoneId()));
        infoEvento.setId(String.format("ID%s%s0%02d", codigoEvento, chaveAcesso, sequencialEvento));
        infoEvento.setNumeroSequencialEvento(sequencialEvento);
        infoEvento.setOrgao(chaveParser.getNFUnidadeFederativa());
        infoEvento.setCodigoEvento(codigoEvento);
        infoEvento.setDetalheEvento(cteDetalhamentoEventoCancelamento);

        CTeEvento cteEvento = new CTeEvento();
        cteEvento.setInfoEvento(infoEvento);
        cteEvento.setVersao(versao);

        return cteEvento;
    }


}
