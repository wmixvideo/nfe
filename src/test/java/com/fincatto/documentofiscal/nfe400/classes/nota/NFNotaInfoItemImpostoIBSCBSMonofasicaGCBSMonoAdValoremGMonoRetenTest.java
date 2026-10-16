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
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoReten().setvBCMonoReten(new BigDecimal("10000000000000"));
        });
    }

    @Test
    public void naoDevePermitirPAliqMonoRetenComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoReten().setpAliqMonoReten(new BigDecimal("1000"));
        });
    }

    @Test
    public void naoDevePermitirVCBSMonoRetenComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoReten().setvCBSMonoReten(new BigDecimal("10000000000000"));
        });
    }

    @Test
    public void deveSetarVBCMonoRetenCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoReten gMonoReten = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoReten();
        gMonoReten.setvBCMonoReten(new BigDecimal("98765432109.87"));
        Assertions.assertEquals("98765432109.87", gMonoReten.getvBCMonoReten());
    }

    @Test
    public void deveSetarPAliqMonoRetenCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoReten gMonoReten = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoReten();
        gMonoReten.setpAliqMonoReten(new BigDecimal("5.4321"));
        Assertions.assertEquals("5.4321", gMonoReten.getpAliqMonoReten());
    }

    @Test
    public void deveSetarVCBSMonoRetenCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoReten gMonoReten = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoReten();
        gMonoReten.setvCBSMonoReten(new BigDecimal("98765432109.87"));
        Assertions.assertEquals("98765432109.87", gMonoReten.getvCBSMonoReten());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoReten><vBCMonoReten>98765432109.87</vBCMonoReten><pAliqMonoReten>5.4321</pAliqMonoReten><vCBSMonoReten>98765432109.87</vCBSMonoReten></NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoReten>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoReten().toString());
    }
}
