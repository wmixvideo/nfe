package com.fincatto.cte200;

import java.security.KeyStore;
import java.security.KeyStoreException;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.dfe.classes.DFAmbiente;
import com.fincatto.dfe.classes.DFTipoEmissao;
import com.fincatto.dfe.classes.DFUnidadeFederativa;

public class CTeConfigTest {

	private final CTeConfigTeste config = new CTeConfigTeste();

    @Test
    public void testaParametrosPadrao() {
        Assert.assertEquals(DFAmbiente.HOMOLOGACAO, config.getAmbiente());
        Assert.assertEquals(DFTipoEmissao.EMISSAO_NORMAL, config.getTipoEmissao());
        Assert.assertEquals("TLSv1", config.getSSLProtocolo());
    }

    @Test
    public void testaParametrosImplementados() throws KeyStoreException {
        Assert.assertNull(config.getCUF());
        Assert.assertNull(config.getCertificadoKeyStore());
        Assert.assertNull(config.getCertificadoSenha());
        Assert.assertNull(config.getCadeiaCertificadosKeyStore());
        Assert.assertNull(config.getCadeiaCertificadosSenha());
    }

    private class CTeConfigTeste extends CTeConfig {

        @Override
        public DFUnidadeFederativa getCUF() {
            return null;
        }

        @Override
        public KeyStore getCertificadoKeyStore() throws KeyStoreException {
            return null;
        }

        @Override
        public String getCertificadoSenha() {
            return null;
        }

        @Override
        public KeyStore getCadeiaCertificadosKeyStore() throws KeyStoreException {
            return null;
        }

        @Override
        public String getCadeiaCertificadosSenha() {
            return null;
        }
    }
}