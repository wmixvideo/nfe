package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

/**
 * @author Ommega Data
 */
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoRetTest {

    @Test
    public void naoDevePermitirVCBSMonoRetComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoRet().setVCBSMonoRet(new BigDecimal("10000000000000"));
        });
    }

    @Test
    public void deveSetarVCBSMonoRetCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoRet gMonoRet = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoRet();
        gMonoRet.setVCBSMonoRet(new BigDecimal("98765432109.87"));
        Assertions.assertEquals("98765432109.87", gMonoRet.getVCBSMonoRet());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoRet><vCBSMonoRet>98765432109.87</vCBSMonoRet></NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoRet>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoRet().toString());
    }
}
