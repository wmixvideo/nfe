package com.fincatto.documentofiscal.cte400.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTTipoPrazoHoraEntregaTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assert.assertNull(CTTipoPrazoHoraEntrega.valueOfCodigo(null));
    	Assert.assertEquals("0", CTTipoPrazoHoraEntrega.SEM_HORA_DEFINIDA.getCodigo());
    	Assert.assertEquals("1", CTTipoPrazoHoraEntrega.NO_HORARIO.getCodigo());
    	Assert.assertEquals("2", CTTipoPrazoHoraEntrega.ATE_A_HORARIO.getCodigo());
    	Assert.assertEquals("3", CTTipoPrazoHoraEntrega.A_PARTIR_DO_HORARIO.getCodigo());
    	Assert.assertEquals("4", CTTipoPrazoHoraEntrega.NO_INTERVALO_DE_TEMPO.getCodigo());
	}

}
