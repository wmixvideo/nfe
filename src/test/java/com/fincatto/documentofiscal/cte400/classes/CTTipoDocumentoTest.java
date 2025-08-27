package com.fincatto.documentofiscal.cte400.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTTipoDocumentoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assert.assertNull(CTTipoDocumento.valueOfCodigo(null));
    	Assert.assertEquals("00", CTTipoDocumento.DECLARACAO.getCodigo());
    	Assert.assertEquals("10", CTTipoDocumento.DUTOVIARIO.getCodigo());
    	Assert.assertEquals("59", CTTipoDocumento.CFeSAT.getCodigo());
    	Assert.assertEquals("65", CTTipoDocumento.NFCe.getCodigo());
    	Assert.assertEquals("99", CTTipoDocumento.OUTROS.getCodigo());
	}

}
