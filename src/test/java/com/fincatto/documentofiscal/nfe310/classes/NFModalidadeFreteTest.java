package com.fincatto.documentofiscal.nfe310.classes;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.classes.NFModalidadeFrete;

public class NFModalidadeFreteTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", NFModalidadeFrete.POR_CONTA_DO_EMITENTE.getCodigo());
        Assert.assertEquals("1", NFModalidadeFrete.POR_CONTA_DO_DESTINATARIO_REMETENTE.getCodigo());
        Assert.assertEquals("2", NFModalidadeFrete.POR_CONTA_DE_TERCEIROS.getCodigo());
        Assert.assertEquals("9", NFModalidadeFrete.SEM_FRETE.getCodigo());
    }
}
