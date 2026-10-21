package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

/**
 * @author Ommega Data
 */
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGpBioDiferencaTest {

    @Test
    public void naoDevePermitirQBCBioCombComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGpBioDiferenca().setQBCBioComb(new BigDecimal("100000000000"));
        });
    }

    @Test
    public void naoDevePermitirVCBSDiferencaComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGpBioDiferenca().setVCBSDiferenca(new BigDecimal("10000000000000"));
        });
    }

    @Test
    public void deveSetarQBCBioCombCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGpBioDiferenca gpBioDiferenca = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGpBioDiferenca();
        gpBioDiferenca.setQBCBioComb(new BigDecimal("1234567.8901"));
        Assertions.assertEquals("1234567.8901", gpBioDiferenca.getQBCBioComb());
    }

    @Test
    public void deveSetarVCBSDiferencaCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGpBioDiferenca gpBioDiferenca = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGpBioDiferenca();
        gpBioDiferenca.setVCBSDiferenca(new BigDecimal("98765432109.87"));
        Assertions.assertEquals("98765432109.87", gpBioDiferenca.getVCBSDiferenca());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGpBioDiferenca><qBCBioComb>1234567.8901</qBCBioComb><vCBSDiferenca>98765432109.87</vCBSDiferenca></NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGpBioDiferenca>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGpBioDiferenca().toString());
    }
}
