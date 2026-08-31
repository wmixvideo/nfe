package com.fincatto.documentofiscal.cte;

import com.fincatto.documentofiscal.DFUnidadeFederativa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.KeyStore;

public class CTeConfigTest {
    
    @Test
    public void testaParametrosPadrao() {
        final CTeConfigTeste config = new CTeConfigTeste();
        Assertions.assertEquals("http://www.portalfiscal.inf.br/cte", CTeConfig.NAMESPACE);
        Assertions.assertEquals(CTTipoEmissao.EMISSAO_NORMAL, config.getTipoEmissao());
    }
    
    public class CTeConfigTeste extends CTeConfig {
        
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