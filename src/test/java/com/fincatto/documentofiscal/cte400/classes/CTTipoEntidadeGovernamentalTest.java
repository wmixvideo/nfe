package com.fincatto.documentofiscal.cte400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTTipoEntidadeGovernamentalTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertNull(CTTipoEntidadeGovernamental.valueOfCodigo(null));
        Assertions.assertNull(CTTipoEntidadeGovernamental.valueOfCodigo("7"));
        Assertions.assertEquals("1", CTTipoEntidadeGovernamental.UNIAO.getCodigo());
        Assertions.assertEquals("2", CTTipoEntidadeGovernamental.ESTADOS.getCodigo());
        Assertions.assertEquals("3", CTTipoEntidadeGovernamental.DISTRITO_FEDERAL.getCodigo());
        Assertions.assertEquals("4", CTTipoEntidadeGovernamental.MUNICIPIOS.getCodigo());
        Assertions.assertEquals("5", CTTipoEntidadeGovernamental.CONSORCIO_PUBLICO.getCodigo());
        Assertions.assertEquals("6", CTTipoEntidadeGovernamental.COMITE_GESTOR_IBS.getCodigo());
        Assertions.assertEquals(CTTipoEntidadeGovernamental.MUNICIPIOS, CTTipoEntidadeGovernamental.valueOfCodigo("4"));
    }

    @Test
    public void deveRepresentarToStringCorretamente() {
        Assertions.assertEquals("1 - União", CTTipoEntidadeGovernamental.UNIAO.toString());
    }
}
