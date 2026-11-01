package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * Grupo legado gMonoRet (UB94), mantido para compatibilidade com o leiaute anterior a NT 2025.002 RTC 1.5.
 * @author Marcos Della Justina Schulz
 */
@SuppressWarnings("removal")
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRetTest {

    @Test
    public void naoDevePermitirQBCMonoRetComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet().setqBCMonoRet(new BigDecimal("100000000000")));
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet().setqBCMonoRet(new BigDecimal("1.12345")));
    }

    @Test
    public void naoDevePermitirAdRemIBSRetComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet().setAdRemIBSRet(new BigDecimal("1000")));
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet().setAdRemIBSRet(new BigDecimal("1.12345")));
    }

    @Test
    public void naoDevePermitirVIBSMonoRetComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet().setVIBSMonoRet(new BigDecimal("10000000000000")));
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet().setVIBSMonoRet(new BigDecimal("1.123")));
    }

    @Test
    public void naoDevePermitirAdRemCBSRetComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet().setAdRemCBSRet(new BigDecimal("1000")));
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet().setAdRemCBSRet(new BigDecimal("1.12345")));
    }

    @Test
    public void naoDevePermitirVCBSMonoRetComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet().setVCBSMonoRet(new BigDecimal("10000000000000")));
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet().setVCBSMonoRet(new BigDecimal("1.123")));
    }

    @Test
    public void naoDeveGerarCamposNulos() {
        Assertions.assertEquals("<NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet/>", new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet().toString());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet><qBCMonoRet>12345678901.2345</qBCMonoRet><adRemIBSRet>123.4567</adRemIBSRet><vIBSMonoRet>1234567890123.45</vIBSMonoRet><adRemCBSRet>98.76</adRemCBSRet><vCBSMonoRet>9876543210.98</vCBSMonoRet></NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet>";
        Assertions.assertEquals(xmlEsperado, getGMonoRet().toString());
    }

    static NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet getGMonoRet() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet gMonoRet = new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet();
        gMonoRet.setqBCMonoRet(new BigDecimal("12345678901.2345"));
        gMonoRet.setAdRemIBSRet(new BigDecimal("123.4567"));
        gMonoRet.setVIBSMonoRet(new BigDecimal("1234567890123.45"));
        gMonoRet.setAdRemCBSRet(new BigDecimal("98.76"));
        gMonoRet.setVCBSMonoRet(new BigDecimal("9876543210.98"));
        return gMonoRet;
    }
}
