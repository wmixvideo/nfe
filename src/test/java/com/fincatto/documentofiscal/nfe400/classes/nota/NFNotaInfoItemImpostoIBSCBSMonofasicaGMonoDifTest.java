package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

/**
 * @author Ommega Data
 */
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDifTest {

    @Test
    public void naoDevePermitirPDifIBSComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif().setPDifIBS(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirVIBSMonoDifComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif().setVIBSMonoDif(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirPDifCBSComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif().setPDifCBS(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirVCBSMonoDifComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif().setVCBSMonoDif(new BigDecimal("10000000000000")));
    }

    @Test
    public void deveSetarPDifIBSCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif monoDif = new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif();
        monoDif.setPDifIBS(new BigDecimal("9.8765"));
        Assertions.assertEquals("9.8765", monoDif.getPDifIBS());
    }

    @Test
    public void deveSetarVIBSMonoDifCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif monoDif = new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif();
        monoDif.setVIBSMonoDif(new BigDecimal("12345678901.23"));
        Assertions.assertEquals("12345678901.23", monoDif.getVIBSMonoDif());
    }

    @Test
    public void deveSetarPDifCBSCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif monoDif = new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif();
        monoDif.setPDifCBS(new BigDecimal("5.4321"));
        Assertions.assertEquals("5.4321", monoDif.getPDifCBS());
    }

    @Test
    public void deveSetarVCBSMonoDifCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif monoDif = new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif();
        monoDif.setVCBSMonoDif(new BigDecimal("98765432109.87"));
        Assertions.assertEquals("98765432109.87", monoDif.getVCBSMonoDif());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif><pDifIBS>9.8765</pDifIBS><vIBSMonoDif>12345678901.23</vIBSMonoDif><pDifCBS>5.4321</pDifCBS><vCBSMonoDif>98765432109.87</vCBSMonoDif></NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif().toString());
    }
}