package com.fincatto.documentofiscal.cte400.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTTipoDocumentoTransporteAnteriorTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assert.assertNull(CTTipoDocumentoTransporteAnterior.valueOfCodigo(null));
    	Assert.assertEquals("07", CTTipoDocumentoTransporteAnterior.ATRE.getCodigo());
    	Assert.assertEquals("08", CTTipoDocumentoTransporteAnterior.DTA.getCodigo());
    	Assert.assertEquals("09", CTTipoDocumentoTransporteAnterior.CONHECIMENTO_AEREO_INTERNACIONAL.getCodigo());
    	Assert.assertEquals("10", CTTipoDocumentoTransporteAnterior.CONHECIMENTO_CARTA_DE_PORTE_INTERNACIONAL.getCodigo());
    	Assert.assertEquals("11", CTTipoDocumentoTransporteAnterior.CONHECIMENTO_AVULSO.getCodigo());
    	Assert.assertEquals("12", CTTipoDocumentoTransporteAnterior.TIF.getCodigo());
    	Assert.assertEquals("13", CTTipoDocumentoTransporteAnterior.BL.getCodigo());
	}

}
