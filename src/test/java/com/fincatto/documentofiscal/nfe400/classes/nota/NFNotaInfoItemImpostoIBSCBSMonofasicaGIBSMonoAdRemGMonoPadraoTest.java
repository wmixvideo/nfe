package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

/**
 * @author Ommega Data
 */
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoPadraoTest {

    @Test
    public void naoDevePermitirQBCMonoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoPadrao().setQBCMono(new BigDecimal("100000000000"));
        });
    }

    @Test
    public void naoDevePermitirAdRemIBSComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoPadrao().setAdRemIBS(new BigDecimal("1000"));
        });
    }

    @Test
    public void naoDevePermitirVIBSMonoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoPadrao().setVIBSMono(new BigDecimal("10000000000000"));
        });
    }

    @Test
    public void deveSerializarQBCMonoComQuatroCasasDecimais() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoPadrao padrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoPadrao();
        padrao.setQBCMono(new BigDecimal("10.5"));
        Assertions.assertEquals("10.5000", padrao.getQBCMono());
    }

    @Test
    public void deveSetarQBCMonoCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoPadrao gMonoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoPadrao();
        gMonoPadrao.setQBCMono(new BigDecimal("1234567.8901"));
        Assertions.assertEquals("1234567.8901", gMonoPadrao.getQBCMono());
    }

    @Test
    public void deveSetarAdRemIBSCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoPadrao gMonoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoPadrao();
        gMonoPadrao.setAdRemIBS(new BigDecimal("9.8765"));
        Assertions.assertEquals("9.8765", gMonoPadrao.getAdRemIBS());
    }

    @Test
    public void deveSetarVIBSMonoCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoPadrao gMonoPadrao = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoPadrao();
        gMonoPadrao.setVIBSMono(new BigDecimal("12345678901.23"));
        Assertions.assertEquals("12345678901.23", gMonoPadrao.getVIBSMono());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoPadrao><qBCMono>1234567.8901</qBCMono><adRemIBS>9.8765</adRemIBS><vIBSMono>12345678901.23</vIBSMono></NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoPadrao>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoPadrao().toString());
    }
}
