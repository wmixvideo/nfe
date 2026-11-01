package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoFaturaTest {

    @Test
    public void deveObterNumeroFaturaComoFoiSetado() {
        final NFNotaInfoFatura fatura = new NFNotaInfoFatura();
        final String numeroFatura = "KDVAp0aewPjmHaTsjbDX1O6NOR9tc7TxGflFLXsMZt2hEKar3oqzZ11uzEQF";
        fatura.setNumeroFatura(numeroFatura);
        Assertions.assertEquals(numeroFatura, fatura.getNumeroFatura());
    }

    @Test
    public void deveObterValorDescontoComoFoiSetado() {
        final NFNotaInfoFatura fatura = new NFNotaInfoFatura();
        final String valorDesconto = "1000.00";
        fatura.setValorDesconto(new BigDecimal(valorDesconto));
        Assertions.assertEquals(valorDesconto, fatura.getValorDesconto());
    }

    @Test
    public void deveObterValorLiquidoFaturaComoFoiSetado() {
        final NFNotaInfoFatura fatura = new NFNotaInfoFatura();
        final String valorLiquidoFatura = "1000.00";
        fatura.setValorLiquidoFatura(new BigDecimal(valorLiquidoFatura));
        Assertions.assertEquals(valorLiquidoFatura, fatura.getValorLiquidoFatura());
    }

    @Test
    public void deveObterComoFoiSetado() {
        final NFNotaInfoFatura fatura = new NFNotaInfoFatura();
        final String valorOriginalFatura = "1000.00";
        fatura.setValorOriginalFatura(new BigDecimal(valorOriginalFatura));
        Assertions.assertEquals(valorOriginalFatura, fatura.getValorOriginalFatura());
    }

    @Test
    public void devePermitirValorDescontoNulo() {
        final NFNotaInfoFatura fatura = new NFNotaInfoFatura();
        fatura.setNumeroFatura("KDVAp0aewPjmHaTsjbDX1O6NOR9tc7TxGflFLXsMZt2hEKar3oqzZ11uzEQF");
        fatura.setValorLiquidoFatura(new BigDecimal("3000"));
        fatura.setValorOriginalFatura(new BigDecimal("3001.15"));
        fatura.toString();
    }

    @Test
    public void devePermitirValorLiquidoFaturaNulo() {
        final NFNotaInfoFatura fatura = new NFNotaInfoFatura();
        fatura.setNumeroFatura("KDVAp0aewPjmHaTsjbDX1O6NOR9tc7TxGflFLXsMZt2hEKar3oqzZ11uzEQF");
        fatura.setValorDesconto(new BigDecimal("0.15"));
        fatura.setValorOriginalFatura(new BigDecimal("3001.15"));
        fatura.toString();
    }

    @Test
    public void devePermitirValorOriginalFaturaNulo() {
        final NFNotaInfoFatura fatura = new NFNotaInfoFatura();
        fatura.setNumeroFatura("KDVAp0aewPjmHaTsjbDX1O6NOR9tc7TxGflFLXsMZt2hEKar3oqzZ11uzEQF");
        fatura.setValorDesconto(new BigDecimal("0.15"));
        fatura.setValorLiquidoFatura(new BigDecimal("3000"));
        fatura.toString();
    }

    @Test
    public void devePermitirNumeroFaturaComTamanhoNulo() {
        final NFNotaInfoFatura fatura = new NFNotaInfoFatura();
        fatura.setValorDesconto(new BigDecimal("0.15"));
        fatura.setValorLiquidoFatura(new BigDecimal("3000"));
        fatura.setValorOriginalFatura(new BigDecimal("3001.15"));
        fatura.toString();
    }

    @Test
    public void devePermitirNumeroFaturaComTamanhoValido() {
        new NFNotaInfoFatura().setNumeroFatura("tQtearTIcXmO9vxNr3TPhSaItw5mk3zyTVlf2aIFXqqvtXrHoa0qPWKzUzca");
        new NFNotaInfoFatura().setNumeroFatura("9");
    }

    @Test
    public void naoDevePermitirNumeroFaturaComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoFatura().setNumeroFatura("tQtearTIcXmO9vxNr3TPhSaItw5mk3zyTVlf2aIFXqqvtXrHoa0qPWKzUzca1");
                Assertions.fail("Validacao nao funcionou");
            } catch (final IllegalStateException e) {
                new NFNotaInfoFatura().setNumeroFatura("");
            }
            Assertions.fail("Validacao nao funcionou");
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoFatura><nFat>KDVAp0aewPjmHaTsjbDX1O6NOR9tc7TxGflFLXsMZt2hEKar3oqzZ11uzEQF</nFat><vOrig>3001.15</vOrig><vDesc>0.15</vDesc><vLiq>3000.00</vLiq></NFNotaInfoFatura>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoFatura().toString());
    }
}