package com.fincatto.documentofiscal.mdfe3.classes.nota;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class MDFInfoModalRodoviarioInfContratoTest {

    private MDFInfoModalRodoviarioInfContrato contrato;

    @BeforeEach
    public void setUp() {
        this.contrato = new MDFInfoModalRodoviarioInfContrato();
    }

    @Test
    public void deveAceitarValorContratoGlobalValidoNoLimite() {

        BigDecimal validoLimite = new BigDecimal("9999999999.99");

        contrato.setValorContratoGlobal(validoLimite);

        Assertions.assertEquals(0, contrato.getValorContratoGlobal().compareTo(validoLimite));
    }

    @Test
    public void deveAceitarValorContratoGlobalValidoIntermediario() {
        BigDecimal valor = new BigDecimal("1234567890.23");

        contrato.setValorContratoGlobal(valor);

        Assertions.assertEquals(0, contrato.getValorContratoGlobal().compareTo(valor));
    }

    @Test
    public void deveRejeitarValorContratoGlobalComMaisDe13DigitosTotais() {
        Assertions.assertThrows(NumberFormatException.class, () -> {

            BigDecimal invalido = new BigDecimal("10000000000000.00");

            contrato.setValorContratoGlobal(invalido);
        });
    }

    @Test
    public void deveRejeitarValorContratoGlobalComMaisDe2CasasDecimais() {
        Assertions.assertThrows(NumberFormatException.class, () -> {

            BigDecimal invalido = new BigDecimal("1.234"); // 3 casas decimais

            contrato.setValorContratoGlobal(invalido);
        });
    }
}