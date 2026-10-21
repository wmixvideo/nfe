package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

/**
 * @author Ommega Data
 */
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoPadraoTest {

    @Test
    public void naoDevePermitirQBCMonoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoPadrao().setQBCMono(new BigDecimal("100000000000"));
        });
    }

    @Test
    public void naoDevePermitirAdRemCBSComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoPadrao().setAdRemCBS(new BigDecimal("1000"));
        });
    }

    @Test
    public void naoDevePermitirVCBSMonoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoPadrao().setVCBSMono(new BigDecimal("10000000000000"));
        });
    }

    @Test
    public void deveSetarQBCMonoCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoPadrao gMonoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoPadrao();
        gMonoPadrao.setQBCMono(new BigDecimal("1234567.8901"));
        Assertions.assertEquals("1234567.8901", gMonoPadrao.getQBCMono());
    }

    @Test
    public void deveSetarAdRemCBSCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoPadrao gMonoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoPadrao();
        gMonoPadrao.setAdRemCBS(new BigDecimal("5.4321"));
        Assertions.assertEquals("5.4321", gMonoPadrao.getAdRemCBS());
    }

    @Test
    public void deveSetarVCBSMonoCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoPadrao gMonoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoPadrao();
        gMonoPadrao.setVCBSMono(new BigDecimal("98765432109.87"));
        Assertions.assertEquals("98765432109.87", gMonoPadrao.getVCBSMono());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoPadrao><qBCMono>1234567.8901</qBCMono><adRemCBS>5.4321</adRemCBS><vCBSMono>98765432109.87</vCBSMono></NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoPadrao>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoPadrao().toString());
    }
}
