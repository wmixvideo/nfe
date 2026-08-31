package com.fincatto.documentofiscal.cte200.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTTipoEntregaDataTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("0", CTTipoEntregaData.SEM_DATA.getCodigo());
        Assertions.assertEquals("1", CTTipoEntregaData.NA_DATA.getCodigo());
        Assertions.assertEquals("2", CTTipoEntregaData.ATE_DATA.getCodigo());
        Assertions.assertEquals("3", CTTipoEntregaData.A_PARTIR_DATA.getCodigo());
        Assertions.assertEquals("4", CTTipoEntregaData.NO_PERIODO.getCodigo());
    }
}
