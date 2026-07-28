package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.NotaFiscalChaveParser;
import com.fincatto.documentofiscal.nfe400.classes.NFAutorizador400;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEnviaEventoRetorno;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEventoTipoAutor;
import com.fincatto.documentofiscal.nfe400.classes.evento.aceitedebitoapuracao.NFEnviaEventoAceiteDebitoApuracao;
import com.fincatto.documentofiscal.nfe400.classes.evento.aceitedebitoapuracao.NFEventoAceiteDebitoApuracao;
import com.fincatto.documentofiscal.nfe400.classes.evento.aceitedebitoapuracao.NFInfoAceiteDebitoApuracao;
import com.fincatto.documentofiscal.nfe400.classes.evento.aceitedebitoapuracao.NFInfoEventoAceiteDebitoApuracao;
import com.fincatto.documentofiscal.nfe400.utils.ChaveAcessoUtils;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.utils.DFHttpClient;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Collections;

class WSAceiteDebitoApuracao implements DFLog {
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("1.00");
    private static final String DESCRICAO_EVENTO = "Aceite de débito na apuração por emissão de nota de crédito";
    private static final String CODIGO_EVENTO = "211128";
    private final NFeConfig config;
    private final DFHttpClient httpClient;

    WSAceiteDebitoApuracao(final NFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    NFEnviaEventoRetorno aceiteDebitoApuracao(
            final String chaveAcesso, final int indAceitacao, final DFUnidadeFederativa ufEmitenteEvento,
            final int numeroSequencialEvento, final String cnpjCpfAutorEvento
    ) throws Exception {
        final String atualizacaoDataPrevisaoEntregaXMl = this.gerarDadosAceiteDebitoApuracao(
                chaveAcesso, indAceitacao, ufEmitenteEvento, numeroSequencialEvento, cnpjCpfAutorEvento
        ).toString();
        final String xmlAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(atualizacaoDataPrevisaoEntregaXMl);
        final String xmlResultado = this.efetuaAceiteDebitoApuracao(xmlAssinado, chaveAcesso);

        return this.config.getPersister().read(NFEnviaEventoRetorno.class, xmlResultado);
    }

    private NFEnviaEventoAceiteDebitoApuracao gerarDadosAceiteDebitoApuracao (
            final String chaveAcesso, final int indAceitacao, final DFUnidadeFederativa ufEmitenteEvento,
            final int numeroSequencialEvento, final String cnpjCpfAutorEvento

    ) {
        final NFInfoAceiteDebitoApuracao aceiteDebitoApuracao = new NFInfoAceiteDebitoApuracao();
        aceiteDebitoApuracao.setDescricaoEvento(WSAceiteDebitoApuracao.DESCRICAO_EVENTO);
        aceiteDebitoApuracao.setVersao(WSAceiteDebitoApuracao.VERSAO_LEIAUTE);
        aceiteDebitoApuracao.setUfEmitenteEvento(ufEmitenteEvento);
        aceiteDebitoApuracao.setTipoAutor(NFEventoTipoAutor.EMPRESA_DESTINADA);
        aceiteDebitoApuracao.setVersaoAplicativo(WSAceiteDebitoApuracao.VERSAO_LEIAUTE.toString());
        aceiteDebitoApuracao.setIndAceitacao(indAceitacao);

        final NotaFiscalChaveParser chaveParser = new NotaFiscalChaveParser(chaveAcesso);
        final NFInfoEventoAceiteDebitoApuracao infoEvento = new NFInfoEventoAceiteDebitoApuracao();
        infoEvento.setAmbiente(this.config.getAmbiente());
        infoEvento.setChave(chaveAcesso);
        infoEvento.setCpf(cnpjCpfAutorEvento.length() == 11 ? cnpjCpfAutorEvento : null);
        infoEvento.setCnpj(cnpjCpfAutorEvento.length() > 11 ? cnpjCpfAutorEvento : null);
        infoEvento.setDataHoraEvento(ZonedDateTime.now(this.config.getTimeZone().toZoneId()));
        infoEvento.setId(ChaveAcessoUtils.geraIDevento(chaveAcesso, WSAceiteDebitoApuracao.CODIGO_EVENTO, numeroSequencialEvento));
        infoEvento.setNumeroSequencialEvento(numeroSequencialEvento);
        infoEvento.setOrgao(chaveParser.getNFUnidadeFederativa());
        infoEvento.setCodigoEvento(WSAceiteDebitoApuracao.CODIGO_EVENTO);
        infoEvento.setVersaoEvento(WSAceiteDebitoApuracao.VERSAO_LEIAUTE);
        infoEvento.setAceiteDebitoApuracao(aceiteDebitoApuracao);

        final NFEventoAceiteDebitoApuracao evento = new NFEventoAceiteDebitoApuracao();
        evento.setInfoEvento(infoEvento);
        evento.setVersao(WSAceiteDebitoApuracao.VERSAO_LEIAUTE);

        final NFEnviaEventoAceiteDebitoApuracao enviaEvento = new NFEnviaEventoAceiteDebitoApuracao();
        enviaEvento.setEvento(Collections.singletonList(evento));
        enviaEvento.setIdLote(Long.toString(ZonedDateTime.now(this.config.getTimeZone().toZoneId()).toInstant().toEpochMilli()));
        enviaEvento.setVersao(WSAceiteDebitoApuracao.VERSAO_LEIAUTE);
        return enviaEvento;
    }

    /**
     * Envia o evento de aceite de debito de apuracao assinado para a SEFAZ e devolve o XML de
     * negocio da resposta. Endpoint sempre resolvido via {@code NFAutorizador400.SVRS}; o envio
     * em si e compartilhado com os demais servicos de evento via
     * {@link AbstractWSEvento#enviarEvento} (ver spec da migracao).
     */
    private String efetuaAceiteDebitoApuracao(final String xmlAssinado, final String chaveAcesso) throws Exception {
        final NotaFiscalChaveParser parser = new NotaFiscalChaveParser(chaveAcesso);
        final NFAutorizador400 autorizador = NFAutorizador400.SVRS;
        final String urlWebService = DFModelo.NFCE.equals(parser.getModelo()) ? autorizador.getNfceRecepcaoEvento(this.config.getAmbiente()) : autorizador.getRecepcaoEvento(this.config.getAmbiente());
        if (urlWebService == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para RecepcaoEvento " + parser.getModelo().name() + ", autorizador " + autorizador.name());
        }

        return AbstractWSEvento.enviarEvento(this.httpClient, urlWebService, xmlAssinado);
    }
}
