package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * Grupo legado gMonoDif (UB99), mantido para compatibilidade com o leiaute anterior a NT 2025.002 RTC 1.5.
 * @author Marcos Della Justina Schulz
 */
@SuppressWarnings("removal")
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDifTest {

    @Test
    public void naoDevePermitirPDifIBSComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif().setPDifIBS(new BigDecimal("1000")));
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif().setPDifIBS(new BigDecimal("1.12345")));
    }

    @Test
    public void naoDevePermitirVIBSMonoDifComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif().setVIBSMonoDif(new BigDecimal("10000000000000")));
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif().setVIBSMonoDif(new BigDecimal("1.123")));
    }

    @Test
    public void naoDevePermitirPDifCBSComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif().setPDifCBS(new BigDecimal("1000")));
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif().setPDifCBS(new BigDecimal("1.12345")));
    }

    @Test
    public void naoDevePermitirVCBSMonoDifComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif().setVCBSMonoDif(new BigDecimal("10000000000000")));
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif().setVCBSMonoDif(new BigDecimal("1.123")));
    }

    @Test
    public void naoDeveGerarCamposNulos() {
        Assertions.assertEquals("<NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif/>", new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif().toString());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif><pDifIBS>12.3456</pDifIBS><vIBSMonoDif>1234567890123.45</vIBSMonoDif><pDifCBS>100.00</pDifCBS><vCBSMonoDif>9876543210.98</vCBSMonoDif></NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif>";
        Assertions.assertEquals(xmlEsperado, getGMonoDif().toString());
    }

    static NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif getGMonoDif() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif gMonoDif = new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif();
        gMonoDif.setPDifIBS(new BigDecimal("12.3456"));
        gMonoDif.setVIBSMonoDif(new BigDecimal("1234567890123.45"));
        gMonoDif.setPDifCBS(new BigDecimal("100"));
        gMonoDif.setVCBSMonoDif(new BigDecimal("9876543210.98"));
        return gMonoDif;
    }
}
