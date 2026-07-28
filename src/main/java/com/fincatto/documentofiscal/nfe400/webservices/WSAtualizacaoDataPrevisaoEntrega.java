package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.NotaFiscalChaveParser;
import com.fincatto.documentofiscal.nfe400.classes.NFAutorizador400;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEnviaEventoRetorno;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEventoTipoAutor;
import com.fincatto.documentofiscal.nfe400.classes.evento.atualizacaodataprevisaoentrega.NFEnviaEventoAtualizacaoDataPrevisaoEntrega;
import com.fincatto.documentofiscal.nfe400.classes.evento.atualizacaodataprevisaoentrega.NFEventoAtualizacaoDataPrevisaoEntrega;
import com.fincatto.documentofiscal.nfe400.classes.evento.atualizacaodataprevisaoentrega.NFInfoAtualizacaoDataPrevisaoEntrega;
import com.fincatto.documentofiscal.nfe400.classes.evento.atualizacaodataprevisaoentrega.NFInfoEventoAtualizacaoDataPrevisaoEntrega;
import com.fincatto.documentofiscal.nfe400.utils.ChaveAcessoUtils;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.utils.DFHttpClient;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Collections;

class WSAtualizacaoDataPrevisaoEntrega implements DFLog {
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("1.00");
    private static final String DESCRICAO_EVENTO = "Atualização da Data de Previsão de Entrega";
    private static final String CODIGO_EVENTO = "112150";
    private final NFeConfig config;
    private final DFHttpClient httpClient;

    WSAtualizacaoDataPrevisaoEntrega(final NFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    NFEnviaEventoRetorno atualizaDataPrevisaoEntrega(final String chaveAcesso, final LocalDate dataPrevisaoEntrega, final DFUnidadeFederativa ufAutorEvento, final NFEventoTipoAutor tpAutorEvento, final int numeroSequencialEvento) throws Exception {
        final String atualizacaoDataPrevisaoEntregaXMl = this.gerarDadosAtualizacaoDataPrevisaoEntrega(chaveAcesso, dataPrevisaoEntrega, ufAutorEvento, tpAutorEvento, numeroSequencialEvento).toString();
        final String xmlAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(atualizacaoDataPrevisaoEntregaXMl);
        final String xmlResultado = this.efetuaAtualizacaoDataPrevisaoEntrega(xmlAssinado, chaveAcesso);

        return this.config.getPersister().read(NFEnviaEventoRetorno.class, xmlResultado);
    }

    private NFEnviaEventoAtualizacaoDataPrevisaoEntrega gerarDadosAtualizacaoDataPrevisaoEntrega (final String chaveAcesso, final LocalDate dataPrevisaoEntrega, final DFUnidadeFederativa ufAutorEvento, final NFEventoTipoAutor tpAutorEvento, final int numeroSequencialEvento) {
        final NFInfoAtualizacaoDataPrevisaoEntrega atualizacaodataentrega = new NFInfoAtualizacaoDataPrevisaoEntrega();
        atualizacaodataentrega.setDescricaoEvento(WSAtualizacaoDataPrevisaoEntrega.DESCRICAO_EVENTO);
        atualizacaodataentrega.setVersao(WSAtualizacaoDataPrevisaoEntrega.VERSAO_LEIAUTE);
        atualizacaodataentrega.setUfAutorEvento(ufAutorEvento);
        atualizacaodataentrega.setVersaoAplicativo(WSAtualizacaoDataPrevisaoEntrega.VERSAO_LEIAUTE.toString());
        atualizacaodataentrega.setTipoAutor(tpAutorEvento);
        atualizacaodataentrega.setDataPrevisaoEntrega(dataPrevisaoEntrega);

        final NotaFiscalChaveParser chaveParser = new NotaFiscalChaveParser(chaveAcesso);
        final NFInfoEventoAtualizacaoDataPrevisaoEntrega infoEvento = new NFInfoEventoAtualizacaoDataPrevisaoEntrega();
        infoEvento.setAmbiente(this.config.getAmbiente());
        infoEvento.setChave(chaveAcesso);
        infoEvento.setCpf(chaveParser.getCpfEmitente());
        infoEvento.setCnpj(chaveParser.getCnpjEmitente());
        infoEvento.setDataHoraEvento(ZonedDateTime.now(this.config.getTimeZone().toZoneId()));
        infoEvento.setId(ChaveAcessoUtils.geraIDevento(chaveAcesso, WSAtualizacaoDataPrevisaoEntrega.CODIGO_EVENTO, numeroSequencialEvento));
        infoEvento.setNumeroSequencialEvento(numeroSequencialEvento);
        infoEvento.setOrgao(chaveParser.getNFUnidadeFederativa());
        infoEvento.setCodigoEvento(WSAtualizacaoDataPrevisaoEntrega.CODIGO_EVENTO);
        infoEvento.setVersaoEvento(WSAtualizacaoDataPrevisaoEntrega.VERSAO_LEIAUTE);
        infoEvento.setAtualizacaoDataPrevisaoEntrega(atualizacaodataentrega);

        final NFEventoAtualizacaoDataPrevisaoEntrega evento = new NFEventoAtualizacaoDataPrevisaoEntrega();
        evento.setInfoEvento(infoEvento);
        evento.setVersao(WSAtualizacaoDataPrevisaoEntrega.VERSAO_LEIAUTE);

        final NFEnviaEventoAtualizacaoDataPrevisaoEntrega enviaEvento = new NFEnviaEventoAtualizacaoDataPrevisaoEntrega();
        enviaEvento.setEvento(Collections.singletonList(evento));
        enviaEvento.setIdLote(Long.toString(ZonedDateTime.now(this.config.getTimeZone().toZoneId()).toInstant().toEpochMilli()));
        enviaEvento.setVersao(WSAtualizacaoDataPrevisaoEntrega.VERSAO_LEIAUTE);
        return enviaEvento;
    }

    /**
     * Envia o evento de atualizacao de data de previsao de entrega assinado para a SEFAZ e
     * devolve o XML de negocio da resposta. Endpoint sempre resolvido via
     * {@code NFAutorizador400.SVRS}; o envio em si e compartilhado com os demais servicos de
     * evento via {@link AbstractWSEvento#enviarEvento} (ver spec da migracao).
     */
    private String efetuaAtualizacaoDataPrevisaoEntrega(final String xmlAssinado, final String chaveAcesso) throws Exception {
        final NotaFiscalChaveParser parser = new NotaFiscalChaveParser(chaveAcesso);
        final NFAutorizador400 autorizador = NFAutorizador400.SVRS;
        final String urlWebService = DFModelo.NFCE.equals(parser.getModelo()) ? autorizador.getNfceRecepcaoEvento(this.config.getAmbiente()) : autorizador.getRecepcaoEvento(this.config.getAmbiente());
        if (urlWebService == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para RecepcaoEvento " + parser.getModelo().name() + ", autorizador " + autorizador.name());
        }

        return AbstractWSEvento.enviarEvento(this.httpClient, urlWebService, xmlAssinado);
    }
}
