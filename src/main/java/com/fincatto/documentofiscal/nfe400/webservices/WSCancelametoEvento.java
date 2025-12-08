package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.NotaFiscalChaveParser;
import com.fincatto.documentofiscal.nfe400.classes.NFAutorizador400;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEnviaEventoRetorno;
import com.fincatto.documentofiscal.nfe400.classes.evento.cancelamentoevento.NFEnviaEventoCancelamentoEvento;
import com.fincatto.documentofiscal.nfe400.classes.evento.cancelamentoevento.NFEventoCancelamentoEvento;
import com.fincatto.documentofiscal.nfe400.classes.evento.cancelamentoevento.NFInfoCancelamentoEvento;
import com.fincatto.documentofiscal.nfe400.classes.evento.cancelamentoevento.NFInfoEventoCancelamentoEvento;
import com.fincatto.documentofiscal.nfe400.webservices.gerado.NFeRecepcaoEvento4Stub;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Collections;

class WSCancelametoEvento implements DFLog {
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("1.00");
    private static final String DESCRICAO_EVENTO = "Cancelamento de Evento";
    private static final String CODIGO_EVENTO = "110001";
    private final NFeConfig config;

    WSCancelametoEvento(NFeConfig config) {
        this.config = config;
    }

    NFEnviaEventoRetorno cancelamentoEvento(final String chaveAcesso, final String codigoEventoAutorizado, final String numeroProtocoloEvento, final int numeroSequencialEventoCancelar, final DFUnidadeFederativa ufEmitenteEvento) throws Exception {
        final String atualizacaoDataPrevisaoEntregaXMl = this.gerarDadosCancelamentoEvento(chaveAcesso, codigoEventoAutorizado, numeroProtocoloEvento, numeroSequencialEventoCancelar, ufEmitenteEvento).toString();
        final String xmlAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(atualizacaoDataPrevisaoEntregaXMl);
        final OMElement omElementResult = this.efetuaCancelamentoevento(xmlAssinado, chaveAcesso);

        return this.config.getPersister().read(NFEnviaEventoRetorno.class, omElementResult.toString());
    }

    private NFEnviaEventoCancelamentoEvento gerarDadosCancelamentoEvento(final String chaveAcesso, final String codigoEventoAutorizado, final String numeroProtocoloEvento, final int numeroSequencialEventoCancelar, final DFUnidadeFederativa ufEmitenteEvento) {
        final NFInfoCancelamentoEvento cancelamentoEvento = new NFInfoCancelamentoEvento();
        cancelamentoEvento.setDescricaoEvento(WSCancelametoEvento.DESCRICAO_EVENTO);
        cancelamentoEvento.setVersao(WSCancelametoEvento.VERSAO_LEIAUTE);
        cancelamentoEvento.setUfEmitenteEvento(ufEmitenteEvento);
        cancelamentoEvento.setVersaoAplicativo(WSCancelametoEvento.VERSAO_LEIAUTE.toString());
        cancelamentoEvento.setTipoEventoAutorizado(codigoEventoAutorizado);
        cancelamentoEvento.setNumeroProtocoloEvento(numeroProtocoloEvento);

        final NotaFiscalChaveParser chaveParser = new NotaFiscalChaveParser(chaveAcesso);
        final NFInfoEventoCancelamentoEvento infoEvento = new NFInfoEventoCancelamentoEvento();
        infoEvento.setAmbiente(this.config.getAmbiente());
        infoEvento.setChave(chaveAcesso);
        infoEvento.setCpf(chaveParser.getCpfEmitente());
        infoEvento.setCnpj(chaveParser.getCnpjEmitente());
        infoEvento.setDataHoraEvento(ZonedDateTime.now(this.config.getTimeZone().toZoneId()));
        infoEvento.setId(String.format("ID%s%s0%s", WSCancelametoEvento.CODIGO_EVENTO, chaveAcesso, numeroSequencialEventoCancelar));
        infoEvento.setNumeroSequencialEvento(numeroSequencialEventoCancelar);
        infoEvento.setOrgao(chaveParser.getNFUnidadeFederativa());
        infoEvento.setCodigoEvento(WSCancelametoEvento.CODIGO_EVENTO);
        infoEvento.setVersaoEvento(WSCancelametoEvento.VERSAO_LEIAUTE);
        infoEvento.setCancelamentoEvento(cancelamentoEvento);

        final NFEventoCancelamentoEvento evento = new NFEventoCancelamentoEvento();
        evento.setInfoEvento(infoEvento);
        evento.setVersao(WSCancelametoEvento.VERSAO_LEIAUTE);

        final NFEnviaEventoCancelamentoEvento enviaEvento = new NFEnviaEventoCancelamentoEvento();
        enviaEvento.setEvento(Collections.singletonList(evento));
        enviaEvento.setIdLote(Long.toString(ZonedDateTime.now(this.config.getTimeZone().toZoneId()).toInstant().toEpochMilli()));
        enviaEvento.setVersao(WSCancelametoEvento.VERSAO_LEIAUTE);
        return enviaEvento;
    }

    private OMElement efetuaCancelamentoevento(final String xmlAssinado, final String chaveAcesso) throws Exception {
        final NFeRecepcaoEvento4Stub.NfeDadosMsg dados = new NFeRecepcaoEvento4Stub.NfeDadosMsg();

        final OMElement omElementXML = AXIOMUtil.stringToOM(xmlAssinado);
        this.getLogger().debug(omElementXML.toString());
        dados.setExtraElement(omElementXML);

        final NotaFiscalChaveParser parser = new NotaFiscalChaveParser(chaveAcesso);
        final NFAutorizador400 autorizador = NFAutorizador400.SVRS;
        final String urlWebService = DFModelo.NFCE.equals(parser.getModelo()) ? autorizador.getNfceRecepcaoEvento(this.config.getAmbiente()) : autorizador.getRecepcaoEvento(this.config.getAmbiente());
        if (urlWebService == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para RecepcaoEvento " + parser.getModelo().name() + ", autorizador " + autorizador.name());
        }

        final NFeRecepcaoEvento4Stub.NfeResultMsg nfeRecepcaoEvento = new NFeRecepcaoEvento4Stub(urlWebService, config).nfeRecepcaoEvento(dados);
        final OMElement omElementResult = nfeRecepcaoEvento.getExtraElement();
        this.getLogger().debug(omElementResult.toString());

        return omElementResult;
    }
}