package com.fincatto.documentofiscal.cte300.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTTipoRegimeTributarioTest {


    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertNull(CTTipoRegimeTributario.valueOfCodigo(null));
        Assertions.assertEquals("1", CTTipoRegimeTributario.SIMPLES_NACIONAL.getCodigo());
        Assertions.assertEquals("2", CTTipoRegimeTributario.SIMPLES_NACIONAL_EXCESSO_SUBLIME_RECEITA_BRUTA.getCodigo());
        Assertions.assertEquals("3", CTTipoRegimeTributario.REGIME_NORMAL.getCodigo());
    }

}