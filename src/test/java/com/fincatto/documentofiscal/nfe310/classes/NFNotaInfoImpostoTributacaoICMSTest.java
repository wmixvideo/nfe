package com.fincatto.documentofiscal.nfe310.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoImpostoTributacaoICMSTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("00", NFNotaInfoImpostoTributacaoICMS.TRIBUTACAO_INTEGRALMENTE.getCodigo());
        Assertions.assertEquals("10", NFNotaInfoImpostoTributacaoICMS.TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA.getCodigo());
        Assertions.assertEquals("20", NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO.getCodigo());
        Assertions.assertEquals("30", NFNotaInfoImpostoTributacaoICMS.ISENTA_OU_NAO_TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA.getCodigo());
        Assertions.assertEquals("40", NFNotaInfoImpostoTributacaoICMS.ISENTA.getCodigo());
        Assertions.assertEquals("41", NFNotaInfoImpostoTributacaoICMS.NAO_TRIBUTADO.getCodigo());
        Assertions.assertEquals("50", NFNotaInfoImpostoTributacaoICMS.SUSPENSAO.getCodigo());
        Assertions.assertEquals("51", NFNotaInfoImpostoTributacaoICMS.DIFERIMENTO.getCodigo());
        Assertions.assertEquals("60", NFNotaInfoImpostoTributacaoICMS.ICMS_COBRADO_ANTERIORMENTE_POR_SUBSTITUICAO_TRIBUTARIA.getCodigo());
        Assertions.assertEquals("70", NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA_ICMS_SUBSTITUICAO_TRIBUTARIA.getCodigo());
        Assertions.assertEquals("90", NFNotaInfoImpostoTributacaoICMS.OUTROS.getCodigo());
    }
}