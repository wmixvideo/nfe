package com.fincatto.documentofiscal.nfe400.classes.nota;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;

public class NFNotaInfoItemProdutoDeclaracaoImportacaoAdicaoTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoFabricanteComTamanhoInvalido() {
        try {
            new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao().setCodigoFabricante("");
        } catch (final IllegalStateException e) {
            new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao().setCodigoFabricante("sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki1");
        }
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirNumeroAtoConcessorioDrawbackComTamanhoInvalido() {
        new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao().setNumeroAtoConcessorioDrawback(new BigInteger("100000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirDescontoComTamanhoInvalido() {
        new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao().setDesconto(new BigDecimal("10000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirNumeroComTamanhoInvalido() {
        new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao().setNumero(1000);
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirSequencialComTamanhoInvalido() {
        new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao().setSequencial(1000);
    }

    @Test
    public void devePermitirNumeroAtoConcessorioDrawbackNulo() {
        final NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao importacaoAdicao = new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao();
        importacaoAdicao.setCodigoFabricante("sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki");
        importacaoAdicao.setDesconto(new BigDecimal("999999999999.99"));
        importacaoAdicao.setNumero(999);
        importacaoAdicao.setSequencial(999);
        importacaoAdicao.setNumeroAtoConcessorioDrawback(new BigInteger("99999999999"));
        importacaoAdicao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoFabricanteNulo() {
        final NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao importacaoAdicao = new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao();
        importacaoAdicao.setDesconto(new BigDecimal("999999999999.99"));
        importacaoAdicao.setNumero(999);
        importacaoAdicao.setSequencial(999);
        importacaoAdicao.setNumeroAtoConcessorioDrawback(new BigInteger("99999999999"));
        importacaoAdicao.toString();
    }

    @Test
    public void devePermitirDescontoNulo() {
        final NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao importacaoAdicao = new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao();
        importacaoAdicao.setCodigoFabricante("sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki");
        importacaoAdicao.setNumero(999);
        importacaoAdicao.setSequencial(999);
        importacaoAdicao.setNumeroAtoConcessorioDrawback(new BigInteger("99999999999"));
        importacaoAdicao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroNulo() {
        final NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao importacaoAdicao = new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao();
        importacaoAdicao.setCodigoFabricante("sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki");
        importacaoAdicao.setDesconto(new BigDecimal("999999999999.99"));
        importacaoAdicao.setSequencial(999);
        importacaoAdicao.setNumeroAtoConcessorioDrawback(new BigInteger("99999999999"));
        importacaoAdicao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSequencialNulo() {
        final NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao importacaoAdicao = new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao();
        importacaoAdicao.setCodigoFabricante("sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki");
        importacaoAdicao.setDesconto(new BigDecimal("999999999999.99"));
        importacaoAdicao.setNumero(999);
        importacaoAdicao.setNumeroAtoConcessorioDrawback(new BigInteger("99999999999"));
        importacaoAdicao.toString();
    }

    @Test
    public void devePermitirItemPedidoCompraNulo() {
        final NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao importacaoAdicao = new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao();
        importacaoAdicao.setCodigoFabricante("sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki");
        importacaoAdicao.setDesconto(new BigDecimal("999999999999.99"));
        importacaoAdicao.setNumero(999);
        importacaoAdicao.setSequencial(999);
        importacaoAdicao.setNumeroAtoConcessorioDrawback(new BigInteger("99999999999"));
        importacaoAdicao.toString();
    }

    @Test
    public void devePermitirNumeroPedidoCompraNulo() {
        final NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao importacaoAdicao = new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao();
        importacaoAdicao.setCodigoFabricante("sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki");
        importacaoAdicao.setDesconto(new BigDecimal("999999999999.99"));
        importacaoAdicao.setNumero(999);
        importacaoAdicao.setSequencial(999);
        importacaoAdicao.setNumeroAtoConcessorioDrawback(new BigInteger("99999999999"));
        importacaoAdicao.toString();
    }

    @Test
    public void deveObterCodigoFabricanteComoFoiSetado() {
        final NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao importacaoAdicao = new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao();
        final String codigoFabricante = "sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki";
        importacaoAdicao.setCodigoFabricante(codigoFabricante);
        Assert.assertEquals(codigoFabricante, importacaoAdicao.getCodigoFabricante());
    }

    @Test
    public void deveObterDescontoComoFoiSetado() {
        final NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao importacaoAdicao = new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao();
        importacaoAdicao.setDesconto(new BigDecimal("999999999999.99"));
        Assert.assertEquals("999999999999.99", importacaoAdicao.getDesconto());
    }

    @Test
    public void deveObterNumeroComoFoiSetado() {
        final NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao importacaoAdicao = new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao();
        final Integer numero = 999;
        importacaoAdicao.setNumero(numero);
        Assert.assertEquals(numero, importacaoAdicao.getNumero());
    }

    @Test
    public void deveObterNumeroAtoConcessorioDrawbackComoFoiSetado() {
        final NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao importacaoAdicao = new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao();
        final BigInteger numeroAtoConcessorioDrawback = new BigInteger("99999999999");
        importacaoAdicao.setNumeroAtoConcessorioDrawback(numeroAtoConcessorioDrawback);
        Assert.assertEquals(numeroAtoConcessorioDrawback, importacaoAdicao.getNumeroAtoConcessorioDrawback());
    }

    @Test
    public void deveObterSequencialComoFoiSetado() {
        final NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao importacaoAdicao = new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao();
        final Integer sequencial = 999;
        importacaoAdicao.setSequencial(sequencial);
        Assert.assertEquals(sequencial, importacaoAdicao.getSequencial());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao><nAdicao>999</nAdicao><nSeqAdic>999</nSeqAdic><cFabricante>sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki</cFabricante><vDescDI>999999999999.99</vDescDI><nDraw>99999999999</nDraw></NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacaoAdicao().toString());
    }
}