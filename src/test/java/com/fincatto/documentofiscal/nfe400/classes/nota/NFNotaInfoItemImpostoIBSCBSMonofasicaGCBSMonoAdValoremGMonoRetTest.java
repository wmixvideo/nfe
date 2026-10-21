package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

/**
 * @author Ommega Data
 */
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoRetTest {

    @Test
    public void naoDevePermitirVCBSMonoRetComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoRet().setVCBSMonoRet(new BigDecimal("10000000000000"));
        });
    }

    @Test
    public void deveSetarVCBSMonoRetCorretamente() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoRet gMonoRet = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoRet();
        gMonoRet.setVCBSMonoRet(new BigDecimal("98765432109.87"));
        Assertions.assertEquals("98765432109.87", gMonoRet.getVCBSMonoRet());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoRet><vCBSMonoRet>98765432109.87</vCBSMonoRet></NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoRet>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoRet().toString());
    }
}
