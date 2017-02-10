package com.fincatto.nfe310;

import java.security.KeyStore;
import java.security.KeyStoreException;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.dfe.classes.DFAmbiente;
import com.fincatto.dfe.classes.DFTipoEmissao;
import com.fincatto.dfe.classes.DFUnidadeFederativa;

public class NFeConfigTest {

	private final NFeConfigTeste config = new NFeConfigTeste();

    @Test
    public void testaParametrosPadrao() {
        Assert.assertEquals(DFAmbiente.HOMOLOGACAO, config.getAmbiente());
        Assert.assertEquals(DFTipoEmissao.EMISSAO_NORMAL, config.getTipoEmissao());
        Assert.assertEquals("TLSv1", config.getSSLProtocolo());
        Assert.assertNull(config.getCodigoSegurancaContribuinte());
        Assert.assertNull(config.getCodigoSegurancaContribuinteID());
    }

    @Test
    public void testaParametrosImplementados() throws KeyStoreException {
        Assert.assertNull(config.getCUF());
        Assert.assertNull(config.getCertificadoKeyStore());
        Assert.assertNull(config.getCertificadoSenha());
        Assert.assertNull(config.getCadeiaCertificadosKeyStore());
        Assert.assertNull(config.getCadeiaCertificadosSenha());
    }

    private class NFeConfigTeste extends NFeConfig {

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

        @Override
        public DFAmbiente getAmbiente() {
            return null;
        }
    }
}