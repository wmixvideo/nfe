package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

/**
 * @author Ommega Data
 */
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoRetenTest {

    @Test
    public void naoDevePermitirVBCMonoRetenComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoReten().setvBCMonoReten(new BigDecimal("10000000000000"));
        });
    }

    @Test
    public void naoDevePermitirPAliqMonoRetenComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoReten().setpAliqMonoReten(new BigDecimal("1000"));
        });
    }

    @Test
    public void naoDevePermitirVIBSMonoRetenComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoReten().setvIBSMonoReten(new BigDecimal("10000000000000"));
        });
    }

    @Test
    public void deveSetarVBCMonoRetenCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoReten gMonoReten = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoReten();
        gMonoReten.setvBCMonoReten(new BigDecimal("12345678901.23"));
        Assertions.assertEquals("12345678901.23", gMonoReten.getvBCMonoReten());
    }

    @Test
    public void deveSetarPAliqMonoRetenCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoReten gMonoReten = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoReten();
        gMonoReten.setpAliqMonoReten(new BigDecimal("9.8765"));
        Assertions.assertEquals("9.8765", gMonoReten.getpAliqMonoReten());
    }

    @Test
    public void deveSetarVIBSMonoRetenCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoReten gMonoReten = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoReten();
        gMonoReten.setvIBSMonoReten(new BigDecimal("12345678901.23"));
        Assertions.assertEquals("12345678901.23", gMonoReten.getvIBSMonoReten());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoReten><vBCMonoReten>12345678901.23</vBCMonoReten><pAliqMonoReten>9.8765</pAliqMonoReten><vIBSMonoReten>12345678901.23</vIBSMonoReten></NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoReten>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoReten().toString());
    }
}
