package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ommega Data
 */
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemTest {

    @Test
    public void deveSetarGMonoPadraoCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoPadrao gMonoPadrao = FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoPadrao();
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRem gIBSMonoAdRem = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRem();
        gIBSMonoAdRem.setGMonoPadrao(gMonoPadrao);
        Assertions.assertSame(gMonoPadrao, gIBSMonoAdRem.getGMonoPadrao());
    }

    @Test
    public void deveSetarGMonoRetenCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoReten gMonoReten = FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoReten();
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRem gIBSMonoAdRem = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRem();
        gIBSMonoAdRem.setGMonoReten(gMonoReten);
        Assertions.assertSame(gMonoReten, gIBSMonoAdRem.getGMonoReten());
    }

    @Test
    public void deveSetarGMonoRetCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoRet gMonoRet = FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoRet();
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRem gIBSMonoAdRem = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRem();
        gIBSMonoAdRem.setGMonoRet(gMonoRet);
        Assertions.assertSame(gMonoRet, gIBSMonoAdRem.getGMonoRet());
    }

    @Test
    public void deveSetarGpBioDiferencaCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGpBioDiferenca gpBioDiferenca = FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGpBioDiferenca();
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRem gIBSMonoAdRem = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRem();
        gIBSMonoAdRem.setGpBioDiferenca(gpBioDiferenca);
        Assertions.assertSame(gpBioDiferenca, gIBSMonoAdRem.getGpBioDiferenca());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRem><gMonoPadrao><qBCMono>1234567.8901</qBCMono><adRemIBS>9.8765</adRemIBS><vIBSMono>12345678901.23</vIBSMono></gMonoPadrao><gMonoReten><qBCMonoReten>1234567.8901</qBCMonoReten><adRemIBSReten>9.8765</adRemIBSReten><vIBSMonoReten>12345678901.23</vIBSMonoReten></gMonoReten><gMonoRet><vIBSMonoRet>12345678901.23</vIBSMonoRet></gMonoRet><gpBioDiferenca><qBCBioComb>1234567.8901</qBCBioComb><vIBSDiferenca>12345678901.23</vIBSDiferenca></gpBioDiferenca></NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRem>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRem().toString());
    }
}
