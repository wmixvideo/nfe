package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * Grupo legado gMonoReten (UB90), mantido para compatibilidade com o leiaute anterior a NT 2025.002 RTC 1.5.
 * @author Marcos Della Justina Schulz
 */
@SuppressWarnings("removal")
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRetenTest {

    @Test
    public void naoDevePermitirQBCMonoRetenComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten().setqBCMonoReten(new BigDecimal("100000000000")));
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten().setqBCMonoReten(new BigDecimal("1.12345")));
    }

    @Test
    public void naoDevePermitirAdRemIBSRetenComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten().setAdRemIBSReten(new BigDecimal("1000")));
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten().setAdRemIBSReten(new BigDecimal("1.12345")));
    }

    @Test
    public void naoDevePermitirVIBSMonoRetenComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten().setVIBSMonoReten(new BigDecimal("10000000000000")));
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten().setVIBSMonoReten(new BigDecimal("1.123")));
    }

    @Test
    public void naoDevePermitirAdRemCBSRetenComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten().setAdRemCBSReten(new BigDecimal("1000")));
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten().setAdRemCBSReten(new BigDecimal("1.12345")));
    }

    @Test
    public void naoDevePermitirVCBSMonoRetenComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten().setVCBSMonoReten(new BigDecimal("10000000000000")));
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten().setVCBSMonoReten(new BigDecimal("1.123")));
    }

    @Test
    public void naoDeveGerarCamposNulos() {
        Assertions.assertEquals("<NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten/>", new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten().toString());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten><qBCMonoReten>12345678901.2345</qBCMonoReten><adRemIBSReten>123.4567</adRemIBSReten><vIBSMonoReten>1234567890123.45</vIBSMonoReten><adRemCBSReten>98.76</adRemCBSReten><vCBSMonoReten>9876543210.98</vCBSMonoReten></NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten>";
        Assertions.assertEquals(xmlEsperado, getGMonoReten().toString());
    }

    static NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten getGMonoReten() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten gMonoReten = new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten();
        gMonoReten.setqBCMonoReten(new BigDecimal("12345678901.2345"));
        gMonoReten.setAdRemIBSReten(new BigDecimal("123.4567"));
        gMonoReten.setVIBSMonoReten(new BigDecimal("1234567890123.45"));
        gMonoReten.setAdRemCBSReten(new BigDecimal("98.76"));
        gMonoReten.setVCBSMonoReten(new BigDecimal("9876543210.98"));
        return gMonoReten;
    }
}
