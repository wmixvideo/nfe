package com.fincatto.documentofiscal.utils;

import com.fincatto.documentofiscal.DFConfig;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;

import javax.net.ssl.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

public class DFSocketFactory implements ProtocolSocketFactory {

    public static final int TIMEOUT_PADRAO_EM_MILLIS = 60_000;
    public static final int SO_TIMEOUT_PADRAO_EM_MILLIS = 30_000;

    private final DFConfig config;
    private final SSLContext sslContext;

    public DFSocketFactory(final DFConfig config) throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        this.config = config;
        this.sslContext = createSSLContext(createCustomKeyManagers(this.config), createTrustManagers(this.config), this.config.getSSLProtocolos()[0]);
    }

    @Override
    public Socket createSocket(final String host, final int port, final InetAddress localAddress, final int localPort, final HttpConnectionParams params) throws IOException {
        final Socket socket = this.sslContext.getSocketFactory().createSocket();
        ((SSLSocket) socket).setEnabledProtocols(this.config.getSSLProtocolos());
        socket.bind(new InetSocketAddress(localAddress, localPort));
        socket.connect(new InetSocketAddress(host, port), params.getConnectionTimeout());
        return socket;
    }

    @Override
    public Socket createSocket(final String host, final int port, final InetAddress clientHost, final int clientPort) throws IOException {
        return this.sslContext.getSocketFactory().createSocket(host, port, clientHost, clientPort);
    }

    @Override
    public Socket createSocket(final String host, final int port) throws IOException {
        return this.sslContext.getSocketFactory().createSocket(host, port);
    }

    /**
     * Cria um SSLContext padrão para API's REST.
     */
    public static SSLContext getDefaultSSLContext(final DFConfig config) throws UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        return createSSLContext(createKeyManagers(config), createTrustManagers(config), config.getSSLProtocolos()[0]);
    }

    /**
     * configura o SSLContext com os KeyManagers e TrustManagers informados.
     *
     * @param km
     * @param tm
     * @param protocol
     * @return
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws KeyManagementException
     */
    private static SSLContext createSSLContext(KeyManager[] km, TrustManager[] tm, String protocol) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        final SSLContext sslContext = SSLContext.getInstance(protocol);
        sslContext.init(km, tm, null);
        return sslContext;
    }

    /**
     * Cria os KeyManagers a partir do KeyStore do certificado digital com algorítmo padrão.
     *
     * @param config Configuração do DF.
     * @return KeyManagers criados.
     */
    private static KeyManager[] createKeyManagers(final DFConfig config) throws UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException {
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(config.getCertificadoKeyStore(), config.getCertificadoSenha().toCharArray());
        return kmf.getKeyManagers();
    }

    /**
     * Cria os KeyManagers a partir do KeyStore do certificado digital com algorítmo customizado.
     *
     * @param config Configuração do DF.
     * @return KeyManagers criados.
     */
    private static KeyManager[] createCustomKeyManagers(final DFConfig config) throws KeyStoreException {
        return new KeyManager[]{new com.fincatto.documentofiscal.utils.DFKeyManager(config)};
    }

    /**
     * Cria os TrustManagers a partir do KeyStore da cadeia de certificados com algorítmo padrão.
     *
     * @param config Configuração do DF.
     * @return TrustManagers criados.
     */
    private static TrustManager[] createTrustManagers(final DFConfig config) throws KeyStoreException, NoSuchAlgorithmException {
        final TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(config.getCadeiaCertificadosKeyStore());
        return trustManagerFactory.getTrustManagers();
    }
}