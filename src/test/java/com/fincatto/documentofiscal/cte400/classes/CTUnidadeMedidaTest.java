package com.fincatto.documentofiscal.cte400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTUnidadeMedidaTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assertions.assertNull(CTUnidadeMedida.valueOfCodigo(null));
    	Assertions.assertEquals("00", CTUnidadeMedida.M3.getCodigo());
    	Assertions.assertEquals("01", CTUnidadeMedida.KG.getCodigo());
    	Assertions.assertEquals("02", CTUnidadeMedida.TON.getCodigo());
    	Assertions.assertEquals("03", CTUnidadeMedida.UNIDADE.getCodigo());
    	Assertions.assertEquals("04", CTUnidadeMedida.LITROS.getCodigo());
    	Assertions.assertEquals("05", CTUnidadeMedida.MMBTU.getCodigo());
	}

}
