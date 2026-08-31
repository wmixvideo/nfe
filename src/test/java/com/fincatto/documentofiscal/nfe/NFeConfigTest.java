package com.fincatto.documentofiscal.nfe;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.KeyStore;

public class NFeConfigTest {

    @Test
    public void testaParametrosPadrao() {
        final NFeConfigTeste config = new NFeConfigTeste();

        Assertions.assertEquals("TLSv1.2", config.getSSLProtocolos()[0]);
        Assertions.assertEquals(NFTipoEmissao.EMISSAO_NORMAL, config.getTipoEmissao());
        Assertions.assertNull(config.getCodigoSegurancaContribuinte());
        Assertions.assertNull(config.getCodigoSegurancaContribuinteID());
    }

    private class NFeConfigTeste extends NFeConfig {

        @Override
        public DFUnidadeFederativa getCUF() {
            return null;
        }

        @Override
        public KeyStore getCertificadoKeyStore() {
            return null;
        }

        @Override
        public String getCertificadoSenha() {
            return null;
        }

        @Override
        public KeyStore getCadeiaCertificadosKeyStore() {
            return null;
        }

        @Override
        public String getCadeiaCertificadosSenha() {
            return null;
        }

        @Override
        public String getCertificadoAlias() {
            return null;
        }
    }
}