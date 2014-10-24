package com.fincatto.nfe310.webservices;

import java.io.IOException;

import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;
import com.fincatto.nfe310.classes.evento.NFEnviaEventoRetorno;
import com.fincatto.nfe310.classes.lote.consulta.NFLoteConsultaRetorno;
import com.fincatto.nfe310.classes.lote.envio.NFLoteEnvio;
import com.fincatto.nfe310.classes.lote.envio.NFLoteEnvioRetorno;
import com.fincatto.nfe310.classes.nota.consulta.NFNotaConsultaRetorno;
import com.fincatto.nfe310.classes.statusservico.consulta.NFStatusServicoConsultaRetorno;
import com.fincatto.nfe310.validadores.xsd.XMLValidador;

public class WSFacade {

    private final WSLoteEnvio wsLoteEnvio;
    private final WSLoteConsulta wsLoteConsulta;
    private final WSStatusConsulta wsStatusConsulta;
    private final WSNotaConsulta wsNotaConsulta;
    private final WSCartaCorrecao wsCartaCorrecao;
    private final WSCancelamento wsCancelamento;
    private final WSConsultaCadastro wsConsultaCadastro;

    public WSFacade(final NFeConfig config) throws IOException {
        System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
        System.setProperty("javax.net.ssl.trustStoreType", "JKS");
        System.setProperty("javax.net.ssl.trustStore", config.getCadeiaCertificados().getAbsolutePath());
        System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");
        System.setProperty("javax.net.ssl.keyStore", config.getCertificado().getAbsolutePath());
        System.setProperty("javax.net.ssl.keyStorePassword", config.getCertificadoSenha());

        this.wsLoteEnvio = new WSLoteEnvio(config);
        this.wsLoteConsulta = new WSLoteConsulta(config);
        this.wsStatusConsulta = new WSStatusConsulta(config);
        this.wsNotaConsulta = new WSNotaConsulta(config);
        this.wsCartaCorrecao = new WSCartaCorrecao(config);
        this.wsCancelamento = new WSCancelamento(config);
        this.wsConsultaCadastro = new WSConsultaCadastro(config);
    }

    public NFLoteEnvioRetorno enviaLote(final NFLoteEnvio lote) throws Exception {
        XMLValidador.validaLote(lote.toString());
        return this.wsLoteEnvio.enviaLote(lote);
    }

    public NFLoteConsultaRetorno consultaLote(final String numeroRecibo) throws Exception {
        return this.wsLoteConsulta.consultaLote(numeroRecibo);
    }

    public NFStatusServicoConsultaRetorno consultaStatus(final NFUnidadeFederativa uf) throws Exception {
        return this.wsStatusConsulta.consultaStatus(uf);
    }

    public NFNotaConsultaRetorno consultaNota(final String chaveDeAcesso) throws Exception {
        return this.wsNotaConsulta.consultaNota(chaveDeAcesso);
    }

    public NFEnviaEventoRetorno corrigeNota(final String chaveDeAcesso, final String textoCorrecao) throws Exception {
        return this.wsCartaCorrecao.corrigirNota(chaveDeAcesso, textoCorrecao);
    }

    public NFEnviaEventoRetorno cancelaNota(final String chaveAcesso, final String numeroProtocolo, final String motivo) throws Exception {
        return this.wsCancelamento.cancelaNota(chaveAcesso, numeroProtocolo, motivo);
    }

    public void consultaCadastro(final String cnpj) throws Exception {
        this.wsConsultaCadastro.consultaCadastro(cnpj);
    }
}