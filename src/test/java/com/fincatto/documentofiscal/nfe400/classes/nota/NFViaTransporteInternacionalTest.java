package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.Assert;
import org.junit.Test;

public class NFViaTransporteInternacionalTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("1", NFViaTransporteInternacional.MARITIMA.getCodigo());
        Assert.assertEquals("2", NFViaTransporteInternacional.FLUVIAL.getCodigo());
        Assert.assertEquals("3", NFViaTransporteInternacional.LACUSTRE.getCodigo());
        Assert.assertEquals("4", NFViaTransporteInternacional.AEREA.getCodigo());
        Assert.assertEquals("5", NFViaTransporteInternacional.POSTAL.getCodigo());
        Assert.assertEquals("6", NFViaTransporteInternacional.FERROVIARIA.getCodigo());
        Assert.assertEquals("7", NFViaTransporteInternacional.RODOVIARIA.getCodigo());
        Assert.assertEquals("8", NFViaTransporteInternacional.CONDUTO_REDE_TRANSMISSAO.getCodigo());
        Assert.assertEquals("9", NFViaTransporteInternacional.MEIOS_PROPRIOS.getCodigo());
        Assert.assertEquals("10", NFViaTransporteInternacional.ENTRADA_SAIDA.getCodigo());
        Assert.assertEquals("11", NFViaTransporteInternacional.COURIER.getCodigo());
        Assert.assertEquals("12", NFViaTransporteInternacional.HANDCARRY.getCodigo());
    }

    @Test
    public void deveObterEnumPeloCodigo() {
        Assert.assertEquals(NFViaTransporteInternacional.MARITIMA, NFViaTransporteInternacional.valueOfCodigo("1"));
        Assert.assertEquals(NFViaTransporteInternacional.FLUVIAL, NFViaTransporteInternacional.valueOfCodigo("2"));
        Assert.assertEquals(NFViaTransporteInternacional.LACUSTRE, NFViaTransporteInternacional.valueOfCodigo("3"));
        Assert.assertEquals(NFViaTransporteInternacional.AEREA, NFViaTransporteInternacional.valueOfCodigo("4"));
        Assert.assertEquals(NFViaTransporteInternacional.POSTAL, NFViaTransporteInternacional.valueOfCodigo("5"));
        Assert.assertEquals(NFViaTransporteInternacional.FERROVIARIA, NFViaTransporteInternacional.valueOfCodigo("6"));
        Assert.assertEquals(NFViaTransporteInternacional.RODOVIARIA, NFViaTransporteInternacional.valueOfCodigo("7"));
        Assert.assertEquals(NFViaTransporteInternacional.CONDUTO_REDE_TRANSMISSAO, NFViaTransporteInternacional.valueOfCodigo("8"));
        Assert.assertEquals(NFViaTransporteInternacional.MEIOS_PROPRIOS, NFViaTransporteInternacional.valueOfCodigo("9"));
        Assert.assertEquals(NFViaTransporteInternacional.ENTRADA_SAIDA, NFViaTransporteInternacional.valueOfCodigo("10"));
        Assert.assertEquals(NFViaTransporteInternacional.COURIER, NFViaTransporteInternacional.valueOfCodigo("11"));
        Assert.assertEquals(NFViaTransporteInternacional.HANDCARRY, NFViaTransporteInternacional.valueOfCodigo("12"));
    }
}