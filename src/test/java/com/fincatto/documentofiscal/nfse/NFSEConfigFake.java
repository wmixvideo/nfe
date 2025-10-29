package com.fincatto.documentofiscal.nfse;

import com.fincatto.documentofiscal.DFUnidadeFederativa;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;

public class NFSEConfigFake extends NFSeConfig {

    private final String certificadoPath;
    private final String certificadoSenha;
    private final String cadeiaCertificadosPath;
    private final String cadeiaCertificadosSenha;
    private KeyStore keyStoreCertificado = null;
        private KeyStore keyStoreCadeia = null;

    public NFSEConfigFake(final String certificadoPath, final String certificadoSenha, final String cadeiaCertificadosPath, final String cadeiaCertificadosSenha) {
        this.certificadoPath = certificadoPath;
        this.certificadoSenha = certificadoSenha;
        this.cadeiaCertificadosPath = cadeiaCertificadosPath;
        this.cadeiaCertificadosSenha = cadeiaCertificadosSenha;
    }

    @Override
        public DFUnidadeFederativa getCUF() {
            return DFUnidadeFederativa.SC;
        }

        @Override
        public String getCertificadoSenha() {
            return this.certificadoSenha;
        }

        @Override
        public String getCadeiaCertificadosSenha() {
            return this.cadeiaCertificadosSenha;
        }

        @Override
        public KeyStore getCertificadoKeyStore() throws KeyStoreException {
            if (this.keyStoreCertificado == null) {
                this.keyStoreCertificado = KeyStore.getInstance("PKCS12");
                try (InputStream certificadoStream = new FileInputStream(this.certificadoPath)) {
                    this.keyStoreCertificado.load(certificadoStream, this.getCertificadoSenha().toCharArray());
                } catch (CertificateException | NoSuchAlgorithmException | IOException e) {
                    this.keyStoreCadeia = null;
                    throw new KeyStoreException("Nao foi possivel montar o KeyStore com a cadeia de certificados", e);
                }
            }
            return this.keyStoreCertificado;
        }

        @Override
        public KeyStore getCadeiaCertificadosKeyStore() throws KeyStoreException {
            if (this.keyStoreCadeia == null) {
                this.keyStoreCadeia = KeyStore.getInstance("JKS");
                try (InputStream cadeia = new FileInputStream(this.cadeiaCertificadosPath)) {
                    this.keyStoreCadeia.load(cadeia, this.getCadeiaCertificadosSenha().toCharArray());
                } catch (CertificateException | NoSuchAlgorithmException | IOException e) {
                    this.keyStoreCadeia = null;
                    throw new KeyStoreException("Nao foi possivel montar o KeyStore com o certificado", e);
                }
            }
            return this.keyStoreCadeia;
        }
    }
