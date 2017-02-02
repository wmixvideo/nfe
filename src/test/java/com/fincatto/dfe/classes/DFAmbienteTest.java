package com.fincatto.dfe.classes;

import org.junit.Assert;
import org.junit.Test;

public class DFAmbienteTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("1", DFAmbiente.PRODUCAO.getCodigo());
        Assert.assertEquals("2", DFAmbiente.HOMOLOGACAO.getCodigo());
    }

    @Test
    public void deveRepresentarADescricaoCorretamente() {
        Assert.assertEquals("Produ\u00e7\u00e3o", DFAmbiente.PRODUCAO.getDescricao());
        Assert.assertEquals("Homologa\u00e7\u00e3o", DFAmbiente.HOMOLOGACAO.getDescricao());
    }

    @Test
    public void deveObterAtravesDoCodigo() {
        Assert.assertEquals(DFAmbiente.PRODUCAO, DFAmbiente.valueOfCodigo("1"));
        Assert.assertEquals(DFAmbiente.HOMOLOGACAO, DFAmbiente.valueOfCodigo("2"));
    }

    @Test
    public void deveRetornarNuloCasoNaoExistaCodigo() {
        Assert.assertNull(DFAmbiente.valueOfCodigo("3"));
    }

    @Test
    public void isHomologacaoDeveRetornarTrueQuandoCodigoFor2() {
        Assert.assertTrue(DFAmbiente.valueOfCodigo("2").isHomologacao());
    }

    @Test
    public void isProducaoDeveRetornarTrueQuandoCodigoFor1() {
        Assert.assertTrue(DFAmbiente.valueOfCodigo("1").isProducao());
    }

    @Test
    public void deveObterToStringCorretamente() {
        Assert.assertEquals("1 - Produ\u00e7\u00e3o", DFAmbiente.PRODUCAO.toString());
        Assert.assertEquals("2 - Homologa\u00e7\u00e3o", DFAmbiente.HOMOLOGACAO.toString());
    }
}