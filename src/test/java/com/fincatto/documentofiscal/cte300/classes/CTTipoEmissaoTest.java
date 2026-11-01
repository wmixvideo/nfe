package com.fincatto.documentofiscal.cte300.classes;

import com.fincatto.documentofiscal.cte.CTTipoEmissao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTTipoEmissaoTest {
	
    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assertions.assertNull(CTTipoEmissao.valueOfCodigo(null));
    	Assertions.assertEquals("1", CTTipoEmissao.EMISSAO_NORMAL.getCodigo());
    	Assertions.assertEquals("4", CTTipoEmissao.CONTINGENCIA_EPEC.getCodigo());
    	Assertions.assertEquals("5", CTTipoEmissao.CONTINGENCIA_FSDA.getCodigo());
    	Assertions.assertEquals("7", CTTipoEmissao.CONTINGENCIA_SVCRS.getCodigo());
    	Assertions.assertEquals("8", CTTipoEmissao.CONTINGENCIA_SVCSP.getCodigo());
	}

}
