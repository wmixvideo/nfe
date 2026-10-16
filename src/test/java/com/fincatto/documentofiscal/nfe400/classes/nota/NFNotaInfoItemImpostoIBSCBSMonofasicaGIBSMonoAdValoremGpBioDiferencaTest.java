package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

/**
 * @author Ommega Data
 */
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGpBioDiferencaTest {

    @Test
    public void naoDevePermitirQBCBioCombComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGpBioDiferenca().setqBCBioComb(new BigDecimal("100000000000"));
        });
    }

    @Test
    public void naoDevePermitirVIBSDiferencaComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGpBioDiferenca().setvIBSDiferenca(new BigDecimal("10000000000000"));
        });
    }

    @Test
    public void deveSetarQBCBioCombCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGpBioDiferenca gpBioDiferenca = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGpBioDiferenca();
        gpBioDiferenca.setqBCBioComb(new BigDecimal("1234567.8901"));
        Assertions.assertEquals("1234567.8901", gpBioDiferenca.getqBCBioComb());
    }

    @Test
    public void deveSetarVIBSDiferencaCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGpBioDiferenca gpBioDiferenca = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGpBioDiferenca();
        gpBioDiferenca.setvIBSDiferenca(new BigDecimal("12345678901.23"));
        Assertions.assertEquals("12345678901.23", gpBioDiferenca.getvIBSDiferenca());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGpBioDiferenca><qBCBioComb>1234567.8901</qBCBioComb><vIBSDiferenca>12345678901.23</vIBSDiferenca></NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGpBioDiferenca>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGpBioDiferenca().toString());
    }
}
