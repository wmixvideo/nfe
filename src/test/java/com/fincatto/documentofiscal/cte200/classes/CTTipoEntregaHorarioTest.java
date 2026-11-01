package com.fincatto.documentofiscal.cte200.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTTipoEntregaHorarioTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("0", CTTipoEntregaHorario.SEM_HORARIO.getCodigo());
        Assertions.assertEquals("1", CTTipoEntregaHorario.NO_HORARIO.getCodigo());
        Assertions.assertEquals("2", CTTipoEntregaHorario.ATE_HORARIO.getCodigo());
        Assertions.assertEquals("3", CTTipoEntregaHorario.A_PARTIR_HORARIO.getCodigo());
        Assertions.assertEquals("4", CTTipoEntregaHorario.NO_INTERVALO.getCodigo());
    }

}
