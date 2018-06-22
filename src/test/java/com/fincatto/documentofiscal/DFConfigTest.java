package com.fincatto.documentofiscal;

import org.junit.Assert;
import org.junit.Test;

import java.security.KeyStore;
import java.util.TimeZone;

public class DFConfigTest {

    @Test
    public void testaDefaults() {
        final DFConfig config = new DFConfigTeste();
        Assert.assertEquals(DFAmbiente.HOMOLOGACAO, config.getAmbiente());
        Assert.assertEquals(DFModelo.NFE, config.getModelo());
        Assert.assertEquals("TLSv1.2", config.getSSLProtocolos()[0]);
        Assert.assertNotNull(config.getTimeZone());
    }

    @Test
    public void testaTimeZoneSP() {
        final DFConfig config = new DFConfigTeste() {
            @Override
            public TimeZone getTimeZone() {
                return TimeZone.getTimeZone("America/Sao_Paulo");
            }
        };
        Assert.assertEquals(TimeZone.getTimeZone("America/Sao_Paulo"), config.getTimeZone());
    }

    @Test
    public void testaTimeZoneNY() {
        final DFConfig config = new DFConfigTeste() {
            @Override
            public TimeZone getTimeZone() {
                return TimeZone.getTimeZone("America/New_York");
            }
        };
        Assert.assertEquals(TimeZone.getTimeZone("America/New_York"), config.getTimeZone());
    }

    private static class DFConfigTeste extends DFConfig {

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
    }
}
