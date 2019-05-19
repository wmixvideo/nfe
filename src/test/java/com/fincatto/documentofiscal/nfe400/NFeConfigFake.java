package com.fincatto.documentofiscal.nfe400;

import com.fincatto.documentofiscal.DFConfig;
import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.TimeZone;

public class NFeConfigFake extends NFeConfig implements DFLog {

    private KeyStore keyStoreCertificado = null;
    private KeyStore keyStoreCadeia = null;

    @Override
    public DFUnidadeFederativa getCUF() {
        return DFUnidadeFederativa.SC;
    }

    @Override
    public KeyStore getCertificadoKeyStore() throws KeyStoreException {
        if (this.keyStoreCertificado == null) {
            this.keyStoreCertificado = KeyStore.getInstance("PKCS12");
            try (InputStream certificadoStream = NFeConfigFake.class.getResourceAsStream("homologacao.pfx")) {
                this.keyStoreCertificado.load(certificadoStream, this.getCertificadoSenha().toCharArray());
            } catch (CertificateException | NoSuchAlgorithmException | IOException e) {
                this.keyStoreCadeia = null;
                throw new KeyStoreException("Nao foi possibel montar o KeyStore com a cadeia de certificados", e);
            }
        }
        return this.keyStoreCertificado;
    }

    @Override
    public String getCertificadoSenha() {
        return "senha";
    }

    @Override
    public KeyStore getCadeiaCertificadosKeyStore() throws KeyStoreException {
        if (this.keyStoreCadeia == null) {
            this.keyStoreCadeia = KeyStore.getInstance("JKS");
            try (InputStream cadeia = NFeConfigFake.class.getResourceAsStream("homologacao.cacerts")) {
                this.keyStoreCadeia.load(cadeia, this.getCadeiaCertificadosSenha().toCharArray());
            } catch (CertificateException | NoSuchAlgorithmException | IOException e) {
                this.keyStoreCadeia = null;
                throw new KeyStoreException("Nao foi possibel montar o KeyStore com o certificado", e);
            }
        }
        return this.keyStoreCadeia;
    }

    @Override
    public String getCadeiaCertificadosSenha() {
        return "senha";
    }

    @Override
    public String getCertificadoAlias() {
        try {
            return this.getCertificadoKeyStore().aliases().nextElement();
        } catch (final KeyStoreException e) {
            getLogger().error("Erro ao identificar alias", e);
        }
        return null;
    }
    
    @Override
    public TimeZone getTimeZone() {
        return DFConfig.TIMEZONE_SP;
    }
}