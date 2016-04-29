package com.fincatto.nfe310.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.classes.NFAmbiente;
import com.fincatto.nfe310.classes.NFAutorizador31;
  
public class NFGeraCadeiaCertificados {
	
    private static final String JSSECACERTS = "NFeCacerts";  
    private static final int TIMEOUT_WS = 30;  
  
    public static void main(String[] args) throws Exception {
    	//Gera a cadeia para Homologação, na pasta do projeto
		geraCadeiaCertificados(NFAmbiente.HOMOLOGACAO, "changeit", null);
	}
    
    /**
     * Gera um arquivo NFeCacerts contento as cadeias dos certificados para o ambiente informado.<br>
     * Valido tanto para NFe quanto NFCe
     * @param ambiente Homologacao ou Producao
     * @param senha Senha da cadeia de certificados, configurada em {@link NFeConfig#getCadeiaCertificadosSenha()}
     * @param diretorio Diretorio em que o arquivo NFeCacerts sera gerado
     */
    public static void geraCadeiaCertificados(NFAmbiente ambiente, String senha, String diretorio) throws Exception {  

    	String sep = File.separator;
    	char[] passphrase = senha.toCharArray();  

    	if (diretorio == null) {
    		diretorio = "";
    	}
    	if (!diretorio.endsWith(sep) && !diretorio.isEmpty()) {
    		diretorio += sep;
    	}

    	File file = new File(diretorio + JSSECACERTS);

    	if (file.isFile() == false) {  
    		File dir = new File(System.getProperty("java.home") + sep + "lib" + sep + "security");  
    		file = new File(dir, JSSECACERTS);  
    		if (file.isFile() == false) {  
    			file = new File(dir, "cacerts");  
    		}  
    	}

    	File cafile = new File(diretorio + JSSECACERTS);

    	try (InputStream in = new FileInputStream(file); OutputStream out = new FileOutputStream(cafile)) {

    		info("| Loading KeyStore " + file + "...");
    		KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());  
    		ks.load(in, passphrase);  

    		for (NFAutorizador31 aut : NFAutorizador31.values()) {

    			//Para NFe...
    			String urlNfe = aut.getNfeConsultaProtocolo(ambiente);
    			urlNfe = getDomainName(urlNfe);
    			get(urlNfe, 443, ks);

    			//Para NFCe...
    			String urlNfce = aut.getNfceStatusServico(ambiente);
    			if (urlNfce != null) {
    				urlNfce = getDomainName(urlNfce);
    				if (urlNfce != null) {
    					get(urlNfce, 443, ks);
    				}
    			}
    		}

    		ks.store(out, passphrase);

    	} catch (Exception e) {  
    		throw e;  
    	}
    }
    
    private static String getDomainName(String url) throws URISyntaxException {
    	
    	if (url == null) {
    		return null;
    	}
    	
        URI uri = new URI(url);
        String domain = uri.getHost();
        return domain.startsWith("www.") ? domain.substring(4) : domain;
    }
  
    private static void get(String host, int port, KeyStore ks) throws Exception {  
        SSLContext context = SSLContext.getInstance("TLS");  
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(  
                TrustManagerFactory.getDefaultAlgorithm());  
        tmf.init(ks);  
        X509TrustManager defaultTrustManager = (X509TrustManager) tmf.getTrustManagers()[0];  
        SavingTrustManager tm = new SavingTrustManager(defaultTrustManager);  
        context.init(null, new TrustManager[] { tm }, null);  
        SSLSocketFactory factory = context.getSocketFactory();  
       
        info("| Opening connection to " + host + ":" + port + "...");  
        SSLSocket socket = (SSLSocket) factory.createSocket(host, port);  
        socket.setSoTimeout(TIMEOUT_WS * 1000);  
        try {  
            info("| Starting SSL handshake...");  
            socket.startHandshake();  
            socket.close();  
            info("| No errors, certificate is already trusted");  
        } catch (SSLHandshakeException e) {  
            /** 
             * PKIX path building failed:  
             * sun.security.provider.certpath.SunCertPathBuilderException:  
             * unable to find valid certification path to requested target 
             * Não tratado, pois sempre ocorre essa exceção quando o cacerts 
             * nao esta gerado. 
             */  
        } catch (SSLException e) {  
            error("| " + e.toString());  
        }  
          
        X509Certificate[] chain = tm.chain;  
        if (chain == null) {  
            info("| Could not obtain server certificate chain");  
        }  
  
        info("| Server sent " + chain.length + " certificate(s):");  
        MessageDigest sha1 = MessageDigest.getInstance("SHA1");  
        MessageDigest md5 = MessageDigest.getInstance("MD5");  
        for (int i = 0; i < chain.length; i++) {  
            X509Certificate cert = chain[i];  
            sha1.update(cert.getEncoded());  
            md5.update(cert.getEncoded());  
              
            String alias = host + "-" + (i);  
            ks.setCertificateEntry(alias, cert);  
            info("| Added certificate to keystore '" + JSSECACERTS + "' using alias '" + alias + "'");            
        }  
    }  
  
    private static class SavingTrustManager implements X509TrustManager {  
        private final X509TrustManager tm;  
        private X509Certificate[] chain;  
       
        SavingTrustManager(X509TrustManager tm) {  
            this.tm = tm;  
        }  
       
        public X509Certificate[] getAcceptedIssuers() {  
            throw new UnsupportedOperationException();  
        }  
       
        public void checkClientTrusted(X509Certificate[] chain, String authType)  
            throws CertificateException {  
            throw new UnsupportedOperationException();  
        }  
       
        public void checkServerTrusted(X509Certificate[] chain, String authType)  
            throws CertificateException {  
            this.chain = chain;  
            tm.checkServerTrusted(chain, authType);  
        }  
    }  
      
    private static void info(String log) {  
        System.out.println("INFO: " + log);  
    }  
  
    private static void error(String log) {  
        System.out.println("ERROR: " + log);  
    }  
  
}
