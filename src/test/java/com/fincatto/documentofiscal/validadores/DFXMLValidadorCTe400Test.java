package com.fincatto.documentofiscal.validadores;

import com.fincatto.documentofiscal.cte400.classes.nota.CTeNotaInfoInformacoesRelativasImpostosIBSCBS;
import com.fincatto.documentofiscal.cte400.classes.nota.CTeTTribSN;
import com.fincatto.documentofiscal.cte400.classes.nota.CTeTTribSNCBS;
import com.fincatto.documentofiscal.cte400.classes.nota.CTeTTribSNIBS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXParseException;

import java.math.BigDecimal;

/**
 * Validacao de um CT-e 4.00 minimo contra o pacote de schemas PL_CTe_400_NT2026.005 RTC SN 1.00 (NT 2026.005).
 */
public class DFXMLValidadorCTe400Test {

    private static final String FIM_EMITENTE = "<CRT>1</CRT></emit>";
    private static final String FIM_ICMS = "</ICMS></imp>";
    private static final String GRUPO_IBSSN = "<gIBSSN><pIBSSN>1.2345</pIBSSN><vIBSSN>1.23</vIBSSN></gIBSSN>";
    private static final String GRUPO_CBSSN = "<gCBSSN><pCBSSN>3.50</pCBSSN><vCBSSN>3.50</vCBSSN></gCBSSN>";
    private static final String GRUPO_ESTORNO = "<gEstornoCred><vIBSEstCred>1.00</vIBSEstCred><vCBSEstCred>1.00</vCBSEstCred></gEstornoCred>";

    private static final String CTE = "<CTe xmlns=\"http://www.portalfiscal.inf.br/cte\"><infCte versao=\"4.00\" Id=\"CTe43261112345678000195570010000000011000000010\">"
            + "<ide><cUF>43</cUF><cCT>00000001</cCT><CFOP>5353</CFOP><natOp>PRESTACAO DE SERVICO DE TRANSPORTE</natOp><mod>57</mod><serie>1</serie><nCT>1</nCT><dhEmi>2026-11-06T10:00:00-03:00</dhEmi><tpImp>1</tpImp><tpEmis>1</tpEmis><cDV>0</cDV><tpAmb>2</tpAmb><tpCTe>0</tpCTe><procEmi>0</procEmi><verProc>1.0</verProc>"
            + "<cMunEnv>4314902</cMunEnv><xMunEnv>PORTO ALEGRE</xMunEnv><UFEnv>RS</UFEnv><modal>01</modal><tpServ>0</tpServ><cMunIni>4314902</cMunIni><xMunIni>PORTO ALEGRE</xMunIni><UFIni>RS</UFIni><cMunFim>4314902</cMunFim><xMunFim>PORTO ALEGRE</xMunFim><UFFim>RS</UFFim><retira>1</retira><indIEToma>1</indIEToma><toma3><toma>0</toma></toma3></ide>"
            + "<emit><CNPJ>12345678000195</CNPJ><IE>1234567890</IE><xNome>EMITENTE TESTE</xNome><enderEmit><xLgr>RUA A</xLgr><nro>1</nro><xBairro>CENTRO</xBairro><cMun>4314902</cMun><xMun>PORTO ALEGRE</xMun><UF>RS</UF></enderEmit>" + FIM_EMITENTE
            + "<vPrest><vTPrest>100.00</vTPrest><vRec>100.00</vRec></vPrest>"
            + "<imp><ICMS><ICMSSN><CST>90</CST><indSN>1</indSN></ICMSSN>" + FIM_ICMS
            + "<infCTeNorm><infCarga><proPred>GLP</proPred><infQ><cUnid>01</cUnid><tpMed>PESO BRUTO</tpMed><qCarga>13.0000</qCarga></infQ></infCarga>"
            + "<infModal versaoModal=\"4.00\"><rodo><RNTRC>12345678</RNTRC></rodo></infModal></infCTeNorm></infCte>"
            + "<Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\"><SignedInfo><CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/><SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/><Reference URI=\"#CTe43261112345678000195570010000000011000000010\"><Transforms><Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/><Transform Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/></Transforms><DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/><DigestValue>DGElW+22IC8ksSISecob4b2l5QU=</DigestValue></Reference></SignedInfo>"
            + "<SignatureValue>aGtkSUxYZUVWLzJ4TnBqREVNTFI2VVNaWVFGL3o5V3BIRUZYVlZ3cnZQQXZ1VnJSOXpwdXVMQTcz</SignatureValue><KeyInfo><X509Data><X509Certificate>TUlJSDZEQ0NCZENnQXdJQkFnSVFkYzF2bDNoUFhVQ25tdmdBdm53MGZEQU5CZ2txaGtpRzl3MEJBUXNGQURCNE1Rc3dDUVlEVlFRRw==</X509Certificate></X509Data></KeyInfo></Signature></CTe>";

    private static String cteComIBSCBS(final String grupoIBSCBS) {
        return CTE.replace(FIM_ICMS, "</ICMS>" + grupoIBSCBS + "</imp>");
    }

    private static String ibscbs(final String grupos) {
        return "<IBSCBS><CST>000</CST><cClassTrib>000001</cClassTrib>" + grupos + "</IBSCBS>";
    }

    @Test
    public void deveValidarCTeSemGrupoIBSCBS() throws Exception {
        Assertions.assertTrue(DFXMLValidador.validaNotaCte400(CTE));
    }

    @Test
    public void deveValidarCTeComGrupoTribSNCompleto() throws Exception {
        Assertions.assertTrue(DFXMLValidador.validaNotaCte400(cteComIBSCBS(ibscbs("<gTribSN>" + GRUPO_IBSSN + GRUPO_CBSSN + "</gTribSN>"))));
    }

    @Test
    public void deveValidarCTeComGrupoTribSNSomenteComCBSSN() throws Exception {
        Assertions.assertTrue(DFXMLValidador.validaNotaCte400(cteComIBSCBS(ibscbs("<gTribSN>" + GRUPO_CBSSN + "</gTribSN>"))));
    }

    @Test
    public void deveValidarCTeComGrupoTribSNSomenteComIBSSN() throws Exception {
        Assertions.assertTrue(DFXMLValidador.validaNotaCte400(cteComIBSCBS(ibscbs("<gTribSN>" + GRUPO_IBSSN + "</gTribSN>"))));
    }

    @Test
    public void deveValidarGrupoTribSNAntesDoEstornoDeCredito() throws Exception {
        Assertions.assertTrue(DFXMLValidador.validaNotaCte400(cteComIBSCBS(ibscbs("<gTribSN>" + GRUPO_CBSSN + "</gTribSN>" + GRUPO_ESTORNO))));
    }

    @Test
    public void deveValidarCTeComGrupoIBSCBSGeradoPelasClassesDaLib() throws Exception {
        final CTeTTribSNIBS ibs = new CTeTTribSNIBS();
        ibs.setPIBSSN(new BigDecimal("1.2345"));
        ibs.setVIBSSN(new BigDecimal("1.23"));
        final CTeTTribSNCBS cbs = new CTeTTribSNCBS();
        cbs.setPCBSSN(new BigDecimal("3.5"));
        cbs.setVCBSSN(new BigDecimal("3.5"));
        final CTeTTribSN tribSN = new CTeTTribSN();
        tribSN.setGIBSSN(ibs);
        tribSN.setGCBSSN(cbs);
        final CTeNotaInfoInformacoesRelativasImpostosIBSCBS grupoIBSCBS = new CTeNotaInfoInformacoesRelativasImpostosIBSCBS();
        grupoIBSCBS.setCST("000");
        grupoIBSCBS.setCClassTrib("000001");
        grupoIBSCBS.setGTribSN(tribSN);

        Assertions.assertTrue(DFXMLValidador.validaNotaCte400(cteComIBSCBS(grupoIBSCBS.toString())));
    }

    @Test
    public void naoDeveValidarGrupoTribSNAposEstornoDeCredito() {
        final String xml = cteComIBSCBS(ibscbs(GRUPO_ESTORNO + "<gTribSN>" + GRUPO_CBSSN + "</gTribSN>"));
        Assertions.assertThrows(SAXParseException.class, () -> DFXMLValidador.validaNotaCte400(xml));
    }

    @Test
    public void naoDeveValidarGrupoCBSSNAntesDoGrupoIBSSN() {
        final String xml = cteComIBSCBS(ibscbs("<gTribSN>" + GRUPO_CBSSN + GRUPO_IBSSN + "</gTribSN>"));
        Assertions.assertThrows(SAXParseException.class, () -> DFXMLValidador.validaNotaCte400(xml));
    }

    @Test
    public void naoDeveValidarAliquotaIBSSNComMaisDeQuatroCasasDecimais() {
        final String xml = cteComIBSCBS(ibscbs("<gTribSN>" + GRUPO_IBSSN.replace("1.2345", "1.23456") + "</gTribSN>"));
        Assertions.assertThrows(SAXParseException.class, () -> DFXMLValidador.validaNotaCte400(xml));
    }

    @Test
    public void naoDeveValidarGrupoIBSSNSemValor() {
        final String xml = cteComIBSCBS(ibscbs("<gTribSN><gIBSSN><pIBSSN>1.2345</pIBSSN></gIBSSN></gTribSN>"));
        Assertions.assertThrows(SAXParseException.class, () -> DFXMLValidador.validaNotaCte400(xml));
    }

    /**
     * O pacote oficial PL_CTe_400_NT2026.005 RTC SN 1.00 define o tipo TRegimeIBSCBS, mas nao declara o elemento
     * tpRegimeIBSCBS no emitente do CT-e; enquanto o pacote nao for corrigido, a tag e rejeitada pelo schema.
     */
    @Test
    public void naoDeveValidarTipoRegimeIBSCBSNoEmitentePeloPacoteOficial() {
        final String xml = CTE.replace(FIM_EMITENTE, "<CRT>1</CRT><tpRegimeIBSCBS>1</tpRegimeIBSCBS></emit>");
        Assertions.assertThrows(SAXParseException.class, () -> DFXMLValidador.validaNotaCte400(xml));
    }
}
