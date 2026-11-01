package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFProdutoCompoeValorNotaTest {

    @Test
    public void deveObterProdutoCampoValorNotaApartirDoSeuCodigo() {
        Assertions.assertEquals(NFProdutoCompoeValorNota.NAO, NFProdutoCompoeValorNota.valueOfCodigo("0"));
        Assertions.assertEquals(NFProdutoCompoeValorNota.SIM, NFProdutoCompoeValorNota.valueOfCodigo("1"));
        Assertions.assertNull(NFProdutoCompoeValorNota.valueOfCodigo("2"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("0", NFProdutoCompoeValorNota.NAO.getCodigo());
        Assertions.assertEquals("1", NFProdutoCompoeValorNota.SIM.getCodigo());
    }

    @Test
    public void deveObterStringficadoCorretamente() {
        Assertions.assertEquals("1 - Sim", NFProdutoCompoeValorNota.SIM.toString());
    }
}