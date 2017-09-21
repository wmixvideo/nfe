package com.fincatto.documentofiscal.nfe310.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe310.classes.nota.NFIndicadorIEDestinatario;
import com.fincatto.documentofiscal.nfe310.classes.nota.NFNotaInfoDestinatario;

public class NFNotaInfoDestinatarioTest {

	@Test(expected = IllegalStateException.class)
	public void naoDevePermitirCNPJComTamanhoInvalido() {
		try {
			new NFNotaInfoDestinatario().setCnpj("1234567890123");
		} catch (final IllegalStateException e) {
			new NFNotaInfoDestinatario().setCnpj("123456789012345");
		}
	}

	@Test(expected = IllegalStateException.class)
	public void naoDevePermitirCPFComTamanhoInvalido() {
		try {
			new NFNotaInfoDestinatario().setCpf("1234567890");
		} catch (final IllegalStateException e) {
			new NFNotaInfoDestinatario().setCpf("123456789012");
		}
	}

	@Test(expected = IllegalStateException.class)
	public void naoDevePermitirCNPJSetadoQuandoCPFEstaSetado() {
		final NFNotaInfoDestinatario entrega = new NFNotaInfoDestinatario();
		entrega.setCpf("12345678901");
		entrega.setCnpj("12345678901234");
	}

	@Test(expected = IllegalStateException.class)
	public void naoDevePermitirCPFSetadoQuandoCNPJEstaSetado() {
		final NFNotaInfoDestinatario entrega = new NFNotaInfoDestinatario();
		entrega.setCnpj("12345678901234");
		entrega.setCpf("12345678901");
	}

	@Test(expected = IllegalStateException.class)
	public void naoDevePermitirRazoaSocialTamanhoInvalido() {
		try {
			new NFNotaInfoDestinatario().setRazaoSocial("");
		} catch (final IllegalStateException e) {
			new NFNotaInfoDestinatario().setRazaoSocial("F7HL85M9v7jW5lX4Z9V7sF3kshuj967gj4uACEmpmVQgM9yYeQAgaY5EcSfR1");
		}
	}

	@Test(expected = IllegalStateException.class)
	public void naoDevePermitirEmailTamanhoInvalido() {
		try {
			new NFNotaInfoDestinatario().setEmail("");
		} catch (final IllegalStateException e) {
			new NFNotaInfoDestinatario().setEmail("F7HL85M9v7jW5lX4Z9V7sF3kshuj967gj4uACEmpmVQgM9yYeQAgaY5EcSfR1");
		}
	}

	@Test(expected = IllegalStateException.class)
	public void naoDevePermitirInscricaoSuframaTamanhoInvalido() {
		try {
			new NFNotaInfoDestinatario().setInscricaoSuframa("4cxG54P");
		} catch (final IllegalStateException e) {
			new NFNotaInfoDestinatario().setInscricaoSuframa("4cxG54PXx1");
		}
	}

	@Test
	public void devePermitirInscricaoMunicipalNuloNulo() {
		final NFNotaInfoDestinatario destinatario = new NFNotaInfoDestinatario();
		destinatario.setEmail("ivU3ctXKzImStrYzRpDTXRyCfSzxlEe5GTbeyVZ1OlIvgKGLJJMJlaKtYj8K");
		destinatario.setCnpj("12345678901234");
		destinatario.setEndereco(FabricaDeObjetosFake.getNFEndereco());
		destinatario.setInscricaoEstadual("ISENTO");
		destinatario.setIndicadorIEDestinatario(NFIndicadorIEDestinatario.NAO_CONTRIBUINTE);
		destinatario.setInscricaoSuframa("999999999");
		destinatario.setRazaoSocial("F7HL85M9v7jW5lX4Z9V7sF3kshuj967gj4uACEmpmVQgM9yYeQAgaY5EcSfR");
		destinatario.toString();
	}

	@Test(expected = IllegalStateException.class)
	public void naoDevePermitirNFIndicadorIEDestinatarioNulo() {
		final NFNotaInfoDestinatario destinatario = new NFNotaInfoDestinatario();
		destinatario.setEmail("ivU3ctXKzImStrYzRpDTXRyCfSzxlEe5GTbeyVZ1OlIvgKGLJJMJlaKtYj8K");
		destinatario.setCnpj("12345678901234");
		destinatario.setEndereco(FabricaDeObjetosFake.getNFEndereco());
		destinatario.setInscricaoEstadual("ISENTO");
		destinatario.setInscricaoSuframa("999999999");
		destinatario.setRazaoSocial("F7HL85M9v7jW5lX4Z9V7sF3kshuj967gj4uACEmpmVQgM9yYeQAgaY5EcSfR");
		destinatario.setInscricaoMunicipal("5ow5E1mZQPe1VUR");
		destinatario.toString();
	}

	@Test
	public void devePermitirCPFNulo() {
		final NFNotaInfoDestinatario destinatario = new NFNotaInfoDestinatario();
		destinatario.setEmail("ivU3ctXKzImStrYzRpDTXRyCfSzxlEe5GTbeyVZ1OlIvgKGLJJMJlaKtYj8K");
		destinatario.setCnpj("12345678901234");
		destinatario.setEndereco(FabricaDeObjetosFake.getNFEndereco());
		destinatario.setInscricaoEstadual("ISENTO");
		destinatario.setInscricaoSuframa("999999999");
		destinatario.setRazaoSocial("F7HL85M9v7jW5lX4Z9V7sF3kshuj967gj4uACEmpmVQgM9yYeQAgaY5EcSfR");
		destinatario.setIndicadorIEDestinatario(NFIndicadorIEDestinatario.NAO_CONTRIBUINTE);
		destinatario.setInscricaoMunicipal("5ow5E1mZQPe1VUR");
		destinatario.toString();
	}

	@Test
	public void devePermitirCNPJNulo() {
		final NFNotaInfoDestinatario destinatario = new NFNotaInfoDestinatario();
		destinatario.setEmail("ivU3ctXKzImStrYzRpDTXRyCfSzxlEe5GTbeyVZ1OlIvgKGLJJMJlaKtYj8K");
		destinatario.setCpf("13245678901");
		destinatario.setEndereco(FabricaDeObjetosFake.getNFEndereco());
		destinatario.setInscricaoEstadual("ISENTO");
		destinatario.setInscricaoSuframa("999999999");
		destinatario.setRazaoSocial("F7HL85M9v7jW5lX4Z9V7sF3kshuj967gj4uACEmpmVQgM9yYeQAgaY5EcSfR");
		destinatario.setIndicadorIEDestinatario(NFIndicadorIEDestinatario.NAO_CONTRIBUINTE);
		destinatario.setInscricaoMunicipal("5ow5E1mZQPe1VUR");
		destinatario.toString();
	}

	@Test
	public void devePermitirEmailNulo() {
		final NFNotaInfoDestinatario destinatario = new NFNotaInfoDestinatario();
		destinatario.setCnpj("12345678901234");
		destinatario.setEndereco(FabricaDeObjetosFake.getNFEndereco());
		destinatario.setInscricaoEstadual("ISENTO");
		destinatario.setInscricaoSuframa("999999999");
		destinatario.setRazaoSocial("F7HL85M9v7jW5lX4Z9V7sF3kshuj967gj4uACEmpmVQgM9yYeQAgaY5EcSfR");
		destinatario.setIndicadorIEDestinatario(NFIndicadorIEDestinatario.NAO_CONTRIBUINTE);
		destinatario.setInscricaoMunicipal("5ow5E1mZQPe1VUR");
		destinatario.toString();
	}

	@Test
	public void devePermitirEnderecoNulo() {
		final NFNotaInfoDestinatario destinatario = new NFNotaInfoDestinatario();
		destinatario.setCnpj("12345678901234");
		destinatario.setEmail("ivU3ctXKzImStrYzRpDTXRyCfSzxlEe5GTbeyVZ1OlIvgKGLJJMJlaKtYj8K");
		destinatario.setInscricaoEstadual("ISENTO");
		destinatario.setInscricaoSuframa("999999999");
		destinatario.setRazaoSocial("F7HL85M9v7jW5lX4Z9V7sF3kshuj967gj4uACEmpmVQgM9yYeQAgaY5EcSfR");
		destinatario.setIndicadorIEDestinatario(NFIndicadorIEDestinatario.NAO_CONTRIBUINTE);
		destinatario.setInscricaoMunicipal("5ow5E1mZQPe1VUR");
		destinatario.toString();
	}

	@Test
	public void devePermitirInscricaoEstadualNulo() {
		final NFNotaInfoDestinatario destinatario = new NFNotaInfoDestinatario();
		destinatario.setCnpj("12345678901234");
		destinatario.setEmail("ivU3ctXKzImStrYzRpDTXRyCfSzxlEe5GTbeyVZ1OlIvgKGLJJMJlaKtYj8K");
		destinatario.setEndereco(FabricaDeObjetosFake.getNFEndereco());
		destinatario.setInscricaoSuframa("999999999");
		destinatario.setRazaoSocial("F7HL85M9v7jW5lX4Z9V7sF3kshuj967gj4uACEmpmVQgM9yYeQAgaY5EcSfR");
		destinatario.setIndicadorIEDestinatario(NFIndicadorIEDestinatario.NAO_CONTRIBUINTE);
		destinatario.setInscricaoMunicipal("5ow5E1mZQPe1VUR");
		destinatario.toString();
	}

	@Test
	public void devePermitirInscricaoSuframaNulo() {
		final NFNotaInfoDestinatario destinatario = new NFNotaInfoDestinatario();
		destinatario.setCnpj("12345678901234");
		destinatario.setEmail("ivU3ctXKzImStrYzRpDTXRyCfSzxlEe5GTbeyVZ1OlIvgKGLJJMJlaKtYj8K");
		destinatario.setEndereco(FabricaDeObjetosFake.getNFEndereco());
		destinatario.setInscricaoEstadual("ISENTO");
		destinatario.setRazaoSocial("F7HL85M9v7jW5lX4Z9V7sF3kshuj967gj4uACEmpmVQgM9yYeQAgaY5EcSfR");
		destinatario.setIndicadorIEDestinatario(NFIndicadorIEDestinatario.NAO_CONTRIBUINTE);
		destinatario.setInscricaoMunicipal("5ow5E1mZQPe1VUR");
		destinatario.toString();
	}

	@Test
	public void devePermitirIdEstrangeiroComTamanhoZero() {
		final NFNotaInfoDestinatario destinatario = new NFNotaInfoDestinatario();
		destinatario.setCnpj("12345678901234");
		destinatario.setEmail("ivU3ctXKzImStrYzRpDTXRyCfSzxlEe5GTbeyVZ1OlIvgKGLJJMJlaKtYj8K");
		destinatario.setEndereco(FabricaDeObjetosFake.getNFEndereco());
		destinatario.setInscricaoEstadual("ISENTO");
		destinatario.setRazaoSocial("F7HL85M9v7jW5lX4Z9V7sF3kshuj967gj4uACEmpmVQgM9yYeQAgaY5EcSfR");
		destinatario.setIndicadorIEDestinatario(NFIndicadorIEDestinatario.NAO_CONTRIBUINTE);
		destinatario.setInscricaoMunicipal("5ow5E1mZQPe1VUR");
		destinatario.setIdEstrangeiro("");
		destinatario.toString();
	}

	@Test
	public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
		final String xmlEsperado = "<NFNotaInfoDestinatario><CNPJ>12345678901234</CNPJ><xNome>F7HL85M9v7jW5lX4Z9V7sF3kshuj967gj4uACEmpmVQgM9yYeQAgaY5EcSfR</xNome><enderDest><xLgr>NKwaAJ5ZJ49aQYmqBvxMhBzkGUqvtXnqusGEtjDzKCXPGwrEZCS8LGKHyBbV</xLgr><nro>11mzXHR8rZTgfE35EqfGhiShiIwQfLCAziFDXVgs3EjLSPkZkCvfGNLMEf5y</nro><xCpl>Fr3gSvoAeKbGpQD3r98KFeB50P3Gq14XBVsv5fpiaBvJ3HTOpREiwYGs20Xw</xCpl><xBairro>67LQFlXOBK0JqAE1rFi2CEyUGW5Z8QmmHhzmZ9GABVLKa9AbV0uFR0onl7nU</xBairro><cMun>9999999</cMun><xMun>s1Cr2hWP6bptQ80A9vWBuTaODR1U82LtKQi1DEm3LsAXu9AbkSeCtfXJVTKG</xMun><UF>RS</UF><CEP>88095550</CEP><cPais>1058</cPais><fone>12345678901324</fone></enderDest><indIEDest>9</indIEDest><IE>13245678901234</IE><ISUF>999999999</ISUF><IM>5ow5E1mZQPe1VUR</IM><email>ivU3ctXKzImStrYzRpDTXRyCfSzxlEe5GTbeyVZ1OlIvgKGLJJMJlaKtYj8K</email></NFNotaInfoDestinatario>";
		Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoDestinatario().toString());
	}
}