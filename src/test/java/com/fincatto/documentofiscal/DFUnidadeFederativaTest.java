package com.fincatto.documentofiscal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DFUnidadeFederativaTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	
        Assertions.assertEquals("AC", DFUnidadeFederativa.AC.getCodigo());
        Assertions.assertEquals("12", DFUnidadeFederativa.AC.getCodigoIbge());
        Assertions.assertEquals("http://hml.sefaznet.ac.gov.br/nfce/qrcode", DFUnidadeFederativa.AC.getQrCodeHomologacao());
        Assertions.assertEquals("http://www.sefaznet.ac.gov.br/nfce/qrcode", DFUnidadeFederativa.AC.getQrCodeProducao());

        Assertions.assertEquals("AL", DFUnidadeFederativa.AL.getCodigo());
        Assertions.assertEquals("27", DFUnidadeFederativa.AL.getCodigoIbge());
        Assertions.assertEquals("http://nfce.sefaz.al.gov.br/QRCode/consultarNFCe.jsp", DFUnidadeFederativa.AL.getQrCodeHomologacao());
        Assertions.assertEquals("http://nfce.sefaz.al.gov.br/QRCode/consultarNFCe.jsp", DFUnidadeFederativa.AL.getQrCodeProducao());


        Assertions.assertEquals("AM", DFUnidadeFederativa.AM.getCodigo());
        Assertions.assertEquals("13", DFUnidadeFederativa.AM.getCodigoIbge());
        Assertions.assertEquals("http://homnfce.sefaz.am.gov.br/nfceweb/consultarNFCe.jsp", DFUnidadeFederativa.AM.getQrCodeHomologacao());
        Assertions.assertEquals("http://sistemas.sefaz.am.gov.br/nfceweb/consultarNFCe.jsp", DFUnidadeFederativa.AM.getQrCodeProducao());

        Assertions.assertEquals("AP", DFUnidadeFederativa.AP.getCodigo());
        Assertions.assertEquals("16", DFUnidadeFederativa.AP.getCodigoIbge());
        Assertions.assertEquals("https://www.sefaz.ap.gov.br/nfcehml/nfce.php", DFUnidadeFederativa.AP.getQrCodeHomologacao());
        Assertions.assertEquals("https://www.sefaz.ap.gov.br/nfce/nfce.php", DFUnidadeFederativa.AP.getQrCodeProducao());

        Assertions.assertEquals("BA", DFUnidadeFederativa.BA.getCodigo());
        Assertions.assertEquals("29", DFUnidadeFederativa.BA.getCodigoIbge());
        Assertions.assertEquals("http://hnfe.sefaz.ba.gov.br/servicos/nfce/modulos/geral/NFCEC_consulta_chave_acesso.aspx", DFUnidadeFederativa.BA.getQrCodeHomologacao());
        Assertions.assertEquals("http://nfe.sefaz.ba.gov.br/servicos/nfce/modulos/geral/NFCEC_consulta_chave_acesso.aspx", DFUnidadeFederativa.BA.getQrCodeProducao());

        Assertions.assertEquals("CE", DFUnidadeFederativa.CE.getCodigo());
        Assertions.assertEquals("23", DFUnidadeFederativa.CE.getCodigoIbge());
        Assertions.assertEquals("http://nfceh.sefaz.ce.gov.br/pages/ShowNFCe.html", DFUnidadeFederativa.CE.getQrCodeHomologacao());
        Assertions.assertEquals("http://nfce.sefaz.ce.gov.br/pages/ShowNFCe.html", DFUnidadeFederativa.CE.getQrCodeProducao());

        Assertions.assertEquals("DF", DFUnidadeFederativa.DF.getCodigo());
        Assertions.assertEquals("53", DFUnidadeFederativa.DF.getCodigoIbge());
        Assertions.assertEquals("http://dec.fazenda.df.gov.br/ConsultarNFCe.aspx", DFUnidadeFederativa.DF.getQrCodeHomologacao());
        Assertions.assertEquals("http://dec.fazenda.df.gov.br/ConsultarNFCe.aspx", DFUnidadeFederativa.DF.getQrCodeProducao());

        Assertions.assertEquals("ES", DFUnidadeFederativa.ES.getCodigo());
        Assertions.assertEquals("32", DFUnidadeFederativa.ES.getCodigoIbge());
        Assertions.assertEquals("http://homologacao.sefaz.es.gov.br/ConsultaNFCe/qrcode.aspx", DFUnidadeFederativa.ES.getQrCodeHomologacao());
        Assertions.assertEquals("http://app.sefaz.es.gov.br/ConsultaNFCe/qrcode.aspx", DFUnidadeFederativa.ES.getQrCodeProducao());

        Assertions.assertEquals("GO", DFUnidadeFederativa.GO.getCodigo());
        Assertions.assertEquals("52", DFUnidadeFederativa.GO.getCodigoIbge());
        Assertions.assertEquals("https://nfewebhomolog.sefaz.go.gov.br/nfeweb/sites/nfce/danfeNFCe", DFUnidadeFederativa.GO.getQrCodeHomologacao());
        Assertions.assertEquals("https://nfeweb.sefaz.go.gov.br/nfeweb/sites/nfce/danfeNFCe", DFUnidadeFederativa.GO.getQrCodeProducao());

        Assertions.assertEquals("MA", DFUnidadeFederativa.MA.getCodigo());
        Assertions.assertEquals("21", DFUnidadeFederativa.MA.getCodigoIbge());
        Assertions.assertEquals("http://www.hom.nfce.sefaz.ma.gov.br/portal/consultarNFCe.jsp", DFUnidadeFederativa.MA.getQrCodeHomologacao());
        Assertions.assertEquals("http://www.nfce.sefaz.ma.gov.br/portal/consultarNFCe.jsp", DFUnidadeFederativa.MA.getQrCodeProducao());

        Assertions.assertEquals("MG", DFUnidadeFederativa.MG.getCodigo());
        Assertions.assertEquals("31", DFUnidadeFederativa.MG.getCodigoIbge());
        Assertions.assertEquals("https://hportalsped.fazenda.mg.gov.br/portalnfce", DFUnidadeFederativa.MG.getConsultaChaveAcessoHomologacao());
        Assertions.assertEquals("https://portalsped.fazenda.mg.gov.br/portalnfce", DFUnidadeFederativa.MG.getConsultaChaveAcessoProducao());
        Assertions.assertEquals("https://portalsped.fazenda.mg.gov.br/portalnfce/sistema/qrcode.xhtml", DFUnidadeFederativa.MG.getQrCodeHomologacao());
        Assertions.assertEquals("https://portalsped.fazenda.mg.gov.br/portalnfce/sistema/qrcode.xhtml", DFUnidadeFederativa.MG.getQrCodeProducao());

        Assertions.assertEquals("MS", DFUnidadeFederativa.MS.getCodigo());
        Assertions.assertEquals("50", DFUnidadeFederativa.MS.getCodigoIbge());
        Assertions.assertEquals("http://www.dfe.ms.gov.br/nfce/qrcode", DFUnidadeFederativa.MS.getQrCodeHomologacao());
        Assertions.assertEquals("http://www.dfe.ms.gov.br/nfce/qrcode", DFUnidadeFederativa.MS.getQrCodeProducao());

        Assertions.assertEquals("MT", DFUnidadeFederativa.MT.getCodigo());
        Assertions.assertEquals("51", DFUnidadeFederativa.MT.getCodigoIbge());
        Assertions.assertEquals("http://homologacao.sefaz.mt.gov.br/nfce/consultanfce", DFUnidadeFederativa.MT.getQrCodeHomologacao());
        Assertions.assertEquals("http://www.sefaz.mt.gov.br/nfce/consultanfce", DFUnidadeFederativa.MT.getQrCodeProducao());

        Assertions.assertEquals("PA", DFUnidadeFederativa.PA.getCodigo());
        Assertions.assertEquals("15", DFUnidadeFederativa.PA.getCodigoIbge());
        Assertions.assertEquals("https://appnfc.sefa.pa.gov.br/portal-homologacao/view/consultas/nfce/nfceForm.seam", DFUnidadeFederativa.PA.getQrCodeHomologacao());
        Assertions.assertEquals("https://appnfc.sefa.pa.gov.br/portal/view/consultas/nfce/nfceForm.seam", DFUnidadeFederativa.PA.getQrCodeProducao());

        Assertions.assertEquals("PB", DFUnidadeFederativa.PB.getCodigo());
        Assertions.assertEquals("25", DFUnidadeFederativa.PB.getCodigoIbge());
        Assertions.assertEquals("http://www.sefaz.pb.gov.br/nfcehom", DFUnidadeFederativa.PB.getQrCodeHomologacao());
        Assertions.assertEquals("http://www.sefaz.pb.gov.br/nfce", DFUnidadeFederativa.PB.getQrCodeProducao());

        Assertions.assertEquals("PE", DFUnidadeFederativa.PE.getCodigo());
        Assertions.assertEquals("26", DFUnidadeFederativa.PE.getCodigoIbge());
        Assertions.assertEquals("http://nfcehomolog.sefaz.pe.gov.br/nfce-web/consultarNFCe", DFUnidadeFederativa.PE.getQrCodeHomologacao());
        Assertions.assertEquals("http://nfce.sefaz.pe.gov.br/nfce-web/consultarNFCe", DFUnidadeFederativa.PE.getQrCodeProducao());

        Assertions.assertEquals("PI", DFUnidadeFederativa.PI.getCodigo());
        Assertions.assertEquals("22", DFUnidadeFederativa.PI.getCodigoIbge());
        Assertions.assertEquals("http://www.sefaz.pi.gov.br/nfce/qrcode", DFUnidadeFederativa.PI.getQrCodeHomologacao());
        Assertions.assertEquals("http://www.sefaz.pi.gov.br/nfce/qrcode", DFUnidadeFederativa.PI.getQrCodeProducao());

        Assertions.assertEquals("PR", DFUnidadeFederativa.PR.getCodigo());
        Assertions.assertEquals("41", DFUnidadeFederativa.PR.getCodigoIbge());
        Assertions.assertEquals("http://www.fazenda.pr.gov.br/nfce/qrcode", DFUnidadeFederativa.PR.getQrCodeHomologacao());
        Assertions.assertEquals("http://www.fazenda.pr.gov.br/nfce/qrcode", DFUnidadeFederativa.PR.getQrCodeProducao());

        Assertions.assertEquals("RJ", DFUnidadeFederativa.RJ.getCodigo());
        Assertions.assertEquals("33", DFUnidadeFederativa.RJ.getCodigoIbge());
        Assertions.assertEquals("http://www4.fazenda.rj.gov.br/consultaNFCe/QRCode", DFUnidadeFederativa.RJ.getQrCodeHomologacao());
        Assertions.assertEquals("http://www4.fazenda.rj.gov.br/consultaNFCe/QRCode", DFUnidadeFederativa.RJ.getQrCodeProducao());

        Assertions.assertEquals("RN", DFUnidadeFederativa.RN.getCodigo());
        Assertions.assertEquals("24", DFUnidadeFederativa.RN.getCodigoIbge());
        Assertions.assertEquals("http://hom.nfce.set.rn.gov.br/consultarNFCe.aspx", DFUnidadeFederativa.RN.getQrCodeHomologacao());
        Assertions.assertEquals("http://nfce.set.rn.gov.br/consultarNFCe.aspx", DFUnidadeFederativa.RN.getQrCodeProducao());

        Assertions.assertEquals("RO", DFUnidadeFederativa.RO.getCodigo());
        Assertions.assertEquals("11", DFUnidadeFederativa.RO.getCodigoIbge());
        Assertions.assertEquals("http://www.nfce.sefin.ro.gov.br/consultanfce/consulta.jsp", DFUnidadeFederativa.RO.getQrCodeHomologacao());
        Assertions.assertEquals("http://www.nfce.sefin.ro.gov.br/consultanfce/consulta.jsp", DFUnidadeFederativa.RO.getQrCodeProducao());

        Assertions.assertEquals("RR", DFUnidadeFederativa.RR.getCodigo());
        Assertions.assertEquals("14", DFUnidadeFederativa.RR.getCodigoIbge());
        Assertions.assertEquals("http://200.174.88.103:8080/nfce/servlet/qrcode", DFUnidadeFederativa.RR.getQrCodeHomologacao());
        Assertions.assertEquals("https://www.sefaz.rr.gov.br/nfce/servlet/qrcode", DFUnidadeFederativa.RR.getQrCodeProducao());

        Assertions.assertEquals("RS", DFUnidadeFederativa.RS.getCodigo());
        Assertions.assertEquals("43", DFUnidadeFederativa.RS.getCodigoIbge());
        Assertions.assertEquals("https://www.sefaz.rs.gov.br/NFCE/NFCE-COM.aspx", DFUnidadeFederativa.RS.getQrCodeHomologacao());
        Assertions.assertEquals("https://www.sefaz.rs.gov.br/NFCE/NFCE-COM.aspx", DFUnidadeFederativa.RS.getQrCodeProducao());

        Assertions.assertEquals("SC", DFUnidadeFederativa.SC.getCodigo());
        Assertions.assertEquals("42", DFUnidadeFederativa.SC.getCodigoIbge());
        Assertions.assertEquals("https://hom.sat.sef.sc.gov.br/nfce/consulta", DFUnidadeFederativa.SC.getQrCodeHomologacao());
        Assertions.assertEquals("https://sat.sef.sc.gov.br/nfce/consulta", DFUnidadeFederativa.SC.getQrCodeProducao());

        Assertions.assertEquals("SE", DFUnidadeFederativa.SE.getCodigo());
        Assertions.assertEquals("28", DFUnidadeFederativa.SE.getCodigoIbge());
        Assertions.assertEquals("http://www.hom.nfe.se.gov.br/portal/consultarNFCe.jsp", DFUnidadeFederativa.SE.getQrCodeHomologacao());
        Assertions.assertEquals("http://www.nfce.se.gov.br/portal/consultarNFCe.jsp", DFUnidadeFederativa.SE.getQrCodeProducao());

        Assertions.assertEquals("SP", DFUnidadeFederativa.SP.getCodigo());
        Assertions.assertEquals("35", DFUnidadeFederativa.SP.getCodigoIbge());
        Assertions.assertEquals("https://www.homologacao.nfce.fazenda.sp.gov.br/NFCeConsultaPublica/Paginas/ConsultaQRCode.aspx", DFUnidadeFederativa.SP.getQrCodeHomologacao());
        Assertions.assertEquals("https://www.nfce.fazenda.sp.gov.br/NFCeConsultaPublica/Paginas/ConsultaQRCode.aspx", DFUnidadeFederativa.SP.getQrCodeProducao());

        Assertions.assertEquals("TO", DFUnidadeFederativa.TO.getCodigo());
        Assertions.assertEquals("17", DFUnidadeFederativa.TO.getCodigoIbge());
        Assertions.assertEquals("http://homologacao.sefaz.to.gov.br/nfce/qrcode", DFUnidadeFederativa.TO.getQrCodeHomologacao());
        Assertions.assertEquals("http://www.sefaz.to.gov.br/nfce/qrcode", DFUnidadeFederativa.TO.getQrCodeProducao());

        Assertions.assertEquals("NC", DFUnidadeFederativa.NACIONAL.getCodigo());
        Assertions.assertEquals("90", DFUnidadeFederativa.NACIONAL.getCodigoIbge());
        Assertions.assertNull(DFUnidadeFederativa.NACIONAL.getQrCodeHomologacao());
        Assertions.assertNull(DFUnidadeFederativa.NACIONAL.getQrCodeProducao());

        Assertions.assertEquals("RFB", DFUnidadeFederativa.RFB.getCodigo());
        Assertions.assertEquals("91", DFUnidadeFederativa.RFB.getCodigoIbge());
        Assertions.assertNull(DFUnidadeFederativa.RFB.getQrCodeHomologacao());
        Assertions.assertNull(DFUnidadeFederativa.RFB.getQrCodeProducao());

        Assertions.assertEquals("EX", DFUnidadeFederativa.EX.getCodigo());
        Assertions.assertEquals("99", DFUnidadeFederativa.EX.getCodigoIbge());
        Assertions.assertNull(DFUnidadeFederativa.EX.getQrCodeHomologacao());
        Assertions.assertNull(DFUnidadeFederativa.EX.getQrCodeProducao());
    }

    @Test
    public void deveLancarExcecaoCasoTenteBuscarUmCodigoErrado() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> DFUnidadeFederativa.valueOfCodigo("1"));
    }

    @Test
    public void deveSerADescricaoAoInvocaarToString() {
        Assertions.assertEquals("Santa Catarina", DFUnidadeFederativa.SC.toString());
        Assertions.assertEquals("Rio Grande do Sul", DFUnidadeFederativa.RS.toString());
    }

    @Test
    public void deveObterAtravesDaSiglaAUF() {
        Assertions.assertEquals(DFUnidadeFederativa.AC, DFUnidadeFederativa.valueOfCodigo("AC"));
        Assertions.assertEquals(DFUnidadeFederativa.AL, DFUnidadeFederativa.valueOfCodigo("AL"));
        Assertions.assertEquals(DFUnidadeFederativa.AM, DFUnidadeFederativa.valueOfCodigo("AM"));
        Assertions.assertEquals(DFUnidadeFederativa.AP, DFUnidadeFederativa.valueOfCodigo("AP"));
        Assertions.assertEquals(DFUnidadeFederativa.BA, DFUnidadeFederativa.valueOfCodigo("BA"));
        Assertions.assertEquals(DFUnidadeFederativa.CE, DFUnidadeFederativa.valueOfCodigo("CE"));
        Assertions.assertEquals(DFUnidadeFederativa.DF, DFUnidadeFederativa.valueOfCodigo("DF"));
        Assertions.assertEquals(DFUnidadeFederativa.ES, DFUnidadeFederativa.valueOfCodigo("ES"));
        Assertions.assertEquals(DFUnidadeFederativa.EX, DFUnidadeFederativa.valueOfCodigo("EX"));
        Assertions.assertEquals(DFUnidadeFederativa.GO, DFUnidadeFederativa.valueOfCodigo("GO"));
        Assertions.assertEquals(DFUnidadeFederativa.MA, DFUnidadeFederativa.valueOfCodigo("MA"));
        Assertions.assertEquals(DFUnidadeFederativa.MG, DFUnidadeFederativa.valueOfCodigo("MG"));
        Assertions.assertEquals(DFUnidadeFederativa.MS, DFUnidadeFederativa.valueOfCodigo("MS"));
        Assertions.assertEquals(DFUnidadeFederativa.MT, DFUnidadeFederativa.valueOfCodigo("MT"));
        Assertions.assertEquals(DFUnidadeFederativa.NACIONAL, DFUnidadeFederativa.valueOfCodigo("NC"));
        Assertions.assertEquals(DFUnidadeFederativa.PA, DFUnidadeFederativa.valueOfCodigo("PA"));
        Assertions.assertEquals(DFUnidadeFederativa.PB, DFUnidadeFederativa.valueOfCodigo("PB"));
        Assertions.assertEquals(DFUnidadeFederativa.PE, DFUnidadeFederativa.valueOfCodigo("PE"));
        Assertions.assertEquals(DFUnidadeFederativa.PI, DFUnidadeFederativa.valueOfCodigo("PI"));
        Assertions.assertEquals(DFUnidadeFederativa.PR, DFUnidadeFederativa.valueOfCodigo("PR"));
        Assertions.assertEquals(DFUnidadeFederativa.RFB, DFUnidadeFederativa.valueOfCodigo("RFB"));
        Assertions.assertEquals(DFUnidadeFederativa.RJ, DFUnidadeFederativa.valueOfCodigo("RJ"));
        Assertions.assertEquals(DFUnidadeFederativa.RN, DFUnidadeFederativa.valueOfCodigo("RN"));
        Assertions.assertEquals(DFUnidadeFederativa.RO, DFUnidadeFederativa.valueOfCodigo("RO"));
        Assertions.assertEquals(DFUnidadeFederativa.RR, DFUnidadeFederativa.valueOfCodigo("RR"));
        Assertions.assertEquals(DFUnidadeFederativa.RS, DFUnidadeFederativa.valueOfCodigo("RS"));
        Assertions.assertEquals(DFUnidadeFederativa.SC, DFUnidadeFederativa.valueOfCodigo("SC"));
        Assertions.assertEquals(DFUnidadeFederativa.SE, DFUnidadeFederativa.valueOfCodigo("SE"));
        Assertions.assertEquals(DFUnidadeFederativa.SP, DFUnidadeFederativa.valueOfCodigo("SP"));
        Assertions.assertEquals(DFUnidadeFederativa.TO, DFUnidadeFederativa.valueOfCodigo("TO"));
    }
}
