package com.fincatto.documentofiscal.nfe310.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoTipoVeiculoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("06", NFNotaInfoTipoVeiculo.AUTOMOVEL.getCodigo());
        Assertions.assertEquals("14", NFNotaInfoTipoVeiculo.CAMINHAO.getCodigo());
        Assertions.assertEquals("13", NFNotaInfoTipoVeiculo.CAMINHONETA.getCodigo());
        Assertions.assertEquals("24", NFNotaInfoTipoVeiculo.CARGA_CAM.getCodigo());
        Assertions.assertEquals("02", NFNotaInfoTipoVeiculo.CICLOMOTO.getCodigo());
        Assertions.assertEquals("22", NFNotaInfoTipoVeiculo.ESP_ONIBUS.getCodigo());
        Assertions.assertEquals("07", NFNotaInfoTipoVeiculo.MICROONIBUS.getCodigo());
        Assertions.assertEquals("23", NFNotaInfoTipoVeiculo.MISTO_CAM.getCodigo());
        Assertions.assertEquals("04", NFNotaInfoTipoVeiculo.MOTOCICLO.getCodigo());
        Assertions.assertEquals("03", NFNotaInfoTipoVeiculo.MOTONETA.getCodigo());
        Assertions.assertEquals("08", NFNotaInfoTipoVeiculo.ONIBUS.getCodigo());
        Assertions.assertEquals("10", NFNotaInfoTipoVeiculo.REBOQUE.getCodigo());
        Assertions.assertEquals("05", NFNotaInfoTipoVeiculo.TRICICLO.getCodigo());
        Assertions.assertEquals("17", NFNotaInfoTipoVeiculo.TRATOR.getCodigo());
    }
}