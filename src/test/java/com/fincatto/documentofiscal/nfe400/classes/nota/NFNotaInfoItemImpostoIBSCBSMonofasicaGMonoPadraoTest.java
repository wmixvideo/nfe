package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @author Ommega Data
 */
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadraoTest {

    @Test
    public void naoDevePermitirQBCMonoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao().setQBCMono(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirAdRemIBSComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao().setAdRemIBS(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirAdRemCBSComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao().setAdRemCBS(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirVIBSMonoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao().setVIBSMono(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirVCBSMonoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao().setVCBSMono(new BigDecimal("10000000000000")));
    }

     @Test
    public void deveSetarQBCMonoCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao monoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao();
        monoPadrao.setQBCMono(new BigDecimal("1234567.8901"));
        Assertions.assertEquals("1234567.8901", monoPadrao.getQBCMono());
    }

    @Test
    public void deveSetarAdRemIBSCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao monoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao();
        monoPadrao.setAdRemIBS(new BigDecimal("9.8765"));
        Assertions.assertEquals("9.8765", monoPadrao.getAdRemIBS());
    }

    @Test
    public void deveSetarAdRemCBSCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao monoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao();
        monoPadrao.setAdRemCBS(new BigDecimal("5.4321"));
        Assertions.assertEquals("5.4321", monoPadrao.getAdRemCBS());
    }

    @Test
    public void deveSetarVIBSMonoCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao monoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao();
        monoPadrao.setVIBSMono(new BigDecimal("12345678901.23"));
        Assertions.assertEquals("12345678901.23", monoPadrao.getVIBSMono());
    }

    @Test
    public void deveSetarVCBSMonoCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao monoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao();
        monoPadrao.setVCBSMono(new BigDecimal("98765432109.87"));
        Assertions.assertEquals("98765432109.87", monoPadrao.getVCBSMono());
    }
    
    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        // XML esperado com base nos valores fake criados e nos nomes dos campos (@Element)
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao><qBCMono>1234567.8901</qBCMono><adRemIBS>9.8765</adRemIBS><adRemCBS>5.4321</adRemCBS><vIBSMono>12345678901.23</vIBSMono><vCBSMono>98765432109.87</vCBSMono></NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao().toString());
    }
}