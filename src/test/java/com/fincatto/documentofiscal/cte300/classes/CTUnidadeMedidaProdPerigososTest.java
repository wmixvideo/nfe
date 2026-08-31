package com.fincatto.documentofiscal.cte300.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTUnidadeMedidaProdPerigososTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assertions.assertNull(CTUnidadeMedidaProdPerigosos.valueOfCodigo(null));
    	Assertions.assertEquals("1", CTUnidadeMedidaProdPerigosos.KG.getCodigo());
    	Assertions.assertEquals("2", CTUnidadeMedidaProdPerigosos.KG_G.getCodigo());
    	Assertions.assertEquals("3", CTUnidadeMedidaProdPerigosos.LITROS.getCodigo());
    	Assertions.assertEquals("4", CTUnidadeMedidaProdPerigosos.TI.getCodigo());
    	Assertions.assertEquals("5", CTUnidadeMedidaProdPerigosos.UNIDADES.getCodigo());
	}

}
