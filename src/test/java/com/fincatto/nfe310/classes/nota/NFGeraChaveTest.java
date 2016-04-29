package com.fincatto.nfe310.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe310.FabricaDeObjetosFake;
import com.fincatto.nfe310.utils.NFGeraChave;

public class NFGeraChaveTest {

	@Test
	public void geraChaveDeAcessoComCPFConformeEsperado() {
		final NFNotaInfo info = FabricaDeObjetosFake.getNFNotaInfo();
		info.getEmitente().setCpf("12345678901");

		final NFNota nota = new NFNota();
		nota.setInfo(info);

		final String chaveAcesso = new NFGeraChave(nota).getChaveAcesso();
		Assert.assertEquals("43101000012345678901559999999999991999999993", chaveAcesso);
		Assert.assertEquals(44, chaveAcesso.length());

		info.setIdentificador(chaveAcesso);
		Assert.assertEquals("NFe43101000012345678901559999999999991999999993", info.getIdentificador());
		Assert.assertEquals(47, info.getIdentificador().length());
	}

	@Test
	public void geraChaveDeAcessoComCNPJConformeEsperado() {
		final NFNotaInfo info = FabricaDeObjetosFake.getNFNotaInfo();
		info.getEmitente().setCpf(null);
		info.getEmitente().setCnpj("12345678901234");

		final NFNota nota = new NFNota();
		nota.setInfo(info);

		final String chaveAcesso = new NFGeraChave(nota).getChaveAcesso();
		Assert.assertEquals("43101012345678901234559999999999991999999999", chaveAcesso);
		Assert.assertEquals(44, chaveAcesso.length());

		info.setIdentificador(chaveAcesso);
		Assert.assertEquals("NFe43101012345678901234559999999999991999999999", info.getIdentificador());
		Assert.assertEquals(47, info.getIdentificador().length());
	}
}