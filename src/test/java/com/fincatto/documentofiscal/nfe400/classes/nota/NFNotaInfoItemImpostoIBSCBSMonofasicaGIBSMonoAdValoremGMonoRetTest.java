package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

/**
 * @author Ommega Data
 */
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoRetTest {

    @Test
    public void naoDevePermitirVIBSMonoRetComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoRet().setVIBSMonoRet(new BigDecimal("10000000000000"));
        });
    }

    @Test
    public void deveSetarVIBSMonoRetCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoRet gMonoRet = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoRet();
        gMonoRet.setVIBSMonoRet(new BigDecimal("12345678901.23"));
        Assertions.assertEquals("12345678901.23", gMonoRet.getVIBSMonoRet());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoRet><vIBSMonoRet>12345678901.23</vIBSMonoRet></NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoRet>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoRet().toString());
    }
}
