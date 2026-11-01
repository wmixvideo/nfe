package com.fincatto.documentofiscal.cte200.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTTipoEmissaoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("1", CTTipoEmissao.NORMAL.getCodigo());
        Assertions.assertEquals("4", CTTipoEmissao.EPEC_SVC.getCodigo());
        Assertions.assertEquals("5", CTTipoEmissao.CONTINGENCIA_FSDA.getCodigo());
        Assertions.assertEquals("7", CTTipoEmissao.AUTORIZACAO_SVCRS.getCodigo());
        Assertions.assertEquals("8", CTTipoEmissao.AUTORIZACAO_SVCSP.getCodigo());
    }

}
