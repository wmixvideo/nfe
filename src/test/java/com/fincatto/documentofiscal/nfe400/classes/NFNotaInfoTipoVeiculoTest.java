package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoTipoVeiculoTest {
    
    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("2", NFNotaInfoTipoVeiculo.CICLOMOTO.getCodigo());
        Assertions.assertEquals("3", NFNotaInfoTipoVeiculo.MOTONETA.getCodigo());
        Assertions.assertEquals("4", NFNotaInfoTipoVeiculo.MOTOCICLO.getCodigo());
        Assertions.assertEquals("5", NFNotaInfoTipoVeiculo.TRICICLO.getCodigo());
        Assertions.assertEquals("6", NFNotaInfoTipoVeiculo.AUTOMOVEL.getCodigo());
        Assertions.assertEquals("7", NFNotaInfoTipoVeiculo.MICROONIBUS.getCodigo());
        Assertions.assertEquals("8", NFNotaInfoTipoVeiculo.ONIBUS.getCodigo());
        Assertions.assertEquals("10", NFNotaInfoTipoVeiculo.REBOQUE.getCodigo());
        Assertions.assertEquals("11", NFNotaInfoTipoVeiculo.SEMIRREBOQUE.getCodigo());
        Assertions.assertEquals("13", NFNotaInfoTipoVeiculo.CAMINHONETA.getCodigo());
        Assertions.assertEquals("14", NFNotaInfoTipoVeiculo.CAMINHAO.getCodigo());
        Assertions.assertEquals("17", NFNotaInfoTipoVeiculo.TRATOR.getCodigo());
        Assertions.assertEquals("18", NFNotaInfoTipoVeiculo.TRATOR_RODAS.getCodigo());
        Assertions.assertEquals("19", NFNotaInfoTipoVeiculo.TRATOR_ESTEIRAS.getCodigo());
        Assertions.assertEquals("20", NFNotaInfoTipoVeiculo.TRATOR_MISTO.getCodigo());
        Assertions.assertEquals("21", NFNotaInfoTipoVeiculo.QUADRICICLO.getCodigo());
        Assertions.assertEquals("22", NFNotaInfoTipoVeiculo.ESP_ONIBUS.getCodigo());
        Assertions.assertEquals("23", NFNotaInfoTipoVeiculo.MISTO_CAM.getCodigo());
        Assertions.assertEquals("24", NFNotaInfoTipoVeiculo.CARGA_CAM.getCodigo());
        Assertions.assertEquals("25", NFNotaInfoTipoVeiculo.UTILITARIO.getCodigo());
        Assertions.assertEquals("26", NFNotaInfoTipoVeiculo.MOTOR_CASA.getCodigo());
    }

    @Test
    public void deveConverterCodigoParaEnum() {
        Assertions.assertEquals(NFNotaInfoTipoVeiculo.CICLOMOTO, NFNotaInfoTipoVeiculo.valueOfCodigo("2"));
        Assertions.assertEquals(NFNotaInfoTipoVeiculo.CICLOMOTO, NFNotaInfoTipoVeiculo.valueOfCodigo("02"));
        Assertions.assertEquals(NFNotaInfoTipoVeiculo.MOTONETA, NFNotaInfoTipoVeiculo.valueOfCodigo("3"));
        Assertions.assertEquals(NFNotaInfoTipoVeiculo.MOTONETA, NFNotaInfoTipoVeiculo.valueOfCodigo("003"));
        Assertions.assertEquals(NFNotaInfoTipoVeiculo.MOTOCICLO, NFNotaInfoTipoVeiculo.valueOfCodigo("4"));
        Assertions.assertEquals(NFNotaInfoTipoVeiculo.MOTOCICLO, NFNotaInfoTipoVeiculo.valueOfCodigo("0004"));
        Assertions.assertEquals(NFNotaInfoTipoVeiculo.TRICICLO, NFNotaInfoTipoVeiculo.valueOfCodigo("5"));
        Assertions.assertEquals(NFNotaInfoTipoVeiculo.TRICICLO, NFNotaInfoTipoVeiculo.valueOfCodigo("05"));
        Assertions.assertEquals(NFNotaInfoTipoVeiculo.AUTOMOVEL, NFNotaInfoTipoVeiculo.valueOfCodigo("6"));
        Assertions.assertEquals(NFNotaInfoTipoVeiculo.AUTOMOVEL, NFNotaInfoTipoVeiculo.valueOfCodigo("06"));
        Assertions.assertEquals(NFNotaInfoTipoVeiculo.MICROONIBUS, NFNotaInfoTipoVeiculo.valueOfCodigo("7"));
        Assertions.assertEquals(NFNotaInfoTipoVeiculo.MICROONIBUS, NFNotaInfoTipoVeiculo.valueOfCodigo("07"));
        Assertions.assertEquals(NFNotaInfoTipoVeiculo.ONIBUS, NFNotaInfoTipoVeiculo.valueOfCodigo("8"));
        Assertions.assertEquals(NFNotaInfoTipoVeiculo.ONIBUS, NFNotaInfoTipoVeiculo.valueOfCodigo("08"));
        Assertions.assertEquals(NFNotaInfoTipoVeiculo.REBOQUE, NFNotaInfoTipoVeiculo.valueOfCodigo("10"));
        Assertions.assertEquals(NFNotaInfoTipoVeiculo.SEMIRREBOQUE, NFNotaInfoTipoVeiculo.valueOfCodigo("11"));
        Assertions.assertEquals(NFNotaInfoTipoVeiculo.CAMINHONETA, NFNotaInfoTipoVeiculo.valueOfCodigo("13"));
        Assertions.assertEquals(NFNotaInfoTipoVeiculo.CAMINHAO, NFNotaInfoTipoVeiculo.valueOfCodigo("14"));
        Assertions.assertEquals(NFNotaInfoTipoVeiculo.TRATOR, NFNotaInfoTipoVeiculo.valueOfCodigo("17"));
        Assertions.assertEquals(NFNotaInfoTipoVeiculo.TRATOR_RODAS, NFNotaInfoTipoVeiculo.valueOfCodigo("18"));
        Assertions.assertEquals(NFNotaInfoTipoVeiculo.TRATOR_ESTEIRAS, NFNotaInfoTipoVeiculo.valueOfCodigo("19"));
        Assertions.assertEquals(NFNotaInfoTipoVeiculo.TRATOR_MISTO, NFNotaInfoTipoVeiculo.valueOfCodigo("20"));
        Assertions.assertEquals(NFNotaInfoTipoVeiculo.QUADRICICLO, NFNotaInfoTipoVeiculo.valueOfCodigo("21"));
        Assertions.assertEquals(NFNotaInfoTipoVeiculo.ESP_ONIBUS, NFNotaInfoTipoVeiculo.valueOfCodigo("22"));
        Assertions.assertEquals(NFNotaInfoTipoVeiculo.MISTO_CAM, NFNotaInfoTipoVeiculo.valueOfCodigo("23"));
        Assertions.assertEquals(NFNotaInfoTipoVeiculo.CARGA_CAM, NFNotaInfoTipoVeiculo.valueOfCodigo("24"));
        Assertions.assertEquals(NFNotaInfoTipoVeiculo.UTILITARIO, NFNotaInfoTipoVeiculo.valueOfCodigo("25"));
        Assertions.assertEquals(NFNotaInfoTipoVeiculo.MOTOR_CASA, NFNotaInfoTipoVeiculo.valueOfCodigo("26"));
    }

    @Test
    public void condigoInvalidoRetornaNulo() {
        Assertions.assertNull(NFNotaInfoTipoVeiculo.valueOfCodigo("27"));
        Assertions.assertNull(NFNotaInfoTipoVeiculo.valueOfCodigo("0"));
        Assertions.assertNull(NFNotaInfoTipoVeiculo.valueOfCodigo(""));
        Assertions.assertNull(NFNotaInfoTipoVeiculo.valueOfCodigo(null));
    }
}