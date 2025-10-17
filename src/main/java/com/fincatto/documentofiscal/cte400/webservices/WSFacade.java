package com.fincatto.documentofiscal.cte400.webservices;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte.classes.distribuicao.CTDistribuicaoIntRetorno;
import com.fincatto.documentofiscal.cte.webservices.distribuicao.WSDistribuicaoCTe;
import com.fincatto.documentofiscal.cte400.classes.consultastatusservico.CTeConsStatServRet;
import com.fincatto.documentofiscal.cte400.classes.envio.CTeEnvioRetornoDados;
import com.fincatto.documentofiscal.cte400.classes.envio.CTeOSEnvioRetornoDados;
import com.fincatto.documentofiscal.cte400.classes.evento.CTeEventoRetorno;
import com.fincatto.documentofiscal.cte400.classes.evento.cartacorrecao.CTeInformacaoCartaCorrecao;
import com.fincatto.documentofiscal.cte400.classes.evento.comprovanteentrega.CTeEnviaEventoComprovanteEntrega;
import com.fincatto.documentofiscal.cte400.classes.evento.epec.CTeEnviaEventoEpec;
import com.fincatto.documentofiscal.cte400.classes.evento.gtv.CTeEnviaEventoGtv;
import com.fincatto.documentofiscal.cte400.classes.evento.insucessoentrega.CTeEnviaEventoInsucessoEntrega;
import com.fincatto.documentofiscal.cte400.classes.nota.CTeNota;
import com.fincatto.documentofiscal.cte400.classes.nota.consulta.CTeNotaConsultaRetorno;
import com.fincatto.documentofiscal.cte400.classes.os.CTeOS;
import com.fincatto.documentofiscal.utils.DFSocketFactory;
import org.apache.commons.httpclient.protocol.Protocol;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.List;

public class WSFacade {

    private final WSStatusConsulta wsStatusConsulta;
    private final WSRecepcaoCTe wsRecepcaoCTe;
    private final WSDistribuicaoCTe wsDistribuicaoCTe;
    private final WSConsulta wsConsulta;
    private final WSCancelamento wsCancelamento;
    private final WSPrestacaoEmDesacordo wsPrestacaoEmDesacordo;
    private final WSRegistroMultimodal wsRegistroMultimodal;
    private final WSCartaCorrecao wsCartaCorrecao;
    private final WSComprovanteEntrega wsComprovanteEntrega;
    private final WSCancelamentoComprovanteEntrega wsCancelamentoComprovanteEntrega;
    private final WSEpec wsEpec;
    private final WSGtv wsGtv;
    private final WSCancelamentoPrestacaoEmDesacordo wsCancelamentoPrestacaoEmDesacordo;
    private final WSInsucessoEntrega wsInsucessoEntrega;
    private final WSCancelamentoInsucessoEntrega wsCancelamentoInsucessoEntrega;
    private final WSRecepcaoCTeOS wsRecepcaoCTeOS;

    public WSFacade(final CTeConfig config) throws KeyManagementException, UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException {
        Protocol.registerProtocol("https", new Protocol("https", new DFSocketFactory(config), 443));
        this.wsStatusConsulta = new WSStatusConsulta(config);
        this.wsRecepcaoCTe = new WSRecepcaoCTe(config);
        this.wsDistribuicaoCTe = new WSDistribuicaoCTe(config);
        this.wsConsulta = new WSConsulta(config);
        this.wsCancelamento = new WSCancelamento(config);
        this.wsPrestacaoEmDesacordo = new WSPrestacaoEmDesacordo(config);
        this.wsRegistroMultimodal = new WSRegistroMultimodal(config);
        this.wsCartaCorrecao = new WSCartaCorrecao(config);
        this.wsComprovanteEntrega = new WSComprovanteEntrega(config);
        this.wsCancelamentoComprovanteEntrega = new WSCancelamentoComprovanteEntrega(config);
        this.wsEpec = new WSEpec(config);
        this.wsGtv = new WSGtv(config);
        this.wsCancelamentoPrestacaoEmDesacordo = new WSCancelamentoPrestacaoEmDesacordo(config);
        this.wsInsucessoEntrega = new WSInsucessoEntrega(config);
        this.wsCancelamentoInsucessoEntrega = new WSCancelamentoInsucessoEntrega(config);
        this.wsRecepcaoCTeOS = new WSRecepcaoCTeOS(config);
    }

    /**
     * Faz a consulta de status responsavel pela UF
     *
     * @param uf uf UF que deseja consultar o status do sefaz responsavel
     * @return dados da consulta de status retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public CTeConsStatServRet consultaStatus(final DFUnidadeFederativa uf) throws Exception {
        return this.wsStatusConsulta.consultaStatus(uf);
    }

    /**
     * Faz o envio do CT-e para a SEFAZ
     *
     * @param cte a ser eviado para a SEFAZ
     * @return dados do retorno do envio do CT-e e o xml assinado
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     * */
    public CTeEnvioRetornoDados enviaCTe(CTeNota cte) throws Exception {
        return this.wsRecepcaoCTe.enviaCTe(cte);
    }

    /**
     * Faz consulta de distribuicao dos CTe.
     * Pode ser feita utilizando o CTe (numero sequencial unico) da receita.
     * @param cpfOuCnpj CPF ou CNPJ da pessoa fisica ou juridica a consultar
     * @param uf Unidade federativa da pessoa juridica a consultar
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
    public CTDistribuicaoIntRetorno consultarDistribuicaoCTe(final String cpfOuCnpj, final DFUnidadeFederativa uf, final String nsu, final String ultNsu) throws Exception {
        return this.wsDistribuicaoCTe.consultar(cpfOuCnpj, uf, nsu, ultNsu);
    }

    /**
     * Faz a consulta do CTe
     *
     * @param chaveDeAcesso chave de acesso do cte
     * @return dados da consulta da nota retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public CTeNotaConsultaRetorno consultaNota(final String chaveDeAcesso) throws Exception {
        return this.wsConsulta.consultaNota(chaveDeAcesso);
    }

    /**
     * Faz o cancelamento do CTe
     *
     * @param chave     chave de acesso da nota
     * @param numeroProtocolo numero do protocolo da nota
     * @param motivo          motivo do cancelamento
     * @return dados do cancelamento da nota retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public CTeEventoRetorno cancelaNota(final String chave, final String numeroProtocolo, final String motivo) throws Exception {
        return this.wsCancelamento.cancelaNota(chave, numeroProtocolo, motivo);
    }

    /**
     * Faz o cancelamento da nota com evento ja assinado
     * ATENCAO: Esse metodo deve ser utilizado para assinaturas A3
     *
     * @param chave       chave de acesso da nota
     * @param eventoAssinadoXml evento ja assinado em formato XML
     * @return dados do cancelamento da nota retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public CTeEventoRetorno cancelaNotaAssinada(final String chave, final String eventoAssinadoXml) throws Exception {
        return this.wsCancelamento.cancelaNotaAssinada(chave, eventoAssinadoXml);
    }

    /**
     * Gera o XML assinado do cancelamento sem enviar para a SEFAZ.
     * @param chave           chave de acesso do CT-e
     * @param numeroProtocolo numero do protocolo da nota
     * @param motivo          motivo do cancelamento
     * @return O XML da requisicao de registro multimodal ja assinado
     * @throws Exception caso nao consiga gerar o xml
     */
    public String getXmlAssinadoCancelamento(final String chave, final String numeroProtocolo, final String motivo) throws Exception {
        return this.wsCancelamento.getXmlAssinado(chave, numeroProtocolo, motivo);
    }

    /**
     * Cancela um evento de comprovante de entrega enviado anteriormente.
     *
     * @param chave                       chave de acesso do CT-e
     * @param protocoloAutorizacao        protocolo de autorizacao
     * @param protocoloComprovanteEntrega protocolo do comprovante de entrega
     * @param sequencialEvento            sequencial do evento
     * @return dados do cancelamento do comprovante de entrega retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public CTeEventoRetorno cancelaComprovanteEntrega(final String chave, final String protocoloAutorizacao, final String protocoloComprovanteEntrega, final int sequencialEvento) throws Exception {
        return this.wsCancelamentoComprovanteEntrega.cancelaComprovanteEntrega(chave, protocoloAutorizacao, protocoloComprovanteEntrega, sequencialEvento);
    }

    /**
     * Cancela um evento de comprovante de entrega enviado anteriormente.
     * ATENCAO: Esse metodo deve ser utilizado para assinaturas A3
     *
     * @param chave             chave de acesso do CT-e
     * @param eventoAssinadoXml evento ja assinado em formato XML
     * @return dados do cancelamento do comprovante de entrega retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public CTeEventoRetorno cancelaComprovanteEntregaAssinado(final String chave, final String eventoAssinadoXml) throws Exception {
        return this.wsCancelamentoComprovanteEntrega.cancelaComprovanteEntregaAssinado(chave, eventoAssinadoXml);
    }

    /**
     * Gera o XML assinado do cancelamento do comprovante de entrega sem enviar para a SEFAZ.
     * @param chave                       chave de acesso do CT-e
     * @param protocoloAutorizacao        protocolo de autorizacao
     * @param protocoloComprovanteEntrega protocolo do comprovante de entrega
     * @param sequencialEvento            sequencial do evento
     * @return O XML da requisicao de cancelamento do comprovante de entrega ja assinado
     * @throws Exception caso nao consiga gerar o xml
     */
    public String getXmlAssinadoCancelamentoComprovanteEntrega(final String chave, final String protocoloAutorizacao, final String protocoloComprovanteEntrega, final int sequencialEvento) throws Exception {
        return this.wsCancelamentoComprovanteEntrega.getXmlAssinado(chave, protocoloAutorizacao, protocoloComprovanteEntrega, sequencialEvento);
    }

    /**
     * Faz a correcao do CT-e.
     *
     * @param chave              chave de acesso do CT-e
     * @param grupoAlterado      grupo de informações que pertence o campo que será alterado
     * @param campoAlterado      campo que será alterado
     * @param valorAlterado      novo valor que deve ser utilizado para o campo
     * @param numeroItemAlterado o índice do item alterado caso a alteração ocorra em uma lista
     * @param sequencialEvento   sequencial do evento
     * @return dados da carta de correção retornada pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public CTeEventoRetorno corrigeNota(final String chave, String grupoAlterado, String campoAlterado, String valorAlterado, Integer numeroItemAlterado, int sequencialEvento) throws Exception {
        return this.wsCartaCorrecao.corrigeNota(chave, grupoAlterado, campoAlterado, valorAlterado, numeroItemAlterado, sequencialEvento);
    }

    /**
     * Faz a correcao do CT-e.
     *
     * @param chave            chave de acesso do CT-e
     * @param correcoes        lista de correções a serem efetuadas no CT-e
     * @param sequencialEvento sequencial do evento
     * @return dados da carta de correção retornada pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public CTeEventoRetorno corrigeNota(final String chave, List<CTeInformacaoCartaCorrecao> correcoes, int sequencialEvento) throws Exception {
        return this.wsCartaCorrecao.corrigeNota(chave, correcoes, sequencialEvento);
    }

    /**
     * Faz a correcao do CT-e.
     * ATENCAO: Esse metodo deve ser utilizado para assinaturas A3
     *
     * @param chave             chave de acesso do CT-e
     * @param eventoAssinadoXml evento ja assinado em formato XML
     * @return ddados da carta de correção retornada pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public CTeEventoRetorno corrigeNotaAssinada(final String chave, final String eventoAssinadoXml) throws Exception {
        return this.wsCartaCorrecao.corrigeNotaAssinada(chave, eventoAssinadoXml);
    }

    /**
     * Gera o XML assinado da carta de correção sem enviar para a SEFAZ.
     * @param chave            chave de acesso do CT-e
     * @param correcoes        lista de correções a serem efetuadas no CT-e
     * @param sequencialEvento sequencial do evento
     * @return O XML da requisicao de carta de correção ja assinado
     * @throws Exception caso nao consiga gerar o xml
     */
    public String getXmlAssinadoCartaCorreca(final String chave, List<CTeInformacaoCartaCorrecao> correcoes, int sequencialEvento) throws Exception {
        return this.wsCartaCorrecao.getXmlAssinado(chave, correcoes, sequencialEvento);
    }

    /**
     * Registra a efetivação da entrega da carga pelo transportador.
     *
     * @param chave                 chave de acesso do CT-e
     * @param comprovanteEntrega    dados do comprovante de entrega
     * @param sequencialEvento      sequencial do evento
     * @return dados do comprovante de entrega retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public CTeEventoRetorno comprovanteEntrega(final String chave, final CTeEnviaEventoComprovanteEntrega comprovanteEntrega, final int sequencialEvento) throws Exception {
        return this.wsComprovanteEntrega.comprovanteEntrega(chave, comprovanteEntrega, sequencialEvento);
    }

    /**
     * Registra a efetivação da entrega da carga pelo transportador.
     * ATENCAO: Esse metodo deve ser utilizado para assinaturas A3
     *
     * @param chave             chave de acesso do CT-e
     * @param eventoAssinadoXml evento ja assinado em formato XML
     * @return dados do comprovante de entrega retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public CTeEventoRetorno comprovanteEntregaAssinado(final String chave, final String eventoAssinadoXml) throws Exception {
        return this.wsComprovanteEntrega.comprovanteEntregaAssinado(chave, eventoAssinadoXml);
    }

    /**
     * Gera o XML assinado do comprovante de entrega sem enviar para a SEFAZ.
     * @param chave                 chave de acesso do CT-e
     * @param comprovanteEntrega    dados do comprovante de entrega
     * @param sequencialEvento      sequencial do evento
     * @return O XML da requisicao de comprovante de entrega ja assinado
     * @throws Exception caso nao consiga gerar o xml
     */
    public String getXmlAssinadoComprovanteEntrega(final String chave, final CTeEnviaEventoComprovanteEntrega comprovanteEntrega, final int sequencialEvento) throws Exception {
        return this.wsComprovanteEntrega.getXmlAssinado(chave, comprovanteEntrega, sequencialEvento);
    }

    /**
     * Faz o registro do EPEC.
     *
     * @param chave           chave de acesso do CT-e
     * @param eventoEpec      dados do evento prévio de emissão em contingência
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public CTeEventoRetorno enviaEpec(final String chave, final CTeEnviaEventoEpec eventoEpec) throws Exception {
        return this.wsEpec.enviaEpec(chave, eventoEpec);
    }

    /**
     * Faz o registro do EPEC.
     * ATENCAO: Esse metodo deve ser utilizado para assinaturas A3
     *
     * @param chave             chave de acesso do CT-e
     * @param eventoAssinadoXml evento ja assinado em formato XML
     * @return dados do EPEC retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public CTeEventoRetorno enviaEpecAssinado(final String chave, final String eventoAssinadoXml) throws Exception {
        return this.wsEpec.enviaEpecAssinado(chave, eventoAssinadoXml);
    }

    /**
     * Gera o XML assinado do EPEC sem enviar para a SEFAZ.
     * @param chave           chave de acesso do CT-e
     * @param eventoEpec      dados do evento prévio de emissão em contingência
     * @return O XML da requisicao de EPEC ja assinado
     * @throws Exception caso nao consiga gerar o xml
     */
    public String getXmlAssinadoEpec(final String chave, final CTeEnviaEventoEpec eventoEpec) throws Exception {
        return this.wsEpec.getXmlAssinado(chave, eventoEpec);
    }

    /**
     * Faz o registro da guia de transporte de valores.
     *
     * @param chave            chave de acesso do CT-e
     * @param eventoGtv        dados da guia de transporte de valores
     * @param sequencialEvento sequencial do evento
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public CTeEventoRetorno enviaGtv(final String chave, final CTeEnviaEventoGtv eventoGtv, final int sequencialEvento) throws Exception {
        return this.wsGtv.enviaGtv(chave, eventoGtv, sequencialEvento);
    }

    /**
     * Faz o registro da guia de transporte de valores.
     * ATENCAO: Esse metodo deve ser utilizado para assinaturas A3
     *
     * @param chave             chave de acesso do CT-e
     * @param eventoAssinadoXml evento ja assinado em formato XML
     * @return dados da guia de transporte de valores retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public CTeEventoRetorno enviaGtvAssinada(final String chave, final String eventoAssinadoXml) throws Exception {
        return this.wsGtv.enviaGtvAssinada(chave, eventoAssinadoXml);
    }

    /**
     * Gera o XML assinado da guia de transporte de valores sem enviar para a SEFAZ.
     * @param chave            chave de acesso do CT-e
     * @param eventoGtv        dados do evento prévio de emissão em contingência
     * @param sequencialEvento sequencial do evento
     * @return O XML da requisicao da guia de transporte de valores ja assinada
     * @throws Exception caso nao consiga gerar o xml
     */
    public String getXmlAssinadoGtv(final String chave, final CTeEnviaEventoGtv eventoGtv, final int sequencialEvento) throws Exception {
        return this.wsGtv.getXmlAssinado(chave, eventoGtv, sequencialEvento);
    }

    /**
     * Faz o registro de prestação de serviço em desacordo.
     *
     * @param chave            chave de acesso do CT-e
     * @param observacao       observação do desacordo
     * @param cpfOuCnpj        CPF ou CNPJ do autor do evento
     * @param sequencialEvento sequencial do evento
     * @return dados do desacordo do CT-e retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public CTeEventoRetorno prestacaoEmDesacordo(final String chave, final String observacao, final String cpfOuCnpj, final int sequencialEvento) throws Exception {
        return this.wsPrestacaoEmDesacordo.prestacaoEmDesacordo(chave, observacao, cpfOuCnpj, sequencialEvento);
    }

    /**
     * Faz o registro de prestação de serviço em desacordo.
     * ATENCAO: Esse metodo deve ser utilizado para assinaturas A3
     *
     * @param chave             chave de acesso do CT-e
     * @param eventoAssinadoXml evento ja assinado em formato XML
     * @return dados do desacordo do CT-e retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public CTeEventoRetorno prestacaoEmDesacordoAssinada(final String chave, final String eventoAssinadoXml) throws Exception {
        return this.wsPrestacaoEmDesacordo.prestacaoEmDesacordoAssinada(chave, eventoAssinadoXml);
    }

    /**
     * Gera o XML assinado da prestação de serviço em desacordo sem enviar para a SEFAZ.
     * @param chave            chave de acesso do CT-e
     * @param observacao       observação do desacordo
     * @param cpfOuCnpj        CPF ou CNPJ do autor do evento
     * @param sequencialEvento sequencial do evento
     * @return O XML da requisicao de prestação de serviço em desacordo ja assinado
     * @throws Exception caso nao consiga gerar o xml
     */
    public String getXmlAssinadoPrestacaoEmDesacordo(final String chave, final String observacao, final String cpfOuCnpj, final int sequencialEvento) throws Exception {
        return this.wsPrestacaoEmDesacordo.getXmlAssinado(chave, observacao, cpfOuCnpj, sequencialEvento);
    }

    /**
     * Vincula um serviço ao CT-e multimodal.
     *
     * @param chave                 chave de acesso do CT-e multimodal
     * @param informacoesAdicionais informações sobre o tipo de documento utilizado e ressalvas, se for o caso
     * @param numeroDocumento       número do documento que será vinculado
     * @return dados do registro multimodal retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public CTeEventoRetorno registroMultimodal(final String chave, final String informacoesAdicionais, final String numeroDocumento) throws Exception {
        return this.wsRegistroMultimodal.registroMultimodal(chave, informacoesAdicionais, numeroDocumento);
    }

    /**
     * Vincula um serviço ao CT-e multimodal.
     * ATENCAO: Esse metodo deve ser utilizado para assinaturas A3
     *
     * @param chave             chave de acesso do CT-e multimodal
     * @param eventoAssinadoXml evento ja assinado em formato XML
     * @return dados do registro multimodal retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public CTeEventoRetorno registroMultimodalAssinado(final String chave, final String eventoAssinadoXml) throws Exception {
        return this.wsRegistroMultimodal.registroMultimodalAssinado(chave, eventoAssinadoXml);
    }

    /**
     * Gera o XML assinado do registro multimodal sem enviar para a SEFAZ.
     * @param chave                 chave de acesso do CT-e multimodal
     * @param informacoesAdicionais informações sobre o tipo de documento utilizado e ressalvas, se for o caso
     * @param numeroDocumento       número do documento que será vinculado
     * @return O XML da requisicao de registro multimodal ja assinado
     * @throws Exception caso nao consiga gerar o xml
     */
    public String getXmlAssinadoRegistroMultimodal(final String chave, final String informacoesAdicionais, final String numeroDocumento) throws Exception {
        return this.wsRegistroMultimodal.getXmlAssinado(chave, informacoesAdicionais, numeroDocumento);
    }

    /**
     * Cancela um evento de prestação de serviço em desacordo enviado anteriormente.
     *
     * @param chave                       chave de acesso do CT-e
     * @param protocoloDesacordo          protocolo do evento de prestação de serviço em desacordo
     * @param cpfOuCnpj                   CPF ou CNPJ do autor do evento
     * @param sequencialEvento            sequencial do evento
     * @return dados do cancelamento do evento de prestação de serviço em desacordo retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public CTeEventoRetorno cancelaPrestacaoEmDesacordo(final String chave, final String protocoloDesacordo, final String cpfOuCnpj, final int sequencialEvento) throws Exception {
        return this.wsCancelamentoPrestacaoEmDesacordo.cancelaPrestacaoEmDesacordo(chave, protocoloDesacordo, cpfOuCnpj, sequencialEvento);
    }

    /**
     * Cancela um evento de prestação de serviço em desacordo enviado anteriormente.
     * ATENCAO: Esse metodo deve ser utilizado para assinaturas A3
     *
     * @param chave             chave de acesso do CT-e
     * @param eventoAssinadoXml evento ja assinado em formato XML
     * @return dados do cancelamento do evento de prestação de serviço em desacordo retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public CTeEventoRetorno cancelaPrestacaoEmDesacordoAssinado(final String chave, final String eventoAssinadoXml) throws Exception {
        return this.wsCancelamentoPrestacaoEmDesacordo.cancelaPrestacaoEmDesacordoAssinado(chave, eventoAssinadoXml);
    }

    /**
     * Gera o XML assinado do cancelamento do evento de prestação de serviço em desacordo sem enviar para a SEFAZ.
     * @param chave                       chave de acesso do CT-e
     * @param protocoloDesacordo          protocolo do evento de prestação de serviço em desacordo
     * @param cpfOuCnpj                   CPF ou CNPJ do autor do evento
     * @param sequencialEvento            sequencial do evento
     * @return O XML da requisicao de cancelamento do evento de prestação de serviço em desacordo ja assinado
     * @throws Exception caso nao consiga gerar o xml
     */
    public String getXmlAssinadoCancelamentoPrestacaoEmDesacordo(final String chave, final String protocoloDesacordo, final String cpfOuCnpj, final int sequencialEvento) throws Exception {
        return this.wsCancelamentoPrestacaoEmDesacordo.getXmlAssinado(chave, protocoloDesacordo, cpfOuCnpj, sequencialEvento);
    }

    /**
     * Cancela um evento de insucesso de entrega enviado anteriormente.
     *
     * @param chave                       chave de acesso do CT-e
     * @param protocoloAutorizacao        protocolo de autorizacao
     * @param protocoloInsucessoEntrega   protocolo do insucesso de entrega
     * @param sequencialEvento            sequencial do evento
     * @return dados do cancelamento do insucesso de entrega retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public CTeEventoRetorno cancelaInsucessoEntrega(final String chave, final String protocoloAutorizacao, final String protocoloInsucessoEntrega, final int sequencialEvento) throws Exception {
        return this.wsCancelamentoInsucessoEntrega.cancelaInsucessoEntrega(chave, protocoloAutorizacao, protocoloInsucessoEntrega, sequencialEvento);
    }

    /**
     * Cancela um evento de insucesso de entrega enviado anteriormente.
     * ATENCAO: Esse metodo deve ser utilizado para assinaturas A3
     *
     * @param chave             chave de acesso do CT-e
     * @param eventoAssinadoXml evento ja assinado em formato XML
     * @return dados do cancelamento do insucesso de entrega retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public CTeEventoRetorno cancelaInsucessoEntregaAssinado(final String chave, final String eventoAssinadoXml) throws Exception {
        return this.wsCancelamentoInsucessoEntrega.cancelaInsucessoEntregaAssinado(chave, eventoAssinadoXml);
    }

    /**
     * Gera o XML assinado do cancelamento do insucesso de entrega sem enviar para a SEFAZ.
     * @param chave                       chave de acesso do CT-e
     * @param protocoloAutorizacao        protocolo de autorizacao
     * @param protocoloInsucessoEntrega   protocolo do insucesso de entrega
     * @param sequencialEvento            sequencial do evento
     * @return O XML da requisicao de cancelamento do insucesso de entrega ja assinado
     * @throws Exception caso nao consiga gerar o xml
     */
    public String getXmlAssinadoCancelamentoInsucessoEntrega(final String chave, final String protocoloAutorizacao, final String protocoloInsucessoEntrega, final int sequencialEvento) throws Exception {
        return this.wsCancelamentoInsucessoEntrega.getXmlAssinado(chave, protocoloAutorizacao, protocoloInsucessoEntrega, sequencialEvento);
    }

    /**
     * Registra o insucesso na entrega da carga pelo transportador.
     *
     * @param chave                 chave de acesso do CT-e
     * @param insucessoEntrega    dados do insucesso de entrega
     * @return dados do insucesso de entrega retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public CTeEventoRetorno insucessoEntrega(final String chave, final CTeEnviaEventoInsucessoEntrega insucessoEntrega, final int sequencialEvento) throws Exception {
        return this.wsInsucessoEntrega.insucessoEntrega(chave, insucessoEntrega, sequencialEvento);
    }

    /**
     * Registra o insucesso na entrega da carga pelo transportador.
     * ATENCAO: Esse metodo deve ser utilizado para assinaturas A3
     *
     * @param chave             chave de acesso do CT-e
     * @param eventoAssinadoXml evento ja assinado em formato XML
     * @return dados do insucesso de entrega retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public CTeEventoRetorno insucessoEntregaAssinado(final String chave, final String eventoAssinadoXml) throws Exception {
        return this.wsInsucessoEntrega.insucessoEntregaAssinado(chave, eventoAssinadoXml);
    }

    /**
     * Gera o XML assinado do insucesso de entrega sem enviar para a SEFAZ.
     * @param chave                 chave de acesso do CT-e
     * @param insucessoEntrega    dados do insucesso de entrega
     * @return O XML da requisicao de insucesso de entrega ja assinado
     * @throws Exception caso nao consiga gerar o xml
     */
    public String getXmlAssinadoInsucessoEntrega(final String chave, final CTeEnviaEventoInsucessoEntrega insucessoEntrega, final int sequencialEvento) throws Exception {
        return this.wsInsucessoEntrega.getXmlAssinado(chave, insucessoEntrega, sequencialEvento);
    }

    /**
     * Faz o envio do CT-e de Outros Serviços para a SEFAZ.
     *
     * @param cteOS a ser eviado para a SEFAZ
     * @return dados do retorno do envio do CT-e OS e o xml assinado
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     * */
    public CTeOSEnvioRetornoDados enviaCTe(CTeOS cteOS) throws Exception {
        return this.wsRecepcaoCTeOS.enviaCTe(cteOS);
    }

}