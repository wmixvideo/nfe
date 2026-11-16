package com.fincatto.documentofiscal.cte400.transformers;

import com.fincatto.documentofiscal.cte400.classes.CTTipoRegimeIBSCBS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTTipoRegimeIBSCBSTransformerTest {

    @Test
    public void deveTestarLeitura() {
        Assertions.assertNull(new CTTipoRegimeIBSCBSTransformer().read("0"));
        Assertions.assertEquals(CTTipoRegimeIBSCBS.SIMPLES_NACIONAL_COM_REGIME_REGULAR, new CTTipoRegimeIBSCBSTransformer().read("1"));
        Assertions.assertEquals(CTTipoRegimeIBSCBS.NORMAL_PENDENTE_SIMPLES_NACIONAL_COM_REGIME_REGULAR, new CTTipoRegimeIBSCBSTransformer().read("4"));
    }

    @Test
    public void deveTestarEscrita() {
        Assertions.assertEquals("2", new CTTipoRegimeIBSCBSTransformer().write(CTTipoRegimeIBSCBS.NORMAL_PENDENTE_SIMPLES_NACIONAL_SEM_REGIME_REGULAR));
        Assertions.assertEquals("3", new CTTipoRegimeIBSCBSTransformer().write(CTTipoRegimeIBSCBS.NORMAL_PENDENTE_SIMPLES_NACIONAL_EXCESSO_SUBLIMITE_SEM_REGIME_REGULAR));
    }
}
