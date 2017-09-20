package com.fincatto.documentofiscal.nfe310.classes;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoEspecieVeiculo;

public class NFNotaInfoEspecieVeiculoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("1", NFNotaInfoEspecieVeiculo.PASSAGEIRO.getCodigo());
        Assert.assertEquals("2", NFNotaInfoEspecieVeiculo.CARGA.getCodigo());
        Assert.assertEquals("3", NFNotaInfoEspecieVeiculo.MISTO.getCodigo());
        Assert.assertEquals("4", NFNotaInfoEspecieVeiculo.CORRIDA.getCodigo());
        Assert.assertEquals("5", NFNotaInfoEspecieVeiculo.TRACAO.getCodigo());
        Assert.assertEquals("6", NFNotaInfoEspecieVeiculo.ESPECIAL.getCodigo());
        Assert.assertEquals("7", NFNotaInfoEspecieVeiculo.COLECAO.getCodigo());
    }
}