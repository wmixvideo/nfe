package com.fincatto.documentofiscal.cte400.classes.simp;

import com.fincatto.documentofiscal.cte400.classes.nota.CTeNotaInfoInformacoesRelativasImpostosIBSCBS.CTeTTribEstornoCred;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CTeNotaSimpInfoTotalIBSCBSTest {

    private static final String XML_ESPERADO = "<IBSCBSTot xmlns=\"http://www.portalfiscal.inf.br/cte\"><vBCIBSCBS>100.00</vBCIBSCBS>"
            + "<gIBS><gIBSUF><vDif>0.00</vDif><vDevTrib>0.00</vDevTrib><vIBSUF>0.10</vIBSUF></gIBSUF>"
            + "<gIBSMun><vDif>0.00</vDif><vDevTrib>0.00</vDevTrib><vIBSMun>0.00</vIBSMun></gIBSMun><vIBS>0.10</vIBS></gIBS>"
            + "<gCBS><vDif>0.00</vDif><vDevTrib>0.00</vDevTrib><vCBS>0.90</vCBS></gCBS></IBSCBSTot>";

    public static CTeNotaSimpInfoTotalIBSCBS getIbsCbsTot() {
        final CTeNotaSimpInfoTotalIBSCBS.GIBSUF gIBSUF = new CTeNotaSimpInfoTotalIBSCBS.GIBSUF();
        gIBSUF.setVDif(BigDecimal.ZERO);
        gIBSUF.setVDevTrib(BigDecimal.ZERO);
        gIBSUF.setVIBSUF(new BigDecimal("0.10"));
        final CTeNotaSimpInfoTotalIBSCBS.GIBSMun gIBSMun = new CTeNotaSimpInfoTotalIBSCBS.GIBSMun();
        gIBSMun.setVDif(BigDecimal.ZERO);
        gIBSMun.setVDevTrib(BigDecimal.ZERO);
        gIBSMun.setVIBSMun(BigDecimal.ZERO);
        final CTeNotaSimpInfoTotalIBSCBS.GIBS gIBS = new CTeNotaSimpInfoTotalIBSCBS.GIBS();
        gIBS.setGIBSUF(gIBSUF);
        gIBS.setGIBSMun(gIBSMun);
        gIBS.setVIBS(new BigDecimal("0.10"));
        final CTeNotaSimpInfoTotalIBSCBS.GCBS gCBS = new CTeNotaSimpInfoTotalIBSCBS.GCBS();
        gCBS.setVDif(BigDecimal.ZERO);
        gCBS.setVDevTrib(BigDecimal.ZERO);
        gCBS.setVCBS(new BigDecimal("0.90"));
        final CTeNotaSimpInfoTotalIBSCBS total = new CTeNotaSimpInfoTotalIBSCBS();
        total.setVBCIBSCBS(new BigDecimal("100"));
        total.setGIBS(gIBS);
        total.setGCBS(gCBS);
        return total;
    }

    @Test
    public void deveGerarXMLNaOrdemDoXSD() {
        Assertions.assertEquals(XML_ESPERADO, getIbsCbsTot().toString());
    }

    @Test
    public void deveGerarEstornoDeCreditoAoFinal() {
        final CTeTTribEstornoCred estorno = new CTeTTribEstornoCred();
        estorno.setVIBSEstCred(BigDecimal.ONE);
        estorno.setVCBSEstCred(BigDecimal.TEN);
        final CTeNotaSimpInfoTotalIBSCBS total = getIbsCbsTot();
        total.setGEstornoCred(estorno);
        Assertions.assertTrue(total.toString().endsWith("</gCBS><gEstornoCred><vIBSEstCred>1.00</vIBSEstCred><vCBSEstCred>10.00</vCBSEstCred></gEstornoCred></IBSCBSTot>"));
    }

    @Test
    public void valoresNaoDevemExtrapolarTamanho() {
        final BigDecimal muitoGrande = new BigDecimal("12345678901234");
        final BigDecimal casasDemais = new BigDecimal("1.123");
        Assertions.assertThrows(NumberFormatException.class, () -> new CTeNotaSimpInfoTotalIBSCBS().setVBCIBSCBS(muitoGrande));
        Assertions.assertThrows(NumberFormatException.class, () -> new CTeNotaSimpInfoTotalIBSCBS().setVBCIBSCBS(casasDemais));
        Assertions.assertThrows(NumberFormatException.class, () -> new CTeNotaSimpInfoTotalIBSCBS.GIBS().setVIBS(muitoGrande));
        Assertions.assertThrows(NumberFormatException.class, () -> new CTeNotaSimpInfoTotalIBSCBS.GIBSUF().setVIBSUF(casasDemais));
        Assertions.assertThrows(NumberFormatException.class, () -> new CTeNotaSimpInfoTotalIBSCBS.GIBSMun().setVIBSMun(casasDemais));
        Assertions.assertThrows(NumberFormatException.class, () -> new CTeNotaSimpInfoTotalIBSCBS.GCBS().setVCBS(muitoGrande));
    }
}
