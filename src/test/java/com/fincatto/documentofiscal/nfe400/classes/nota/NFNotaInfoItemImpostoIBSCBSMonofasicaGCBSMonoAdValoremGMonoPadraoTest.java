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
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoPadrao().setvBCMono(new BigDecimal("10000000000000"));
        });
    }

    @Test
    public void naoDevePermitirPAliqMonoCBSComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoPadrao().setpAliqMonoCBS(new BigDecimal("1000"));
        });
    }

    @Test
    public void naoDevePermitirVCBSMonoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoPadrao().setvCBSMono(new BigDecimal("10000000000000"));
        });
    }

    @Test
    public void deveSetarVBCMonoCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoPadrao gMonoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoPadrao();
        gMonoPadrao.setvBCMono(new BigDecimal("98765432109.87"));
        Assertions.assertEquals("98765432109.87", gMonoPadrao.getvBCMono());
    }

    @Test
    public void deveSetarPAliqMonoCBSCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoPadrao gMonoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoPadrao();
        gMonoPadrao.setpAliqMonoCBS(new BigDecimal("5.4321"));
        Assertions.assertEquals("5.4321", gMonoPadrao.getpAliqMonoCBS());
    }

    @Test
    public void deveSetarVCBSMonoCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoPadrao gMonoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoPadrao();
        gMonoPadrao.setvCBSMono(new BigDecimal("98765432109.87"));
        Assertions.assertEquals("98765432109.87", gMonoPadrao.getvCBSMono());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoPadrao><vBCMono>98765432109.87</vBCMono><pAliqMonoCBS>5.4321</pAliqMonoCBS><vCBSMono>98765432109.87</vCBSMono></NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoPadrao>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoPadrao().toString());
    }
}
