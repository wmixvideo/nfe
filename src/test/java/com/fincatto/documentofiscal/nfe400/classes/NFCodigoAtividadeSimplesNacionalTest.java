package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFCodigoAtividadeSimplesNacionalTest {

    @Test
    public void deveObterPeloCodigoCorretamente() {
        Assertions.assertEquals(NFCodigoAtividadeSimplesNacional.REVENDA_OU_INDUSTRIALIZACAO_ANEXO_I, NFCodigoAtividadeSimplesNacional.valueOfCodigo("01"));
        Assertions.assertEquals(NFCodigoAtividadeSimplesNacional.DEMAIS_BENS_SEM_ICMS_ANEXO_I, NFCodigoAtividadeSimplesNacional.valueOfCodigo("02"));
        Assertions.assertEquals(NFCodigoAtividadeSimplesNacional.INDUSTRIALIZACAO_INCENTIVADA_ZFM_ANEXO_II, NFCodigoAtividadeSimplesNacional.valueOfCodigo("03"));
        Assertions.assertEquals(NFCodigoAtividadeSimplesNacional.DEMAIS_BENS_INDUSTRIALIZACAO_INCENTIVADA_ZFM_SEM_ICMS_ANEXO_II, NFCodigoAtividadeSimplesNacional.valueOfCodigo("04"));
        Assertions.assertEquals(NFCodigoAtividadeSimplesNacional.OPERACOES_NAO_TRIBUTAVEIS, NFCodigoAtividadeSimplesNacional.valueOfCodigo("90"));
    }

    @Test
    public void deveObterNuloCasoNaoExistaCodigo() {
        Assertions.assertNull(NFCodigoAtividadeSimplesNacional.valueOfCodigo("1"));
        Assertions.assertNull(NFCodigoAtividadeSimplesNacional.valueOfCodigo("05"));
    }

    @Test
    public void deveRetornarStringficadoCorretamente() {
        Assertions.assertEquals("90 - Operações não tributáveis", NFCodigoAtividadeSimplesNacional.OPERACOES_NAO_TRIBUTAVEIS.toString());
    }
}
