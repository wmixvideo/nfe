package com.fincatto.documentofiscal.nfe310.webservices;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.assinatura.AssinaturaDigital;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe310.classes.NFAutorizador31;
import com.fincatto.documentofiscal.nfe310.classes.evento.NFEnviaEventoRetorno;
import com.fincatto.documentofiscal.nfe310.classes.evento.manifestacaodestinatario.NFEnviaEventoManifestacaoDestinatario;
import com.fincatto.documentofiscal.nfe310.classes.evento.manifestacaodestinatario.NFEventoManifestacaoDestinatario;
import com.fincatto.documentofiscal.nfe310.classes.evento.manifestacaodestinatario.NFInfoEventoManifestacaoDestinatario;
import com.fincatto.documentofiscal.nfe310.classes.evento.manifestacaodestinatario.NFInfoManifestacaoDestinatario;
import com.fincatto.documentofiscal.nfe310.classes.evento.manifestacaodestinatario.NFTipoEventoManifestacaoDestinatario;
import com.fincatto.documentofiscal.nfe310.parsers.NotaFiscalChaveParser;
import com.fincatto.documentofiscal.nfe310.webservices.gerado.RecepcaoEventoStub;
import com.fincatto.documentofiscal.persister.DFPersister;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.TimeZone;

public class WSManifestacaoDestinatario {

    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("1.00");
    private static final Logger LOGGER = LoggerFactory.getLogger(WSManifestacaoDestinatario.class);
    private final NFeConfig config;

    public WSManifestacaoDestinatario(final NFeConfig config) {
        this.config = config;
    }

    NFEnviaEventoRetorno manifestaDestinatarioNotaAssinada(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        final OMElement omElementResult = this.efetuaManifestacaoDestinatario(eventoAssinadoXml, chaveAcesso);
        return new DFPersister().read(NFEnviaEventoRetorno.class, omElementResult.toString());
    }

    NFEnviaEventoRetorno manifestaDestinatarioNota(final String chaveAcesso, final NFTipoEventoManifestacaoDestinatario tipoEvento, final String motivo, final String cnpj, TimeZone timeZone) throws Exception {
        final String manifestacaoDestinatarioNotaXML = this.gerarDadosManifestacaoDestinatario(chaveAcesso, tipoEvento, motivo, cnpj, timeZone).toString();
        final String xmlAssinado = new AssinaturaDigital(this.config).assinarDocumento(manifestacaoDestinatarioNotaXML);
        final OMElement omElementResult = this.efetuaManifestacaoDestinatario(xmlAssinado, chaveAcesso);
        return new DFPersister().read(NFEnviaEventoRetorno.class, omElementResult.toString());
    }

    private OMElement efetuaManifestacaoDestinatario(final String xmlAssinado, final String chaveAcesso) throws Exception {
        final RecepcaoEventoStub.NfeCabecMsg cabecalho = new RecepcaoEventoStub.NfeCabecMsg();
        cabecalho.setCUF(this.config.getCUF().getCodigoIbge());
        cabecalho.setVersaoDados(WSManifestacaoDestinatario.VERSAO_LEIAUTE.toPlainString());

        final RecepcaoEventoStub.NfeCabecMsgE cabecalhoE = new RecepcaoEventoStub.NfeCabecMsgE();
        cabecalhoE.setNfeCabecMsg(cabecalho);

        final RecepcaoEventoStub.NfeDadosMsg dados = new RecepcaoEventoStub.NfeDadosMsg();
        final OMElement omElementXML = AXIOMUtil.stringToOM(xmlAssinado);
        WSManifestacaoDestinatario.LOGGER.debug(omElementXML.toString());
        dados.setExtraElement(omElementXML);

        final NotaFiscalChaveParser parser = new NotaFiscalChaveParser(chaveAcesso);
        final NFAutorizador31 autorizador = NFAutorizador31.valueOfChaveAcesso(chaveAcesso);
        final String urlWebService = autorizador.getRecepcaoEventoAN(this.config.getAmbiente());
        if (urlWebService == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para RecepcaoEvento " + parser.getModelo().name() + ", autorizador " + autorizador.name());
        }

        final RecepcaoEventoStub.NfeRecepcaoEventoResult nfeRecepcaoEvento = new RecepcaoEventoStub(urlWebService).nfeRecepcaoEvento(dados, cabecalhoE);
        final OMElement omElementResult = nfeRecepcaoEvento.getExtraElement();
        WSManifestacaoDestinatario.LOGGER.debug(omElementResult.toString());
        return omElementResult;
    }

    private NFEnviaEventoManifestacaoDestinatario gerarDadosManifestacaoDestinatario(final String chaveAcesso, final NFTipoEventoManifestacaoDestinatario tipoEvento, final String motivo, final String cnpj, TimeZone timeZone) {
        // final NotaFiscalChaveParser chaveParser = new NotaFiscalChaveParser(chaveAcesso);

        final NFInfoManifestacaoDestinatario manifestacaoDestinatario = new NFInfoManifestacaoDestinatario();
        manifestacaoDestinatario.setDescricaoEvento(tipoEvento.getDescricao());
        manifestacaoDestinatario.setVersao(WSManifestacaoDestinatario.VERSAO_LEIAUTE);
        manifestacaoDestinatario.setJustificativa(motivo);

        final NFInfoEventoManifestacaoDestinatario infoEvento = new NFInfoEventoManifestacaoDestinatario();
        infoEvento.setAmbiente(this.config.getAmbiente());
        infoEvento.setChave(chaveAcesso);
        infoEvento.setCnpj(cnpj);
        if(timeZone != null){
            infoEvento.setDataHoraEvento(ZonedDateTime.now().withZoneSameInstant(timeZone.toZoneId()));
        }else{
            infoEvento.setDataHoraEvento(ZonedDateTime.now());
        }
        infoEvento.setId(String.format("ID%s%s0%s", tipoEvento.getCodigo(), chaveAcesso, "1"));
        infoEvento.setNumeroSequencialEvento(1);
        infoEvento.setOrgao(DFUnidadeFederativa.RFB);
        infoEvento.setCodigoEvento(tipoEvento.getCodigo());
        infoEvento.setVersaoEvento(WSManifestacaoDestinatario.VERSAO_LEIAUTE);
        infoEvento.setManifestacaoDestinatario(manifestacaoDestinatario);

        final NFEventoManifestacaoDestinatario evento = new NFEventoManifestacaoDestinatario();
        evento.setInfoEvento(infoEvento);
        evento.setVersao(WSManifestacaoDestinatario.VERSAO_LEIAUTE);

        final NFEnviaEventoManifestacaoDestinatario enviaEvento = new NFEnviaEventoManifestacaoDestinatario();
        enviaEvento.setEvento(Collections.singletonList(evento));
        enviaEvento.setIdLote(Long.toString(ZonedDateTime.now().toInstant().toEpochMilli()));
        enviaEvento.setVersao(WSManifestacaoDestinatario.VERSAO_LEIAUTE);
        return enviaEvento;
    }

}