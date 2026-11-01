package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

/**
 * @author Ommega Data
 */
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoRetTest {

    @Test
    public void naoDevePermitirVIBSMonoRetComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoRet().setVIBSMonoRet(new BigDecimal("10000000000000"));
        });
    }

    @Test
    public void deveSetarVIBSMonoRetCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoRet gMonoRet = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoRet();
        gMonoRet.setVIBSMonoRet(new BigDecimal("12345678901.23"));
        Assertions.assertEquals("12345678901.23", gMonoRet.getVIBSMonoRet());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoRet><vIBSMonoRet>12345678901.23</vIBSMonoRet></NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoRet>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoRet().toString());
    }
}
