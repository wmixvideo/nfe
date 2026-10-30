package com.fincatto.documentofiscal.nfe400.danfe;

import com.fincatto.documentofiscal.nfe400.classes.nota.NFNota;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoInformacoesAdicionais;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoSuplementar;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

/**
 * Testes dos dados adicionais e do QR Code do DANFE.
 *
 * @author Marcos Lombardi de Andrade
 */
class DanfeRodapeTest {

    private static final class Resultado {
        private String texto;
        private int paginas;
    }

    private static Resultado desenhar(final NFNota nota, final float espacoDisponivel) throws Exception {
        try (final PDDocument documento = new PDDocument(); final ByteArrayOutputStream saida = new ByteArrayOutputStream()) {
            final DanfeCanvas canvas = new DanfeCanvas(documento);
            if (espacoDisponivel > 0) {
                canvas.avancar(canvas.restante() - espacoDisponivel);
            }
            DanfeRodape.desenhar(canvas, nota);
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

    private static NFNota nota(final String complementares, final String fisco) {
        final NFNota nota = DanfeFixtures.notaProcessada().getNota();
        final NFNotaInfoInformacoesAdicionais adicionais = new NFNotaInfoInformacoesAdicionais();
        adicionais.setInformacoesComplementaresInteresseContribuinte(complementares);
        adicionais.setInformacoesAdicionaisInteresseFisco(fisco);
        nota.getInfo().setInformacoesAdicionais(adicionais);
        nota.setInfoSuplementar(null);
        return nota;
    }

    @Test
    void deveDesenharInformacoesComplementaresEReservadoAoFisco() throws Exception {
        final String texto = desenhar(nota("Documento emitido para teste ABC", "Texto do fisco XYZ"), 0).texto;
        Assertions.assertTrue(texto.contains("DADOS ADICIONAIS"));
        Assertions.assertTrue(texto.contains("INFORMA\u00c7\u00d5ES COMPLEMENTARES"));
        Assertions.assertTrue(texto.contains("Documento emitido para teste ABC"));
        Assertions.assertTrue(texto.contains("RESERVADO AO FISCO"));
        Assertions.assertTrue(texto.contains("Texto do fisco XYZ"));
    }

    @Test
    void deveContinuarEmNovaPaginaSemPerderTexto() throws Exception {
        final StringBuilder palavras = new StringBuilder();
        for (int i = 1; i <= 450; i++) {
            palavras.append(String.format("palavra%03d ", i));
        }
        final Resultado resultado = desenhar(nota(palavras.toString().trim(), null), 100f);
        Assertions.assertTrue(resultado.paginas > 1);
        Assertions.assertTrue(resultado.texto.contains("CONTINUA\u00c7\u00c3O"));
        for (final String marca : new String[]{"palavra001", "palavra225", "palavra450"}) {
            Assertions.assertTrue(resultado.texto.contains(marca), marca);
            Assertions.assertEquals(resultado.texto.indexOf(marca), resultado.texto.lastIndexOf(marca), marca + " duplicada");
        }
    }

    @Test
    void deveDesenharQrCodeSomenteQuandoExisteNoXml() throws Exception {
        final NFNota sem = nota("a", "b");
        Assertions.assertFalse(desenhar(sem, 0).texto.contains("QR CODE"));

        final NFNota com = nota("a", "b");
        final NFNotaInfoSuplementar suplementar = new NFNotaInfoSuplementar();
        suplementar.setQrCode("https://www.nfe.fazenda.gov.br/portal/consulta?chNFe=35170399999999999999550010000000011000000015");
        suplementar.setUrlConsultaChaveAcesso("https://www.nfe.fazenda.gov.br/portal/consultaRecaptcha.aspx");
        com.setInfoSuplementar(suplementar);
        Assertions.assertTrue(desenhar(com, 0).texto.contains("QR CODE"));
    }

    @Test
    void naoDeveFalharSemInformacoesAdicionais() throws Exception {
        final NFNota nota = nota("a", "b");
        nota.getInfo().setInformacoesAdicionais(null);
        Assertions.assertTrue(desenhar(nota, 0).texto.contains("DADOS ADICIONAIS"));
    }
}
