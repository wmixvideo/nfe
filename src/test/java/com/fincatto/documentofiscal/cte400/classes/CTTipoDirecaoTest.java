package com.fincatto.documentofiscal.cte400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTTipoDirecaoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assertions.assertNull(CTTipoDirecao.valueOfCodigo(null));
    	Assertions.assertEquals("N", CTTipoDirecao.NORTE.getCodigo());
    	Assertions.assertEquals("L", CTTipoDirecao.LESTE.getCodigo());
    	Assertions.assertEquals("S", CTTipoDirecao.SUL.getCodigo());
    	Assertions.assertEquals("O", CTTipoDirecao.OESTE.getCodigo());
    }

}
