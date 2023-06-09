package com.fincatto.documentofiscal.cte400.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTTipoFerroviaTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assert.assertNull(CTTipoFerrovia.valueOfCodigo(null));
    	Assert.assertEquals("1", CTTipoFerrovia.FERROVIA_ORIGEM.getCodigo());
    	Assert.assertEquals("2", CTTipoFerrovia.FERROVIS_DESTINO.getCodigo());
	}

}
