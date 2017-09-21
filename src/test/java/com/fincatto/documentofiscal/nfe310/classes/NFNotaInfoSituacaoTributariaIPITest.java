package com.fincatto.documentofiscal.nfe310.classes;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoSituacaoTributariaIPI;

public class NFNotaInfoSituacaoTributariaIPITest {

    @Test
    public void deveObterSituacaoTributariaIPIApartirDoSeuCodigo() {
        Assert.assertEquals(NFNotaInfoSituacaoTributariaIPI.ENTRADA_RECUPERACAO_CREDITO, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("00"));
        Assert.assertEquals(NFNotaInfoSituacaoTributariaIPI.ENTRADA_TRIBUTADA_ALIQUOTA_ZERO, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("01"));
        Assert.assertEquals(NFNotaInfoSituacaoTributariaIPI.ENTRADA_ISENTA, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("02"));
        Assert.assertEquals(NFNotaInfoSituacaoTributariaIPI.ENTRADA_NAO_TRIBUTADA, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("03"));
        Assert.assertEquals(NFNotaInfoSituacaoTributariaIPI.ENTRADA_IMUNE, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("04"));
        Assert.assertEquals(NFNotaInfoSituacaoTributariaIPI.ENTRADA_COM_SUSPENSAO, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("05"));
        Assert.assertEquals(NFNotaInfoSituacaoTributariaIPI.OUTRAS_ENTRADAS, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("49"));
        Assert.assertEquals(NFNotaInfoSituacaoTributariaIPI.SAIDA_TRIBUTADA, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("50"));
        Assert.assertEquals(NFNotaInfoSituacaoTributariaIPI.SAIDA_TRIBUTADA_COM_ALIQUOTA_ZERO, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("51"));
        Assert.assertEquals(NFNotaInfoSituacaoTributariaIPI.SAIDA_ISENTA, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("52"));
        Assert.assertEquals(NFNotaInfoSituacaoTributariaIPI.SAIDA_NAO_TRIBUTADA, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("53"));
        Assert.assertEquals(NFNotaInfoSituacaoTributariaIPI.SAIDA_IMUNE, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("54"));
        Assert.assertEquals(NFNotaInfoSituacaoTributariaIPI.SAIDA_COM_SUSPENSAO, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("55"));
        Assert.assertEquals(NFNotaInfoSituacaoTributariaIPI.OUTRAS_SAIDAS, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("99"));
        Assert.assertNull(NFNotaInfoSituacaoTributariaIPI.valueOfCodigo(""));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("00", NFNotaInfoSituacaoTributariaIPI.ENTRADA_RECUPERACAO_CREDITO.getCodigo());
        Assert.assertEquals("01", NFNotaInfoSituacaoTributariaIPI.ENTRADA_TRIBUTADA_ALIQUOTA_ZERO.getCodigo());
        Assert.assertEquals("02", NFNotaInfoSituacaoTributariaIPI.ENTRADA_ISENTA.getCodigo());
        Assert.assertEquals("03", NFNotaInfoSituacaoTributariaIPI.ENTRADA_NAO_TRIBUTADA.getCodigo());
        Assert.assertEquals("04", NFNotaInfoSituacaoTributariaIPI.ENTRADA_IMUNE.getCodigo());
        Assert.assertEquals("05", NFNotaInfoSituacaoTributariaIPI.ENTRADA_COM_SUSPENSAO.getCodigo());
        Assert.assertEquals("49", NFNotaInfoSituacaoTributariaIPI.OUTRAS_ENTRADAS.getCodigo());
        Assert.assertEquals("50", NFNotaInfoSituacaoTributariaIPI.SAIDA_TRIBUTADA.getCodigo());
        Assert.assertEquals("51", NFNotaInfoSituacaoTributariaIPI.SAIDA_TRIBUTADA_COM_ALIQUOTA_ZERO.getCodigo());
        Assert.assertEquals("52", NFNotaInfoSituacaoTributariaIPI.SAIDA_ISENTA.getCodigo());
        Assert.assertEquals("53", NFNotaInfoSituacaoTributariaIPI.SAIDA_NAO_TRIBUTADA.getCodigo());
        Assert.assertEquals("54", NFNotaInfoSituacaoTributariaIPI.SAIDA_IMUNE.getCodigo());
        Assert.assertEquals("55", NFNotaInfoSituacaoTributariaIPI.SAIDA_COM_SUSPENSAO.getCodigo());
        Assert.assertEquals("99", NFNotaInfoSituacaoTributariaIPI.OUTRAS_SAIDAS.getCodigo());
    }
}