package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoCOFINSSTTest {

    @Test
    public void naoDevePermitirValorCOFINSForaoDoLimite() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoCOFINSST().setValorCOFINS(new BigDecimal("99999999999999999")));
    }

    @Test
    public void naoDevePermitirValorAliquotaCOFINSForaoDoLimite() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoCOFINSST().setValorAliquotaCOFINS(new BigDecimal("99999999999999999")));
    }

    @Test
    public void naoDevePermitirQuantidadeVendidaForaDoLimite() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoCOFINSST().setQuantidadeVendida(new BigDecimal("999999999999999999")));
    }

    @Test
    public void naoDevePermitirValorPercentualAliquotaCOFINSForaDoLimite() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoCOFINSST().setPercentualAliquota(new BigDecimal("1000.01")));
    }

    @Test
    public void naoDevePermitirValorBaseCalculoForaDoLimite() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoCOFINSST().setValorBaseCalculo(new BigDecimal("99999999999999999")));
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoCOFINSST><vBC>999999999999.99</vBC><pCOFINS>99.99</pCOFINS><vCOFINS>999999999999.00</vCOFINS></NFNotaInfoItemImpostoCOFINSST>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSST().toString());
    }

    @Test
    public void deveGerarXMLIndicacaoSomaConfins() {
        final NFNotaInfoItemImpostoCOFINSST impostoCOFINSST = FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSST();
        impostoCOFINSST.setIndicadorSomaCOFINSST(NFIndicadorSomaCofinsST.COMPOE_VALOR_TOTAL);
        final String xmlEsperado = "<NFNotaInfoItemImpostoCOFINSST><vBC>999999999999.99</vBC><pCOFINS>99.99</pCOFINS><vCOFINS>999999999999.00</vCOFINS><indSomaCOFINSST>1</indSomaCOFINSST></NFNotaInfoItemImpostoCOFINSST>";
        Assertions.assertEquals(xmlEsperado, impostoCOFINSST.toString());

        impostoCOFINSST.setIndicadorSomaCOFINSST(NFIndicadorSomaCofinsST.NAO_COMPOE_VALOR_TOTAL);
        final String xmlEsperadoII = "<NFNotaInfoItemImpostoCOFINSST><vBC>999999999999.99</vBC><pCOFINS>99.99</pCOFINS><vCOFINS>999999999999.00</vCOFINS><indSomaCOFINSST>0</indSomaCOFINSST></NFNotaInfoItemImpostoCOFINSST>";
        Assertions.assertEquals(xmlEsperadoII, impostoCOFINSST.toString());
    }
}