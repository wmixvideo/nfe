package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

/**
 * @author Ommega Data
 */
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadraoTest {

    @Test
    public void naoDevePermitirVBCMonoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao().setVBCMono(new BigDecimal("10000000000000"));
        });
    }

    @Test
    public void naoDevePermitirPAliqMonoUFComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao().setPAliqMonoUF(new BigDecimal("1000"));
        });
    }

    @Test
    public void naoDevePermitirVIBSMonoUfComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao().setVIBSMonoUF(new BigDecimal("10000000000000"));
        });
    }

    @Test
    public void naoDevePermitirPAliqMonoMunComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao().setPAliqMonoMun(new BigDecimal("1000"));
        });
    }

    @Test
    public void naoDevePermitirVIBSMonoMunComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao().setVIBSMonoMun(new BigDecimal("10000000000000"));
        });
    }

    @Test
    public void naoDevePermitirVIBSMonoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao().setVIBSMono(new BigDecimal("10000000000000"));
        });
    }

    @Test
    public void deveSetarVBCMonoCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao gMonoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao();
        gMonoPadrao.setVBCMono(new BigDecimal("12345678901.23"));
        Assertions.assertEquals("12345678901.23", gMonoPadrao.getVBCMono());
    }

    @Test
    public void deveSetarPAliqMonoUFCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao gMonoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao();
        gMonoPadrao.setPAliqMonoUF(new BigDecimal("9.8765"));
        Assertions.assertEquals("9.8765", gMonoPadrao.getPAliqMonoUF());
    }

    @Test
    public void deveSetarVIBSMonoUfCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao gMonoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao();
        gMonoPadrao.setVIBSMonoUF(new BigDecimal("12345678901.23"));
        Assertions.assertEquals("12345678901.23", gMonoPadrao.getVIBSMonoUF());
    }

    @Test
    public void deveSetarPAliqMonoMunCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao gMonoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao();
        gMonoPadrao.setPAliqMonoMun(new BigDecimal("5.4321"));
        Assertions.assertEquals("5.4321", gMonoPadrao.getPAliqMonoMun());
    }

    @Test
    public void deveSetarVIBSMonoMunCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao gMonoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao();
        gMonoPadrao.setVIBSMonoMun(new BigDecimal("98765432109.87"));
        Assertions.assertEquals("98765432109.87", gMonoPadrao.getVIBSMonoMun());
    }

    @Test
    public void deveSetarVIBSMonoCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao gMonoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao();
        gMonoPadrao.setVIBSMono(new BigDecimal("12345678901.23"));
        Assertions.assertEquals("12345678901.23", gMonoPadrao.getVIBSMono());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao><vBCMono>12345678901.23</vBCMono><pAliqMonoUF>9.8765</pAliqMonoUF><vIBSMonoUF>12345678901.23</vIBSMonoUF><pAliqMonoMun>5.4321</pAliqMonoMun><vIBSMonoMun>98765432109.87</vIBSMonoMun><vIBSMono>12345678901.23</vIBSMono></NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao().toString());
    }
}
