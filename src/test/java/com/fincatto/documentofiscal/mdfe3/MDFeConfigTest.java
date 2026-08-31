package com.fincatto.documentofiscal.mdfe3;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoEmissao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.KeyStore;

public class MDFeConfigTest {

    @Test
    public void testaParametrosPadrao() {
        final MDFeConfigTeste config = new MDFeConfigTeste();
        Assertions.assertEquals("3.00", MDFeConfig.VERSAO);
        Assertions.assertEquals("http://www.portalfiscal.inf.br/mdfe", MDFeConfig.NAMESPACE);
        Assertions.assertEquals(MDFTipoEmissao.NORMAL, config.getTipoEmissao());
    }

    public class MDFeConfigTeste extends MDFeConfig {

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
