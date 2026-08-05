package com.fincatto.documentofiscal.mdfe3.utils;

import com.fincatto.documentofiscal.mdfe3.FabricaDeObjetosFakeMDFe;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFe;
import com.fincatto.documentofiscal.mdfe3.classes.parsers.MDFChaveParser;
import org.junit.Assert;
import org.junit.Test;

/**
 * Testes de {@link MDFGeraChave}, com foco no round-trip gera->parse de chave
 * com CNPJ alfanumerico do emitente (NT 2026.004).
 */
public class MDFGeraChaveTest {

    @Test
    public void geraChaveDeAcessoComCnpjNumericoConformeEsperado() {
        final MDFe mdfe = FabricaDeObjetosFakeMDFe.getMDFe1();
        // "99999999999999" (fixture padrao) tem todos os digitos iguais e e rejeitado por DFUtils.isCnpjValido
        mdfe.getInfo().getEmitente().setCnpj("11222333000181");

        final String chaveAcesso = new MDFGeraChave(mdfe).getChaveAcesso();
        Assert.assertEquals(44, chaveAcesso.length());

        final MDFChaveParser parser = new MDFChaveParser(chaveAcesso);
        Assert.assertTrue(parser.isEmitentePessoaJuridica());
        Assert.assertEquals(mdfe.getInfo().getEmitente().getCnpj(), parser.getCnpjEmitente());
    }

    @Test
    public void geraChaveDeAcessoComCnpjAlfanumericoConformeEsperado() {
        final MDFe mdfe = FabricaDeObjetosFakeMDFe.getMDFe1();
        mdfe.getInfo().getEmitente().setCnpj("AB12CD34EF5602");

        final MDFGeraChave geraChave = new MDFGeraChave(mdfe);
        final String chaveAcesso = geraChave.getChaveAcesso();
        Assert.assertEquals(44, chaveAcesso.length());
        Assert.assertTrue("chave deve conter o CNPJ alfanumerico do emitente", chaveAcesso.contains("AB12CD34EF5602"));

        // round-trip: o parser deve reconhecer a mesma chave gerada, sem lancar excecao
        final MDFChaveParser parser = new MDFChaveParser(chaveAcesso);
        Assert.assertEquals(chaveAcesso, parser.getChave());
        Assert.assertTrue(parser.isEmitentePessoaJuridica());
        Assert.assertEquals("AB12CD34EF5602", parser.getCnpjEmitente());

        // o DV calculado pela geracao deve bater com o ultimo digito da propria chave
        Assert.assertEquals(chaveAcesso.substring(43, 44), String.valueOf(geraChave.getDV()));
    }

    @Test(expected = IllegalStateException.class)
    public void geraChaveDeAcessoSemCodigoNumericoRetornaExcecao() {
        final MDFe mdfe = FabricaDeObjetosFakeMDFe.getMDFe1();
        mdfe.getInfo().getIdentificacao().setCodigoNumerico(null);
        new MDFGeraChave(mdfe).getChaveAcesso();
    }
}
