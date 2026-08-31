package com.fincatto.documentofiscal.cte300.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTTipoPrazoDataEntregaTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assertions.assertNull(CTTipoPrazoDataEntrega.valueOfCodigo(null));
    	Assertions.assertEquals("0", CTTipoPrazoDataEntrega.SEM_DATA_DEFINIDA.getCodigo());
    	Assertions.assertEquals("1", CTTipoPrazoDataEntrega.NA_DATA.getCodigo());
    	Assertions.assertEquals("2", CTTipoPrazoDataEntrega.ATE_A_DATA.getCodigo());
    	Assertions.assertEquals("3", CTTipoPrazoDataEntrega.A_PARTIR_DA_DATA.getCodigo());
    	Assertions.assertEquals("4", CTTipoPrazoDataEntrega.NO_PERIODO.getCodigo());
	}

}
