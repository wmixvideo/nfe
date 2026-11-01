package com.fincatto.documentofiscal.nfe310.classes.nota;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFViaTransporteInternacionalTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("1", NFViaTransporteInternacional.MARITIMA.getCodigo());
        Assertions.assertEquals("2", NFViaTransporteInternacional.FLUVIAL.getCodigo());
        Assertions.assertEquals("3", NFViaTransporteInternacional.LACUSTRE.getCodigo());
        Assertions.assertEquals("4", NFViaTransporteInternacional.AEREA.getCodigo());
        Assertions.assertEquals("5", NFViaTransporteInternacional.POSTAL.getCodigo());
        Assertions.assertEquals("6", NFViaTransporteInternacional.FERROVIARIA.getCodigo());
        Assertions.assertEquals("7", NFViaTransporteInternacional.RODOVIARIA.getCodigo());
        Assertions.assertEquals("8", NFViaTransporteInternacional.CONDUTO_REDE_TRANSMISSAO.getCodigo());
        Assertions.assertEquals("9", NFViaTransporteInternacional.MEIOS_PROPRIOS.getCodigo());
        Assertions.assertEquals("10", NFViaTransporteInternacional.ENTRADA_SAIDA.getCodigo());
        Assertions.assertEquals("11", NFViaTransporteInternacional.COURIER.getCodigo());
        Assertions.assertEquals("12", NFViaTransporteInternacional.HANDCARRY.getCodigo());
    }

    @Test
    public void deveObterEnumPeloCodigo() {
        Assertions.assertEquals(NFViaTransporteInternacional.MARITIMA, NFViaTransporteInternacional.valueOfCodigo("1"));
        Assertions.assertEquals(NFViaTransporteInternacional.FLUVIAL, NFViaTransporteInternacional.valueOfCodigo("2"));
        Assertions.assertEquals(NFViaTransporteInternacional.LACUSTRE, NFViaTransporteInternacional.valueOfCodigo("3"));
        Assertions.assertEquals(NFViaTransporteInternacional.AEREA, NFViaTransporteInternacional.valueOfCodigo("4"));
        Assertions.assertEquals(NFViaTransporteInternacional.POSTAL, NFViaTransporteInternacional.valueOfCodigo("5"));
        Assertions.assertEquals(NFViaTransporteInternacional.FERROVIARIA, NFViaTransporteInternacional.valueOfCodigo("6"));
        Assertions.assertEquals(NFViaTransporteInternacional.RODOVIARIA, NFViaTransporteInternacional.valueOfCodigo("7"));
        Assertions.assertEquals(NFViaTransporteInternacional.CONDUTO_REDE_TRANSMISSAO, NFViaTransporteInternacional.valueOfCodigo("8"));
        Assertions.assertEquals(NFViaTransporteInternacional.MEIOS_PROPRIOS, NFViaTransporteInternacional.valueOfCodigo("9"));
        Assertions.assertEquals(NFViaTransporteInternacional.ENTRADA_SAIDA, NFViaTransporteInternacional.valueOfCodigo("10"));
        Assertions.assertEquals(NFViaTransporteInternacional.COURIER, NFViaTransporteInternacional.valueOfCodigo("11"));
        Assertions.assertEquals(NFViaTransporteInternacional.HANDCARRY, NFViaTransporteInternacional.valueOfCodigo("12"));
    }
}