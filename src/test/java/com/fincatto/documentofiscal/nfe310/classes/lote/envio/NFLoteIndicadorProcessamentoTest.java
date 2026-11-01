package com.fincatto.documentofiscal.nfe310.classes.lote.envio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFLoteIndicadorProcessamentoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("0", NFLoteIndicadorProcessamento.PROCESSAMENTO_ASSINCRONO.getCodigo());
        Assertions.assertEquals("1", NFLoteIndicadorProcessamento.PROCESSAMENTO_SINCRONO.getCodigo());
    }

    @Test
    public void deveObterAtravesDoCodigo() {
        Assertions.assertEquals(NFLoteIndicadorProcessamento.PROCESSAMENTO_ASSINCRONO, NFLoteIndicadorProcessamento.valueOfCodigo("0"));
        Assertions.assertEquals(NFLoteIndicadorProcessamento.PROCESSAMENTO_SINCRONO, NFLoteIndicadorProcessamento.valueOfCodigo("1"));
    }

    @Test
    public void deveRetornarNuloCasoNaoExistaEnumComOCodigo() {
        Assertions.assertNull(NFLoteIndicadorProcessamento.valueOfCodigo("2"));
    }

    @Test
    public void deveObterStringficadoCorretamente() {
        Assertions.assertEquals("0 - Processamento Ass\u00edncrono", NFLoteIndicadorProcessamento.PROCESSAMENTO_ASSINCRONO.toString());
    }
}