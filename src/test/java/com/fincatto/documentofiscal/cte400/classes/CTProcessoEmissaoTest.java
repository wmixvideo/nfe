package com.fincatto.documentofiscal.cte400.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTProcessoEmissaoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assert.assertNull(CTProcessoEmissao.valueOfCodigo(null));
    	Assert.assertEquals("0", CTProcessoEmissao.EMISSOR_CONTRIBUINTE.getCodigo());
    	Assert.assertEquals("3", CTProcessoEmissao.EMISSOR_FISCO.getCodigo());
    }

}
