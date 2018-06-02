package com.fincatto.documentofiscal;

import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;

import javax.net.ssl.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.*;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

public class DFSocketFactory implements ProtocolSocketFactory {

    private final DFConfig config;
    private final SSLContext sslContext;

    public DFSocketFactory(final DFConfig config) throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        this.config = config;
        this.sslContext = this.createSSLContext(config);
    }

    @Override
    public Socket createSocket(final String host, final int port, final InetAddress localAddress, final int localPort, final HttpConnectionParams params) throws IOException {
        final Socket socket = this.sslContext.getSocketFactory().createSocket();
        ((SSLSocket) socket).setEnabledProtocols(this.config.getSSLProtocolos());
        socket.bind(new InetSocketAddress(localAddress, localPort));
        socket.connect(new InetSocketAddress(host, port), 60000);
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

    private SSLContext createSSLContext(final DFConfig config) throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        final KeyManager[] keyManagers = this.createKeyManagers(config);
        final TrustManager[] trustManagers = this.createTrustManagers(config);
        final SSLContext sslContext = SSLContext.getInstance(config.getSSLProtocolos()[0]);
        sslContext.init(keyManagers, trustManagers, null);
        return sslContext;
    }

    private KeyManager[] createKeyManagers(final DFConfig config) throws UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException {
        final String alias = DFSocketFactory.getAlias(config.getCertificadoKeyStore());
        final X509Certificate certificate = (X509Certificate) config.getCertificadoKeyStore().getCertificate(alias);
        final PrivateKey privateKey = (PrivateKey) config.getCertificadoKeyStore().getKey(alias, config.getCertificadoSenha().toCharArray());
        return new KeyManager[] { new DFKeyManager(certificate, privateKey) };
    }

    private TrustManager[] createTrustManagers(final DFConfig config) throws KeyStoreException, NoSuchAlgorithmException {
        final TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(config.getCadeiaCertificadosKeyStore());
        return trustManagerFactory.getTrustManagers();
    }

    private static String getAlias(final KeyStore ks) throws KeyStoreException {
        final Enumeration<String> aliasesEnum = ks.aliases();
        while (aliasesEnum.hasMoreElements()) {
            final String alias = aliasesEnum.nextElement();
            if (ks.isKeyEntry(alias)) {
                return alias;
            }
        }
        throw new KeyStoreException("Nenhum alias encontrado no certificado");
    }
}

class DFKeyManager implements X509KeyManager {

    private final X509Certificate certificate;
    private final PrivateKey privateKey;

    DFKeyManager(final X509Certificate certificate, final PrivateKey privateKey) {
        this.certificate = certificate;
        this.privateKey = privateKey;
    }

    @Override
    public String chooseClientAlias(final String[] arg0, final Principal[] arg1, final Socket arg2) {
        return this.certificate.getIssuerDN().getName();
    }

    @Override
    public String chooseServerAlias(final String arg0, final Principal[] arg1, final Socket arg2) {
        return null;
    }

    @Override
    public X509Certificate[] getCertificateChain(final String arg0) {
        return new X509Certificate[] { this.certificate };
    }

    @Override
    public String[] getClientAliases(final String arg0, final Principal[] arg1) {
        return new String[] { this.certificate.getIssuerDN().getName() };
    }

    @Override
    public PrivateKey getPrivateKey(final String arg0) {
        return this.privateKey;
    }

    @Override
    public String[] getServerAliases(final String arg0, final Principal[] arg1) {
        return null;
    }
}
