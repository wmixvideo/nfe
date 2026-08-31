package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFOperacaoConsumidorFinalTest {

    @Test
    public void deveObterTipoApartirDoSeuCodigo() {
        Assertions.assertEquals(NFOperacaoConsumidorFinal.NAO, NFOperacaoConsumidorFinal.valueOfCodigo("0"));
        Assertions.assertEquals(NFOperacaoConsumidorFinal.SIM, NFOperacaoConsumidorFinal.valueOfCodigo("1"));
        Assertions.assertNull(NFOperadoraCartao.valueOfCodigo("2"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("0", NFOperacaoConsumidorFinal.NAO.getCodigo());
        Assertions.assertEquals("1", NFOperacaoConsumidorFinal.SIM.getCodigo());
    }

    @Test
    public void deveObterStringficadoCorretamente() {
        Assertions.assertEquals("0 - N\u00e3o", NFOperacaoConsumidorFinal.NAO.toString());
    }
}