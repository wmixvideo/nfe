package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFRetornoStatusTest {

    @Test
    public void valueOfCodigoStringTest() {
        Assertions.assertEquals(NFRetornoStatus.CODIGO_100, NFRetornoStatus.valueOfCodigo("100"));
    }

    @Test
    public void valueOfCodigoIntegerTest() {
        Assertions.assertEquals(NFRetornoStatus.CODIGO_100, NFRetornoStatus.valueOfCodigo(100));
    }

    @Test
    public void valueOfCodigoNaoMapeadoTest() {
        Assertions.assertNull(NFRetornoStatus.valueOfCodigo(666));
    }

    @Test
    public void isAutorizadoTest() {
        Assertions.assertTrue(NFRetornoStatus.CODIGO_100.isAutorizado());
        Assertions.assertFalse(NFRetornoStatus.CODIGO_620.isAutorizado());
    }

    @Test
    public void isDenegadoTest() {
        Assertions.assertTrue(NFRetornoStatus.CODIGO_110.isDenegado());
        Assertions.assertTrue(NFRetornoStatus.CODIGO_301.isDenegado());
        Assertions.assertTrue(NFRetornoStatus.CODIGO_302.isDenegado());
        Assertions.assertTrue(NFRetornoStatus.CODIGO_303.isDenegado());
        Assertions.assertFalse(NFRetornoStatus.CODIGO_100.isDenegado());
    }

    @Test
    public void isRejeitadoTest() {
        Assertions.assertTrue(NFRetornoStatus.CODIGO_230.isRejeitado());
        Assertions.assertFalse(NFRetornoStatus.CODIGO_100.isRejeitado());
        Assertions.assertFalse(NFRetornoStatus.CODIGO_206.isRejeitado());
    }

    @Test
    public void isDuplicadoTest() {
        Assertions.assertTrue(NFRetornoStatus.CODIGO_539.isDuplicado());
        Assertions.assertTrue(NFRetornoStatus.CODIGO_204.isDuplicado());
        Assertions.assertFalse(NFRetornoStatus.CODIGO_100.isDuplicado());
    }

    @Test
    public void isJaInutilizadoTest() {
        Assertions.assertTrue(NFRetornoStatus.CODIGO_206.isJaInutilizado());
        Assertions.assertFalse(NFRetornoStatus.CODIGO_100.isJaInutilizado());
    }
}