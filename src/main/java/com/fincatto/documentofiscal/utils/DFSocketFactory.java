package com.fincatto.documentofiscal.utils;

import com.fincatto.documentofiscal.DFConfig;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

/**
 * Monta o {@link SSLContext} usado no mTLS com a SEFAZ a partir do certificado A1 (via
 * {@link DFKeyManager}) e da cadeia de certificados configurada. Ate a migracao Axis2 -&gt;
 * HttpClient5 esta classe tambem implementava {@code org.apache.commons.httpclient.protocol.ProtocolSocketFactory}
 * (Commons-HttpClient 3, usada pelo transporte do Axis2); essa interface e os metodos
 * {@code createSocket(...)} que ela exigia foram removidos por nao terem mais nenhum chamador -
 * hoje o unico uso desta classe e {@link #getSslContext()}.
 */
public class DFSocketFactory {

    public static final int TIMEOUT_PADRAO_EM_MILLIS = 60_000;
    public static final int SO_TIMEOUT_PADRAO_EM_MILLIS = 30_000;

    private final SSLContext sslContext;

    public DFSocketFactory(final DFConfig config) throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        this.sslContext = this.createSSLContext(config);
    }

    /**
     * Expoe o {@link SSLContext} ja montado a partir do certificado A1 (via {@link DFKeyManager})
     * e da cadeia de certificados da SEFAZ, para que outros clientes HTTP (ex.: {@link DFHttpClient})
     * possam reaproveita-lo sem duplicar a leitura do KeyStore/TrustStore.
     *
     * @return o SSLContext usado para o mTLS com a SEFAZ.
     */
    public SSLContext getSslContext() {
        return this.sslContext;
    }

    private SSLContext createSSLContext(final DFConfig config) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, UnrecoverableKeyException {
        final KeyManager[] keyManagers = this.createKeyManagers(config);
        final TrustManager[] trustManagers = this.createTrustManagers(config);
        final SSLContext sslContext = SSLContext.getInstance(config.getSSLProtocolos()[0]);
        sslContext.init(keyManagers, trustManagers, null);
        return sslContext;
    }

    private KeyManager[] createKeyManagers(final DFConfig config) throws UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException{
        return new KeyManager[]{new com.fincatto.documentofiscal.utils.DFKeyManager(config)};
    }

    private TrustManager[] createTrustManagers(final DFConfig config) throws KeyStoreException, NoSuchAlgorithmException {
        final TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(config.getCadeiaCertificadosKeyStore());
        return trustManagerFactory.getTrustManagers();
    }

}