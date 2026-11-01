package com.fincatto.documentofiscal.cte400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTTipoDocumentoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assertions.assertNull(CTTipoDocumento.valueOfCodigo(null));
    	Assertions.assertEquals("00", CTTipoDocumento.DECLARACAO.getCodigo());
    	Assertions.assertEquals("10", CTTipoDocumento.DUTOVIARIO.getCodigo());
    	Assertions.assertEquals("59", CTTipoDocumento.CFeSAT.getCodigo());
    	Assertions.assertEquals("65", CTTipoDocumento.NFCe.getCodigo());
    	Assertions.assertEquals("99", CTTipoDocumento.OUTROS.getCodigo());
	}

}
