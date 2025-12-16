package com.fincatto.documentofiscal.nfe400.utils;

import junit.framework.TestCase;
import org.junit.Test;

public class ChaveAcessoUtilsTest extends TestCase {

    @Test
    public void testGeraIDevento_deveGerarIdComZeroEsquerdaSequancial() {
        String idGerado = ChaveAcessoUtils.geraIDevento("12345678901234567890123456789012345678901234", "110112", 5);
        assertEquals("ID1101121234567890123456789012345678901234567890123405", idGerado);
    }

    @Test
    public void testGeraIDevento_naoDeveGerarIdComZeroEsquerdaSequancial() {
        String idGerado = ChaveAcessoUtils.geraIDevento("12345678901234567890123456789012345678901234", "110112", 10);
        assertEquals("ID1101121234567890123456789012345678901234567890123410", idGerado);
    }
}