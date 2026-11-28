package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe400.NFeConfigFake;
import com.fincatto.documentofiscal.nfe400.classes.evento.conciliacaofinanceira.NFEnviaEventoCancelamentoEconf;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

public class WSCancelamentoEconfTest {

    private static final String CHAVE_NFE = "35261072834992000163550010000001231000000010";
    private static final String CHAVE_NFCE = "35261072834992000163650010000001231000000010";
    private static final String PROTOCOLO_ECONF = "135260000012345";

    // o XSD exige o grupo ds:Signature no evento; este e um bloco ficticio, sem certificado real
    private static final String ASSINATURA_FICTICIA = "<Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\">" +
            "<SignedInfo>" +
            "<CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/>" +
            "<SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/>" +
            "<Reference URI=\"#ID\">" +
            "<Transforms>" +
            "<Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/>" +
            "<Transform Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/>" +
            "</Transforms>" +
            "<DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/>" +
            "<DigestValue>yzGYhUx1/XYYzksWB+fPR3Qc50c=</DigestValue>" +
            "</Reference>" +
            "</SignedInfo>" +
            "<SignatureValue>AAAA</SignatureValue>" +
            "<KeyInfo><X509Data><X509Certificate>AAAA</X509Certificate></X509Data></KeyInfo>" +
            "</Signature>";

    @Test
    public void naoDevePermitirChaveDeNFCe() {
        final WSCancelamentoEconf wsCancelamentoEconf = new WSCancelamentoEconf(new NFeConfigFake(), null);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> wsCancelamentoEconf.gerarDadosXml(CHAVE_NFCE, 1, PROTOCOLO_ECONF));
    }

    @Test
    public void naoDevePermitirChaveInvalida() {
        final WSCancelamentoEconf wsCancelamentoEconf = new WSCancelamentoEconf(new NFeConfigFake(), null);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> wsCancelamentoEconf.gerarDadosXml("65", 1, PROTOCOLO_ECONF));
    }

    @Test
    public void naoDevePermitirProtocoloDoEconfInvalido() {
        final WSCancelamentoEconf wsCancelamentoEconf = new WSCancelamentoEconf(new NFeConfigFake(), null);
        Assertions.assertThrows(IllegalStateException.class, () -> wsCancelamentoEconf.gerarDadosXml(CHAVE_NFE, 1, "123"));
    }

    @Test
    public void deveGerarEnvelopeComVersaoDoLayout() {
        final NFEnviaEventoCancelamentoEconf envio = this.gerarEnvio();
        Assertions.assertEquals("1.00", envio.getVersao());
        Assertions.assertEquals("1.00", envio.getEvento().get(0).getVersao());
        Assertions.assertNotNull(envio.getIdLote());
    }

    @Test
    public void deveEnviarParaASVRSComOrgao92() {
        final NFEnviaEventoCancelamentoEconf envio = this.gerarEnvio();
        Assertions.assertEquals(DFUnidadeFederativa.BRID, envio.getEvento().get(0).getInfoEvento().getOrgao());
        Assertions.assertTrue(envio.toString().contains("<cOrgao>92</cOrgao>"));
    }

    @Test
    public void deveGerarIdDoEventoComCodigoChaveESequencial() {
        final NFEnviaEventoCancelamentoEconf envio = this.gerarEnvio();
        Assertions.assertEquals("ID110751" + CHAVE_NFE + "01", envio.getEvento().get(0).getInfoEvento().getId());
        Assertions.assertEquals("110751", envio.getEvento().get(0).getInfoEvento().getCodigoEvento());
    }

    @Test
    public void deveInformarOProtocoloDoEconfCancelado() {
        final NFEnviaEventoCancelamentoEconf envio = this.gerarEnvio();
        Assertions.assertEquals(PROTOCOLO_ECONF, envio.getEvento().get(0).getInfoEvento().getDetalhesEvento().getNumeroProtocoloEvento());
    }

    @Test
    public void deveInformarADescricaoDoEvento() {
        final NFEnviaEventoCancelamentoEconf envio = this.gerarEnvio();
        Assertions.assertTrue(envio.toString().contains("<descEvento>Cancelamento Conciliação Financeira</descEvento>"));
    }

    @Test
    public void deveGerarXMLValidoNoXSD() throws Exception {
        final NFEnviaEventoCancelamentoEconf envio = this.gerarEnvio();
        final String xmlComAssinatura = envio.toString().replace("</infEvento>", "</infEvento>" + ASSINATURA_FICTICIA);
        Assertions.assertTrue(DFXMLValidador.validaCancelamentoEconf(xmlComAssinatura));
    }

    @Test
    public void naoDeveGerarXMLValidoSemAssinatura() {
        final NFEnviaEventoCancelamentoEconf envio = this.gerarEnvio();
        Assertions.assertThrows(SAXException.class, () -> DFXMLValidador.validaCancelamentoEconf(envio.toString()));
    }

    private NFEnviaEventoCancelamentoEconf gerarEnvio() {
        return new WSCancelamentoEconf(new NFeConfigFake(), null)
                .gerarDadosXml(CHAVE_NFE, 1, PROTOCOLO_ECONF);
    }

}
