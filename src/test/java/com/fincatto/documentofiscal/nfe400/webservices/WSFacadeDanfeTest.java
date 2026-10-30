package com.fincatto.documentofiscal.nfe400.webservices;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fincatto.documentofiscal.nfe400.NFeConfigFake;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaProcessada;
import com.fincatto.documentofiscal.nfe400.danfe.DanfeCreditos;
import com.fincatto.documentofiscal.nfe400.danfe.DanfeFixtures;
import com.fincatto.documentofiscal.nfe400.danfe.DanfeNfceFixtures;
import com.fincatto.documentofiscal.nfe400.danfe.NFGeraDanfeNfce;

/**
 * Testes da geracao do DANFE pelo {@link com.fincatto.documentofiscal.nfe400.webservices.WSFacade}.
 *
 * @author Marcos Lombardi de Andrade
 */
class WSFacadeDanfeTest {

    private static boolean ehPdf(final byte[] pdf) {
        return new String(pdf, 0, 4, StandardCharsets.US_ASCII).equals("%PDF");
    }

    @Test
    void deveGerarDanfeSemELogotipo() throws Exception {
        try (final WSFacade facade = new WSFacade(new NFeConfigFake())) {
            final String xml = DanfeFixtures.xml();
            Assertions.assertTrue(ehPdf(facade.geraDanfe(xml)));
            final ByteArrayOutputStream logo = new ByteArrayOutputStream();
            ImageIO.write(new BufferedImage(4, 2, BufferedImage.TYPE_INT_RGB), "png", logo);
            Assertions.assertTrue(ehPdf(facade.geraDanfe(xml, logo.toByteArray())));
        }
    }

    @Test
    void naoDeveGerarDanfeParaXmlSemProtocolo() throws Exception {
        final String xml = DanfeFixtures.xmlSemProtocolo();
        try (final WSFacade facade = new WSFacade(new NFeConfigFake())) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> facade.geraDanfe(xml));
        }
    }

    @Test
    void deveGerarDanfeAPartirDoObjetoNotaProcessada() throws Exception {
        try (final WSFacade facade = new WSFacade(new NFeConfigFake())) {
            Assertions.assertTrue(ehPdf(facade.geraDanfe(DanfeFixtures.notaProcessada())));
            final ByteArrayOutputStream logo = new ByteArrayOutputStream();
            ImageIO.write(new BufferedImage(4, 2, BufferedImage.TYPE_INT_RGB), "png", logo);
            Assertions.assertTrue(ehPdf(facade.geraDanfe(DanfeFixtures.notaProcessada(), logo.toByteArray())));
        }
    }

    @Test
    void naoDeveGerarDanfeParaObjetoSemProtocolo() throws Exception {
        final NFNotaProcessada nota = DanfeFixtures.notaProcessada();
        nota.setProtocolo(null);
        try (final WSFacade facade = new WSFacade(new NFeConfigFake())) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> facade.geraDanfe(nota));
        }
    }

    @Test
    void deveGerarDanfeNfceAPartirDoXmlEDoObjeto() throws Exception {
        try (final WSFacade facade = new WSFacade(new NFeConfigFake())) {
            final String xml = DanfeNfceFixtures.xml();
            Assertions.assertTrue(ehPdf(facade.geraDanfeNfce(xml)));
            final NFNotaProcessada nota = new com.fincatto.documentofiscal.utils.DFPersister().read(NFNotaProcessada.class, xml);
            Assertions.assertTrue(ehPdf(facade.geraDanfeNfce(nota)));
        }
    }

    @Test
    void deveGerarDanfeNfceEm80MmComCreditos() throws Exception {
        try (final WSFacade facade = new WSFacade(new NFeConfigFake())) {
            final byte[] pdf = facade.geraDanfeNfce(DanfeNfceFixtures.xml(), new DanfeCreditos("Desenvolvido por Exemplo", null));
            Assertions.assertTrue(ehPdf(pdf));
            try (final org.apache.pdfbox.pdmodel.PDDocument documento = org.apache.pdfbox.Loader.loadPDF(pdf)) {
                Assertions.assertEquals(NFGeraDanfeNfce.LARGURA_80_MM * 72f / 25.4f, documento.getPage(0).getMediaBox().getWidth(), 0.01f);
                Assertions.assertTrue(new org.apache.pdfbox.text.PDFTextStripper().getText(documento).contains("Desenvolvido por Exemplo"));
            }
        }
    }

    @Test
    void naoDeveGerarDanfeNfceParaXmlSemProtocolo() throws Exception {
        final String xml = DanfeNfceFixtures.nfce().semProtocolo().build();
        try (final WSFacade facade = new WSFacade(new NFeConfigFake())) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> facade.geraDanfeNfce(xml));
        }
    }
}
