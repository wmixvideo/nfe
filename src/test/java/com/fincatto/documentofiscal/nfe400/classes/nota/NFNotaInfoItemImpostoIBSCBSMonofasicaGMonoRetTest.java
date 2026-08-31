package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

/**
 * @author Ommega Data
 */
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRetTest {

    @Test
    public void naoDevePermitirQBCMonoRetComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet().setqBCMonoRet(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirAdRemIBSRetComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet().setAdRemIBSRet(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirVIBSMonoRetComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet().setVIBSMonoRet(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirAdRemCBSRetComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet().setAdRemCBSRet(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirVCBSMonoRetComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet().setVCBSMonoRet(new BigDecimal("10000000000000")));
    }

    @Test
    public void deveSetarQBCMonoRetCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet monoRet = new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet();
        monoRet.setqBCMonoRet(new BigDecimal("1234567.8901"));
        Assertions.assertEquals("1234567.8901", monoRet.getqBCMonoRet());
    }

    @Test
    public void deveSetarAdRemIBSRetCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet monoRet = new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet();
        monoRet.setAdRemIBSRet(new BigDecimal("9.8765"));
        Assertions.assertEquals("9.8765", monoRet.getAdRemIBSRet());
    }

    @Test
    public void deveSetarVIBSMonoRetCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet monoRet = new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet();
        monoRet.setVIBSMonoRet(new BigDecimal("12345678901.23"));
        Assertions.assertEquals("12345678901.23", monoRet.getVIBSMonoRet());
    }

    @Test
    public void deveSetarAdRemCBSRetCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet monoRet = new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet();
        monoRet.setAdRemCBSRet(new BigDecimal("5.4321"));
        Assertions.assertEquals("5.4321", monoRet.getAdRemCBSRet());
    }

    @Test
    public void deveSetarVCBSMonoRetCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet monoRet = new NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet();
        monoRet.setVCBSMonoRet(new BigDecimal("98765432109.87"));
        Assertions.assertEquals("98765432109.87", monoRet.getVCBSMonoRet());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet><qBCMonoRet>1234567.8901</qBCMonoRet><adRemIBSRet>9.8765</adRemIBSRet><vIBSMonoRet>12345678901.23</vIBSMonoRet><adRemCBSRet>5.4321</adRemCBSRet><vCBSMonoRet>98765432109.87</vCBSMonoRet></NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet().toString());
    }
}