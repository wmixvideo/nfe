package com.fincatto.documentofiscal.nfe400.classes.cadastro;

import org.junit.Assert;
import org.junit.Test;

public class NFSituacaoContribuinteTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals(NFSituacaoContribuinte.NAO_HABILITADO, NFSituacaoContribuinte.valueOfCodigo(0));
        Assert.assertEquals(NFSituacaoContribuinte.HABILITADO, NFSituacaoContribuinte.valueOfCodigo(1));
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoRecebaParametroNaoMapeado() {
        NFSituacaoContribuinte.valueOfCodigo(2);
    }
}