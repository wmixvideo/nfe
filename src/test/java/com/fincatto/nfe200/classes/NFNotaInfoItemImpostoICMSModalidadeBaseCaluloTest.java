package com.fincatto.nfe200.classes;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe200.classes.NFNotaInfoItemImpostoICMSModalidadeBaseCalulo;

public class NFNotaInfoItemImpostoICMSModalidadeBaseCaluloTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.MVA.getCodigo());
        Assert.assertEquals("1", NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.PAUTA.getCodigo());
        Assert.assertEquals("2", NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.PRECO_TABELADO_MAXIMO.getCodigo());
        Assert.assertEquals("3", NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO.getCodigo());
    }
}