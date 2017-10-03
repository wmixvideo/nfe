package com.fincatto.documentofiscal;
import java.security.KeyStore;
import java.security.KeyStoreException;

import org.junit.Assert;

public class DFConfigTest {

	public void testaParametrosPadrao() {
		final DFConfig config = new DFConfigTeste();
		
		Assert.assertEquals(DFAmbiente.HOMOLOGACAO, config.getAmbiente());
		Assert.assertEquals(DFModelo.NFE, config.getModelo());
		Assert.assertEquals("TLSv1.2", config.getSSLProtocolo());
	}
	
	public class DFConfigTeste extends DFConfig {

		@Override
		public DFUnidadeFederativa getCUF() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public KeyStore getCertificadoKeyStore() throws KeyStoreException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getCertificadoSenha() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public KeyStore getCadeiaCertificadosKeyStore()
				throws KeyStoreException {
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
