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
import com.fincatto.documentofiscal.nfe400.webservices.gerado.NFeRecepcaoEvento4Stub;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Collections;

class WSAtualizacaoDataPrevisaoEntrega implements DFLog {
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("1.00");
    private static final String DESCRICAO_EVENTO = "Atualização da Data de Previsão de Entrega";
    private static final String CODIGO_EVENTO = "112150";
    private final NFeConfig config;

    WSAtualizacaoDataPrevisaoEntrega(NFeConfig config) {
        this.config = config;
    }

    NFEnviaEventoRetorno atualizaDataPrevisaoEntrega(final String chaveAcesso, final LocalDate dataPrevisaoEntrega, final DFUnidadeFederativa ufAutorEvento, final NFEventoTipoAutor tpAutorEvento, final int numeroSequencialEvento) throws Exception {
        final String atualizacaoDataPrevisaoEntregaXMl = this.gerarDadosAtualizacaoDataPrevisaoEntrega(chaveAcesso, dataPrevisaoEntrega, ufAutorEvento, tpAutorEvento, numeroSequencialEvento).toString();
        final String xmlAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(atualizacaoDataPrevisaoEntregaXMl);
        final OMElement omElementResult = this.efetuaAtualizacaoDataPrevisaoEntrega(xmlAssinado, chaveAcesso);

        return this.config.getPersister().read(NFEnviaEventoRetorno.class, omElementResult.toString());
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

    private OMElement efetuaAtualizacaoDataPrevisaoEntrega(final String xmlAssinado, final String chaveAcesso) throws Exception {
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