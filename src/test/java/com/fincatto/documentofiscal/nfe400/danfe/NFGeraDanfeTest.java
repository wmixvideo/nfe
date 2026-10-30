package com.fincatto.documentofiscal.nfe400.danfe;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItem;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaProcessada;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Testes de {@link com.fincatto.documentofiscal.nfe400.danfe.NFGeraDanfe}: entrada, protocolo, logotipo e marca d'agua.
 *
 * @author Marcos Lombardi de Andrade
 */
class NFGeraDanfeTest {

    private final NFGeraDanfe gerador = new NFGeraDanfe();

    @Test
    void deveLancarExcecaoParaXmlNuloOuVazio() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> gerador.gerar((String) null, null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> gerador.gerar("", null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> gerador.gerar("   ", null));
    }

    @Test
    void deveLancarExcecaoParaXmlMalformado() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> gerador.gerar("<nfeProc", null));
    }

    @Test
    void deveLancarExcecaoParaNotaSemProtocolo() {
        final String xml = DanfeFixtures.xmlSemProtocolo();
        Assertions.assertFalse(xml.contains("protNFe"));
        final IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> gerador.gerar(xml, null));
        Assertions.assertTrue(e.getMessage().contains("protocolo"));
    }

    @Test
    void deveGerarPdfValidoParaNotaProcessada() throws Exception {
        final byte[] pdf = gerador.gerar(DanfeFixtures.xml(), null);
        Assertions.assertEquals("%PDF", new String(pdf, 0, 4, StandardCharsets.US_ASCII));
        try (final PDDocument documento = Loader.loadPDF(pdf)) {
            Assertions.assertTrue(documento.getNumberOfPages() >= 1);
        }
    }

    @Test
    void deveIgnorarLogotipoNuloOuInvalido() throws Exception {
        final String xml = DanfeFixtures.xml();
        for (final byte[] logo : new byte[][]{null, new byte[]{1, 2, 3}}) {
            try (final PDDocument documento = Loader.loadPDF(gerador.gerar(xml, logo))) {
                Assertions.assertTrue(documento.getNumberOfPages() >= 1);
            }
        }
    }

    private static String xmlComItens(final int quantidade, final DFAmbiente ambiente) {
        final NFNotaProcessada nota = DanfeFixtures.notaProcessada();
        nota.getNota().getInfo().getIdentificacao().setAmbiente(ambiente);
        final List<NFNotaInfoItem> itens = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            itens.add(FabricaDeObjetosFake.getNFNotaInfoItem());
        }
        nota.getNota().getInfo().setItens(itens);
        return nota.toString();
    }

    /**
     * Fluxos de conteudo da pagina: a marca d'agua e acrescentada como um fluxo a parte. O texto nao pode ser procurado no
     * conteudo (a fonte embutida guarda indices de glifos) nem extraido (o texto girado se mistura com o das demais linhas).
     */
    private static int fluxosDeConteudo(final byte[] pdf, final int pagina) throws Exception {
        try (final PDDocument documento = Loader.loadPDF(pdf)) {
            int total = 0;
            for (final java.util.Iterator<org.apache.pdfbox.pdmodel.common.PDStream> it = documento.getPage(pagina - 1).getContentStreams(); it.hasNext(); it.next()) {
                total++;
            }
            return total;
        }
    }

    @Test
    void deveAplicarMarcaDaguaEmTodasAsPaginasEmHomologacao() throws Exception {
        final byte[] pdf = gerador.gerar(xmlComItens(8, DFAmbiente.HOMOLOGACAO), null);
        try (final PDDocument documento = Loader.loadPDF(pdf)) {
            Assertions.assertTrue(documento.getNumberOfPages() > 1);
            for (int pagina = 1; pagina <= documento.getNumberOfPages(); pagina++) {
                Assertions.assertTrue(fluxosDeConteudo(pdf, pagina) > 1, "p\u00e1gina " + pagina);
            }
        }
    }

    @Test
    void naoDeveAplicarMarcaDaguaEmProducao() throws Exception {
        final byte[] pdf = gerador.gerar(xmlComItens(8, DFAmbiente.PRODUCAO), null);
        try (final PDDocument documento = Loader.loadPDF(pdf)) {
            for (int pagina = 1; pagina <= documento.getNumberOfPages(); pagina++) {
                Assertions.assertEquals(1, fluxosDeConteudo(pdf, pagina), "p\u00e1gina " + pagina);
            }
        }
    }

    @Test
    void deveGerarPdfValidoAPartirDoObjetoNotaProcessada() throws Exception {
        final byte[] pdf = gerador.gerar(DanfeFixtures.notaProcessada(), null);
        Assertions.assertEquals("%PDF", new String(pdf, 0, 4, StandardCharsets.US_ASCII));
        try (final PDDocument documento = Loader.loadPDF(pdf)) {
            Assertions.assertTrue(documento.getNumberOfPages() >= 1);
        }
    }

    @Test
    void deveGerarOMesmoDocumentoPeloObjetoEPelaString() throws Exception {
        final NFNotaProcessada nota = DanfeFixtures.notaProcessada();
        try (final PDDocument peloObjeto = Loader.loadPDF(gerador.gerar(nota, null));
             final PDDocument peloXml = Loader.loadPDF(gerador.gerar(nota.toString(), null))) {
            Assertions.assertEquals(peloXml.getNumberOfPages(), peloObjeto.getNumberOfPages());
            Assertions.assertEquals(new PDFTextStripper().getText(peloXml), new PDFTextStripper().getText(peloObjeto));
        }
    }

    @Test
    void deveIgnorarLogotipoInvalidoAoGerarPeloObjeto() throws Exception {
        try (final PDDocument documento = Loader.loadPDF(gerador.gerar(DanfeFixtures.notaProcessada(), new byte[]{1, 2, 3}))) {
            Assertions.assertTrue(documento.getNumberOfPages() >= 1);
        }
    }

    @Test
    void deveLancarExcecaoParaObjetoNuloOuIncompleto() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> gerador.gerar((NFNotaProcessada) null, null));

        final NFNotaProcessada semProtocolo = DanfeFixtures.notaProcessada();
        semProtocolo.setProtocolo(null);
        final IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> gerador.gerar(semProtocolo, null));
        Assertions.assertTrue(e.getMessage().contains("protocolo"));

        final NFNotaProcessada semNota = DanfeFixtures.notaProcessada();
        semNota.setNota(null);
        Assertions.assertThrows(IllegalArgumentException.class, () -> gerador.gerar(semNota, null));
    }

    private static String textoDaPagina(final PDDocument documento, final int pagina) throws Exception {
        final PDFTextStripper leitor = new PDFTextStripper();
        leitor.setStartPage(pagina);
        leitor.setEndPage(pagina);
        return leitor.getText(documento);
    }

    @Test
    void deveImprimirRodapePersonalizadoEmTodasAsPaginas() throws Exception {
        final DanfeCreditos rodape = new DanfeCreditos("Desenvolvido por Fulano - (11) 99999-0000", "www.exemplo.com.br");
        final byte[] pdf = gerador.gerar(xmlComItens(8, DFAmbiente.PRODUCAO), null, rodape);
        try (final PDDocument documento = Loader.loadPDF(pdf)) {
            Assertions.assertTrue(documento.getNumberOfPages() > 1);
            for (int pagina = 1; pagina <= documento.getNumberOfPages(); pagina++) {
                final String texto = textoDaPagina(documento, pagina);
                Assertions.assertTrue(texto.contains("Desenvolvido por Fulano - (11) 99999-0000"), "p\u00e1gina " + pagina);
                Assertions.assertTrue(texto.contains("www.exemplo.com.br"), "p\u00e1gina " + pagina);
            }
        }
    }

    @Test
    void naoDeveImprimirRodapeQuandoNaoInformado() throws Exception {
        final String xml = DanfeFixtures.xml();
        try (final PDDocument esperado = Loader.loadPDF(gerador.gerar(xml, null));
             final PDDocument obtido = Loader.loadPDF(gerador.gerar(xml, null, null))) {
            Assertions.assertEquals(esperado.getNumberOfPages(), obtido.getNumberOfPages());
            Assertions.assertEquals(textoDaPagina(esperado, 1), textoDaPagina(obtido, 1));
        }
        try (final PDDocument esperado = Loader.loadPDF(gerador.gerar(xml, null));
             final PDDocument obtido = Loader.loadPDF(gerador.gerar(xml, null, new DanfeCreditos(null, null)))) {
            Assertions.assertEquals(textoDaPagina(esperado, 1), textoDaPagina(obtido, 1));
        }
    }

    @Test
    void deveCortarTextoDeRodapeMuitoLongoSemInvadirOutroLado() throws Exception {
        final String longo = String.join(" ", java.util.Collections.nCopies(60, "palavra"));
        final byte[] pdf = gerador.gerar(DanfeFixtures.xml(), null, new DanfeCreditos(longo, "www.exemplo.com.br"));
        try (final PDDocument documento = Loader.loadPDF(pdf)) {
            final String texto = textoDaPagina(documento, 1);
            Assertions.assertTrue(texto.contains("www.exemplo.com.br"));
            Assertions.assertFalse(texto.contains(longo));
        }
    }
}
