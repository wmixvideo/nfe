package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFNotaInfoImpostoTributacaoICMSTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("00", NFNotaInfoImpostoTributacaoICMS.TRIBUTACAO_INTEGRALMENTE.getCodigo());
        Assert.assertEquals("10", NFNotaInfoImpostoTributacaoICMS.TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA.getCodigo());
        Assert.assertEquals("20", NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO.getCodigo());
        Assert.assertEquals("30", NFNotaInfoImpostoTributacaoICMS.ISENTA_OU_NAO_TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA.getCodigo());
        Assert.assertEquals("40", NFNotaInfoImpostoTributacaoICMS.ISENTA.getCodigo());
        Assert.assertEquals("41", NFNotaInfoImpostoTributacaoICMS.NAO_TRIBUTADO.getCodigo());
        Assert.assertEquals("50", NFNotaInfoImpostoTributacaoICMS.SUSPENSAO.getCodigo());
        Assert.assertEquals("51", NFNotaInfoImpostoTributacaoICMS.DIFERIMENTO.getCodigo());
        Assert.assertEquals("60", NFNotaInfoImpostoTributacaoICMS.ICMS_COBRADO_ANTERIORMENTE_POR_SUBSTITUICAO_TRIBUTARIA.getCodigo());
        Assert.assertEquals("70", NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA_ICMS_SUBSTITUICAO_TRIBUTARIA.getCodigo());
        Assert.assertEquals("90", NFNotaInfoImpostoTributacaoICMS.OUTROS.getCodigo());
    }
}