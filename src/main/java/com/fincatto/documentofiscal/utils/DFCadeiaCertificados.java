package com.fincatto.documentofiscal.utils;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.cte300.classes.CTAutorizador31;
import com.fincatto.documentofiscal.cte400.classes.CTAutorizador400;
import com.fincatto.documentofiscal.mdfe3.classes.MDFAutorizador3;
import com.fincatto.documentofiscal.nfe400.classes.NFAutorizador400;
import com.fincatto.documentofiscal.nfse.webservices.WSDANFSe;
import com.fincatto.documentofiscal.nfse.webservices.WSParametrosMunicipais;
import com.fincatto.documentofiscal.nfse.webservices.WSSefinNFSe;
import org.apache.commons.lang3.StringUtils;

import javax.net.ssl.*;
import java.io.ByteArrayOutputStream;
import java.net.URI;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public abstract class DFCadeiaCertificados implements DFLog {

    private static final int PORT = 443;
    private static final String PROTOCOL = "TLSv1.2";

    public static byte[] geraCadeiaCertificados(final DFAmbiente ambiente, final String senha) throws Exception {
        final var homologacao = DFAmbiente.HOMOLOGACAO == ambiente;
        final KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null, senha.toCharArray());
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
//            for (final NFAutorizador400 aut : NFAutorizador400.values()) {
//                // Para NFe...
//                final String urlNF = aut.getNfeStatusServico(ambiente);
//                if (StringUtils.isNotBlank(urlNF)) {
//                    DFCadeiaCertificados.get(keyStore, urlNF);
//                }
//
//                // Para NFCe...
//                final String urlNFC = aut.getNfceStatusServico(ambiente);
//                if (StringUtils.isNotBlank(urlNFC)) {
//                    DFCadeiaCertificados.get(keyStore, urlNFC);
//                }
//            }
//
//            //URLs especificas do AN (www.fazenda.gov.br e www1.fazenda.gov.br)
//            final String urlNF1 = NFAutorizador400.AN.getRecepcaoEventoAN(ambiente);
//            if (StringUtils.isNotBlank(urlNF1)) {
//                DFCadeiaCertificados.get(keyStore, urlNF1);
//            }
//            final String urlNF2 = NFAutorizador400.AN.getNFeDistribuicaoDFe(ambiente);
//            if (StringUtils.isNotBlank(urlNF2)) {
//                DFCadeiaCertificados.get(keyStore, urlNF2);
//            }
//
//            // MDFE
//            for (final MDFAutorizador3 aut : MDFAutorizador3.values()) {
//                final String urlMDFe = aut.getMDFeStatusServico(ambiente);
//                if (StringUtils.isNotBlank(urlMDFe)) {
//                    DFCadeiaCertificados.get(keyStore, urlMDFe);
//                }
//            }
//
//            // CTe
//            for (final CTAutorizador31 aut : CTAutorizador31.values()) {
//                final String urlCTe = aut.getCteStatusServico(ambiente);
//                if (StringUtils.isNotBlank(urlCTe)) {
//                    DFCadeiaCertificados.get(keyStore, urlCTe);
//                }
//            }
//
//            // CTe 4.00
//            for (final CTAutorizador400 aut : CTAutorizador400.values()) {
//                final String urlCTe = aut.getCteStatusServico(ambiente);
//                if (StringUtils.isNotBlank(urlCTe)) {
//                    DFCadeiaCertificados.get(keyStore, urlCTe);
//                }
//            }

            // NFSe
            DFCadeiaCertificados.get(keyStore, WSSefinNFSe.URL_BASE_PRODUCAO);
            DFCadeiaCertificados.get(keyStore, WSSefinNFSe.URL_BASE_HOMOLOGACAO);
            DFCadeiaCertificados.get(keyStore, WSDANFSe.URL_BASE_PRODUCAO);
            DFCadeiaCertificados.get(keyStore, WSDANFSe.URL_BASE_HOMOLOGACAO);
            DFCadeiaCertificados.get(keyStore, WSParametrosMunicipais.URL_BASE_PRODUCAO);
            DFCadeiaCertificados.get(keyStore, WSParametrosMunicipais.URL_BASE_HOMOLOGACAO);

            // grava o keystore em um array de bytes
            keyStore.store(out, senha.toCharArray());
            return out.toByteArray();
        }
    }

    private static void get(final KeyStore keyStore, final String url) throws Exception {
        // obtém o host a partir da URL fornecida - necessário para abrir a conexão SSL
        final var host = new URI(url).getHost();

        final TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);

        final X509TrustManager defaultTrustManager = (X509TrustManager) trustManagerFactory.getTrustManagers()[0];
        final SavingTrustManager savingTrustManager = new SavingTrustManager(defaultTrustManager);

        final SSLContext sslContext = SSLContext.getInstance(DFCadeiaCertificados.PROTOCOL);
        sslContext.init(null, new TrustManager[]{savingTrustManager}, null);

        DFLog.getLogger(DFCadeiaCertificados.class).debug("Abrindo conexao para o servidor: {}:{}", host, DFCadeiaCertificados.PORT);
        try (SSLSocket sslSocket = (SSLSocket) sslContext.getSocketFactory().createSocket(host, DFCadeiaCertificados.PORT)) {
            sslSocket.setSoTimeout(10000);
            sslSocket.startHandshake();
        } catch (final Exception e) {
            DFLog.getLogger(DFCadeiaCertificados.class).error(String.format("[%s] %s", host, e.toString()));
        }

        // se conseguir obter a cadeia de certificados, adiciona no keystore
        if (savingTrustManager.chain != null) {
            DFLog.getLogger(DFCadeiaCertificados.class).debug("Certificados enviados pelo servidor: {}", savingTrustManager.chain.length);
            final MessageDigest sha1 = MessageDigest.getInstance("SHA1");
            final MessageDigest md5 = MessageDigest.getInstance("MD5");
            for (int i = 0; i < savingTrustManager.chain.length; i++) {
                final X509Certificate certificate = savingTrustManager.chain[i];
                sha1.update(certificate.getEncoded());
                md5.update(certificate.getEncoded());

                final String alias = String.format("%s.%s", host, i + 1);
                keyStore.setCertificateEntry(alias, certificate);
                DFLog.getLogger(DFCadeiaCertificados.class).debug("Adicionado certificado no keystore com o alias: {}", alias);
            }
        }
    }

    private static class SavingTrustManager implements X509TrustManager {
        private final X509TrustManager trustManager;
        private X509Certificate[] chain;

        SavingTrustManager(final X509TrustManager trustManager) {
            this.trustManager = trustManager;
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return this.trustManager.getAcceptedIssuers();
        }

        @Override
        public void checkClientTrusted(final X509Certificate[] chain, final String authType) throws CertificateException {
            this.trustManager.checkClientTrusted(chain, authType);
        }

        @Override
        public void checkServerTrusted(final X509Certificate[] chain, final String authType) throws CertificateException {
            this.chain = chain;
            this.trustManager.checkServerTrusted(chain, authType);
        }
    }
}
