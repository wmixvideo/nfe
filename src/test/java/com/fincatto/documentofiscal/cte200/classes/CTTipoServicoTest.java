package com.fincatto.documentofiscal.cte200.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTTipoServicoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("0", CTTipoServico.NORMAL.getCodigo());
        Assertions.assertEquals("1", CTTipoServico.SUBCONTRATACAO.getCodigo());
        Assertions.assertEquals("2", CTTipoServico.REDESPACHO.getCodigo());
        Assertions.assertEquals("3", CTTipoServico.REDESPACHO_INTERMEDIARIO.getCodigo());
        Assertions.assertEquals("4", CTTipoServico.SERVICO_VINCULADO_MULTIMODAL.getCodigo());
    }

}
