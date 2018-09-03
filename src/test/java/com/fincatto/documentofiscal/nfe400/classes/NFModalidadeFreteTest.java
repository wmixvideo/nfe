package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFModalidadeFreteTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", NFModalidadeFrete.CONTRATACAO_POR_CONTA_DO_REMETENTE.getCodigo());
        Assert.assertEquals("1", NFModalidadeFrete.CONTRATACAO_POR_CONTA_DO_DESTINATARIO.getCodigo());
        Assert.assertEquals("2", NFModalidadeFrete.CONTRATACAO_POR_CONTA_DE_TERCEIROS.getCodigo());
        Assert.assertEquals("3", NFModalidadeFrete.PROPRIO_POR_CONTA_DO_REMETENTE.getCodigo());
        Assert.assertEquals("4", NFModalidadeFrete.PROPRIO_POR_CONTA_DO_DESTINATARIO.getCodigo());
        Assert.assertEquals("9", NFModalidadeFrete.SEM_OCORRENCIA_TRANSPORTE.getCodigo());
    }

    @Test
    public void deveObterTipoApartirDoSeuCodigo() {
        Assert.assertEquals(NFModalidadeFrete.CONTRATACAO_POR_CONTA_DO_REMETENTE, NFModalidadeFrete.valueOfCodigo("0"));
        Assert.assertEquals(NFModalidadeFrete.CONTRATACAO_POR_CONTA_DO_DESTINATARIO, NFModalidadeFrete.valueOfCodigo("1"));
        Assert.assertEquals(NFModalidadeFrete.CONTRATACAO_POR_CONTA_DE_TERCEIROS, NFModalidadeFrete.valueOfCodigo("2"));
        Assert.assertEquals(NFModalidadeFrete.PROPRIO_POR_CONTA_DO_REMETENTE, NFModalidadeFrete.valueOfCodigo("3"));
        Assert.assertEquals(NFModalidadeFrete.PROPRIO_POR_CONTA_DO_DESTINATARIO, NFModalidadeFrete.valueOfCodigo("4"));
        Assert.assertEquals(NFModalidadeFrete.SEM_OCORRENCIA_TRANSPORTE, NFModalidadeFrete.valueOfCodigo("9"));
    }
}
