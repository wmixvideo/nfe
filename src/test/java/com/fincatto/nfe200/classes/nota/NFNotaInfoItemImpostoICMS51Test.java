package com.fincatto.nfe200.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe200.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.nfe200.classes.NFNotaInfoItemImpostoICMSModalidadeBaseCalulo;
import com.fincatto.nfe200.classes.NFOrigem;
import com.fincatto.nfe200.classes.nota.NFNotaInfoItemImpostoICMS51;

public class NFNotaInfoItemImpostoICMS51Test {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualICMSComTamanhoDiferente() {
        new NFNotaInfoItemImpostoICMS51().setPercentualICMS(new BigDecimal("100"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualReducaoBCComTamanhoDiferente() {
        new NFNotaInfoItemImpostoICMS51().setPercentualReducaoBC(new BigDecimal("100"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorBCICMSComTamanhoDiferente() {
        new NFNotaInfoItemImpostoICMS51().setValorBCICMS(new BigDecimal("1000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorICMSComTamanhoDiferente() {
        new NFNotaInfoItemImpostoICMS51().setValorICMS(new BigDecimal("1000000000000"));
    }

    @Test
    public void naoDevePermitirModalidadeBCNulo() {
        final NFNotaInfoItemImpostoICMS51 icms51 = new NFNotaInfoItemImpostoICMS51();
        icms51.setOrigem(NFOrigem.NACIONAL);
        icms51.setPercentualICMS(new BigDecimal("99.99"));
        icms51.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms51.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA);
        icms51.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms51.setValorICMS(new BigDecimal("999999999999.99"));
        icms51.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirOrigemNulo() {
        final NFNotaInfoItemImpostoICMS51 icms51 = new NFNotaInfoItemImpostoICMS51();
        icms51.setModalidadeBC(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
        icms51.setPercentualICMS(new BigDecimal("99.99"));
        icms51.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms51.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA);
        icms51.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms51.setValorICMS(new BigDecimal("999999999999.99"));
        icms51.toString();
    }

    @Test
    public void devePermitirPercentualICMSBCNulo() {
        final NFNotaInfoItemImpostoICMS51 icms51 = new NFNotaInfoItemImpostoICMS51();
        icms51.setModalidadeBC(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
        icms51.setOrigem(NFOrigem.NACIONAL);
        icms51.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms51.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA);
        icms51.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms51.setValorICMS(new BigDecimal("999999999999.99"));
        icms51.toString();
    }

    @Test
    public void devePermitirPercentualReducaoBCNulo() {
        final NFNotaInfoItemImpostoICMS51 icms51 = new NFNotaInfoItemImpostoICMS51();
        icms51.setModalidadeBC(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
        icms51.setOrigem(NFOrigem.NACIONAL);
        icms51.setPercentualICMS(new BigDecimal("99.99"));
        icms51.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA);
        icms51.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms51.setValorICMS(new BigDecimal("999999999999.99"));
        icms51.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSituacaoTributariaNulo() {
        final NFNotaInfoItemImpostoICMS51 icms51 = new NFNotaInfoItemImpostoICMS51();
        icms51.setModalidadeBC(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
        icms51.setOrigem(NFOrigem.NACIONAL);
        icms51.setPercentualICMS(new BigDecimal("99.99"));
        icms51.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms51.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms51.setValorICMS(new BigDecimal("999999999999.99"));
        icms51.toString();
    }

    @Test
    public void devePermitirValorBCICMSNulo() {
        final NFNotaInfoItemImpostoICMS51 icms51 = new NFNotaInfoItemImpostoICMS51();
        icms51.setModalidadeBC(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
        icms51.setOrigem(NFOrigem.NACIONAL);
        icms51.setPercentualICMS(new BigDecimal("99.99"));
        icms51.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms51.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA);
        icms51.setValorICMS(new BigDecimal("999999999999.99"));
        icms51.toString();
    }

    @Test
    public void devePermitirValorICMSNulo() {
        final NFNotaInfoItemImpostoICMS51 icms51 = new NFNotaInfoItemImpostoICMS51();
        icms51.setModalidadeBC(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
        icms51.setOrigem(NFOrigem.NACIONAL);
        icms51.setPercentualICMS(new BigDecimal("99.99"));
        icms51.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms51.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA);
        icms51.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms51.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoICMS51 icms51 = new NFNotaInfoItemImpostoICMS51();
        icms51.setModalidadeBC(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
        icms51.setOrigem(NFOrigem.NACIONAL);
        icms51.setPercentualICMS(new BigDecimal("99.99"));
        icms51.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms51.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA);
        icms51.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms51.setValorICMS(new BigDecimal("999999999999.99"));

        final String xmlEsperado = "<NFNotaInfoItemImpostoICMS51><orig>0</orig><CST>40</CST><modBC>3</modBC><pRedBC>99.99</pRedBC><vBC>999999999999.99</vBC><pICMS>99.99</pICMS><vICMS>999999999999.99</vICMS></NFNotaInfoItemImpostoICMS51>";
        Assert.assertEquals(xmlEsperado, icms51.toString());
    }
}