package com.fincatto.documentofiscal.cte200.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTTipoServicoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", CTTipoServico.NORMAL.getCodigo());
        Assert.assertEquals("1", CTTipoServico.SUBCONTRATACAO.getCodigo());
        Assert.assertEquals("2", CTTipoServico.REDESPACHO.getCodigo());
        Assert.assertEquals("3", CTTipoServico.REDESPACHO_INTERMEDIARIO.getCodigo());
        Assert.assertEquals("4", CTTipoServico.SERVICO_VINCULADO_MULTIMODAL.getCodigo());
    }

}
