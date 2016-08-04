package com.fincatto.nfe.core.utils;

import com.fincatto.nfe.core.NFAmbiente;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Diego Fincatto on 07/05/16.
 */
public class NFGeraCadeiaCertificadosTest {

    @Test
    public void geraCadeiaCertificadoHomologacao() throws Exception {
        final byte[] cadeia = NFGeraCadeiaCertificados.geraCadeiaCertificados(NFAmbiente.HOMOLOGACAO, "senha");
        Assert.assertTrue(cadeia.length > 0);
    }

    @Test
    public void geraCadeiaCertificadoProducao() throws Exception {
        final byte[] cadeia = NFGeraCadeiaCertificados.geraCadeiaCertificados(NFAmbiente.PRODUCAO, "senha");
        Assert.assertTrue(cadeia.length > 0);
    }
}