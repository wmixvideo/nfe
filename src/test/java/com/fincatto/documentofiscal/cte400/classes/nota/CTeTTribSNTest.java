package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.utils.DFPersister;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CTeTTribSNTest {

    private static final String NAMESPACE = " xmlns=\"http://www.portalfiscal.inf.br/cte\"";
    private static final String GRUPO_IBSSN = "<gIBSSN><pIBSSN>1.2345</pIBSSN><vIBSSN>12.34</vIBSSN></gIBSSN>";
    private static final String GRUPO_CBSSN = "<gCBSSN><pCBSSN>999.99</pCBSSN><vCBSSN>9999999999999.99</vCBSSN></gCBSSN>";

    @Test
    public void naoDevePermitirPercentualIBSSNComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new CTeTTribSNIBS().setPIBSSN(new BigDecimal("1000")));
        Assertions.assertThrows(NumberFormatException.class, () -> new CTeTTribSNIBS().setPIBSSN(new BigDecimal("1.12345")));
    }

    @Test
    public void naoDevePermitirValorIBSSNComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new CTeTTribSNIBS().setVIBSSN(new BigDecimal("10000000000000")));
        Assertions.assertThrows(NumberFormatException.class, () -> new CTeTTribSNIBS().setVIBSSN(new BigDecimal("1.123")));
    }

    @Test
    public void naoDevePermitirPercentualCBSSNComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new CTeTTribSNCBS().setPCBSSN(new BigDecimal("1000")));
        Assertions.assertThrows(NumberFormatException.class, () -> new CTeTTribSNCBS().setPCBSSN(new BigDecimal("1.12345")));
    }

    @Test
    public void naoDevePermitirValorCBSSNComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new CTeTTribSNCBS().setVCBSSN(new BigDecimal("10000000000000")));
        Assertions.assertThrows(NumberFormatException.class, () -> new CTeTTribSNCBS().setVCBSSN(new BigDecimal("1.123")));
    }

    @Test
    public void naoDevePermitirCamposDosGruposNulos() {
        Assertions.assertThrows(IllegalStateException.class, () -> new CTeTTribSNIBS().toString());
        Assertions.assertThrows(IllegalStateException.class, () -> new CTeTTribSNCBS().toString());
    }

    @Test
    public void deveFormatarCasasDecimais() {
        final CTeTTribSNIBS ibs = new CTeTTribSNIBS();
        ibs.setPIBSSN(new BigDecimal("2"));
        ibs.setVIBSSN(new BigDecimal("3"));
        Assertions.assertEquals("2.00", ibs.getPIBSSN());
        Assertions.assertEquals("3.00", ibs.getVIBSSN());

        final CTeTTribSNCBS cbs = new CTeTTribSNCBS();
        cbs.setPCBSSN(new BigDecimal("0.1234"));
        cbs.setVCBSSN(new BigDecimal("0.5"));
        Assertions.assertEquals("0.1234", cbs.getPCBSSN());
        Assertions.assertEquals("0.50", cbs.getVCBSSN());
    }

    @Test
    public void deveGerarXMLComIBSSNECBSSN() {
        Assertions.assertEquals("<gTribSN" + NAMESPACE + ">" + GRUPO_IBSSN + GRUPO_CBSSN + "</gTribSN>", getGrupoTribSN(true, true).toString());
    }

    @Test
    public void deveGerarXMLSomenteComIBSSN() {
        Assertions.assertEquals("<gTribSN" + NAMESPACE + ">" + GRUPO_IBSSN + "</gTribSN>", getGrupoTribSN(true, false).toString());
    }

    @Test
    public void deveGerarXMLSomenteComCBSSN() {
        Assertions.assertEquals("<gTribSN" + NAMESPACE + ">" + GRUPO_CBSSN + "</gTribSN>", getGrupoTribSN(false, true).toString());
    }

    @Test
    public void naoDeveGerarGrupoTribSNNoIBSCBSQuandoNulo() {
        Assertions.assertEquals("<IBSCBS" + NAMESPACE + "><CST>000</CST><cClassTrib>000001</cClassTrib></IBSCBS>", getIBSCBS().toString());
    }

    @Test
    public void deveGerarGrupoTribSNAntesDoEstornoDeCredito() {
        final CTeNotaInfoInformacoesRelativasImpostosIBSCBS ibscbs = getIBSCBS();
        final CTeNotaInfoInformacoesRelativasImpostosIBSCBS.CTeTTribEstornoCred estorno = new CTeNotaInfoInformacoesRelativasImpostosIBSCBS.CTeTTribEstornoCred();
        estorno.setVIBSEstCred(BigDecimal.ONE);
        estorno.setVCBSEstCred(BigDecimal.TEN);
        ibscbs.setGEstornoCred(estorno);
        ibscbs.setGTribSN(getGrupoTribSN(true, true));

        Assertions.assertEquals("<IBSCBS" + NAMESPACE + "><CST>000</CST><cClassTrib>000001</cClassTrib><gTribSN>" + GRUPO_IBSSN + GRUPO_CBSSN + "</gTribSN>"
                + "<gEstornoCred><vIBSEstCred>1.00</vIBSEstCred><vCBSEstCred>10.00</vCBSEstCred></gEstornoCred></IBSCBS>", ibscbs.toString());
    }

    @Test
    public void deveLerGrupoTribSNDoXML() throws Exception {
        final String xml = "<IBSCBS><CST>000</CST><cClassTrib>000001</cClassTrib><gTribSN>" + GRUPO_IBSSN + GRUPO_CBSSN + "</gTribSN></IBSCBS>";

        final CTeNotaInfoInformacoesRelativasImpostosIBSCBS lido = new DFPersister().read(CTeNotaInfoInformacoesRelativasImpostosIBSCBS.class, xml);
        final CTeTTribSN tribSN = lido.getGTribSN();
        Assertions.assertEquals("1.2345", tribSN.getGIBSSN().getPIBSSN());
        Assertions.assertEquals("12.34", tribSN.getGIBSSN().getVIBSSN());
        Assertions.assertEquals("999.99", tribSN.getGCBSSN().getPCBSSN());
        Assertions.assertEquals("9999999999999.99", tribSN.getGCBSSN().getVCBSSN());
        Assertions.assertEquals(xml.replace("<IBSCBS>", "<IBSCBS" + NAMESPACE + ">"), lido.toString());
    }

    @Test
    public void deveLerGrupoTribSNSomenteComCBSSNDoXML() throws Exception {
        final String xml = "<IBSCBS><CST>000</CST><cClassTrib>000001</cClassTrib><gTribSN>" + GRUPO_CBSSN + "</gTribSN></IBSCBS>";

        final CTeNotaInfoInformacoesRelativasImpostosIBSCBS lido = new DFPersister().read(CTeNotaInfoInformacoesRelativasImpostosIBSCBS.class, xml);
        Assertions.assertNull(lido.getGTribSN().getGIBSSN());
        Assertions.assertEquals("999.99", lido.getGTribSN().getGCBSSN().getPCBSSN());
        Assertions.assertEquals(xml.replace("<IBSCBS>", "<IBSCBS" + NAMESPACE + ">"), lido.toString());
    }

    private static CTeNotaInfoInformacoesRelativasImpostosIBSCBS getIBSCBS() {
        final CTeNotaInfoInformacoesRelativasImpostosIBSCBS ibscbs = new CTeNotaInfoInformacoesRelativasImpostosIBSCBS();
        ibscbs.setCST("000");
        ibscbs.setCClassTrib("000001");
        return ibscbs;
    }

    private static CTeTTribSN getGrupoTribSN(final boolean comIBS, final boolean comCBS) {
        final CTeTTribSN tribSN = new CTeTTribSN();
        if (comIBS) {
            final CTeTTribSNIBS ibs = new CTeTTribSNIBS();
            ibs.setPIBSSN(new BigDecimal("1.2345"));
            ibs.setVIBSSN(new BigDecimal("12.34"));
            tribSN.setGIBSSN(ibs);
        }
        if (comCBS) {
            final CTeTTribSNCBS cbs = new CTeTTribSNCBS();
            cbs.setPCBSSN(new BigDecimal("999.99"));
            cbs.setVCBSSN(new BigDecimal("9999999999999.99"));
            tribSN.setGCBSSN(cbs);
        }
        return tribSN;
    }
}
