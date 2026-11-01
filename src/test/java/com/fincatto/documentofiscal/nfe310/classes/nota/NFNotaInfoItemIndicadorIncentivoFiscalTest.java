package com.fincatto.documentofiscal.nfe310.classes.nota;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoItemIndicadorIncentivoFiscalTest {

    @Test
    public void deveObterTipoApartirDoSeuCodigo() {
        Assertions.assertEquals(NFNotaInfoItemIndicadorIncentivoFiscal.SIM, NFNotaInfoItemIndicadorIncentivoFiscal.valueOfCodigo("1"));
        Assertions.assertEquals(NFNotaInfoItemIndicadorIncentivoFiscal.NAO, NFNotaInfoItemIndicadorIncentivoFiscal.valueOfCodigo("2"));
        Assertions.assertNull(NFNotaInfoItemIndicadorIncentivoFiscal.valueOfCodigo("3"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("1", NFNotaInfoItemIndicadorIncentivoFiscal.SIM.getCodigo());
        Assertions.assertEquals("2", NFNotaInfoItemIndicadorIncentivoFiscal.NAO.getCodigo());
    }

    @Test
    public void deveObterStringficadoCorretamente() {
        Assertions.assertEquals("1 - Sim", NFNotaInfoItemIndicadorIncentivoFiscal.SIM.toString());
    }
}