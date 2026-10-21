package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

/**
 * @author Ommega Data
 */
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGpBioDiferencaTest {

    @Test
    public void naoDevePermitirQBCBioCombComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGpBioDiferenca().setQBCBioComb(new BigDecimal("100000000000"));
        });
    }

    @Test
    public void naoDevePermitirVIBSDiferencaComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGpBioDiferenca().setVIBSDiferenca(new BigDecimal("10000000000000"));
        });
    }

    @Test
    public void deveSetarQBCBioCombCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGpBioDiferenca gpBioDiferenca = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGpBioDiferenca();
        gpBioDiferenca.setQBCBioComb(new BigDecimal("1234567.8901"));
        Assertions.assertEquals("1234567.8901", gpBioDiferenca.getQBCBioComb());
    }

    @Test
    public void deveSetarVIBSDiferencaCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGpBioDiferenca gpBioDiferenca = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGpBioDiferenca();
        gpBioDiferenca.setVIBSDiferenca(new BigDecimal("12345678901.23"));
        Assertions.assertEquals("12345678901.23", gpBioDiferenca.getVIBSDiferenca());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGpBioDiferenca><qBCBioComb>1234567.8901</qBCBioComb><vIBSDiferenca>12345678901.23</vIBSDiferenca></NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGpBioDiferenca>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGpBioDiferenca().toString());
    }
}
