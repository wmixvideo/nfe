package com.fincatto.documentofiscal.cte300.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.cte300.CTeConfig;
import com.fincatto.documentofiscal.cte300.classes.CTAutorizador31;
import com.fincatto.documentofiscal.cte300.classes.evento.CTeDetalhamentoEvento;
import com.fincatto.documentofiscal.cte300.classes.evento.CTeEvento;
import com.fincatto.documentofiscal.cte300.classes.evento.CTeEventoRetorno;
import com.fincatto.documentofiscal.cte300.classes.evento.CTeInfoEvento;
import com.fincatto.documentofiscal.cte300.classes.evento.desacordo.CTeEnviaEventoPrestacaoEmDesacordo;
import com.fincatto.documentofiscal.cte300.parsers.CTChaveParser;
import com.fincatto.documentofiscal.cte300.webservices.recepcaoevento.RecepcaoEventoStub;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

class WSPrestacaoEmDesacordo implements DFLog {

    private static final String DESCRICAO_EVENTO = "Prestacao do Servico em Desacordo";
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("3.00");
    private static final String EVENTO_SERVICO_EM_DESACORDO = "610110";
    private final CTeConfig config;

    WSPrestacaoEmDesacordo(final CTeConfig config) {
        this.config = config;
    }

    CTeEventoRetorno prestacaoEmDesacordoAssinada(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        final OMElement omElementResult = this.efetuaPrestacaoEmDesacordo(eventoAssinadoXml, chaveAcesso);
        return this.config.getPersister().read(CTeEventoRetorno.class, omElementResult.toString());
    }

    CTeEventoRetorno prestacaoEmDesacordo(final String chaveAcesso, final String motivo, final String cpfOuCnpj) throws Exception {
        final String xmlAssinado = this.getXmlAssinado(chaveAcesso, motivo, cpfOuCnpj);
        final OMElement omElementResult = this.efetuaPrestacaoEmDesacordo(xmlAssinado, chaveAcesso);
        return this.config.getPersister().read(CTeEventoRetorno.class, omElementResult.toString());
    }

    String getXmlAssinado(final String chave, final String observacao, final String cpfOuCnpj) throws Exception {
        final String xml = this.gerarDadosPrestacaoEmDesacordo(chave, observacao, cpfOuCnpj).toString();
        return new DFAssinaturaDigital(this.config).assinarDocumento(xml);
    }

    private OMElement efetuaPrestacaoEmDesacordo(final String xmlAssinado, final String chaveAcesso) throws Exception {
        final CTChaveParser ctChaveParser = new CTChaveParser(chaveAcesso);
        final RecepcaoEventoStub.CteCabecMsg cabec = new RecepcaoEventoStub.CteCabecMsg();
        cabec.setCUF(ctChaveParser.getNFUnidadeFederativa().getCodigoIbge());
        cabec.setVersaoDados(DFBigDecimalValidador.tamanho5Com2CasasDecimais(VERSAO_LEIAUTE, "Versao do Evento"));

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

    private CTeEvento gerarDadosPrestacaoEmDesacordo(final String chaveAcesso, final String motivo) {
        final CTChaveParser chaveParser = new CTChaveParser(chaveAcesso);

        final CTeEnviaEventoPrestacaoEmDesacordo desacordo = new CTeEnviaEventoPrestacaoEmDesacordo();
        desacordo.setDescricaoEvento(WSPrestacaoEmDesacordo.DESCRICAO_EVENTO);
        desacordo.setIndicadorPrestacaoEmDesacordo(1);
        desacordo.setObservacao(motivo.trim());

        CTeDetalhamentoEvento cTeDetalhamentoEventoCancelamento = new CTeDetalhamentoEvento();
        cTeDetalhamentoEventoCancelamento.setVersaoEvento(WSPrestacaoEmDesacordo.VERSAO_LEIAUTE);
        cTeDetalhamentoEventoCancelamento.setEvento(desacordo);

        final CTeInfoEvento infoEvento = new CTeInfoEvento();
        infoEvento.setAmbiente(this.config.getAmbiente());
        infoEvento.setChave(chaveAcesso);
        infoEvento.setCnpj(chaveParser.getCnpjEmitente());
        infoEvento.setDataHoraEvento(ZonedDateTime.now(this.config.getTimeZone().toZoneId()));
        infoEvento.setId(String.format("ID%s%s0%s", WSPrestacaoEmDesacordo.EVENTO_SERVICO_EM_DESACORDO, chaveAcesso, "1"));
        infoEvento.setNumeroSequencialEvento(1);
        infoEvento.setOrgao(chaveParser.getNFUnidadeFederativa());
        infoEvento.setCodigoEvento(WSPrestacaoEmDesacordo.EVENTO_SERVICO_EM_DESACORDO);
        infoEvento.setCancelamento(cTeDetalhamentoEventoCancelamento);

        CTeEvento cTeEventoCancelamento = new CTeEvento();
        cTeEventoCancelamento.setInfoEvento(infoEvento);
        cTeEventoCancelamento.setVersao(WSPrestacaoEmDesacordo.VERSAO_LEIAUTE);

        return cTeEventoCancelamento;
    }
}
