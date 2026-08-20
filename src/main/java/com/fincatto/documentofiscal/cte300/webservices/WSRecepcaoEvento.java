package com.fincatto.documentofiscal.cte300.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte300.classes.CTAutorizador31;
import com.fincatto.documentofiscal.cte300.classes.evento.CTeDetalhamentoEvento;
import com.fincatto.documentofiscal.cte300.classes.evento.CTeEvento;
import com.fincatto.documentofiscal.cte300.classes.evento.CTeInfoEvento;
import com.fincatto.documentofiscal.cte300.classes.evento.CTeTipoEvento;
import com.fincatto.documentofiscal.cte300.parsers.CTChaveParser;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

abstract class WSRecepcaoEvento implements DFLog {

    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoEvento";
    private static final String SOAP_ACTION = WSRecepcaoEvento.NAMESPACE_WSDL + "/cteRecepcaoEvento";

    protected final CTeConfig config;
    private final DFHttpClient httpClient;
    private final List<DFModelo> modelosPermitidos;

    WSRecepcaoEvento(CTeConfig config, DFHttpClient httpClient, List<DFModelo> modelosPermitidos) {
        this.config = config;
        this.httpClient = httpClient;
        this.modelosPermitidos = modelosPermitidos;
    }

    protected String efetuaEvento(final String xmlAssinado, final String chaveAcesso, final BigDecimal versao) throws Exception {
        return efetuaEvento(xmlAssinado, chaveAcesso, versao, false);
    }

    protected String efetuaEventoSVC(final String xmlAssinado, final String chaveAcesso, final BigDecimal versao) throws Exception {
        return efetuaEvento(xmlAssinado, chaveAcesso, versao, true);
    }

    protected String efetuaEvento(final String xmlAssinado, final String chaveAcesso, final BigDecimal versao, final boolean contingencia) throws Exception {
        final CTChaveParser ctChaveParser = new CTChaveParser(chaveAcesso);
        if (!modelosPermitidos.contains(ctChaveParser.getModelo())) {
            throw new IllegalArgumentException("CT-e do modelo \"" + ctChaveParser.getModelo().toString() + "\" não é permitido nesse evento.");
        }

        DFXMLValidador.validaEventoCTe300(xmlAssinado);

        final CTAutorizador31 autorizador;
        if (contingencia) {
            autorizador = CTAutorizador31.valueOfTipoEmissao(this.config.getTipoEmissao(), this.config.getCUF());
        } else {
            autorizador = CTAutorizador31.valueOfChaveAcesso(chaveAcesso);
        }
        final String urlWebService = autorizador.getRecepcaoEvento(this.config.getAmbiente());
        if (urlWebService == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para RecepcaoEvento " + ctChaveParser.getModelo().name() + ", autorizador " + autorizador.name());
        }

        final String versaoDados = DFBigDecimalValidador.tamanho5Com2CasasDecimais(versao, "Versao do Evento");
        final String cabecalho = "<cUF>" + ctChaveParser.getNFUnidadeFederativa().getCodigoIbge() + "</cUF><versaoDados>" + versaoDados + "</versaoDados>";
        final String envelope = DFSoapEnvelope.envelopar(WSRecepcaoEvento.NAMESPACE_WSDL, "cteCabecMsg", cabecalho, "cteDadosMsg", xmlAssinado);
        final String resposta = this.httpClient.postSoap(urlWebService, WSRecepcaoEvento.SOAP_ACTION, envelope);
        return DFSoapEnvelope.desempacotar(resposta);
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
        infoEvento.setNumeroSequencialEvento(sequencialEvento);
        infoEvento.setId(String.format("ID%s%s%02d", codigoEvento, chaveAcesso, sequencialEvento));
        infoEvento.setOrgao(chaveParser.getNFUnidadeFederativa());
        infoEvento.setCodigoEvento(codigoEvento);
        infoEvento.setDetalheEvento(cteDetalhamentoEventoCancelamento);

        CTeEvento cteEvento = new CTeEvento();
        cteEvento.setInfoEvento(infoEvento);
        cteEvento.setVersao(versao);

        return cteEvento;
    }
}
