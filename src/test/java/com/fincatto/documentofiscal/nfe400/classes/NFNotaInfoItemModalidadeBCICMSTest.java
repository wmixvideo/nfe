package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFNotaInfoItemModalidadeBCICMSTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", NFNotaInfoItemModalidadeBCICMS.MVA.getCodigo());
        Assert.assertEquals("1", NFNotaInfoItemModalidadeBCICMS.PAUTA.getCodigo());
        Assert.assertEquals("2", NFNotaInfoItemModalidadeBCICMS.PRECO_TABELADO_MAXIMO.getCodigo());
        Assert.assertEquals("3", NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO.getCodigo());
    }
}