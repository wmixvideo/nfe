package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFTipoTest {

    @Test
    public void deveObterTipoApartirDoSeuCodigo() {
        Assertions.assertEquals(NFTipo.ENTRADA, NFTipo.valueOfCodigo("0"));
        Assertions.assertEquals(NFTipo.SAIDA, NFTipo.valueOfCodigo("1"));
        Assertions.assertNull(NFTipo.valueOfCodigo("2"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("0", NFTipo.ENTRADA.getCodigo());
        Assertions.assertEquals("1", NFTipo.SAIDA.getCodigo());
    }

    @Test
    public void deveRepresentarToStringCorretamente() {
        Assertions.assertEquals("0 - Entrada", NFTipo.ENTRADA.toString());
        Assertions.assertEquals("1 - Sa\u00edda", NFTipo.SAIDA.toString());
    }
}