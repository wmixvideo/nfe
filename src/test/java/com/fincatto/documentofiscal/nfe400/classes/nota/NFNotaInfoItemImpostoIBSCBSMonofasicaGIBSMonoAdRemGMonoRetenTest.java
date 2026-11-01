package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

/**
 * @author Ommega Data
 */
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoRetenTest {

    @Test
    public void naoDevePermitirQBCMonoRetenComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoReten().setQBCMonoReten(new BigDecimal("100000000000"));
        });
    }

    @Test
    public void naoDevePermitirAdRemIBSRetenComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoReten().setAdRemIBSReten(new BigDecimal("1000"));
        });
    }

    @Test
    public void naoDevePermitirVIBSMonoRetenComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoReten().setVIBSMonoReten(new BigDecimal("10000000000000"));
        });
    }

    @Test
    public void deveSetarQBCMonoRetenCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoReten gMonoReten = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoReten();
        gMonoReten.setQBCMonoReten(new BigDecimal("1234567.8901"));
        Assertions.assertEquals("1234567.8901", gMonoReten.getQBCMonoReten());
    }

    @Test
    public void deveSetarAdRemIBSRetenCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoReten gMonoReten = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoReten();
        gMonoReten.setAdRemIBSReten(new BigDecimal("9.8765"));
        Assertions.assertEquals("9.8765", gMonoReten.getAdRemIBSReten());
    }

    @Test
    public void deveSetarVIBSMonoRetenCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoReten gMonoReten = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoReten();
        gMonoReten.setVIBSMonoReten(new BigDecimal("12345678901.23"));
        Assertions.assertEquals("12345678901.23", gMonoReten.getVIBSMonoReten());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoReten><qBCMonoReten>1234567.8901</qBCMonoReten><adRemIBSReten>9.8765</adRemIBSReten><vIBSMonoReten>12345678901.23</vIBSMonoReten></NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoReten>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoReten().toString());
    }
}
