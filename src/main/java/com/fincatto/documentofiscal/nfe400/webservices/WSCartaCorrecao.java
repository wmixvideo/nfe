package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.NotaFiscalChaveParser;
import com.fincatto.documentofiscal.nfe400.classes.NFAutorizador400;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEnviaEventoRetorno;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEvento;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFInfoEvento;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFTipoEvento;
import com.fincatto.documentofiscal.nfe400.classes.evento.cartacorrecao.NFEnviaEventoCartaCorrecao;
import com.fincatto.documentofiscal.nfe400.classes.evento.cartacorrecao.NFProtocoloEventoCartaCorrecao;
import com.fincatto.documentofiscal.nfe400.webservices.gerado.NFeRecepcaoEvento4Stub;
import com.fincatto.documentofiscal.nfe400.webservices.gerado.NFeRecepcaoEvento4Stub.NfeResultMsg;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;

import javax.xml.stream.XMLStreamException;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.time.ZonedDateTime;
import java.util.Collections;

class WSCartaCorrecao implements DFLog {
    
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("1.00");
    private static final String EVENTO_CODIGO = "110110";
    private static final String EVENTO_DESCRICAO = "Carta de Correcao";
    private static final String EVENTO_CONDICAO_USO = "A Carta de Correcao e disciplinada pelo paragrafo 1o-A do art. 7o do Convenio S/N, de 15 de dezembro de 1970 e pode ser utilizada para regularizacao de erro ocorrido na emissao de documento fiscal, desde que o erro nao esteja relacionado com: I - as variaveis que determinam o valor do imposto tais como: base de calculo, aliquota, diferenca de preco, quantidade, valor da operacao ou da prestacao; II - a correcao de dados cadastrais que implique mudanca do remetente ou do destinatario; III - a data de emissao ou de saida.";
    private final NFeConfig config;
    
    WSCartaCorrecao(final NFeConfig config) {
        this.config = config;
    }
    
    NFEnviaEventoRetorno corrigeNota(final String chaveAcesso, final String textoCorrecao, final int numeroSequencialEvento) throws Exception {
        final String xmlAssinado = getXmlAssinado(chaveAcesso, textoCorrecao, numeroSequencialEvento);
        final OMElement omElementResult = this.efetuaCorrecao(xmlAssinado, chaveAcesso);
        return this.config.getPersister().read(NFEnviaEventoRetorno.class, omElementResult.toString());
    }
    
    NFEnviaEventoRetorno corrigeNotaAssinada(final String xmlAssinado) throws Exception {
        final NFEnviaEventoCartaCorrecao enviaEventoCartaCorrecao = this.config.getPersister().read(NFEnviaEventoCartaCorrecao.class, xmlAssinado);
        final OMElement omElementResult = this.efetuaCorrecao(xmlAssinado, enviaEventoCartaCorrecao.getEvento().get(0).getInfoEvento().getChave());
        return this.config.getPersister().read(NFEnviaEventoRetorno.class, omElementResult.toString());
    }
    
    NFProtocoloEventoCartaCorrecao corrigeNotaAssinadaProtocolo(final String xmlAssinado) throws Exception {
        final NFEnviaEventoCartaCorrecao evento = this.config.getPersister().read(NFEnviaEventoCartaCorrecao.class, xmlAssinado);
        final OMElement omElementResult = this.efetuaCorrecao(xmlAssinado, evento.getEvento().get(0).getInfoEvento().getChave());
    
        final NFEnviaEventoRetorno retorno = this.config.getPersister().read(NFEnviaEventoRetorno.class, omElementResult.toString());
    
        final NFProtocoloEventoCartaCorrecao nfProtocoloEventoCartaCorrecao = new NFProtocoloEventoCartaCorrecao();
        nfProtocoloEventoCartaCorrecao.setEvento(evento.getEvento().get(0));
        nfProtocoloEventoCartaCorrecao.setEventoRetorno(retorno.getEventoRetorno().get(0));
        return nfProtocoloEventoCartaCorrecao;
    }
    
    NFEnviaEventoRetorno corrigeNotaAssinada(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        final OMElement omElementResult = this.efetuaCorrecao(eventoAssinadoXml, chaveAcesso);
        return this.config.getPersister().read(NFEnviaEventoRetorno.class, omElementResult.toString());
    }
    
    private OMElement efetuaCorrecao(final String xmlAssinado, final String chaveAcesso) throws XMLStreamException, RemoteException {
        final NFeRecepcaoEvento4Stub.NfeDadosMsg dados = new NFeRecepcaoEvento4Stub.NfeDadosMsg();
        final OMElement omElementXML = AXIOMUtil.stringToOM(xmlAssinado);
        this.getLogger().debug(omElementXML.toString());
        dados.setExtraElement(omElementXML);
        
        final NotaFiscalChaveParser parser = new NotaFiscalChaveParser(chaveAcesso);
        
        final NFAutorizador400 autorizacao = NFAutorizador400.valueOfCodigoUF(this.config.getCUF());
        final String urlWebService = DFModelo.NFCE.equals(parser.getModelo()) ? autorizacao.getNfceRecepcaoEvento(this.config.getAmbiente()) : autorizacao.getRecepcaoEvento(this.config.getAmbiente());
        if (urlWebService == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para RecepcaoEvento " + parser.getModelo().name() + ", autorizador " + autorizacao.name());
        }
        
        final NfeResultMsg nfeRecepcaoEvento = new NFeRecepcaoEvento4Stub(urlWebService, config).nfeRecepcaoEvento(dados);
        final OMElement omElementResult = nfeRecepcaoEvento.getExtraElement();
        this.getLogger().debug(omElementResult.toString());
        return omElementResult;
    }
    
    /**
     * Retorna XML assinado para uso externo.
     */
    public String getXmlAssinado(final String chaveAcesso, final String textoCorrecao, final int numeroSequencialEvento) throws Exception {
        final String cartaCorrecaoXML = this.gerarDadosCartaCorrecao(chaveAcesso, textoCorrecao, numeroSequencialEvento).toString();
        return new DFAssinaturaDigital(this.config).assinarDocumento(cartaCorrecaoXML);
    }
    
    public NFEnviaEventoCartaCorrecao gerarDadosCartaCorrecao(final String chaveAcesso, final String textoCorrecao, final int numeroSequencialEvento) {
        final NotaFiscalChaveParser chaveParser = new NotaFiscalChaveParser(chaveAcesso);
        
        final NFTipoEvento cartaCorrecao = new NFTipoEvento();
        cartaCorrecao.setVersao(WSCartaCorrecao.VERSAO_LEIAUTE);
        cartaCorrecao.setDescricaoEvento(WSCartaCorrecao.EVENTO_DESCRICAO);
        cartaCorrecao.setCondicaoUso(WSCartaCorrecao.EVENTO_CONDICAO_USO);
        cartaCorrecao.setTextoCorrecao(textoCorrecao);
        
        final NFInfoEvento infoEvento = new NFInfoEvento();
        infoEvento.setAmbiente(this.config.getAmbiente());
        infoEvento.setDadosEvento(cartaCorrecao);
        infoEvento.setChave(chaveAcesso);
        if (Integer.parseInt(chaveParser.getSerie()) >= 920 && Integer.parseInt(chaveParser.getSerie()) <= 969) {//destinado a emissão de pessoa física com IE
            infoEvento.setCpf(chaveParser.getCnpjEmitente().substring(3));
        } else {
            infoEvento.setCnpj(chaveParser.getCnpjEmitente());
        }
        infoEvento.setDataHoraEvento(ZonedDateTime.now(this.config.getTimeZone().toZoneId()));
        infoEvento.setId(String.format("ID%s%s%02d", WSCartaCorrecao.EVENTO_CODIGO, chaveAcesso, numeroSequencialEvento));
        infoEvento.setNumeroSequencialEvento(numeroSequencialEvento);
        infoEvento.setOrgao(chaveParser.getNFUnidadeFederativa());
        infoEvento.setTipoEvento(WSCartaCorrecao.EVENTO_CODIGO);
        infoEvento.setVersaoEvento(WSCartaCorrecao.VERSAO_LEIAUTE);
        
        final NFEvento evento = new NFEvento();
        evento.setInfoEvento(infoEvento);
        evento.setVersao(WSCartaCorrecao.VERSAO_LEIAUTE);
        
        final NFEnviaEventoCartaCorrecao enviaEvento = new NFEnviaEventoCartaCorrecao();
        enviaEvento.setEvento(Collections.singletonList(evento));
        enviaEvento.setIdLote(Long.toString(ZonedDateTime.now(this.config.getTimeZone().toZoneId()).toInstant().toEpochMilli()));
        enviaEvento.setVersao(WSCartaCorrecao.VERSAO_LEIAUTE);
        return enviaEvento;
    }
}
