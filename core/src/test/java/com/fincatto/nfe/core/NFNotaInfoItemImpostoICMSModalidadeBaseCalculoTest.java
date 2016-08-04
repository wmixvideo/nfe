package com.fincatto.nfe.core;

import org.junit.Assert;
import org.junit.Test;

/**
 * @deprecated Utilizar NFNotaInfoItemModalidadeBCICMSTest.class
 */
@Deprecated
public class NFNotaInfoItemImpostoICMSModalidadeBaseCalculoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", NFNotaInfoItemImpostoICMSModalidadeBaseCalculo.MVA.getCodigo());
        Assert.assertEquals("1", NFNotaInfoItemImpostoICMSModalidadeBaseCalculo.PAUTA.getCodigo());
        Assert.assertEquals("2", NFNotaInfoItemImpostoICMSModalidadeBaseCalculo.PRECO_TABELADO_MAXIMO.getCodigo());
        Assert.assertEquals("3", NFNotaInfoItemImpostoICMSModalidadeBaseCalculo.VALOR_OPERACAO.getCodigo());
    }
}