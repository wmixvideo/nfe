package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFNotaInfoCombustivelTipoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("01", NFNotaInfoCombustivelTipo.ALCOOL.getCodigo());
        Assert.assertEquals("02", NFNotaInfoCombustivelTipo.GASOLINA.getCodigo());
        Assert.assertEquals("03", NFNotaInfoCombustivelTipo.DIESEL.getCodigo());
        Assert.assertEquals("04", NFNotaInfoCombustivelTipo.GASOGENIO.getCodigo());
        Assert.assertEquals("05", NFNotaInfoCombustivelTipo.GAS_METANO.getCodigo());
        Assert.assertEquals("06", NFNotaInfoCombustivelTipo.ELETRICO_FONTE_INTERNA.getCodigo());
        Assert.assertEquals("07", NFNotaInfoCombustivelTipo.ELETRICO_FONTE_EXTERNA.getCodigo());
        Assert.assertEquals("08", NFNotaInfoCombustivelTipo.GASOL_GAS_NATURAL_COMBUSTIVEL.getCodigo());
        Assert.assertEquals("09", NFNotaInfoCombustivelTipo.ALCOOL_GAS_NATURAL.getCodigo());
        Assert.assertEquals("10", NFNotaInfoCombustivelTipo.DIESEL_GAS_NATURAL.getCodigo());
        Assert.assertEquals("11", NFNotaInfoCombustivelTipo.VIDE_CAMPO_OBSERVACAO.getCodigo());
        Assert.assertEquals("12", NFNotaInfoCombustivelTipo.ALCOOL_GAS_NATURAL_VEICULAR.getCodigo());
        Assert.assertEquals("13", NFNotaInfoCombustivelTipo.GASOLINA_GAS_NATURAL_VEICULAR.getCodigo());
        Assert.assertEquals("14", NFNotaInfoCombustivelTipo.DIESEL_GAS_NATURAL_VEICULAR.getCodigo());
        Assert.assertEquals("15", NFNotaInfoCombustivelTipo.GAS_NATURAL_VEICULAR.getCodigo());
        Assert.assertEquals("16", NFNotaInfoCombustivelTipo.ALCOOL_GASOLINA.getCodigo());
        Assert.assertEquals("17", NFNotaInfoCombustivelTipo.GASOLINA_ALCOOL_GAS_NATURAL.getCodigo());
        Assert.assertEquals("18", NFNotaInfoCombustivelTipo.GASOLINA_ELETRICO.getCodigo());
    }
}