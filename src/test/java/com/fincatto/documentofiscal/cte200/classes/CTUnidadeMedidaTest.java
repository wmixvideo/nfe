package com.fincatto.documentofiscal.cte200.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTUnidadeMedidaTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("00", CTUnidadeMedida.M3.getCodigo());
        Assertions.assertEquals("01", CTUnidadeMedida.KG.getCodigo());
        Assertions.assertEquals("02", CTUnidadeMedida.TON.getCodigo());
        Assertions.assertEquals("03", CTUnidadeMedida.UNIDADE.getCodigo());
        Assertions.assertEquals("04", CTUnidadeMedida.LITRO.getCodigo());
        Assertions.assertEquals("05", CTUnidadeMedida.MMBTU.getCodigo());
    }

}
