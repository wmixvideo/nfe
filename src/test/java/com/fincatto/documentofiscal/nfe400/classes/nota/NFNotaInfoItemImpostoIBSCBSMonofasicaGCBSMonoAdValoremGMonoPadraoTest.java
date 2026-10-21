package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

/**
 * @author Ommega Data
 */
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoPadraoTest {

    @Test
    public void naoDevePermitirVBCMonoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoPadrao().setVBCMono(new BigDecimal("10000000000000"));
        });
    }

    @Test
    public void naoDevePermitirPAliqMonoCBSComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoPadrao().setPAliqMonoCBS(new BigDecimal("1000"));
        });
    }

    @Test
    public void naoDevePermitirVCBSMonoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoPadrao().setVCBSMono(new BigDecimal("10000000000000"));
        });
    }

    @Test
    public void deveSetarVBCMonoCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoPadrao gMonoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoPadrao();
        gMonoPadrao.setVBCMono(new BigDecimal("98765432109.87"));
        Assertions.assertEquals("98765432109.87", gMonoPadrao.getVBCMono());
    }

    @Test
    public void deveSetarPAliqMonoCBSCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoPadrao gMonoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoPadrao();
        gMonoPadrao.setPAliqMonoCBS(new BigDecimal("5.4321"));
        Assertions.assertEquals("5.4321", gMonoPadrao.getPAliqMonoCBS());
    }

    @Test
    public void deveSetarVCBSMonoCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoPadrao gMonoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoPadrao();
        gMonoPadrao.setVCBSMono(new BigDecimal("98765432109.87"));
        Assertions.assertEquals("98765432109.87", gMonoPadrao.getVCBSMono());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoPadrao><vBCMono>98765432109.87</vBCMono><pAliqMonoCBS>5.4321</pAliqMonoCBS><vCBSMono>98765432109.87</vCBSMono></NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoPadrao>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoPadrao().toString());
    }
}
