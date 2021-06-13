package com.fincatto.documentofiscal.cte300.webservices;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import org.apache.commons.httpclient.protocol.Protocol;

import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.cte300.CTeConfig;
import com.fincatto.documentofiscal.cte300.classes.consultastatusservico.CTeConsStatServRet;
import com.fincatto.documentofiscal.cte300.classes.enviolote.CTeEnvioLote;
import com.fincatto.documentofiscal.cte300.classes.enviolote.CTeEnvioLoteRetornoDados;
import com.fincatto.documentofiscal.cte300.classes.enviolote.consulta.CTeConsultaRecLoteRet;
import com.fincatto.documentofiscal.cte300.classes.evento.cancelamento.CTeRetornoCancelamento;
import com.fincatto.documentofiscal.cte300.classes.evento.inutilizacao.CTeRetornoEventoInutilizacao;
import com.fincatto.documentofiscal.cte300.classes.nota.consulta.CTeNotaConsultaRetorno;
import com.fincatto.documentofiscal.utils.DFSocketFactory;

public class WSFacade {


	private final WSStatusConsulta wsStatusConsulta;
	private final WSRecepcaoLote wsRecepcaoLote;
	private final WSNotaConsulta wsNotaConsulta;
    private final WSCancelamento wsCancelamento;
    private final WSInutilizacao wsInutilizacao;

	private final WSRecepcaoLoteRetorno wsRecepcaoLoteRetorno;

    public WSFacade(final CTeConfig config) throws IOException, KeyManagementException, UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException, CertificateException {
        Protocol.registerProtocol("https", new Protocol("https", new DFSocketFactory(config), 443));
        this.wsStatusConsulta = new WSStatusConsulta(config);
        this.wsRecepcaoLote = new WSRecepcaoLote(config);
        this.wsRecepcaoLoteRetorno = new WSRecepcaoLoteRetorno(config);
        this.wsNotaConsulta = new WSNotaConsulta(config);
        this.wsCancelamento = new WSCancelamento(config);
        this.wsInutilizacao = new WSInutilizacao(config);
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
     * Faz o envio do lote para a SEFAZ
     * 
     * @param cteRecepcao a ser eviado para a SEFAZ
     * @return dados do retorno do envio do lote e o xml assinado
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     * */
    public CTeEnvioLoteRetornoDados envioRecepcaoLote(CTeEnvioLote cteRecepcao) throws Exception {
    	return this.wsRecepcaoLote.envioRecepcao(cteRecepcao);
    }
    
    /**
     * Faz a consulta do processamento do lote na SEFAZ
     * 
     * @param numRecibo do recebimento do lote
     * @return dados da consulta do processamento do lote
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     * */
    public CTeConsultaRecLoteRet consultaEnvioRecepcaoLote(String numRecibo) throws Exception {
    	return this.wsRecepcaoLoteRetorno.consultaLote(numRecibo);
    }

    /**
     * Faz a consulta do CTe
     *
     * @param chaveDeAcesso chave de acesso do cte
     * @return dados da consulta da nota retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public CTeNotaConsultaRetorno consultaNota(final String chaveDeAcesso) throws Exception {
        return this.wsNotaConsulta.consultaNota(chaveDeAcesso);
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
    public CTeRetornoCancelamento cancelaNota(final String chave, final String numeroProtocolo, final String motivo) throws Exception {
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
    public CTeRetornoCancelamento cancelaNotaAssinada(final String chave, final String eventoAssinadoXml) throws Exception {
        return this.wsCancelamento.cancelaNotaAssinada(chave, eventoAssinadoXml);
    }

    /**
     * Inutiliza o CTE com o evento assinado ATENCAO: Esse metodo deve ser utilizado para assinaturas A3
     * @param eventoAssinadoXml evento assinado em XML
     * @param modelo modelo do CTE
     * @return dados da inutilizacao do CTE retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public CTeRetornoEventoInutilizacao inutilizaNotaAssinada(final String eventoAssinadoXml, final DFModelo modelo) throws Exception {
        return this.wsInutilizacao.inutilizaNotaAssinada(eventoAssinadoXml, modelo);
    }

    /**
     * Inutiliza o CTE
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
    public CTeRetornoEventoInutilizacao inutilizaNota(final int anoInutilizacaoNumeracao, final String cnpjEmitente, final String serie, final String numeroInicial, final String numeroFinal, final String justificativa, final DFModelo modelo) throws Exception {
        return this.wsInutilizacao.inutilizaNota(anoInutilizacaoNumeracao, cnpjEmitente, serie, numeroInicial, numeroFinal, justificativa, modelo);
    }
    
    /**
     * Gera o XML assinado da inutilizacao sem enviar para a SEFAZ.
     * @param anoInutilizacaoNumeracao ano de inutilizacao
     * @param cnpjEmitente CNPJ emitente da nota
     * @param serie serie da nota
     * @param numeroInicial numero inicial da nota
     * @param numeroFinal numero final da nota
     * @param justificativa justificativa da inutilizacao
     * @param modelo modelo da nota (NF-e ou NFC-e)
     * @return O XML da requisicao de inutilizacao ja assinado
     * @throws Exception caso nao consiga gerar o xml
     */
    public String getXmlAssinadoInutilizacao(final int anoInutilizacaoNumeracao, final String cnpjEmitente, final String serie, final String numeroInicial, final String numeroFinal, final String justificativa, final DFModelo modelo) throws Exception {
    	return this.wsInutilizacao.getXmlAssinado(anoInutilizacaoNumeracao, cnpjEmitente, serie, numeroInicial, numeroFinal, justificativa, modelo);
    }
}
