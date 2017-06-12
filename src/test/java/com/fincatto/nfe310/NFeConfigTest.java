package com.fincatto.nfe310;

import com.fincatto.nfe310.classes.NFTipoEmissao;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;
import org.junit.Assert;
import org.junit.Test;

import java.security.KeyStore;
import java.security.KeyStoreException;

public class NFeConfigTest {

    @Test
    public void testaParametrosPadrao() {
        final NFeConfigTeste config = new NFeConfigTeste();

        Assert.assertEquals("TLSv1", config.getSSLProtocolo());
        Assert.assertEquals(NFTipoEmissao.EMISSAO_NORMAL, config.getTipoEmissao());
        Assert.assertNull(config.getCodigoSegurancaContribuinte());
        Assert.assertNull(config.getCodigoSegurancaContribuinteID());
    }

    private class NFeConfigTeste extends NFeConfig {

        @Override
        public NFUnidadeFederativa getCUF() {
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
		public String getCertificadoAlias(){
			return null;
		}
    }
}