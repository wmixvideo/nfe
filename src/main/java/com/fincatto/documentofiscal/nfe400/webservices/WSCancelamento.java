package com.fincatto.documentofiscal.nfe400.webservices;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.assinatura.AssinaturaDigital;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.NotaFiscalChaveParser;
import com.fincatto.documentofiscal.nfe400.classes.NFAutorizador400;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEnviaEventoRetorno;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEventoRetorno;
import com.fincatto.documentofiscal.nfe400.classes.evento.cancelamento.NFEnviaEventoCancelamento;
import com.fincatto.documentofiscal.nfe400.classes.evento.cancelamento.NFEventoCancelamento;
import com.fincatto.documentofiscal.nfe400.classes.evento.cancelamento.NFInfoCancelamento;
import com.fincatto.documentofiscal.nfe400.classes.evento.cancelamento.NFInfoEventoCancelamento;
import com.fincatto.documentofiscal.nfe400.classes.evento.cancelamento.NFProtocoloEventoCancelamento;
import com.fincatto.documentofiscal.nfe400.classes.lote.envio.NFCancelamentoRetornoDados;
import com.fincatto.documentofiscal.nfe400.webservices.gerado.NFeRecepcaoEvento4Stub;
import com.fincatto.documentofiscal.nfe400.webservices.gerado.NFeRecepcaoEvento4Stub.NfeResultMsg;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.utils.DFPersister;

class WSCancelamento implements DFLog {
    
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("1.00");
    private static final String DESCRICAO_EVENTO = "Cancelamento";
    private static final String EVENTO_CANCELAMENTO = "110111";
    private static final String DESCRICAO_EVENTO_CANCELAMENTO_POR_SUBSTITUICAO = "Cancelamento por substituicao";
    private static final String EVENTO_CANCELAMENTO_POR_SUBSTITUICAO = "110112";
    private final NFeConfig config;
    
    WSCancelamento(final NFeConfig config) {
        this.config = config;
    }

//    NFEnviaEventoRetorno cancelaNotaAssinada(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
    NFEnviaEventoRetorno cancelaNotaAssinada(final String chaveAcesso, final String eventoAssinadoXml, final boolean proxy, final String host, final String porta) throws Exception {
        final OMElement omElementResult = this.efetuaCancelamento(eventoAssinadoXml, chaveAcesso, proxy, host, porta);
        System.out.println("=====================================================================================");
        System.out.println("*** PASSO 5 - WSFacade.java (FINCATTO)  > WSCancelamento (FINCATTO) - 2. CANCELAMENTO DA NOTA ASSINADA ***");
        System.out.println("*** 1.WsFacade.java - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNotaAssinada - Chave de Acesso:  " + chaveAcesso);
        System.out.println("*** 1.WsFacade.java - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNotaAssinada - Evento Assinado XML: " + eventoAssinadoXml);
        System.out.println("*** 1.WsFacade.java - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNotaAssinada - Proxy: " + proxy);
        System.out.println("*** 1.WsFacade.java - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNotaAssinada - Host: " + host);
        System.out.println("*** 1.WsFacade.java - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNotaAssinada - Porta: " + porta);
        return this.config.getPersister().read(NFEnviaEventoRetorno.class, omElementResult.toString());
    }

    // ============================================================================================================================================================================
    NFEnviaEventoRetorno cancelaNota(final String chaveAcesso, final String numeroProtocolo, final String motivo, final boolean proxy, final String host, final String porta) throws Exception {
        //final String cancelamentoNotaXML = this.gerarDadosCancelamento(chaveAcesso, numeroProtocolo, motivo).toString();
        final String cancelamentoNotaXML = this.gerarDadosCancelamento(chaveAcesso, numeroProtocolo, motivo, proxy, host, porta).toString();
        System.out.println("=====================================================================================");
        System.out.println("*** PASSO 5 - WSFacade.java  > WSCancelamento (FINCATTO) - 2. CANCELAMENTO DA NOTA ***");
        System.out.println("*** 2.WsFacade.java   > WSCancelamento.java - cancelamentoNotaXML = this.gerarDadosCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - Chave de Acesso:  " + chaveAcesso);
        System.out.println("*** 2.WsFacade.java   > WSCancelamento.java - cancelamentoNotaXML = this.gerarDadosCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - Protocolo: " + numeroProtocolo);
        System.out.println("*** 2.WsFacade.java   > WSCancelamento.java - cancelamentoNotaXML = this.gerarDadosCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - Motivo: " + motivo);
        System.out.println("*** 2.WsFacade.java   > WSCancelamento.java - cancelamentoNotaXML = this.gerarDadosCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - Proxy: " + proxy);
        System.out.println("*** 2.WsFacade.java   > WSCancelamento.java - cancelamentoNotaXML = this.gerarDadosCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - Host: " + host);
        System.out.println("*** 2.WsFacade.java   > WSCancelamento.java - cancelamentoNotaXML = this.gerarDadosCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - Porta: " + porta);
        System.out.println("=====================================================================================");
        final String xmlAssinado = new AssinaturaDigital(this.config).assinarDocumento(cancelamentoNotaXML);
        System.out.println("*** 2.WsFacade.java   > WSCancelamento.java - xmlAssinado = this.config - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - XML Assinado:  " + xmlAssinado);
//        final OMElement omElementResult = this.efetuaCancelamento(xmlAssinado, chaveAcesso);
        final OMElement omElementResult = this.efetuaCancelamento(xmlAssinado, chaveAcesso, proxy, host, porta);
        System.out.println("*** 2.WsFacade.java   > WSCancelamento.java - omElementResult = this.config - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Efetua Cancelamento:  " + omElementResult);
        System.out.println("=====================================================================================");
        System.out.println("*** PASSO 5 - WSFacade.java  > WSCancelamento (FINCATTO) - 2. CANCELAMENTO DA NOTA ***");
        System.out.println("*** 2.WsFacade.java   > WSCancelamento.java - omElementResult = this.efetuaCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - XML Assinado:  " + xmlAssinado);
        System.out.println("*** 2.WsFacade.java   > WSCancelamento.java - omElementResult = this.efetuaCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - Chave de Acesso: " + chaveAcesso);
        System.out.println("*** 2.WsFacade.java   > WSCancelamento.java - omElementResult = this.efetuaCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - Proxy: " + proxy);
        System.out.println("*** 2.WsFacade.java   > WSCancelamento.java - omElementResult = this.efetuaCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - Host: " + host);
        System.out.println("*** 2.WsFacade.java   > WSCancelamento.java - omElementResult = this.efetuaCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - Porta: " + porta);
        System.out.println("*** 2.WsFacade.java   > WSCancelamento.java - Chama a classe NFEnviaEventoRetorno.class, omElementResult.toString(): ");
        System.out.println("=====================================================================================");
        return new com.fincatto.documentofiscal.persister.DFPersister().read(NFEnviaEventoRetorno.class, omElementResult.toString());
    }
    
//    private OMElement efetuaCancelamento(final String xmlAssinado, final String chaveAcesso) throws Exception {
    private OMElement efetuaCancelamento(final String xmlAssinado, final String chaveAcesso, final boolean proxy, final String host, final String porta) throws Exception {
        final NFeRecepcaoEvento4Stub.NfeDadosMsg dados = new NFeRecepcaoEvento4Stub.NfeDadosMsg();
        final OMElement omElementXML = AXIOMUtil.stringToOM(xmlAssinado);
        this.getLogger().debug(omElementXML.toString());
        dados.setExtraElement(omElementXML);
        
        System.out.println("=====================================================================================");
        System.out.println("*** PASSO 5 - WSFacade.java  > WSCancelamento (FINCATTO) - 2. CANCELAMENTO DA NOTA ASSINADA ***");
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - omElementResult = this.efetuaCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno efetuaCancelamento - XML Assinado:  " + xmlAssinado);
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - omElementResult = this.efetuaCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno efetuaCancelamento - Dados:  " + dados);
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - omElementResult = this.efetuaCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno efetuaCancelamento - Chave de Acesso: " + chaveAcesso);
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - omElementResult = this.efetuaCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno efetuaCancelamento - Proxy: " + proxy);
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - omElementResult = this.efetuaCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno efetuaCancelamento - Host: " + host);
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - omElementResult = this.efetuaCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno efetuaCancelamento - Porta: " + porta);
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - omElementResult = this.efetuaCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno efetuaCancelamento - OMElement: " + omElementXML);
        
        final NotaFiscalChaveParser parser = new NotaFiscalChaveParser(chaveAcesso);
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - parser = new NotaFiscalChaveParser - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno efetuaCancelamento - Nota Fiscal Chave Parser: " + parser);
        final NFAutorizador400 autorizador = NFAutorizador400.valueOfChaveAcesso(chaveAcesso);
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - autorizador = NFAutorizador400 - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno efetuaCancelamento - Autorizador: " + autorizador);        
        final String urlWebService = DFModelo.NFCE.equals(parser.getModelo()) ? autorizador.getNfceRecepcaoEvento(this.config.getAmbiente()) : autorizador.getRecepcaoEvento(this.config.getAmbiente());
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - urlWebService = DFModelo - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno efetuaCancelamento - urlWebService: " + urlWebService);        
        if (urlWebService == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para RecepcaoEvento " + parser.getModelo().name() + ", autorizador " + autorizador.name());
        }
        
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java NotaFiscalChaveParser parser - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Nota Fiscal Chave Parser:  " + parser);
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java NFAutorizador400 autorizador - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Autorizador:  " + autorizador);
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java String urlWebService - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - URL WebService:  " + urlWebService);
        
        final NfeResultMsg nfeRecepcaoEvento = new NFeRecepcaoEvento4Stub(urlWebService, config).nfeRecepcaoEvento(dados);
        final OMElement omElementResult = nfeRecepcaoEvento.getExtraElement();
        this.getLogger().debug(omElementResult.toString());

        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java NfeResultMsg nfeRecepcaoEvento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Recepção Evento:  " + nfeRecepcaoEvento);
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java OMElement omElementResult - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - OmElementResult:  " + omElementResult);
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java OMElement - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - WSCancelamento.LOGGER.debug(omElementResult.toString()");

        System.out.println("=====================================================================================");
        return omElementResult;
    }
    
    // ============================================================================================================================================================================
//    private NFEnviaEventoCancelamento gerarDadosCancelamento(final String chaveAcesso, final String numeroProtocolo, final String motivo) {
    private NFEnviaEventoCancelamento gerarDadosCancelamento(final String chaveAcesso, final String numeroProtocolo, final String motivo, final boolean proxy, final String host, final String porta) {
        System.out.println("=====================================================================================");
        System.out.println("*** PASSO 5 - WSFacade.java  > WSCancelamento (FINCATTO) - 2. CANCELAMENTO DA NOTA ***");
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFEnviaEventoCancelamento gerarDadosCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e ");
        
        final NotaFiscalChaveParser chaveParser = new NotaFiscalChaveParser(chaveAcesso);
        System.out.println("*** 2.WsFacade.java   > WSCancelamento.java - NFEnviaEventoCancelamento gerarDadosCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Chave Parser:  " + chaveParser);

        final NFInfoCancelamento cancelamento = new NFInfoCancelamento();
        cancelamento.setDescricaoEvento(WSCancelamento.DESCRICAO_EVENTO);
        cancelamento.setVersao(WSCancelamento.VERSAO_LEIAUTE);
        cancelamento.setJustificativa(motivo);
        cancelamento.setProtocoloAutorizacao(numeroProtocolo);
        
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento cancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Cancelamento:  " + cancelamento);
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento setDescricaoEvento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Descrição Evento:  " + WSCancelamento.DESCRICAO_EVENTO);
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento SetVersao - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Chave Parser:  " + WSCancelamento.VERSAO_LEIAUTE);
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento SetProtocoloAutorizacao - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Protocolo de Autorização:  " + numeroProtocolo);

        final NFInfoEventoCancelamento infoEvento = new NFInfoEventoCancelamento();
        infoEvento.setAmbiente(this.config.getAmbiente());
        infoEvento.setChave(chaveAcesso);
        if (Integer.parseInt(chaveParser.getSerie()) >= 920 && Integer.parseInt(chaveParser.getSerie()) <= 969 && chaveParser.isEmitentePessoaFisica()) {//destinado a emissão de pessoa física com IE
            infoEvento.setCpf(chaveParser.getCpfEmitente());
        } else {
            infoEvento.setCnpj(chaveParser.getCnpjEmitente());
        }
        infoEvento.setDataHoraEvento(ZonedDateTime.now(this.config.getTimeZone().toZoneId()));
        infoEvento.setId(String.format("ID%s%s0%s", WSCancelamento.EVENTO_CANCELAMENTO, chaveAcesso, "1"));
        infoEvento.setNumeroSequencialEvento(1);
        infoEvento.setOrgao(chaveParser.getNFUnidadeFederativa());
        infoEvento.setCodigoEvento(WSCancelamento.EVENTO_CANCELAMENTO);
        infoEvento.setVersaoEvento(WSCancelamento.VERSAO_LEIAUTE);
        infoEvento.setCancelamento(cancelamento);
        
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento infoEvento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Info Evento:  " + infoEvento);
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento setAmbiente - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Ambiente:  " + this.config.getAmbiente());
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento setChave - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Chave de Acesso:  " + chaveAcesso);
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento setDataHoraEvento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Data e Hora Evento:  " + ZonedDateTime.now(this.config.getTimeZone().toZoneId()));
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento setId - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - ID. Evento:  " + String.format("ID%s%s0%s", WSCancelamento.EVENTO_CANCELAMENTO, chaveAcesso, "1"));
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento setNumeroSequencialEvento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Numero Sequencial Evento:  " + 1);
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento setOrgao - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Órgão:  " + chaveParser.getNFUnidadeFederativa());
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento setCodigoEvento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Código Evento:  " + WSCancelamento.EVENTO_CANCELAMENTO);
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento setVersaoEvento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Versão Evento:  " + WSCancelamento.VERSAO_LEIAUTE);
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento setCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Cancelamento:  " + cancelamento);
        
        final NFEventoCancelamento evento = new NFEventoCancelamento();
        evento.setInfoEvento(infoEvento);
        evento.setVersao(WSCancelamento.VERSAO_LEIAUTE);
        
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFEventoCancelamento infoEvento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Info Evento:  " + infoEvento);
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFEventoCancelamento setVersao - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Versão:  " + WSCancelamento.VERSAO_LEIAUTE);

        final NFEnviaEventoCancelamento enviaEvento = new NFEnviaEventoCancelamento();
        enviaEvento.setEvento(Collections.singletonList(evento));
        enviaEvento.setIdLote(Long.toString(ZonedDateTime.now(this.config.getTimeZone().toZoneId()).toInstant().toEpochMilli()));
        enviaEvento.setVersao(WSCancelamento.VERSAO_LEIAUTE);

        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFEnviaEventoCancelamento enviaEvento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Info Evento:  " + infoEvento);
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento setEvento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Versão:  " + Collections.singletonList(evento));
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento setIdLote - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - ID. Lote:  " + Long.toString(ZonedDateTime.now(this.config.getTimeZone().toZoneId()).toInstant().toEpochMilli()));
        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento setVersao - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - ID. Lote:  " + WSCancelamento.VERSAO_LEIAUTE);

        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - enviaEvento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Envia Evento:  " + enviaEvento);

        return enviaEvento;
    }
    
//    NFEnviaEventoRetorno cancelaNotaPorSubstituicao(final String chaveAcesso, final String numeroProtocolo, final String motivo, final String versaoAplicativoAutorizador, final String chaveSubstituta) throws Exception {
    NFEnviaEventoRetorno cancelaNotaPorSubstituicao(final String chaveAcesso, final String numeroProtocolo, final String motivo, final boolean proxy, final String host, final String porta, final String versaoAplicativoAutorizador, final String chaveSubstituta) throws Exception {
        final String cancelamentoNotaXML = this.gerarDadosCancelamentoPorSubstituicao(chaveAcesso, numeroProtocolo, motivo, versaoAplicativoAutorizador, chaveSubstituta).toString();
        final String xmlAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(cancelamentoNotaXML);
        final OMElement omElementResult = this.efetuaCancelamento(xmlAssinado, chaveAcesso, proxy, host, porta);
        return this.config.getPersister().read(NFEnviaEventoRetorno.class, omElementResult.toString());
    }
    
    private NFEnviaEventoCancelamento gerarDadosCancelamentoPorSubstituicao(final String chaveAcesso, final String numeroProtocolo, final String motivo, final String versaoAplicativoAutorizador, final String chaveSubstituta) {
        final NotaFiscalChaveParser chaveParser = new NotaFiscalChaveParser(chaveAcesso);
        
        if(DFModelo.NFE.equals(chaveParser.getModelo())) throw new IllegalArgumentException("Evento nao permitido para modelo 55 - NFe!");
        	
        final NFInfoCancelamento cancelamento = new NFInfoCancelamento();
        cancelamento.setDescricaoEvento(WSCancelamento.DESCRICAO_EVENTO_CANCELAMENTO_POR_SUBSTITUICAO);
        cancelamento.setUfAutorizador(chaveParser.getNFUnidadeFederativa());
        cancelamento.setTipoAutorizador("1");//como orientado no manual
        cancelamento.setVersaoAplicativo(versaoAplicativoAutorizador);
        cancelamento.setVersao(WSCancelamento.VERSAO_LEIAUTE);
        cancelamento.setJustificativa(motivo);
        cancelamento.setProtocoloAutorizacao(numeroProtocolo);
        cancelamento.setChaveAcessoSubstituta(chaveSubstituta);
        
        final NFInfoEventoCancelamento infoEvento = new NFInfoEventoCancelamento();
        infoEvento.setAmbiente(this.config.getAmbiente());
        infoEvento.setChave(chaveAcesso);
        if (Integer.parseInt(chaveParser.getSerie()) >= 920 && Integer.parseInt(chaveParser.getSerie()) <= 969) {//destinado a emissão de pessoa física com IE
            infoEvento.setCpf(chaveParser.getCpfEmitente());
        } else {
            infoEvento.setCnpj(chaveParser.getCnpjEmitente());
        }
        infoEvento.setDataHoraEvento(ZonedDateTime.now(this.config.getTimeZone().toZoneId()));
        infoEvento.setId(String.format("ID%s%s0%s", WSCancelamento.EVENTO_CANCELAMENTO_POR_SUBSTITUICAO, chaveAcesso, "1"));
        infoEvento.setNumeroSequencialEvento(1);
        infoEvento.setOrgao(chaveParser.getNFUnidadeFederativa());
        infoEvento.setCodigoEvento(WSCancelamento.EVENTO_CANCELAMENTO_POR_SUBSTITUICAO);
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
