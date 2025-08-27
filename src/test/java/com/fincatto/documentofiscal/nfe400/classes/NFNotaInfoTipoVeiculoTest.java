package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFNotaInfoTipoVeiculoTest {
    
    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("2", NFNotaInfoTipoVeiculo.CICLOMOTO.getCodigo());
        Assert.assertEquals("3", NFNotaInfoTipoVeiculo.MOTONETA.getCodigo());
        Assert.assertEquals("4", NFNotaInfoTipoVeiculo.MOTOCICLO.getCodigo());
        Assert.assertEquals("5", NFNotaInfoTipoVeiculo.TRICICLO.getCodigo());
        Assert.assertEquals("6", NFNotaInfoTipoVeiculo.AUTOMOVEL.getCodigo());
        Assert.assertEquals("7", NFNotaInfoTipoVeiculo.MICROONIBUS.getCodigo());
        Assert.assertEquals("8", NFNotaInfoTipoVeiculo.ONIBUS.getCodigo());
        Assert.assertEquals("10", NFNotaInfoTipoVeiculo.REBOQUE.getCodigo());
        Assert.assertEquals("11", NFNotaInfoTipoVeiculo.SEMIRREBOQUE.getCodigo());
        Assert.assertEquals("13", NFNotaInfoTipoVeiculo.CAMINHONETA.getCodigo());
        Assert.assertEquals("14", NFNotaInfoTipoVeiculo.CAMINHAO.getCodigo());
        Assert.assertEquals("17", NFNotaInfoTipoVeiculo.TRATOR.getCodigo());
        Assert.assertEquals("18", NFNotaInfoTipoVeiculo.TRATOR_RODAS.getCodigo());
        Assert.assertEquals("19", NFNotaInfoTipoVeiculo.TRATOR_ESTEIRAS.getCodigo());
        Assert.assertEquals("20", NFNotaInfoTipoVeiculo.TRATOR_MISTO.getCodigo());
        Assert.assertEquals("21", NFNotaInfoTipoVeiculo.QUADRICICLO.getCodigo());
        Assert.assertEquals("22", NFNotaInfoTipoVeiculo.ESP_ONIBUS.getCodigo());
        Assert.assertEquals("23", NFNotaInfoTipoVeiculo.MISTO_CAM.getCodigo());
        Assert.assertEquals("24", NFNotaInfoTipoVeiculo.CARGA_CAM.getCodigo());
        Assert.assertEquals("25", NFNotaInfoTipoVeiculo.UTILITARIO.getCodigo());
        Assert.assertEquals("26", NFNotaInfoTipoVeiculo.MOTOR_CASA.getCodigo());
    }

    @Test
    public void deveConverterCodigoParaEnum() {
        Assert.assertEquals(NFNotaInfoTipoVeiculo.CICLOMOTO, NFNotaInfoTipoVeiculo.valueOfCodigo("2"));
        Assert.assertEquals(NFNotaInfoTipoVeiculo.CICLOMOTO, NFNotaInfoTipoVeiculo.valueOfCodigo("02"));
        Assert.assertEquals(NFNotaInfoTipoVeiculo.MOTONETA, NFNotaInfoTipoVeiculo.valueOfCodigo("3"));
        Assert.assertEquals(NFNotaInfoTipoVeiculo.MOTONETA, NFNotaInfoTipoVeiculo.valueOfCodigo("003"));
        Assert.assertEquals(NFNotaInfoTipoVeiculo.MOTOCICLO, NFNotaInfoTipoVeiculo.valueOfCodigo("4"));
        Assert.assertEquals(NFNotaInfoTipoVeiculo.MOTOCICLO, NFNotaInfoTipoVeiculo.valueOfCodigo("0004"));
        Assert.assertEquals(NFNotaInfoTipoVeiculo.TRICICLO, NFNotaInfoTipoVeiculo.valueOfCodigo("5"));
        Assert.assertEquals(NFNotaInfoTipoVeiculo.TRICICLO, NFNotaInfoTipoVeiculo.valueOfCodigo("05"));
        Assert.assertEquals(NFNotaInfoTipoVeiculo.AUTOMOVEL, NFNotaInfoTipoVeiculo.valueOfCodigo("6"));
        Assert.assertEquals(NFNotaInfoTipoVeiculo.AUTOMOVEL, NFNotaInfoTipoVeiculo.valueOfCodigo("06"));
        Assert.assertEquals(NFNotaInfoTipoVeiculo.MICROONIBUS, NFNotaInfoTipoVeiculo.valueOfCodigo("7"));
        Assert.assertEquals(NFNotaInfoTipoVeiculo.MICROONIBUS, NFNotaInfoTipoVeiculo.valueOfCodigo("07"));
        Assert.assertEquals(NFNotaInfoTipoVeiculo.ONIBUS, NFNotaInfoTipoVeiculo.valueOfCodigo("8"));
        Assert.assertEquals(NFNotaInfoTipoVeiculo.ONIBUS, NFNotaInfoTipoVeiculo.valueOfCodigo("08"));
        Assert.assertEquals(NFNotaInfoTipoVeiculo.REBOQUE, NFNotaInfoTipoVeiculo.valueOfCodigo("10"));
        Assert.assertEquals(NFNotaInfoTipoVeiculo.SEMIRREBOQUE, NFNotaInfoTipoVeiculo.valueOfCodigo("11"));
        Assert.assertEquals(NFNotaInfoTipoVeiculo.CAMINHONETA, NFNotaInfoTipoVeiculo.valueOfCodigo("13"));
        Assert.assertEquals(NFNotaInfoTipoVeiculo.CAMINHAO, NFNotaInfoTipoVeiculo.valueOfCodigo("14"));
        Assert.assertEquals(NFNotaInfoTipoVeiculo.TRATOR, NFNotaInfoTipoVeiculo.valueOfCodigo("17"));
        Assert.assertEquals(NFNotaInfoTipoVeiculo.TRATOR_RODAS, NFNotaInfoTipoVeiculo.valueOfCodigo("18"));
        Assert.assertEquals(NFNotaInfoTipoVeiculo.TRATOR_ESTEIRAS, NFNotaInfoTipoVeiculo.valueOfCodigo("19"));
        Assert.assertEquals(NFNotaInfoTipoVeiculo.TRATOR_MISTO, NFNotaInfoTipoVeiculo.valueOfCodigo("20"));
        Assert.assertEquals(NFNotaInfoTipoVeiculo.QUADRICICLO, NFNotaInfoTipoVeiculo.valueOfCodigo("21"));
        Assert.assertEquals(NFNotaInfoTipoVeiculo.ESP_ONIBUS, NFNotaInfoTipoVeiculo.valueOfCodigo("22"));
        Assert.assertEquals(NFNotaInfoTipoVeiculo.MISTO_CAM, NFNotaInfoTipoVeiculo.valueOfCodigo("23"));
        Assert.assertEquals(NFNotaInfoTipoVeiculo.CARGA_CAM, NFNotaInfoTipoVeiculo.valueOfCodigo("24"));
        Assert.assertEquals(NFNotaInfoTipoVeiculo.UTILITARIO, NFNotaInfoTipoVeiculo.valueOfCodigo("25"));
        Assert.assertEquals(NFNotaInfoTipoVeiculo.MOTOR_CASA, NFNotaInfoTipoVeiculo.valueOfCodigo("26"));
    }

    @Test
    public void condigoInvalidoRetornaNulo() {
        Assert.assertNull(NFNotaInfoTipoVeiculo.valueOfCodigo("27"));
        Assert.assertNull(NFNotaInfoTipoVeiculo.valueOfCodigo("0"));
        Assert.assertNull(NFNotaInfoTipoVeiculo.valueOfCodigo(""));
        Assert.assertNull(NFNotaInfoTipoVeiculo.valueOfCodigo(null));
    }
}