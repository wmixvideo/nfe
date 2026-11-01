package com.fincatto.documentofiscal.cte200.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTTipoDocumentoTransporteAnteriorTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("0", CTTipoDocumentoTransporteAnterior.CTRC.getCodigo());
        Assertions.assertEquals("1", CTTipoDocumentoTransporteAnterior.CTAC.getCodigo());
        Assertions.assertEquals("2", CTTipoDocumentoTransporteAnterior.ACT.getCodigo());
        Assertions.assertEquals("3", CTTipoDocumentoTransporteAnterior.NF_MODELO_7.getCodigo());
        Assertions.assertEquals("4", CTTipoDocumentoTransporteAnterior.NF_MODELO_27.getCodigo());
        Assertions.assertEquals("5", CTTipoDocumentoTransporteAnterior.CONHECIMENTO_AEREO_NACIONAL.getCodigo());
        Assertions.assertEquals("6", CTTipoDocumentoTransporteAnterior.CTMC.getCodigo());
        Assertions.assertEquals("7", CTTipoDocumentoTransporteAnterior.ATRE.getCodigo());
        Assertions.assertEquals("8", CTTipoDocumentoTransporteAnterior.DIA.getCodigo());
        Assertions.assertEquals("9", CTTipoDocumentoTransporteAnterior.CONHECIMENTO_AEREO_INTERNACIONAL.getCodigo());
        Assertions.assertEquals("10", CTTipoDocumentoTransporteAnterior.CONHECIMENTO_CARTA_PORTE_INTERNACIONAL.getCodigo());
        Assertions.assertEquals("11", CTTipoDocumentoTransporteAnterior.CONHECIMENTO_AVULSO.getCodigo());
        Assertions.assertEquals("12", CTTipoDocumentoTransporteAnterior.TIF.getCodigo());
        Assertions.assertEquals("99", CTTipoDocumentoTransporteAnterior.OUTROS.getCodigo());
    }

}
