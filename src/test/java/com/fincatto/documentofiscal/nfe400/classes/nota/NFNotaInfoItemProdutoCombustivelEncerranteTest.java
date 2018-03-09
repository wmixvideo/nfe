package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemProdutoCombustivelEncerranteTest {

    @Test
    public void deveGerarXmlDeAcordoComPadrao(){
        NFNotaInfoItemProdutoCombustivelEncerrante combustivel = new NFNotaInfoItemProdutoCombustivelEncerrante();
        combustivel.setNumeroBico("1");
        combustivel.setNumeroBomba("2");
        combustivel.setNumeroTanque("10");
        combustivel.setValorEncerramentoInicial(new BigDecimal("100"));
        combustivel.setValorEncerramentoFinal(new BigDecimal("200"));

        String xml = "<NFNotaInfoItemProdutoCombustivelEncerrante><nBico>1</nBico><nBomba>2</nBomba><nTanque>10</nTanque><vEncIni>100.000</vEncIni><vEncFin>200.000</vEncFin></NFNotaInfoItemProdutoCombustivelEncerrante>";
        Assert.assertEquals(xml, combustivel.toString());

    }


}