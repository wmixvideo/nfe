package com.fincatto.documentofiscal.cte300.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTModeloNFTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assertions.assertNull(CTModeloNF.valueOfCodigo(null));
    	Assertions.assertEquals("01", CTModeloNF.NF_Modelo_01_ou_1A_ou_Avulsa.getCodigo());
    	Assertions.assertEquals("04", CTModeloNF.NF_DE_PRODUTOR.getCodigo());
    }

}
