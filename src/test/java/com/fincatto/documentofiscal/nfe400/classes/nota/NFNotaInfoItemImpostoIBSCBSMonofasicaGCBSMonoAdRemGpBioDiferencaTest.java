package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

/**
 * @author Ommega Data
 */
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGpBioDiferencaTest {

    @Test
    public void naoDevePermitirQBCBioCombComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGpBioDiferenca().setQBCBioComb(new BigDecimal("100000000000"));
        });
    }

    @Test
    public void naoDevePermitirVCBSDiferencaComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGpBioDiferenca().setVCBSDiferenca(new BigDecimal("10000000000000"));
        });
    }

    @Test
    public void deveSetarQBCBioCombCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGpBioDiferenca gpBioDiferenca = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGpBioDiferenca();
        gpBioDiferenca.setQBCBioComb(new BigDecimal("1234567.8901"));
        Assertions.assertEquals("1234567.8901", gpBioDiferenca.getQBCBioComb());
    }

    @Test
    public void deveSetarVCBSDiferencaCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGpBioDiferenca gpBioDiferenca = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGpBioDiferenca();
        gpBioDiferenca.setVCBSDiferenca(new BigDecimal("98765432109.87"));
        Assertions.assertEquals("98765432109.87", gpBioDiferenca.getVCBSDiferenca());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGpBioDiferenca><qBCBioComb>1234567.8901</qBCBioComb><vCBSDiferenca>98765432109.87</vCBSDiferenca></NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGpBioDiferenca>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGpBioDiferenca().toString());
    }
}
