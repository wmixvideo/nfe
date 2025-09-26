package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFNotaSituacaoOperacionalSimplesNacionalTest {

    @Test
    public void deveObterSituacaoOperacionalSimplesNacionalApartirDoSeuCodigo() {
        Assert.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_101, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("101"));
        Assert.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_102, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("102"));
        Assert.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_103, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("103"));
        Assert.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_201, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("201"));
        Assert.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_202, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("202"));
        Assert.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_203, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("203"));
        Assert.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_300, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("300"));
        Assert.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_400, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("400"));
        Assert.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_500, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("500"));
        Assert.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_900, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("900"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("101", NFNotaSituacaoOperacionalSimplesNacional.CSOSN_101.getCodigo());
        Assert.assertEquals("102", NFNotaSituacaoOperacionalSimplesNacional.CSOSN_102.getCodigo());
        Assert.assertEquals("103", NFNotaSituacaoOperacionalSimplesNacional.CSOSN_103.getCodigo());
        Assert.assertEquals("201", NFNotaSituacaoOperacionalSimplesNacional.CSOSN_201.getCodigo());
        Assert.assertEquals("202", NFNotaSituacaoOperacionalSimplesNacional.CSOSN_202.getCodigo());
        Assert.assertEquals("203", NFNotaSituacaoOperacionalSimplesNacional.CSOSN_203.getCodigo());
        Assert.assertEquals("300", NFNotaSituacaoOperacionalSimplesNacional.CSOSN_300.getCodigo());
        Assert.assertEquals("400", NFNotaSituacaoOperacionalSimplesNacional.CSOSN_400.getCodigo());
        Assert.assertEquals("500", NFNotaSituacaoOperacionalSimplesNacional.CSOSN_500.getCodigo());
        Assert.assertEquals("900", NFNotaSituacaoOperacionalSimplesNacional.CSOSN_900.getCodigo());
    }
}