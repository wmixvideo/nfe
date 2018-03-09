package com.fincatto.documentofiscal.nfe400.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;

public class NFNotaInfoICMSTotalTest {

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorTotalTributosInvalido() {
        new NFNotaInfoICMSTotal().setValorTotalTributos(new BigDecimal("1000000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorTotalSeguroInvalidoMonetario() {
        new NFNotaInfoICMSTotal().setValorTotalSeguro(new BigDecimal("1000000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorTotalNFeInvalidoMonetario() {
        new NFNotaInfoICMSTotal().setValorTotalNFe(new BigDecimal("1000000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorTotalIPIInvalidoMonetario() {
        new NFNotaInfoICMSTotal().setValorTotalIPI(new BigDecimal("1000000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorTotalIIInvalidoMonetario() {
        new NFNotaInfoICMSTotal().setValorTotalII(new BigDecimal("1000000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorTotalICMSSTInvalidoMonetario() {
        new NFNotaInfoICMSTotal().setValorTotalICMSST(new BigDecimal("1000000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorTotalICMSInvalidoMonetario() {
        new NFNotaInfoICMSTotal().setValorTotalICMS(new BigDecimal("1000000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorTotalFreteInvalidoMonetario() {
        new NFNotaInfoICMSTotal().setValorTotalFrete(new BigDecimal("1000000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorTotalDosProdutosServicosInvalidoMonetario() {
        new NFNotaInfoICMSTotal().setValorTotalDosProdutosServicos(new BigDecimal("1000000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorTotalDescontoInvalidoMonetario() {
        new NFNotaInfoICMSTotal().setValorTotalDesconto(new BigDecimal("1000000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorPISInvalidoMonetario() {
        new NFNotaInfoICMSTotal().setValorPIS(new BigDecimal("1000000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorCOFINSInvalidoMonetario() {
        new NFNotaInfoICMSTotal().setValorCOFINS(new BigDecimal("1000000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorInvalidoMonetario() {
        new NFNotaInfoICMSTotal().setBaseCalculoICMSST(new BigDecimal("1000000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirOutrasDespesasAcessoriasInvalidoMonetario() {
        new NFNotaInfoICMSTotal().setOutrasDespesasAcessorias(new BigDecimal("1000000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirBaseCalculoICMSInvalidoMonetario() {
        new NFNotaInfoICMSTotal().setBaseCalculoICMS(new BigDecimal("1000000000000000"));
    }

    @Test
    public void devePermitirValorICMSDesoneradoNulo() {
        final NFNotaInfoICMSTotal icmsTotal = new NFNotaInfoICMSTotal();
        icmsTotal.setBaseCalculoICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        icmsTotal.setBaseCalculoICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorCOFINS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorPIS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDesconto(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDosProdutosServicos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFrete(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalII(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPI(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalNFe(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalSeguro(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSDesonerado(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalTributos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaDestinatario(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaRementente(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaSTRetido(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPIDevolvido(new BigDecimal("999999999999.99"));
        icmsTotal.toString();
    }

    @Test
    public void devePermitirValorTotalTributosNulo() {
        final NFNotaInfoICMSTotal icmsTotal = new NFNotaInfoICMSTotal();
        icmsTotal.setBaseCalculoICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        icmsTotal.setBaseCalculoICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorCOFINS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorPIS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDesconto(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDosProdutosServicos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFrete(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalII(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPI(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalNFe(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalSeguro(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSDesonerado(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaDestinatario(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaRementente(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaSTRetido(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPIDevolvido(new BigDecimal("999999999999.99"));
        icmsTotal.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirBaseCalculoICMSNulo() {
        final NFNotaInfoICMSTotal icmsTotal = new NFNotaInfoICMSTotal();
        icmsTotal.setOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        icmsTotal.setBaseCalculoICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorCOFINS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorPIS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDesconto(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDosProdutosServicos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFrete(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalII(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPI(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalNFe(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalSeguro(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalTributos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSDesonerado(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaDestinatario(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaRementente(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaSTRetido(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPIDevolvido(new BigDecimal("999999999999.99"));
        icmsTotal.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirOutrasDespesasAcessoriasNulo() {
        final NFNotaInfoICMSTotal icmsTotal = new NFNotaInfoICMSTotal();
        icmsTotal.setBaseCalculoICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setBaseCalculoICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorCOFINS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorPIS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDesconto(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDosProdutosServicos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFrete(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalII(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPI(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalNFe(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalSeguro(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalTributos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSDesonerado(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaDestinatario(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaRementente(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaSTRetido(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPIDevolvido(new BigDecimal("999999999999.99"));
        icmsTotal.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorNulo() {
        final NFNotaInfoICMSTotal icmsTotal = new NFNotaInfoICMSTotal();
        icmsTotal.setBaseCalculoICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        icmsTotal.setValorCOFINS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorPIS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDesconto(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDosProdutosServicos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFrete(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalII(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPI(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalNFe(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalSeguro(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalTributos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSDesonerado(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaDestinatario(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaRementente(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaSTRetido(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPIDevolvido(new BigDecimal("999999999999.99"));
        icmsTotal.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCOFINSNulo() {
        final NFNotaInfoICMSTotal icmsTotal = new NFNotaInfoICMSTotal();
        icmsTotal.setBaseCalculoICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        icmsTotal.setBaseCalculoICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorPIS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDesconto(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDosProdutosServicos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFrete(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalII(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPI(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalNFe(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalSeguro(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalTributos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSDesonerado(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaDestinatario(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaRementente(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaSTRetido(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPIDevolvido(new BigDecimal("999999999999.99"));
        icmsTotal.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirTotalPISNulo() {
        final NFNotaInfoICMSTotal icmsTotal = new NFNotaInfoICMSTotal();
        icmsTotal.setBaseCalculoICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        icmsTotal.setBaseCalculoICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorCOFINS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDesconto(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDosProdutosServicos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFrete(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalII(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPI(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalNFe(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalSeguro(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalTributos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSDesonerado(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaDestinatario(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaRementente(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaSTRetido(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPIDevolvido(new BigDecimal("999999999999.99"));
        icmsTotal.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirTotalDescontoNulo() {
        final NFNotaInfoICMSTotal icmsTotal = new NFNotaInfoICMSTotal();
        icmsTotal.setBaseCalculoICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        icmsTotal.setBaseCalculoICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorCOFINS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorPIS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDosProdutosServicos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFrete(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalII(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPI(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalNFe(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalSeguro(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalTributos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSDesonerado(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaDestinatario(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaRementente(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaSTRetido(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPIDevolvido(new BigDecimal("999999999999.99"));
        icmsTotal.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitrValorTotalDosProdutosServicosNulo() {
        final NFNotaInfoICMSTotal icmsTotal = new NFNotaInfoICMSTotal();
        icmsTotal.setBaseCalculoICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        icmsTotal.setBaseCalculoICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorCOFINS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorPIS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDesconto(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFrete(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalII(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPI(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalNFe(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalSeguro(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalTributos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSDesonerado(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaDestinatario(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaRementente(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaSTRetido(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPIDevolvido(new BigDecimal("999999999999.99"));
        icmsTotal.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirFreteNulo() {
        final NFNotaInfoICMSTotal icmsTotal = new NFNotaInfoICMSTotal();
        icmsTotal.setBaseCalculoICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        icmsTotal.setBaseCalculoICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorCOFINS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorPIS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDesconto(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDosProdutosServicos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalII(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPI(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalNFe(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalSeguro(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalTributos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSDesonerado(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaDestinatario(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaRementente(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaSTRetido(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPIDevolvido(new BigDecimal("999999999999.99"));
        icmsTotal.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirICMSNulo() {
        final NFNotaInfoICMSTotal icmsTotal = new NFNotaInfoICMSTotal();
        icmsTotal.setBaseCalculoICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        icmsTotal.setBaseCalculoICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorCOFINS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorPIS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDesconto(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDosProdutosServicos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFrete(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalII(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPI(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalNFe(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalSeguro(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalTributos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSDesonerado(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaDestinatario(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaRementente(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaSTRetido(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPIDevolvido(new BigDecimal("999999999999.99"));
        icmsTotal.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirICMSSTNulo() {
        final NFNotaInfoICMSTotal icmsTotal = new NFNotaInfoICMSTotal();
        icmsTotal.setBaseCalculoICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        icmsTotal.setBaseCalculoICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorCOFINS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorPIS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDesconto(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDosProdutosServicos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFrete(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalII(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPI(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalNFe(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalSeguro(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalTributos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSDesonerado(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaDestinatario(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaRementente(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaSTRetido(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPIDevolvido(new BigDecimal("999999999999.99"));
        icmsTotal.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorTotalIINulo() {
        final NFNotaInfoICMSTotal icmsTotal = new NFNotaInfoICMSTotal();
        icmsTotal.setBaseCalculoICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        icmsTotal.setBaseCalculoICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorCOFINS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorPIS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDesconto(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDosProdutosServicos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFrete(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPI(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalNFe(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalSeguro(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalTributos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSDesonerado(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaDestinatario(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaRementente(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaSTRetido(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPIDevolvido(new BigDecimal("999999999999.99"));
        icmsTotal.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorTotalIPINulo() {
        final NFNotaInfoICMSTotal icmsTotal = new NFNotaInfoICMSTotal();
        icmsTotal.setBaseCalculoICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        icmsTotal.setBaseCalculoICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorCOFINS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorPIS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDesconto(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDosProdutosServicos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFrete(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalII(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalNFe(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalSeguro(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalTributos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSDesonerado(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaDestinatario(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaRementente(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaSTRetido(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPIDevolvido(new BigDecimal("999999999999.99"));
        icmsTotal.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorTotalNFeNulo() {
        final NFNotaInfoICMSTotal icmsTotal = new NFNotaInfoICMSTotal();
        icmsTotal.setBaseCalculoICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        icmsTotal.setBaseCalculoICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorCOFINS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorPIS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDesconto(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDosProdutosServicos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFrete(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalII(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPI(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalSeguro(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalTributos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSDesonerado(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaDestinatario(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaRementente(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaSTRetido(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPIDevolvido(new BigDecimal("999999999999.99"));
        icmsTotal.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorTotalSeguroNulo() {
        final NFNotaInfoICMSTotal icmsTotal = new NFNotaInfoICMSTotal();
        icmsTotal.setBaseCalculoICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        icmsTotal.setBaseCalculoICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorCOFINS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorPIS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDesconto(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDosProdutosServicos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFrete(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalII(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPI(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalNFe(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalTributos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSDesonerado(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaDestinatario(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaRementente(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaSTRetido(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPIDevolvido(new BigDecimal("999999999999.99"));
        icmsTotal.toString();
    }

    @Test
    public void devePermitirICMSFundoCombatePobrezaNulo() {
        final NFNotaInfoICMSTotal icmsTotal = new NFNotaInfoICMSTotal();
        icmsTotal.setBaseCalculoICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        icmsTotal.setBaseCalculoICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorCOFINS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorPIS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDesconto(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDosProdutosServicos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFrete(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalII(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPI(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalNFe(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalSeguro(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSDesonerado(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaDestinatario(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaRementente(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaSTRetido(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPIDevolvido(new BigDecimal("999999999999.99"));
        icmsTotal.toString();
    }

    @Test
    public void devePermitirICMSPartilhaDestinatarioNulo() {
        final NFNotaInfoICMSTotal icmsTotal = new NFNotaInfoICMSTotal();
        icmsTotal.setBaseCalculoICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        icmsTotal.setBaseCalculoICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorCOFINS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorPIS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDesconto(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDosProdutosServicos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFrete(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalII(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPI(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalNFe(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalSeguro(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSDesonerado(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaRementente(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaSTRetido(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPIDevolvido(new BigDecimal("999999999999.99"));
        icmsTotal.toString();
    }

    @Test
    public void devePermitirICMSPartilhaRemententeNulo() {
        final NFNotaInfoICMSTotal icmsTotal = new NFNotaInfoICMSTotal();
        icmsTotal.setBaseCalculoICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        icmsTotal.setBaseCalculoICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorCOFINS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorPIS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDesconto(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDosProdutosServicos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFrete(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalII(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPI(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalNFe(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalSeguro(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSDesonerado(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorICMSPartilhaDestinatario(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFundoCombatePobrezaSTRetido(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPIDevolvido(new BigDecimal("999999999999.99"));
        icmsTotal.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoICMSTotal><vBC>999999999999.99</vBC><vICMS>999999999999.99</vICMS><vICMSDeson>999999999999.99</vICMSDeson><vFCPUFDest>999999999999.99</vFCPUFDest><vICMSUFDest>999999999999.99</vICMSUFDest><vICMSUFRemet>999999999999.99</vICMSUFRemet><vFCP>999999999999.99</vFCP><vBCST>999999999999.99</vBCST><vST>999999999999.99</vST><vFCPST>999999999999.99</vFCPST><vFCPSTRet>999999999999.99</vFCPSTRet><vProd>999999999999.99</vProd><vFrete>999999999999.99</vFrete><vSeg>999999999999.99</vSeg><vDesc>999999999999.99</vDesc><vII>999999999999.99</vII><vIPI>999999999999.99</vIPI><vIPIDevol>999999999999.99</vIPIDevol><vPIS>999999999999.99</vPIS><vCOFINS>999999999999.99</vCOFINS><vOutro>999999999999.99</vOutro><vNF>999999999999.99</vNF></NFNotaInfoICMSTotal>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoICMSTotal().toString());
    }
}