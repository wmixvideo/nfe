package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.Assert;
import org.junit.Test;

public class NFNotaInfoRegimeEspecialTributacaoTest {

    @Test
    public void deveObterTipoApartirDoSeuCodigo() {
        Assert.assertEquals(NFNotaInfoRegimeEspecialTributacao.MICROEMPRESA_MUNICIPAL, NFNotaInfoRegimeEspecialTributacao.valueOfCodigo("1"));
        Assert.assertEquals(NFNotaInfoRegimeEspecialTributacao.ESTIMATIVA, NFNotaInfoRegimeEspecialTributacao.valueOfCodigo("2"));
        Assert.assertEquals(NFNotaInfoRegimeEspecialTributacao.SOCIEDADE_PROFISSIONAIS, NFNotaInfoRegimeEspecialTributacao.valueOfCodigo("3"));
        Assert.assertEquals(NFNotaInfoRegimeEspecialTributacao.COOPERATIVA, NFNotaInfoRegimeEspecialTributacao.valueOfCodigo("4"));
        Assert.assertEquals(NFNotaInfoRegimeEspecialTributacao.MICROEMPRESARIO_INDIVIDUAL_MEI, NFNotaInfoRegimeEspecialTributacao.valueOfCodigo("5"));
        Assert.assertEquals(NFNotaInfoRegimeEspecialTributacao.MICROEMPRESARIO_E_EMPRESA_PEQUENOPORTE, NFNotaInfoRegimeEspecialTributacao.valueOfCodigo("6"));
        Assert.assertNull(NFNotaInfoRegimeEspecialTributacao.valueOfCodigo("0"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("1", NFNotaInfoRegimeEspecialTributacao.MICROEMPRESA_MUNICIPAL.getCodigo());
        Assert.assertEquals("2", NFNotaInfoRegimeEspecialTributacao.ESTIMATIVA.getCodigo());
        Assert.assertEquals("3", NFNotaInfoRegimeEspecialTributacao.SOCIEDADE_PROFISSIONAIS.getCodigo());
        Assert.assertEquals("4", NFNotaInfoRegimeEspecialTributacao.COOPERATIVA.getCodigo());
        Assert.assertEquals("5", NFNotaInfoRegimeEspecialTributacao.MICROEMPRESARIO_INDIVIDUAL_MEI.getCodigo());
        Assert.assertEquals("6", NFNotaInfoRegimeEspecialTributacao.MICROEMPRESARIO_E_EMPRESA_PEQUENOPORTE.getCodigo());
    }

    @Test
    public void deveObterStringficadoCorretamente() {
        Assert.assertEquals("1 - Microempresa municipal", NFNotaInfoRegimeEspecialTributacao.MICROEMPRESA_MUNICIPAL.toString());
    }
}