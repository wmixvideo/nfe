package com.fincatto.documentofiscal.mdfe3.classes.nota;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class MDFInfoModalRodoviarioInfContratoTest {

    private MDFInfoModalRodoviarioInfContrato contrato;

    @Before
    public void setUp() {
        this.contrato = new MDFInfoModalRodoviarioInfContrato();
    }

    @Test
    public void deveAceitarValorContratoGlobalValidoNoLimite() {

        BigDecimal validoLimite = new BigDecimal("9999999999.99");

        contrato.setValorContratoGlobal(validoLimite);

        assertEquals("Valor retornado deve ser igual ao atribuído (compareTo == 0)", 0, contrato.getValorContratoGlobal().compareTo(validoLimite));
    }

    @Test
    public void deveAceitarValorContratoGlobalValidoIntermediario() {
        BigDecimal valor = new BigDecimal("1234567890.23");

        contrato.setValorContratoGlobal(valor);

        assertEquals(0, contrato.getValorContratoGlobal().compareTo(valor));
    }

    @Test(expected = NumberFormatException.class)
    public void deveRejeitarValorContratoGlobalComMaisDe13DigitosTotais() {

        BigDecimal invalido = new BigDecimal("100000000000.00");

        contrato.setValorContratoGlobal(invalido);
    }

    @Test(expected = NumberFormatException.class)
    public void deveRejeitarValorContratoGlobalComMaisDe2CasasDecimais() {

        BigDecimal invalido = new BigDecimal("1.234"); // 3 casas decimais

        contrato.setValorContratoGlobal(invalido);
    }
}