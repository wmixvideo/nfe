package com.fincatto.documentofiscal.nfe310.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFRetornoStatusTest {

    @Test
    public void valueOfCodigoStringTest() {
        Assertions.assertEquals(NFRetornoStatus.AUTORIZADO_USO_NFE, NFRetornoStatus.valueOfCodigo("100"));
    }

    @Test
    public void valueOfCodigoIntegerTest() {
        Assertions.assertEquals(NFRetornoStatus.AUTORIZADO_USO_NFE, NFRetornoStatus.valueOfCodigo(100));
    }

    @Test
    public void valueOfCodigoNaoMapeadoTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> NFRetornoStatus.valueOfCodigo(666));
    }

    @Test
    public void isAutorizadoTest() {
        Assertions.assertTrue(NFRetornoStatus.AUTORIZADO_USO_NFE.isAutorizado());
        Assertions.assertFalse(NFRetornoStatus.CHAVE_DE_ACESSO_DIFERENTE_NO_DB_SEFAZ.isAutorizado());
    }

    @Test
    public void isDenegadoTest() {
        Assertions.assertTrue(NFRetornoStatus.CODIGO_110.isDenegado());
        Assertions.assertTrue(NFRetornoStatus.CODIGO_301.isDenegado());
        Assertions.assertTrue(NFRetornoStatus.CODIGO_302.isDenegado());
        Assertions.assertTrue(NFRetornoStatus.CODIGO_303.isDenegado());
        Assertions.assertFalse(NFRetornoStatus.AUTORIZADO_USO_NFE.isDenegado());
    }

    @Test
    public void isRejeitadoTest() {
        Assertions.assertTrue(NFRetornoStatus.CODIGO_230.isRejeitado());
        Assertions.assertFalse(NFRetornoStatus.AUTORIZADO_USO_NFE.isRejeitado());
    }

    @Test
    public void isDuplicadoTest() {
        Assertions.assertTrue(NFRetornoStatus.CODIGO_539.isDuplicado());
        Assertions.assertFalse(NFRetornoStatus.AUTORIZADO_USO_NFE.isDuplicado());
    }
}