package com.fincatto.nfe.core.nota;

import com.fincatto.nfe.core.FabricaDeObjetosFake;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoImportacaoTest {

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorBaseCalculoInvalido() {
        new NFNotaInfoItemImpostoImportacao().setValorBaseCalculo(new BigDecimal("99999999999999"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorDespesaAduaneiraTamanhoInvalido() {
        new NFNotaInfoItemImpostoImportacao().setValorDespesaAduaneira(new BigDecimal("99999999999999"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirImpostoImportacaoTamanhoInvalido() {
        new NFNotaInfoItemImpostoImportacao().setValorImpostoImportacao(new BigDecimal("99999999999999"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorIOFTamanhoInvalido() {
        new NFNotaInfoItemImpostoImportacao().setValorIOF(new BigDecimal("99999999999999"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorBaseCalculoNulo() {
        final NFNotaInfoItemImpostoImportacao importacao = new NFNotaInfoItemImpostoImportacao();
        importacao.setValorDespesaAduaneira(new BigDecimal("999999999999.99"));
        importacao.setValorImpostoImportacao(new BigDecimal("999999999999.99"));
        importacao.setValorIOF(new BigDecimal("999999999999.99"));
        importacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorDespesaAduaneiraNulo() {
        final NFNotaInfoItemImpostoImportacao importacao = new NFNotaInfoItemImpostoImportacao();
        importacao.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        importacao.setValorImpostoImportacao(new BigDecimal("999999999999.99"));
        importacao.setValorIOF(new BigDecimal("999999999999.99"));
        importacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirImpostoImportacaoNulo() {
        final NFNotaInfoItemImpostoImportacao importacao = new NFNotaInfoItemImpostoImportacao();
        importacao.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        importacao.setValorDespesaAduaneira(new BigDecimal("999999999999.99"));
        importacao.setValorIOF(new BigDecimal("999999999999.99"));
        importacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorIOFNulo() {
        final NFNotaInfoItemImpostoImportacao importacao = new NFNotaInfoItemImpostoImportacao();
        importacao.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        importacao.setValorDespesaAduaneira(new BigDecimal("999999999999.99"));
        importacao.setValorImpostoImportacao(new BigDecimal("999999999999.99"));
        importacao.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoImportacao><vBC>999999999999.99</vBC><vDespAdu>999999999999.99</vDespAdu><vII>999999999999.99</vII><vIOF>999999999999.99</vIOF></NFNotaInfoItemImpostoImportacao>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoImportacao().toString());
    }
}