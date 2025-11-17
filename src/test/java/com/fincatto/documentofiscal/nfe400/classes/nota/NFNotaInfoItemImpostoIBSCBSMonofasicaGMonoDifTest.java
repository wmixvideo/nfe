package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;

/**
 * @author Ommega Data
 */
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDifTest {

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPDifIBSComTamanhoInvalido() {
        new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif().setPDifIBS(new BigDecimal("1000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirVIBSMonoDifComTamanhoInvalido() {
        new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif().setVIBSMonoDif(new BigDecimal("10000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPDifCBSComTamanhoInvalido() {
        new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif().setPDifCBS(new BigDecimal("1000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirVCBSMonoDifComTamanhoInvalido() {
        new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif().setVCBSMonoDif(new BigDecimal("10000000000000"));
    }

    @Test
    public void deveSetarPDifIBSCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif monoDif = new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif();
        monoDif.setPDifIBS(new BigDecimal("9.8765"));
        Assert.assertEquals("9.8765", monoDif.getPDifIBS());
    }

    @Test
    public void deveSetarVIBSMonoDifCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif monoDif = new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif();
        monoDif.setVIBSMonoDif(new BigDecimal("12345678901.23"));
        Assert.assertEquals("12345678901.23", monoDif.getVIBSMonoDif());
    }

    @Test
    public void deveSetarPDifCBSCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif monoDif = new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif();
        monoDif.setPDifCBS(new BigDecimal("5.4321"));
        Assert.assertEquals("5.4321", monoDif.getPDifCBS());
    }

    @Test
    public void deveSetarVCBSMonoDifCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif monoDif = new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif();
        monoDif.setVCBSMonoDif(new BigDecimal("98765432109.87"));
        Assert.assertEquals("98765432109.87", monoDif.getVCBSMonoDif());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif><pDifIBS>9.8765</pDifIBS><vIBSMonoDif>12345678901.23</vIBSMonoDif><pDifCBS>5.4321</pDifCBS><vCBSMonoDif>98765432109.87</vCBSMonoDif></NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif().toString());
    }
}