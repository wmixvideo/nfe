package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemProdutoDeclaracaoImportacaoAdicaoTest {

    @Test
    public void naoDevePermitirCodigoFabricanteComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao().setCodigoFabricante("");
            } catch (final IllegalStateException e) {
                new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao().setCodigoFabricante("sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki1");
            }
        });
    }

    @Test
    public void naoDevePermitirNumeroAtoConcessorioDrawbackComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao().setNumeroAtoConcessorioDrawback("999999999999999999999"));
    }

    @Test
    public void naoDevePermitirDescontoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao().setDesconto(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirNumeroComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao().setNumero(1000));
    }

    @Test
    public void naoDevePermitirSequencialComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao().setSequencial(100000));
    }

    @Test
    public void devePermitirNumeroAtoConcessorioDrawbackNulo() {
        final NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao importacaoAdicao = new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao();
        importacaoAdicao.setCodigoFabricante("sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki");
        importacaoAdicao.setDesconto(new BigDecimal("999999999999.99"));
        importacaoAdicao.setNumero(999);
        importacaoAdicao.setSequencial(999);
        importacaoAdicao.setNumeroAtoConcessorioDrawback("99999999999");
        importacaoAdicao.toString();
    }

    @Test
    public void naoDevePermitirCodigoFabricanteNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao importacaoAdicao = new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao();
            importacaoAdicao.setDesconto(new BigDecimal("999999999999.99"));
            importacaoAdicao.setNumero(999);
            importacaoAdicao.setSequencial(999);
            importacaoAdicao.setNumeroAtoConcessorioDrawback("99999999999");
            importacaoAdicao.toString();
        });
    }

    @Test
    public void devePermitirDescontoNulo() {
        final NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao importacaoAdicao = new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao();
        importacaoAdicao.setCodigoFabricante("sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki");
        importacaoAdicao.setNumero(999);
        importacaoAdicao.setSequencial(999);
        importacaoAdicao.setNumeroAtoConcessorioDrawback("99999999999");
        importacaoAdicao.toString();
    }

    @Test
    public void devePermitirNumeroNulo() {
        final NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao importacaoAdicao = new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao();
        importacaoAdicao.setCodigoFabricante("sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki");
        importacaoAdicao.setDesconto(new BigDecimal("999999999999.99"));
        importacaoAdicao.setSequencial(999);
        importacaoAdicao.setNumeroAtoConcessorioDrawback("99999999999");
        importacaoAdicao.toString();
    }

    @Test
    public void naoDevePermitirSequencialNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao importacaoAdicao = new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao();
            importacaoAdicao.setCodigoFabricante("sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki");
            importacaoAdicao.setDesconto(new BigDecimal("999999999999.99"));
            importacaoAdicao.setNumero(999);
            importacaoAdicao.setNumeroAtoConcessorioDrawback("99999999999");
            importacaoAdicao.toString();
        });
    }

    @Test
    public void devePermitirItemPedidoCompraNulo() {
        final NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao importacaoAdicao = new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao();
        importacaoAdicao.setCodigoFabricante("sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki");
        importacaoAdicao.setDesconto(new BigDecimal("999999999999.99"));
        importacaoAdicao.setNumero(999);
        importacaoAdicao.setSequencial(999);
        importacaoAdicao.setNumeroAtoConcessorioDrawback("99999999999");
        importacaoAdicao.toString();
    }

    @Test
    public void devePermitirNumeroPedidoCompraNulo() {
        final NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao importacaoAdicao = new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao();
        importacaoAdicao.setCodigoFabricante("sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki");
        importacaoAdicao.setDesconto(new BigDecimal("999999999999.99"));
        importacaoAdicao.setNumero(999);
        importacaoAdicao.setSequencial(999);
        importacaoAdicao.setNumeroAtoConcessorioDrawback("99999999999");
        importacaoAdicao.toString();
    }

    @Test
    public void deveObterCodigoFabricanteComoFoiSetado() {
        final NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao importacaoAdicao = new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao();
        final String codigoFabricante = "sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki";
        importacaoAdicao.setCodigoFabricante(codigoFabricante);
        Assertions.assertEquals(codigoFabricante, importacaoAdicao.getCodigoFabricante());
    }

    @Test
    public void deveObterDescontoComoFoiSetado() {
        final NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao importacaoAdicao = new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao();
        importacaoAdicao.setDesconto(new BigDecimal("999999999999.99"));
        Assertions.assertEquals("999999999999.99", importacaoAdicao.getDesconto());
    }

    @Test
    public void deveObterNumeroComoFoiSetado() {
        final NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao importacaoAdicao = new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao();
        final Integer numero = 999;
        importacaoAdicao.setNumero(numero);
        Assertions.assertEquals(numero, importacaoAdicao.getNumero());
    }

    @Test
    public void deveObterNumeroAtoConcessorioDrawbackComoFoiSetado() {
        final NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao importacaoAdicao = new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao();
        final String numeroAtoConcessorioDrawback = "99999999999";
        importacaoAdicao.setNumeroAtoConcessorioDrawback(numeroAtoConcessorioDrawback);
        Assertions.assertEquals(numeroAtoConcessorioDrawback, importacaoAdicao.getNumeroAtoConcessorioDrawback());
    }

    @Test
    public void deveObterSequencialComoFoiSetado() {
        final NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao importacaoAdicao = new NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao();
        final Integer sequencial = 999;
        importacaoAdicao.setSequencial(sequencial);
        Assertions.assertEquals(sequencial, importacaoAdicao.getSequencial());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao><nAdicao>999</nAdicao><nSeqAdic>999</nSeqAdic><cFabricante>sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki</cFabricante><vDescDI>999999999999.99</vDescDI><nDraw>99999999999</nDraw></NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacaoAdicao().toString());
    }
}
