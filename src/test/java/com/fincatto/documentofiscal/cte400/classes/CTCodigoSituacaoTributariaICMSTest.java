package com.fincatto.documentofiscal.cte400.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTCodigoSituacaoTributariaICMSTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assert.assertNull(CTCodigoSituacaoTributariaICMS.valueOfCodigo(null));
    	Assert.assertEquals("00", CTCodigoSituacaoTributariaICMS.TRIBUTACAO_INTEGRALMENTE.getCodigo());
    	Assert.assertEquals("10", CTCodigoSituacaoTributariaICMS.TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA.getCodigo());
    	Assert.assertEquals("20", CTCodigoSituacaoTributariaICMS.COM_REDUCAO_BASE_CALCULO.getCodigo());
    	Assert.assertEquals("30", CTCodigoSituacaoTributariaICMS.ISENTA_OU_NAO_TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA.getCodigo());
    	Assert.assertEquals("40", CTCodigoSituacaoTributariaICMS.ISENTA.getCodigo());
    	Assert.assertEquals("41", CTCodigoSituacaoTributariaICMS.NAO_TRIBUTADO.getCodigo());
    	Assert.assertEquals("50", CTCodigoSituacaoTributariaICMS.SUSPENSAO.getCodigo());
    	Assert.assertEquals("51", CTCodigoSituacaoTributariaICMS.DIFERIMENTO.getCodigo());
    	Assert.assertEquals("60", CTCodigoSituacaoTributariaICMS.ICMS_COBRADO_ANTERIORMENTE_POR_SUBSTITUICAO_TRIBUTARIA.getCodigo());
    	Assert.assertEquals("70", CTCodigoSituacaoTributariaICMS.COM_REDUCAO_BASE_CALCULO_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA_ICMS_SUBSTITUICAO_TRIBUTARIA.getCodigo());
    	Assert.assertEquals("90", CTCodigoSituacaoTributariaICMS.OUTROS.getCodigo());
    }

}
