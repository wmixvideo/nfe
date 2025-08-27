package com.fincatto.documentofiscal.cte400.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTTomadorServicoTest {
   
	@Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assert.assertNull(CTTomadorServico.valueOfCodigo(null));
    	Assert.assertEquals("0", CTTomadorServico.REMETENTE.getCodigo());
    	Assert.assertEquals("1", CTTomadorServico.EXPEDIDOR.getCodigo());
    	Assert.assertEquals("2", CTTomadorServico.RECEBEDOR.getCodigo());
    	Assert.assertEquals("3", CTTomadorServico.DESTINATARIO.getCodigo());
    	Assert.assertEquals("4", CTTomadorServico.OUTROS.getCodigo());
	}

}
