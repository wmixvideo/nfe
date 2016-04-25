package com.fincatto.nfe310.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe310.FabricaDeObjetosFake;

public class NFGeraChaveTest {

	@Test
	public void geraChaveDeAcessoComCPFConformeEsperado() {
		NFNotaInfo info = FabricaDeObjetosFake.getNFNotaInfo();
		info.getEmitente().setCpf("12345678901");
		info.geraChaveIdentificacao();
		Assert.assertEquals(44 + 3, info.getIdentificador().length());
		Assert.assertEquals("NFe43101000012345678901559999999999991999999993", info.getIdentificador());
	}
	
	@Test
	public void geraChaveDeAcessoComCNPJConformeEsperado() {
		NFNotaInfo info = FabricaDeObjetosFake.getNFNotaInfo();
		info.getEmitente().setCpf(null);
		info.getEmitente().setCnpj("12345678901234");
		info.geraChaveIdentificacao();
		Assert.assertEquals(44 + 3, info.getIdentificador().length());
		Assert.assertEquals("NFe43101012345678901234559999999999991999999999", info.getIdentificador());
	}
	
}
