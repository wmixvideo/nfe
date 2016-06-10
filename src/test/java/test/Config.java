package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;

public class Config extends NFeConfig {

	private KeyStore keyStoreCertificado = null;

	private KeyStore keyStoreCadeia = null;

	@Override
	public NFUnidadeFederativa getCUF() {
		return NFUnidadeFederativa.MA;
	}

	@Override
	public String getCertificadoSenha() {
		return "";
	}

	@Override
	public String getCadeiaCertificadosSenha() {
		return "123456";
	}

	@Override
	public KeyStore getCertificadoKeyStore() throws KeyStoreException {
		if (keyStoreCertificado == null) {
			keyStoreCertificado = KeyStore.getInstance("PKCS12");
			try (InputStream certificadoStream = new FileInputStream("c:/users/welyab/downloads/ecnpj2016.pfx")) {
				keyStoreCertificado.load(certificadoStream, this.getCertificadoSenha().toCharArray());
			} catch (CertificateException | NoSuchAlgorithmException | IOException e) {
				keyStoreCadeia = null;
				throw new KeyStoreException("Nao foi possibel montar o KeyStore com a cadeia de certificados", e);
			}
		}
		return keyStoreCertificado;
	}

	@Override
	public KeyStore getCadeiaCertificadosKeyStore() throws KeyStoreException {
		if (keyStoreCadeia == null) {
			keyStoreCadeia = KeyStore.getInstance("JKS");
			try (InputStream cadeia = new FileInputStream("C:/Users/Welyab/Documents/cadeia/cadeia.jks")) {
				keyStoreCadeia.load(cadeia, this.getCadeiaCertificadosSenha().toCharArray());
			} catch (CertificateException | NoSuchAlgorithmException | IOException e) {
				keyStoreCadeia = null;
				throw new KeyStoreException("Nao foi possibel montar o KeyStore com o certificado", e);
			}
		}
		return keyStoreCadeia;
	}
}
