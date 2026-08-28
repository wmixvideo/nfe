package com.fincatto.documentofiscal.cte400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTTipoUnidadeCargaTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assertions.assertNull(CTTipoUnidadeCarga.valueOfCodigo(null));
    	Assertions.assertEquals("1", CTTipoUnidadeCarga.CONTAINER.getCodigo());
    	Assertions.assertEquals("2", CTTipoUnidadeCarga.ULD.getCodigo());
    	Assertions.assertEquals("3", CTTipoUnidadeCarga.PALLET.getCodigo());
    	Assertions.assertEquals("4", CTTipoUnidadeCarga.OUTROS.getCodigo());
	}

}
