package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

/**
 * @author Ommega Data
 */
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoRetenTest {

    @Test
    public void naoDevePermitirVBCMonoRetenComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoReten().setVBCMonoReten(new BigDecimal("10000000000000"));
        });
    }

    @Test
    public void naoDevePermitirPAliqMonoRetenComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoReten().setPAliqMonoReten(new BigDecimal("1000"));
        });
    }

    @Test
    public void naoDevePermitirVCBSMonoRetenComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoReten().setVCBSMonoReten(new BigDecimal("10000000000000"));
        });
    }

    @Test
    public void deveSetarVBCMonoRetenCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoReten gMonoReten = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoReten();
        gMonoReten.setVBCMonoReten(new BigDecimal("98765432109.87"));
        Assertions.assertEquals("98765432109.87", gMonoReten.getVBCMonoReten());
    }

    @Test
    public void deveSetarPAliqMonoRetenCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoReten gMonoReten = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoReten();
        gMonoReten.setPAliqMonoReten(new BigDecimal("5.4321"));
        Assertions.assertEquals("5.4321", gMonoReten.getPAliqMonoReten());
    }

    @Test
    public void deveSetarVCBSMonoRetenCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoReten gMonoReten = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoReten();
        gMonoReten.setVCBSMonoReten(new BigDecimal("98765432109.87"));
        Assertions.assertEquals("98765432109.87", gMonoReten.getVCBSMonoReten());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoReten><vBCMonoReten>98765432109.87</vBCMonoReten><pAliqMonoReten>5.4321</pAliqMonoReten><vCBSMonoReten>98765432109.87</vCBSMonoReten></NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoReten>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoReten().toString());
    }
}
