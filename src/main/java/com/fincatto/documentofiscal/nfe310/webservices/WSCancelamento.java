package com.fincatto.documentofiscal.nfe310.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe310.classes.NFAutorizador31;
import com.fincatto.documentofiscal.nfe310.classes.evento.NFEnviaEventoRetorno;
import com.fincatto.documentofiscal.nfe310.classes.evento.cancelamento.NFEnviaEventoCancelamento;
import com.fincatto.documentofiscal.nfe310.classes.evento.cancelamento.NFEventoCancelamento;
import com.fincatto.documentofiscal.nfe310.classes.evento.cancelamento.NFInfoCancelamento;
import com.fincatto.documentofiscal.nfe310.classes.evento.cancelamento.NFInfoEventoCancelamento;
import com.fincatto.documentofiscal.nfe310.parsers.NotaFiscalChaveParser;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Collections;

class WSCancelamento implements DFLog {

    private static final String DESCRICAO_EVENTO = "Cancelamento";
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("1.00");
    private static final String EVENTO_CANCELAMENTO = "110111";
    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/nfe/wsdl/RecepcaoEvento";
    private static final String SOAP_ACTION = WSCancelamento.NAMESPACE_WSDL + "/nfeRecepcaoEvento";
    private final NFeConfig config;
    private final DFHttpClient httpClient;

    WSCancelamento(final NFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    NFEnviaEventoRetorno cancelaNotaAssinada(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        final String xmlResultado = this.efetuaCancelamento(eventoAssinadoXml, chaveAcesso);
        return this.config.getPersister().read(NFEnviaEventoRetorno.class, xmlResultado);
    }

    NFEnviaEventoRetorno cancelaNota(final String chaveAcesso, final String numeroProtocolo, final String motivo) throws Exception {
        final String cancelamentoNotaXML = this.gerarDadosCancelamento(chaveAcesso, numeroProtocolo, motivo).toString();
        final String xmlAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(cancelamentoNotaXML);
        final String xmlResultado = this.efetuaCancelamento(xmlAssinado, chaveAcesso);
        return this.config.getPersister().read(NFEnviaEventoRetorno.class, xmlResultado);
    }

    private String efetuaCancelamento(final String xmlAssinado, final String chaveAcesso) throws IOException, DFSoapFaultException {
        final NotaFiscalChaveParser parser = new NotaFiscalChaveParser(chaveAcesso);
        final NFAutorizador31 autorizador = NFAutorizador31.valueOfChaveAcesso(chaveAcesso);
        final String urlWebService = DFModelo.NFCE.equals(parser.getModelo()) ? autorizador.getNfceRecepcaoEvento(this.config.getAmbiente()) : autorizador.getRecepcaoEvento(this.config.getAmbiente());
        if (urlWebService == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para RecepcaoEvento " + parser.getModelo().name() + ", autorizador " + autorizador.name());
        }

        final String cabecalho = "<cUF>" + this.config.getCUF().getCodigoIbge() + "</cUF><versaoDados>" + WSCancelamento.VERSAO_LEIAUTE.toPlainString() + "</versaoDados>";
        final String envelope = DFSoapEnvelope.envelopar(WSCancelamento.NAMESPACE_WSDL, "nfeCabecMsg", cabecalho, "nfeDadosMsg", xmlAssinado);
        final String resposta = this.httpClient.postSoap(urlWebService, WSCancelamento.SOAP_ACTION, envelope);
        return DFSoapEnvelope.desempacotar(resposta);
    }

    private NFEnviaEventoCancelamento gerarDadosCancelamento(final String chaveAcesso, final String numeroProtocolo, final String motivo) {
        final NotaFiscalChaveParser chaveParser = new NotaFiscalChaveParser(chaveAcesso);

        final NFInfoCancelamento cancelamento = new NFInfoCancelamento();
        cancelamento.setDescricaoEvento(WSCancelamento.DESCRICAO_EVENTO);
        cancelamento.setVersao(WSCancelamento.VERSAO_LEIAUTE);
        cancelamento.setJustificativa(motivo);
        cancelamento.setProtocoloAutorizacao(numeroProtocolo);

        final NFInfoEventoCancelamento infoEvento = new NFInfoEventoCancelamento();
        infoEvento.setAmbiente(this.config.getAmbiente());
        infoEvento.setChave(chaveAcesso);
        infoEvento.setCnpj(chaveParser.getCnpjEmitente());
        infoEvento.setDataHoraEvento(ZonedDateTime.now(this.config.getTimeZone().toZoneId()));
        infoEvento.setId(String.format("ID%s%s0%s", WSCancelamento.EVENTO_CANCELAMENTO, chaveAcesso, "1"));
        infoEvento.setNumeroSequencialEvento(1);
        infoEvento.setOrgao(chaveParser.getNFUnidadeFederativa());
        infoEvento.setCodigoEvento(WSCancelamento.EVENTO_CANCELAMENTO);
        infoEvento.setVersaoEvento(WSCancelamento.VERSAO_LEIAUTE);
        infoEvento.setCancelamento(cancelamento);

        final NFEventoCancelamento evento = new NFEventoCancelamento();
        evento.setInfoEvento(infoEvento);
        evento.setVersao(WSCancelamento.VERSAO_LEIAUTE);

        final NFEnviaEventoCancelamento enviaEvento = new NFEnviaEventoCancelamento();
        enviaEvento.setEvento(Collections.singletonList(evento));
        enviaEvento.setIdLote(Long.toString(ZonedDateTime.now(this.config.getTimeZone().toZoneId()).toInstant().toEpochMilli()));
        enviaEvento.setVersao(WSCancelamento.VERSAO_LEIAUTE);
        return enviaEvento;
    }
}
