package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFNotaInfoTipoVeiculoTest {
    
    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("06", NFNotaInfoTipoVeiculo.AUTOMOVEL.getCodigo());
        Assert.assertEquals("14", NFNotaInfoTipoVeiculo.CAMINHAO.getCodigo());
        Assert.assertEquals("13", NFNotaInfoTipoVeiculo.CAMINHONETA.getCodigo());
        Assert.assertEquals("24", NFNotaInfoTipoVeiculo.CARGA_CAM.getCodigo());
        Assert.assertEquals("02", NFNotaInfoTipoVeiculo.CICLOMOTO.getCodigo());
        Assert.assertEquals("22", NFNotaInfoTipoVeiculo.ESP_ONIBUS.getCodigo());
        Assert.assertEquals("07", NFNotaInfoTipoVeiculo.MICROONIBUS.getCodigo());
        Assert.assertEquals("23", NFNotaInfoTipoVeiculo.MISTO_CAM.getCodigo());
        Assert.assertEquals("04", NFNotaInfoTipoVeiculo.MOTOCICLO.getCodigo());
        Assert.assertEquals("03", NFNotaInfoTipoVeiculo.MOTONETA.getCodigo());
        Assert.assertEquals("08", NFNotaInfoTipoVeiculo.ONIBUS.getCodigo());
        Assert.assertEquals("10", NFNotaInfoTipoVeiculo.REBOQUE.getCodigo());
        Assert.assertEquals("05", NFNotaInfoTipoVeiculo.TRICICLO.getCodigo());
        Assert.assertEquals("17", NFNotaInfoTipoVeiculo.TRATOR.getCodigo());
        Assert.assertEquals("11", NFNotaInfoTipoVeiculo.SEMIRREBOQUE.getCodigo());
        Assert.assertEquals("18", NFNotaInfoTipoVeiculo.TRATOR_RODAS.getCodigo());
        Assert.assertEquals("19", NFNotaInfoTipoVeiculo.TRATOR_ESTEIRAS.getCodigo());
        Assert.assertEquals("20", NFNotaInfoTipoVeiculo.TRATOR_MISTO.getCodigo());
        Assert.assertEquals("21", NFNotaInfoTipoVeiculo.QUADRICICLO.getCodigo());
        Assert.assertEquals("25", NFNotaInfoTipoVeiculo.UTILITARIO.getCodigo());
        Assert.assertEquals("26", NFNotaInfoTipoVeiculo.MOTOR_CASA.getCodigo());
    }
}