package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMSPrevistoPagtoAntecipTest {

    @Test
    public void naoDevePermitirValorICMSPrevistoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSPrevistoPagtoAntecip().setValorICMSPrevisto(new BigDecimal("10000000000000")));
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSPrevistoPagtoAntecip().setValorICMSPrevisto(new BigDecimal("1.123")));
    }

    @Test
    public void naoDevePermitirValorICMSPrevistoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFNotaInfoItemImpostoICMSPrevistoPagtoAntecip().toString());
    }

    @Test
    public void deveObterValorICMSPrevistoComoFoiSetado() {
        final NFNotaInfoItemImpostoICMSPrevistoPagtoAntecip icmsPrevisto = new NFNotaInfoItemImpostoICMSPrevistoPagtoAntecip();
        icmsPrevisto.setValorICMSPrevisto(new BigDecimal("999999999999.99"));
        Assertions.assertEquals("999999999999.99", icmsPrevisto.getValorICMSPrevisto());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoICMSPrevistoPagtoAntecip><vICMSPrevisto>999999999999.99</vICMSPrevisto></NFNotaInfoItemImpostoICMSPrevistoPagtoAntecip>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoICMSPrevistoPagtoAntecip().toString());
    }

    @Test
    public void deveGerarXMLDoGrupoICMSComICMSPrevistoPagtoAntecip() {
        final NFNotaInfoItemImpostoICMS icms = new NFNotaInfoItemImpostoICMS();
        icms.setIcmsPrevistoPagtoAntecip(FabricaDeObjetosFake.getNFNotaInfoItemImpostoICMSPrevistoPagtoAntecip());
        final String xmlEsperado = "<NFNotaInfoItemImpostoICMS><ICMSPrevistoPagtoAntecip><vICMSPrevisto>999999999999.99</vICMSPrevisto></ICMSPrevistoPagtoAntecip></NFNotaInfoItemImpostoICMS>";
        Assertions.assertEquals(xmlEsperado, icms.toString());
    }
}
