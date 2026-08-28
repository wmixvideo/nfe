package com.fincatto.documentofiscal.utils;

import com.fincatto.documentofiscal.DFConfig;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.KeyStore;
import java.security.cert.X509Certificate;

/**
 * Testa {@link DFKeyManager} com um keystore de mais de uma chave, cenario em que
 * {@link DFConfig#getCertificadoAlias()} precisa ser respeitado para que o certificado
 * apresentado no handshake mTLS seja o mesmo usado para assinar o XML.
 *
 * @author Marcos Lombardi de Andrade
 */
public class DFKeyManagerTest {

    // keytool exige senha de chave com pelo menos 6 caracteres
    private static final String SENHA = "senha123";
    private static final String ALIAS_PRIMEIRO = "primeiro";
    private static final String ALIAS_SEGUNDO = "segundo";

    private Path keystorePath;

    @AfterAll
    public void removeKeystoreTemporario() throws IOException {
        if (this.keystorePath != null) {
            Files.deleteIfExists(this.keystorePath);
        }
    }

    @Test
    public void deveUsarOAliasConfiguradoQuandoOKeystoreTemMaisDeUmaChave() throws Exception {
        this.keystorePath = DFKeyManagerTest.criarKeystoreComDoisAliases();
        final KeyStore keyStore = DFKeyManagerTest.carregarKeystore(this.keystorePath);

        final DFKeyManager keyManager = new DFKeyManager(new DFConfigTeste(keyStore, DFKeyManagerTest.ALIAS_SEGUNDO));

        Assertions.assertEquals(DFKeyManagerTest.ALIAS_SEGUNDO, keyManager.chooseClientAlias(null, null, null));
        final X509Certificate[] cadeia = keyManager.getCertificateChain(DFKeyManagerTest.ALIAS_SEGUNDO);
        Assertions.assertEquals("CN=segundo", cadeia[0].getSubjectX500Principal().getName());
        Assertions.assertNotNull(keyManager.getPrivateKey(DFKeyManagerTest.ALIAS_SEGUNDO));
    }

    @Test
    public void deveCairNoPrimeiroAliasDeChaveQuandoNenhumAliasForConfigurado() throws Exception {
        this.keystorePath = DFKeyManagerTest.criarKeystoreComDoisAliases();
        final KeyStore keyStore = DFKeyManagerTest.carregarKeystore(this.keystorePath);

        final DFKeyManager keyManager = new DFKeyManager(new DFConfigTeste(keyStore, null));

        final String aliasEscolhido = keyManager.chooseClientAlias(null, null, null);
        Assertions.assertTrue(DFKeyManagerTest.ALIAS_PRIMEIRO.equals(aliasEscolhido) || DFKeyManagerTest.ALIAS_SEGUNDO.equals(aliasEscolhido));
        Assertions.assertNotNull(keyManager.getPrivateKey(aliasEscolhido));
    }

    private static Path criarKeystoreComDoisAliases() throws IOException, InterruptedException {
        final Path path = Files.createTempFile("dfkeymanager-teste", ".p12");
        Files.deleteIfExists(path);
        DFKeyManagerTest.gerarChave(path, DFKeyManagerTest.ALIAS_PRIMEIRO, "CN=primeiro");
        DFKeyManagerTest.gerarChave(path, DFKeyManagerTest.ALIAS_SEGUNDO, "CN=segundo");
        return path;
    }

    private static void gerarChave(final Path keystorePath, final String alias, final String dn) throws IOException, InterruptedException {
        final Process processo = new ProcessBuilder(
                "keytool", "-genkeypair",
                "-alias", alias,
                "-keyalg", "RSA",
                "-keysize", "1024",
                "-validity", "1",
                "-dname", dn,
                "-keystore", keystorePath.toString(),
                "-storetype", "PKCS12",
                "-storepass", DFKeyManagerTest.SENHA,
                "-keypass", DFKeyManagerTest.SENHA)
                .redirectErrorStream(true)
                .start();
        final int codigoSaida = processo.waitFor();
        if (codigoSaida != 0) {
            throw new IllegalStateException("keytool falhou ao gerar o alias '" + alias + "', codigo de saida " + codigoSaida);
        }
    }

    private static KeyStore carregarKeystore(final Path path) throws Exception {
        final KeyStore keyStore = KeyStore.getInstance("PKCS12");
        try (InputStream entrada = Files.newInputStream(path)) {
            keyStore.load(entrada, DFKeyManagerTest.SENHA.toCharArray());
        }
        return keyStore;
    }

    private static class DFConfigTeste extends DFConfig {
        private final KeyStore keyStore;
        private final String alias;

        DFConfigTeste(final KeyStore keyStore, final String alias) {
            this.keyStore = keyStore;
            this.alias = alias;
        }

        @Override
        public DFUnidadeFederativa getCUF() {
            return null;
        }

        @Override
        public KeyStore getCertificadoKeyStore() {
            return this.keyStore;
        }

        @Override
        public String getCertificadoAlias() {
            return this.alias;
        }

        @Override
        public String getCertificadoSenha() {
            return DFKeyManagerTest.SENHA;
        }

        @Override
        public KeyStore getCadeiaCertificadosKeyStore() {
            return null;
        }

        @Override
        public String getCadeiaCertificadosSenha() {
            return null;
        }
    }
}
