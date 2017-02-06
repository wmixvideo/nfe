package com.fincatto.cte300.webservices;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.HttpsURLConnection;

import com.fincatto.cte300.CTeConfig;
import com.fincatto.cte300.classes.statusservico.consulta.CTStatusServicoConsultaRetorno;
import com.fincatto.dfe.classes.DFUnidadeFederativa;
import com.fincatto.dfe.webservices.DFSocketFactory;

public class CTFacade {

    private final WSStatusConsulta wsStatusConsulta;

    public CTFacade(final CTeConfig config) throws IOException, KeyManagementException, UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException, CertificateException {
    	HttpsURLConnection.setDefaultSSLSocketFactory(new DFSocketFactory(config).createSSLContext().getSocketFactory());

        // inicia os servicos disponiveis do cte
        this.wsStatusConsulta = new WSStatusConsulta(config);
    }

    /**
     * Faz a consulta de status responsavel pela UF
     *
     * @param uf     uf UF que deseja consultar o status do sefaz responsavel
     * @param modelo modelo da nota (NF-e, NFC-e, CT-e)
     * @return dados da consulta de status retornado pelo webservice
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com o sefaz
     */
    public CTStatusServicoConsultaRetorno consultaStatus(final DFUnidadeFederativa uf) throws Exception {
        return this.wsStatusConsulta.consultaStatus(uf);
    }

}