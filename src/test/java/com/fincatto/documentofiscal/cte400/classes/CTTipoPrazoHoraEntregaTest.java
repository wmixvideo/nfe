package com.fincatto.documentofiscal.cte400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTTipoPrazoHoraEntregaTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assertions.assertNull(CTTipoPrazoHoraEntrega.valueOfCodigo(null));
    	Assertions.assertEquals("0", CTTipoPrazoHoraEntrega.SEM_HORA_DEFINIDA.getCodigo());
    	Assertions.assertEquals("1", CTTipoPrazoHoraEntrega.NO_HORARIO.getCodigo());
    	Assertions.assertEquals("2", CTTipoPrazoHoraEntrega.ATE_A_HORARIO.getCodigo());
    	Assertions.assertEquals("3", CTTipoPrazoHoraEntrega.A_PARTIR_DO_HORARIO.getCodigo());
    	Assertions.assertEquals("4", CTTipoPrazoHoraEntrega.NO_INTERVALO_DE_TEMPO.getCodigo());
	}

}
