package com.fincatto.documentofiscal.cte300.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTCodigoSituacaoTributariaICMSTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assertions.assertNull(CTCodigoSituacaoTributariaICMS.valueOfCodigo(null));
    	Assertions.assertEquals("00", CTCodigoSituacaoTributariaICMS.TRIBUTACAO_INTEGRALMENTE.getCodigo());
    	Assertions.assertEquals("10", CTCodigoSituacaoTributariaICMS.TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA.getCodigo());
    	Assertions.assertEquals("20", CTCodigoSituacaoTributariaICMS.COM_REDUCAO_BASE_CALCULO.getCodigo());
    	Assertions.assertEquals("30", CTCodigoSituacaoTributariaICMS.ISENTA_OU_NAO_TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA.getCodigo());
    	Assertions.assertEquals("40", CTCodigoSituacaoTributariaICMS.ISENTA.getCodigo());
    	Assertions.assertEquals("41", CTCodigoSituacaoTributariaICMS.NAO_TRIBUTADO.getCodigo());
    	Assertions.assertEquals("50", CTCodigoSituacaoTributariaICMS.SUSPENSAO.getCodigo());
    	Assertions.assertEquals("51", CTCodigoSituacaoTributariaICMS.DIFERIMENTO.getCodigo());
    	Assertions.assertEquals("60", CTCodigoSituacaoTributariaICMS.ICMS_COBRADO_ANTERIORMENTE_POR_SUBSTITUICAO_TRIBUTARIA.getCodigo());
    	Assertions.assertEquals("70", CTCodigoSituacaoTributariaICMS.COM_REDUCAO_BASE_CALCULO_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA_ICMS_SUBSTITUICAO_TRIBUTARIA.getCodigo());
    	Assertions.assertEquals("90", CTCodigoSituacaoTributariaICMS.OUTROS.getCodigo());
    }

}
