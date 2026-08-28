package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoCombustivelTipoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("01", NFNotaInfoCombustivelTipo.ALCOOL.getCodigo());
        Assertions.assertEquals("02", NFNotaInfoCombustivelTipo.GASOLINA.getCodigo());
        Assertions.assertEquals("03", NFNotaInfoCombustivelTipo.DIESEL.getCodigo());
        Assertions.assertEquals("04", NFNotaInfoCombustivelTipo.GASOGENIO.getCodigo());
        Assertions.assertEquals("05", NFNotaInfoCombustivelTipo.GAS_METANO.getCodigo());
        Assertions.assertEquals("06", NFNotaInfoCombustivelTipo.ELETRICO_FONTE_INTERNA.getCodigo());
        Assertions.assertEquals("07", NFNotaInfoCombustivelTipo.ELETRICO_FONTE_EXTERNA.getCodigo());
        Assertions.assertEquals("08", NFNotaInfoCombustivelTipo.GASOL_GAS_NATURAL_COMBUSTIVEL.getCodigo());
        Assertions.assertEquals("09", NFNotaInfoCombustivelTipo.ALCOOL_GAS_NATURAL.getCodigo());
        Assertions.assertEquals("10", NFNotaInfoCombustivelTipo.DIESEL_GAS_NATURAL.getCodigo());
        Assertions.assertEquals("11", NFNotaInfoCombustivelTipo.VIDE_CAMPO_OBSERVACAO.getCodigo());
        Assertions.assertEquals("12", NFNotaInfoCombustivelTipo.ALCOOL_GAS_NATURAL_VEICULAR.getCodigo());
        Assertions.assertEquals("13", NFNotaInfoCombustivelTipo.GASOLINA_GAS_NATURAL_VEICULAR.getCodigo());
        Assertions.assertEquals("14", NFNotaInfoCombustivelTipo.DIESEL_GAS_NATURAL_VEICULAR.getCodigo());
        Assertions.assertEquals("15", NFNotaInfoCombustivelTipo.GAS_NATURAL_VEICULAR.getCodigo());
        Assertions.assertEquals("16", NFNotaInfoCombustivelTipo.ALCOOL_GASOLINA.getCodigo());
        Assertions.assertEquals("17", NFNotaInfoCombustivelTipo.GASOLINA_ALCOOL_GAS_NATURAL.getCodigo());
        Assertions.assertEquals("18", NFNotaInfoCombustivelTipo.GASOLINA_ELETRICO.getCodigo());
    }
}