package com.fincatto.documentofiscal.cte400.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTUnidadeMedidaProdPerigososTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assert.assertNull(CTUnidadeMedidaProdPerigosos.valueOfCodigo(null));
    	Assert.assertEquals("1", CTUnidadeMedidaProdPerigosos.KG.getCodigo());
    	Assert.assertEquals("2", CTUnidadeMedidaProdPerigosos.KG_G.getCodigo());
    	Assert.assertEquals("3", CTUnidadeMedidaProdPerigosos.LITROS.getCodigo());
    	Assert.assertEquals("4", CTUnidadeMedidaProdPerigosos.TI.getCodigo());
    	Assert.assertEquals("5", CTUnidadeMedidaProdPerigosos.UNIDADES.getCodigo());
	}

}
