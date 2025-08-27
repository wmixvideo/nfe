package com.fincatto.documentofiscal.cte400.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTTipoPrazoDataEntregaTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assert.assertNull(CTTipoPrazoDataEntrega.valueOfCodigo(null));
    	Assert.assertEquals("0", CTTipoPrazoDataEntrega.SEM_DATA_DEFINIDA.getCodigo());
    	Assert.assertEquals("1", CTTipoPrazoDataEntrega.NA_DATA.getCodigo());
    	Assert.assertEquals("2", CTTipoPrazoDataEntrega.ATE_A_DATA.getCodigo());
    	Assert.assertEquals("3", CTTipoPrazoDataEntrega.A_PARTIR_DA_DATA.getCodigo());
    	Assert.assertEquals("4", CTTipoPrazoDataEntrega.NO_PERIODO.getCodigo());
	}

}
