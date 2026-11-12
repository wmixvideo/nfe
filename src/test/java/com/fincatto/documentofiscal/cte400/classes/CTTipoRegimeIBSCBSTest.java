package com.fincatto.documentofiscal.cte400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTTipoRegimeIBSCBSTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("1", CTTipoRegimeIBSCBS.SIMPLES_NACIONAL_COM_REGIME_REGULAR.getCodigo());
        Assertions.assertEquals("2", CTTipoRegimeIBSCBS.NORMAL_PENDENTE_SIMPLES_NACIONAL_SEM_REGIME_REGULAR.getCodigo());
        Assertions.assertEquals("3", CTTipoRegimeIBSCBS.NORMAL_PENDENTE_SIMPLES_NACIONAL_EXCESSO_SUBLIMITE_SEM_REGIME_REGULAR.getCodigo());
        Assertions.assertEquals("4", CTTipoRegimeIBSCBS.NORMAL_PENDENTE_SIMPLES_NACIONAL_COM_REGIME_REGULAR.getCodigo());
    }

    @Test
    public void deveObterPeloCodigoCorretamente() {
        Assertions.assertEquals(CTTipoRegimeIBSCBS.SIMPLES_NACIONAL_COM_REGIME_REGULAR, CTTipoRegimeIBSCBS.valueOfCodigo("1"));
        Assertions.assertEquals(CTTipoRegimeIBSCBS.NORMAL_PENDENTE_SIMPLES_NACIONAL_SEM_REGIME_REGULAR, CTTipoRegimeIBSCBS.valueOfCodigo("2"));
        Assertions.assertEquals(CTTipoRegimeIBSCBS.NORMAL_PENDENTE_SIMPLES_NACIONAL_EXCESSO_SUBLIMITE_SEM_REGIME_REGULAR, CTTipoRegimeIBSCBS.valueOfCodigo("3"));
        Assertions.assertEquals(CTTipoRegimeIBSCBS.NORMAL_PENDENTE_SIMPLES_NACIONAL_COM_REGIME_REGULAR, CTTipoRegimeIBSCBS.valueOfCodigo("4"));
    }

    @Test
    public void deveObterNuloCasoNaoExistaCodigo() {
        Assertions.assertNull(CTTipoRegimeIBSCBS.valueOfCodigo(null));
        Assertions.assertNull(CTTipoRegimeIBSCBS.valueOfCodigo("0"));
        Assertions.assertNull(CTTipoRegimeIBSCBS.valueOfCodigo("5"));
    }

    @Test
    public void deveRetornarStringficadoComCodigoEDescricao() {
        Assertions.assertTrue(CTTipoRegimeIBSCBS.SIMPLES_NACIONAL_COM_REGIME_REGULAR.toString().startsWith("1 - Contribuinte do Simples Nacional"));
    }
}
