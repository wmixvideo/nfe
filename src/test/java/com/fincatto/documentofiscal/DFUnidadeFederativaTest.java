package com.fincatto.documentofiscal;

import org.junit.Assert;
import org.junit.Test;

public class DFUnidadeFederativaTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	
        Assert.assertEquals("AC", DFUnidadeFederativa.AC.getCodigo());
        Assert.assertEquals("12", DFUnidadeFederativa.AC.getCodigoIbge());
        Assert.assertEquals("http://hml.sefaznet.ac.gov.br/nfce/qrcode", DFUnidadeFederativa.AC.getQrCodeHomologacao());
        Assert.assertEquals("http://www.sefaznet.ac.gov.br/nfce/qrcode", DFUnidadeFederativa.AC.getQrCodeProducao());

        Assert.assertEquals("AL", DFUnidadeFederativa.AL.getCodigo());
        Assert.assertEquals("27", DFUnidadeFederativa.AL.getCodigoIbge());
        Assert.assertEquals("http://nfce.sefaz.al.gov.br/QRCode/consultarNFCe.jsp", DFUnidadeFederativa.AL.getQrCodeHomologacao());
        Assert.assertEquals("http://nfce.sefaz.al.gov.br/QRCode/consultarNFCe.jsp", DFUnidadeFederativa.AL.getQrCodeProducao());


        Assert.assertEquals("AM", DFUnidadeFederativa.AM.getCodigo());
        Assert.assertEquals("13", DFUnidadeFederativa.AM.getCodigoIbge());
        Assert.assertEquals("http://homnfce.sefaz.am.gov.br/nfceweb/consultarNFCe.jsp", DFUnidadeFederativa.AM.getQrCodeHomologacao());
        Assert.assertEquals("http://sistemas.sefaz.am.gov.br/nfceweb/consultarNFCe.jsp", DFUnidadeFederativa.AM.getQrCodeProducao());

        Assert.assertEquals("AP", DFUnidadeFederativa.AP.getCodigo());
        Assert.assertEquals("16", DFUnidadeFederativa.AP.getCodigoIbge());
        Assert.assertEquals("https://www.sefaz.ap.gov.br/nfcehml/nfce.php", DFUnidadeFederativa.AP.getQrCodeHomologacao());
        Assert.assertEquals("https://www.sefaz.ap.gov.br/nfce/nfce.php", DFUnidadeFederativa.AP.getQrCodeProducao());

        Assert.assertEquals("BA", DFUnidadeFederativa.BA.getCodigo());
        Assert.assertEquals("29", DFUnidadeFederativa.BA.getCodigoIbge());
        Assert.assertEquals("http://hnfe.sefaz.ba.gov.br/servicos/nfce/modulos/geral/NFCEC_consulta_chave_acesso.aspx", DFUnidadeFederativa.BA.getQrCodeHomologacao());
        Assert.assertEquals("http://nfe.sefaz.ba.gov.br/servicos/nfce/modulos/geral/NFCEC_consulta_chave_acesso.aspx", DFUnidadeFederativa.BA.getQrCodeProducao());

        Assert.assertEquals("CE", DFUnidadeFederativa.CE.getCodigo());
        Assert.assertEquals("23", DFUnidadeFederativa.CE.getCodigoIbge());
        Assert.assertEquals("http://nfceh.sefaz.ce.gov.br/pages/ShowNFCe.html", DFUnidadeFederativa.CE.getQrCodeHomologacao());
        Assert.assertEquals("http://nfce.sefaz.ce.gov.br/pages/ShowNFCe.html", DFUnidadeFederativa.CE.getQrCodeProducao());

        Assert.assertEquals("DF", DFUnidadeFederativa.DF.getCodigo());
        Assert.assertEquals("53", DFUnidadeFederativa.DF.getCodigoIbge());
        Assert.assertEquals("http://dec.fazenda.df.gov.br/ConsultarNFCe.aspx", DFUnidadeFederativa.DF.getQrCodeHomologacao());
        Assert.assertEquals("http://dec.fazenda.df.gov.br/ConsultarNFCe.aspx", DFUnidadeFederativa.DF.getQrCodeProducao());

        Assert.assertEquals("ES", DFUnidadeFederativa.ES.getCodigo());
        Assert.assertEquals("32", DFUnidadeFederativa.ES.getCodigoIbge());
        Assert.assertEquals("http://homologacao.sefaz.es.gov.br/ConsultaNFCe/qrcode.aspx", DFUnidadeFederativa.ES.getQrCodeHomologacao());
        Assert.assertEquals("http://app.sefaz.es.gov.br/ConsultaNFCe/qrcode.aspx", DFUnidadeFederativa.ES.getQrCodeProducao());

        Assert.assertEquals("GO", DFUnidadeFederativa.GO.getCodigo());
        Assert.assertEquals("52", DFUnidadeFederativa.GO.getCodigoIbge());
        Assert.assertEquals("https://nfewebhomolog.sefaz.go.gov.br/nfeweb/sites/nfce/danfeNFCe", DFUnidadeFederativa.GO.getQrCodeHomologacao());
        Assert.assertEquals("https://nfeweb.sefaz.go.gov.br/nfeweb/sites/nfce/danfeNFCe", DFUnidadeFederativa.GO.getQrCodeProducao());

        Assert.assertEquals("MA", DFUnidadeFederativa.MA.getCodigo());
        Assert.assertEquals("21", DFUnidadeFederativa.MA.getCodigoIbge());
        Assert.assertEquals("http://www.hom.nfce.sefaz.ma.gov.br/portal/consultarNFCe.jsp", DFUnidadeFederativa.MA.getQrCodeHomologacao());
        Assert.assertEquals("http://www.nfce.sefaz.ma.gov.br/portal/consultarNFCe.jsp", DFUnidadeFederativa.MA.getQrCodeProducao());

        Assert.assertEquals("MG", DFUnidadeFederativa.MG.getCodigo());
        Assert.assertEquals("31", DFUnidadeFederativa.MG.getCodigoIbge());
        Assert.assertEquals("https://hportalsped.fazenda.mg.gov.br/portalnfce", DFUnidadeFederativa.MG.getConsultaChaveAcessoHomologacao());
        Assert.assertEquals("https://portalsped.fazenda.mg.gov.br/portalnfce", DFUnidadeFederativa.MG.getConsultaChaveAcessoProducao());
        Assert.assertEquals("https://portalsped.fazenda.mg.gov.br/portalnfce/sistema/qrcode.xhtml", DFUnidadeFederativa.MG.getQrCodeHomologacao());
        Assert.assertEquals("https://portalsped.fazenda.mg.gov.br/portalnfce/sistema/qrcode.xhtml", DFUnidadeFederativa.MG.getQrCodeProducao());

        Assert.assertEquals("MS", DFUnidadeFederativa.MS.getCodigo());
        Assert.assertEquals("50", DFUnidadeFederativa.MS.getCodigoIbge());
        Assert.assertEquals("http://www.dfe.ms.gov.br/nfce/qrcode", DFUnidadeFederativa.MS.getQrCodeHomologacao());
        Assert.assertEquals("http://www.dfe.ms.gov.br/nfce/qrcode", DFUnidadeFederativa.MS.getQrCodeProducao());

        Assert.assertEquals("MT", DFUnidadeFederativa.MT.getCodigo());
        Assert.assertEquals("51", DFUnidadeFederativa.MT.getCodigoIbge());
        Assert.assertEquals("http://homologacao.sefaz.mt.gov.br/nfce/consultanfce", DFUnidadeFederativa.MT.getQrCodeHomologacao());
        Assert.assertEquals("http://www.sefaz.mt.gov.br/nfce/consultanfce", DFUnidadeFederativa.MT.getQrCodeProducao());

        Assert.assertEquals("PA", DFUnidadeFederativa.PA.getCodigo());
        Assert.assertEquals("15", DFUnidadeFederativa.PA.getCodigoIbge());
        Assert.assertEquals("https://appnfc.sefa.pa.gov.br/portal-homologacao/view/consultas/nfce/nfceForm.seam", DFUnidadeFederativa.PA.getQrCodeHomologacao());
        Assert.assertEquals("https://appnfc.sefa.pa.gov.br/portal/view/consultas/nfce/nfceForm.seam", DFUnidadeFederativa.PA.getQrCodeProducao());

        Assert.assertEquals("PB", DFUnidadeFederativa.PB.getCodigo());
        Assert.assertEquals("25", DFUnidadeFederativa.PB.getCodigoIbge());
        Assert.assertEquals("http://www.sefaz.pb.gov.br/nfcehom", DFUnidadeFederativa.PB.getQrCodeHomologacao());
        Assert.assertEquals("http://www.sefaz.pb.gov.br/nfce", DFUnidadeFederativa.PB.getQrCodeProducao());

        Assert.assertEquals("PE", DFUnidadeFederativa.PE.getCodigo());
        Assert.assertEquals("26", DFUnidadeFederativa.PE.getCodigoIbge());
        Assert.assertEquals("http://nfcehomolog.sefaz.pe.gov.br/nfce-web/consultarNFCe", DFUnidadeFederativa.PE.getQrCodeHomologacao());
        Assert.assertEquals("http://nfce.sefaz.pe.gov.br/nfce-web/consultarNFCe", DFUnidadeFederativa.PE.getQrCodeProducao());

        Assert.assertEquals("PI", DFUnidadeFederativa.PI.getCodigo());
        Assert.assertEquals("22", DFUnidadeFederativa.PI.getCodigoIbge());
        Assert.assertEquals("http://www.sefaz.pi.gov.br/nfce/qrcode", DFUnidadeFederativa.PI.getQrCodeHomologacao());
        Assert.assertEquals("http://www.sefaz.pi.gov.br/nfce/qrcode", DFUnidadeFederativa.PI.getQrCodeProducao());

        Assert.assertEquals("PR", DFUnidadeFederativa.PR.getCodigo());
        Assert.assertEquals("41", DFUnidadeFederativa.PR.getCodigoIbge());
        Assert.assertEquals("http://www.fazenda.pr.gov.br/nfce/qrcode", DFUnidadeFederativa.PR.getQrCodeHomologacao());
        Assert.assertEquals("http://www.fazenda.pr.gov.br/nfce/qrcode", DFUnidadeFederativa.PR.getQrCodeProducao());

        Assert.assertEquals("RJ", DFUnidadeFederativa.RJ.getCodigo());
        Assert.assertEquals("33", DFUnidadeFederativa.RJ.getCodigoIbge());
        Assert.assertEquals("http://www4.fazenda.rj.gov.br/consultaNFCe/QRCode", DFUnidadeFederativa.RJ.getQrCodeHomologacao());
        Assert.assertEquals("http://www4.fazenda.rj.gov.br/consultaNFCe/QRCode", DFUnidadeFederativa.RJ.getQrCodeProducao());

        Assert.assertEquals("RN", DFUnidadeFederativa.RN.getCodigo());
        Assert.assertEquals("24", DFUnidadeFederativa.RN.getCodigoIbge());
        Assert.assertEquals("http://hom.nfce.set.rn.gov.br/consultarNFCe.aspx", DFUnidadeFederativa.RN.getQrCodeHomologacao());
        Assert.assertEquals("http://nfce.set.rn.gov.br/consultarNFCe.aspx", DFUnidadeFederativa.RN.getQrCodeProducao());

        Assert.assertEquals("RO", DFUnidadeFederativa.RO.getCodigo());
        Assert.assertEquals("11", DFUnidadeFederativa.RO.getCodigoIbge());
        Assert.assertEquals("http://www.nfce.sefin.ro.gov.br/consultanfce/consulta.jsp", DFUnidadeFederativa.RO.getQrCodeHomologacao());
        Assert.assertEquals("http://www.nfce.sefin.ro.gov.br/consultanfce/consulta.jsp", DFUnidadeFederativa.RO.getQrCodeProducao());

        Assert.assertEquals("RR", DFUnidadeFederativa.RR.getCodigo());
        Assert.assertEquals("14", DFUnidadeFederativa.RR.getCodigoIbge());
        Assert.assertEquals("http://200.174.88.103:8080/nfce/servlet/qrcode", DFUnidadeFederativa.RR.getQrCodeHomologacao());
        Assert.assertEquals("https://www.sefaz.rr.gov.br/nfce/servlet/qrcode", DFUnidadeFederativa.RR.getQrCodeProducao());

        Assert.assertEquals("RS", DFUnidadeFederativa.RS.getCodigo());
        Assert.assertEquals("43", DFUnidadeFederativa.RS.getCodigoIbge());
        Assert.assertEquals("https://www.sefaz.rs.gov.br/NFCE/NFCE-COM.aspx", DFUnidadeFederativa.RS.getQrCodeHomologacao());
        Assert.assertEquals("https://www.sefaz.rs.gov.br/NFCE/NFCE-COM.aspx", DFUnidadeFederativa.RS.getQrCodeProducao());

        Assert.assertEquals("SC", DFUnidadeFederativa.SC.getCodigo());
        Assert.assertEquals("42", DFUnidadeFederativa.SC.getCodigoIbge());
        Assert.assertEquals("https://hom.sat.sef.sc.gov.br/nfce/consulta", DFUnidadeFederativa.SC.getQrCodeHomologacao());
        Assert.assertEquals("https://sat.sef.sc.gov.br/nfce/consulta", DFUnidadeFederativa.SC.getQrCodeProducao());

        Assert.assertEquals("SE", DFUnidadeFederativa.SE.getCodigo());
        Assert.assertEquals("28", DFUnidadeFederativa.SE.getCodigoIbge());
        Assert.assertEquals("http://www.hom.nfe.se.gov.br/portal/consultarNFCe.jsp", DFUnidadeFederativa.SE.getQrCodeHomologacao());
        Assert.assertEquals("http://www.nfce.se.gov.br/portal/consultarNFCe.jsp", DFUnidadeFederativa.SE.getQrCodeProducao());

        Assert.assertEquals("SP", DFUnidadeFederativa.SP.getCodigo());
        Assert.assertEquals("35", DFUnidadeFederativa.SP.getCodigoIbge());
        Assert.assertEquals("https://www.homologacao.nfce.fazenda.sp.gov.br/NFCeConsultaPublica/Paginas/ConsultaQRCode.aspx", DFUnidadeFederativa.SP.getQrCodeHomologacao());
        Assert.assertEquals("https://www.nfce.fazenda.sp.gov.br/NFCeConsultaPublica/Paginas/ConsultaQRCode.aspx", DFUnidadeFederativa.SP.getQrCodeProducao());

        Assert.assertEquals("TO", DFUnidadeFederativa.TO.getCodigo());
        Assert.assertEquals("17", DFUnidadeFederativa.TO.getCodigoIbge());
        Assert.assertEquals("http://homologacao.sefaz.to.gov.br/nfce/qrcode", DFUnidadeFederativa.TO.getQrCodeHomologacao());
        Assert.assertEquals("http://www.sefaz.to.gov.br/nfce/qrcode", DFUnidadeFederativa.TO.getQrCodeProducao());

        Assert.assertEquals("NC", DFUnidadeFederativa.NACIONAL.getCodigo());
        Assert.assertEquals("90", DFUnidadeFederativa.NACIONAL.getCodigoIbge());
        Assert.assertNull(DFUnidadeFederativa.NACIONAL.getQrCodeHomologacao());
        Assert.assertNull(DFUnidadeFederativa.NACIONAL.getQrCodeProducao());

        Assert.assertEquals("RFB", DFUnidadeFederativa.RFB.getCodigo());
        Assert.assertEquals("91", DFUnidadeFederativa.RFB.getCodigoIbge());
        Assert.assertNull(DFUnidadeFederativa.RFB.getQrCodeHomologacao());
        Assert.assertNull(DFUnidadeFederativa.RFB.getQrCodeProducao());

        Assert.assertEquals("EX", DFUnidadeFederativa.EX.getCodigo());
        Assert.assertEquals("99", DFUnidadeFederativa.EX.getCodigoIbge());
        Assert.assertNull(DFUnidadeFederativa.EX.getQrCodeHomologacao());
        Assert.assertNull(DFUnidadeFederativa.EX.getQrCodeProducao());
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoCasoTenteBuscarUmCodigoErrado() {
        DFUnidadeFederativa.valueOfCodigo("1");
    }

    @Test
    public void deveSerADescricaoAoInvocaarToString() {
        Assert.assertEquals("Santa Catarina", DFUnidadeFederativa.SC.toString());
        Assert.assertEquals("Rio Grande do Sul", DFUnidadeFederativa.RS.toString());
    }

    @Test
    public void deveObterAtravesDaSiglaAUF() {
        Assert.assertEquals(DFUnidadeFederativa.AC, DFUnidadeFederativa.valueOfCodigo("AC"));
        Assert.assertEquals(DFUnidadeFederativa.AL, DFUnidadeFederativa.valueOfCodigo("AL"));
        Assert.assertEquals(DFUnidadeFederativa.AM, DFUnidadeFederativa.valueOfCodigo("AM"));
        Assert.assertEquals(DFUnidadeFederativa.AP, DFUnidadeFederativa.valueOfCodigo("AP"));
        Assert.assertEquals(DFUnidadeFederativa.BA, DFUnidadeFederativa.valueOfCodigo("BA"));
        Assert.assertEquals(DFUnidadeFederativa.CE, DFUnidadeFederativa.valueOfCodigo("CE"));
        Assert.assertEquals(DFUnidadeFederativa.DF, DFUnidadeFederativa.valueOfCodigo("DF"));
        Assert.assertEquals(DFUnidadeFederativa.ES, DFUnidadeFederativa.valueOfCodigo("ES"));
        Assert.assertEquals(DFUnidadeFederativa.EX, DFUnidadeFederativa.valueOfCodigo("EX"));
        Assert.assertEquals(DFUnidadeFederativa.GO, DFUnidadeFederativa.valueOfCodigo("GO"));
        Assert.assertEquals(DFUnidadeFederativa.MA, DFUnidadeFederativa.valueOfCodigo("MA"));
        Assert.assertEquals(DFUnidadeFederativa.MG, DFUnidadeFederativa.valueOfCodigo("MG"));
        Assert.assertEquals(DFUnidadeFederativa.MS, DFUnidadeFederativa.valueOfCodigo("MS"));
        Assert.assertEquals(DFUnidadeFederativa.MT, DFUnidadeFederativa.valueOfCodigo("MT"));
        Assert.assertEquals(DFUnidadeFederativa.NACIONAL, DFUnidadeFederativa.valueOfCodigo("NC"));
        Assert.assertEquals(DFUnidadeFederativa.PA, DFUnidadeFederativa.valueOfCodigo("PA"));
        Assert.assertEquals(DFUnidadeFederativa.PB, DFUnidadeFederativa.valueOfCodigo("PB"));
        Assert.assertEquals(DFUnidadeFederativa.PE, DFUnidadeFederativa.valueOfCodigo("PE"));
        Assert.assertEquals(DFUnidadeFederativa.PI, DFUnidadeFederativa.valueOfCodigo("PI"));
        Assert.assertEquals(DFUnidadeFederativa.PR, DFUnidadeFederativa.valueOfCodigo("PR"));
        Assert.assertEquals(DFUnidadeFederativa.RFB, DFUnidadeFederativa.valueOfCodigo("RFB"));
        Assert.assertEquals(DFUnidadeFederativa.RJ, DFUnidadeFederativa.valueOfCodigo("RJ"));
        Assert.assertEquals(DFUnidadeFederativa.RN, DFUnidadeFederativa.valueOfCodigo("RN"));
        Assert.assertEquals(DFUnidadeFederativa.RO, DFUnidadeFederativa.valueOfCodigo("RO"));
        Assert.assertEquals(DFUnidadeFederativa.RR, DFUnidadeFederativa.valueOfCodigo("RR"));
        Assert.assertEquals(DFUnidadeFederativa.RS, DFUnidadeFederativa.valueOfCodigo("RS"));
        Assert.assertEquals(DFUnidadeFederativa.SC, DFUnidadeFederativa.valueOfCodigo("SC"));
        Assert.assertEquals(DFUnidadeFederativa.SE, DFUnidadeFederativa.valueOfCodigo("SE"));
        Assert.assertEquals(DFUnidadeFederativa.SP, DFUnidadeFederativa.valueOfCodigo("SP"));
        Assert.assertEquals(DFUnidadeFederativa.TO, DFUnidadeFederativa.valueOfCodigo("TO"));
    }
}
