package com.fincatto.documentofiscal.nfe400.webservices;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.NotaFiscalChaveParser;
import com.fincatto.documentofiscal.nfe400.classes.NFAutorizador400;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEnviaEventoRetorno;
import com.fincatto.documentofiscal.nfe400.classes.evento.conciliacaofinanceira.NFDetEventoEconf;
import com.fincatto.documentofiscal.nfe400.classes.evento.conciliacaofinanceira.NFDetPagEconf;
import com.fincatto.documentofiscal.nfe400.classes.evento.conciliacaofinanceira.NFEnviaEventoEconf;
import com.fincatto.documentofiscal.nfe400.classes.evento.conciliacaofinanceira.NFEventoEconf;
import com.fincatto.documentofiscal.nfe400.classes.evento.conciliacaofinanceira.NFInfoEventoEconf;
import com.fincatto.documentofiscal.nfe400.utils.ChaveAcessoUtils;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;

/**
 * Classe responsável por enviar o evento de Conciliação Financeira (ECONF), que informa à SEFAZ os pagamentos
 * relacionados a uma NF-e (NT 2024.002 v1.00).
 * O evento é recebido pela SVRS (cOrgao 92) e só é suportado para a NF-e (modelo 55).
 * Não guarda os dados do evento: chave, sequencial e pagamentos são recebidos a cada chamada,
 * então a mesma instância pode ser usada por várias threads ao mesmo tempo.
 */
class WSEconf {

    private static final BigDecimal VERSAO_LAYOUT = new BigDecimal("1.00");
    private static final String DESCRICAO_EVENTO = "ECONF";
    private static final String CODIGO_EVENTO = "110750";
    private final NFeConfig config;
    private final DFHttpClient httpClient;

    /**
     * @param config Configuração da NF-e utilizada para a comunicação com o web service.
     * @param httpClient Cliente HTTP utilizado para enviar o evento à SEFAZ.
     */
    WSEconf(final NFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    /**
     * Gera, assina e envia o evento de conciliação financeira para a SEFAZ.
     *
     * @param chaveAcesso Chave de acesso da NF-e (modelo 55) relacionada ao evento.
     * @param numeroSequencialEvento Número sequencial do evento (1 a 99).
     * @param pagamentos Pagamentos a informar (1 a 100).
     * @return {@link NFEnviaEventoRetorno} contendo a resposta do web service.
     * @throws IllegalArgumentException caso a chave não seja de uma NF-e modelo 55.
     * @throws Exception caso não consiga gerar ou assinar o XML, ou haja problema de conexão com a SEFAZ.
     */
    NFEnviaEventoRetorno enviaEvento(final String chaveAcesso, final int numeroSequencialEvento, final List<NFDetPagEconf> pagamentos) throws Exception {
        final String econfXml = this.gerarDadosXml(chaveAcesso, numeroSequencialEvento, pagamentos).toString();
        final String xmlAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(econfXml);
        DFXMLValidador.validaEconf(xmlAssinado);
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
     * Gera os dados XML do evento de conciliação financeira.
     *
     * @param chaveAcesso Chave de acesso da NF-e (modelo 55) relacionada ao evento.
     * @param numeroSequencialEvento Número sequencial do evento (1 a 99).
     * @param pagamentos Pagamentos a informar (1 a 100).
     * @return {@link NFEnviaEventoEconf} com os dados do evento preenchidos.
     * @throws IllegalArgumentException caso a chave não seja de uma NF-e modelo 55.
     */
    NFEnviaEventoEconf gerarDadosXml(final String chaveAcesso, final int numeroSequencialEvento, final List<NFDetPagEconf> pagamentos) {
        final NotaFiscalChaveParser chaveParser = new NotaFiscalChaveParser(chaveAcesso);
        if (!DFModelo.NFE.equals(chaveParser.getModelo())) {
            throw new IllegalArgumentException("O ECONF só é suportado para NF-e (modelo 55)");
        }
        final NFEventoEconf evento = new NFEventoEconf();
        evento.setInfoEvento(this.gerarInfoEvento(chaveParser, chaveAcesso, numeroSequencialEvento, this.gerarDetalhesEvento(pagamentos)));
        evento.setVersao(WSEconf.VERSAO_LAYOUT);

        final NFEnviaEventoEconf enviaEvento = new NFEnviaEventoEconf();
        enviaEvento.setEvento(Collections.singletonList(evento));
        enviaEvento.setIdLote(Long.toString(ZonedDateTime.now(this.config.getTimeZone().toZoneId()).toInstant().toEpochMilli()));
        enviaEvento.setVersao(WSEconf.VERSAO_LAYOUT);
        return enviaEvento;
    }

    /**
     * Gera o detalhamento do evento (detEvento), com a descrição, a versão e os pagamentos.
     *
     * @param pagamentos Pagamentos a informar (1 a 100).
     * @return {@link NFDetEventoEconf} com os detalhes do evento preenchidos.
     */
    private NFDetEventoEconf gerarDetalhesEvento(final List<NFDetPagEconf> pagamentos) {
        final NFDetEventoEconf detEvento = new NFDetEventoEconf();
        detEvento.setDescricaoEvento(WSEconf.DESCRICAO_EVENTO);
        detEvento.setVersao(WSEconf.VERSAO_LAYOUT);
        detEvento.setVersaoAplicativo(WSEconf.VERSAO_LAYOUT.toString());
        detEvento.setPagamentos(pagamentos);
        return detEvento;
    }

    /**
     * Gera os dados do evento (infEvento). O órgão de recepção é sempre a SVRS (92), conforme a NT para o modelo 55.
     *
     * @param chaveParser Leitor da chave de acesso, usado para obter o CNPJ ou CPF do emitente.
     * @param chaveAcesso Chave de acesso da NF-e (modelo 55) relacionada ao evento.
     * @param numeroSequencialEvento Número sequencial do evento (1 a 99).
     * @param detEvento Detalhes específicos do evento.
     * @return {@link NFInfoEventoEconf} com os dados do evento preenchidos.
     */
    private NFInfoEventoEconf gerarInfoEvento(final NotaFiscalChaveParser chaveParser, final String chaveAcesso,
            final int numeroSequencialEvento, final NFDetEventoEconf detEvento) {
        final NFInfoEventoEconf infoEvento = new NFInfoEventoEconf();
        infoEvento.setAmbiente(this.config.getAmbiente());
        infoEvento.setChave(chaveAcesso);
        infoEvento.setCpf(chaveParser.getCpfEmitente());
        infoEvento.setCnpj(chaveParser.getCnpjEmitente());
        infoEvento.setDataHoraEvento(ZonedDateTime.now(this.config.getTimeZone().toZoneId()));
        infoEvento.setId(ChaveAcessoUtils.geraIDevento(chaveAcesso, WSEconf.CODIGO_EVENTO, numeroSequencialEvento));
        infoEvento.setNumeroSequencialEvento(numeroSequencialEvento);
        infoEvento.setOrgao(DFUnidadeFederativa.BRID);
        infoEvento.setCodigoEvento(WSEconf.CODIGO_EVENTO);
        infoEvento.setVersaoEvento(WSEconf.VERSAO_LAYOUT);
        infoEvento.setDetalhesEvento(detEvento);
        return infoEvento;
    }
}
