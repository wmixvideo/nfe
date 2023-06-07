package com.fincatto.documentofiscal.cte400.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTTipoImpressaoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assert.assertNull(CTTipoImpressao.valueOfCodigo(null));
    	Assert.assertEquals("1", CTTipoImpressao.RETRATO.getCodigo());
    	Assert.assertEquals("2", CTTipoImpressao.PAISAGEM.getCodigo());
	}

}
