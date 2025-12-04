package com.fincatto.documentofiscal.utils;

import com.fincatto.documentofiscal.DFAmbiente;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;

@Ignore("A gera\u00e7\u00e3o de cadeia \u00e9 lenta, s\u00f3 deve ser rodado quando efetivamente for testada!")
public class DFCadeiaCertificadosTest {

    @Test
    @Ignore("Geracao de cacerts de homologacao. Executar sob demanda.")
    public void geraCadeiaCertificadoHomologacao() throws Exception {
        final byte[] cadeia = DFCadeiaCertificados.geraCadeiaCertificados(DFAmbiente.HOMOLOGACAO, "senha");
        FileUtils.writeByteArrayToFile(new File("/tmp/cacerts_homologacao.jks"), cadeia);
        Assert.assertTrue(cadeia.length > 0);
    }

    @Test
    @Ignore("Geracao de cacerts de producao. Executar sob demanda.")
    public void geraCadeiaCertificadoProducao() throws Exception {
        final byte[] cadeia = DFCadeiaCertificados.geraCadeiaCertificados(DFAmbiente.PRODUCAO, "senha");
        FileUtils.writeByteArrayToFile(new File("/tmp/cacerts_producao.jks"), cadeia);
        Assert.assertTrue(cadeia.length > 0);
    }
}
