package com.fincatto.documentofiscal.cte400.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTTipoServicoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assert.assertNull(CTTipoServico.valueOfCodigo(null));
    	Assert.assertEquals("0", CTTipoServico.NORMAL.getCodigo());
    	Assert.assertEquals("1", CTTipoServico.SUBCONTRATACAO.getCodigo());
    	Assert.assertEquals("2", CTTipoServico.REDESPACHO.getCodigo());
    	Assert.assertEquals("3", CTTipoServico.REDESPACHO_INTERMEDIARIO.getCodigo());
    	Assert.assertEquals("4", CTTipoServico.SERVICO_VINCULADO_A_MULTIMODAL.getCodigo());
	}

}
