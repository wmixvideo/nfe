package com.fincatto.documentofiscal.cte400.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTModeloNFTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assert.assertNull(CTModeloNF.valueOfCodigo(null));
    	Assert.assertEquals("01", CTModeloNF.NF_Modelo_01_ou_1A_ou_Avulsa.getCodigo());
    	Assert.assertEquals("04", CTModeloNF.NF_DE_PRODUTOR.getCodigo());
    }

}
