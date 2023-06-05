package com.fincatto.documentofiscal.cte400.webservices;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte.classes.distribuicao.CTDistribuicaoIntRetorno;
import com.fincatto.documentofiscal.cte.webservices.distribuicao.WSDistribuicaoCTe;
import com.fincatto.documentofiscal.cte400.classes.nota.consulta.CTeNotaConsultaRetorno;
import com.fincatto.documentofiscal.cte400.classes.consultastatusservico.CTeConsStatServRet;
import com.fincatto.documentofiscal.utils.DFSocketFactory;
import org.apache.commons.httpclient.protocol.Protocol;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

public class WSFacade {

    private final WSStatusConsulta wsStatusConsulta;

    private final WSDistribuicaoCTe wsDistribuicaoCTe;

    private WSConsulta wsConsulta;

    public WSFacade(final CTeConfig config) throws IOException, KeyManagementException, UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException, CertificateException {
        Protocol.registerProtocol("https", new Protocol("https", new DFSocketFactory(config), 443));
        this.wsStatusConsulta = new WSStatusConsulta(config);
        this.wsDistribuicaoCTe = new WSDistribuicaoCTe(config);
        this.wsConsulta = new WSConsulta(config);
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

}