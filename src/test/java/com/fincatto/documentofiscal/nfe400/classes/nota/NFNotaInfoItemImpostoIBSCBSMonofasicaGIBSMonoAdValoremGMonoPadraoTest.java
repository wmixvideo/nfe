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
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao().setvBCMono(new BigDecimal("10000000000000"));
        });
    }

    @Test
    public void naoDevePermitirPAliqMonoUFComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao().setpAliqMonoUF(new BigDecimal("1000"));
        });
    }

    @Test
    public void naoDevePermitirVIBSMonoUfComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao().setvIBSMonoUF(new BigDecimal("10000000000000"));
        });
    }

    @Test
    public void naoDevePermitirPAliqMonoMunComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao().setpAliqMonoMun(new BigDecimal("1000"));
        });
    }

    @Test
    public void naoDevePermitirVIBSMonoMunComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao().setvIBSMonoMun(new BigDecimal("10000000000000"));
        });
    }

    @Test
    public void naoDevePermitirVIBSMonoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao().setvIBSMono(new BigDecimal("10000000000000"));
        });
    }

    @Test
    public void deveSetarVBCMonoCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao gMonoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao();
        gMonoPadrao.setvBCMono(new BigDecimal("12345678901.23"));
        Assertions.assertEquals("12345678901.23", gMonoPadrao.getvBCMono());
    }

    @Test
    public void deveSetarPAliqMonoUFCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao gMonoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao();
        gMonoPadrao.setpAliqMonoUF(new BigDecimal("9.8765"));
        Assertions.assertEquals("9.8765", gMonoPadrao.getpAliqMonoUF());
    }

    @Test
    public void deveSetarVIBSMonoUfCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao gMonoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao();
        gMonoPadrao.setvIBSMonoUF(new BigDecimal("12345678901.23"));
        Assertions.assertEquals("12345678901.23", gMonoPadrao.getvIBSMonoUF());
    }

    @Test
    public void deveSetarPAliqMonoMunCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao gMonoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao();
        gMonoPadrao.setpAliqMonoMun(new BigDecimal("5.4321"));
        Assertions.assertEquals("5.4321", gMonoPadrao.getpAliqMonoMun());
    }

    @Test
    public void deveSetarVIBSMonoMunCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao gMonoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao();
        gMonoPadrao.setvIBSMonoMun(new BigDecimal("98765432109.87"));
        Assertions.assertEquals("98765432109.87", gMonoPadrao.getvIBSMonoMun());
    }

    @Test
    public void deveSetarVIBSMonoCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao gMonoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao();
        gMonoPadrao.setvIBSMono(new BigDecimal("12345678901.23"));
        Assertions.assertEquals("12345678901.23", gMonoPadrao.getvIBSMono());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao><vBCMono>12345678901.23</vBCMono><pAliqMonoUF>9.8765</pAliqMonoUF><vIBSMonoUF>12345678901.23</vIBSMonoUF><pAliqMonoMun>5.4321</pAliqMonoMun><vIBSMonoMun>98765432109.87</vIBSMonoMun><vIBSMono>12345678901.23</vIBSMono></NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao().toString());
    }
}
