package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

/**
 * @author Ommega Data
 */
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
        monofasia.setgIBSMonoAdRem(gIBSMonoAdRem);
        Assertions.assertSame(gIBSMonoAdRem, monofasia.getgIBSMonoAdRem());
    }

    @Test
    public void deveSetarGIBSMonoAdValoremCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValorem gIBSMonoAdValorem = FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValorem();
        final NFNotaInfoItemImpostoIBSCBSMonofasia monofasia = new NFNotaInfoItemImpostoIBSCBSMonofasia();
        monofasia.setgIBSMonoAdValorem(gIBSMonoAdValorem);
        Assertions.assertSame(gIBSMonoAdValorem, monofasia.getgIBSMonoAdValorem());
    }

    @Test
    public void deveSetarGCBSMonoAdRemCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRem gCBSMonoAdRem = FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRem();
        final NFNotaInfoItemImpostoIBSCBSMonofasia monofasia = new NFNotaInfoItemImpostoIBSCBSMonofasia();
        monofasia.setgCBSMonoAdRem(gCBSMonoAdRem);
        Assertions.assertSame(gCBSMonoAdRem, monofasia.getgCBSMonoAdRem());
    }

    @Test
    public void deveSetarGCBSMonoAdValoremCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValorem gCBSMonoAdValorem = FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValorem();
        final NFNotaInfoItemImpostoIBSCBSMonofasia monofasia = new NFNotaInfoItemImpostoIBSCBSMonofasia();
        monofasia.setgCBSMonoAdValorem(gCBSMonoAdValorem);
        Assertions.assertSame(gCBSMonoAdValorem, monofasia.getgCBSMonoAdValorem());
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
}
