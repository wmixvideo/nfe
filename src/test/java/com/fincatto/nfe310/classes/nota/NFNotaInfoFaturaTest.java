package com.fincatto.nfe310.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe310.FabricaDeObjetosFake;
import com.fincatto.nfe310.classes.nota.NFNotaInfoFatura;

public class NFNotaInfoFaturaTest {
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

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroFaturaComTamanhoInvalido() {
        try {
            new NFNotaInfoFatura().setNumeroFatura("tQtearTIcXmO9vxNr3TPhSaItw5mk3zyTVlf2aIFXqqvtXrHoa0qPWKzUzca1");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
            new NFNotaInfoFatura().setNumeroFatura("");
        }
        Assert.fail("Validacao nao funcionou");
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoFatura><nFat>KDVAp0aewPjmHaTsjbDX1O6NOR9tc7TxGflFLXsMZt2hEKar3oqzZ11uzEQF</nFat><vOrig>3001.15</vOrig><vDesc>0.15</vDesc><vLiq>3000.00</vLiq></NFNotaInfoFatura>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoFatura().toString());
    }
}