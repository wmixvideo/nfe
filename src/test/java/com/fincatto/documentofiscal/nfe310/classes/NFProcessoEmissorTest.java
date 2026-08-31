package com.fincatto.documentofiscal.nfe310.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFProcessoEmissorTest {

    @Test
    public void deveObterVeiculoCondicaoApartirDoSeuCodigo() {
        Assertions.assertEquals(NFProcessoEmissor.CONTRIBUINTE, NFProcessoEmissor.valueOfCodigo("0"));
        Assertions.assertEquals(NFProcessoEmissor.AVULSA_FISCO, NFProcessoEmissor.valueOfCodigo("1"));
        Assertions.assertEquals(NFProcessoEmissor.AVULSA_CONTRIBUINTE_COM_CERTIFICADO_DIGITAL_FISCO, NFProcessoEmissor.valueOfCodigo("2"));
        Assertions.assertEquals(NFProcessoEmissor.CONTRIBUINTE_APLICATIVO_FISCO, NFProcessoEmissor.valueOfCodigo("3"));
        Assertions.assertNull(NFProcessoEmissor.valueOfCodigo("4"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("0", NFProcessoEmissor.CONTRIBUINTE.getCodigo());
        Assertions.assertEquals("1", NFProcessoEmissor.AVULSA_FISCO.getCodigo());
        Assertions.assertEquals("2", NFProcessoEmissor.AVULSA_CONTRIBUINTE_COM_CERTIFICADO_DIGITAL_FISCO.getCodigo());
        Assertions.assertEquals("3", NFProcessoEmissor.CONTRIBUINTE_APLICATIVO_FISCO.getCodigo());
    }

    @Test
    public void deveObterStringficadoCorretamente() {
        Assertions.assertEquals("1 - Emiss\u00e3o de NF-e avulsa pelo Fisco", NFProcessoEmissor.AVULSA_FISCO.toString());
    }
}