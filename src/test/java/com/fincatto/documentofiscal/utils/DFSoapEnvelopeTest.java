package com.fincatto.documentofiscal.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * Testa {@link DFSoapEnvelope}, responsavel por montar e desempacotar o envelope SOAP 1.2 dos
 * webservices da SEFAZ migrados do Axis2 para {@code httpclient5}: envelopar (concatenacao de
 * texto do XML de negocio dentro do wrapper), desempacotar no caso comum de 1 nivel de wrapper
 * e no caso de 2 niveis (ex.: NFeDistribuicaoDFe), propagacao de {@code soap:Fault} como
 * {@link DFSoapFaultException} e o hardening contra XXE no parsing da resposta.
 *
 * @author Marcos Lombardi de Andrade
 */
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
    public void deveDesempacotarDoisNiveisDeWrapperQuandoPedidoExplicitamente() throws DFSoapFaultException {
        // reproduz o corpo SOAP da NFeDistribuicaoDFe: nfeDistDFeInteresseResponse > NFeDistDFeInteresseResult > XML de negocio
        final String respostaComDoisWrappers = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\">"
                + "<soap:Body>"
                + "<nfeDistDFeInteresseResponse xmlns=\"" + NAMESPACE_WSDL + "\">"
                + "<NFeDistDFeInteresseResult>"
                + "<retDistDFeInt xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"1.01\">"
                + "<cStat>137</cStat>"
                + "</retDistDFeInt>"
                + "</NFeDistDFeInteresseResult>"
                + "</nfeDistDFeInteresseResponse>"
                + "</soap:Body>"
                + "</soap:Envelope>";

        final String xmlNegocio = DFSoapEnvelope.desempacotar(respostaComDoisWrappers, 2);

        Assert.assertTrue(xmlNegocio.startsWith("<retDistDFeInt"));
        Assert.assertTrue(xmlNegocio.contains("<cStat>137</cStat>"));
        Assert.assertFalse("nao deve sobrar nenhum wrapper no resultado", xmlNegocio.contains("nfeDistDFeInteresseResponse") || xmlNegocio.contains("NFeDistDFeInteresseResult"));
    }

    @Test
    public void deveLancarDFSoapFaultExceptionComDoisNiveisDeWrapperQuandoRespostaForFault() {
        final String respostaComFault = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\">"
                + "<soap:Body>"
                + "<soap:Fault>"
                + "<soap:Code><soap:Value>soap:Receiver</soap:Value></soap:Code>"
                + "<soap:Reason><soap:Text xml:lang=\"pt\">Servico Paralisado Temporariamente</soap:Text></soap:Reason>"
                + "</soap:Fault>"
                + "</soap:Body>"
                + "</soap:Envelope>";

        try {
            DFSoapEnvelope.desempacotar(respostaComFault, 2);
            Assert.fail("deveria ter lancado DFSoapFaultException");
        } catch (final DFSoapFaultException e) {
            Assert.assertEquals("Servico Paralisado Temporariamente", e.getMessage());
        }
    }

    @Test
    public void enveloparEDesempacotarDevemSerRoundTripParaOMesmoXmlDeNegocio() throws DFSoapFaultException {
        final String xmlNegocio = "<retConsStatServ xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"4.00\"><cStat>107</cStat></retConsStatServ>";

        final String envelope = DFSoapEnvelope.envelopar(NAMESPACE_WSDL, "nfeResultMsg", xmlNegocio);
        final String xmlDesempacotado = DFSoapEnvelope.desempacotar(envelope);

        Assert.assertTrue(xmlDesempacotado.contains("<cStat>107</cStat>"));
    }
}
