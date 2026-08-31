package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @author Ommega Data
 */
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRetenTest {

    @Test
    public void naoDevePermitirQBCMonoRetenComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten().setqBCMonoReten(new BigDecimal("10000000000000")));
    }


    @Test
    public void naoDevePermitirAdRemIBSRetenComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten().setAdRemIBSReten(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirVIBSMonoRetenComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten().setVIBSMonoReten(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirAdRemCBSRetenComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten().setAdRemCBSReten(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirVCBSMonoRetenComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten().setVCBSMonoReten(new BigDecimal("10000000000000")));
    }

    @Test
    public void deveSetarQBCMonoRetenCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten monoReten = new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten();
        monoReten.setqBCMonoReten(new BigDecimal("1234567.8901"));
        Assertions.assertEquals("1234567.8901", monoReten.getqBCMonoReten());
    }

    @Test
    public void deveSetarAdRemIBSRetenCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten monoReten = new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten();
        monoReten.setAdRemIBSReten(new BigDecimal("9.8765"));
        Assertions.assertEquals("9.8765", monoReten.getAdRemIBSReten());
    }

    @Test
    public void deveSetarVIBSMonoRetenCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten monoReten = new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten();
        monoReten.setVIBSMonoReten(new BigDecimal("12345678901.23"));
        Assertions.assertEquals("12345678901.23", monoReten.getVIBSMonoReten());
    }

    @Test
    public void deveSetarAdRemCBSRetenCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten monoReten = new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten();
        monoReten.setAdRemCBSReten(new BigDecimal("5.4321"));
        Assertions.assertEquals("5.4321", monoReten.getAdRemCBSReten());
    }

    @Test
    public void deveSetarVCBSMonoRetenCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten monoReten = new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten();
        monoReten.setVCBSMonoReten(new BigDecimal("98765432109.87"));
        Assertions.assertEquals("98765432109.87", monoReten.getVCBSMonoReten());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten><qBCMonoReten>1234567.8901</qBCMonoReten><adRemIBSReten>9.8765</adRemIBSReten><vIBSMonoReten>12345678901.23</vIBSMonoReten><adRemCBSReten>5.4321</adRemCBSReten><vCBSMonoReten>98765432109.87</vCBSMonoReten></NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten>";;
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten().toString());
    }
}