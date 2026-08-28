package com.fincatto.documentofiscal.utils;

import com.fincatto.documentofiscal.DFConfig;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.apache.hc.client5.http.ClientProtocolException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.net.ssl.SSLContext;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Marcos Lombardi de Andrade
 */
public class DFHttpClientTest {

    private HttpServer servidor;
    private DFHttpClient httpClient;

    @AfterAll
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

        Assertions.assertEquals("application/soap+xml; charset=UTF-8; action=\"" + actionEsperada + "\"", contentTypeRecebido.get());
        Assertions.assertEquals(envelope, corpoRecebido.get());
    }

    @Test
    public void deveDevolverOCorpoDaRespostaQuandoStatusForSucesso() throws Exception {
        final String endpoint = this.iniciarServidor(exchange -> responder(exchange, 200, "<retConsStatServ><cStat>107</cStat></retConsStatServ>"));
        this.httpClient = new DFHttpClient(SSLContext.getDefault(), new DFConfigTeste());

        final String resposta = this.httpClient.postSoap(endpoint, "acao", "<envelope/>");

        Assertions.assertEquals("<retConsStatServ><cStat>107</cStat></retConsStatServ>", resposta);
    }

    @Test
    public void naoDeveLancarExcecaoParaCodigoImediatamenteAbaixoDoLimiteDeErro() throws Exception {
        final String endpoint = this.iniciarServidor(exchange -> responder(exchange, 299, "<ok/>"));
        this.httpClient = new DFHttpClient(SSLContext.getDefault(), new DFConfigTeste());

        Assertions.assertEquals("<ok/>", this.httpClient.postSoap(endpoint, "acao", "<envelope/>"));
    }

    @Test
    public void deveLancarClientProtocolExceptionComCodigoECorpoNoLimiteDoErro() throws Exception {
        // sem header Location - o DefaultRedirectStrategy do httpclient5 exige Location para
        // tratar 300 como redirect, entao a resposta chega intacta ao nosso handler
        final String endpoint = this.iniciarServidor(exchange -> responder(exchange, 300, "codigo limite"));
        this.httpClient = new DFHttpClient(SSLContext.getDefault(), new DFConfigTeste());

        try {
            this.httpClient.postSoap(endpoint, "acao", "<envelope/>");
            Assertions.fail("deveria ter lancado excecao para HTTP 300");
        } catch (final ClientProtocolException e) {
            Assertions.assertTrue(e.getMessage().contains("300"));
            Assertions.assertTrue(e.getMessage().contains("codigo limite"));
        }
    }

    @Test
    public void deveLancarClientProtocolExceptionComCodigoECorpoParaErroDoServidor() throws Exception {
        final String endpoint = this.iniciarServidor(exchange -> responder(exchange, 500, "<soap:Fault>servico indisponivel</soap:Fault>"));
        this.httpClient = new DFHttpClient(SSLContext.getDefault(), new DFConfigTeste());

        try {
            this.httpClient.postSoap(endpoint, "acao-qualquer", "<envelope/>");
            Assertions.fail("deveria ter lancado excecao para HTTP 500");
        } catch (final ClientProtocolException e) {
            Assertions.assertTrue(e.getMessage().contains("500"));
            Assertions.assertTrue(e.getMessage().contains("servico indisponivel"));
        }
    }

    @Test
    public void deveLancarIOExceptionQuandoNaoConseguirConectar() throws Exception {
        Assertions.assertThrows(IOException.class, () -> {
            // porta 1 normalmente esta livre/sem listener - falha de conexao, nao de resposta HTTP
            this.httpClient = new DFHttpClient(SSLContext.getDefault(), new DFConfigTeste());
            this.httpClient.postSoap("http://localhost:1/", "acao", "<envelope/>");
        });
    }

    @Test
    public void deveLancarDFSoapFaultExceptionQuandoCorpoDeErroForUmSoapFaultReconhecivel() throws Exception {
        // a SEFAZ por vezes devolve soap:Fault sob HTTP 500
        final String envelopeComFault = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\">"
                + "<soap:Body>"
                + "<soap:Fault>"
                + "<soap:Code><soap:Value>soap:Receiver</soap:Value></soap:Code>"
                + "<soap:Reason><soap:Text xml:lang=\"pt\">Servico Paralisado Temporariamente</soap:Text></soap:Reason>"
                + "</soap:Fault>"
                + "</soap:Body>"
                + "</soap:Envelope>";
        final String endpoint = this.iniciarServidor(exchange -> responder(exchange, 500, envelopeComFault));
        this.httpClient = new DFHttpClient(SSLContext.getDefault(), new DFConfigTeste());

        try {
            this.httpClient.postSoap(endpoint, "acao", "<envelope/>");
            Assertions.fail("deveria ter lancado DFSoapFaultException para soap:Fault sob HTTP 500");
        } catch (final DFSoapFaultException e) {
            Assertions.assertEquals("Servico Paralisado Temporariamente", e.getMessage());
        }
    }

    @Test
    public void naoDeveReenviarAutomaticamenteUmPostQuandoServidorResponderIndisponibilidadeMomentanea() throws Exception {
        final AtomicInteger requisicoesRecebidas = new AtomicInteger();
        final String endpoint = this.iniciarServidor(exchange -> {
            requisicoesRecebidas.incrementAndGet();
            responder(exchange, 503, "servico temporariamente indisponivel");
        });
        this.httpClient = new DFHttpClient(SSLContext.getDefault(), new DFConfigTeste());

        try {
            this.httpClient.postSoap(endpoint, "acao", "<envelope/>");
            Assertions.fail("deveria ter lancado excecao para HTTP 503");
        } catch (final ClientProtocolException e) {
            Assertions.assertTrue(e.getMessage().contains("503"));
        }

        // um POST de operacao fiscal nao pode ser reenviado automaticamente pelo transporte -
        // com o retry automatico do httpclient5 ativo (default), esse contador seria 2
        Assertions.assertEquals(1, requisicoesRecebidas.get());
    }

    @Test
    public void deveLancarIOExceptionQuandoRespostaDemoraMaisQueOTimeoutDeLeitura() throws Exception {
        Assertions.assertThrows(IOException.class, () -> {
            final String endpoint = this.iniciarServidor(exchange -> {
                try {
                    Thread.sleep(500);
                } catch (final InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                responder(exchange, 200, "<ok/>");
            });
            final DFConfigTeste configComTimeoutDeLeituraCurto = new DFConfigTeste() {
                @Override
                public int getSoTimeoutEmMillis() {
                    return 100;
                }
            };
            this.httpClient = new DFHttpClient(SSLContext.getDefault(), configComTimeoutDeLeituraCurto);

            this.httpClient.postSoap(endpoint, "acao", "<envelope/>");
        });
    }

    @Test
    public void deveLancarUnknownHostExceptionParaHostInexistente() throws Exception {
        Assertions.assertThrows(UnknownHostException.class, () -> {
            this.httpClient = new DFHttpClient(SSLContext.getDefault(), new DFConfigTeste());
            // ".invalid" e reservado pela RFC 2606 para nunca resolver - garante a falha de DNS sem depender de um host de rede real
            this.httpClient.postSoap("http://webservice-sefaz-teste.invalid/", "acao", "<envelope/>");
        });
    }

    @Test
    public void deveAtenderRequisicoesConcorrentesReaproveitandoOMesmoPoolDeConexoes() throws Exception {
        final int totalRequisicoes = 30; // acima do default de DFConfig.getMaxConexoesPorRota() (20), forca fila/reuso no pool
        final AtomicInteger requisicoesRecebidas = new AtomicInteger();
        final String endpoint = this.iniciarServidor(exchange -> {
            requisicoesRecebidas.incrementAndGet();
            try {
                Thread.sleep(30);
            } catch (final InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            responder(exchange, 200, "<ok/>");
        });
        this.httpClient = new DFHttpClient(SSLContext.getDefault(), new DFConfigTeste());

        final ExecutorService executor = Executors.newFixedThreadPool(totalRequisicoes);
        try {
            final List<Future<String>> respostas = new ArrayList<>();
            for (int i = 0; i < totalRequisicoes; i++) {
                respostas.add(executor.submit(() -> this.httpClient.postSoap(endpoint, "acao", "<envelope/>")));
            }
            for (final Future<String> resposta : respostas) {
                Assertions.assertEquals("<ok/>", resposta.get(10, TimeUnit.SECONDS));
            }
        } finally {
            executor.shutdown();
        }

        Assertions.assertEquals(totalRequisicoes, requisicoesRecebidas.get());
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
