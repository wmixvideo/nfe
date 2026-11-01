package com.fincatto.documentofiscal.nfe400.webservices;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Collections;

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
import com.fincatto.documentofiscal.nfe400.utils.ChaveAcessoUtils;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;

class WSCancelametoEvento implements DFLog {
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("1.00");
    private static final String DESCRICAO_EVENTO = "Cancelamento de Evento";
    private static final String CODIGO_EVENTO = "110001";
    private final NFeConfig config;
    private final DFHttpClient httpClient;

    WSCancelametoEvento(final NFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    NFEnviaEventoRetorno cancelamentoEvento(
            final String chaveAcesso, final String codigoEventoAutorizado, final String numeroProtocoloEvento,
            final int numeroSequencialEventoCancelar, final DFUnidadeFederativa ufEmitenteEvento, final String cnpjCpfAutorEvento
    ) throws Exception {
        final String atualizacaoDataPrevisaoEntregaXMl = this.gerarDadosCancelamentoEvento(
                chaveAcesso, codigoEventoAutorizado, numeroProtocoloEvento, numeroSequencialEventoCancelar, ufEmitenteEvento, cnpjCpfAutorEvento
        ).toString();
        final String xmlAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(atualizacaoDataPrevisaoEntregaXMl);
        final String xmlResultado = this.efetuaCancelamentoevento(xmlAssinado, chaveAcesso);

        return this.config.getPersister().read(NFEnviaEventoRetorno.class, xmlResultado);
    }

    private NFEnviaEventoCancelamentoEvento gerarDadosCancelamentoEvento(
            final String chaveAcesso, final String codigoEventoAutorizado, final String numeroProtocoloEvento,
            final int numeroSequencialEventoCancelar, final DFUnidadeFederativa ufEmitenteEvento, final String cnpjCpfAutorEvento
    ) {
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
        infoEvento.setCpf(cnpjCpfAutorEvento.length() == 11 ? cnpjCpfAutorEvento : null);
        infoEvento.setCnpj(cnpjCpfAutorEvento.length() > 11 ? cnpjCpfAutorEvento : null);
        infoEvento.setDataHoraEvento(ZonedDateTime.now(this.config.getTimeZone().toZoneId()));
        infoEvento.setId(ChaveAcessoUtils.geraIDevento(chaveAcesso, WSCancelametoEvento.CODIGO_EVENTO, numeroSequencialEventoCancelar));
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

    /**
     * Envia o evento de cancelamento de evento assinado para a SEFAZ e devolve o XML de negocio
     * da resposta. Endpoint sempre resolvido via {@code NFAutorizador400.SVRS} (nao depende da
     * UF do emitente); o envio em si e compartilhado com os demais servicos de evento via
     * {@link AbstractWSEvento#enviarEvento} (ver spec da migracao).
     */
    private String efetuaCancelamentoevento(final String xmlAssinado, final String chaveAcesso) throws IOException, DFSoapFaultException {
        final NotaFiscalChaveParser parser = new NotaFiscalChaveParser(chaveAcesso);
        final NFAutorizador400 autorizador = NFAutorizador400.SVRS;
        final String urlWebService = DFModelo.NFCE.equals(parser.getModelo()) ? autorizador.getNfceRecepcaoEvento(this.config.getAmbiente()) : autorizador.getRecepcaoEvento(this.config.getAmbiente());
        if (urlWebService == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para RecepcaoEvento " + parser.getModelo().name() + ", autorizador " + autorizador.name());
        }

        return AbstractWSEvento.enviarEvento(this.httpClient, urlWebService, xmlAssinado);
    }
}
