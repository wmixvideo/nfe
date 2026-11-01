package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoICMSTotalTest {

    @Test
    public void naoDevePermitirValorTotalTributosInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoICMSTotal().setValorTotalTributos(new BigDecimal("1000000000000000")));
    }

    @Test
    public void naoDevePermitirValorTotalSeguroInvalidoMonetario() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoICMSTotal().setValorTotalSeguro(new BigDecimal("1000000000000000")));
    }

    @Test
    public void naoDevePermitirValorTotalNFeInvalidoMonetario() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoICMSTotal().setValorTotalNFe(new BigDecimal("1000000000000000")));
    }

    @Test
    public void naoDevePermitirValorTotalIPIInvalidoMonetario() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoICMSTotal().setValorTotalIPI(new BigDecimal("1000000000000000")));
    }

    @Test
    public void naoDevePermitirValorTotalIIInvalidoMonetario() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoICMSTotal().setValorTotalII(new BigDecimal("1000000000000000")));
    }

    @Test
    public void naoDevePermitirValorTotalICMSSTInvalidoMonetario() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoICMSTotal().setValorTotalICMSST(new BigDecimal("1000000000000000")));
    }

    @Test
    public void naoDevePermitirValorTotalICMSInvalidoMonetario() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoICMSTotal().setValorTotalICMS(new BigDecimal("1000000000000000")));
    }

    @Test
    public void naoDevePermitirValorTotalFreteInvalidoMonetario() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoICMSTotal().setValorTotalFrete(new BigDecimal("1000000000000000")));
    }

    @Test
    public void naoDevePermitirValorTotalDosProdutosServicosInvalidoMonetario() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoICMSTotal().setValorTotalDosProdutosServicos(new BigDecimal("1000000000000000")));
    }

    @Test
    public void naoDevePermitirValorTotalDescontoInvalidoMonetario() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoICMSTotal().setValorTotalDesconto(new BigDecimal("1000000000000000")));
    }

    @Test
    public void naoDevePermitirValorPISInvalidoMonetario() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoICMSTotal().setValorPIS(new BigDecimal("1000000000000000")));
    }

    @Test
    public void naoDevePermitirValorCOFINSInvalidoMonetario() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoICMSTotal().setValorCOFINS(new BigDecimal("1000000000000000")));
    }

    @Test
    public void naoDevePermitirValorInvalidoMonetario() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoICMSTotal().setBaseCalculoICMSST(new BigDecimal("1000000000000000")));
    }

    @Test
    public void naoDevePermitirOutrasDespesasAcessoriasInvalidoMonetario() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoICMSTotal().setOutrasDespesasAcessorias(new BigDecimal("1000000000000000")));
    }

    @Test
    public void naoDevePermitirBaseCalculoICMSInvalidoMonetario() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoICMSTotal().setBaseCalculoICMS(new BigDecimal("1000000000000000")));
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

    @Test
    public void naoDevePermitirBaseCalculoICMSNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirOutrasDespesasAcessoriasNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirValorNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirCOFINSNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirTotalPISNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirTotalDescontoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitrValorTotalDosProdutosServicosNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirFreteNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirICMSNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirICMSSTNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirValorTotalIINulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirValorTotalIPINulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirValorTotalNFeNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirValorTotalSeguroNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
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
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoICMSTotal().toString());
    }

    @Test
    public void deveGerarXMLFreteZerado() {
        final String xmlEsperado = "<NFNotaInfoICMSTotal><vBC>999999999999.99</vBC><vICMS>999999999999.99</vICMS><vICMSDeson>999999999999.99</vICMSDeson><vFCPUFDest>999999999999.99</vFCPUFDest><vICMSUFDest>999999999999.99</vICMSUFDest><vICMSUFRemet>999999999999.99</vICMSUFRemet><vFCP>999999999999.99</vFCP><vBCST>999999999999.99</vBCST><vST>999999999999.99</vST><vFCPST>999999999999.99</vFCPST><vFCPSTRet>999999999999.99</vFCPSTRet><vProd>999999999999.99</vProd><vFrete>0.00</vFrete><vSeg>999999999999.99</vSeg><vDesc>999999999999.99</vDesc><vII>999999999999.99</vII><vIPI>999999999999.99</vIPI><vIPIDevol>999999999999.99</vIPIDevol><vPIS>999999999999.99</vPIS><vCOFINS>999999999999.99</vCOFINS><vOutro>999999999999.99</vOutro><vNF>999999999999.99</vNF></NFNotaInfoICMSTotal>";
        NFNotaInfoICMSTotal nfNotaInfoICMSTotal = FabricaDeObjetosFake.getNFNotaInfoICMSTotal();
        nfNotaInfoICMSTotal.setValorTotalFrete(BigDecimal.ZERO);
        Assertions.assertEquals(xmlEsperado, nfNotaInfoICMSTotal.toString());
    }
}