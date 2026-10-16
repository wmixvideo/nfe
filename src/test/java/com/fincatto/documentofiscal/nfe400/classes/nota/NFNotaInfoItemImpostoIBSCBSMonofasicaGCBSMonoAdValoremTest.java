package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ommega Data
 */
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremTest {

    @Test
    public void deveSetarGMonoPadraoCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoPadrao gMonoPadrao = FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoPadrao();
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValorem gCBSMonoAdValorem = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValorem();
        gCBSMonoAdValorem.setgMonoPadrao(gMonoPadrao);
        Assertions.assertSame(gMonoPadrao, gCBSMonoAdValorem.getgMonoPadrao());
    }

    @Test
    public void deveSetarGMonoRetenCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoReten gMonoReten = FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoReten();
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValorem gCBSMonoAdValorem = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValorem();
        gCBSMonoAdValorem.setgMonoReten(gMonoReten);
        Assertions.assertSame(gMonoReten, gCBSMonoAdValorem.getgMonoReten());
    }

    @Test
    public void deveSetarGMonoRetCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoRet gMonoRet = FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoRet();
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValorem gCBSMonoAdValorem = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValorem();
        gCBSMonoAdValorem.setgMonoRet(gMonoRet);
        Assertions.assertSame(gMonoRet, gCBSMonoAdValorem.getgMonoRet());
    }

    @Test
    public void deveSetarGpBioDiferencaCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGpBioDiferenca gpBioDiferenca = FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGpBioDiferenca();
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValorem gCBSMonoAdValorem = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValorem();
        gCBSMonoAdValorem.setGpBioDiferenca(gpBioDiferenca);
        Assertions.assertSame(gpBioDiferenca, gCBSMonoAdValorem.getGpBioDiferenca());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValorem><gMonoPadrao><vBCMono>98765432109.87</vBCMono><pAliqMonoCBS>5.4321</pAliqMonoCBS><vCBSMono>98765432109.87</vCBSMono></gMonoPadrao><gMonoReten><vBCMonoReten>98765432109.87</vBCMonoReten><pAliqMonoReten>5.4321</pAliqMonoReten><vCBSMonoReten>98765432109.87</vCBSMonoReten></gMonoReten><gMonoRet><vCBSMonoRet>98765432109.87</vCBSMonoRet></gMonoRet><gpBioDiferenca><qBCBioComb>1234567.8901</qBCBioComb><vCBSDiferenca>98765432109.87</vCBSDiferenca></gpBioDiferenca></NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValorem>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValorem().toString());
    }
}
