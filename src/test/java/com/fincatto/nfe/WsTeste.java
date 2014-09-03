package com.fincatto.nfe;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import com.fincatto.nfe.classes.NFAmbiente;
import com.fincatto.nfe.classes.NFTipoEmissao;
import com.fincatto.nfe.classes.NFUnidadeFederativa;
import com.fincatto.nfe.classes.lote.envio.NFLoteEnvioRetorno;
import com.fincatto.nfe.webservices.WSFacade;

public class WsTeste {

    public static void main(final String[] args) throws Exception {
        final NFEConfig config = new NFEConfig() {
            @Override
            public File getCertificado() {
                return new File("/Users/Jeferson/Documents/Workspace/wmix/wmix-core/target/classes/certificado/wmix_a1_2015.pfx");
            }

            @Override
            public File getCadeiaCertificados() {
                return new File("/Users/Jeferson/Documents/Workspace/wmix/wmix-core/target/classes/certificado/root.jks");
            }

            @Override
            public String getCertificadoSenha() {
                return "Wm7xD7str7";
            }

            @Override
            public URL getWsdl() {
                try {
                    return new URL("https://homologacao.nfe.sefazvirtual.rs.gov.br/ws/nfeRecepcao/nfeRecepcao2.asmx?WSDL");
                } catch (final MalformedURLException e) {
                    return null;
                }
            }

            @Override
            public NFUnidadeFederativa getCUF() {
                return NFUnidadeFederativa.SC;
            }

            @Override
            public NFAmbiente getAmbiente() {
                return NFAmbiente.HOMOLOGACAO;
            }

            @Override
            public NFTipoEmissao getTipoEmissao() {
                return NFTipoEmissao.NORMAL;
            }
        };

        final WSFacade wsFacade = new WSFacade(config);

        final NFLoteEnvioRetorno loteEnvioRetorno = wsFacade.enviaLote(FabricaDeObjetosFake.getNFLoteEnvio());
        wsFacade.consultaStatus(NFUnidadeFederativa.SC);
        wsFacade.consultaLote(loteEnvioRetorno.getInfoRecebimento().getRecibo(), NFUnidadeFederativa.SC);
    }
}