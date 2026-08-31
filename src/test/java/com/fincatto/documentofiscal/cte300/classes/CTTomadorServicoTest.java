package com.fincatto.documentofiscal.cte300.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTTomadorServicoTest {
   
	@Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assertions.assertNull(CTTomadorServico.valueOfCodigo(null));
    	Assertions.assertEquals("0", CTTomadorServico.REMETENTE.getCodigo());
    	Assertions.assertEquals("1", CTTomadorServico.EXPEDIDOR.getCodigo());
    	Assertions.assertEquals("2", CTTomadorServico.RECEBEDOR.getCodigo());
    	Assertions.assertEquals("3", CTTomadorServico.DESTINATARIO.getCodigo());
    	Assertions.assertEquals("4", CTTomadorServico.OUTROS.getCodigo());
	}

}
