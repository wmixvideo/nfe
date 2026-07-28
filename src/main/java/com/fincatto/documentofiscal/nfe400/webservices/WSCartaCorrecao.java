package com.fincatto.documentofiscal.nfe400.webservices;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Collections;

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
import com.fincatto.documentofiscal.nfe400.utils.ChaveAcessoUtils;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;

class WSCartaCorrecao implements DFLog {

    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("1.00");
    private static final String EVENTO_CODIGO = "110110";
    private static final String EVENTO_DESCRICAO = "Carta de Correcao";
    private static final String EVENTO_CONDICAO_USO = "A Carta de Correcao e disciplinada pelo paragrafo 1o-A do art. 7o do Convenio S/N, de 15 de dezembro de 1970 e pode ser utilizada para regularizacao de erro ocorrido na emissao de documento fiscal, desde que o erro nao esteja relacionado com: I - as variaveis que determinam o valor do imposto tais como: base de calculo, aliquota, diferenca de preco, quantidade, valor da operacao ou da prestacao; II - a correcao de dados cadastrais que implique mudanca do remetente ou do destinatario; III - a data de emissao ou de saida.";
    private final NFeConfig config;
    private final DFHttpClient httpClient;

    WSCartaCorrecao(final NFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    NFEnviaEventoRetorno corrigeNota(final String chaveAcesso, final String textoCorrecao, final int numeroSequencialEvento) throws Exception {
        final String xmlAssinado = getXmlAssinado(chaveAcesso, textoCorrecao, numeroSequencialEvento);
        final String xmlResultado = this.efetuaCorrecao(xmlAssinado, chaveAcesso);
        return this.config.getPersister().read(NFEnviaEventoRetorno.class, xmlResultado);
    }

    NFEnviaEventoRetorno corrigeNotaAssinada(final String xmlAssinado) throws Exception {
        final NFEnviaEventoCartaCorrecao enviaEventoCartaCorrecao = this.config.getPersister().read(NFEnviaEventoCartaCorrecao.class, xmlAssinado);
        final String xmlResultado = this.efetuaCorrecao(xmlAssinado, enviaEventoCartaCorrecao.getEvento().get(0).getInfoEvento().getChave());
        return this.config.getPersister().read(NFEnviaEventoRetorno.class, xmlResultado);
    }

    NFProtocoloEventoCartaCorrecao corrigeNotaAssinadaProtocolo(final String xmlAssinado) throws Exception {
        final NFEnviaEventoCartaCorrecao evento = this.config.getPersister().read(NFEnviaEventoCartaCorrecao.class, xmlAssinado);
        final String xmlResultado = this.efetuaCorrecao(xmlAssinado, evento.getEvento().get(0).getInfoEvento().getChave());

        final NFEnviaEventoRetorno retorno = this.config.getPersister().read(NFEnviaEventoRetorno.class, xmlResultado);

        final NFProtocoloEventoCartaCorrecao nfProtocoloEventoCartaCorrecao = new NFProtocoloEventoCartaCorrecao();
        nfProtocoloEventoCartaCorrecao.setEvento(evento.getEvento().get(0));
        nfProtocoloEventoCartaCorrecao.setEventoRetorno(retorno.getEventoRetorno().get(0));
        return nfProtocoloEventoCartaCorrecao;
    }

    NFEnviaEventoRetorno corrigeNotaAssinada(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        final String xmlResultado = this.efetuaCorrecao(eventoAssinadoXml, chaveAcesso);
        return this.config.getPersister().read(NFEnviaEventoRetorno.class, xmlResultado);
    }

    /**
     * Envia o evento de carta de correcao assinado para a SEFAZ e devolve o XML de negocio da
     * resposta. A resolucao de endpoint (por UF do emitente, com bifurcacao NFe/NFCe) e
     * especifica desta classe; o envio em si (montagem do envelope SOAP, HTTP, desempacotamento)
     * e compartilhado com todos os demais servicos de evento via
     * {@link AbstractWSEvento#enviarEvento} - ver o spec da migracao para o racional de nao unificar
     * via heranca (a assinatura publica desta classe nao se encaixa no padrao de
     * AbstractWSEvento).
     */
    private String efetuaCorrecao(final String xmlAssinado, final String chaveAcesso) throws IOException, DFSoapFaultException {
        final NotaFiscalChaveParser parser = new NotaFiscalChaveParser(chaveAcesso);

        final NFAutorizador400 autorizacao = NFAutorizador400.valueOfCodigoUF(this.config.getCUF());
        final String urlWebService = DFModelo.NFCE.equals(parser.getModelo()) ? autorizacao.getNfceRecepcaoEvento(this.config.getAmbiente()) : autorizacao.getRecepcaoEvento(this.config.getAmbiente());
        if (urlWebService == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para RecepcaoEvento " + parser.getModelo().name() + ", autorizador " + autorizacao.name());
        }

        return AbstractWSEvento.enviarEvento(this.httpClient, urlWebService, xmlAssinado);
    }

    /**
     * Retorna XML assinado para uso externo.
     */
    public String getXmlAssinado(final String chaveAcesso, final String textoCorrecao, final int numeroSequencialEvento) throws Exception {
        final String cartaCorrecaoXML = this.gerarDadosCartaCorrecao(chaveAcesso, textoCorrecao, numeroSequencialEvento).toString();
        return new DFAssinaturaDigital(this.config).assinarDocumento(cartaCorrecaoXML);
    }

    public NFEnviaEventoCartaCorrecao gerarDadosCartaCorrecao(final String chaveAcesso, final String textoCorrecao, final int numeroSequencialEvento) {
        final NFTipoEvento cartaCorrecao = new NFTipoEvento();
        cartaCorrecao.setVersao(WSCartaCorrecao.VERSAO_LEIAUTE);
        cartaCorrecao.setDescricaoEvento(WSCartaCorrecao.EVENTO_DESCRICAO);
        cartaCorrecao.setCondicaoUso(WSCartaCorrecao.EVENTO_CONDICAO_USO);
        cartaCorrecao.setTextoCorrecao(textoCorrecao);

        final NotaFiscalChaveParser chaveParser = new NotaFiscalChaveParser(chaveAcesso);
        final NFInfoEvento infoEvento = new NFInfoEvento();
        infoEvento.setAmbiente(this.config.getAmbiente());
        infoEvento.setDadosEvento(cartaCorrecao);
        infoEvento.setChave(chaveAcesso);
        infoEvento.setCpf(chaveParser.getCpfEmitente());
        infoEvento.setCnpj(chaveParser.getCnpjEmitente());
        infoEvento.setDataHoraEvento(ZonedDateTime.now(this.config.getTimeZone().toZoneId()));
        infoEvento.setId(ChaveAcessoUtils.geraIDevento(chaveAcesso, WSCartaCorrecao.EVENTO_CODIGO, numeroSequencialEvento));
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
