package com.fincatto.documentofiscal.cte300.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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

import com.fincatto.documentofiscal.cte300.CTConfig;
import com.fincatto.documentofiscal.cte300.classes.CTAutorizador31;

public class CTGeraCadeiaCertificados {

    private static String CACERTS_NAME = "";
    private static final char SEPARATOR = File.separatorChar;
    private static final int TIMEOUT_WS = 30; 

    private static CTConfig ctConfig;
    
	public CTGeraCadeiaCertificados(CTConfig cteConfig) {
		this.ctConfig = cteConfig;
		
		CACERTS_NAME = "NFeCacerts"+(cteConfig.getAmbiente().getCodigo().equals("1") ? "Producao" : "Homologacao" );
	}

	public String getCaminhoCacerts() {
		return CACERTS_NAME;
	}
	
	public static void geraCadeiaCertificadora() throws Exception{
		File fileExixte = new File(CACERTS_NAME);
		if(!fileExixte.isFile()){
			//senha do arquivo
			char[] passphrase = ctConfig.getCadeiaCertificadosSenha().toCharArray();
			
			//verifica existencia do diret�rio
			//File diretorio = new File(Config.getConfig().PASTA);
			//if(!diretorio.exists()){
				//diretorio.mkdir();
			//}
			
			//verificad existencia do arquivo
			File file = new File(CACERTS_NAME);
			if (file.isFile()) {
				file.delete();
			}
			
			File dir = new File(System.getProperty("java.home") + SEPARATOR
					+ "lib" + SEPARATOR + "security");
			file = new File(dir, CACERTS_NAME);
			if (file.isFile() == false) {
				file = new File(dir, "cacerts");
			}

			info("| Carregando chaves " + file + "...");
			InputStream in = new FileInputStream(file);
			//KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
			KeyStore ks = KeyStore.getInstance("jks");
			ks.load(in, passphrase);
			in.close();

			for (final CTAutorizador31 aut : CTAutorizador31.values()) {
				//Para NF-E
				if(aut.getCteStatusServico(ctConfig.getAmbiente()) != null){
					String urlNfe [] = aut.getCteStatusServico(ctConfig.getAmbiente()).split("//");
					urlNfe = urlNfe[1].split("/");
					final String urlNF = urlNfe[0];
					info("");
					info("| CT-E - ("+urlNF+")");
					get(urlNF, 443, ks);
				}
			}
			
			File cafile = new File(CACERTS_NAME);
			OutputStream out = new FileOutputStream(cafile);
			ks.store(out, passphrase);
			out.close();
		}
	}

	private static void get(String host, int port, KeyStore ks) throws Exception, SSLHandshakeException, SSLException {
		SSLContext context = SSLContext.getInstance(ctConfig.getSSLProtocolo());
		TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
		tmf.init(ks);
		X509TrustManager defaultTrustManager = (X509TrustManager) tmf.getTrustManagers()[0];
		SavingTrustManager tm = new SavingTrustManager(defaultTrustManager);
		context.init(null, new TrustManager[] { tm }, null);
		SSLSocketFactory factory = context.getSocketFactory();

		info("| Abrindo a conex�o " + host + ":" + port + "...");
		SSLSocket socket = (SSLSocket) factory.createSocket(host, port);
		//socket.setSoTimeout(TIMEOUT_WS * 1000);
		socket.setSoTimeout(10000);
		
		try {
			info("| Iniciando SSL ["+ctConfig.getSSLProtocolo()+"] handshake...");
			socket.startHandshake();
			socket.close();
			info("| Sem erros, certificado j� � confi�vel");
		} catch (final Exception e) {
			/**
			 * PKIX path building failed:
			 * sun.security.provider.certpath.SunCertPathBuilderException:
			 * unable to find valid certification path to requested target Não
			 * tratado, pois sempre ocorre essa exceo quando o cacerts nao esta
			 * gerado.
			 */
			info("| Incapaz de encontrar caminho de certifica��o v�lido para o destino solicitado = "+ host);
		} 


		if(tm.chain != null){
			X509Certificate[] chain = tm.chain;
			if (chain == null) {
				error("| N�o foi poss�vel obter a cadeia de certificados do servidor");
			} else {
				info("| Servidor enviou " + chain.length + " certificado(s):");
				MessageDigest sha1 = MessageDigest.getInstance("SHA1");
				MessageDigest md5 = MessageDigest.getInstance("MD5");
				for (int i = 0; i < chain.length; i++) {
					X509Certificate cert = chain[i];
					sha1.update(cert.getEncoded());
					md5.update(cert.getEncoded());
	
					String alias = host + "-" + (i);
					ks.setCertificateEntry(alias, cert);
					info("| Certificado adicionado ao armazenamento de chaves '" + CACERTS_NAME + "' utilizando '" + alias
							+ "'");
				}
			}
		}else{
			error("| N�o foi poss�vel obter a cadeia de certificados do servidor");
		}
	}

	private static class SavingTrustManager implements X509TrustManager {
		private final X509TrustManager tm;
		private X509Certificate[] chain;

		SavingTrustManager(X509TrustManager tm) {
			this.tm = tm;
		}

		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return new X509Certificate[0];
			// throw new UnsupportedOperationException();
		}

		@Override
		public void checkClientTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
			throw new UnsupportedOperationException();
		}

		@Override
		public void checkServerTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
			this.chain = chain;
			this.tm.checkServerTrusted(chain, authType);
		}
	}

	private static void info(String log) {
		System.out.println("INFO: " + log);
	}

	private static void error(String log) {
		System.out.println("ERROR: " + log);
	}

}
