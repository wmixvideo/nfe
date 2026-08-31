package com.fincatto.documentofiscal.mdfe3.utils;

import com.fincatto.documentofiscal.mdfe3.FabricaDeObjetosFakeMDFe;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFe;
import com.fincatto.documentofiscal.mdfe3.classes.parsers.MDFChaveParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        Assertions.assertEquals(44, chaveAcesso.length());

        final MDFChaveParser parser = new MDFChaveParser(chaveAcesso);
        Assertions.assertTrue(parser.isEmitentePessoaJuridica());
        Assertions.assertEquals(mdfe.getInfo().getEmitente().getCnpj(), parser.getCnpjEmitente());
    }

    @Test
    public void geraChaveDeAcessoComCnpjAlfanumericoConformeEsperado() {
        final MDFe mdfe = FabricaDeObjetosFakeMDFe.getMDFe1();
        mdfe.getInfo().getEmitente().setCnpj("AB12CD34EF5602");

        final MDFGeraChave geraChave = new MDFGeraChave(mdfe);
        final String chaveAcesso = geraChave.getChaveAcesso();
        Assertions.assertEquals(44, chaveAcesso.length());
        Assertions.assertTrue(chaveAcesso.contains("AB12CD34EF5602"));

        // round-trip: o parser deve reconhecer a mesma chave gerada, sem lancar excecao
        final MDFChaveParser parser = new MDFChaveParser(chaveAcesso);
        Assertions.assertEquals(chaveAcesso, parser.getChave());
        Assertions.assertTrue(parser.isEmitentePessoaJuridica());
        Assertions.assertEquals("AB12CD34EF5602", parser.getCnpjEmitente());

        // o DV calculado pela geracao deve bater com o ultimo digito da propria chave
        Assertions.assertEquals(chaveAcesso.substring(43, 44), String.valueOf(geraChave.getDV()));
    }

    @Test
    public void geraChaveDeAcessoSemCodigoNumericoRetornaExcecao() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final MDFe mdfe = FabricaDeObjetosFakeMDFe.getMDFe1();
            mdfe.getInfo().getIdentificacao().setCodigoNumerico(null);
            new MDFGeraChave(mdfe).getChaveAcesso();
        });
    }
}
