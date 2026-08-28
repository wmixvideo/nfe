package com.fincatto.documentofiscal.cte400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTTipoFerroviaTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assertions.assertNull(CTTipoFerrovia.valueOfCodigo(null));
    	Assertions.assertEquals("1", CTTipoFerrovia.FERROVIA_ORIGEM.getCodigo());
    	Assertions.assertEquals("2", CTTipoFerrovia.FERROVIS_DESTINO.getCodigo());
	}

}
