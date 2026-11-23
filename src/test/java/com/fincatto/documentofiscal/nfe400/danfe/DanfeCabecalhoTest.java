package com.fincatto.documentofiscal.nfe400.danfe;

import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaProcessada;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

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
            // o total de folhas do "FOLHA n/N" tambem e um XObject, mas nao e imagem
            final org.apache.pdfbox.pdmodel.PDResources recursos = documento.getPage(0).getResources();
            for (final org.apache.pdfbox.cos.COSName nome : recursos.getXObjectNames()) {
                if (recursos.isImageXObject(nome)) {
                    return true;
                }
            }
            return false;
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
        Assertions.assertTrue(texto.contains("PROTOCOLO DE AUTORIZA\u00c7\u00c3O DE USO"));
        Assertions.assertTrue(texto.contains(nota.getProtocolo().getProtocoloInfo().getNumeroProtocolo()));
    }

    @Test
    void deveDesenharCrtETipoDeRegimeDeApuracaoEmBranco() throws Exception {
        final String texto;
        try (final PDDocument documento = new PDDocument(); final ByteArrayOutputStream saida = new ByteArrayOutputStream()) {
            final DanfeCanvas canvas = new DanfeCanvas(documento);
            DanfeCabecalho.desenhar(canvas, DanfeFixtures.notaProcessada(), null);
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
        // com logotipo o texto do emitente fica mais estreito e pode quebrar em outros pontos
        Assertions.assertTrue(texto(comLogo).replaceAll("\\s+", " ").contains(DanfeFixtures.notaProcessada().getNota().getInfo().getEmitente().getRazaoSocial().substring(0, 20)));
        Assertions.assertEquals(texto(semLogo), texto(logoInvalido));
    }

    @Test
    void deveCentralizarOEmitenteNoQuadroSemLogotipo() throws Exception {
        final byte[] pdf = gerador.gerar(notaComEmitenteCurto(), null);
        Assertions.assertFalse(temImagem(pdf));
        final float centroDoQuadro = DanfeCanvas.MARGEM + DanfeCabecalho.LARGURA_EMITENTE / 2;
        final TextPosition[] razaoSocial = letras(pdf, "Empresa Exemplo Ltda");
        Assertions.assertEquals(centroDoQuadro, centro(razaoSocial), 0.5f, "razão social centralizada");
        Assertions.assertTrue(razaoSocial[0].getFont().getName().contains("Bold"), "razão social em negrito");
        Assertions.assertEquals(centroDoQuadro, centro(letras(pdf, "Fone: (48) 3035-9700")), 0.5f, "telefone centralizado");
    }

    @Test
    void deveAlinharOEmitenteAEsquerdaDepoisDoLogotipo() throws Exception {
        final byte[] pdf = gerador.gerar(notaComEmitenteCurto(), png());
        Assertions.assertTrue(temImagem(pdf));
        final float depoisDoLogotipo = DanfeCanvas.MARGEM + DanfeCabecalho.LARGURA_LOGO + 4;
        final TextPosition[] razaoSocial = letras(pdf, "Empresa Exemplo Ltda");
        Assertions.assertEquals(depoisDoLogotipo, razaoSocial[0].getXDirAdj(), 0.5f, "razão social depois do logotipo");
        Assertions.assertTrue(razaoSocial[0].getFont().getName().contains("Bold"), "razão social em negrito");
        Assertions.assertEquals(depoisDoLogotipo, letras(pdf, "Fone: (48) 3035-9700")[0].getXDirAdj(), 0.5f, "telefone depois do logotipo");
    }

    @Test
    void deveImprimirOComplementoDoEnderecoDoEmitente() throws Exception {
        final NFNotaProcessada nota = notaComEmitenteCurto();
        final String semComplemento = texto(gerador.gerar(nota, null)).replaceAll("\\s+", " ");
        Assertions.assertTrue(semComplemento.contains("Rua Exemplo, 100 – Centro"), semComplemento);
        nota.getNota().getInfo().getEmitente().getEndereco().setComplemento("Sala 101");
        final String comComplemento = texto(gerador.gerar(nota, null)).replaceAll("\\s+", " ");
        Assertions.assertTrue(comComplemento.contains("Rua Exemplo, 100, Sala 101 – Centro"), comComplemento);
    }

    /**
     * Nota com razao social e endereco curtos, que cabem no quadro do emitente com ou sem logotipo.
     */
    private static NFNotaProcessada notaComEmitenteCurto() {
        final NFNotaProcessada nota = DanfeFixtures.notaProcessada();
        nota.getNota().getInfo().getEmitente().setRazaoSocial("Empresa Exemplo Ltda");
        nota.getNota().getInfo().getEmitente().getEndereco().setLogradouro("Rua Exemplo");
        nota.getNota().getInfo().getEmitente().getEndereco().setNumero("100");
        nota.getNota().getInfo().getEmitente().getEndereco().setComplemento(null);
        nota.getNota().getInfo().getEmitente().getEndereco().setBairro("Centro");
        nota.getNota().getInfo().getEmitente().getEndereco().setDescricaoMunicipio("Florianopolis");
        nota.getNota().getInfo().getEmitente().getEndereco().setTelefone("4830359700");
        return nota;
    }

    /**
     * @return primeira e ultima letra do texto procurado na primeira pagina, na ordem em que foram desenhadas
     */
    private static TextPosition[] letras(final byte[] pdf, final String procurado) throws Exception {
        final List<TextPosition> letras = new ArrayList<>();
        final PDFTextStripper leitor = new PDFTextStripper() {
            @Override
            protected void processTextPosition(final TextPosition letra) {
                letras.add(letra);
            }
        };
        leitor.setEndPage(1);
        try (final PDDocument documento = Loader.loadPDF(pdf)) {
            leitor.getText(documento);
        }
        final StringBuilder texto = new StringBuilder();
        letras.forEach(letra -> texto.append(letra.getUnicode()));
        final int inicio = texto.indexOf(procurado);
        Assertions.assertTrue(inicio >= 0, procurado);
        return new TextPosition[]{letras.get(inicio), letras.get(inicio + procurado.length() - 1)};
    }

    /**
     * @return centro horizontal do texto, entre o inicio da primeira letra e o fim da ultima
     */
    private static float centro(final TextPosition[] letras) {
        return (letras[0].getXDirAdj() + letras[1].getXDirAdj() + letras[1].getWidthDirAdj()) / 2;
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
