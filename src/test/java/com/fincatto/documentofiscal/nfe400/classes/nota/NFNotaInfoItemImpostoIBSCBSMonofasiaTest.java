package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.utils.DFPersister;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

/**
 * @author Ommega Data
 */
@SuppressWarnings("removal")
public class NFNotaInfoItemImpostoIBSCBSMonofasiaTest {

    @Test
    public void naoDevePermitirVTotIBSMonoItemComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasia().setVTotIBSMonoItem(new BigDecimal("10000000000000"));
        });
    }

    @Test
    public void naoDevePermitirVTotCBSMonoItemComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasia().setVTotCBSMonoItem(new BigDecimal("10000000000000"));
        });
    }

    @Test
    public void deveSetarVTotIBSMonoItemCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasia monofasia = new NFNotaInfoItemImpostoIBSCBSMonofasia();
        monofasia.setVTotIBSMonoItem(new BigDecimal("1234567890.12"));
        Assertions.assertEquals("1234567890.12", monofasia.getVTotIBSMonoItem());
    }

    @Test
    public void deveSetarVTotCBSMonoItemCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasia monofasia = new NFNotaInfoItemImpostoIBSCBSMonofasia();
        monofasia.setVTotCBSMonoItem(new BigDecimal("1234567890.12"));
        Assertions.assertEquals("1234567890.12", monofasia.getVTotCBSMonoItem());
    }

    @Test
    public void deveSetarGIBSMonoAdRemCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRem gIBSMonoAdRem = FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRem();
        final NFNotaInfoItemImpostoIBSCBSMonofasia monofasia = new NFNotaInfoItemImpostoIBSCBSMonofasia();
        monofasia.setGIBSMonoAdRem(gIBSMonoAdRem);
        Assertions.assertSame(gIBSMonoAdRem, monofasia.getGIBSMonoAdRem());
    }

    @Test
    public void deveSetarGIBSMonoAdValoremCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValorem gIBSMonoAdValorem = FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValorem();
        final NFNotaInfoItemImpostoIBSCBSMonofasia monofasia = new NFNotaInfoItemImpostoIBSCBSMonofasia();
        monofasia.setGIBSMonoAdValorem(gIBSMonoAdValorem);
        Assertions.assertSame(gIBSMonoAdValorem, monofasia.getGIBSMonoAdValorem());
    }

    @Test
    public void deveSetarGCBSMonoAdRemCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRem gCBSMonoAdRem = FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRem();
        final NFNotaInfoItemImpostoIBSCBSMonofasia monofasia = new NFNotaInfoItemImpostoIBSCBSMonofasia();
        monofasia.setGCBSMonoAdRem(gCBSMonoAdRem);
        Assertions.assertSame(gCBSMonoAdRem, monofasia.getGCBSMonoAdRem());
    }

    @Test
    public void deveSetarGCBSMonoAdValoremCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValorem gCBSMonoAdValorem = FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValorem();
        final NFNotaInfoItemImpostoIBSCBSMonofasia monofasia = new NFNotaInfoItemImpostoIBSCBSMonofasia();
        monofasia.setGCBSMonoAdValorem(gCBSMonoAdValorem);
        Assertions.assertSame(gCBSMonoAdValorem, monofasia.getGCBSMonoAdValorem());
    }

    @Test
    public void naoDevePermitirIBSAdRemEAdValoremSimultaneos() {
        final NFNotaInfoItemImpostoIBSCBSMonofasia monofasia = new NFNotaInfoItemImpostoIBSCBSMonofasia();
        monofasia.setGIBSMonoAdRem(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRem());
        Assertions.assertThrows(IllegalStateException.class, () -> {
            monofasia.setGIBSMonoAdValorem(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValorem());
        });
    }

    @Test
    public void naoDevePermitirCBSAdRemEAdValoremSimultaneos() {
        final NFNotaInfoItemImpostoIBSCBSMonofasia monofasia = new NFNotaInfoItemImpostoIBSCBSMonofasia();
        monofasia.setGCBSMonoAdValorem(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValorem());
        Assertions.assertThrows(IllegalStateException.class, () -> {
            monofasia.setGCBSMonoAdRem(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRem());
        });
    }

    @Test
    public void devePermitirSubstituirOMesmoGrupo() {
        final NFNotaInfoItemImpostoIBSCBSMonofasia monofasia = new NFNotaInfoItemImpostoIBSCBSMonofasia();
        monofasia.setGIBSMonoAdRem(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRem());
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRem substituto = FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRem();
        monofasia.setGIBSMonoAdRem(substituto);
        Assertions.assertSame(substituto, monofasia.getGIBSMonoAdRem());
    }

    @Test
    public void devePermitirTrocarDeGrupoAposLimparOAnterior() {
        final NFNotaInfoItemImpostoIBSCBSMonofasia monofasia = new NFNotaInfoItemImpostoIBSCBSMonofasia();
        monofasia.setGIBSMonoAdRem(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRem());
        monofasia.setGIBSMonoAdRem(null);
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValorem adValorem = FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValorem();
        monofasia.setGIBSMonoAdValorem(adValorem);
        Assertions.assertSame(adValorem, monofasia.getGIBSMonoAdValorem());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecidoAdRem() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasia><gIBSMonoAdRem><gMonoPadrao><qBCMono>1234567.8901</qBCMono><adRemIBS>9.8765</adRemIBS><vIBSMono>12345678901.23</vIBSMono></gMonoPadrao><gMonoReten><qBCMonoReten>1234567.8901</qBCMonoReten><adRemIBSReten>9.8765</adRemIBSReten><vIBSMonoReten>12345678901.23</vIBSMonoReten></gMonoReten><gMonoRet><vIBSMonoRet>12345678901.23</vIBSMonoRet></gMonoRet><gpBioDiferenca><qBCBioComb>1234567.8901</qBCBioComb><vIBSDiferenca>12345678901.23</vIBSDiferenca></gpBioDiferenca></gIBSMonoAdRem><gCBSMonoAdRem><gMonoPadrao><qBCMono>1234567.8901</qBCMono><adRemCBS>5.4321</adRemCBS><vCBSMono>98765432109.87</vCBSMono></gMonoPadrao><gMonoReten><qBCMonoReten>1234567.8901</qBCMonoReten><adRemCBSReten>5.4321</adRemCBSReten><vCBSMonoReten>98765432109.87</vCBSMonoReten></gMonoReten><gMonoRet><vCBSMonoRet>98765432109.87</vCBSMonoRet></gMonoRet><gpBioDiferenca><qBCBioComb>1234567.8901</qBCBioComb><vCBSDiferenca>98765432109.87</vCBSDiferenca></gpBioDiferenca></gCBSMonoAdRem><vTotIBSMonoItem>1234567890.12</vTotIBSMonoItem><vTotCBSMonoItem>1234567890.12</vTotCBSMonoItem></NFNotaInfoItemImpostoIBSCBSMonofasia>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasiaAdRem().toString());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecidoAdValorem() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasia><gIBSMonoAdValorem><gMonoPadrao><vBCMono>12345678901.23</vBCMono><pAliqMonoUF>9.8765</pAliqMonoUF><vIBSMonoUF>12345678901.23</vIBSMonoUF><pAliqMonoMun>5.4321</pAliqMonoMun><vIBSMonoMun>98765432109.87</vIBSMonoMun><vIBSMono>12345678901.23</vIBSMono></gMonoPadrao><gMonoReten><vBCMonoReten>12345678901.23</vBCMonoReten><pAliqMonoReten>9.8765</pAliqMonoReten><vIBSMonoReten>12345678901.23</vIBSMonoReten></gMonoReten><gMonoRet><vIBSMonoRet>12345678901.23</vIBSMonoRet></gMonoRet><gpBioDiferenca><qBCBioComb>1234567.8901</qBCBioComb><vIBSDiferenca>12345678901.23</vIBSDiferenca></gpBioDiferenca></gIBSMonoAdValorem><gCBSMonoAdValorem><gMonoPadrao><vBCMono>98765432109.87</vBCMono><pAliqMonoCBS>5.4321</pAliqMonoCBS><vCBSMono>98765432109.87</vCBSMono></gMonoPadrao><gMonoReten><vBCMonoReten>98765432109.87</vBCMonoReten><pAliqMonoReten>5.4321</pAliqMonoReten><vCBSMonoReten>98765432109.87</vCBSMonoReten></gMonoReten><gMonoRet><vCBSMonoRet>98765432109.87</vCBSMonoRet></gMonoRet><gpBioDiferenca><qBCBioComb>1234567.8901</qBCBioComb><vCBSDiferenca>98765432109.87</vCBSDiferenca></gpBioDiferenca></gCBSMonoAdValorem><vTotIBSMonoItem>1234567890.12</vTotIBSMonoItem><vTotCBSMonoItem>1234567890.12</vTotCBSMonoItem></NFNotaInfoItemImpostoIBSCBSMonofasia>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasiaAdValorem().toString());
    }

    @Test
    public void deveGerarXMLDosGruposLegadosNaOrdemDoLeiauteAnterior() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasia>" + XML_GRUPOS_LEGADOS + "<vTotIBSMonoItem>1234567890.12</vTotIBSMonoItem><vTotCBSMonoItem>9876543210.98</vTotCBSMonoItem></NFNotaInfoItemImpostoIBSCBSMonofasia>";
        Assertions.assertEquals(xmlEsperado, getMonofasiaLegada().toString());
    }

    @Test
    public void naoDeveGerarGruposLegadosNulos() {
        final NFNotaInfoItemImpostoIBSCBSMonofasia monofasia = new NFNotaInfoItemImpostoIBSCBSMonofasia();
        monofasia.setgMonoDif(NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDifTest.getGMonoDif());
        monofasia.setVTotIBSMonoItem(new BigDecimal("1234567890.12"));
        monofasia.setVTotCBSMonoItem(new BigDecimal("9876543210.98"));
        final String xml = monofasia.toString();
        Assertions.assertFalse(xml.contains("<gMonoPadrao>"));
        Assertions.assertFalse(xml.contains("<gMonoReten>"));
        Assertions.assertFalse(xml.contains("<gMonoRet>"));
        Assertions.assertTrue(xml.contains("<gMonoDif>"));
    }

    @Test
    public void deveLerXMLDoLeiauteAnteriorComGruposLegados() throws Exception {
        final String xml = "<NFNotaInfoItemImpostoIBSCBSMonofasia>" + XML_GRUPOS_LEGADOS + "<vTotIBSMonoItem>1234567890.12</vTotIBSMonoItem><vTotCBSMonoItem>9876543210.98</vTotCBSMonoItem></NFNotaInfoItemImpostoIBSCBSMonofasia>";
        final NFNotaInfoItemImpostoIBSCBSMonofasia monofasia = new DFPersister().read(NFNotaInfoItemImpostoIBSCBSMonofasia.class, xml);

        Assertions.assertEquals("12345678901.2345", monofasia.getgMonoPadrao().getQBCMono());
        Assertions.assertEquals("123.4567", monofasia.getgMonoPadrao().getAdRemIBS());
        Assertions.assertEquals("98.76", monofasia.getgMonoPadrao().getAdRemCBS());
        Assertions.assertEquals("1234567890123.45", monofasia.getgMonoPadrao().getVIBSMono());
        Assertions.assertEquals("9876543210.98", monofasia.getgMonoPadrao().getVCBSMono());

        Assertions.assertEquals("12345678901.2345", monofasia.getgMonoReten().getqBCMonoReten());
        Assertions.assertEquals("123.4567", monofasia.getgMonoReten().getAdRemIBSReten());
        Assertions.assertEquals("1234567890123.45", monofasia.getgMonoReten().getVIBSMonoReten());
        Assertions.assertEquals("98.76", monofasia.getgMonoReten().getAdRemCBSReten());
        Assertions.assertEquals("9876543210.98", monofasia.getgMonoReten().getVCBSMonoReten());

        Assertions.assertEquals("12345678901.2345", monofasia.getgMonoRet().getqBCMonoRet());
        Assertions.assertEquals("123.4567", monofasia.getgMonoRet().getAdRemIBSRet());
        Assertions.assertEquals("1234567890123.45", monofasia.getgMonoRet().getVIBSMonoRet());
        Assertions.assertEquals("98.76", monofasia.getgMonoRet().getAdRemCBSRet());
        Assertions.assertEquals("9876543210.98", monofasia.getgMonoRet().getVCBSMonoRet());

        Assertions.assertEquals("12.3456", monofasia.getgMonoDif().getPDifIBS());
        Assertions.assertEquals("1234567890123.45", monofasia.getgMonoDif().getVIBSMonoDif());
        Assertions.assertEquals("100.00", monofasia.getgMonoDif().getPDifCBS());
        Assertions.assertEquals("9876543210.98", monofasia.getgMonoDif().getVCBSMonoDif());

        Assertions.assertNull(monofasia.getGIBSMonoAdRem());
        Assertions.assertNull(monofasia.getGCBSMonoAdRem());
        Assertions.assertEquals("1234567890.12", monofasia.getVTotIBSMonoItem());
        Assertions.assertEquals("9876543210.98", monofasia.getVTotCBSMonoItem());

        Assertions.assertEquals(xml, monofasia.toString());
    }

    private static final String XML_GRUPOS_LEGADOS = "<gMonoPadrao><qBCMono>12345678901.2345</qBCMono><adRemIBS>123.4567</adRemIBS><adRemCBS>98.76</adRemCBS><vIBSMono>1234567890123.45</vIBSMono><vCBSMono>9876543210.98</vCBSMono></gMonoPadrao>"
            + "<gMonoReten><qBCMonoReten>12345678901.2345</qBCMonoReten><adRemIBSReten>123.4567</adRemIBSReten><vIBSMonoReten>1234567890123.45</vIBSMonoReten><adRemCBSReten>98.76</adRemCBSReten><vCBSMonoReten>9876543210.98</vCBSMonoReten></gMonoReten>"
            + "<gMonoRet><qBCMonoRet>12345678901.2345</qBCMonoRet><adRemIBSRet>123.4567</adRemIBSRet><vIBSMonoRet>1234567890123.45</vIBSMonoRet><adRemCBSRet>98.76</adRemCBSRet><vCBSMonoRet>9876543210.98</vCBSMonoRet></gMonoRet>"
            + "<gMonoDif><pDifIBS>12.3456</pDifIBS><vIBSMonoDif>1234567890123.45</vIBSMonoDif><pDifCBS>100.00</pDifCBS><vCBSMonoDif>9876543210.98</vCBSMonoDif></gMonoDif>";

    private static NFNotaInfoItemImpostoIBSCBSMonofasia getMonofasiaLegada() {
        final NFNotaInfoItemImpostoIBSCBSMonofasia monofasia = new NFNotaInfoItemImpostoIBSCBSMonofasia();
        monofasia.setgMonoPadrao(NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadraoTest.getGMonoPadrao());
        monofasia.setgMonoReten(NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRetenTest.getGMonoReten());
        monofasia.setgMonoRet(NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRetTest.getGMonoRet());
        monofasia.setgMonoDif(NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDifTest.getGMonoDif());
        monofasia.setVTotIBSMonoItem(new BigDecimal("1234567890.12"));
        monofasia.setVTotCBSMonoItem(new BigDecimal("9876543210.98"));
        return monofasia;
    }
}
