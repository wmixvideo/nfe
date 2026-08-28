package com.fincatto.documentofiscal.cte300.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
 * Created by Eldevan Nery Junior on 22/07/2022 13:46
 */
public class CTRetornoStatusTest {

    @Test
    public void valueOfCodigoStringTest() {
        Assertions.assertEquals(CTRetornoStatus.CODIGO_100, CTRetornoStatus.valueOfCodigo("100"));
    }

    @Test
    public void valueOfCodigoIntegerTest() {
        Assertions.assertEquals(CTRetornoStatus.CODIGO_100, CTRetornoStatus.valueOfCodigo(100));
    }

    @Test
    public void valueOfCodigoNaoMapeadoTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Assertions.assertNull(CTRetornoStatus.valueOfCodigo(900)));
    }

    @Test
    public void isAutorizadoTest() {
        Assertions.assertTrue(CTRetornoStatus.CODIGO_100.isAutorizado());
    }

    @Test
    public void isDenegadoTest() {
        Assertions.assertTrue(CTRetornoStatus.CODIGO_110.isDenegado());
        Assertions.assertTrue(CTRetornoStatus.CODIGO_301.isDenegado());
        Assertions.assertTrue(CTRetornoStatus.CODIGO_302.isDenegado());
        Assertions.assertTrue(CTRetornoStatus.CODIGO_303.isDenegado());
        Assertions.assertTrue(CTRetornoStatus.CODIGO_304.isDenegado());
        Assertions.assertTrue(CTRetornoStatus.CODIGO_305.isDenegado());
        Assertions.assertTrue(CTRetornoStatus.CODIGO_306.isDenegado());
        Assertions.assertFalse(CTRetornoStatus.CODIGO_100.isDenegado());
    }

    @Test
    public void isRejeitadoTest() {
        Assertions.assertTrue(CTRetornoStatus.CODIGO_230.isRejeitado());
        Assertions.assertFalse(CTRetornoStatus.CODIGO_100.isRejeitado());
    }

    @Test
    public void isDuplicadoTest() {
        Assertions.assertTrue(CTRetornoStatus.CODIGO_539.isDuplicado());
        Assertions.assertFalse(CTRetornoStatus.CODIGO_100.isDuplicado());
    }

}