package com.fincatto.documentofiscal.mdfe3.webservices;

import com.fincatto.documentofiscal.mdfe3.MDFeConfigFake;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.net.ssl.SSLContext;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

/**
 * Pina o formato exato do envelope SOAP 1.2 montado por {@link WSTransporteEvento}, a mecanica
 * de transporte compartilhada pelas 5 classes de evento do mdfe3 (WSCancelamento,
 * WSEncerramento, WSIncluirCondutor, WSIncluirDFe, WSPagamentoTransporte). Em especial, garante
 * que o {@code mdfeCabecMsg} usa o {@code cUF} da UF da chave de acesso do evento - nao a UF
 * configurada no {@code MDFeConfig} - o mesmo tipo de detalhe que causou o bug do wrapper duplo
 * encontrado na revisao final da migracao deste modulo (ver o Javadoc de
 * {@link com.fincatto.documentofiscal.mdfe.webservices.distribuicao.WSDistribuicaoMDFe}).
 * Segue o mesmo padrao de servidor HTTP local (sem dependencias externas de mock) ja usado em
 * {@code AbstractWSEventoTest} (nfe400).
 */
public class WSTransporteEventoTest {

    private HttpServer servidor;
    private DFHttpClient httpClient;

    @AfterEach
    public void encerraClienteEServidor() throws IOException {
        if (this.httpClient != null) {
            this.httpClient.close();
        }
        if (this.servidor != null) {
            this.servidor.stop(0);
        }
    }

    @Test
    public void deveMontarEnvelopeComMdfeCabecMsgEEnviarOXmlAssinadoDentroDoMdfeDadosMsg() throws Exception {
        final String xmlAssinado = "<eventoMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\" versao=\"3.00\"><evento>assinado</evento></eventoMDFe>";
        final StringBuilder corpoRecebido = new StringBuilder();
        final StringBuilder contentTypeRecebido = new StringBuilder();

        final String endpoint = this.iniciarServidor(exchange -> {
            contentTypeRecebido.append(exchange.getRequestHeaders().getFirst("Content-Type"));
            corpoRecebido.append(WSTransporteEventoTest.lerCorpo(exchange));
            WSTransporteEventoTest.responder(exchange, 200, WSTransporteEventoTest.envelopeComResultado("<retEventoMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\"><cStat>135</cStat></retEventoMDFe>"));
        });
        this.httpClient = new DFHttpClient(SSLContext.getDefault(), new MDFeConfigFake());

        final String xmlResultado = WSTransporteEvento.enviarEvento(this.httpClient, endpoint, xmlAssinado, "33", new BigDecimal("3.00"));

        Assertions.assertTrue(contentTypeRecebido.toString().contains("http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoEvento/mdfeRecepcaoEvento"));
        Assertions.assertEquals("<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\">"
                + "<soap:Header>"
                + "<mdfeCabecMsg xmlns=\"http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoEvento\"><cUF>33</cUF><versaoDados>3.00</versaoDados></mdfeCabecMsg>"
                + "</soap:Header>"
                + "<soap:Body>"
                + "<mdfeDadosMsg xmlns=\"http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoEvento\">" + xmlAssinado + "</mdfeDadosMsg>"
                + "</soap:Body>"
                + "</soap:Envelope>", corpoRecebido.toString());
        Assertions.assertTrue(xmlResultado.startsWith("<retEventoMDFe"));
    }

    @Test
    public void deveLancarDFSoapFaultExceptionQuandoSefazDevolverSoapFault() throws Exception {
        final String respostaComFault = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\">"
                + "<soap:Body>"
                + "<soap:Fault>"
                + "<soap:Code><soap:Value>soap:Receiver</soap:Value></soap:Code>"
                + "<soap:Reason><soap:Text xml:lang=\"pt\">Rejeicao: evento invalido</soap:Text></soap:Reason>"
                + "</soap:Fault>"
                + "</soap:Body>"
                + "</soap:Envelope>";
        final String endpoint = this.iniciarServidor(exchange -> WSTransporteEventoTest.responder(exchange, 200, respostaComFault));
        this.httpClient = new DFHttpClient(SSLContext.getDefault(), new MDFeConfigFake());

        try {
            WSTransporteEvento.enviarEvento(this.httpClient, endpoint, "<eventoMDFe/>", "35", new BigDecimal("3.00"));
            Assertions.fail("deveria ter lancado DFSoapFaultException");
        } catch (final DFSoapFaultException e) {
            Assertions.assertEquals("Rejeicao: evento invalido", e.getMessage());
        }
    }

    private static String envelopeComResultado(final String xmlNegocio) {
        return "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\">"
                + "<soap:Body>"
                + "<mdfeResultMsg xmlns=\"http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoEvento\">"
                + xmlNegocio
                + "</mdfeResultMsg>"
                + "</soap:Body>"
                + "</soap:Envelope>";
    }

    private String iniciarServidor(final HttpHandler handler) throws IOException {
        this.servidor = HttpServer.create(new InetSocketAddress("localhost", 0), 0);
        this.servidor.createContext("/", handler);
        this.servidor.start();
        return "http://localhost:" + this.servidor.getAddress().getPort() + "/";
    }

    private static void responder(final HttpExchange exchange, final int statusCode, final String corpo) throws IOException {
        final byte[] bytes = corpo.getBytes(StandardCharsets.UTF_8);
        exchange.sendResponseHeaders(statusCode, bytes.length);
        exchange.getResponseBody().write(bytes);
        exchange.close();
    }

    private static String lerCorpo(final HttpExchange exchange) {
        try (InputStream entrada = exchange.getRequestBody()) {
            final ByteArrayOutputStream saida = new ByteArrayOutputStream();
            final byte[] buffer = new byte[1024];
            int lidos;
            while ((lidos = entrada.read(buffer)) != -1) {
                saida.write(buffer, 0, lidos);
            }
            return new String(saida.toByteArray(), StandardCharsets.UTF_8);
        } catch (final IOException e) {
            throw new IllegalStateException(e);
        }
    }

}
