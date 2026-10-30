package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.nfe400.NFeConfigFake;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaProcessada;
import com.fincatto.documentofiscal.nfe400.danfe.DanfeFixtures;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

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
        try (final WSFacade facade = new WSFacade(new NFeConfigFake())) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> facade.geraDanfe(DanfeFixtures.xmlSemProtocolo()));
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
}
