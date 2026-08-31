package com.fincatto.documentofiscal.nfe400.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChaveAcessoUtilsTest {

    @Test
    public void testGeraIDevento_deveGerarIdComZeroEsquerdaSequancial() {
        String idGerado = ChaveAcessoUtils.geraIDevento("12345678901234567890123456789012345678901234", "110112", 5);
        Assertions.assertEquals("ID1101121234567890123456789012345678901234567890123405", idGerado);
    }

    @Test
    public void testGeraIDevento_naoDeveGerarIdComZeroEsquerdaSequancial() {
        String idGerado = ChaveAcessoUtils.geraIDevento("12345678901234567890123456789012345678901234", "110112", 10);
        Assertions.assertEquals("ID1101121234567890123456789012345678901234567890123410", idGerado);
    }
}