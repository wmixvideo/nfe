package com.fincatto.documentofiscal.utils;

import com.fincatto.documentofiscal.DFConfig;
import com.fincatto.documentofiscal.DFLog;
import org.apache.commons.lang3.StringUtils;

import javax.net.ssl.X509KeyManager;
import java.net.Socket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

/**
 * Created by Eldevan Nery Junior on 18/10/19.
 */
public class DFKeyManager implements X509KeyManager, DFLog {
    
    private final KeyStore ks;
    private final String alias;
    // guardada como char[] (nao String) para reduzir a exposicao da senha em heap dumps
    private final char[] password;

    public DFKeyManager(DFConfig config) throws KeyStoreException {
        this.ks = config.getCertificadoKeyStore();
        // mesma prioridade usada por DFAssinaturaDigital.getPrivateKeyEntry(): honra o alias
        // configurado (necessario em keystores com mais de uma chave) e so cai no primeiro
        // alias de chave do keystore quando nenhum foi informado.
        this.alias = StringUtils.isNotBlank(config.getCertificadoAlias()) ? config.getCertificadoAlias() : getAlias(this.ks);
        this.password = config.getCertificadoSenha() == null ? null : config.getCertificadoSenha().toCharArray();
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
        // a interface X509KeyManager exige retorno null em caso de falha; o log preserva a causa
        // real, que de outra forma se perderia num handshake_failure generico
        try {
            Certificate[] certificates = this.ks.getCertificateChain(alias);
            if (certificates == null) {
                this.getLogger().error("Alias '{}' nao encontrado no keystore - cadeia de certificados vazia", alias);
                return null;
            }
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
            return (PrivateKey) ks.getKey(alias, password);
        } catch (UnrecoverableKeyException e) {
            this.getLogger().error("Senha do certificado incorreta para o alias:" + alias, e);
            return null;
        } catch (KeyStoreException | NoSuchAlgorithmException e) {
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