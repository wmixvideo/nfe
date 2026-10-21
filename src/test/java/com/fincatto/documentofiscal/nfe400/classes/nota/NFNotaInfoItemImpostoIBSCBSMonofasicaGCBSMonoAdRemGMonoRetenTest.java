package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

/**
 * @author Ommega Data
 */
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoRetenTest {

    @Test
    public void naoDevePermitirQBCMonoRetenComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoReten().setQBCMonoReten(new BigDecimal("100000000000"));
        });
    }

    @Test
    public void naoDevePermitirAdRemCBSRetenComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoReten().setAdRemCBSReten(new BigDecimal("1000"));
        });
    }

    @Test
    public void naoDevePermitirVCBSMonoRetenComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoReten().setVCBSMonoReten(new BigDecimal("10000000000000"));
        });
    }

    @Test
    public void deveSetarQBCMonoRetenCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoReten gMonoReten = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoReten();
        gMonoReten.setQBCMonoReten(new BigDecimal("1234567.8901"));
        Assertions.assertEquals("1234567.8901", gMonoReten.getQBCMonoReten());
    }

    @Test
    public void deveSetarAdRemCBSRetenCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoReten gMonoReten = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoReten();
        gMonoReten.setAdRemCBSReten(new BigDecimal("5.4321"));
        Assertions.assertEquals("5.4321", gMonoReten.getAdRemCBSReten());
    }

    @Test
    public void deveSetarVCBSMonoRetenCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoReten gMonoReten = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoReten();
        gMonoReten.setVCBSMonoReten(new BigDecimal("98765432109.87"));
        Assertions.assertEquals("98765432109.87", gMonoReten.getVCBSMonoReten());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoReten><qBCMonoReten>1234567.8901</qBCMonoReten><adRemCBSReten>5.4321</adRemCBSReten><vCBSMonoReten>98765432109.87</vCBSMonoReten></NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoReten>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoReten().toString());
    }
}
