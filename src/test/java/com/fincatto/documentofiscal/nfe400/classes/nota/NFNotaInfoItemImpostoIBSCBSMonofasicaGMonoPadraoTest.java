package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author Ommega Data
 */
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadraoTest {

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirQBCMonoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao().setQBCMono(new BigDecimal("10000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirAdRemIBSComTamanhoInvalido() {
        new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao().setAdRemIBS(new BigDecimal("1000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirAdRemCBSComTamanhoInvalido() {
        new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao().setAdRemCBS(new BigDecimal("1000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirVIBSMonoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao().setVIBSMono(new BigDecimal("10000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirVCBSMonoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao().setVCBSMono(new BigDecimal("10000000000000"));
    }

     @Test
    public void deveSetarQBCMonoCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao monoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao();
        monoPadrao.setQBCMono(new BigDecimal("1234567.8901"));
        Assert.assertEquals("1234567.8901", monoPadrao.getQBCMono());
    }

    @Test
    public void deveSetarAdRemIBSCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao monoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao();
        monoPadrao.setAdRemIBS(new BigDecimal("9.8765"));
        Assert.assertEquals("9.8765", monoPadrao.getAdRemIBS());
    }

    @Test
    public void deveSetarAdRemCBSCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao monoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao();
        monoPadrao.setAdRemCBS(new BigDecimal("5.4321"));
        Assert.assertEquals("5.4321", monoPadrao.getAdRemCBS());
    }

    @Test
    public void deveSetarVIBSMonoCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao monoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao();
        monoPadrao.setVIBSMono(new BigDecimal("12345678901.23"));
        Assert.assertEquals("12345678901.23", monoPadrao.getVIBSMono());
    }

    @Test
    public void deveSetarVCBSMonoCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao monoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao();
        monoPadrao.setVCBSMono(new BigDecimal("98765432109.87"));
        Assert.assertEquals("98765432109.87", monoPadrao.getVCBSMono());
    }
    
    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        // XML esperado com base nos valores fake criados e nos nomes dos campos (@Element)
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao><qBCMono>1234567.8901</qBCMono><adRemIBS>9.8765</adRemIBS><adRemCBS>5.4321</adRemCBS><vIBSMono>12345678901.23</vIBSMono><vCBSMono>98765432109.87</vCBSMono></NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao().toString());
    }
}