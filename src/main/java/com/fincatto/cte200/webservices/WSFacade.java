package com.fincatto.cte200.webservices;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import org.apache.commons.httpclient.protocol.Protocol;

import com.fincatto.cte200.CTeConfig;
import com.fincatto.cte200.classes.statusservico.consulta.CTStatusServicoConsultaRetorno;
import com.fincatto.dfe.classes.DFUnidadeFederativa;
import com.fincatto.dfe.classes.DFModelo;
import com.fincatto.dfe.webservices.DFSocketFactory;

public class WSFacade {

    private final WSStatusConsulta wsStatusConsulta;

    public WSFacade(final CTeConfig config) throws IOException, KeyManagementException, UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException, CertificateException {
    	// registra o protocolo e o socket factory correspondente
        Protocol.registerProtocol("https", new Protocol("https", new DFSocketFactory(config), 443));

        // inicia os servicos disponiveis do cte
        this.wsStatusConsulta = new WSStatusConsulta(config);
    }

    public CTStatusServicoConsultaRetorno consultaStatus(final DFUnidadeFederativa uf, final DFModelo modelo) throws Exception {
        return this.wsStatusConsulta.consultaStatus(uf, modelo);
    }

}