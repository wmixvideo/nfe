package com.fincatto.documentofiscal.cte200.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTTipoEntregaHorarioTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", CTTipoEntregaHorario.SEM_HORARIO.getCodigo());
        Assert.assertEquals("1", CTTipoEntregaHorario.NO_HORARIO.getCodigo());
        Assert.assertEquals("2", CTTipoEntregaHorario.ATE_HORARIO.getCodigo());
        Assert.assertEquals("3", CTTipoEntregaHorario.A_PARTIR_HORARIO.getCodigo());
        Assert.assertEquals("4", CTTipoEntregaHorario.NO_INTERVALO.getCodigo());
    }

}
