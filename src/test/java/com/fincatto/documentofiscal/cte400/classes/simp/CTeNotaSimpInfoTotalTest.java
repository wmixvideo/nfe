package com.fincatto.documentofiscal.cte400.classes.simp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CTeNotaSimpInfoTotalTest {

    private static CTeNotaSimpInfoTotal getTotal() {
        final CTeNotaSimpInfoTotal total = new CTeNotaSimpInfoTotal();
        total.setVTPrest(new BigDecimal("100"));
        total.setVTRec(new BigDecimal("100"));
        return total;
    }

    @Test
    public void naoDeveGerarCamposOpcionaisQuandoNulos() {
        Assertions.assertEquals("<total xmlns=\"http://www.portalfiscal.inf.br/cte\"><vTPrest>100.00</vTPrest><vTRec>100.00</vTRec></total>", getTotal().toString());
    }

    @Test
    public void deveGerarXMLComTodosOsCamposNaOrdemDoXSD() {
        final CTeNotaSimpInfoTotal total = getTotal();
        total.setVTPrestLiq(new BigDecimal("90"));
        total.setIbsCbsTot(CTeNotaSimpInfoTotalIBSCBSTest.getIbsCbsTot());
        total.setVTotDFe(new BigDecimal("101"));
        final String xml = total.toString();
        Assertions.assertTrue(xml.startsWith("<total xmlns=\"http://www.portalfiscal.inf.br/cte\"><vTPrest>100.00</vTPrest><vTPrestLiq>90.00</vTPrestLiq><vTRec>100.00</vTRec><IBSCBSTot>"), xml);
        Assertions.assertTrue(xml.endsWith("</IBSCBSTot><vTotDFe>101.00</vTotDFe></total>"), xml);
    }

    @Test
    public void valoresNaoDevemExtrapolarTamanho() {
        final CTeNotaSimpInfoTotal total = new CTeNotaSimpInfoTotal();
        Assertions.assertThrows(NumberFormatException.class, () -> total.setVTPrestLiq(new BigDecimal("12345678901234")));
        Assertions.assertThrows(NumberFormatException.class, () -> total.setVTPrestLiq(new BigDecimal("1.123")));
        Assertions.assertThrows(NumberFormatException.class, () -> total.setVTotDFe(new BigDecimal("12345678901234")));
        Assertions.assertThrows(NumberFormatException.class, () -> total.setVTotDFe(new BigDecimal("1.123")));
    }
}
