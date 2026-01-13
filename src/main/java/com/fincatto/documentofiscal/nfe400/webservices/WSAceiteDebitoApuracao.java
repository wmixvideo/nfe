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
import com.fincatto.documentofiscal.nfe400.webservices.gerado.NFeRecepcaoEvento4Stub;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Collections;

class WSAceiteDebitoApuracao implements DFLog {
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("1.00");
    private static final String DESCRICAO_EVENTO = "Aceite de d\u00e9bito na apura\u00e7\u00e3o por emiss\u00e3o de nota de cr\u00e9dito";
    private static final String CODIGO_EVENTO = "211128";
    private final NFeConfig config;

    WSAceiteDebitoApuracao(NFeConfig config) {
        this.config = config;
    }

    NFEnviaEventoRetorno aceiteDebitoApuracao(
            final String chaveAcesso, final int indAceitacao, final DFUnidadeFederativa ufEmitenteEvento,
            final int numeroSequencialEvento, final String cnpjCpfAutorEvento
    ) throws Exception {
        final String atualizacaoDataPrevisaoEntregaXMl = this.gerarDadosAceiteDebitoApuracao(
                chaveAcesso, indAceitacao, ufEmitenteEvento, numeroSequencialEvento, cnpjCpfAutorEvento
        ).toString();
        final String xmlAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(atualizacaoDataPrevisaoEntregaXMl);
        final OMElement omElementResult = this.efetuaAceiteDebitoApuracao(xmlAssinado, chaveAcesso);

        return this.config.getPersister().read(NFEnviaEventoRetorno.class, omElementResult.toString());
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

    private OMElement efetuaAceiteDebitoApuracao(final String xmlAssinado, final String chaveAcesso) throws Exception {
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
;