package com.fincatto.documentofiscal.nfe400.danfe;

import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfo;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

/**
 * Testes dos blocos de destinatario, totais, ISSQN e transporte do DANFE.
 *
 * @author Marcos Lombardi de Andrade
 */
class DanfeTotaisTest {

    /** Desenha so os totais e devolve o texto (espacos e quebras normalizados). */
    private static String desenhar(final NFNotaInfo info) throws Exception {
        try (final PDDocument documento = new PDDocument(); final ByteArrayOutputStream saida = new ByteArrayOutputStream()) {
            final DanfeCanvas canvas = new DanfeCanvas(documento);
            DanfeTotais.desenhar(canvas, info);
            canvas.fechar();
            documento.save(saida);
            try (final PDDocument lido = Loader.loadPDF(saida.toByteArray())) {
                return new PDFTextStripper().getText(lido).replaceAll("\\s+", " ");
            }
        }
    }

    @Test
    void deveDesenharBlocoIbsCbsIsDepoisDoIcmsIpiEComValoresDoXml() throws Exception {
        final String texto = desenhar(DanfeFixtures.infoComIbsCbs(false));
        final int icms = texto.indexOf("TOTAL DO ICMS / IPI");
        final int ibs = texto.indexOf("TOTAL DO IBS / CBS / IS");
        Assertions.assertTrue(icms >= 0 && ibs > icms, "bloco IBS/CBS/IS deve vir depois do ICMS/IPI");
        for (final String rotulo : new String[]{"VALOR DA CBS", "VALOR DO IBS UF", "VALOR DO IBS MUNIC\u00cdPIO", "VALOR DO IMPOSTO SELETIVO"}) {
            Assertions.assertTrue(texto.indexOf(rotulo, ibs) > ibs, rotulo);
        }
        final String bloco = texto.substring(ibs);
        Assertions.assertTrue(bloco.contains("444,44"), "vCBS");
        Assertions.assertTrue(bloco.contains("111,11"), "vIBSUF");
        Assertions.assertTrue(bloco.contains("222,22"), "vIBSMun");
        Assertions.assertTrue(bloco.contains("999,99"), "vIS");
    }

    @Test
    void deveDesenharCamposMonofasicosSomenteComGrupoGMono() throws Exception {
        final String sem = desenhar(DanfeFixtures.infoComIbsCbs(false));
        Assertions.assertFalse(sem.contains("IBS MONOF\u00c1SICO"));
        Assertions.assertFalse(sem.contains("CBS MONOF\u00c1SICA"));
        final String com = desenhar(DanfeFixtures.infoComIbsCbs(true));
        Assertions.assertTrue(com.contains("VALOR DO IBS MONOF\u00c1SICO") && com.contains("555,55"));
        Assertions.assertTrue(com.contains("VALOR DA CBS MONOF\u00c1SICA") && com.contains("666,66"));
        Assertions.assertTrue(com.contains("VALOR DO IBS MONOF\u00c1SICO POR RETEN\u00c7\u00c3O") && com.contains("777,77"));
        Assertions.assertTrue(com.contains("VALOR DA CBS MONOF\u00c1SICA POR RETEN\u00c7\u00c3O") && com.contains("888,88"));
    }

    @Test
    void deveManterOBlocoIbsCbsIsMesmoSemOsGruposNoXml() throws Exception {
        final String texto = desenhar(DanfeFixtures.notaProcessada().getNota().getInfo());
        Assertions.assertTrue(texto.contains("TOTAL DO IBS / CBS / IS"));
        Assertions.assertFalse(texto.contains("IBS MONOF\u00c1SICO"));
    }

    @Test
    void deveDesenharDestinatarioETotaisDaNota() throws Exception {
        final NFNotaInfo info = DanfeFixtures.notaProcessada().getNota().getInfo();
        final String texto = desenhar(info);
        Assertions.assertTrue(texto.contains("DESTINAT\u00c1RIO / REMETENTE"));
        Assertions.assertTrue(texto.contains("NOME / RAZ\u00c3O SOCIAL"));
        Assertions.assertTrue(texto.contains(info.getDestinatario().getRazaoSocial().substring(0, 15)));
        Assertions.assertTrue(texto.contains("TOTAL DOS PRODUTOS E TOTAL DA NOTA"));
        Assertions.assertTrue(texto.contains("VALOR TOTAL DOS PRODUTOS"));
        Assertions.assertTrue(texto.contains("999.999.999.999,99"));
        Assertions.assertTrue(texto.contains("BASE DE C\u00c1LCULO DO ICMS"));
        Assertions.assertTrue(texto.contains("VALOR DO IPI"));
    }

    @Test
    void deveDesenharQuadrosFacultativosSomenteQuandoExistemNoXml() throws Exception {
        final NFNotaInfo completa = DanfeFixtures.notaProcessada().getNota().getInfo();
        final String com = desenhar(completa);
        Assertions.assertTrue(com.contains("FATURA / DUPLICATAS"));
        Assertions.assertTrue(com.contains("C\u00c1LCULO DO ISSQN"));
        Assertions.assertTrue(com.contains("TRANSPORTADOR / VOLUMES TRANSPORTADOS"));
        Assertions.assertTrue(com.contains("VALOR DO FCP"));

        final NFNotaInfo enxuta = DanfeFixtures.notaProcessada().getNota().getInfo();
        enxuta.setCobranca(null);
        enxuta.getTotal().setIssqnTotal(null);
        enxuta.setTransporte(null);
        enxuta.getTotal().getIcmsTotal().setValorTotalFundoCombatePobreza(null);
        enxuta.getTotal().getIcmsTotal().setValorTotalFundoCombatePobrezaST(null);
        enxuta.getTotal().getIcmsTotal().setValorICMSPartilhaDestinatario(null);
        enxuta.getTotal().getIcmsTotal().setValorICMSFundoCombatePobreza(null);
        final String sem = desenhar(enxuta);
        Assertions.assertFalse(sem.contains("FATURA / DUPLICATAS"));
        Assertions.assertFalse(sem.contains("C\u00c1LCULO DO ISSQN"));
        Assertions.assertFalse(sem.contains("TRANSPORTADOR"));
        Assertions.assertFalse(sem.contains("VALOR DO FCP"));
        Assertions.assertFalse(sem.contains("DIFAL"));
    }

    @Test
    void naoDeveFalharComDestinatarioSomenteComCpfESemDadosOpcionais() throws Exception {
        final NFNotaInfo info = DanfeFixtures.notaProcessada().getNota().getInfo();
        info.getDestinatario().setEndereco(null);
        info.getDestinatario().setInscricaoEstadual(null);
        info.getTransporte().setTransportador(null);
        info.getTransporte().setVeiculo(null);
        info.getTransporte().setVolumes(null);
        Assertions.assertTrue(desenhar(info).contains("DESTINAT\u00c1RIO / REMETENTE"));
    }

    @Test
    void deveContinuarEmNovaPaginaQuandoAFaturaTemMuitasParcelas() throws Exception {
        final NFNotaInfo info = DanfeFixtures.notaProcessada().getNota().getInfo();
        final java.util.List<com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoParcela> parcelas = new java.util.ArrayList<>();
        for (int i = 1; i <= 120; i++) {
            final com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoParcela parcela = new com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoParcela();
            parcela.setNumeroParcela(String.format("%03d", i));
            parcela.setDataVencimento(java.time.LocalDate.of(2026, 12, 1));
            parcela.setValorParcela(new java.math.BigDecimal("10.00"));
            parcelas.add(parcela);
        }
        info.getCobranca().setParcelas(parcelas);
        try (final PDDocument documento = new PDDocument()) {
            final DanfeCanvas canvas = new DanfeCanvas(documento);
            DanfeTotais.desenhar(canvas, info);
            Assertions.assertTrue(canvas.paginas() > 1);
        }
    }
}
