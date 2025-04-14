package com.fincatto.documentofiscal.mdfe3.webservices;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.time.LocalDate;
import java.util.List;

import org.apache.commons.httpclient.protocol.Protocol;

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
import com.fincatto.documentofiscal.utils.DFSocketFactory;

public class WSFacade {

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
    public WSFacade(final MDFeConfig config) throws IOException, KeyManagementException, UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException, CertificateException {
        Protocol.registerProtocol("https", new Protocol("https", new DFSocketFactory(config), 443));
        this.wsStatusConsulta = new WSStatusConsulta(config);
        this.wsRecepcaoLote = new WSRecepcaoLote(config);
        this.wsRecepcaoSinc = new WSRecepcaoSinc(config);
//        this.wsRecepcaoLoteRetorno = new WSRecepcaoLoteRetorno(config);
        this.wsNotaConsulta = new WSNotaConsulta(config);
        this.wsCancelamento = new WSCancelamento(config);
        this.wsEncerramento = new WSEncerramento(config);
        this.wsConsultaRecibo = new WSConsultaRecibo(config);
        this.wsConsultaNaoEncerrados = new WSConsultaNaoEncerrados(config);
        this.wsIncluirCondutor = new WSIncluirCondutor(config);
        this.wsIncluirDFe = new WSIncluirDFe(config);
        this.wsPagamentoTransporte = new WSPagamentoTransporte(config);
        this.wsDistribuicaoMDFe = new WSDistribuicaoMDFe(config);
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
     * @param chaveAcesso
     * @param nomeCondutor
     * @param cpfCondutor
     * @return
     * @throws Exception
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
