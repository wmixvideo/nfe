package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ommega Data
 */
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemTest {

    @Test
    public void deveSetarGMonoPadraoCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoPadrao gMonoPadrao = FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoPadrao();
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRem gCBSMonoAdRem = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRem();
        gCBSMonoAdRem.setGMonoPadrao(gMonoPadrao);
        Assertions.assertSame(gMonoPadrao, gCBSMonoAdRem.getGMonoPadrao());
    }

    @Test
    public void deveSetarGMonoRetenCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoReten gMonoReten = FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoReten();
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRem gCBSMonoAdRem = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRem();
        gCBSMonoAdRem.setGMonoReten(gMonoReten);
        Assertions.assertSame(gMonoReten, gCBSMonoAdRem.getGMonoReten());
    }

    @Test
    public void deveSetarGMonoRetCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoRet gMonoRet = FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoRet();
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRem gCBSMonoAdRem = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRem();
        gCBSMonoAdRem.setGMonoRet(gMonoRet);
        Assertions.assertSame(gMonoRet, gCBSMonoAdRem.getGMonoRet());
    }

    @Test
    public void deveSetarGpBioDiferencaCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGpBioDiferenca gpBioDiferenca = FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGpBioDiferenca();
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRem gCBSMonoAdRem = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRem();
        gCBSMonoAdRem.setGpBioDiferenca(gpBioDiferenca);
        Assertions.assertSame(gpBioDiferenca, gCBSMonoAdRem.getGpBioDiferenca());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRem><gMonoPadrao><qBCMono>1234567.8901</qBCMono><adRemCBS>5.4321</adRemCBS><vCBSMono>98765432109.87</vCBSMono></gMonoPadrao><gMonoReten><qBCMonoReten>1234567.8901</qBCMonoReten><adRemCBSReten>5.4321</adRemCBSReten><vCBSMonoReten>98765432109.87</vCBSMonoReten></gMonoReten><gMonoRet><vCBSMonoRet>98765432109.87</vCBSMonoRet></gMonoRet><gpBioDiferenca><qBCBioComb>1234567.8901</qBCBioComb><vCBSDiferenca>98765432109.87</vCBSDiferenca></gpBioDiferenca></NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRem>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRem().toString());
    }
}
