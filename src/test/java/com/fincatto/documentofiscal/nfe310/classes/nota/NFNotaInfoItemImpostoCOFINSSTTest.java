package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
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
}