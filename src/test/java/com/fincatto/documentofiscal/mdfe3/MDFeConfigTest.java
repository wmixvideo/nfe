package com.fincatto.documentofiscal.mdfe3;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoEmissao;
import org.junit.Assert;
import org.junit.Test;

import java.security.KeyStore;

public class MDFeConfigTest {

    @Test
    public void testaParametrosPadrao() {
        final MDFeConfigTeste config = new MDFeConfigTeste();
        Assert.assertEquals("3.00", MDFeConfig.VERSAO);
        Assert.assertEquals("http://www.portalfiscal.inf.br/mdfe", MDFeConfig.NAMESPACE);
        Assert.assertEquals(MDFTipoEmissao.NORMAL, config.getTipoEmissao());
    }

    public class MDFeConfigTeste extends MDFeConfig {

        @Override
        public DFUnidadeFederativa getCUF() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public KeyStore getCertificadoKeyStore() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String getCertificadoSenha() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public KeyStore getCadeiaCertificadosKeyStore() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String getCadeiaCertificadosSenha() {
            // TODO Auto-generated method stub
            return null;
        }

    }

}
