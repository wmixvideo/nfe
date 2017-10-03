package com.fincatto.documentofiscal.cte300;

import static org.junit.Assert.*;

import java.security.KeyStore;
import java.security.KeyStoreException;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.cte200.classes.CTTipoEmissao;

public class CTeConfigTest {

    @Test
    public void testaParametrosPadrao() {
    	final CTeConfigTeste config = new CTeConfigTeste();
    	
    	Assert.assertEquals("3.00", config.VERSAO);
    	Assert.assertEquals("http://www.portalfiscal.inf.br/cte", config.NAMESPACE);
    	Assert.assertEquals(com.fincatto.documentofiscal.cte300.classes.CTTipoEmissao.EMISSAO_NORMAL, config.getTipoEmissao());
    }
    
    public class CTeConfigTeste extends CTeConfig {

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
