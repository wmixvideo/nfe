package com.fincatto.documentofiscal.nfe400.danfe;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItem;

/**
 * Testes da tabela de itens do DANFE.
 *
 * @author Marcos Lombardi de Andrade
 */
class DanfeItensTest {

    private static final class Resultado {
        private String texto;
        private int paginas;
    }

    private static Resultado desenhar(final List<NFNotaInfoItem> itens) throws Exception {
        try (final PDDocument documento = new PDDocument(); final ByteArrayOutputStream saida = new ByteArrayOutputStream()) {
            final DanfeCanvas canvas = new DanfeCanvas(documento);
            DanfeItens.desenhar(canvas, itens);
            final Resultado resultado = new Resultado();
            resultado.paginas = canvas.paginas();
            canvas.fechar();
            documento.save(saida);
            try (final PDDocument lido = Loader.loadPDF(saida.toByteArray())) {
                resultado.texto = new PDFTextStripper().getText(lido).replaceAll("\\s+", " ");
            }
            return resultado;
        }
    }

    private static String valor(final String xml) {
        return DanfeFormatador.valor(xml);
    }

    @Test
    void deveDesenharDescricaoClassificacaoEValoresDeIbsCbsIs() throws Exception {
        final NFNotaInfoItem item = DanfeFixtures.itemComIbsCbs(false);
        final String texto = desenhar(Collections.singletonList(item)).texto;
        Assertions.assertTrue(texto.contains("DADOS DOS PRODUTOS / SERVI\u00c7OS"));
        for (final String coluna : new String[]{"DESCRI\u00c7\u00c3O DO PRODUTO / SERVI\u00c7O", "BASES DE C\u00c1LCULO", "AL\u00cdQUOTAS", "VALOR DOS TRIBUTOS"}) {
            Assertions.assertTrue(texto.contains(coluna), coluna);
        }
        Assertions.assertTrue(texto.contains(item.getProduto().getDescricao().substring(0, 15)));
        Assertions.assertTrue(texto.contains("[NCM " + item.getProduto().getNcm() + "]"));
        Assertions.assertTrue(texto.contains("[cClassTrib 123456]"));
        Assertions.assertTrue(texto.contains(valor("77.77")), "vIBSUF");
        Assertions.assertTrue(texto.contains(valor("66.66")), "vIBSMun");
        Assertions.assertTrue(texto.contains(valor("55.55")), "vCBS");
        Assertions.assertTrue(texto.contains(valor("88.88")), "vIS");
        Assertions.assertTrue(texto.contains(valor("1000.00")), "vBC IBS/CBS");
        Assertions.assertTrue(texto.contains(valor("900.00")), "vBCIS");
        Assertions.assertTrue(texto.contains(valor("9.9999") + "%"), "pIS");
    }

    @Test
    void deveImprimirAliquotaNominalQuandoNaoHaGRed() throws Exception {
        final String texto = desenhar(Collections.singletonList(DanfeFixtures.itemComIbsCbs(false))).texto;
        for (final String nominal : new String[]{"7.7777", "6.6666", "5.5555"}) {
            Assertions.assertTrue(texto.contains(valor(nominal) + "%"), nominal);
        }
        for (final String efetiva : new String[]{"3.3333", "2.2222", "4.4444"}) {
            Assertions.assertFalse(texto.contains(valor(efetiva) + "%"), efetiva);
        }
    }

    @Test
    void deveImprimirAliquotaEfetivaQuandoHaGRed() throws Exception {
        final String texto = desenhar(Collections.singletonList(DanfeFixtures.itemComIbsCbs(true))).texto;
        for (final String efetiva : new String[]{"3.3333", "2.2222", "4.4444"}) {
            Assertions.assertTrue(texto.contains(valor(efetiva) + "%"), efetiva);
        }
        for (final String nominal : new String[]{"7.7777", "6.6666", "5.5555"}) {
            Assertions.assertFalse(texto.contains(valor(nominal) + "%"), nominal);
        }
    }

    @Test
    void naoDeveFalharParaItemSemGruposIbsCbsEIs() throws Exception {
        final NFNotaInfoItem item = FabricaDeObjetosFake.getNFNotaInfoItem();
        final String texto = desenhar(Collections.singletonList(item)).texto;
        Assertions.assertTrue(texto.contains(item.getProduto().getDescricao().substring(0, 15)));
        Assertions.assertFalse(texto.contains("cClassTrib"));
    }

    @Test
    void naoDeveEstourarComDescricaoEInformacoesAdicionaisNoTamanhoMaximo() throws Exception {
        final NFNotaInfoItem item = DanfeFixtures.itemComIbsCbs(true);
        item.getProduto().setDescricao(String.join("", Collections.nCopies(120, "W")));
        item.setInformacoesAdicionais(String.join("", Collections.nCopies(500, "Z")));
        final Resultado resultado = desenhar(Collections.singletonList(item));
        Assertions.assertTrue(resultado.texto.contains("WWWWWWWWWW"));
        Assertions.assertTrue(resultado.texto.contains("ZZZZZZZZZZ"));
    }

    @Test
    void deveRepetirOCabecalhoEPaginarSemPerderItens() throws Exception {
        final List<NFNotaInfoItem> itens = new ArrayList<>();
        for (int i = 1; i <= 300; i++) {
            final NFNotaInfoItem item = FabricaDeObjetosFake.getNFNotaInfoItem();
            item.getProduto().setDescricao(String.format("PRODUTO%05d", i));
            itens.add(item);
        }
        final Resultado resultado = desenhar(itens);
        Assertions.assertTrue(resultado.paginas > 1);
        for (final int numero : new int[]{1, 150, 300}) {
            final String marca = String.format("PRODUTO%05d", numero);
            Assertions.assertEquals(1, ocorrencias(resultado.texto, marca), marca);
        }
        Assertions.assertEquals(resultado.paginas, ocorrencias(resultado.texto, "DESCRI\u00c7\u00c3O DO PRODUTO / SERVI\u00c7O"));
    }

    private static int ocorrencias(final String texto, final String trecho) {
        int total = 0;
        for (int i = texto.indexOf(trecho); i >= 0; i = texto.indexOf(trecho, i + trecho.length())) {
            total++;
        }
        return total;
    }

    @Test
    void naoDeveFalharComListaDeItensNulaOuVazia() throws Exception {
        Assertions.assertTrue(desenhar(Collections.emptyList()).texto.contains("DADOS DOS PRODUTOS / SERVI\u00c7OS"));
        Assertions.assertTrue(desenhar(null).texto.contains("DADOS DOS PRODUTOS / SERVI\u00c7OS"));
    }

    private static NFNotaInfoItem itemSimples() {
        final NFNotaInfoItem item = FabricaDeObjetosFake.getNFNotaInfoItem();
        item.setInformacoesAdicionais(null);
        item.getProduto().setDescricao("Produto simples");
        item.getProduto().setNcm("04061010");
        item.getProduto().setCfop("5102");
        item.getProduto().setQuantidadeComercial(new java.math.BigDecimal("2"));
        item.getProduto().setValorUnitario(new java.math.BigDecimal("50"));
        return item;
    }

    @Test
    void deveCompletarDuasCasasNaQuantidadeENoValorUnitario() throws Exception {
        final String texto = desenhar(Collections.singletonList(itemSimples())).texto;
        Assertions.assertTrue(texto.contains("2,00 [") , "quantidade");
        Assertions.assertTrue(texto.contains("50,00"), "valor unit\u00e1rio");
    }

    @Test
    void naoDeveQuebrarCstECfopNaColunaEstreita() throws Exception {
        try (final PDDocument documento = new PDDocument()) {
            final DanfeCanvas canvas = new DanfeCanvas(documento);
            DanfeItens.desenhar(canvas, Collections.singletonList(itemSimples()));
            final float antes = canvas.y();
            DanfeItens.desenhar(canvas, Collections.singletonList(itemSimples()));
            final float alturaDaLinha = antes - canvas.y() - DanfeCanvas.ALTURA_TITULO - 14f;
            // descricao + NCM + 2 linhas de CST/CFOP cabem em 2 linhas de texto
            Assertions.assertEquals(2 * canvas.alturaLinha(6f) + 4f, alturaDaLinha, 0.01f);
        }
    }
}
