package com.fincatto.documentofiscal.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.util.concurrent.atomic.AtomicReference;

import javax.net.ssl.SSLContext;

import org.apache.hc.client5.http.ClientProtocolException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.DFConfig;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/**
 * @author Marcos Lombardi de Andrade
 */
public class DFHttpClientTest {

    private HttpServer servidor;
    private DFHttpClient httpClient;

    @After
    public void encerraClienteEServidor() throws IOException {
        if (this.httpClient != null) {
            this.httpClient.close();
        }
        if (this.servidor != null) {
            this.servidor.stop(0);
        }
    }

    @Test
    public void deveEnviarContentTypeSoap12ComAActionDaOperacao() throws Exception {
        final AtomicReference<String> contentTypeRecebido = new AtomicReference<>();
        final AtomicReference<String> corpoRecebido = new AtomicReference<>();
        final String envelope = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\"><soap:Body/></soap:Envelope>";
        final String actionEsperada = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4/nfeStatusServicoNF";

        final String endpoint = this.iniciarServidor(exchange -> {
            contentTypeRecebido.set(exchange.getRequestHeaders().getFirst("Content-Type"));
            corpoRecebido.set(lerCorpo(exchange));
            responder(exchange, 200, "<ok/>");
        });
        this.httpClient = new DFHttpClient(SSLContext.getDefault(), new DFConfigTeste());

        this.httpClient.postSoap(endpoint, actionEsperada, envelope);

        Assert.assertEquals("application/soap+xml; charset=UTF-8; action=\"" + actionEsperada + "\"", contentTypeRecebido.get());
        Assert.assertEquals(envelope, corpoRecebido.get());
    }

    @Test
    public void deveDevolverOCorpoDaRespostaQuandoStatusForSucesso() throws Exception {
        final String endpoint = this.iniciarServidor(exchange -> responder(exchange, 200, "<retConsStatServ><cStat>107</cStat></retConsStatServ>"));
        this.httpClient = new DFHttpClient(SSLContext.getDefault(), new DFConfigTeste());

        final String resposta = this.httpClient.postSoap(endpoint, "acao", "<envelope/>");

        Assert.assertEquals("<retConsStatServ><cStat>107</cStat></retConsStatServ>", resposta);
    }

    @Test
    public void naoDeveLancarExcecaoParaCodigoImediatamenteAbaixoDoLimiteDeErro() throws Exception {
        final String endpoint = this.iniciarServidor(exchange -> responder(exchange, 299, "<ok/>"));
        this.httpClient = new DFHttpClient(SSLContext.getDefault(), new DFConfigTeste());

        Assert.assertEquals("<ok/>", this.httpClient.postSoap(endpoint, "acao", "<envelope/>"));
    }

    @Test
    public void deveLancarClientProtocolExceptionComCodigoECorpoNoLimiteDoErro() throws Exception {
        // sem header Location - o DefaultRedirectStrategy do httpclient5 exige Location para
        // tratar 300 como redirect, entao a resposta chega intacta ao nosso handler
        final String endpoint = this.iniciarServidor(exchange -> responder(exchange, 300, "codigo limite"));
        this.httpClient = new DFHttpClient(SSLContext.getDefault(), new DFConfigTeste());

        try {
            this.httpClient.postSoap(endpoint, "acao", "<envelope/>");
            Assert.fail("deveria ter lancado excecao para HTTP 300");
        } catch (final ClientProtocolException e) {
            Assert.assertTrue(e.getMessage().contains("300"));
            Assert.assertTrue(e.getMessage().contains("codigo limite"));
        }
    }

    @Test
    public void deveLancarClientProtocolExceptionComCodigoECorpoParaErroDoServidor() throws Exception {
        final String endpoint = this.iniciarServidor(exchange -> responder(exchange, 500, "<soap:Fault>servico indisponivel</soap:Fault>"));
        this.httpClient = new DFHttpClient(SSLContext.getDefault(), new DFConfigTeste());

        try {
            this.httpClient.postSoap(endpoint, "acao-qualquer", "<envelope/>");
            Assert.fail("deveria ter lancado excecao para HTTP 500");
        } catch (final ClientProtocolException e) {
            Assert.assertTrue(e.getMessage().contains("500"));
            Assert.assertTrue(e.getMessage().contains("servico indisponivel"));
        }
    }

    @Test(expected = IOException.class)
    public void deveLancarIOExceptionQuandoNaoConseguirConectar() throws Exception {
        // porta 1 normalmente esta livre/sem listener - falha de conexao, nao de resposta HTTP
        this.httpClient = new DFHttpClient(SSLContext.getDefault(), new DFConfigTeste());
        this.httpClient.postSoap("http://localhost:1/", "acao", "<envelope/>");
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

    private static class DFConfigTeste extends DFConfig {
        @Override
        public DFUnidadeFederativa getCUF() {
            return null;
        }

        @Override
        public KeyStore getCertificadoKeyStore() {
            return null;
        }

        @Override
        public String getCertificadoSenha() {
            return null;
        }

        @Override
        public KeyStore getCadeiaCertificadosKeyStore() {
            return null;
        }

        @Override
        public String getCadeiaCertificadosSenha() {
            return null;
        }
    }
}
