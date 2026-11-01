package com.fincatto.documentofiscal.cte300.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTProcessoEmissaoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assertions.assertNull(CTProcessoEmissao.valueOfCodigo(null));
    	Assertions.assertEquals("0", CTProcessoEmissao.EMISSOR_CONTRIBUINTE.getCodigo());
    	Assertions.assertEquals("3", CTProcessoEmissao.EMISSOR_FISCO.getCodigo());
    }

}
