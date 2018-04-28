package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe400.classes.NFModalidadeFrete;

public class NFModalidadeFreteTest {

    @Test
    public void deveRetornarNuloAoPassarCodigoInvalido() {
        Assert.assertNull(NFModalidadeFrete.valueOfCodigo(""));
    }

    @Test
    public void deveRetornarModalidadeFreteAoPassarCodigoValido() {
        Assert.assertNotNull(NFModalidadeFrete.valueOfCodigo(NFModalidadeFrete.CONTRATACAO_POR_CONTA_DE_TERCEIROS.getCodigo()));
    }
}