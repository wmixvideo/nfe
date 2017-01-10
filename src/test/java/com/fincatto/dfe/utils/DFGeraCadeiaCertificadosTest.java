package com.fincatto.dfe.utils;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.dfe.classes.DFAmbiente;
import com.fincatto.dfe.utils.DFGeraCadeiaCertificados;

/**
 * Created by Diego Fincatto on 07/05/16.
 */
public class DFGeraCadeiaCertificadosTest {

    @Test
    public void geraCadeiaCertificadoHomologacao() throws Exception {
        final byte[] cadeia = DFGeraCadeiaCertificados.geraCadeiaCertificados(DFAmbiente.HOMOLOGACAO, "senha");
        Assert.assertTrue(cadeia.length > 0);
    }

    @Test
    public void geraCadeiaCertificadoProducao() throws Exception {
        final byte[] cadeia = DFGeraCadeiaCertificados.geraCadeiaCertificados(DFAmbiente.PRODUCAO, "senha");
        Assert.assertTrue(cadeia.length > 0);
    }
}