package com.fincatto.documentofiscal.nfe310.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFProgramaEmissorTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("0", NFProcessoEmissor.CONTRIBUINTE.getCodigo());
        Assertions.assertEquals("1", NFProcessoEmissor.AVULSA_FISCO.getCodigo());
        Assertions.assertEquals("2", NFProcessoEmissor.AVULSA_CONTRIBUINTE_COM_CERTIFICADO_DIGITAL_FISCO.getCodigo());
        Assertions.assertEquals("3", NFProcessoEmissor.CONTRIBUINTE_APLICATIVO_FISCO.getCodigo());
    }
}