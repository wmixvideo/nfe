package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoRetencoesTributosTest {

    @Test
    public void naoDevePermitirValorRetidoPISInvalidosMonetarios() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoRetencoesTributos().setValorRetidoPIS(new BigDecimal("1000000000000000")));
    }

    @Test
    public void naoDevePermitirValorRetidoIRRFInvalidosMonetarios() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoRetencoesTributos().setValorRetidoIRRF(new BigDecimal("1000000000000000")));
    }

    @Test
    public void naoDevePermitirValorRetidoCSLLInvalidosMonetarios() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoRetencoesTributos().setValorRetidoCSLL(new BigDecimal("1000000000000000")));
    }

    @Test
    public void naoDevePermitirValorRetidoCOFINSInvalidosMonetarios() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoRetencoesTributos().setValorRetidoCOFINS(new BigDecimal("1000000000000000")));
    }

    @Test
    public void naoDevePermitirValorRetencaoPrevidenciaSocialInvalidosMonetarios() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoRetencoesTributos().setValorRetencaoPrevidenciaSocial(new BigDecimal("1000000000000000")));
    }

    @Test
    public void naoDevePermitirCalculoRetencaoPrevidenciaSocialInvalidosMonetarios() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoRetencoesTributos().setBaseCalculoRetencaoPrevidenciaSocial(new BigDecimal("1000000000000000")));
    }

    @Test
    public void naoDevePermitirCalculoIRRFInvalidosMonetarios() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoRetencoesTributos().setBaseCalculoIRRF(new BigDecimal("1000000000000000")));
    }

    @Test
    public void devePermitirValoresValidosMonetarios() {
        final NFNotaInfoRetencoesTributos retencoesTributos = new NFNotaInfoRetencoesTributos();
        retencoesTributos.setBaseCalculoIRRF(new BigDecimal("999999999999.99"));
        retencoesTributos.setBaseCalculoRetencaoPrevidenciaSocial(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetencaoPrevidenciaSocial(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetidoCOFINS(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetidoCSLL(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetidoIRRF(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetidoPIS(new BigDecimal("999999999999.99"));

        retencoesTributos.setBaseCalculoIRRF(new BigDecimal("0.01"));
        retencoesTributos.setBaseCalculoRetencaoPrevidenciaSocial(new BigDecimal("1"));
        retencoesTributos.setValorRetencaoPrevidenciaSocial(new BigDecimal("1"));
        retencoesTributos.setValorRetidoCOFINS(new BigDecimal("0.01"));
        retencoesTributos.setValorRetidoCSLL(new BigDecimal("0.01"));
        retencoesTributos.setValorRetidoIRRF(new BigDecimal("0.01"));
        retencoesTributos.setValorRetidoPIS(new BigDecimal("0.1"));
    }

    @Test
    public void devePermitirBaseCalculoIRRFNulo() {
        final NFNotaInfoRetencoesTributos retencoesTributos = new NFNotaInfoRetencoesTributos();
        retencoesTributos.setBaseCalculoRetencaoPrevidenciaSocial(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetencaoPrevidenciaSocial(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetidoCOFINS(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetidoCSLL(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetidoIRRF(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetidoPIS(new BigDecimal("999999999999.99"));
        retencoesTributos.toString();
    }

    @Test
    public void devePermitirValorRetencaoPrevidenciaSocialNulo() {
        final NFNotaInfoRetencoesTributos retencoesTributos = new NFNotaInfoRetencoesTributos();
        retencoesTributos.setBaseCalculoIRRF(new BigDecimal("999999999999.99"));
        retencoesTributos.setBaseCalculoRetencaoPrevidenciaSocial(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetidoCOFINS(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetidoCSLL(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetidoIRRF(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetidoPIS(new BigDecimal("999999999999.99"));
        retencoesTributos.toString();
    }

    @Test
    public void devePermitirValorRetidoCOFINSNulo() {
        final NFNotaInfoRetencoesTributos retencoesTributos = new NFNotaInfoRetencoesTributos();
        retencoesTributos.setBaseCalculoIRRF(new BigDecimal("999999999999.99"));
        retencoesTributos.setBaseCalculoRetencaoPrevidenciaSocial(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetencaoPrevidenciaSocial(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetidoCSLL(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetidoIRRF(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetidoPIS(new BigDecimal("999999999999.99"));
        retencoesTributos.toString();
    }

    @Test
    public void devePermitirValorRetidoCSLLNulo() {
        final NFNotaInfoRetencoesTributos retencoesTributos = new NFNotaInfoRetencoesTributos();
        retencoesTributos.setBaseCalculoIRRF(new BigDecimal("999999999999.99"));
        retencoesTributos.setBaseCalculoRetencaoPrevidenciaSocial(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetencaoPrevidenciaSocial(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetidoCOFINS(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetidoIRRF(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetidoPIS(new BigDecimal("999999999999.99"));
        retencoesTributos.toString();
    }

    @Test
    public void devePermitirValorRetidoIRRFNulo() {
        final NFNotaInfoRetencoesTributos retencoesTributos = new NFNotaInfoRetencoesTributos();
        retencoesTributos.setBaseCalculoIRRF(new BigDecimal("999999999999.99"));
        retencoesTributos.setBaseCalculoRetencaoPrevidenciaSocial(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetencaoPrevidenciaSocial(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetidoCOFINS(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetidoCSLL(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetidoPIS(new BigDecimal("999999999999.99"));
        retencoesTributos.toString();
    }

    @Test
    public void devePermitirValorRetidoPISNulo() {
        final NFNotaInfoRetencoesTributos retencoesTributos = new NFNotaInfoRetencoesTributos();
        retencoesTributos.setBaseCalculoIRRF(new BigDecimal("999999999999.99"));
        retencoesTributos.setBaseCalculoRetencaoPrevidenciaSocial(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetencaoPrevidenciaSocial(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetidoCOFINS(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetidoCSLL(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetidoIRRF(new BigDecimal("999999999999.99"));
        retencoesTributos.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecidoComVagao() {
        final String xmlEsperado = "<NFNotaInfoRetencoesTributos><vRetPIS>999999999999.99</vRetPIS><vRetCOFINS>999999999999.99</vRetCOFINS><vRetCSLL>999999999999.99</vRetCSLL><vBCIRRF>999999999999.99</vBCIRRF><vIRRF>999999999999.99</vIRRF><vBCRetPrev>999999999999.99</vBCRetPrev><vRetPrev>999999999999.99</vRetPrev></NFNotaInfoRetencoesTributos>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoRetencoesTributos().toString());
    }
}