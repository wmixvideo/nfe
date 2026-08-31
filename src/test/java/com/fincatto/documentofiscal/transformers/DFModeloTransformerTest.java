package com.fincatto.documentofiscal.transformers;

import com.fincatto.documentofiscal.DFModelo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DFModeloTransformerTest {

    @Test
    public void deveTestarLeitura() throws Exception {
    	Assertions.assertNull(new DFModeloTransformer().read(null));
    	Assertions.assertEquals(DFModelo.AVULSA, new DFModeloTransformer().read("01"));
    	Assertions.assertEquals(DFModelo.PRODUTOR, new DFModeloTransformer().read("04"));
    	Assertions.assertEquals(DFModelo.NFE, new DFModeloTransformer().read("55"));
    	Assertions.assertEquals(DFModelo.NFCE, new DFModeloTransformer().read("65"));
    	Assertions.assertEquals(DFModelo.CTE, new DFModeloTransformer().read("57"));
    	Assertions.assertEquals(DFModelo.CTeOS, new DFModeloTransformer().read("67"));
    }
    
    @Test
    public void deveTestarEscrita() throws Exception {
    	Assertions.assertEquals("01", new DFModeloTransformer().write(DFModelo.AVULSA));
    	Assertions.assertEquals("04", new DFModeloTransformer().write(DFModelo.PRODUTOR));
    	Assertions.assertEquals("55", new DFModeloTransformer().write(DFModelo.NFE));
    	Assertions.assertEquals("65", new DFModeloTransformer().write(DFModelo.NFCE));
    	Assertions.assertEquals("57", new DFModeloTransformer().write(DFModelo.CTE));
    	Assertions.assertEquals("67", new DFModeloTransformer().write(DFModelo.CTeOS));
    }

}
