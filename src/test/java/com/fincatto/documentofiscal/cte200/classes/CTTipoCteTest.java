package com.fincatto.documentofiscal.cte200.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTTipoCteTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("0", CTTipoCte.NORMAL.getCodigo());
        Assertions.assertEquals("1", CTTipoCte.COMPLEMENTO.getCodigo());
        Assertions.assertEquals("2", CTTipoCte.ANULACAO.getCodigo());
        Assertions.assertEquals("3", CTTipoCte.SUBSTITUTO.getCodigo());
    }

}
