package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFModalidadeFreteTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", NFModalidadeFrete.CONTRATACAO_POR_CONTA_DO_EMITENTE.getCodigo());
        Assert.assertEquals("1", NFModalidadeFrete.CONTRATACAO_POR_CONTA_DO_DESTINATARIO_REMETENTE.getCodigo());
        Assert.assertEquals("2", NFModalidadeFrete.CONTRATACAO_POR_CONTA_DE_TERCEIROS.getCodigo());
        Assert.assertEquals("3", NFModalidadeFrete.PROPRIO_POR_CONTA_DO_REMETENTE.getCodigo());
        Assert.assertEquals("4", NFModalidadeFrete.PROPRIO_POR_CONTA_DO_DESTINATARIO.getCodigo());
        Assert.assertEquals("9", NFModalidadeFrete.SEM_OCORRENCIA_TRANSPORTE.getCodigo());
    }
}
