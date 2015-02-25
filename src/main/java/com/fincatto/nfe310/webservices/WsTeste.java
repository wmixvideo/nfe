package com.fincatto.nfe310.webservices;

import java.io.File;
import java.io.IOException;

import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.classes.NFAmbiente;
import com.fincatto.nfe310.classes.NFTipoEmissao;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;

public class WsTeste {

    public static void main(final String[] args) throws IOException, Exception {
        final NFeConfig config = new NFeConfig() {

            @Override
            public NFTipoEmissao getTipoEmissao() {
                return NFTipoEmissao.EMISSAO_NORMAL;
            }

            @Override
            public String getCertificadoSenha() {
                return "Wm7xD7str7";
            }

            @Override
            public File getCertificado() throws IOException {
                return new File("/Users/Jeferson/Documents/Workspace/wmix/wmix-core/src/main/resources/certificado/wmix_a1_2015.pfx");
            }

            @Override
            public File getCadeiaCertificados() throws IOException {
                return new File("/Users/Jeferson/Documents/Workspace/wmix/wmix-core/src/main/resources/certificado/root.jks");
            }

            @Override
            public NFUnidadeFederativa getCUF() {
                return NFUnidadeFederativa.SC;
            }

            @Override
            public NFAmbiente getAmbiente() {
                return NFAmbiente.HOMOLOGACAO;
            }
        };

        new WSFacade(config).inutilizaNota(15, "03918609000132", "5", "654896", "654896", "Teste erro");
    }
}