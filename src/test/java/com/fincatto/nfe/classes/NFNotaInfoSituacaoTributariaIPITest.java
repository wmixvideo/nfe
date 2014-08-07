package com.fincatto.nfe.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFNotaInfoSituacaoTributariaIPITest {

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