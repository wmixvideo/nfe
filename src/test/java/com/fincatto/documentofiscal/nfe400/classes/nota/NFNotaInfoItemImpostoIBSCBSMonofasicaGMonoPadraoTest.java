package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * Grupo legado gMonoPadrao (UB84a), mantido para compatibilidade com o leiaute anterior a NT 2025.002 RTC 1.5.
 * @author Marcos Della Justina Schulz
 */
@SuppressWarnings("removal")
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadraoTest {

    @Test
    public void naoDevePermitirQBCMonoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao().setQBCMono(new BigDecimal("100000000000")));
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao().setQBCMono(new BigDecimal("1.12345")));
    }

    @Test
    public void naoDevePermitirAdRemIBSComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao().setAdRemIBS(new BigDecimal("1000")));
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao().setAdRemIBS(new BigDecimal("1.12345")));
    }

    @Test
    public void naoDevePermitirAdRemCBSComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao().setAdRemCBS(new BigDecimal("1000")));
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao().setAdRemCBS(new BigDecimal("1.12345")));
    }

    @Test
    public void naoDevePermitirVIBSMonoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao().setVIBSMono(new BigDecimal("10000000000000")));
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao().setVIBSMono(new BigDecimal("1.123")));
    }

    @Test
    public void naoDevePermitirVCBSMonoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao().setVCBSMono(new BigDecimal("10000000000000")));
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao().setVCBSMono(new BigDecimal("1.123")));
    }

    @Test
    public void naoDeveGerarCamposNulos() {
        Assertions.assertEquals("<NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao/>", new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao().toString());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao><qBCMono>12345678901.2345</qBCMono><adRemIBS>123.4567</adRemIBS><adRemCBS>98.76</adRemCBS><vIBSMono>1234567890123.45</vIBSMono><vCBSMono>9876543210.98</vCBSMono></NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao>";
        Assertions.assertEquals(xmlEsperado, getGMonoPadrao().toString());
    }

    static NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao getGMonoPadrao() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao gMonoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao();
        gMonoPadrao.setQBCMono(new BigDecimal("12345678901.2345"));
        gMonoPadrao.setAdRemIBS(new BigDecimal("123.4567"));
        gMonoPadrao.setAdRemCBS(new BigDecimal("98.76"));
        gMonoPadrao.setVIBSMono(new BigDecimal("1234567890123.45"));
        gMonoPadrao.setVCBSMono(new BigDecimal("9876543210.98"));
        return gMonoPadrao;
    }
}
