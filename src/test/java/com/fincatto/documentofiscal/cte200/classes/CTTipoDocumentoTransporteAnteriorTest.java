package com.fincatto.documentofiscal.cte200.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTTipoDocumentoTransporteAnteriorTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", CTTipoDocumentoTransporteAnterior.CTRC.getCodigo());
        Assert.assertEquals("1", CTTipoDocumentoTransporteAnterior.CTAC.getCodigo());
        Assert.assertEquals("2", CTTipoDocumentoTransporteAnterior.ACT.getCodigo());
        Assert.assertEquals("3", CTTipoDocumentoTransporteAnterior.NF_MODELO_7.getCodigo());
        Assert.assertEquals("4", CTTipoDocumentoTransporteAnterior.NF_MODELO_27.getCodigo());
        Assert.assertEquals("5", CTTipoDocumentoTransporteAnterior.CONHECIMENTO_AEREO_NACIONAL.getCodigo());
        Assert.assertEquals("6", CTTipoDocumentoTransporteAnterior.CTMC.getCodigo());
        Assert.assertEquals("7", CTTipoDocumentoTransporteAnterior.ATRE.getCodigo());
        Assert.assertEquals("8", CTTipoDocumentoTransporteAnterior.DIA.getCodigo());
        Assert.assertEquals("9", CTTipoDocumentoTransporteAnterior.CONHECIMENTO_AEREO_INTERNACIONAL.getCodigo());
        Assert.assertEquals("10", CTTipoDocumentoTransporteAnterior.CONHECIMENTO_CARTA_PORTE_INTERNACIONAL.getCodigo());
        Assert.assertEquals("11", CTTipoDocumentoTransporteAnterior.CONHECIMENTO_AVULSO.getCodigo());
        Assert.assertEquals("12", CTTipoDocumentoTransporteAnterior.TIF.getCodigo());
        Assert.assertEquals("99", CTTipoDocumentoTransporteAnterior.OUTROS.getCodigo());
    }

}
