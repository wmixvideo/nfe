package com.fincatto.documentofiscal.cte400.classes;

import com.fincatto.documentofiscal.cte.CTTipoEmissao;
import org.junit.Assert;
import org.junit.Test;

public class CTTipoEmissaoTest {
	
    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assert.assertNull(CTTipoEmissao.valueOfCodigo(null));
    	Assert.assertEquals("1", CTTipoEmissao.EMISSAO_NORMAL.getCodigo());
    	Assert.assertEquals("4", CTTipoEmissao.CONTINGENCIA_EPEC.getCodigo());
    	Assert.assertEquals("5", CTTipoEmissao.CONTINGENCIA_FSDA.getCodigo());
    	Assert.assertEquals("7", CTTipoEmissao.CONTINGENCIA_SVCRS.getCodigo());
    	Assert.assertEquals("8", CTTipoEmissao.CONTINGENCIA_SVCSP.getCodigo());
	}

}
