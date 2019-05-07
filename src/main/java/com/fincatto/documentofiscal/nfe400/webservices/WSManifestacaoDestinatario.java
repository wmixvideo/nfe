package com.fincatto.documentofiscal.nfe400.webservices;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Collections;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.assinatura.AssinaturaDigital;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.NFAutorizador400;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEnviaEventoRetorno;
import com.fincatto.documentofiscal.nfe400.classes.evento.manifestacaodestinatario.NFEnviaEventoManifestacaoDestinatario;
import com.fincatto.documentofiscal.nfe400.classes.evento.manifestacaodestinatario.NFEventoManifestacaoDestinatario;
import com.fincatto.documentofiscal.nfe400.classes.evento.manifestacaodestinatario.NFInfoEventoManifestacaoDestinatario;
import com.fincatto.documentofiscal.nfe400.classes.evento.manifestacaodestinatario.NFInfoManifestacaoDestinatario;
import com.fincatto.documentofiscal.nfe400.classes.evento.manifestacaodestinatario.NFProtocoloEventoManifestacaoDestinatario;
import com.fincatto.documentofiscal.nfe400.classes.evento.manifestacaodestinatario.NFTipoEventoManifestacaoDestinatario;
import com.fincatto.documentofiscal.nfe400.parsers.NotaFiscalChaveParser;
import com.fincatto.documentofiscal.nfe400.webservices.gerado.NFeRecepcaoEvento4Stub;
import com.fincatto.documentofiscal.nfe400.webservices.gerado.NFeRecepcaoEvento4Stub.NfeResultMsg;
import com.fincatto.documentofiscal.persister.DFPersister;

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

    NFEnviaEventoRetorno manifestaDestinatarioNota(final String chaveAcesso, final NFTipoEventoManifestacaoDestinatario tipoEvento, final String motivo, final String cnpj) throws Exception {
        final String manifestacaoDestinatarioNotaXML = this.gerarDadosManifestacaoDestinatario(chaveAcesso, tipoEvento, motivo, cnpj).toString();
        final String xmlAssinado = new AssinaturaDigital(this.config).assinarDocumento(manifestacaoDestinatarioNotaXML);
        final OMElement omElementResult = this.efetuaManifestacaoDestinatario(xmlAssinado, chaveAcesso);
        return new DFPersister().read(NFEnviaEventoRetorno.class, omElementResult.toString());
    }

    NFProtocoloEventoManifestacaoDestinatario manifestaDestinatarioNotaProtocolo(final String chaveAcesso, final NFTipoEventoManifestacaoDestinatario tipoEvento, final String motivo, final String cnpj) throws Exception {
    	String manifestacaoDestinatarioNotaXML = this.gerarDadosManifestacaoDestinatario(chaveAcesso, tipoEvento, motivo, cnpj).toString();
    	
    	final String xmlAssinado = new AssinaturaDigital(this.config).assinarDocumento(manifestacaoDestinatarioNotaXML);
    	final OMElement omElementResult = this.efetuaManifestacaoDestinatario(xmlAssinado, chaveAcesso);
    	
    	NFEnviaEventoManifestacaoDestinatario evento = new DFPersister().read(NFEnviaEventoManifestacaoDestinatario.class, xmlAssinado);
    	NFEnviaEventoRetorno retorno = new DFPersister().read(NFEnviaEventoRetorno.class, omElementResult.toString());
    	
    	// Excessao se o codigo status do retorno diferente de 128 - Lote de Evento Processado 
		if (retorno.getCodigoStatusReposta() != 128) {
			throw new RuntimeException("Status: " + retorno.getCodigoStatusReposta() + " - Motivo: " + retorno.getMotivo());
		}

    	NFProtocoloEventoManifestacaoDestinatario nfProtocoloEventoManifestacaoDestinatario = new NFProtocoloEventoManifestacaoDestinatario();
    	nfProtocoloEventoManifestacaoDestinatario.setVersao(evento.getVersao());
    	nfProtocoloEventoManifestacaoDestinatario.setEvento(evento.getEvento().get(0));
    	nfProtocoloEventoManifestacaoDestinatario.setEventoRetorno(retorno.getEventoRetorno().get(0));
    	
    	return nfProtocoloEventoManifestacaoDestinatario;
    }
    
    private OMElement efetuaManifestacaoDestinatario(final String xmlAssinado, final String chaveAcesso) throws Exception {
        final NFeRecepcaoEvento4Stub.NfeDadosMsg dados = new NFeRecepcaoEvento4Stub.NfeDadosMsg();
        final OMElement omElementXML = AXIOMUtil.stringToOM(xmlAssinado);
        WSManifestacaoDestinatario.LOGGER.debug(omElementXML.toString());
        dados.setExtraElement(omElementXML);

        final NotaFiscalChaveParser parser = new NotaFiscalChaveParser(chaveAcesso);
        final NFAutorizador400 autorizador = NFAutorizador400.valueOfChaveAcesso(chaveAcesso);
        final String urlWebService = autorizador.getRecepcaoEventoAN(this.config.getAmbiente());
        if (urlWebService == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para RecepcaoEvento " + parser.getModelo().name() + ", autorizador " + autorizador.name());
        }

        final NfeResultMsg nfeRecepcaoEvento = new NFeRecepcaoEvento4Stub(urlWebService).nfeRecepcaoEvento(dados);
        final OMElement omElementResult = nfeRecepcaoEvento.getExtraElement();
        WSManifestacaoDestinatario.LOGGER.debug(omElementResult.toString());
        return omElementResult;
    }

    private NFEnviaEventoManifestacaoDestinatario gerarDadosManifestacaoDestinatario(final String chaveAcesso, final NFTipoEventoManifestacaoDestinatario tipoEvento, final String motivo, final String cnpj) {
        final NFInfoManifestacaoDestinatario manifestacaoDestinatario = new NFInfoManifestacaoDestinatario();
        manifestacaoDestinatario.setDescricaoEvento(tipoEvento.getDescricao());
        manifestacaoDestinatario.setVersao(WSManifestacaoDestinatario.VERSAO_LEIAUTE);
        manifestacaoDestinatario.setJustificativa(motivo);

        final NFInfoEventoManifestacaoDestinatario infoEvento = new NFInfoEventoManifestacaoDestinatario();
        infoEvento.setAmbiente(this.config.getAmbiente());
        infoEvento.setChave(chaveAcesso);
        infoEvento.setCnpj(cnpj);
        infoEvento.setDataHoraEvento(ZonedDateTime.now(this.config.getTimeZone().toZoneId()));
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
        enviaEvento.setIdLote(Long.toString(ZonedDateTime.now(this.config.getTimeZone().toZoneId()).toInstant().toEpochMilli()));
        enviaEvento.setVersao(WSManifestacaoDestinatario.VERSAO_LEIAUTE);
        return enviaEvento;
    }
}