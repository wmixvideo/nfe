package com.fincatto.documentofiscal.nfe400.webservices;

import java.util.Collections;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe400.NFeConfigFake;
import com.fincatto.documentofiscal.nfe400.classes.evento.conciliacaofinanceira.NFDetPagEconf;
import com.fincatto.documentofiscal.nfe400.classes.evento.conciliacaofinanceira.NFEnviaEventoEconf;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFOperadoraCartao;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

public class WSEconfTest {

    private static final String CHAVE_NFE = "35261072834992000163550010000001231000000010";
    private static final String CHAVE_NFCE = "35261072834992000163650010000001231000000010";

    // o XSD exige o grupo ds:Signature no evento; este é um bloco ficticio, sem certificado real
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
        final WSEconf wsEconf = new WSEconf(new NFeConfigFake(), null);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> wsEconf.gerarDadosXml(CHAVE_NFCE, 1, Collections.singletonList(FabricaDeObjetosFake.getNFDetPagEconf())));
    }

    @Test
    public void naoDevePermitirChaveInvalida() {
        final WSEconf wsEconf = new WSEconf(new NFeConfigFake(), null);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> wsEconf.gerarDadosXml("65", 1, Collections.singletonList(FabricaDeObjetosFake.getNFDetPagEconf())));
    }

    @Test
    public void deveGerarEnvelopeComVersaoDoLayout() {
        final NFEnviaEventoEconf envio = this.gerarEnvio(FabricaDeObjetosFake.getNFDetPagEconf());
        Assertions.assertEquals("1.00", envio.getVersao());
        Assertions.assertEquals("1.00", envio.getEvento().get(0).getVersao());
        Assertions.assertNotNull(envio.getIdLote());
    }

    @Test
    public void deveEnviarParaASVRSComOrgao92() {
        final NFEnviaEventoEconf envio = this.gerarEnvio(FabricaDeObjetosFake.getNFDetPagEconf());
        Assertions.assertEquals(DFUnidadeFederativa.BRID, envio.getEvento().get(0).getInfoEvento().getOrgao());
        Assertions.assertTrue(envio.toString().contains("<cOrgao>92</cOrgao>"));
    }

    @Test
    public void deveGerarIdDoEventoComCodigoChaveESequencial() {
        final NFEnviaEventoEconf envio = this.gerarEnvio(FabricaDeObjetosFake.getNFDetPagEconf());
        Assertions.assertEquals("ID110750" + CHAVE_NFE + "01", envio.getEvento().get(0).getInfoEvento().getId());
        Assertions.assertEquals("110750", envio.getEvento().get(0).getInfoEvento().getCodigoEvento());
    }

    @Test
    public void deveGerarXMLValidoNoXSD() throws Exception {
        final NFEnviaEventoEconf envio = this.gerarEnvio(FabricaDeObjetosFake.getNFDetPagEconf());
        Assertions.assertTrue(DFXMLValidador.validaEconf(this.comAssinaturaFicticia(envio)));
    }

    @Test
    public void naoDeveGerarXMLValidoComBandeirasSemCnpjTransacional() {
        final NFDetPagEconf pagamento = FabricaDeObjetosFake.getNFDetPagEconf().setOperadoraCartao(NFOperadoraCartao.ELO);
        final NFEnviaEventoEconf envio = this.gerarEnvio(pagamento);
        Assertions.assertThrows(SAXException.class, () -> DFXMLValidador.validaEconf(this.comAssinaturaFicticia(envio)));
    }

    private NFEnviaEventoEconf gerarEnvio(final NFDetPagEconf pagamento) {
        return new WSEconf(new NFeConfigFake(), null)
                .gerarDadosXml(CHAVE_NFE, 1, Collections.singletonList(pagamento));
    }

    private String comAssinaturaFicticia(final NFEnviaEventoEconf envio) {
        return envio.toString().replace("</infEvento>", "</infEvento>" + ASSINATURA_FICTICIA);
    }

}
