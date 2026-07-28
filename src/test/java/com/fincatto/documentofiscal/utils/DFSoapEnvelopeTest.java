package com.fincatto.documentofiscal.utils;

import org.junit.Assert;
import org.junit.Test;

public class DFSoapEnvelopeTest {

    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4";

    @Test
    public void deveEnveloparXmlDeNegocioDentroDoWrapperNoSoapBody() {
        final String xmlNegocio = "<consStatServ xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"4.00\"><tpAmb>2</tpAmb></consStatServ>";

        final String envelope = DFSoapEnvelope.envelopar(NAMESPACE_WSDL, "nfeDadosMsg", xmlNegocio);

        Assert.assertTrue(envelope.startsWith("<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\">"));
        Assert.assertTrue(envelope.contains("<soap:Body>"));
        Assert.assertTrue(envelope.contains("<nfeDadosMsg xmlns=\"" + NAMESPACE_WSDL + "\">"));
        Assert.assertTrue(envelope.contains(xmlNegocio));
        Assert.assertTrue(envelope.contains("</nfeDadosMsg>"));
        Assert.assertTrue(envelope.endsWith("</soap:Body></soap:Envelope>"));
    }

    @Test
    public void deveDesempacotarXmlDeNegocioDaRespostaComSucesso() throws DFSoapFaultException {
        final String respostaSefaz = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\">"
                + "<soap:Body>"
                + "<nfeResultMsg xmlns=\"" + NAMESPACE_WSDL + "\">"
                + "<retConsStatServ xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"4.00\">"
                + "<tpAmb>2</tpAmb>"
                + "<cStat>107</cStat>"
                + "<xMotivo>Servico em Operacao</xMotivo>"
                + "</retConsStatServ>"
                + "</nfeResultMsg>"
                + "</soap:Body>"
                + "</soap:Envelope>";

        final String xmlNegocio = DFSoapEnvelope.desempacotar(respostaSefaz);

        Assert.assertTrue(xmlNegocio.startsWith("<retConsStatServ"));
        Assert.assertTrue(xmlNegocio.contains("<cStat>107</cStat>"));
        Assert.assertTrue(xmlNegocio.contains("<xMotivo>Servico em Operacao</xMotivo>"));
        Assert.assertFalse("nao deve sobrar o wrapper nfeResultMsg no resultado", xmlNegocio.contains("nfeResultMsg"));
    }

    @Test
    public void deveLancarDFSoapFaultExceptionComOMotivoQuandoRespostaForFault() {
        final String respostaComFault = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\">"
                + "<soap:Body>"
                + "<soap:Fault>"
                + "<soap:Code><soap:Value>soap:Receiver</soap:Value></soap:Code>"
                + "<soap:Reason><soap:Text xml:lang=\"pt\">Servico Paralisado Temporariamente</soap:Text></soap:Reason>"
                + "</soap:Fault>"
                + "</soap:Body>"
                + "</soap:Envelope>";

        try {
            DFSoapEnvelope.desempacotar(respostaComFault);
            Assert.fail("deveria ter lancado DFSoapFaultException");
        } catch (final DFSoapFaultException e) {
            Assert.assertEquals("Servico Paralisado Temporariamente", e.getMessage());
        }
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarIllegalStateExceptionParaRespostaQueNaoEUmEnvelopeSoapValido() throws DFSoapFaultException {
        DFSoapEnvelope.desempacotar("isto nao e um XML valido");
    }

    @Test
    public void enveloparEDesempacotarDevemSerRoundTripParaOMesmoXmlDeNegocio() throws DFSoapFaultException {
        final String xmlNegocio = "<retConsStatServ xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"4.00\"><cStat>107</cStat></retConsStatServ>";

        final String envelope = DFSoapEnvelope.envelopar(NAMESPACE_WSDL, "nfeResultMsg", xmlNegocio);
        final String xmlDesempacotado = DFSoapEnvelope.desempacotar(envelope);

        Assert.assertTrue(xmlDesempacotado.contains("<cStat>107</cStat>"));
    }
}
