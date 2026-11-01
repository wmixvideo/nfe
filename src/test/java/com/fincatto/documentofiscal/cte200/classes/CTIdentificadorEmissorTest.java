package com.fincatto.documentofiscal.cte200.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTIdentificadorEmissorTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("0", CTIdentificadorEmissor.CONTRIBUINTE_APLICATIVO.getCodigo());
        Assertions.assertEquals("1", CTIdentificadorEmissor.FISCO_AVULSA.getCodigo());
        Assertions.assertEquals("2", CTIdentificadorEmissor.CONTRIBUINTE_AVULSA.getCodigo());
        Assertions.assertEquals("3", CTIdentificadorEmissor.FISCO_APLICATIVO.getCodigo());
    }
}
