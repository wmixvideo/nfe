package com.fincatto.documentofiscal.nfe310.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoSituacaoTributariaIPITest {

    @Test
    public void deveObterSituacaoTributariaIPIApartirDoSeuCodigo() {
        Assertions.assertEquals(NFNotaInfoSituacaoTributariaIPI.ENTRADA_RECUPERACAO_CREDITO, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("00"));
        Assertions.assertEquals(NFNotaInfoSituacaoTributariaIPI.ENTRADA_TRIBUTADA_ALIQUOTA_ZERO, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("01"));
        Assertions.assertEquals(NFNotaInfoSituacaoTributariaIPI.ENTRADA_ISENTA, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("02"));
        Assertions.assertEquals(NFNotaInfoSituacaoTributariaIPI.ENTRADA_NAO_TRIBUTADA, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("03"));
        Assertions.assertEquals(NFNotaInfoSituacaoTributariaIPI.ENTRADA_IMUNE, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("04"));
        Assertions.assertEquals(NFNotaInfoSituacaoTributariaIPI.ENTRADA_COM_SUSPENSAO, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("05"));
        Assertions.assertEquals(NFNotaInfoSituacaoTributariaIPI.OUTRAS_ENTRADAS, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("49"));
        Assertions.assertEquals(NFNotaInfoSituacaoTributariaIPI.SAIDA_TRIBUTADA, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("50"));
        Assertions.assertEquals(NFNotaInfoSituacaoTributariaIPI.SAIDA_TRIBUTADA_COM_ALIQUOTA_ZERO, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("51"));
        Assertions.assertEquals(NFNotaInfoSituacaoTributariaIPI.SAIDA_ISENTA, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("52"));
        Assertions.assertEquals(NFNotaInfoSituacaoTributariaIPI.SAIDA_NAO_TRIBUTADA, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("53"));
        Assertions.assertEquals(NFNotaInfoSituacaoTributariaIPI.SAIDA_IMUNE, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("54"));
        Assertions.assertEquals(NFNotaInfoSituacaoTributariaIPI.SAIDA_COM_SUSPENSAO, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("55"));
        Assertions.assertEquals(NFNotaInfoSituacaoTributariaIPI.OUTRAS_SAIDAS, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("99"));
        Assertions.assertNull(NFNotaInfoSituacaoTributariaIPI.valueOfCodigo(""));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("00", NFNotaInfoSituacaoTributariaIPI.ENTRADA_RECUPERACAO_CREDITO.getCodigo());
        Assertions.assertEquals("01", NFNotaInfoSituacaoTributariaIPI.ENTRADA_TRIBUTADA_ALIQUOTA_ZERO.getCodigo());
        Assertions.assertEquals("02", NFNotaInfoSituacaoTributariaIPI.ENTRADA_ISENTA.getCodigo());
        Assertions.assertEquals("03", NFNotaInfoSituacaoTributariaIPI.ENTRADA_NAO_TRIBUTADA.getCodigo());
        Assertions.assertEquals("04", NFNotaInfoSituacaoTributariaIPI.ENTRADA_IMUNE.getCodigo());
        Assertions.assertEquals("05", NFNotaInfoSituacaoTributariaIPI.ENTRADA_COM_SUSPENSAO.getCodigo());
        Assertions.assertEquals("49", NFNotaInfoSituacaoTributariaIPI.OUTRAS_ENTRADAS.getCodigo());
        Assertions.assertEquals("50", NFNotaInfoSituacaoTributariaIPI.SAIDA_TRIBUTADA.getCodigo());
        Assertions.assertEquals("51", NFNotaInfoSituacaoTributariaIPI.SAIDA_TRIBUTADA_COM_ALIQUOTA_ZERO.getCodigo());
        Assertions.assertEquals("52", NFNotaInfoSituacaoTributariaIPI.SAIDA_ISENTA.getCodigo());
        Assertions.assertEquals("53", NFNotaInfoSituacaoTributariaIPI.SAIDA_NAO_TRIBUTADA.getCodigo());
        Assertions.assertEquals("54", NFNotaInfoSituacaoTributariaIPI.SAIDA_IMUNE.getCodigo());
        Assertions.assertEquals("55", NFNotaInfoSituacaoTributariaIPI.SAIDA_COM_SUSPENSAO.getCodigo());
        Assertions.assertEquals("99", NFNotaInfoSituacaoTributariaIPI.OUTRAS_SAIDAS.getCodigo());
    }
}