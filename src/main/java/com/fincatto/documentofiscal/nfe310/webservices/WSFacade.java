package com.fincatto.documentofiscal.nfe310.webservices;

import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe.classes.distribuicao.NFDistribuicaoIntRetorno;
import com.fincatto.documentofiscal.nfe.webservices.distribuicao.WSDistribuicaoNFe;
import com.fincatto.documentofiscal.nfe310.classes.cadastro.NFRetornoConsultaCadastro;
import com.fincatto.documentofiscal.nfe310.classes.evento.NFEnviaEventoRetorno;
import com.fincatto.documentofiscal.nfe310.classes.evento.downloadnf.NFDownloadNFeRetorno;
import com.fincatto.documentofiscal.nfe310.classes.evento.inutilizacao.NFRetornoEventoInutilizacao;
import com.fincatto.documentofiscal.nfe310.classes.evento.manifestacaodestinatario.NFTipoEventoManifestacaoDestinatario;
import com.fincatto.documentofiscal.nfe310.classes.lote.consulta.NFLoteConsultaRetorno;
import com.fincatto.documentofiscal.nfe310.classes.lote.envio.NFLoteEnvio;
import com.fincatto.documentofiscal.nfe310.classes.lote.envio.NFLoteEnvioRetorno;
import com.fincatto.documentofiscal.nfe310.classes.lote.envio.NFLoteEnvioRetornoDados;
import com.fincatto.documentofiscal.nfe310.classes.lote.envio.NFLoteIndicadorProcessamento;
import com.fincatto.documentofiscal.nfe310.classes.nota.consulta.NFNotaConsultaRetorno;
import com.fincatto.documentofiscal.nfe310.classes.statusservico.consulta.NFStatusServicoConsultaRetorno;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSocketFactory;

import java.io.Closeable;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

/**
 * Ponto de entrada publico para todos os webservices de NF-e/NFC-e 3.10 (envio/consulta de
 * lote, status, consulta de nota e cadastro, download, eventos - cancelamento, carta de
 * correcao, inutilizacao, manifestacao do destinatario - e distribuicao de DF-e). Ao contrario
 * do mdfe3, as 4 classes de evento nao foram unificadas num helper compartilhado: cada uma
 * resolve endpoint/cabecalho de forma genuinamente diferente. Status e consulta de nota tem
 * ainda um caminho separado para a Bahia (WSDL proprio).
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
    private volatile WSNotaDownload wsNotaDownload;
    private volatile WSDistribuicaoNFe wSDistribuicaoNFe;

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
     * Faz o envio de lote para a Sefaz
     * @param lote o lote a ser enviado para a Sefaz
     * @return dados do lote retornado pelo webservice, alem do lote assinado
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public NFLoteEnvioRetornoDados enviaLote(final NFLoteEnvio lote) throws Exception {
        if (lote.getIndicadorProcessamento().equals(NFLoteIndicadorProcessamento.PROCESSAMENTO_SINCRONO) && lote.getNotas().size() > 1) {
            throw new IllegalArgumentException("Apenas uma nota permitida no modo sincrono!");
        } else if (lote.getNotas().size() == 0) {
            throw new IllegalArgumentException("Nenhuma nota informada no envio do Lote!");
        }
        if (this.wsLoteEnvio == null) {
            this.wsLoteEnvio = new WSLoteEnvio(this.config, this.httpClient);
        }
        return this.wsLoteEnvio.enviaLote(lote);
    }

    public NFLoteEnvio getLoteAssinado(final NFLoteEnvio lote) throws Exception {
        if (this.wsLoteEnvio == null) {
            this.wsLoteEnvio = new WSLoteEnvio(this.config, this.httpClient);
        }
        return this.wsLoteEnvio.getLoteAssinado(lote);
    }

    /**
     * Faz o envio assinado para a Sefaz de NF-e e NFC-e ATENCAO: Esse metodo deve ser utilizado para assinaturas A3
     * @param loteAssinadoXml lote assinado no formato XML
     * @param modelo modelo da nota (NF-e ou NFC-e)
     * @return dados do lote retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public NFLoteEnvioRetorno enviaLoteAssinado(final String loteAssinadoXml, final DFModelo modelo) throws Exception {
        if (this.wsLoteEnvio == null) {
            this.wsLoteEnvio = new WSLoteEnvio(this.config, this.httpClient);
        }
        return this.wsLoteEnvio.enviaLoteAssinado(loteAssinadoXml, modelo);
    }

    /**
     * Faz a consulta do lote na Sefaz (NF-e e NFC-e)
     * @param numeroRecibo numero do recibo do processamento
     * @param modelo modelo da nota (NF-e ou NFC-e)
     * @return dados de consulta de lote retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public NFLoteConsultaRetorno consultaLote(final String numeroRecibo, final DFModelo modelo) throws Exception {
        if (this.wsLoteConsulta == null) {
            this.wsLoteConsulta = new WSLoteConsulta(this.config, this.httpClient);
        }
        return this.wsLoteConsulta.consultaLote(numeroRecibo, modelo);
    }

    /**
     * Faz a consulta de status responsavel pela UF
     * @param uf uf UF que deseja consultar o status do sefaz responsavel
     * @param modelo modelo da nota (NF-e ou NFC-e)
     * @return dados da consulta de status retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public NFStatusServicoConsultaRetorno consultaStatus(final DFUnidadeFederativa uf, final DFModelo modelo) throws Exception {
        if (this.wsStatusConsulta == null) {
            this.wsStatusConsulta = new WSStatusConsulta(this.config, this.httpClient);
        }
        return this.wsStatusConsulta.consultaStatus(uf, modelo);
    }

    /**
     * Faz a consulta da nota
     * @param chaveDeAcesso chave de acesso da nota
     * @return dados da consulta da nota retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public NFNotaConsultaRetorno consultaNota(final String chaveDeAcesso) throws Exception {
        if (this.wsNotaConsulta == null) {
            this.wsNotaConsulta = new WSNotaConsulta(this.config, this.httpClient);
        }
        return this.wsNotaConsulta.consultaNota(chaveDeAcesso);
    }

    /**
     * Faz a correcao da nota
     * @param chaveDeAcesso chave de acesso da nota
     * @param textoCorrecao texto de correcao
     * @param numeroSequencialEvento numero sequencial de evento, esse numero nao pode ser repetido!
     * @return dados da correcao da nota retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public NFEnviaEventoRetorno corrigeNota(final String chaveDeAcesso, final String textoCorrecao, final int numeroSequencialEvento) throws Exception {
        if (this.wsCartaCorrecao == null) {
            this.wsCartaCorrecao = new WSCartaCorrecao(this.config, this.httpClient);
        }
        return this.wsCartaCorrecao.corrigeNota(chaveDeAcesso, textoCorrecao, numeroSequencialEvento);
    }

    /**
     * Faz a correcao da nota com o evento ja assinado ATENCAO: Esse metodo deve ser utilizado para assinaturas A3
     * @param chave chave de acesso da nota
     * @param eventoAssinadoXml evento ja assinado em formato XML
     * @return dados da correcao da nota retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public NFEnviaEventoRetorno corrigeNotaAssinada(final String chave, final String eventoAssinadoXml) throws Exception {
        if (this.wsCartaCorrecao == null) {
            this.wsCartaCorrecao = new WSCartaCorrecao(this.config, this.httpClient);
        }
        return this.wsCartaCorrecao.corrigeNotaAssinada(chave, eventoAssinadoXml);
    }

    /**
     * Faz o cancelamento da nota
     * @param chave chave de acesso da nota
     * @param numeroProtocolo numero do protocolo da nota
     * @param motivo motivo do cancelamento
     * @return dados do cancelamento da nota retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public NFEnviaEventoRetorno cancelaNota(final String chave, final String numeroProtocolo, final String motivo) throws Exception {
        if (this.wsCancelamento == null) {
            this.wsCancelamento = new WSCancelamento(this.config, this.httpClient);
        }
        return this.wsCancelamento.cancelaNota(chave, numeroProtocolo, motivo);
    }

    /**
     * Faz o cancelamento da nota com evento ja assinado ATENCAO: Esse metodo deve ser utilizado para assinaturas A3
     * @param chave chave de acesso da nota
     * @param eventoAssinadoXml evento ja assinado em formato XML
     * @return dados do cancelamento da nota retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public NFEnviaEventoRetorno cancelaNotaAssinada(final String chave, final String eventoAssinadoXml) throws Exception {
        if (this.wsCancelamento == null) {
            this.wsCancelamento = new WSCancelamento(this.config, this.httpClient);
        }
        return this.wsCancelamento.cancelaNotaAssinada(chave, eventoAssinadoXml);
    }

    /**
     * Inutiliza a nota com o evento assinado ATENCAO: Esse metodo deve ser utilizado para assinaturas A3
     * @param eventoAssinadoXml evento assinado em XML
     * @param modelo modelo da nota (NF-e ou NFC-e)
     * @return dados da inutilizacao da nota retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public NFRetornoEventoInutilizacao inutilizaNotaAssinada(final String eventoAssinadoXml, final DFModelo modelo) throws Exception {
        if (this.wsInutilizacao == null) {
            this.wsInutilizacao = new WSInutilizacao(this.config, this.httpClient);
        }
        return this.wsInutilizacao.inutilizaNotaAssinada(eventoAssinadoXml, modelo);
    }

    /**
     * Inutiliza a nota
     * @param anoInutilizacaoNumeracao ano de inutilizacao
     * @param cnpjEmitente CNPJ emitente da nota
     * @param serie serie da nota
     * @param numeroInicial numero inicial da nota
     * @param numeroFinal numero final da nota
     * @param justificativa justificativa da inutilizacao
     * @param modelo modelo da nota (NF-e ou NFC-e)
     * @return dados da inutilizacao da nota retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public NFRetornoEventoInutilizacao inutilizaNota(final int anoInutilizacaoNumeracao, final String cnpjEmitente, final String serie, final String numeroInicial, final String numeroFinal, final String justificativa, final DFModelo modelo) throws Exception {
        if (this.wsInutilizacao == null) {
            this.wsInutilizacao = new WSInutilizacao(this.config, this.httpClient);
        }
        return this.wsInutilizacao.inutilizaNota(anoInutilizacaoNumeracao, cnpjEmitente, serie, numeroInicial, numeroFinal, justificativa, modelo);
    }

    /**
     * Realiza a consulta de cadastro de pessoa juridica com inscricao estadual
     * @param cnpj CNPJ da pessoa juridica
     * @param uf UF da pessoa juridica
     * @return dados da consulta da pessoa juridica retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public NFRetornoConsultaCadastro consultaCadastro(final String cnpj, final DFUnidadeFederativa uf) throws Exception {
        if (this.wsConsultaCadastro == null) {
            this.wsConsultaCadastro = new WSConsultaCadastro(this.config, this.httpClient);
        }
        return this.wsConsultaCadastro.consultaCadastro(cnpj, uf);
    }

    /**
     * Faz a manifestação do destinatário da nota
     * @param chave chave de acesso da nota
     * @param tipoEvento tipo do evento da manifestacao do destinatario
     * @param motivo motivo do cancelamento
     * @param cnpj cnpj do autor do evento
     * @return dados da manifestacao do destinatario da nota retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public NFEnviaEventoRetorno manifestaDestinatarioNota(final String chave, final NFTipoEventoManifestacaoDestinatario tipoEvento, final String motivo, final String cnpj) throws Exception {
        if (this.wSManifestacaoDestinatario == null) {
            this.wSManifestacaoDestinatario = new WSManifestacaoDestinatario(this.config, this.httpClient);
        }
        return this.wSManifestacaoDestinatario.manifestaDestinatarioNota(chave, tipoEvento, motivo, cnpj);
    }

    /**
     * Faz a manifestação do destinatário da nota com evento ja assinado ATENCAO: Esse metodo deve ser utilizado para assinaturas A3
     * @param chave chave de acesso da nota
     * @param eventoAssinadoXml evento ja assinado em formato XML
     * @return dados da manifestacao do destinatario da nota retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public NFEnviaEventoRetorno manifestaDestinatarioNotaAssinada(final String chave, final String eventoAssinadoXml) throws Exception {
        if (this.wSManifestacaoDestinatario == null) {
            this.wSManifestacaoDestinatario = new WSManifestacaoDestinatario(this.config, this.httpClient);
        }
        return this.wSManifestacaoDestinatario.manifestaDestinatarioNotaAssinada(chave, eventoAssinadoXml);
    }

    /**
     * Faz o download do xml da nota para um cnpj Informando até 10 chaves de acesso
     * @param cnpj para quem foi emitida a nota
     * @param chave chave de acesso da nota
     * @return dados do download da nota retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public NFDownloadNFeRetorno downloadNota(final String cnpj, final String chave) throws Exception {
        if (this.wsNotaDownload == null) {
            this.wsNotaDownload = new WSNotaDownload(this.config, this.httpClient);
        }
        return this.wsNotaDownload.downloadNota(cnpj, chave);
    }

    /**
     * Faz consulta de distribuicao das notas fiscais. Pode ser feita pela chave de acesso ou utilizando o NSU (numero sequencial unico) da receita.
     * @param cpfOuCnpj CPF ou CNPJ da pessoa fisica ou juridica a consultar
     * @param uf Unidade federativa da pessoa juridica a consultar
     * @param nsu Número Sequencial Único. Geralmente esta consulta será utilizada quando identificado pelo interessado um NSU faltante.
     *            O Web Service retornará o documento ou informará que o NSU não existe no Ambiente Nacional. Assim, esta
     *            consulta fechará a lacuna do NSU identificado como faltante.
     * @param ultNsu Último NSU recebido pelo ator. Caso seja informado com zero, ou com um NSU muito antigo, a consulta retornará unicamente as
     *               informações resumidas e documentos fiscais eletrônicos que tenham sido recepcionados pelo
     *               Ambiente Nacional nos últimos 3 meses.
     * @return dados da consulta retornado pelo webservice limitando um total de 50 registros
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public NFDistribuicaoIntRetorno consultarDistribuicaoDFe(final String cpfOuCnpj, final DFUnidadeFederativa uf, final String chaveAcesso, final String nsu, final String ultNsu) throws Exception {
        if (this.wSDistribuicaoNFe == null) {
            this.wSDistribuicaoNFe = new WSDistribuicaoNFe(this.config, this.httpClient);
        }
        return this.wSDistribuicaoNFe.consultar(cpfOuCnpj, uf, chaveAcesso, nsu, ultNsu);
    }
}
