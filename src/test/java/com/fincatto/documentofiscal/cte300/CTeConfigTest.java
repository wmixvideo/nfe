package com.fincatto.documentofiscal.cte300;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.cte300.classes.CTTipoEmissao;
import org.junit.Assert;
import org.junit.Test;

import java.security.KeyStore;

public class CTeConfigTest {

    @Test
    public void testaParametrosPadrao() {
        final CTeConfigTeste config = new CTeConfigTeste();
        Assert.assertEquals("3.00", CTeConfig.VERSAO);
        Assert.assertEquals("http://www.portalfiscal.inf.br/cte", CTeConfig.NAMESPACE);
        Assert.assertEquals(CTTipoEmissao.EMISSAO_NORMAL, config.getTipoEmissao());
    }

    public class CTeConfigTeste extends CTeConfig {

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
