package com.fincatto.documentofiscal.cte300.classes;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.cte300.classes.CTTipoImpressao;

public class CTTipoImpressaoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assert.assertNull(CTTipoImpressao.valueOfCodigo(null));
    	Assert.assertEquals("1", CTTipoImpressao.RETRATO.getCodigo());
    	Assert.assertEquals("2", CTTipoImpressao.PAISAGEM.getCodigo());
	}

}
