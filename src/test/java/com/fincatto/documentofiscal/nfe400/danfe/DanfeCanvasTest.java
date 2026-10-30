package com.fincatto.documentofiscal.nfe400.danfe;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.function.Consumer;

/**
 * Testes das primitivas de desenho do DANFE.
 *
 * @author Marcos Lombardi de Andrade
 */
class DanfeCanvasTest {

    private static byte[] pdf(final Consumer<DanfeCanvas> desenho) throws Exception {
        try (final PDDocument documento = new PDDocument(); final ByteArrayOutputStream saida = new ByteArrayOutputStream()) {
            final DanfeCanvas canvas = new DanfeCanvas(documento);
            desenho.accept(canvas);
            canvas.fechar();
            documento.save(saida);
            return saida.toByteArray();
        }
    }

    private static String texto(final byte[] pdf, final int pagina) throws Exception {
        try (final PDDocument documento = Loader.loadPDF(pdf)) {
            final PDFTextStripper stripper = new PDFTextStripper();
            stripper.setStartPage(pagina);
            stripper.setEndPage(pagina);
            return stripper.getText(documento);
        }
    }

    private static int tamanhoDoConteudo(final byte[] pdf) throws Exception {
        try (final PDDocument documento = Loader.loadPDF(pdf)) {
            try (java.io.InputStream conteudo = documento.getPage(0).getContents()) {
                final ByteArrayOutputStream saida = new ByteArrayOutputStream();
                final byte[] buffer = new byte[4096];
                int lidos;
                while ((lidos = conteudo.read(buffer)) != -1) {
                    saida.write(buffer, 0, lidos);
                }
                return saida.size();
            }
        }
    }

    private static byte[] png() throws Exception {
        final ByteArrayOutputStream saida = new ByteArrayOutputStream();
        ImageIO.write(new BufferedImage(2, 2, BufferedImage.TYPE_INT_RGB), "png", saida);
        return saida.toByteArray();
    }

    @Test
    void deveQuebrarTextoSemEspacosSemPerderCaracteres() throws Exception {
        try (final PDDocument documento = new PDDocument()) {
            final DanfeCanvas canvas = new DanfeCanvas(documento);
            final String longo = String.join("", java.util.Collections.nCopies(5000, "A"));
            final List<String> linhas = canvas.quebrar(longo, 100f, 8f);
            Assertions.assertTrue(linhas.size() > 100);
            Assertions.assertEquals(longo, String.join("", linhas));
            for (final String linha : linhas) {
                Assertions.assertTrue(canvas.largura(linha, 8f) <= 100f, "linha maior que a largura");
            }
        }
    }

    @Test
    void deveQuebrarTextoPorPalavrasERespeitarQuebraDeLinha() throws Exception {
        try (final PDDocument documento = new PDDocument()) {
            final DanfeCanvas canvas = new DanfeCanvas(documento);
            Assertions.assertEquals(java.util.Arrays.asList("um", "dois"), canvas.quebrar("um\ndois", 200f, 8f));
            final List<String> linhas = canvas.quebrar("palavra1 palavra2 palavra3 palavra4", 60f, 8f);
            Assertions.assertTrue(linhas.size() > 1);
            Assertions.assertEquals("palavra1 palavra2 palavra3 palavra4", String.join(" ", linhas));
            Assertions.assertEquals(java.util.Collections.singletonList(""), canvas.quebrar(null, 60f, 8f));
        }
    }

    @Test
    void deveReduzirAFonteECortarLinhasParaCaberNoQuadro() throws Exception {
        try (final PDDocument documento = new PDDocument()) {
            final DanfeCanvas canvas = new DanfeCanvas(documento);
            final DanfeCanvas.TextoAjustado curto = canvas.ajustarAoQuadro("linha1\nlinha2", 150f, 70f, 7f, 5.5f);
            Assertions.assertEquals(7f, curto.tamanho, 0.001f);
            Assertions.assertEquals(java.util.Arrays.asList("linha1", "linha2"), curto.linhas);

            final String longo = String.join("\n", java.util.Collections.nCopies(30, "palavra palavra palavra palavra palavra"));
            final DanfeCanvas.TextoAjustado ajustado = canvas.ajustarAoQuadro(longo, 150f, 70f, 7f, 5.5f);
            Assertions.assertEquals(5.5f, ajustado.tamanho, 0.001f);
            Assertions.assertTrue(ajustado.linhas.size() * canvas.alturaLinha(5.5f) <= 70f);
            Assertions.assertFalse(ajustado.linhas.isEmpty());
        }
    }

    @Test
    void textoDeveDevolverAlturaDeTodasAsLinhasEAparecerNoPdf() throws Exception {
        final float[] altura = new float[1];
        final byte[] pdf = pdf(canvas -> altura[0] = canvas.texto(0, 60f, "palavra1 palavra2 palavra3", 8f));
        Assertions.assertTrue(altura[0] > 2 * 8f);
        Assertions.assertTrue(texto(pdf, 1).contains("palavra3"));
    }

    @Test
    void caixaNaoDeveLancarExcecaoComCaracteresInvalidosEQuebrasDeLinha() throws Exception {
        final byte[] pdf = pdf(canvas -> canvas.caixa(0, 200f, 24f, "R\u00d3TULO", "\u0141\u00f3d\u017a \uD83D\uDE00\nlinha2\t", DanfeCanvas.Alinhamento.ESQUERDA));
        final String texto = texto(pdf, 1);
        Assertions.assertTrue(texto.contains("R\u00d3TULO"));
        Assertions.assertTrue(texto.contains("?"));
    }

    @Test
    void deveEmbutirALiberationSansRegularENegritoNoPdf() throws Exception {
        final byte[] pdf = pdf(canvas -> {
            canvas.titulo("TITULO");
            canvas.caixa(0, 100f, 24f, "ROTULO", "valor", DanfeCanvas.Alinhamento.ESQUERDA);
        });
        try (final PDDocument documento = Loader.loadPDF(pdf)) {
            final java.util.List<String> nomes = new java.util.ArrayList<>();
            for (final org.apache.pdfbox.cos.COSName nome : documento.getPage(0).getResources().getFontNames()) {
                final org.apache.pdfbox.pdmodel.font.PDFont fonte = documento.getPage(0).getResources().getFont(nome);
                Assertions.assertTrue(fonte.isEmbedded(), "fonte nao embutida: " + fonte.getName());
                nomes.add(fonte.getName());
            }
            Assertions.assertTrue(nomes.stream().anyMatch(n -> n.contains("LiberationSans") && n.contains("Bold")), nomes.toString());
            Assertions.assertTrue(nomes.stream().anyMatch(n -> n.contains("LiberationSans") && !n.contains("Bold")), nomes.toString());
        }
    }

    @Test
    void devePreservarCaracteresForaDoLatin1ESubstituirOQueAFonteNaoTem() throws Exception {
        final byte[] pdf = pdf(canvas -> {
            canvas.caixa(0, 200f, 24f, "R", "\u0141\u00f3d\u017a", DanfeCanvas.Alinhamento.ESQUERDA);
            canvas.avancar(24f);
            canvas.caixa(0, 200f, 24f, "R", "A\uD83D\uDE00B", DanfeCanvas.Alinhamento.ESQUERDA);
        });
        final String texto = texto(pdf, 1);
        Assertions.assertTrue(texto.contains("\u0141\u00f3d\u017a"), texto);
        Assertions.assertTrue(texto.contains("A?B"), texto);
    }

    @Test
    void caixaDeveCortarValorMaisLargoQueACaixa() throws Exception {
        final String longo = String.join("", java.util.Collections.nCopies(500, "W"));
        final byte[] pdf = pdf(canvas -> canvas.caixa(0, 80f, 24f, "R", longo, DanfeCanvas.Alinhamento.DIREITA));
        final String texto = texto(pdf, 1).replace("\n", "");
        Assertions.assertTrue(texto.length() < 100, "valor deveria ter sido cortado, mas tem " + texto.length());
    }

    @Test
    void caixaDeveCortarRotuloMaisLargoQueACaixa() throws Exception {
        final String rotulo = "R\u00d3TULO MUITO LONGO PARA UMA CAIXA ESTREITA";
        final byte[] pdf = pdf(canvas -> canvas.caixa(0, 40f, 24f, rotulo, "", DanfeCanvas.Alinhamento.ESQUERDA));
        final String texto = texto(pdf, 1).trim();
        Assertions.assertFalse(texto.isEmpty());
        Assertions.assertTrue(texto.length() < rotulo.length() / 2, "r\u00f3tulo deveria ter sido cortado: " + texto);
    }

    @Test
    void novaPaginaDeveAumentarONumeroDePaginas() throws Exception {
        final int[] paginas = new int[2];
        final byte[] pdf = pdf(canvas -> {
            paginas[0] = canvas.paginas();
            canvas.novaPagina();
            paginas[1] = canvas.paginas();
        });
        Assertions.assertEquals(1, paginas[0]);
        Assertions.assertEquals(2, paginas[1]);
        try (final PDDocument documento = Loader.loadPDF(pdf)) {
            Assertions.assertEquals(2, documento.getNumberOfPages());
        }
    }

    @Test
    void avancarDeveConsumirEspacoRestanteDaPagina() throws Exception {
        try (final PDDocument documento = new PDDocument()) {
            final DanfeCanvas canvas = new DanfeCanvas(documento);
            final float antes = canvas.restante();
            canvas.avancar(100f);
            Assertions.assertEquals(antes - 100f, canvas.restante(), 0.01f);
            canvas.novaPagina();
            Assertions.assertEquals(antes, canvas.restante(), 0.01f);
        }
    }

    @Test
    void tituloDeveAparecerNoPdf() throws Exception {
        final byte[] pdf = pdf(canvas -> canvas.titulo("DESTINAT\u00c1RIO / REMETENTE"));
        Assertions.assertTrue(texto(pdf, 1).contains("DESTINAT\u00c1RIO / REMETENTE"));
    }

    @Test
    void garantirDeveAbrirNovaPaginaSomenteQuandoFaltaEspaco() throws Exception {
        try (final PDDocument documento = new PDDocument()) {
            final DanfeCanvas canvas = new DanfeCanvas(documento);
            canvas.garantir(20f);
            Assertions.assertEquals(1, canvas.paginas());
            canvas.avancar(canvas.restante() - 10f);
            canvas.garantir(20f);
            Assertions.assertEquals(2, canvas.paginas());
        }
    }

    @Test
    void marcaDaguaDeveAparecerEmTodasAsPaginas() throws Exception {
        final byte[] pdf = pdf(canvas -> {
            canvas.marcaDagua("SEM VALOR FISCAL");
            canvas.novaPagina();
        });
        Assertions.assertTrue(texto(pdf, 1).replaceAll("\\s", "").contains("SEMVALORFISCAL"));
        Assertions.assertTrue(texto(pdf, 2).replaceAll("\\s", "").contains("SEMVALORFISCAL"));
    }

    @Test
    void imagemValidaDeveSerDesenhadaEInvalidaOuNulaIgnorada() throws Exception {
        final byte[] imagem = png();
        final byte[] comImagem = pdf(canvas -> canvas.imagem(0, 50f, 50f, imagem));
        final byte[] invalida = pdf(canvas -> canvas.imagem(0, 50f, 50f, new byte[]{1, 2, 3}));
        final byte[] nula = pdf(canvas -> canvas.imagem(0, 50f, 50f, null));
        try (final PDDocument documento = Loader.loadPDF(comImagem)) {
            Assertions.assertTrue(documento.getPage(0).getResources().getXObjectNames().iterator().hasNext());
        }
        for (final byte[] semImagem : new byte[][]{invalida, nula}) {
            try (final PDDocument documento = Loader.loadPDF(semImagem)) {
                final PDPage pagina = documento.getPage(0);
                Assertions.assertFalse(pagina.getResources().getXObjectNames().iterator().hasNext());
            }
        }
    }

    @Test
    void codigoDeBarrasEQrCodeDevemDesenharConteudo() throws Exception {
        final int vazio = tamanhoDoConteudo(pdf(canvas -> {
        }));
        final int barras = tamanhoDoConteudo(pdf(canvas -> canvas.codigoBarras128(0, 250f, 30f, "35170399999999999999550010000000011000000015")));
        final int qr = tamanhoDoConteudo(pdf(canvas -> canvas.qrCode(0, 80f, "https://www.nfe.fazenda.gov.br/portal")));
        Assertions.assertTrue(barras > vazio + 200);
        Assertions.assertTrue(qr > vazio + 200);
    }
}
