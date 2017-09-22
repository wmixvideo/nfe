package com.fincatto.documentofiscal.nfe310.classes.lote.envio;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.classes.lote.envio.NFLoteIndicadorProcessamento;

public class NFLoteIndicadorProcessamentoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", NFLoteIndicadorProcessamento.PROCESSAMENTO_ASSINCRONO.getCodigo());
        Assert.assertEquals("1", NFLoteIndicadorProcessamento.PROCESSAMENTO_SINCRONO.getCodigo());
    }

    @Test
    public void deveObterAtravesDoCodigo() {
        Assert.assertEquals(NFLoteIndicadorProcessamento.PROCESSAMENTO_ASSINCRONO, NFLoteIndicadorProcessamento.valueOfCodigo("0"));
        Assert.assertEquals(NFLoteIndicadorProcessamento.PROCESSAMENTO_SINCRONO, NFLoteIndicadorProcessamento.valueOfCodigo("1"));
    }

    @Test
    public void deveRetornarNuloCasoNaoExistaEnumComOCodigo() {
        Assert.assertNull(NFLoteIndicadorProcessamento.valueOfCodigo("2"));
    }

    @Test
    public void deveObterStringficadoCorretamente() {
        Assert.assertEquals("0 - Processamento Ass\u00edncrono", NFLoteIndicadorProcessamento.PROCESSAMENTO_ASSINCRONO.toString());
    }
}