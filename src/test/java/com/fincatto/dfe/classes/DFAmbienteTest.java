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
    public void deveObterAtravesDoCodigo() {
        Assert.assertEquals(DFAmbiente.PRODUCAO, DFAmbiente.valueOfCodigo("1"));
        Assert.assertEquals(DFAmbiente.HOMOLOGACAO, DFAmbiente.valueOfCodigo("2"));
    }

    @Test
    public void isHomologacaoDeveRetornarTrueQuandoCodigoFor2() {
        Assert.assertTrue(DFAmbiente.valueOfCodigo("2").isHomologacao());
    }

    @Test
    public void isProducaoDeveRetornarTrueQuandoCodigoFor1() {
        Assert.assertTrue(DFAmbiente.valueOfCodigo("1").isProducao());
    }
}