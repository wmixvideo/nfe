package com.fincatto.documentofiscal.nfe400.webservices;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Collections;

import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.NotaFiscalChaveParser;
import com.fincatto.documentofiscal.nfe400.classes.NFAutorizador400;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEnviaEventoRetorno;
import com.fincatto.documentofiscal.nfe400.classes.evento.conciliacaofinanceira.NFDetEventoCancelamentoEconf;
import com.fincatto.documentofiscal.nfe400.classes.evento.conciliacaofinanceira.NFEnviaEventoCancelamentoEconf;
import com.fincatto.documentofiscal.nfe400.classes.evento.conciliacaofinanceira.NFEventoCancelamentoEconf;
import com.fincatto.documentofiscal.nfe400.classes.evento.conciliacaofinanceira.NFInfoEventoCancelamentoEconf;
import com.fincatto.documentofiscal.nfe400.utils.ChaveAcessoUtils;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;

/**
 * Classe responsável por enviar o cancelamento do evento de Conciliação Financeira (ECONF), que desfaz um ECONF
 * já registrado na SEFAZ (NT 2024.002 v1.00).
 * O evento é recebido pela SVRS (cOrgao 92) e só é suportado para a NF-e (modelo 55).
 * Não guarda os dados do evento: chave, sequencial e protocolo do ECONF são recebidos a cada chamada,
 * então a mesma instância pode ser usada por várias threads ao mesmo tempo.
 */
class WSCancelamentoEconf {

    private static final BigDecimal VERSAO_LAYOUT = new BigDecimal("1.00");
    private static final String DESCRICAO_EVENTO = "Cancelamento Conciliação Financeira";
    private static final String CODIGO_EVENTO = "110751";
    private final NFeConfig config;
    private final DFHttpClient httpClient;

    /**
     * @param config Configuração da NF-e utilizada para a comunicação com o web service.
     * @param httpClient Cliente HTTP utilizado para enviar o evento à SEFAZ.
     */
    WSCancelamentoEconf(final NFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    /**
     * Gera, assina e envia o cancelamento da conciliação financeira para a SEFAZ.
     *
     * @param chaveAcesso Chave de acesso da NF-e (modelo 55) relacionada ao evento.
     * @param numeroSequencialEvento Número sequencial do evento (1 a 99).
     * @param protocoloEconf Número do protocolo de autorização do ECONF que será cancelado (15 dígitos).
     * @return {@link NFEnviaEventoRetorno} contendo a resposta do web service.
     * @throws IllegalArgumentException caso a chave não seja de uma NF-e modelo 55.
     * @throws Exception caso não consiga gerar ou assinar o XML, ou haja problema de conexão com a SEFAZ.
     */
    NFEnviaEventoRetorno enviaEvento(final String chaveAcesso, final int numeroSequencialEvento, final String protocoloEconf) throws Exception {
        final String cancelamentoEconfXml = this.gerarDadosXml(chaveAcesso, numeroSequencialEvento, protocoloEconf).toString();
        final String xmlAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(cancelamentoEconfXml);
        DFXMLValidador.validaCancelamentoEconf(xmlAssinado);
        final String xmlResultado = this.efetuaEnvio(xmlAssinado);
        return this.config.getPersister().read(NFEnviaEventoRetorno.class, xmlResultado);
    }

    /**
     * Envia o evento assinado à SVRS, conforme a NT para o modelo 55.
     *
     * @param xmlAssinado XML do evento assinado digitalmente.
     * @return XML de negócio da resposta do web service (já desempacotado do envelope SOAP).
     * @throws IOException caso não consiga se conectar à SEFAZ.
     * @throws DFSoapFaultException caso a SEFAZ devolva um soap:Fault.
     */
    private String efetuaEnvio(final String xmlAssinado) throws IOException, DFSoapFaultException {
        final String urlWebService = NFAutorizador400.SVRS.getRecepcaoEvento(this.config.getAmbiente());
        return AbstractWSEvento.enviarEvento(this.httpClient, urlWebService, xmlAssinado);
    }

    /**
     * Gera os dados XML do cancelamento da conciliação financeira.
     *
     * @param chaveAcesso Chave de acesso da NF-e (modelo 55) relacionada ao evento.
     * @param numeroSequencialEvento Número sequencial do evento (1 a 99).
     * @param protocoloEconf Número do protocolo de autorização do ECONF que será cancelado (15 dígitos).
     * @return {@link NFEnviaEventoCancelamentoEconf} com os dados do evento preenchidos.
     * @throws IllegalArgumentException caso a chave não seja de uma NF-e modelo 55.
     */
    NFEnviaEventoCancelamentoEconf gerarDadosXml(final String chaveAcesso, final int numeroSequencialEvento, final String protocoloEconf) {
        final NotaFiscalChaveParser chaveParser = new NotaFiscalChaveParser(chaveAcesso);
        if (!DFModelo.NFE.equals(chaveParser.getModelo())) {
            throw new IllegalArgumentException("O cancelamento do ECONF só é suportado para NF-e (modelo 55)");
        }

        final NFEventoCancelamentoEconf evento = new NFEventoCancelamentoEconf();
        evento.setInfoEvento(this.gerarInfoEvento(chaveParser, chaveAcesso, numeroSequencialEvento, this.gerarDetalhesEvento(protocoloEconf)));
        evento.setVersao(WSCancelamentoEconf.VERSAO_LAYOUT);

        final NFEnviaEventoCancelamentoEconf enviaEvento = new NFEnviaEventoCancelamentoEconf();
        enviaEvento.setEvento(Collections.singletonList(evento));
        enviaEvento.setIdLote(Long.toString(ZonedDateTime.now(this.config.getTimeZone().toZoneId()).toInstant().toEpochMilli()));
        enviaEvento.setVersao(WSCancelamentoEconf.VERSAO_LAYOUT);
        return enviaEvento;
    }

    /**
     * Gera o detalhamento do evento (detEvento), com a descrição, a versão e o protocolo do ECONF a cancelar.
     *
     * @param protocoloEconf Número do protocolo de autorização do ECONF que será cancelado (15 dígitos).
     * @return {@link NFDetEventoCancelamentoEconf} com os detalhes do evento preenchidos.
     */
    private NFDetEventoCancelamentoEconf gerarDetalhesEvento(final String protocoloEconf) {
        final NFDetEventoCancelamentoEconf detEvento = new NFDetEventoCancelamentoEconf();
        detEvento.setDescricaoEvento(WSCancelamentoEconf.DESCRICAO_EVENTO);
        detEvento.setVersao(WSCancelamentoEconf.VERSAO_LAYOUT);
        detEvento.setVersaoAplicativo(WSCancelamentoEconf.VERSAO_LAYOUT.toString());
        detEvento.setNumeroProtocoloEvento(protocoloEconf);
        return detEvento;
    }

    private NFInfoEventoCancelamentoEconf gerarInfoEvento(final NotaFiscalChaveParser chaveParser, final String chaveAcesso,
            final int numeroSequencialEvento, final NFDetEventoCancelamentoEconf detEvento) {
        final NFInfoEventoCancelamentoEconf infoEvento = new NFInfoEventoCancelamentoEconf();
        infoEvento.setAmbiente(this.config.getAmbiente());
        infoEvento.setChave(chaveAcesso);
        infoEvento.setCpf(chaveParser.getCpfEmitente());
        infoEvento.setCnpj(chaveParser.getCnpjEmitente());
        infoEvento.setDataHoraEvento(ZonedDateTime.now(this.config.getTimeZone().toZoneId()));
        infoEvento.setId(ChaveAcessoUtils.geraIDevento(chaveAcesso, WSCancelamentoEconf.CODIGO_EVENTO, numeroSequencialEvento));
        infoEvento.setNumeroSequencialEvento(numeroSequencialEvento);
        infoEvento.setOrgao(DFUnidadeFederativa.BRID);
        infoEvento.setCodigoEvento(WSCancelamentoEconf.CODIGO_EVENTO);
        infoEvento.setVersaoEvento(WSCancelamentoEconf.VERSAO_LAYOUT);
        infoEvento.setDetalhesEvento(detEvento);
        return infoEvento;
    }
}
