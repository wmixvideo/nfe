package com.fincatto.documentofiscal.cte200.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTResponsavelSeguroTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("0", CTResponsavelSeguro.REMETENTE.getCodigo());
        Assertions.assertEquals("1", CTResponsavelSeguro.EXPEDIDOR.getCodigo());
        Assertions.assertEquals("2", CTResponsavelSeguro.RECEBEDOR.getCodigo());
        Assertions.assertEquals("3", CTResponsavelSeguro.DESTINATARIO.getCodigo());
        Assertions.assertEquals("4", CTResponsavelSeguro.EMITENTE.getCodigo());
        Assertions.assertEquals("5", CTResponsavelSeguro.TOMADOR.getCodigo());
    }
}
