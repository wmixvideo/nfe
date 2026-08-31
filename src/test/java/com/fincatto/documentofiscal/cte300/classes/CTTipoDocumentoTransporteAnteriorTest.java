package com.fincatto.documentofiscal.cte300.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTTipoDocumentoTransporteAnteriorTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assertions.assertNull(CTTipoDocumentoTransporteAnterior.valueOfCodigo(null));
    	Assertions.assertEquals("07", CTTipoDocumentoTransporteAnterior.ATRE.getCodigo());
    	Assertions.assertEquals("08", CTTipoDocumentoTransporteAnterior.DTA.getCodigo());
    	Assertions.assertEquals("09", CTTipoDocumentoTransporteAnterior.CONHECIMENTO_AEREO_INTERNACIONAL.getCodigo());
    	Assertions.assertEquals("10", CTTipoDocumentoTransporteAnterior.CONHECIMENTO_CARTA_DE_PORTE_INTERNACIONAL.getCodigo());
    	Assertions.assertEquals("11", CTTipoDocumentoTransporteAnterior.CONHECIMENTO_AVULSO.getCodigo());
    	Assertions.assertEquals("12", CTTipoDocumentoTransporteAnterior.TIF.getCodigo());
    	Assertions.assertEquals("13", CTTipoDocumentoTransporteAnterior.BL.getCodigo());
	}

}
