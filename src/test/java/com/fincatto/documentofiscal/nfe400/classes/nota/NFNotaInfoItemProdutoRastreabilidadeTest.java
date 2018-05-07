package com.fincatto.documentofiscal.nfe400.classes.nota;

import java.math.BigDecimal;

import java.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

public class NFNotaInfoItemProdutoRastreabilidadeTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirLoteComTamanhoInvalido() {
        try {
            new NFNotaInfoItemProdutoRastreabilidade().setNumeroLote("");
        } catch (final IllegalStateException e) {
            new NFNotaInfoItemProdutoRastreabilidade().setNumeroLote("yq50jVDZsvQVNuWoS45U1");
        }
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirQuantidadeComTamanhoInvalido() {
        new NFNotaInfoItemProdutoRastreabilidade().setQuantidadeLote(new BigDecimal("100000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirDataFabricacaoNulo() {
        final NFNotaInfoItemProdutoRastreabilidade rastreio = new NFNotaInfoItemProdutoRastreabilidade();
        rastreio.setDataValidade(LocalDate.of(2015, 1, 1));
        rastreio.setNumeroLote("yq50jVDZsvQVNuWoS45U");
        rastreio.setQuantidadeLote(new BigDecimal("9999999.999"));
        rastreio.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirDataValidadeNulo() {
        final NFNotaInfoItemProdutoRastreabilidade rastreio = new NFNotaInfoItemProdutoRastreabilidade();
        rastreio.setDataFabricacao(LocalDate.of(2014, 1, 1));
        rastreio.setNumeroLote("yq50jVDZsvQVNuWoS45U");
        rastreio.setQuantidadeLote(new BigDecimal("9999999.999"));
        rastreio.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirLoteNulo() {
        final NFNotaInfoItemProdutoRastreabilidade rastreio = new NFNotaInfoItemProdutoRastreabilidade();
        rastreio.setDataFabricacao(LocalDate.of(2014, 1, 1));
        rastreio.setDataValidade(LocalDate.of(2015, 1, 1));
        rastreio.setQuantidadeLote(new BigDecimal("9999999.999"));
        rastreio.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirQuantidadeNulo() {
        final NFNotaInfoItemProdutoRastreabilidade rastreio = new NFNotaInfoItemProdutoRastreabilidade();
        rastreio.setDataFabricacao(LocalDate.of(2014, 1, 1));
        rastreio.setDataValidade(LocalDate.of(2015, 1, 1));
        rastreio.setNumeroLote("yq50jVDZsvQVNuWoS45U");
        rastreio.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemProdutoRastreabilidade rastreio = new NFNotaInfoItemProdutoRastreabilidade();
        rastreio.setCodigoAgregacao("123456");
        rastreio.setDataFabricacao(LocalDate.of(2014, 1, 1));
        rastreio.setDataValidade(LocalDate.of(2015, 1, 1));
        rastreio.setNumeroLote("yq50jVDZsvQVNuWoS45U");
        rastreio.setQuantidadeLote(new BigDecimal("9999999.999"));

        final String xmlEsperado = "<NFNotaInfoItemProdutoRastreabilidade><nLote>yq50jVDZsvQVNuWoS45U</nLote><qLote>9999999.999</qLote><dFab>2014-01-01</dFab><dVal>2015-01-01</dVal><cAgreg>123456</cAgreg></NFNotaInfoItemProdutoRastreabilidade>";
        Assert.assertEquals(xmlEsperado, rastreio.toString());
    }
}