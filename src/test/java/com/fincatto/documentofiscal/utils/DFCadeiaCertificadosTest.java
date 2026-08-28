package com.fincatto.documentofiscal.utils;

import com.fincatto.documentofiscal.DFAmbiente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("A gera\u00e7\u00e3o de cadeia \u00e9 lenta, s\u00f3 deve ser rodado quando efetivamente for testada!")
public class DFCadeiaCertificadosTest {

    @Test
    public void geraCadeiaCertificadoHomologacao() throws Exception {
        final byte[] cadeia = DFCadeiaCertificados.geraCadeiaCertificados(DFAmbiente.HOMOLOGACAO, "senha");
        Assertions.assertTrue(cadeia.length > 0);
    }

    @Test
    public void geraCadeiaCertificadoProducao() throws Exception {
        final byte[] cadeia = DFCadeiaCertificados.geraCadeiaCertificados(DFAmbiente.PRODUCAO, "senha");
        Assertions.assertTrue(cadeia.length > 0);
    }
}
