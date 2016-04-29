package com.fincatto.nfe310.classes.nota;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe310.FabricaDeObjetosFake;
import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.classes.NFAmbiente;
import com.fincatto.nfe310.classes.NFTipoEmissao;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;
import com.fincatto.nfe310.utils.NFGeraQRCode;

public class NFGeraQRCodeTest {

	//EXEMPLO DO MANUAL DA RECEITA
	public static final String URL_TEST = "?chNFe=28140300156225000131650110000151341562040824&nVersao=100&tpAmb=1&cDest=13017959000181&dhEmi=323031342d30332d31385431303a35353a33332d30333a3030&vNF=60.90&vICMS=12.75&digVal=797a4759685578312f5859597a6b7357422b6650523351633530633d&cIdToken=000001&cHashQRCode=329f9d7b9fc5650372c1b2699ab88e9e22e0d33a";
	
	@Test
	public void geraQRCodeConformeEsperado() throws NoSuchAlgorithmException {

		final NFNota nota = FabricaDeObjetosFake.getNotaQRCode();

		NFGeraQRCode qr = new NFGeraQRCode(nota, createConfigTest());
		String qrCode = qr.getQRCode();
		
		nota.setInfoSuplementar(new NFNotaInfoSuplementar());
		nota.getInfoSuplementar().setQrCode(qrCode);
		
		String urlUf = nota.getInfo().getIdentificacao().getUf().getQrCodeProducao();
		Assert.assertEquals(urlUf+URL_TEST, nota.getInfoSuplementar().getQrCode());
	}
	
	@Test
	public void geraSHA1() throws Exception{
		String entrada = "chNFe=28140300156225000131650110000151341562040824&nVersao=100&tpAmb=1&cDest=13017959000181&dhEmi=323031342d30332d31385431303a35353a33332d30333a3030&vNF=60.90&vICMS=12.75&digVal=797a4759685578312f5859597a6b7357422b6650523351633530633d&cIdToken=000001SEU-CODIGO-CSC-CONTRIBUINTE-36-CARACTERES";
		String saida = NFGeraQRCode.sha1(entrada);
		Assert.assertEquals(saida, "329f9d7b9fc5650372c1b2699ab88e9e22e0d33a");
	}

	private NFeConfig createConfigTest() {
		return new NFeConfig() {
			@Override
			public Integer getCodigoSegurancaContribuinteID() {
				return 1;
			}
			@Override
			public String getCodigoSegurancaContribuinte() {
				return "SEU-CODIGO-CSC-CONTRIBUINTE-36-CARACTERES";
			}
			@Override
			public NFUnidadeFederativa getCUF() {
				return NFUnidadeFederativa.SE;
			}
			@Override
			public NFAmbiente getAmbiente() {
				return NFAmbiente.PRODUCAO;
			}
			
			public NFTipoEmissao getTipoEmissao() {return null;}
			public String getSSLProtocolo() {return null;}
			public String getCertificadoSenha() {return null;}
			public byte[] getCertificado() throws IOException {return null;}
			public String getCadeiaCertificadosSenha() {return null;}
			public byte[] getCadeiaCertificados() throws IOException {return null;}
		};
	}

	
}