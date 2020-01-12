package com.fincatto.documentofiscal.utils;

import com.fincatto.documentofiscal.DFConfig;
import com.fincatto.documentofiscal.DFLog;

import javax.net.ssl.X509KeyManager;
import java.net.Socket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

/**
 * Created by Eldevan Nery Junior on 18/10/19.
 */
public class DFKeyManager implements X509KeyManager, DFLog {
    
    private KeyStore ks;
    private String alias;
    private String password;
    
    public DFKeyManager(DFConfig config) throws KeyStoreException {
        this.ks = config.getCertificadoKeyStore();
        this.alias = getAlias(this.ks);
        this.password = config.getCertificadoSenha();
    }
    
    public String chooseClientAlias(String[] str, Principal[] principal, Socket socket) {
        return alias;
    }
    
    public String chooseServerAlias(String str, Principal[] principal, Socket socket) {
        return alias;
    }
    
    public String[] getClientAliases(String str, Principal[] principal) {
        return new String[]{alias};
    }
    
    public String[] getServerAliases(String str, Principal[] principal) {
        return new String[]{alias};
    }
    
    public X509Certificate[] getCertificateChain(String alias) {
        try {
            Certificate[] certificates = this.ks.getCertificateChain(alias);
            X509Certificate[] x509Certificates = new X509Certificate[certificates.length];
            System.arraycopy(certificates, 0, x509Certificates, 0, certificates.length);
            return x509Certificates;
        } catch (KeyStoreException e) {
            this.getLogger().error("N\u00e3o foi poss\u00edvel carregar o keystore para o alias:" + alias, e);
            return null;
        }
    }
    
    public PrivateKey getPrivateKey(String alias) {
        try {
            return (PrivateKey) ks.getKey(alias, password == null ? null : password.toCharArray());
        } catch (Exception e) {
            this.getLogger().error("N\u00e3o foi poss\u00edvel carregar o keystore para o alias:" + alias, e);
            return null;
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
        throw new KeyStoreException("Nenhum alias encontrado no certificado");
    }
}