package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.utils.NFVerificaChave;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Testes para a classe {@link NFVerificaChave}
 */
public class NFVerificaChaveTest {

    /**
     * Verifica se uma chave de acesso é válida.
     */
    @Test
    public void verificaChave() {
        String chave = "43101000012345678901559999999999991999999993";
        Assertions.assertEquals(chave.length(), 44);
        final NFVerificaChave nfVerificaChave = new NFVerificaChave(chave);
        Assertions.assertTrue(nfVerificaChave.isChaveValida());
        chave = "53101000012345678901559999999999991999999993";
        Assertions.assertFalse(NFVerificaChave.isChaveValida(chave));
        chave = "43101000012345678901559999999999991999999";
        Assertions.assertEquals(chave.length(), 41);
        Assertions.assertFalse(NFVerificaChave.isChaveValida(chave));
    }

    /**
     * Chave com CNPJ alfanumerico do emitente (NT 2026.004) nas posicoes 6-19.<br>
     * Antes da correcao, o calculo do DV usava Integer.parseInt sobre cada caractere
     * da chave e lancava NumberFormatException ao encontrar uma letra.
     */
    @Test
    public void verificaChaveComCnpjAlfanumericoNaoLancaExcecaoECalculaDVCorretamente() {
        final String chaveValida = "432505AB123456789012550010000000011000000011";
        Assertions.assertEquals(44, chaveValida.length());
        final NFVerificaChave nfVerificaChave = new NFVerificaChave(chaveValida);
        Assertions.assertEquals(Integer.valueOf(1), nfVerificaChave.calculaDV());
        Assertions.assertTrue(nfVerificaChave.isChaveValida());
    }

    @Test
    public void verificaChaveComCnpjAlfanumericoEDVIncorretoRetornaInvalida() {
        final String chaveComDvErrado = "432505AB123456789012550010000000011000000012";
        Assertions.assertFalse(NFVerificaChave.isChaveValida(chaveComDvErrado));
    }

}