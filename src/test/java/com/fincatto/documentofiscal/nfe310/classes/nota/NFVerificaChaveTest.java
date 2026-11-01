package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.utils.NFVerificaChave;
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

}