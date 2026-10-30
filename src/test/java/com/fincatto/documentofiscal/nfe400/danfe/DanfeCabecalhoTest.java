package com.fincatto.documentofiscal.nfe400.danfe;

import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaProcessada;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

/**
 * Testes do cabecalho do DANFE (canhoto, emitente, chave e regime).
 *
 * @author Marcos Lombardi de Andrade
 */
class DanfeCabecalhoTest {

    private final NFGeraDanfe gerador = new NFGeraDanfe();

    private static String texto(final byte[] pdf) throws Exception {
        try (final PDDocument documento = Loader.loadPDF(pdf)) {
            return new PDFTextStripper().getText(documento);
        }
    }

    private static boolean temImagem(final byte[] pdf) throws Exception {
        try (final PDDocument documento = Loader.loadPDF(pdf)) {
            return documento.getPage(0).getResources().getXObjectNames().iterator().hasNext();
        }
    }

    private static byte[] png() throws Exception {
        final ByteArrayOutputStream saida = new ByteArrayOutputStream();
        ImageIO.write(new BufferedImage(4, 2, BufferedImage.TYPE_INT_RGB), "png", saida);
        return saida.toByteArray();
    }

    @Test
    void deveDesenharCanhotoEmitenteChaveENaturezaDaOperacao() throws Exception {
        final NFNotaProcessada nota = DanfeFixtures.notaProcessada();
        final String texto = texto(gerador.gerar(nota.toString(), null)).replaceAll("\\s+", " ");
        Assertions.assertTrue(texto.contains("RECEBEMOS DE"));
        Assertions.assertTrue(texto.contains("DATA DE RECEBIMENTO"));
        Assertions.assertTrue(texto.contains("DANFE"));
        Assertions.assertTrue(texto.contains("DOCUMENTO AUXILIAR DA NOTA FISCAL ELETR\u00d4NICA"));
        Assertions.assertTrue(texto.contains(DanfeFormatador.chaveAcesso(nota.getNota().getInfo().getChaveAcesso())));
        Assertions.assertTrue(texto.contains("NATUREZA DA OPERA\u00c7\u00c3O"));
        Assertions.assertTrue(texto.contains(nota.getNota().getInfo().getEmitente().getRazaoSocial().substring(0, 20)));
        Assertions.assertTrue(texto.contains("N\u00ba 999.999.999"));
        Assertions.assertTrue(texto.contains("S\u00c9RIE 999"));
        try (final PDDocument documento = Loader.loadPDF(gerador.gerar(nota.toString(), null))) {
            Assertions.assertTrue(texto.contains("FOLHA 1/" + documento.getNumberOfPages()), "total de folhas");
        }
        Assertions.assertTrue(texto.contains("PROTOCOLO DE AUTORIZA\u00c7\u00c3O DE USO"));
        Assertions.assertTrue(texto.contains(nota.getProtocolo().getProtocoloInfo().getNumeroProtocolo()));
    }

    @Test
    void deveDesenharCrtETipoDeRegimeDeApuracaoEmBranco() throws Exception {
        final String texto;
        try (final PDDocument documento = new PDDocument(); final ByteArrayOutputStream saida = new ByteArrayOutputStream()) {
            final DanfeCanvas canvas = new DanfeCanvas(documento);
            DanfeCabecalho.desenhar(canvas, DanfeFixtures.notaProcessada(), null, 1);
            canvas.fechar();
            documento.save(saida);
            texto = texto(saida.toByteArray());
        }
        Assertions.assertTrue(texto.contains("C\u00d3DIGO DO REGIME TRIBUT\u00c1RIO"));
        Assertions.assertTrue(texto.contains("3 - REGIME NORMAL"));
        final String rotulo = "TIPO DE REGIME DE APURA\u00c7\u00c3O DO IBS E DA CBS";
        final int posicao = texto.indexOf(rotulo);
        Assertions.assertTrue(posicao >= 0);
        Assertions.assertTrue(texto.substring(posicao + rotulo.length()).trim().isEmpty(), "o quadro deve ficar em branco");
    }

    @Test
    void deveDesenharLogotipoSomenteQuandoValido() throws Exception {
        final String xml = DanfeFixtures.xml();
        final byte[] semLogo = gerador.gerar(xml, null);
        final byte[] logoInvalido = gerador.gerar(xml, new byte[]{1, 2, 3});
        final byte[] comLogo = gerador.gerar(xml, png());
        Assertions.assertTrue(temImagem(comLogo));
        Assertions.assertFalse(temImagem(semLogo));
        Assertions.assertFalse(temImagem(logoInvalido));
        Assertions.assertEquals(texto(semLogo), texto(comLogo));
        Assertions.assertEquals(texto(semLogo), texto(logoInvalido));
    }

    @Test
    void naoDeveFalharSemCamposOpcionaisDoEmitente() throws Exception {
        final String xml = DanfeFixtures.xml()
                .replaceAll("(?s)<xFant>.*?</xFant>", "")
                .replaceAll("(?s)<IEST>.*?</IEST>", "")
                .replaceAll("(?s)<IM>.*?</IM>", "")
                .replaceAll("(?s)<CNAE>.*?</CNAE>", "");
        Assertions.assertFalse(xml.contains("<IEST>"));
        Assertions.assertTrue(texto(gerador.gerar(xml, null)).contains("DANFE"));
    }
}
