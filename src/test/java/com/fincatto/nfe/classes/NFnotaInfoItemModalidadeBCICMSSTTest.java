package com.fincatto.nfe.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFnotaInfoItemModalidadeBCICMSSTTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", NFnotaInfoItemModalidadeBCICMSST.PRECO_TABELADO.getCodigo());
        Assert.assertEquals("1", NFnotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA.getCodigo());
        Assert.assertEquals("2", NFnotaInfoItemModalidadeBCICMSST.LISTA_POSITIVA.getCodigo());
        Assert.assertEquals("3", NFnotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA.getCodigo());
        Assert.assertEquals("4", NFnotaInfoItemModalidadeBCICMSST.MARGEM_VALOR_AGREGADO.getCodigo());
        Assert.assertEquals("5", NFnotaInfoItemModalidadeBCICMSST.PAUTA.getCodigo());
    }
}