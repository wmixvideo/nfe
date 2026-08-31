package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaSituacaoOperacionalSimplesNacionalTest {

    @Test
    public void deveObterSituacaoOperacionalSimplesNacionalApartirDoSeuCodigo() {
        Assertions.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_101, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("101"));
        Assertions.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_102, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("102"));
        Assertions.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_103, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("103"));
        Assertions.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_201, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("201"));
        Assertions.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_202, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("202"));
        Assertions.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_203, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("203"));
        Assertions.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_300, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("300"));
        Assertions.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_400, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("400"));
        Assertions.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_500, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("500"));
        Assertions.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_900, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("900"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("101", NFNotaSituacaoOperacionalSimplesNacional.CSOSN_101.getCodigo());
        Assertions.assertEquals("102", NFNotaSituacaoOperacionalSimplesNacional.CSOSN_102.getCodigo());
        Assertions.assertEquals("103", NFNotaSituacaoOperacionalSimplesNacional.CSOSN_103.getCodigo());
        Assertions.assertEquals("201", NFNotaSituacaoOperacionalSimplesNacional.CSOSN_201.getCodigo());
        Assertions.assertEquals("202", NFNotaSituacaoOperacionalSimplesNacional.CSOSN_202.getCodigo());
        Assertions.assertEquals("203", NFNotaSituacaoOperacionalSimplesNacional.CSOSN_203.getCodigo());
        Assertions.assertEquals("300", NFNotaSituacaoOperacionalSimplesNacional.CSOSN_300.getCodigo());
        Assertions.assertEquals("400", NFNotaSituacaoOperacionalSimplesNacional.CSOSN_400.getCodigo());
        Assertions.assertEquals("500", NFNotaSituacaoOperacionalSimplesNacional.CSOSN_500.getCodigo());
        Assertions.assertEquals("900", NFNotaSituacaoOperacionalSimplesNacional.CSOSN_900.getCodigo());
    }
}