package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe.classes.distribuicao.NFDistribuicaoIntRetorno;
import com.fincatto.documentofiscal.nfe.webservices.distribuicao.WSDistribuicaoNFe;
import com.fincatto.documentofiscal.nfe400.classes.cadastro.NFRetornoConsultaCadastro;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEnviaEventoRetorno;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEventoTipoAutor;
import com.fincatto.documentofiscal.nfe400.classes.evento.alczfmimportacao.NFDetGrupoConsumoZFM;
import com.fincatto.documentofiscal.nfe400.classes.evento.apropriacaobens.NFDetGrupoCredito;
import com.fincatto.documentofiscal.nfe400.classes.evento.apropriacaocomb.NFDetGrupoConsumoCombustivel;
import com.fincatto.documentofiscal.nfe400.classes.evento.apropriacaocredito.NFDetGrupoCreditoPresumido;
import com.fincatto.documentofiscal.nfe400.classes.evento.cartacorrecao.NFProtocoloEventoCartaCorrecao;
import com.fincatto.documentofiscal.nfe400.classes.evento.consumopessoal.NFDetGrupoConsumo;
import com.fincatto.documentofiscal.nfe400.classes.evento.epec.NFEnviaEventoEpecRetorno;
import com.fincatto.documentofiscal.nfe400.classes.evento.imobilizacao.NFDetGrupoImobilizacao;
import com.fincatto.documentofiscal.nfe400.classes.evento.inutilizacao.NFRetornoEventoInutilizacao;
import com.fincatto.documentofiscal.nfe400.classes.evento.manifestacaodestinatario.NFProtocoloEventoManifestacaoDestinatario;
import com.fincatto.documentofiscal.nfe400.classes.evento.manifestacaodestinatario.NFTipoEventoManifestacaoDestinatario;
import com.fincatto.documentofiscal.nfe400.classes.evento.naofornecido.NFDetGrupoItemNaoFornecido;
import com.fincatto.documentofiscal.nfe400.classes.evento.roubo.NFDetGrupoPerecimento;
import com.fincatto.documentofiscal.nfe400.classes.evento.roubo.NFDetGrupoPerecimentoFornecedor;
import com.fincatto.documentofiscal.nfe400.classes.lote.consulta.NFLoteConsultaRetorno;
import com.fincatto.documentofiscal.nfe400.classes.lote.envio.*;
import com.fincatto.documentofiscal.nfe400.classes.nota.consulta.NFNotaConsultaRetorno;
import com.fincatto.documentofiscal.nfe400.classes.statusservico.consulta.NFStatusServicoConsultaRetorno;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;
import com.fincatto.documentofiscal.utils.DFSocketFactory;

import java.io.Closeable;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.time.LocalDate;
import java.util.List;

/**
 * Ponto de entrada publico para todos os webservices de NF-e/NFC-e 4.00 (envio/consulta de
 * lote, status, consulta de nota e cadastro, e a longa lista de eventos - cancelamento, carta
 * de correcao, EPEC, manifestacao do destinatario, atualizacao de data de previsao de entrega,
 * aceite de debito de apuracao, imobilizacao, insucesso/comprovante de entrega, entre outros).
 * A maioria dos eventos compartilha a mecanica de transporte de {@link AbstractWSEvento}.
 * <p>
 * Uma instancia deve ser criada uma vez por {@link com.fincatto.documentofiscal.nfe.NFeConfig}/
 * certificado e reaproveitada entre chamadas - nao recriada por documento fiscal emitido. Cada
 * instancia mantem um pool de conexoes HTTP proprio e uma thread de fundo (daemon) para
 * descartar conexoes ociosas; recriar {@link WSFacade} por documento acumula pools e threads
 * sem chamar {@link #close()} entre eles.
 */
public class WSFacade implements Closeable {

    private final NFeConfig config;
    private final DFHttpClient httpClient;
    private volatile WSLoteEnvio wsLoteEnvio;
    private volatile WSLoteConsulta wsLoteConsulta;
    private volatile WSStatusConsulta wsStatusConsulta;
    private volatile WSNotaConsulta wsNotaConsulta;
    private volatile WSCartaCorrecao wsCartaCorrecao;
    private volatile WSCancelamento wsCancelamento;
    private volatile WSConsultaCadastro wsConsultaCadastro;
    private volatile WSInutilizacao wsInutilizacao;
    private volatile WSManifestacaoDestinatario wSManifestacaoDestinatario;
    private volatile WSDistribuicaoNFe wSDistribuicaoNFe;
    private volatile WSEpec wsEpec;
    private volatile WSAtualizacaoDataPrevisaoEntrega wsAtualizacaoDataPrevisaoEntrega;
    private volatile WSAceiteDebitoApuracao wsAceiteDebitoAPuracao;
    private volatile WSCancelametoEvento wsCancelametoEvento;
    private volatile WSInfoEfetPagIntegral wsInfoEfetPagIntegral;
    private volatile WSSolicitacaoApropriacaoCreditoPresumido wsSolicitacaoApropriacaoCreditoPresumido;
    private volatile WSSolicitacaoApropriacaoCreditoCombustivel wsSolicitacaoApropriacaoCreditoCombustivel;
    private volatile WSRouboTransporteAdquirente wsRouboTransporteAdquirente;
    private volatile WSSolicitacaoApropriacaoCreditoBensAtdAdquirinte wsSolicitacaoApropriacaoCreditoBensAtdAdquirinte;
    private volatile WSRouboTransporteFornecedor wsRouboTransporteFornecedor;
    private volatile WSNaoFornecimentoPagamentoAntecipado wsNaoFornecimentoPagamentoAntecipado;
    private volatile WSDestinacaoItemConsumoPessoal wsDestinacaoItemConsumoPessoal;
    private volatile WSImobilizacaoItem wsImobilizacaoItem;
    private volatile WSImportacaoALCZFMNaoConvertidaIsencao wsImportacaoALCZFMNaoConvertidaIsencao;

    public WSFacade(final NFeConfig config) throws KeyManagementException, UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException {
        this.config = config;
        this.httpClient = new DFHttpClient(new DFSocketFactory(config).getSslContext(), config);
    }

    @Override
    public void close() throws IOException {
        if(this.httpClient != null){
            this.httpClient.close();
        }
    }

    /**
     * Faz o envio de lote para a Sefaz.
     *
     * @param lote o lote a ser enviado para a Sefaz
     * @param validarXML - boolean indicando se deve haver validação XSD com o XML a ser enviado
     * @return dados do lote retornado pelo webservice, alem do lote assinado
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
     * o sefaz
     */
    public NFLoteEnvioRetornoDados enviaLote(final NFLoteEnvio lote, boolean validarXML) throws Exception {
        if (lote.getIndicadorProcessamento().equals(NFLoteIndicadorProcessamento.PROCESSAMENTO_SINCRONO) && lote.getNotas().size() > 1) {
            throw new IllegalArgumentException("Apenas uma nota permitida no modo sincrono!");
        } else if (lote.getNotas().isEmpty()) {
            throw new IllegalArgumentException("Nenhuma nota informada no envio do Lote!");
        }
        if (this.wsLoteEnvio == null) {
            this.wsLoteEnvio = new WSLoteEnvio(this.config, this.httpClient);
        }
        return this.wsLoteEnvio.enviaLote(lote, validarXML);
    }
    
    public NFLoteEnvioRetornoDados enviaLote(final NFLoteEnvio lote) throws Exception {
        return enviaLote(lote, true);
    }

    public NFLoteEnvio getLoteAssinado(final NFLoteEnvio lote) throws Exception {
        if (this.wsLoteEnvio == null) {
            this.wsLoteEnvio = new WSLoteEnvio(this.config, this.httpClient);
        }
        return this.wsLoteEnvio.getLoteAssinado(lote);
    }

    /**
     * Faz o envio assinado para a Sefaz de NF-e e NFC-e ATENCAO: Esse metodo
     * deve ser utilizado para assinaturas A3.
     *
     * @param loteAssinadoXml lote assinado no formato XML
     * @param modelo modelo da nota (NF-e ou NFC-e)
     * @return dados do lote retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
     * o sefaz
     */
    public NFLoteEnvioRetorno enviaLoteAssinado(final String loteAssinadoXml, final DFModelo modelo) throws Exception {
        if (this.wsLoteEnvio == null) {
            this.wsLoteEnvio = new WSLoteEnvio(this.config, this.httpClient);
        }
        return this.wsLoteEnvio.enviaLoteAssinado(loteAssinadoXml, modelo);
    }

    /**
     * Faz o envio assinado para a Sefaz de NF-e e NFC-e ATENCAO: Esse metodo
     * deve ser utilizado para assinaturas A3. Retorna resultado bruto da
     * receita, para processamento posterior.
     *
     * @param loteAssinadoXml lote assinado no formato XML
     * @param modelo modelo da nota (NF-e ou NFC-e)
     * @return dados do lote retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
     * o sefaz
     */
    public String getNfeResultMsg(final String loteAssinadoXml, final DFModelo modelo) throws Exception {
        if (this.wsLoteEnvio == null) {
            this.wsLoteEnvio = new WSLoteEnvio(this.config, this.httpClient);
        }
        return this.wsLoteEnvio.efetuaComunicacaoLote(loteAssinadoXml, modelo, true);
    }

    /**
     * Faz a consulta do lote na Sefaz (NF-e e NFC-e).
     *
     * @param numeroRecibo numero do recibo do processamento
     * @param modelo modelo da nota (NF-e ou NFC-e)
     * @return dados de consulta de lote retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
     * o sefaz
     */
    public NFLoteConsultaRetorno consultaLote(final String numeroRecibo, final DFModelo modelo) throws Exception {
        if (this.wsLoteConsulta == null) {
            this.wsLoteConsulta = new WSLoteConsulta(this.config, this.httpClient);
        }
        return this.wsLoteConsulta.consultaLote(numeroRecibo, modelo);
    }

    /**
     * Faz a consulta de status responsavel pela UF.
     *
     * @param uf uf UF que deseja consultar o status do sefaz responsavel
     * @param modelo modelo da nota (NF-e ou NFC-e)
     * @return dados da consulta de status retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
     * o sefaz
     */
    public NFStatusServicoConsultaRetorno consultaStatus(final DFUnidadeFederativa uf, final DFModelo modelo) throws Exception {
        if (this.wsStatusConsulta == null) {
            this.wsStatusConsulta = new WSStatusConsulta(this.config, this.httpClient);
        }
        return this.wsStatusConsulta.consultaStatus(uf, modelo);
    }

    /**
     * Faz a consulta da nota.
     *
     * @param chaveDeAcesso chave de acesso da nota
     * @return dados da consulta da nota retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
     * o sefaz
     */
    public NFNotaConsultaRetorno consultaNota(final String chaveDeAcesso) throws Exception {
        if (this.wsNotaConsulta == null) {
            this.wsNotaConsulta = new WSNotaConsulta(this.config, this.httpClient);
        }
        return this.wsNotaConsulta.consultaNota(chaveDeAcesso);
    }

    /**
     * Faz a consulta da nota.(Retorno como string)
     *
     * @param chaveDeAcesso chave de acesso da nota
     * @return dados da consulta da nota retornado pelo webservice
     * @throws IOException caso nao consiga se conectar a SEFAZ.
     * @throws DFSoapFaultException caso a SEFAZ devolva um soap:Fault.
     */
    public String consultaNotaAsString(final String chaveDeAcesso) throws IOException, DFSoapFaultException {
        if (this.wsNotaConsulta == null) {
            this.wsNotaConsulta = new WSNotaConsulta(this.config, this.httpClient);
        }
        return this.wsNotaConsulta.consultaNotaAsString(chaveDeAcesso);
    }

    /**
     * Faz a correcao da nota.
     *
     * @param chaveDeAcesso chave de acesso da nota
     * @param textoCorrecao texto de correcao
     * @param numeroSequencialEvento numero sequencial de evento, esse numero
     * nao pode ser repetido!
     * @return dados da correcao da nota retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
     * o sefaz
     */
    public NFEnviaEventoRetorno corrigeNota(final String chaveDeAcesso, final String textoCorrecao, final int numeroSequencialEvento) throws Exception {
        if (this.wsCartaCorrecao == null) {
            this.wsCartaCorrecao = new WSCartaCorrecao(this.config, this.httpClient);
        }
        return this.wsCartaCorrecao.corrigeNota(chaveDeAcesso, textoCorrecao, numeroSequencialEvento);
    }

    /**
     * Faz a correcao da nota com o evento ja assinado ATENCAO: Esse metodo deve
     * ser utilizado para assinaturas A3.
     *
     * @param chave chave de acesso da nota
     * @param eventoAssinadoXml evento ja assinado em formato XML
     * @return dados da correcao da nota retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
     * o sefaz
     */
    public NFEnviaEventoRetorno corrigeNotaAssinada(final String chave, final String eventoAssinadoXml) throws Exception {
        if (this.wsCartaCorrecao == null) {
            this.wsCartaCorrecao = new WSCartaCorrecao(this.config, this.httpClient);
        }
        return this.wsCartaCorrecao.corrigeNotaAssinada(chave, eventoAssinadoXml);
    }

    /**
     * Faz a correcao da nota com o evento ja assinado.
     *
     * @param eventoAssinadoXml evento ja assinado em formato XML
     * @return dados da correcao da nota retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
     * o sefaz
     */
    public NFEnviaEventoRetorno corrigeNotaAssinada(final String eventoAssinadoXml) throws Exception {
        if (this.wsCartaCorrecao == null) {
            this.wsCartaCorrecao = new WSCartaCorrecao(this.config, this.httpClient);
        }
        return this.wsCartaCorrecao.corrigeNotaAssinada(eventoAssinadoXml);
    }

    public NFProtocoloEventoCartaCorrecao corrigeNotaAssinadaProtocolo(final String eventoAssinadoXml) throws Exception {
        if (this.wsCartaCorrecao == null) {
            this.wsCartaCorrecao = new WSCartaCorrecao(this.config, this.httpClient);
        }
        return this.wsCartaCorrecao.corrigeNotaAssinadaProtocolo(eventoAssinadoXml);
    }

    public NFProtocoloEventoCartaCorrecao corrigeNotaAssinadaProtocolo(final String chaveDeAcesso, final String textoCorrecao, final int numeroSequencialEvento) throws Exception {
        if (this.wsCartaCorrecao == null) {
            this.wsCartaCorrecao = new WSCartaCorrecao(this.config, this.httpClient);
        }
        return this.wsCartaCorrecao.corrigeNotaAssinadaProtocolo(getXmlAssinado(chaveDeAcesso, textoCorrecao, numeroSequencialEvento));
    }

    public String getXmlAssinado(final String chaveDeAcesso, final String textoCorrecao, final int numeroSequencialEvento) throws Exception {
        if (this.wsCartaCorrecao == null) {
            this.wsCartaCorrecao = new WSCartaCorrecao(this.config, this.httpClient);
        }
        return this.wsCartaCorrecao.getXmlAssinado(chaveDeAcesso, textoCorrecao, numeroSequencialEvento);
    }

    /**
     * Faz o cancelamento da nota. com sequencial fixo 1
     *
     * @param chave chave de acesso da nota
     * @param numeroProtocolo numero do protocolo da nota
     * @param motivo motivo do cancelamento
     * @return dados do cancelamento da nota retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
     * o sefaz
     */
    public NFCancelamentoRetornoDados cancelaNota(final String chave, final String numeroProtocolo, final String motivo) throws Exception {
        if (this.wsCancelamento == null) {
            this.wsCancelamento = new WSCancelamento(this.config, this.httpClient);
        }
        return this.wsCancelamento.cancelaNota(chave, numeroProtocolo, motivo, 1);
    }

    /**
     * Faz o cancelamento da nota. Com opção de passar o numero sequencial do evento
     *
     * @param chave chave de acesso da nota
     * @param numeroProtocolo numero do protocolo da nota
     * @param motivo motivo do cancelamento
     * @param numeroSequencial numero sequencial do evento informado
     * @return dados do cancelamento da nota retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
     * o sefaz
     */
    public NFCancelamentoRetornoDados cancelaNota(final String chave, final String numeroProtocolo, final String motivo, final int numeroSequencial) throws Exception {
        if (this.wsCancelamento == null) {
            this.wsCancelamento = new WSCancelamento(this.config, this.httpClient);
        }
        return this.wsCancelamento.cancelaNota(chave, numeroProtocolo, motivo, numeroSequencial);
    }

    /**
     * Faz o cancelamento da nota com evento ja assinado ATENCAO: Esse metodo
     * deve ser utilizado para assinaturas A3.
     *
     * @param chave chave de acesso da nota
     * @param eventoAssinadoXml evento ja assinado em formato XML
     * @return dados do cancelamento da nota retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
     * o sefaz
     */
    public NFEnviaEventoRetorno cancelaNotaAssinada(final String chave, final String eventoAssinadoXml) throws Exception {
        if (this.wsCancelamento == null) {
            this.wsCancelamento = new WSCancelamento(this.config, this.httpClient);
        }
        return this.wsCancelamento.cancelaNotaAssinada(chave, eventoAssinadoXml);
    }
    
    /**
     * Faz o cancelamento da nota por substituicao, evento permitido para NFCe.
     *
     * @param chave chave de acesso da nota
     * @param numeroProtocolo numero do protocolo da nota
     * @param motivo motivo do cancelamento
     * @param versaoAplicativoAutorizador versao do aplicativo autorizador do evento
     * @param chaveSubstituta chave de acesso da nota substituta
     * @return dados do cancelamento da nota retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
     * o sefaz
     */
    public NFEnviaEventoRetorno cancelaNotaPorSubstituicao(final String chave, final String numeroProtocolo, final String motivo, final String versaoAplicativoAutorizador, final String chaveSubstituta) throws Exception {
        if (this.wsCancelamento == null) {
            this.wsCancelamento = new WSCancelamento(this.config, this.httpClient);
        }
        return this.wsCancelamento.cancelaNotaPorSubstituicao(chave, numeroProtocolo, motivo, versaoAplicativoAutorizador, chaveSubstituta);
    }

    /**
     * Inutiliza a nota com o evento assinado ATENCAO: Esse metodo deve ser
     * utilizado para assinaturas A3.
     *
     * @param eventoAssinadoXml evento assinado em XML
     * @param modelo modelo da nota (NF-e ou NFC-e)
     * @return dados da inutilizacao da nota retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
     * o sefaz
     */
    public NFRetornoEventoInutilizacao inutilizaNotaAssinada(final String eventoAssinadoXml, final DFModelo modelo) throws Exception {
        if (this.wsInutilizacao == null) {
            this.wsInutilizacao = new WSInutilizacao(this.config, this.httpClient);
        }
        return this.wsInutilizacao.inutilizaNotaAssinada(eventoAssinadoXml, modelo);
    }

    /**
     * Inutiliza a nota.
     *
     * @param anoInutilizacaoNumeracao ano de inutilizacao
     * @param cnpjEmitente CNPJ emitente da nota
     * @param serie serie da nota
     * @param numeroInicial numero inicial da nota
     * @param numeroFinal numero final da nota
     * @param justificativa justificativa da inutilizacao
     * @param modelo modelo da nota (NF-e ou NFC-e)
     * @return dados da inutilizacao da nota retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
     * o sefaz
     */
    public NFRetornoEventoInutilizacao inutilizaNota(final int anoInutilizacaoNumeracao, final String cnpjEmitente, final String serie, final String numeroInicial, final String numeroFinal, final String justificativa, final DFModelo modelo) throws Exception {
        if (this.wsInutilizacao == null) {
            this.wsInutilizacao = new WSInutilizacao(this.config, this.httpClient);
        }
        return this.wsInutilizacao.inutilizaNota(anoInutilizacaoNumeracao, cnpjEmitente, serie, numeroInicial, numeroFinal, justificativa, modelo);
    }

    /**
     * Realiza a consulta de cadastro de pessoa juridica com inscricao estadual.
     *
     * @param cnpj CNPJ da pessoa juridica
     * @param uf UF da pessoa juridica
     * @return dados da consulta da pessoa juridica retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
     * o sefaz
     */
    public NFRetornoConsultaCadastro consultaCadastro(final String cnpj, final DFUnidadeFederativa uf) throws Exception {
        if (this.wsConsultaCadastro == null) {
            this.wsConsultaCadastro = new WSConsultaCadastro(this.config, this.httpClient);
        }
        return this.wsConsultaCadastro.consultaCadastro(cnpj, uf);
    }

    /**
     * Faz a manifestação do destinatário da nota.
     *
     * @param chave chave de acesso da nota
     * @param tipoEvento tipo do evento da manifestacao do destinatario
     * @param motivo motivo do cancelamento
     * @param cnpj cnpj do autor do evento
     * @return dados da manifestacao do destinatario da nota retornado pelo
     * webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
     * o sefaz
     */
    public NFEnviaEventoRetorno manifestaDestinatarioNota(final String chave, final NFTipoEventoManifestacaoDestinatario tipoEvento, final String motivo, final String cnpj) throws Exception {
        if (this.wSManifestacaoDestinatario == null) {
            this.wSManifestacaoDestinatario = new WSManifestacaoDestinatario(this.config, this.httpClient);
        }
        return this.wSManifestacaoDestinatario.manifestaDestinatarioNota(chave, tipoEvento, motivo, cnpj);
    }

    public NFProtocoloEventoManifestacaoDestinatario manifestaDestinatarioNotaProtocolo(final String chave, final NFTipoEventoManifestacaoDestinatario tipoEvento, final String motivo, final String cnpj) throws Exception {
        if (this.wSManifestacaoDestinatario == null) {
            this.wSManifestacaoDestinatario = new WSManifestacaoDestinatario(this.config, this.httpClient);
        }
        return this.wSManifestacaoDestinatario.manifestaDestinatarioNotaProtocolo(chave, tipoEvento, motivo, cnpj);
    }

    /**
     * Faz a manifestação do destinatário da nota com evento ja assinado
     * ATENCAO: Esse metodo deve ser utilizado para assinaturas A3.
     *
     * @param chave chave de acesso da nota
     * @param eventoAssinadoXml evento ja assinado em formato XML
     * @return dados da manifestacao do destinatario da nota retornado pelo
     * webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
     * o sefaz
     */
    public NFEnviaEventoRetorno manifestaDestinatarioNotaAssinada(final String chave, final String eventoAssinadoXml) throws Exception {
        if (this.wSManifestacaoDestinatario == null) {
            this.wSManifestacaoDestinatario = new WSManifestacaoDestinatario(this.config, this.httpClient);
        }
        return this.wSManifestacaoDestinatario.manifestaDestinatarioNotaAssinada(chave, eventoAssinadoXml);
    }

    /**
     * Faz consulta de distribuicao das notas fiscais.Pode ser feita pela chave
     * de acesso ou utilizando o NSU (numero sequencial unico) da receita.
     *
     * @param cpfOuCnpj CPF ou CNPJ da pessoa fisica ou juridica a consultar
     * @param uf Unidade federativa da pessoa juridica a consultar
     * @param chaveAcesso
     * @param nsu Número Sequencial Único. Geralmente esta consulta será
     * utilizada quando identificado pelo interessado um NSU faltante. O Web
     * Service retornará o documento ou informará que o NSU não existe no
     * Ambiente Nacional. Assim, esta consulta fechará a lacuna do NSU
     * identificado como faltante.
     * @param ultNsu Último NSU recebido pelo ator. Caso seja informado com
     * zero, ou com um NSU muito antigo, a consulta retornará unicamente as
     * informações resumidas e documentos fiscais eletrônicos que tenham sido
     * recepcionados pelo Ambiente Nacional nos últimos 3 meses.
     * @return dados da consulta retornado pelo webservice limitando um total de
     * 50 registros
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
     * o sefaz
     */
    public NFDistribuicaoIntRetorno consultarDistribuicaoDFe(final String cpfOuCnpj, final DFUnidadeFederativa uf, final String chaveAcesso, final String nsu, final String ultNsu) throws Exception {
        if (this.wSDistribuicaoNFe == null) {
            this.wSDistribuicaoNFe = new WSDistribuicaoNFe(this.config, this.httpClient);
        }
        return this.wSDistribuicaoNFe.consultar(cpfOuCnpj, uf, chaveAcesso, nsu, ultNsu);
    }

    /**
     * Faz o envio de lote já enviado em EPEC para a Sefaz
     *
     * @param lote o lote a ser enviado para a Sefaz
     * @return dados do lote retornado pelo webservice, alem do lote assinado
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
     * o sefaz
     */
    public NFEnviaEventoEpecRetorno enviaLoteEpec(final NFLoteEnvio lote) throws Exception {
        if (this.wsEpec == null) {
            this.wsEpec = new WSEpec(this.config, this.httpClient);
        }
        return this.wsEpec.enviaEpec(lote);
    }

    /**
     * Faz o envio do epec como evento para o ambiente nacional
     *
     * @param lote
     * @return dados do epec retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
     * o ambiente nacional da sefaz
     */
    public NFEnviaEventoEpecRetorno enviaEpec(final NFLoteEnvio lote) throws Exception {
        if (this.wsEpec == null) {
            this.wsEpec = new WSEpec(this.config, this.httpClient);
        }
        return this.wsEpec.enviaEpec(lote);
    }

    /**
     * Faz o envio assinado para o ambiente nacional da Sefaz
     *
     * @param epecAssinadoXml
     * @return dados do epec retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
     * o ambiente nacional da sefaz
     */
    public NFEnviaEventoEpecRetorno enviaEpecAssinado(final String epecAssinadoXml) throws Exception {
        if (this.wsEpec == null) {
            this.wsEpec = new WSEpec(this.config, this.httpClient);
        }
        return this.wsEpec.enviaEpecAssinado(epecAssinadoXml);
    }

    public NFEnviaEventoRetorno enviaAtualizacaoDataPrevisaoEntrega(final String chaveAcesso, final LocalDate dataPrevisaoEntrega, final DFUnidadeFederativa ufAutorEvento, final NFEventoTipoAutor tpAutorEvento, final int numeroSequencialEvento) throws Exception {
        if (this.wsAtualizacaoDataPrevisaoEntrega == null) {
            this.wsAtualizacaoDataPrevisaoEntrega = new WSAtualizacaoDataPrevisaoEntrega(this.config, this.httpClient);
        }
        return this.wsAtualizacaoDataPrevisaoEntrega.atualizaDataPrevisaoEntrega(chaveAcesso, dataPrevisaoEntrega, ufAutorEvento, tpAutorEvento, numeroSequencialEvento);
    }

    public NFEnviaEventoRetorno aceiteDebitoApuracao(final String chaveAcesso, final int indAceitacao, final DFUnidadeFederativa ufEmitenteEvento, final int numeroSequencialEvento, final String cnpjCpfAutorEvento) throws Exception {
        if (this.wsAceiteDebitoAPuracao == null) {
            this.wsAceiteDebitoAPuracao = new WSAceiteDebitoApuracao(this.config, this.httpClient);
        }
        return this.wsAceiteDebitoAPuracao.aceiteDebitoApuracao(chaveAcesso, indAceitacao, ufEmitenteEvento, numeroSequencialEvento, cnpjCpfAutorEvento);
    }

    public NFEnviaEventoRetorno cancelamentoEvento(
            final String chaveAcesso, final String codigoEventoAutorizado, final String numeroProtocoloEvento,
            final int numeroSequencialEventoCancelar, final DFUnidadeFederativa ufEmitenteEvento, final String cnpjCpfAutorEvento
    ) throws Exception {
        if (this.wsCancelametoEvento == null) {
            this.wsCancelametoEvento = new WSCancelametoEvento(this.config, this.httpClient);
        }
        return this.wsCancelametoEvento.cancelamentoEvento(
                chaveAcesso, codigoEventoAutorizado, numeroProtocoloEvento, numeroSequencialEventoCancelar,
                ufEmitenteEvento, cnpjCpfAutorEvento
        );
    }

    /**
     * Gera XML e faz envio do evento de informação de efetivo pagamento integral para liberar credito presumido do
     * adquirente.
     *
     * @param chaveAcesso chave de acesso da NF
     * @param ufEmitenteEvento UF do emitente do evento
     * @param numeroSequencialEvento número sequencial do evento
     * @return {@link NFEnviaEventoRetorno} dados do evento retornado pelo webservice
     *
     * @throws Exception
     */
    public NFEnviaEventoRetorno enviaInformacaoEfetivoPagamentoIntegral(
            final String chaveAcesso, final DFUnidadeFederativa ufEmitenteEvento, final int numeroSequencialEvento
    ) throws Exception {
        if (this.wsInfoEfetPagIntegral == null) {
            this.wsInfoEfetPagIntegral = new WSInfoEfetPagIntegral(this.config, this.httpClient);
        }
        return this.wsInfoEfetPagIntegral
                .adicionarDadosEvento(chaveAcesso, ufEmitenteEvento, numeroSequencialEvento)
                .gerarEnviarEvento();
    }

    /**
     * Gera XML e faz envio do evento de solicitação de apropriação de crédito presumido.
     *
     * @param chaveAcesso chave de acesso da NF
     * @param gruposCreditoPresumido Lista de grupos do crédito presumido
     * @param numeroSequencialEvento número sequencial do evento
     * @param cnpjCpfAutorEvento  CNPJ ou CPF do autor do evento sem formatação.
     * @return {@link NFEnviaEventoRetorno} dados do evento retornado pelo webservice
     * @throws Exception
     */
    public NFEnviaEventoRetorno enviaSolicitacaoApropriacaoCreditoPresumido(
            final String chaveAcesso, final DFUnidadeFederativa ufEmitenteEvento,
            final List<NFDetGrupoCreditoPresumido> gruposCreditoPresumido, final int numeroSequencialEvento,
            final String cnpjCpfAutorEvento, final NFEventoTipoAutor tpAutorEvento
    ) throws Exception {
        if (this.wsSolicitacaoApropriacaoCreditoPresumido == null) {
            this.wsSolicitacaoApropriacaoCreditoPresumido = new WSSolicitacaoApropriacaoCreditoPresumido(this.config, this.httpClient);
        }
        return this.wsSolicitacaoApropriacaoCreditoPresumido
                .adicionarDadosEvento(chaveAcesso, ufEmitenteEvento, gruposCreditoPresumido, numeroSequencialEvento, cnpjCpfAutorEvento, tpAutorEvento)
                .gerarEnviarEvento();
    }
    /**
     * Gera XML e faz envio do evento de Perecimento, perda, roubo ou furto durante o transporte contratado pelo adquirente.
     *
     * @param chaveAcesso chave de acesso da NF
     * @param gruposPerecimento Lista de grupos de perecimento, perda, roubo ou furto
     * @param numeroSequencialEvento número sequencial do evento
     * @param cnpjCpfAutorEvento CNPJ ou CPF do autor do evento sem formatação.
     * @return {@link NFEnviaEventoRetorno} dados do evento retornado pelo webservice
     * @throws Exception
     */
    public NFEnviaEventoRetorno enviaPerdaRouboTransporteAdquirente(
            final String chaveAcesso, final DFUnidadeFederativa ufEmitenteEvento,
            final List<NFDetGrupoPerecimento> gruposPerecimento, final int numeroSequencialEvento,
            final String cnpjCpfAutorEvento
    ) throws Exception {
        if (this.wsRouboTransporteAdquirente == null) {
            this.wsRouboTransporteAdquirente = new WSRouboTransporteAdquirente(this.config, this.httpClient);
        }
        return this.wsRouboTransporteAdquirente
                .adicionarDadosEvento(chaveAcesso, ufEmitenteEvento, gruposPerecimento, numeroSequencialEvento, cnpjCpfAutorEvento)
                .gerarEnviarEvento();
    }

    /**
     * Gera XML e faz envio do evento de Perecimento, perda, roubo ou furto durante o transporte contratado pelo fornecedor.
     *
     * @param chaveAcesso chave de acesso da NF
     * @param gruposPerecimento Lista de grupos de perecimento, perda, roubo ou furto
     * @param numeroSequencialEvento número sequencial do evento
     * @return {@link NFEnviaEventoRetorno} dados do evento retornado pelo webservice
     * @throws Exception
     */
    public NFEnviaEventoRetorno enviaPerdaRouboTransporteFornecedor(
            final String chaveAcesso, final DFUnidadeFederativa ufEmitenteEvento,
            final List<NFDetGrupoPerecimentoFornecedor> gruposPerecimento, final int numeroSequencialEvento
    ) throws Exception {
        if (this.wsRouboTransporteFornecedor == null) {
            this.wsRouboTransporteFornecedor = new WSRouboTransporteFornecedor(this.config, this.httpClient);
        }
        return this.wsRouboTransporteFornecedor
                .adicionarDadosEvento(chaveAcesso, ufEmitenteEvento, gruposPerecimento, numeroSequencialEvento)
                .gerarEnviarEvento();
    }

    /**
     * Gera XML e faz envio do evento de solicitação de apropriação de crédito combustível
     *
     * @param chaveAcesso chave de acesso da NF
     * @param grupoConsumoCombustivel Lista de grupos de consumo de combustível
     * @param numeroSequencialEvento número sequencial do evento
     * @param cnpjCpfAutorEvento CNPJ ou CPF do autor do evento sem formatação.
     * @return {@link NFEnviaEventoRetorno} dados do evento retornado pelo webservice
     * @throws Exception
     */
    public NFEnviaEventoRetorno enviaSolicitacaoApropriacaoCreditoCombustivel(
            final String chaveAcesso, final DFUnidadeFederativa ufEmitenteEvento,
            final List<NFDetGrupoConsumoCombustivel> grupoConsumoCombustivel, final int numeroSequencialEvento,
            final String cnpjCpfAutorEvento
    ) throws Exception {
        if (this.wsSolicitacaoApropriacaoCreditoCombustivel == null) {
            this.wsSolicitacaoApropriacaoCreditoCombustivel = new WSSolicitacaoApropriacaoCreditoCombustivel(this.config, this.httpClient);
        }
        return this.wsSolicitacaoApropriacaoCreditoCombustivel
                .adicionarDadosEvento(chaveAcesso, ufEmitenteEvento, grupoConsumoCombustivel, numeroSequencialEvento, cnpjCpfAutorEvento)
                .gerarEnviarEvento();
    }

    /**
     * Gera XML e faz envio do evento de Solicitação de Apropriação de Crédito para bens e serviços que dependem de atividade do adquirente Destinatário
     *
     * @param chaveAcesso chave de acesso da NF
     * @param gruposCredito Lista de grupos de grupo de crédito
     * @param numeroSequencialEvento número sequencial do evento
     * @param cnpjCpfAutorEvento CNPJ ou CPF do autor do evento sem formatação.
     * @return {@link NFEnviaEventoRetorno} dados do evento retornado pelo webservice
     * @throws Exception
     */
    public NFEnviaEventoRetorno enviaSolicitacaoApropriacaoCreditoBensAtividadeAdquirente(
            final String chaveAcesso, final DFUnidadeFederativa ufEmitenteEvento,
            final List<NFDetGrupoCredito> gruposCredito, final int numeroSequencialEvento, final String cnpjCpfAutorEvento
    ) throws Exception {
        if (this.wsSolicitacaoApropriacaoCreditoBensAtdAdquirinte == null) {
            this.wsSolicitacaoApropriacaoCreditoBensAtdAdquirinte = new WSSolicitacaoApropriacaoCreditoBensAtdAdquirinte(this.config, this.httpClient);
        }
        return this.wsSolicitacaoApropriacaoCreditoBensAtdAdquirinte
                .adicionarDadosEvento(chaveAcesso, ufEmitenteEvento, gruposCredito, numeroSequencialEvento, cnpjCpfAutorEvento)
                .gerarEnviarEvento();
    }
    /**
     * Gera XML e faz envio do evento de Fornecimento não realizado com pagamento antecipado.
     *
     * @param chaveAcesso chave de acesso da NF
     * @param gruposItemNaoFornecedo Lista de grupos de grupo de itens não fornecidos
     * @param numeroSequencialEvento número sequencial do evento
     * @return {@link NFEnviaEventoRetorno} dados do evento retornado pelo webservice
     * @throws Exception
     */
    public NFEnviaEventoRetorno enviaNaoFornecimentoPagamentoAntecipado(
            final String chaveAcesso, final DFUnidadeFederativa ufEmitenteEvento,
            final List<NFDetGrupoItemNaoFornecido> gruposItemNaoFornecedo, final int numeroSequencialEvento
    ) throws Exception {
        if (this.wsNaoFornecimentoPagamentoAntecipado == null) {
            this.wsNaoFornecimentoPagamentoAntecipado = new WSNaoFornecimentoPagamentoAntecipado(this.config, this.httpClient);
        }
        return this.wsNaoFornecimentoPagamentoAntecipado
                .adicionarDadosEvento(chaveAcesso, ufEmitenteEvento, gruposItemNaoFornecedo, numeroSequencialEvento)
                .gerarEnviarEvento();
    }

    /**
     * Gera XML e faz envio do evento de Destinação de itens para consumo pessoal.
     *
     * @param chaveAcesso chave de acesso da NF
     * @param grupoItensConsumo Lista de grupos de grupo de itens para consumo pessoal
     * @param numeroSequencialEvento número sequencial do evento
     * @param tpAutorEvento tipo do autor do evento (emitente ou destinatario)
     * @param cnpjCpfAutorEvento cnpj ou cpf do autor do evento sem formatação.
     * @return {@link NFEnviaEventoRetorno} dados do evento retornado pelo webservice
     * @throws Exception
     */
    @Deprecated(since = "Evento removido em razão da revogação do § 6º do art. 57. da Lei Complementar nº 214/2025 pela Lei Complementar nº 227/2026", forRemoval = true)
    public NFEnviaEventoRetorno enviaDestinacaoItemConsumoPessoal(
            final String chaveAcesso, final DFUnidadeFederativa ufEmitenteEvento, final List<NFDetGrupoConsumo> grupoItensConsumo,
            final int numeroSequencialEvento, final NFEventoTipoAutor tpAutorEvento, final String cnpjCpfAutorEvento
    ) throws Exception {
        if (this.wsDestinacaoItemConsumoPessoal == null) {
            this.wsDestinacaoItemConsumoPessoal = new WSDestinacaoItemConsumoPessoal(this.config, this.httpClient);
        }
        return this.wsDestinacaoItemConsumoPessoal
                .adicionarDadosEvento(chaveAcesso, ufEmitenteEvento, grupoItensConsumo, numeroSequencialEvento, tpAutorEvento, cnpjCpfAutorEvento)
                .gerarEnviarEvento();
    }

    /**
     * Gera XML e faz envio do evento de Imobilizacao de item.
     *
     * @param chaveAcesso chave de acesso da NF
     * @param gruposImobilizacao Lista de grupos de grupo de itens imobilizacao
     * @param numeroSequencialEvento número sequencial do evento
     * @param cnpjCpfAutorEvento CNPJ ou CPF do autor do evento sem formatação.
     * @return {@link NFEnviaEventoRetorno} dados do evento retornado pelo webservice
     * @throws Exception
     */
    public NFEnviaEventoRetorno enviaImobilizacaoItem(
            final String chaveAcesso, final DFUnidadeFederativa ufEmitenteEvento, final List<NFDetGrupoImobilizacao> gruposImobilizacao,
            final int numeroSequencialEvento, final String cnpjCpfAutorEvento
    ) throws Exception {
        if (this.wsImobilizacaoItem == null) {
            this.wsImobilizacaoItem = new WSImobilizacaoItem(this.config, this.httpClient);
        }
        return this.wsImobilizacaoItem
                .adicionarDadosEvento(chaveAcesso, ufEmitenteEvento, gruposImobilizacao, numeroSequencialEvento, cnpjCpfAutorEvento)
                .gerarEnviarEvento();
    }
    /**
     * Gera XML e faz envio do evento de Impotação em ALC/ZFM não convertida em isenção.
     *
     * @param chaveAcesso chave de acesso da NF
     * @param gruposImobilizacao Lista de grupos de grupo de itens consumo em ALC/ZFM não convertida em isenção
     * @param numeroSequencialEvento número sequencial do evento
     * @return {@link NFEnviaEventoRetorno} dados do evento retornado pelo webservice
     * @throws Exception
     */
    public NFEnviaEventoRetorno enviaImportacaoALCZFMNaoConvertidaEmIsencao(
            final String chaveAcesso, final DFUnidadeFederativa ufEmitenteEvento, final List<NFDetGrupoConsumoZFM> gruposImobilizacao,
            final int numeroSequencialEvento
    ) throws Exception {
        if (this.wsImportacaoALCZFMNaoConvertidaIsencao == null) {
            this.wsImportacaoALCZFMNaoConvertidaIsencao = new WSImportacaoALCZFMNaoConvertidaIsencao(this.config, this.httpClient);
        }
        return this.wsImportacaoALCZFMNaoConvertidaIsencao
                .adicionarDadosEvento(chaveAcesso, ufEmitenteEvento, gruposImobilizacao, numeroSequencialEvento)
                .gerarEnviarEvento();
    }
}
