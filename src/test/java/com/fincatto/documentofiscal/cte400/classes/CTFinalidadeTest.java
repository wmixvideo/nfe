package com.fincatto.documentofiscal.cte400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTFinalidadeTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assertions.assertNull(CTFinalidade.valueOfCodigo(null));
    	Assertions.assertEquals("0", CTFinalidade.NORMAL.getCodigo());
    	Assertions.assertEquals("1", CTFinalidade.COMPLEMENTAR.getCodigo());
    	Assertions.assertEquals("3", CTFinalidade.SUBSTITUTO.getCodigo());
    }

}
