package com.fincatto.nfe.webservices;

import com.fincatto.nfe.NFEConfig;
import com.fincatto.nfe.classes.NFUnidadeFederativa;
import com.fincatto.nfe.classes.lote.consulta.NFLoteConsultaRetorno;
import com.fincatto.nfe.classes.lote.envio.NFLoteEnvio;
import com.fincatto.nfe.classes.lote.envio.NFLoteEnvioRetorno;
import com.fincatto.nfe.classes.statusservico.consulta.NFStatusServicoConsultaRetorno;

public class WSFacade {
    private final WSLoteEnvio wsLoteEnvio;
    private final WSLoteConsulta wsLoteConsulta;
    private final WSStatusConsulta wsStatusConsulta;

    public WSFacade(final NFEConfig config) {
        System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
        System.setProperty("javax.net.ssl.trustStoreType", "JKS");
        System.setProperty("javax.net.ssl.trustStore", config.getCadeiaCertificados().getAbsolutePath());
        System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");
        System.setProperty("javax.net.ssl.keyStore", config.getCertificado().getAbsolutePath());
        System.setProperty("javax.net.ssl.keyStorePassword", config.getCertificadoSenha());

        this.wsLoteEnvio = new WSLoteEnvio(config);
        this.wsLoteConsulta = new WSLoteConsulta(config);
        this.wsStatusConsulta = new WSStatusConsulta(config);
    }

    public NFLoteEnvioRetorno enviaLote(final NFLoteEnvio lote) throws Exception {
        return this.wsLoteEnvio.enviaLote(lote);
    }

    public NFLoteConsultaRetorno consultaLote(final String numeroRecibo, final NFUnidadeFederativa uf) throws Exception {
        return this.wsLoteConsulta.consultaLote(numeroRecibo, uf);
    }

    public NFStatusServicoConsultaRetorno consultaStatus(final NFUnidadeFederativa uf) throws Exception {
        return this.wsStatusConsulta.consultaStatus(uf);
    }
}