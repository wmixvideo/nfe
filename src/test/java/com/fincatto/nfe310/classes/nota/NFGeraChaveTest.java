package com.fincatto.nfe310.classes.nota;

import java.util.TimeZone;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fincatto.nfe310.FabricaDeObjetosFake;
import com.fincatto.nfe310.utils.NFGeraChave;

public class NFGeraChaveTest {
	
	@BeforeClass
	public static void setUpBeforeClass() {
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
	}

    @Test
    public void geraChaveDeAcessoComCPFConformeEsperado() {
        final NFNota nota = new NFNota();
        nota.setInfo(FabricaDeObjetosFake.getNFNotaInfo());
        nota.getInfo().getEmitente().setCpf("12345678901");
        nota.getInfo().getEmitente().setCnpj(null);

        final String chaveAcesso = new NFGeraChave(nota).getChaveAcesso();
        Assert.assertEquals("43101000012345678901559999999999991999999993", chaveAcesso);
        Assert.assertEquals(44, chaveAcesso.length());

        nota.getInfo().setIdentificador(chaveAcesso);
        Assert.assertEquals("NFe43101000012345678901559999999999991999999993", nota.getInfo().getIdentificador());
        Assert.assertEquals(47, nota.getInfo().getIdentificador().length());
    }

    @Test
    public void geraChaveDeAcessoComCNPJConformeEsperado() {
        final NFNota nota = new NFNota();
        nota.setInfo(FabricaDeObjetosFake.getNFNotaInfo());
        nota.getInfo().getEmitente().setCpf(null);
        nota.getInfo().getEmitente().setCnpj("12345678901234");

        final String chaveAcesso = new NFGeraChave(nota).getChaveAcesso();
        Assert.assertEquals("43101012345678901234559999999999991999999999", chaveAcesso);
        Assert.assertEquals(44, chaveAcesso.length());

        nota.getInfo().setIdentificador(chaveAcesso);
        Assert.assertEquals("NFe43101012345678901234559999999999991999999999", nota.getInfo().getIdentificador());
        Assert.assertEquals(47, nota.getInfo().getIdentificador().length());
    }

    @Test
    public void geraChaveDeAcessoRandomica() {
        final NFNota nota = new NFNota();
        nota.setInfo(FabricaDeObjetosFake.getNFNotaInfo());
        nota.getInfo().getEmitente().setCpf(null);
        nota.getInfo().getEmitente().setCnpj("12345678901234");

        final NFGeraChave geraChave = new NFGeraChave(nota);
        nota.getInfo().getIdentificacao().setCodigoRandomico(geraChave.geraCodigoRandomico());

        final String chaveAcesso = geraChave.getChaveAcesso();
        Assert.assertEquals("43101012345678901234559999999999991696178050", chaveAcesso);
        Assert.assertEquals(44, chaveAcesso.length());

        nota.getInfo().setIdentificador(chaveAcesso);
        Assert.assertEquals("NFe43101012345678901234559999999999991696178050", nota.getInfo().getIdentificador());
        Assert.assertEquals(47, nota.getInfo().getIdentificador().length());
    }

    @Test(expected = IllegalStateException.class)
    public void geraChaveDeAcessoSemCodigoRandomicoRetornaExcecao() {
        final NFNota nota = new NFNota();
        nota.setInfo(FabricaDeObjetosFake.getNFNotaInfo());
        nota.getInfo().getIdentificacao().setCodigoRandomico(null);
        new NFGeraChave(nota).getChaveAcesso();
    }
}