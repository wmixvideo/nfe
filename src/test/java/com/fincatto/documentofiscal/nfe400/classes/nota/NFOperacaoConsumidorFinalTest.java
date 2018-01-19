package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.Assert;
import org.junit.Test;

public class NFOperacaoConsumidorFinalTest {

    @Test
    public void deveObterTipoApartirDoSeuCodigo() {
        Assert.assertEquals(NFOperacaoConsumidorFinal.NAO, NFOperacaoConsumidorFinal.valueOfCodigo("0"));
        Assert.assertEquals(NFOperacaoConsumidorFinal.SIM, NFOperacaoConsumidorFinal.valueOfCodigo("1"));
        Assert.assertNull(NFOperadoraCartao.valueOfCodigo("2"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", NFOperacaoConsumidorFinal.NAO.getCodigo());
        Assert.assertEquals("1", NFOperacaoConsumidorFinal.SIM.getCodigo());
    }

    @Test
    public void deveObterStringficadoCorretamente() {
        Assert.assertEquals("0 - N\u00e3o", NFOperacaoConsumidorFinal.NAO.toString());
    }
}