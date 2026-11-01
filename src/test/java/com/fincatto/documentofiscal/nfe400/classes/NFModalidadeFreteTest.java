package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFModalidadeFreteTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("0", NFModalidadeFrete.CONTRATACAO_POR_CONTA_DO_REMETENTE.getCodigo());
        Assertions.assertEquals("1", NFModalidadeFrete.CONTRATACAO_POR_CONTA_DO_DESTINATARIO.getCodigo());
        Assertions.assertEquals("2", NFModalidadeFrete.CONTRATACAO_POR_CONTA_DE_TERCEIROS.getCodigo());
        Assertions.assertEquals("3", NFModalidadeFrete.PROPRIO_POR_CONTA_DO_REMETENTE.getCodigo());
        Assertions.assertEquals("4", NFModalidadeFrete.PROPRIO_POR_CONTA_DO_DESTINATARIO.getCodigo());
        Assertions.assertEquals("9", NFModalidadeFrete.SEM_OCORRENCIA_TRANSPORTE.getCodigo());
    }

    @Test
    public void deveObterTipoApartirDoSeuCodigo() {
        Assertions.assertEquals(NFModalidadeFrete.CONTRATACAO_POR_CONTA_DO_REMETENTE, NFModalidadeFrete.valueOfCodigo("0"));
        Assertions.assertEquals(NFModalidadeFrete.CONTRATACAO_POR_CONTA_DO_DESTINATARIO, NFModalidadeFrete.valueOfCodigo("1"));
        Assertions.assertEquals(NFModalidadeFrete.CONTRATACAO_POR_CONTA_DE_TERCEIROS, NFModalidadeFrete.valueOfCodigo("2"));
        Assertions.assertEquals(NFModalidadeFrete.PROPRIO_POR_CONTA_DO_REMETENTE, NFModalidadeFrete.valueOfCodigo("3"));
        Assertions.assertEquals(NFModalidadeFrete.PROPRIO_POR_CONTA_DO_DESTINATARIO, NFModalidadeFrete.valueOfCodigo("4"));
        Assertions.assertEquals(NFModalidadeFrete.SEM_OCORRENCIA_TRANSPORTE, NFModalidadeFrete.valueOfCodigo("9"));
    }
}
