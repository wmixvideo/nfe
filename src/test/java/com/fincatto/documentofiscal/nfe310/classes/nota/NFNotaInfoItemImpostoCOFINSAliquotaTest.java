package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoSituacaoTributariaCOFINS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoCOFINSAliquotaTest {

    @Test
    public void naoDevePermitirValorTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoCOFINSAliquota().setValor(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirValorBaseCaluloTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoCOFINSAliquota().setValorBaseCalculo(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirPercentualAliquotaTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoCOFINSAliquota().setPercentualAliquota(new BigDecimal("1000")));
    }

    @Test
    public void naoDeveValorBaseCalculoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoCOFINSAliquota cofinsAliquota = new NFNotaInfoItemImpostoCOFINSAliquota();
            cofinsAliquota.setPercentualAliquota(new BigDecimal("99.99"));
            cofinsAliquota.setSituacaoTributaria(NFNotaInfoSituacaoTributariaCOFINS.CREDITO_PRESUMIDO_OUTRAS_OPERACOES);
            cofinsAliquota.setValor(new BigDecimal("999999999999.99"));
            cofinsAliquota.toString();
        });
    }

    @Test
    public void naoDeveValorAliquotaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoCOFINSAliquota cofinsAliquota = new NFNotaInfoItemImpostoCOFINSAliquota();
            cofinsAliquota.setPercentualAliquota(new BigDecimal("99.99"));
            cofinsAliquota.setSituacaoTributaria(NFNotaInfoSituacaoTributariaCOFINS.CREDITO_PRESUMIDO_OUTRAS_OPERACOES);
            cofinsAliquota.setValorBaseCalculo(new BigDecimal("999999999999.99"));
            cofinsAliquota.toString();
        });
    }

    @Test
    public void naoDeveSituacaoTributariaAliquotaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoCOFINSAliquota cofinsAliquota = new NFNotaInfoItemImpostoCOFINSAliquota();
            cofinsAliquota.setPercentualAliquota(new BigDecimal("99.99"));
            cofinsAliquota.setValor(new BigDecimal("999999999999.99"));
            cofinsAliquota.setValorBaseCalculo(new BigDecimal("999999999999.99"));
            cofinsAliquota.toString();
        });
    }

    @Test
    public void naoDevePermitirPercentualAliquotaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoCOFINSAliquota cofinsAliquota = new NFNotaInfoItemImpostoCOFINSAliquota();
            cofinsAliquota.setSituacaoTributaria(NFNotaInfoSituacaoTributariaCOFINS.CREDITO_PRESUMIDO_OUTRAS_OPERACOES);
            cofinsAliquota.setValor(new BigDecimal("999999999999.99"));
            cofinsAliquota.setValorBaseCalculo(new BigDecimal("999999999999.99"));
            cofinsAliquota.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoCOFINSAliquota><CST>01</CST><vBC>999999999999.99</vBC><pCOFINS>99.99</pCOFINS><vCOFINS>999999999999.99</vCOFINS></NFNotaInfoItemImpostoCOFINSAliquota>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSAliquota().toString());
    }
}