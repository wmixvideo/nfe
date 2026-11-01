package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFConfig;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.apache.hc.client5.http.ClientProtocolException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.net.ssl.SSLContext;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;

/**
 * Testa {@link AbstractWSEvento#enviarEvento}, o metodo estatico que concentra a mecanica de
 * transporte (montar envelope SOAP 1.2, enviar via {@link DFHttpClient}, desempacotar a
 * resposta) reaproveitada por todos os 17 servicos de evento do nfe400
 * (carta de correcao, cancelamento, manifestacao do destinatario, EPEC e os 10 eventos que
 * herdam de {@link AbstractWSEvento}). Segue o mesmo padrao de servidor HTTP local (sem dependencias externas de mock)
 * ja usado em {@code DFHttpClientTest}.
 * 
 * @author Marcos Lombardi de Andrade
 */
public class AbstractWSEventoTest {

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
    public void deveEnviarOXmlAssinadoDentroDoWrapperComNamespaceEActionDoNFeRecepcaoEvento4() throws Exception {
        final String xmlAssinado = "<envEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"1.00\"><evento>assinado</evento></envEvento>";
        final StringBuilder corpoRecebido = new StringBuilder();
        final StringBuilder contentTypeRecebido = new StringBuilder();

        final String endpoint = this.iniciarServidor(exchange -> {
            contentTypeRecebido.append(exchange.getRequestHeaders().getFirst("Content-Type"));
            corpoRecebido.append(AbstractWSEventoTest.lerCorpo(exchange));
            AbstractWSEventoTest.responder(exchange, 200, AbstractWSEventoTest.envelopeComResultado("<retEnvEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\"><cStat>128</cStat></retEnvEvento>"));
        });
        this.httpClient = new DFHttpClient(SSLContext.getDefault(), new DFConfigTeste());

        AbstractWSEvento.enviarEvento(this.httpClient, endpoint, xmlAssinado);

        // a action do SOAP 1.2 vai dentro do Content-Type (nao num header SOAPAction separado)
        Assertions.assertTrue(contentTypeRecebido.toString().contains(AbstractWSEvento.SOAP_ACTION));
        // o wrapper nfeDadosMsg usa o namespace da operacao nfeRecepcaoEvento
        Assertions.assertTrue(corpoRecebido.toString().contains("<nfeDadosMsg xmlns=\"" + AbstractWSEvento.NAMESPACE_WSDL + "\">"));
        // o XML assinado vai embutido tal qual, sem reprocessamento (concatenacao de texto)
        Assertions.assertTrue(corpoRecebido.toString().contains(xmlAssinado));
    }

    @Test
    public void deveDevolverOXmlDeNegocioJaDesempacotadoDoWrapperNfeResultMsg() throws Exception {
        final String endpoint = this.iniciarServidor(exchange ->
                AbstractWSEventoTest.responder(exchange, 200, AbstractWSEventoTest.envelopeComResultado("<retEnvEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\"><cStat>135</cStat><xMotivo>Evento registrado</xMotivo></retEnvEvento>")));
        this.httpClient = new DFHttpClient(SSLContext.getDefault(), new DFConfigTeste());

        final String xmlResultado = AbstractWSEvento.enviarEvento(this.httpClient, endpoint, "<envEvento/>");

        Assertions.assertTrue(xmlResultado.startsWith("<retEnvEvento"));
        Assertions.assertTrue(xmlResultado.contains("<cStat>135</cStat>"));
        Assertions.assertTrue(xmlResultado.contains("<xMotivo>Evento registrado</xMotivo>"));
        Assertions.assertFalse(xmlResultado.contains("nfeResultMsg"));
    }

    @Test
    public void deveLancarDFSoapFaultExceptionQuandoSefazDevolverSoapFault() throws Exception {
        final String respostaComFault = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\">"
                + "<soap:Body>"
                + "<soap:Fault>"
                + "<soap:Code><soap:Value>soap:Receiver</soap:Value></soap:Code>"
                + "<soap:Reason><soap:Text xml:lang=\"pt\">Rejeicao: Chave de Acesso invalida</soap:Text></soap:Reason>"
                + "</soap:Fault>"
                + "</soap:Body>"
                + "</soap:Envelope>";
        final String endpoint = this.iniciarServidor(exchange -> AbstractWSEventoTest.responder(exchange, 200, respostaComFault));
        this.httpClient = new DFHttpClient(SSLContext.getDefault(), new DFConfigTeste());

        try {
            AbstractWSEvento.enviarEvento(this.httpClient, endpoint, "<envEvento/>");
            Assertions.fail("deveria ter lancado DFSoapFaultException");
        } catch (final DFSoapFaultException e) {
            Assertions.assertEquals("Rejeicao: Chave de Acesso invalida", e.getMessage());
        }
    }

    @Test
    public void devePropagarClientProtocolExceptionQuandoSefazDevolverErroHttp() throws Exception {
        final String endpoint = this.iniciarServidor(exchange -> AbstractWSEventoTest.responder(exchange, 500, "servico indisponivel"));
        this.httpClient = new DFHttpClient(SSLContext.getDefault(), new DFConfigTeste());

        try {
            AbstractWSEvento.enviarEvento(this.httpClient, endpoint, "<envEvento/>");
            Assertions.fail("deveria ter lancado ClientProtocolException");
        } catch (final ClientProtocolException e) {
            Assertions.assertTrue(e.getMessage().contains("500"));
        }
    }

    private static String envelopeComResultado(final String xmlNegocio) {
        return "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\">"
                + "<soap:Body>"
                + "<nfeResultMsg xmlns=\"" + AbstractWSEvento.NAMESPACE_WSDL + "\">"
                + xmlNegocio
                + "</nfeResultMsg>"
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
