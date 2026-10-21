package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ommega Data
 */
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremTest {

    @Test
    public void deveSetarGMonoPadraoCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao gMonoPadrao = FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao();
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValorem gIBSMonoAdValorem = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValorem();
        gIBSMonoAdValorem.setGMonoPadrao(gMonoPadrao);
        Assertions.assertSame(gMonoPadrao, gIBSMonoAdValorem.getGMonoPadrao());
    }

    @Test
    public void deveSetarGMonoRetenCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoReten gMonoReten = FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoReten();
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValorem gIBSMonoAdValorem = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValorem();
        gIBSMonoAdValorem.setGMonoReten(gMonoReten);
        Assertions.assertSame(gMonoReten, gIBSMonoAdValorem.getGMonoReten());
    }

    @Test
    public void deveSetarGMonoRetCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoRet gMonoRet = FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoRet();
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValorem gIBSMonoAdValorem = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValorem();
        gIBSMonoAdValorem.setGMonoRet(gMonoRet);
        Assertions.assertSame(gMonoRet, gIBSMonoAdValorem.getGMonoRet());
    }

    @Test
    public void deveSetarGpBioDiferencaCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGpBioDiferenca gpBioDiferenca = FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGpBioDiferenca();
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValorem gIBSMonoAdValorem = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValorem();
        gIBSMonoAdValorem.setGpBioDiferenca(gpBioDiferenca);
        Assertions.assertSame(gpBioDiferenca, gIBSMonoAdValorem.getGpBioDiferenca());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValorem><gMonoPadrao><vBCMono>12345678901.23</vBCMono><pAliqMonoUF>9.8765</pAliqMonoUF><vIBSMonoUF>12345678901.23</vIBSMonoUF><pAliqMonoMun>5.4321</pAliqMonoMun><vIBSMonoMun>98765432109.87</vIBSMonoMun><vIBSMono>12345678901.23</vIBSMono></gMonoPadrao><gMonoReten><vBCMonoReten>12345678901.23</vBCMonoReten><pAliqMonoReten>9.8765</pAliqMonoReten><vIBSMonoReten>12345678901.23</vIBSMonoReten></gMonoReten><gMonoRet><vIBSMonoRet>12345678901.23</vIBSMonoRet></gMonoRet><gpBioDiferenca><qBCBioComb>1234567.8901</qBCBioComb><vIBSDiferenca>12345678901.23</vIBSDiferenca></gpBioDiferenca></NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValorem>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValorem().toString());
    }
}
