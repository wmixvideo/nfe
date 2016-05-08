package com.fincatto.nfe310.webservices;

import com.fincatto.nfe310.NFeConfig;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509KeyManager;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

class NFSocketFactory implements ProtocolSocketFactory {

    private final SSLContext sslContext;

    NFSocketFactory(final NFeConfig config) throws KeyManagementException, UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
        this.sslContext = this.createSSLContext(config);
    }

    private SSLContext createSSLContext(final NFeConfig config) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, KeyManagementException, UnrecoverableKeyException {
        final KeyManager[] keyManagers = this.createKeyManagers(config);
        final TrustManager[] trustManagers = this.createTrustManagers(config);
        final SSLContext sslContext = SSLContext.getInstance(config.getSSLProtocolo());
        sslContext.init(keyManagers, trustManagers, null);
        return sslContext;
    }

    @Override
    public Socket createSocket(final String host, final int port, final InetAddress localAddress, final int localPort, final HttpConnectionParams params) throws IOException {
        final Socket socket = this.sslContext.getSocketFactory().createSocket();
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

    private KeyManager[] createKeyManagers(final NFeConfig config) throws UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
        try (InputStream certificado = new ByteArrayInputStream(config.getCertificado())) {
            final KeyStore ks = KeyStore.getInstance("PKCS12");
            ks.load(certificado, config.getCertificadoSenha().toCharArray());

            final String alias = NFSocketFactory.getAlias(ks);
            final X509Certificate certificate = (X509Certificate) ks.getCertificate(alias);
            final PrivateKey privateKey = (PrivateKey) ks.getKey(alias, config.getCertificadoSenha().toCharArray());
            return new KeyManager[]{new HSKeyManager(certificate, privateKey)};
        }
    }

    private TrustManager[] createTrustManagers(final NFeConfig config) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
        try (ByteArrayInputStream cadeia = new ByteArrayInputStream(config.getCadeiaCertificados())) {
            final KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(cadeia, config.getCadeiaCertificadosSenha().toCharArray());

            final TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(trustStore);
            return trustManagerFactory.getTrustManagers();
        }
    }

    private static String getAlias(final KeyStore ks) throws KeyStoreException {
        final Enumeration<String> aliasesEnum = ks.aliases();
        while (aliasesEnum.hasMoreElements()) {
            final String alias = aliasesEnum.nextElement();
            if (ks.isKeyEntry(alias)) {
                return alias;
            }
        }
        return "";
    }
}

class HSKeyManager implements X509KeyManager {

    private final X509Certificate certificate;
    private final PrivateKey privateKey;

    HSKeyManager(final X509Certificate certificate, final PrivateKey privateKey) {
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
        return new X509Certificate[]{this.certificate};
    }

    @Override
    public String[] getClientAliases(final String arg0, final Principal[] arg1) {
        return new String[]{this.certificate.getIssuerDN().getName()};
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