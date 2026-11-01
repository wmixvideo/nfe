package com.fincatto.documentofiscal.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Testa {@link DFSoapEnvelope}, responsavel por montar e desempacotar o envelope SOAP 1.2 dos
 * webservices da SEFAZ: envelopar (concatenacao de texto do XML de negocio dentro do wrapper),
 * desempacotar no caso comum de 1 nivel de wrapper e no caso de 2 niveis (ex.: NFeDistribuicaoDFe),
 * propagacao de {@code soap:Fault} como {@link DFSoapFaultException} e o hardening contra XXE no parsing da resposta.
 *
 * @author Marcos Lombardi de Andrade
 */
public class DFSoapEnvelopeTest {

    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4";

    @Test
    public void deveEnveloparXmlDeNegocioDentroDoWrapperNoSoapBody() {
        final String xmlNegocio = "<consStatServ xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"4.00\"><tpAmb>2</tpAmb></consStatServ>";

        final String envelope = DFSoapEnvelope.envelopar(NAMESPACE_WSDL, "nfeDadosMsg", xmlNegocio);

        Assertions.assertTrue(envelope.startsWith("<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\">"));
        Assertions.assertTrue(envelope.contains("<soap:Body>"));
        Assertions.assertTrue(envelope.contains("<nfeDadosMsg xmlns=\"" + NAMESPACE_WSDL + "\">"));
        Assertions.assertTrue(envelope.contains(xmlNegocio));
        Assertions.assertTrue(envelope.contains("</nfeDadosMsg>"));
        Assertions.assertTrue(envelope.endsWith("</soap:Body></soap:Envelope>"));
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

        Assertions.assertTrue(xmlNegocio.startsWith("<retConsStatServ"));
        Assertions.assertTrue(xmlNegocio.contains("<cStat>107</cStat>"));
        Assertions.assertTrue(xmlNegocio.contains("<xMotivo>Servico em Operacao</xMotivo>"));
        Assertions.assertFalse(xmlNegocio.contains("nfeResultMsg"));
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
            Assertions.fail("deveria ter lancado DFSoapFaultException");
        } catch (final DFSoapFaultException e) {
            Assertions.assertEquals("Servico Paralisado Temporariamente", e.getMessage());
        }
    }

    @Test
    public void deveLancarIllegalStateExceptionParaRespostaQueNaoEUmEnvelopeSoapValido() throws DFSoapFaultException {
        Assertions.assertThrows(IllegalStateException.class, () -> DFSoapEnvelope.desempacotar("isto nao e um XML valido"));
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

        Assertions.assertTrue(xmlNegocio.startsWith("<retDistDFeInt"));
        Assertions.assertTrue(xmlNegocio.contains("<cStat>137</cStat>"));
        Assertions.assertFalse(xmlNegocio.contains("nfeDistDFeInteresseResponse") || xmlNegocio.contains("NFeDistDFeInteresseResult"));
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
            Assertions.fail("deveria ter lancado DFSoapFaultException");
        } catch (final DFSoapFaultException e) {
            Assertions.assertEquals("Servico Paralisado Temporariamente", e.getMessage());
        }
    }

    @Test
    public void deveLancarIllegalArgumentExceptionQuandoNiveisDeWrapperForZero() throws DFSoapFaultException {
        Assertions.assertThrows(IllegalArgumentException.class, () -> DFSoapEnvelope.desempacotar("<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\"><soap:Body/></soap:Envelope>", 0));
    }

    @Test
    public void deveLancarIllegalArgumentExceptionQuandoNiveisDeWrapperForNegativo() throws DFSoapFaultException {
        Assertions.assertThrows(IllegalArgumentException.class, () -> DFSoapEnvelope.desempacotar("<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\"><soap:Body/></soap:Envelope>", -1));
    }

    @Test
    public void enveloparEDesempacotarDevemSerRoundTripParaOMesmoXmlDeNegocio() throws DFSoapFaultException {
        final String xmlNegocio = "<retConsStatServ xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"4.00\"><cStat>107</cStat></retConsStatServ>";

        final String envelope = DFSoapEnvelope.envelopar(NAMESPACE_WSDL, "nfeResultMsg", xmlNegocio);
        final String xmlDesempacotado = DFSoapEnvelope.desempacotar(envelope);

        Assertions.assertTrue(xmlDesempacotado.contains("<cStat>107</cStat>"));
    }

    @Test
    public void deveEnveloparXmlDeNegocioComCabecalhoQuandoOverloadDeCincoArgumentosForUsado() {
        final String namespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteStatusServico";
        final String headerXml = "<cUF>35</cUF><versaoDados>3.00</versaoDados>";
        final String xmlNegocio = "<consStatServ xmlns=\"http://www.portalfiscal.inf.br/cte\" versao=\"3.00\"><tpAmb>2</tpAmb></consStatServ>";

        final String envelope = DFSoapEnvelope.envelopar(namespace, "cteCabecMsg", headerXml, "cteDadosMsg", xmlNegocio);

        Assertions.assertTrue(envelope.startsWith("<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\">"));
        Assertions.assertTrue(envelope.contains("<soap:Header>"));
        Assertions.assertTrue(envelope.contains("<cteCabecMsg xmlns=\"" + namespace + "\">" + headerXml + "</cteCabecMsg>"));
        Assertions.assertTrue(envelope.contains("</soap:Header>"));
        Assertions.assertTrue(envelope.contains("<soap:Body>"));
        Assertions.assertTrue(envelope.contains("<cteDadosMsg xmlns=\"" + namespace + "\">" + xmlNegocio + "</cteDadosMsg>"));
        Assertions.assertTrue(envelope.endsWith("</soap:Body></soap:Envelope>"));
        // o cabecalho deve vir antes do corpo, na ordem exigida pelo XML Schema (sequence)
        Assertions.assertTrue(envelope.indexOf("<soap:Header>") < envelope.indexOf("<soap:Body>"));
    }

    @Test
    public void deveReconhecerFaultEmCorpoDevolvidoComStatusHttpDeErro() {
        // mesma forma de soap:Fault que a SEFAZ devolve sob HTTP 200 (deveLancarDFSoapFaultExceptionComOMotivoQuandoRespostaForFault),
        // mas aqui simulando o cenario de HTTP 500 com Fault no corpo
        final String respostaComFault = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\">"
                + "<soap:Body>"
                + "<soap:Fault>"
                + "<soap:Code><soap:Value>soap:Receiver</soap:Value></soap:Code>"
                + "<soap:Reason><soap:Text xml:lang=\"pt\">Servico Paralisado Temporariamente</soap:Text></soap:Reason>"
                + "</soap:Fault>"
                + "</soap:Body>"
                + "</soap:Envelope>";

        final DFSoapFaultException fault = DFSoapEnvelope.tentarReconhecerFault(respostaComFault);

        Assertions.assertNotNull(fault);
        Assertions.assertEquals("Servico Paralisado Temporariamente", fault.getMessage());
    }

    @Test
    public void naoDeveReconhecerFaultQuandoCorpoNaoForUmEnvelopeSoapValido() {
        Assertions.assertNull(DFSoapEnvelope.tentarReconhecerFault("servico temporariamente indisponivel"));
    }

    @Test
    public void naoDeveReconhecerFaultQuandoBodyNaoComecarComFault() {
        final String respostaSemFault = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\">"
                + "<soap:Body>"
                + "<nfeResultMsg xmlns=\"" + NAMESPACE_WSDL + "\"><retConsStatServ/></nfeResultMsg>"
                + "</soap:Body>"
                + "</soap:Envelope>";

        Assertions.assertNull(DFSoapEnvelope.tentarReconhecerFault(respostaSemFault));
    }

    @Test
    public void enveloparComCabecalhoEDesempacotarDevemSerRoundTripParaOMesmoXmlDeNegocio() throws DFSoapFaultException {
        final String namespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteStatusServico";
        final String xmlNegocio = "<retConsStatServ xmlns=\"http://www.portalfiscal.inf.br/cte\" versao=\"3.00\"><cStat>107</cStat></retConsStatServ>";

        // a resposta da SEFAZ nao tem cabecalho, so o corpo - o envelope de pedido com
        // cabecalho e a resposta sem cabecalho sao simulados separadamente aqui
        final String envelopeDoPedido = DFSoapEnvelope.envelopar(namespace, "cteCabecMsg", "<cUF>35</cUF><versaoDados>3.00</versaoDados>", "cteDadosMsg", "<consStatServ/>");
        Assertions.assertTrue(envelopeDoPedido.contains("<soap:Header>"));

        final String respostaSefaz = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\">"
                + "<soap:Body>"
                + "<cteResultMsg xmlns=\"" + namespace + "\">"
                + xmlNegocio
                + "</cteResultMsg>"
                + "</soap:Body>"
                + "</soap:Envelope>";
        final String xmlDesempacotado = DFSoapEnvelope.desempacotar(respostaSefaz);
        Assertions.assertTrue(xmlDesempacotado.contains("<cStat>107</cStat>"));
    }
}
