package com.fincatto.documentofiscal.utils;

import com.fincatto.documentofiscal.DFAmbiente;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@Ignore("A gera\u00e7\u00e3o de cadeia \u00e9 lenta, s\u00f3 deve ser rodado quando efetivamente for testada!")
public class GeraCadeiaCertificadosTest {

    @Test
    public void geraCadeiaCertificadoHomologacao() throws Exception {
        final byte[] cadeia = GeraCadeiaCertificados.geraCadeiaCertificados(DFAmbiente.HOMOLOGACAO, "senha");
        Assert.assertTrue(cadeia.length > 0);
    }

    @Test
    public void geraCadeiaCertificadoProducao() throws Exception {
        final byte[] cadeia = GeraCadeiaCertificados.geraCadeiaCertificados(DFAmbiente.PRODUCAO, "senha");
        Assert.assertTrue(cadeia.length > 0);
    }
}
