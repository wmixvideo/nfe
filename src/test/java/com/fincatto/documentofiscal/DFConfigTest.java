package com.fincatto.documentofiscal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.KeyStore;
import java.util.TimeZone;

public class DFConfigTest {
    
    @Test
    public void testaDefaults() {
        final DFConfig config = new DFConfigTeste();
        Assertions.assertEquals(DFAmbiente.HOMOLOGACAO, config.getAmbiente());
        Assertions.assertEquals(DFModelo.NFE, config.getModelo());
        Assertions.assertEquals("TLSv1.2", config.getSSLProtocolos()[0]);
        Assertions.assertNotNull(config.getTimeZone());
        Assertions.assertEquals(60000, config.getTimeoutRequisicaoEmMillis());
    }
    
    @Test
    public void testaTimeZoneSP() {
        final DFConfig config = new DFConfigTeste() {
            @Override
            public TimeZone getTimeZone() {
                return TimeZone.getTimeZone("America/Sao_Paulo");
            }
        };
        Assertions.assertEquals(TimeZone.getTimeZone("America/Sao_Paulo"), config.getTimeZone());
    }
    
    @Test
    public void testaTimeZoneNY() {
        final DFConfig config = new DFConfigTeste() {
            @Override
            public TimeZone getTimeZone() {
                return TimeZone.getTimeZone("America/New_York");
            }
        };
        Assertions.assertEquals(TimeZone.getTimeZone("America/New_York"), config.getTimeZone());
    }

    @Test
    public void testaTimeoutRequisicaoEmMillis() {
        final DFConfig config = new DFConfigTeste() {
            @Override
            public int getTimeoutRequisicaoEmMillis() {
                return 30_000;
            }
        };
        Assertions.assertEquals(30_000, config.getTimeoutRequisicaoEmMillis());
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
