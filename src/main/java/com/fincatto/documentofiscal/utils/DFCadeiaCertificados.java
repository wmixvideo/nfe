package com.fincatto.documentofiscal.utils;

import java.io.ByteArrayOutputStream;
import java.net.URI;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.lang3.StringUtils;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.cte300.classes.CTAutorizador31;
import com.fincatto.documentofiscal.cte400.classes.CTAutorizador400;
import com.fincatto.documentofiscal.mdfe3.classes.MDFAutorizador3;
import com.fincatto.documentofiscal.nfe400.classes.NFAutorizador400;

/**
 * Ferramenta administrativa offline para gerar o {@link KeyStore} da cadeia de certificados da
 * SEFAZ (o {@code producao.cacerts}/{@code homologacao.cacerts} usado por
 * {@link com.fincatto.documentofiscal.DFConfig#getCadeiaCertificadosKeyStore()}). Nao participa
 * do fluxo de emissao de documentos fiscais em runtime.
 * <p>
 * <b>Atencao:</b> {@link #get} usa um padrao <i>trust-on-first-use</i> - aceita e grava no
 * keystore de saida qualquer certificado devolvido pelo host consultado, sem validar a cadeia
 * contra uma autoridade certificadora confiavel previamente conhecida. Isso e aceitavel apenas
 * porque a execucao e manual, feita uma vez por um operador contra os hosts fixos e conhecidos
 * da SEFAZ, e o resultado deve ser conferido antes de distribuido - o fingerprint SHA-256 de
 * cada certificado capturado e logado em debug justamente para essa conferencia manual. Nunca
 * reutilize esse padrao em codigo que valide certificados de servidor em tempo de execucao.
 */
public abstract class DFCadeiaCertificados implements DFLog {
    
    private static final int PORT = 443;
    private static final String PROTOCOL = "TLSv1.2";
    
    public static byte[] geraCadeiaCertificados(final DFAmbiente ambiente, final String senha) throws Exception {
        final KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null, senha.toCharArray());
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
    
        	/*//nao eh mais usado
            for (final NFAutorizador31 aut : NFAutorizador31.values()) {
                // Para NFe...
                final String urlNF = aut.getNfeStatusServico(ambiente);
                if (StringUtils.isNotBlank(urlNF)) {
                    final String host = new URI(urlNF).getHost();
                    DFCadeiaCertificados.get(keyStore, host);
                }
        
                // Para NFCe...
                final String urlNFC = aut.getNfceStatusServico(ambiente);
                if (StringUtils.isNotBlank(urlNFC)) {
                    final String host = new URI(urlNFC).getHost();
                    DFCadeiaCertificados.get(keyStore, host);
                }
            }
            */
    
            for (final NFAutorizador400 aut : NFAutorizador400.values()) {
                // Para NFe...
                final String urlNF = aut.getNfeStatusServico(ambiente);
                if (StringUtils.isNotBlank(urlNF)) {
                    final String host = new URI(urlNF).getHost();
                    DFCadeiaCertificados.get(keyStore, host);
                }
        
                // Para NFCe...
                final String urlNFC = aut.getNfceStatusServico(ambiente);
                if (StringUtils.isNotBlank(urlNFC)) {
                    final String host = new URI(urlNFC).getHost();
                    DFCadeiaCertificados.get(keyStore, host);
                }
            }
            
            //URLs especificas do AN (www.fazenda.gov.br e www1.fazenda.gov.br)
            final String urlNF1 = NFAutorizador400.AN.getRecepcaoEventoAN(ambiente);
            if (StringUtils.isNotBlank(urlNF1)) {
                final String host = new URI(urlNF1).getHost();
                DFCadeiaCertificados.get(keyStore, host);
            }
            final String urlNF2 = NFAutorizador400.AN.getNFeDistribuicaoDFe(ambiente);
            if (StringUtils.isNotBlank(urlNF2)) {
                final String host = new URI(urlNF2).getHost();
                DFCadeiaCertificados.get(keyStore, host);
            }
    
            // MDFE
            for (final MDFAutorizador3 aut : MDFAutorizador3.values()) {
                final String urlMDFe = aut.getMDFeStatusServico(ambiente);
                if (StringUtils.isNotBlank(urlMDFe)) {
                    final String host = new URI(urlMDFe).getHost();
                    DFCadeiaCertificados.get(keyStore, host);
                }
            }
    
            // CTe
            for (final CTAutorizador31 aut : CTAutorizador31.values()) {
                final String urlCTe = aut.getCteStatusServico(ambiente);
                if (StringUtils.isNotBlank(urlCTe)) {
                    final String host = new URI(urlCTe).getHost();
                    DFCadeiaCertificados.get(keyStore, host);
                }
            }

            // CTe 4.00
            for (final CTAutorizador400 aut : CTAutorizador400.values()) {
                final String urlCTe = aut.getCteStatusServico(ambiente);
                if (StringUtils.isNotBlank(urlCTe)) {
                    final String host = new URI(urlCTe).getHost();
                    DFCadeiaCertificados.get(keyStore, host);
                }
            }
    
            keyStore.store(out, senha.toCharArray());
            return out.toByteArray();
        }
    }
    
    private static void get(final KeyStore keyStore, final String host) throws Exception {
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
            // loga com stack trace e segue: o keystore resultante fica sem os certificados deste
            // host - o operador deve conferir o log antes de distribuir o arquivo gerado
            DFLog.getLogger(DFCadeiaCertificados.class).error(String.format("Falha ao capturar certificados de [%s] - keystore resultante NAO contem este host", host), e);
        }
        
        // se conseguir obter a cadeia de certificados, adiciona no keystore
        if (savingTrustManager.chain != null) {
            DFLog.getLogger(DFCadeiaCertificados.class).debug("Certificados enviados pelo servidor: {}", savingTrustManager.chain.length);
            final MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            for (int i = 0; i < savingTrustManager.chain.length; i++) {
                final X509Certificate certificate = savingTrustManager.chain[i];
                final String alias = String.format("%s.%s", host, i + 1);
                keyStore.setCertificateEntry(alias, certificate);
                // fingerprint logado para a conferencia manual do padrao trust-on-first-use
                // documentada no javadoc da classe
                sha256.reset();
                final StringBuilder fingerprint = new StringBuilder();
                for (final byte b : sha256.digest(certificate.getEncoded())) {
                    fingerprint.append(String.format("%02X", b));
                }
                DFLog.getLogger(DFCadeiaCertificados.class).debug("Adicionado certificado no keystore com o alias: {} (SHA-256: {})", alias, fingerprint);
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
