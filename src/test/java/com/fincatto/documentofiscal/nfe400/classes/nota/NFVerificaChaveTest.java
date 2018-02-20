package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe400.utils.NFVerificaChave;

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
        Assert.assertEquals(chave.length(), 44);
        final NFVerificaChave nfVerificaChave = new NFVerificaChave(chave);
        Assert.assertTrue(nfVerificaChave.isChaveValida());
        chave = "53101000012345678901559999999999991999999993";
        Assert.assertFalse(NFVerificaChave.isChaveValida(chave));
        chave = "43101000012345678901559999999999991999999";
        Assert.assertEquals(chave.length(), 41);
        Assert.assertFalse(NFVerificaChave.isChaveValida(chave));
    }

}