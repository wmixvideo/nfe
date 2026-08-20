package com.fincatto.documentofiscal.mdfe3.webservices;

import java.io.Closeable;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.time.LocalDate;
import java.util.List;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.mdfe.classes.distribuicao.MDFeDistribuicaoIntRetorno;
import com.fincatto.documentofiscal.mdfe.webservices.distribuicao.WSDistribuicaoMDFe;
import com.fincatto.documentofiscal.mdfe3.MDFeConfig;
import com.fincatto.documentofiscal.mdfe3.classes.consultaRecibo.MDFeConsultaReciboRetorno;
import com.fincatto.documentofiscal.mdfe3.classes.consultanaoencerrados.MDFeConsultaNaoEncerradosRetorno;
import com.fincatto.documentofiscal.mdfe3.classes.consultastatusservico.MDFeConsStatServRet;
import com.fincatto.documentofiscal.mdfe3.classes.lote.envio.MDFEnvioLote;
import com.fincatto.documentofiscal.mdfe3.classes.lote.envio.MDFEnvioLoteRetornoDados;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoModalRodoviarioInfPag;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoModalRodoviarioInfViagens;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFe;
import com.fincatto.documentofiscal.mdfe3.classes.nota.consulta.MDFeNotaConsultaRetorno;
import com.fincatto.documentofiscal.mdfe3.classes.nota.envio.MDFEnvioRetornoDados;
import com.fincatto.documentofiscal.mdfe3.classes.nota.evento.MDFeEnviaEventoIncluirDFeInfDoc;
import com.fincatto.documentofiscal.mdfe3.classes.nota.evento.MDFeRetorno;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSocketFactory;

/**
 * Ponto de entrada publico para todos os webservices de MDF-e 3.00 (status, consulta - recibo e
 * nao encerrados -, recepcao de lote/sincrona, eventos - cancelamento, encerramento, inclusao
 * de condutor/DF-e, pagamento de transporte - e distribuicao de DF-e). As 5 classes de evento
 * compartilham a mecanica de envio via {@link WSTransporteEvento}. Todos os servicos ja
 * migrados de Axis2 para {@code httpclient5}; ver {@link #close()} para o descarte dos pools de
 * conexao mantidos por esta instancia.
 */
public class WSFacade implements Closeable {

    private final DFHttpClient httpClient;
    private final WSStatusConsulta wsStatusConsulta;
    private final WSRecepcaoLote wsRecepcaoLote;
    private final WSRecepcaoSinc wsRecepcaoSinc;
    private final WSNotaConsulta wsNotaConsulta;
    private final WSCancelamento wsCancelamento;
    private final WSEncerramento wsEncerramento;
    private final WSConsultaRecibo wsConsultaRecibo;
    private final WSConsultaNaoEncerrados wsConsultaNaoEncerrados;
    private final WSIncluirCondutor wsIncluirCondutor;
    private final WSIncluirDFe wsIncluirDFe;
    private final WSPagamentoTransporte wsPagamentoTransporte;
    private final WSDistribuicaoMDFe wsDistribuicaoMDFe;

//	private final WSRecepcaoLoteRetorno wsRecepcaoLoteRetorno;
    public WSFacade(final MDFeConfig config) throws KeyManagementException, UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException {
        // DFSocketFactory e usado apenas para montar o SSLContext do certificado A1: o
        // Protocol.registerProtocol que existia aqui antes mutava um registro estatico global
        // (org.apache.commons.httpclient.protocol.Protocol), compartilhado por todos os facades
        // da lib - cada instancia criada sobrescrevia o certificado usado por instancias
        // concorrentes de outros modulos. Removido: cada servico deste facade agora usa o
        // DFHttpClient injetado (httpclient5), que carrega seu proprio SSLContext.
        final DFSocketFactory socketFactory = new DFSocketFactory(config);
        this.httpClient = new DFHttpClient(socketFactory.getSslContext(), config);

        this.wsStatusConsulta = new WSStatusConsulta(config, this.httpClient);
        this.wsRecepcaoLote = new WSRecepcaoLote(config, this.httpClient);
        this.wsRecepcaoSinc = new WSRecepcaoSinc(config, this.httpClient);
//        this.wsRecepcaoLoteRetorno = new WSRecepcaoLoteRetorno(config);
        this.wsNotaConsulta = new WSNotaConsulta(config, this.httpClient);
        this.wsCancelamento = new WSCancelamento(config, this.httpClient);
        this.wsEncerramento = new WSEncerramento(config, this.httpClient);
        this.wsConsultaRecibo = new WSConsultaRecibo(config, this.httpClient);
        this.wsConsultaNaoEncerrados = new WSConsultaNaoEncerrados(config, this.httpClient);
        this.wsIncluirCondutor = new WSIncluirCondutor(config, this.httpClient);
        this.wsIncluirDFe = new WSIncluirDFe(config, this.httpClient);
        this.wsPagamentoTransporte = new WSPagamentoTransporte(config, this.httpClient);
        this.wsDistribuicaoMDFe = new WSDistribuicaoMDFe(config);
    }

    /**
     * Libera o pool de conexoes HTTP compartilhado entre os servicos deste facade ja migrados
     * para {@code httpclient5}, e tambem o {@link com.fincatto.documentofiscal.utils.DFHttpClient}
     * proprio de {@link com.fincatto.documentofiscal.mdfe.webservices.distribuicao.WSDistribuicaoMDFe}
     * - que nao compartilha o pool acima, mas tambem ja esta em {@code httpclient5}. Chamar
     * quando esta instancia de {@link WSFacade} nao for mais utilizada.
     * <p>
     * Os dois pools sao fechados via try-with-resources: se o primeiro {@code close()} lancar
     * excecao, o segundo ainda assim e chamado (evitando vazar a conexao dele), e a excecao do
     * segundo - se houver - e anexada como suprimida a excecao do primeiro.
     *
     * @throws IOException caso ocorra falha ao liberar as conexoes.
     */
    @Override
    @SuppressWarnings("try") // corpo intencionalmente vazio: o try-with-resources fecha os dois recursos so pelo efeito colateral do close() implicito
    public void close() throws IOException {
        try (WSDistribuicaoMDFe wsDistribuicaoMDFeFechavel = this.wsDistribuicaoMDFe; DFHttpClient httpClientFechavel = this.httpClient) {
            // corpo vazio: o try-with-resources fecha os dois recursos, na ordem inversa da
            // declaracao (httpClient primeiro, depois wsDistribuicaoMDFe), mesmo que um deles lance excecao
        }
    }

    /**
     * Serviços Assincronos serão desativados na data de 30 de Junho de 2024 conforme versa a NT 2024.001.
     *
     * Faz o envio do lote para a SEFAZ
     *
     * @param mdfEnvioLote a ser eviado para a SEFAZ
     * @return dados do retorno do envio do lote e o xml assinado
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
     * o sefaz
     *
     */
    @Deprecated
    public MDFEnvioLoteRetornoDados envioRecepcaoLote(MDFEnvioLote mdfEnvioLote) throws Exception {
        return this.wsRecepcaoLote.envioRecepcao(mdfEnvioLote);
    }

    /**
     * Faz o envio sincronizado para a SEFAZ
     *
     * @param mdfEnvio a ser eviado para a SEFAZ
     * @return dados do retorno do envio do MDFE e o xml assinado
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
     * o sefaz
     *
     */
    public MDFEnvioRetornoDados envioRecepcaoSinc(MDFe mdfEnvio) throws Exception {
        return this.wsRecepcaoSinc.envioRecepcaoSinc(mdfEnvio);
    }

    /**
     * Faz o envio sincronizado para a SEFAZ com o evento já assinado
     *
     * @param mdfEnvioAssinado a ser eviado para a SEFAZ
     * @return dados do retorno do envio do MDFE e o xml assinado
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
     * o sefaz
     *
     */
    public MDFEnvioRetornoDados envioRecepcaoSincAssinado(final String mdfEnvioAssinado) throws Exception {
        return this.wsRecepcaoSinc.envioRecepcaoSincAssinado(mdfEnvioAssinado);
    }

    /**
     * Faz a consulta de status responsavel pela UF, no caso apenas o RS está
     * disponível
     *
     * @param uf uf UF que deseja consultar o status do sefaz responsavel
     * @return dados da consulta de status retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
     * o sefaz
     */
    public MDFeConsStatServRet consultaStatus(final DFUnidadeFederativa uf) throws Exception {
        return this.wsStatusConsulta.consultaStatus(uf);
    }

    /**
     * @see #consultaStatus(DFUnidadeFederativa)
     * @return
     * @throws Exception
     */
    public MDFeConsStatServRet consultaStatus() throws Exception {
        return this.wsStatusConsulta.consultaStatus(DFUnidadeFederativa.RS);
    }

    /**
     * Faz a consulta do MDF-e
     *
     * @param chaveDeAcesso chave de acesso do MDF-e
     * @return dados da consulta da nota retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
     * o sefaz
     */
    public MDFeNotaConsultaRetorno consultaMdfe(final String chaveDeAcesso) throws Exception {
        return this.wsNotaConsulta.consultaNota(chaveDeAcesso);
    }

    /**
     * Faz o cancelamento do MDFe
     *
     * @param chave chave de acesso da nota
     * @param numeroProtocolo numero do protocolo da nota
     * @param motivo motivo do cancelamento
     * @return dados do cancelamento da nota retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
     * o sefaz
     */
    public MDFeRetorno cancelaMdfe(final String chave, final String numeroProtocolo, final String motivo) throws Exception {
        return this.wsCancelamento.cancelaNota(chave, numeroProtocolo, motivo);
    }

    /**
     * Faz o cancelamento da nota com evento ja assinado ATENCAO: Esse metodo
     * deve ser utilizado para assinaturas A3
     *
     * @param chave chave de acesso da nota
     * @param eventoAssinadoXml evento ja assinado em formato XML
     * @return dados do cancelamento da nota retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
     * o sefaz
     */
    public MDFeRetorno cancelaMdfeAssinado(final String chave, final String eventoAssinadoXml) throws Exception {
        return this.wsCancelamento.cancelaNotaAssinada(chave, eventoAssinadoXml);
    }

    /**
     * Faz o encerramento do MDFe
     *
     * @param chaveAcesso chave de acesso da nota
     * @param numeroProtocolo numero do protocolo da nota
     * @param codigoMunicipio Informar o código do município do encerramento do
     * manifesto
     * @param dataEncerramento Data em que o manifesto foi encerrado.
     * @param unidadeFederativa Informar a UF de encerramento do manifesto
     * @return dados do encerramento da nota retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
     * o sefaz
     */
    public MDFeRetorno encerramento(final String chaveAcesso, final String numeroProtocolo,
            final String codigoMunicipio, final LocalDate dataEncerramento, final DFUnidadeFederativa unidadeFederativa) throws Exception {
        return this.wsEncerramento.encerraMdfe(chaveAcesso, numeroProtocolo, codigoMunicipio, dataEncerramento, unidadeFederativa);
    }

    /**
     * Faz o encerramento do MDFe assinado
     *
     * @param chaveAcesso
     * @param eventoAssinadoXml
     * @return
     * @throws Exception
     */
    public MDFeRetorno encerramentoAssinado(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        return this.wsEncerramento.encerramentoMdfeAssinado(chaveAcesso, eventoAssinadoXml);
    }

    /**
     * Faz a consulta do recibo do MDF-e
     *
     * @param numeroRecibo recibo do processamento do arquivo MDF-e
     * @return dados da consulta da nota retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
     * o sefaz
     */
    public MDFeConsultaReciboRetorno consultaRecibo(final String numeroRecibo) throws Exception {
        return this.wsConsultaRecibo.consultaRecibo(numeroRecibo);
    }

    /**
     * Faz a consulta do recibo do MDF-e
     *
     * @param cnpj CNPJ do Emitente do MDF-e
     * @return Retorno de Pedido de Consulta MDF-e não Encerrados
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
     * o sefaz
     */
    public MDFeConsultaNaoEncerradosRetorno consultaNaoEncerrados(final String cnpj) throws Exception {
        return this.wsConsultaNaoEncerrados.consultaNaoEncerrados(cnpj);
    }

    /**
     * Faz a inclusão de condutor do veículo de MDF-e Rodoviário.
     *
     * @param chaveAcesso
     * @param nomeCondutor
     * @param cpfCondutor
     * @return
     * @throws Exception
     */
    public MDFeRetorno incluirCondutor(final String chaveAcesso, final String nomeCondutor, final String cpfCondutor) throws Exception {
        return this.wsIncluirCondutor.incluirCondutor(chaveAcesso, nomeCondutor, cpfCondutor);
    }

    /**
     * Faz a inclusão de condutor do veículo de MDF-e Rodoviário evento assinado
     *
     * @param chaveAcesso
     * @param eventoAssinadoXml
     * @return
     * @throws Exception
     */
    public MDFeRetorno incluirCondutorAssinado(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        return this.wsIncluirCondutor.incluirCondutorAssinado(chaveAcesso, eventoAssinadoXml);
    }

    /**
     * Faz a inclusão de DF-e no MDF-e Rodoviário.
     *
     * @param chaveAcesso chave de acesso do MDF-e
     * @param nProt numero do protocolo de autorizacao do MDF-e
     * @param cMunCarrega codigo do municipio de carregamento
     * @param xMunCarrega nome do municipio de carregamento
     * @param infDoc lista de documentos fiscais a incluir
     * @return dados da inclusao de DF-e retornados pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public MDFeRetorno incluirDFe(final String chaveAcesso, final String nProt, final String cMunCarrega, final String xMunCarrega, final List<MDFeEnviaEventoIncluirDFeInfDoc> infDoc) throws Exception {
        return this.wsIncluirDFe.incluirDFe(chaveAcesso, nProt, cMunCarrega, xMunCarrega, infDoc);
    }

    /**
     * Faz a inclusão de DF-e no MDF-e Rodoviário evento assinado
     *
     * @param chaveAcesso
     * @param eventoAssinadoXml
     * @return
     * @throws Exception
     */
    public MDFeRetorno incluirDFeAssinado(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        return this.wsIncluirDFe.incluirDFeAssinado(chaveAcesso, eventoAssinadoXml);
    }

    /**
     * Faz o evento de Pagamento da Operação de Transporte.
     *
     * @param chaveAcesso
     * @param nProt
     * @param infPag
     * @param infViagens
     * @return
     * @throws Exception
     */
    public MDFeRetorno pagamentoTransporte(final String chaveAcesso, final String nProt, final List<MDFInfoModalRodoviarioInfPag> infPag, final List<MDFInfoModalRodoviarioInfViagens> infViagens) throws Exception {
        return this.wsPagamentoTransporte.pagamento(chaveAcesso, nProt, infPag, infViagens);
    }

    /**
     * Faz o evento de Pagamento da Operação de Transporte assinado.
     *
     * @param chaveAcesso
     * @param eventoAssinadoXml
     * @return
     * @throws Exception
     */
    public MDFeRetorno pagamentoTransporteAssinado(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        return this.wsPagamentoTransporte.pagamentoAssinado(chaveAcesso, eventoAssinadoXml);
    }

    /**
     * Faz consulta de distribuicao dos MDFe.
     *
     * @param cpfOuCnpj
     * @param uf
     * @param nsu
     * @param ultNsu
     * @return
     * @throws Exception
     */
    public MDFeDistribuicaoIntRetorno consultarDistribuicaoMDFe(final String cpfOuCnpj, final DFUnidadeFederativa uf, final String nsu, final String ultNsu) throws Exception {
        return this.wsDistribuicaoMDFe.consultar(cpfOuCnpj, uf, nsu, ultNsu);
    }

}
