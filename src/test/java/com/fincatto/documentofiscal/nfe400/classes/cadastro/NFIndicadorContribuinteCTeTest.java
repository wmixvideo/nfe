package com.fincatto.documentofiscal.nfe400.classes.cadastro;

import org.junit.Assert;
import org.junit.Test;

public class NFIndicadorContribuinteCTeTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals(NFIndicadorContribuinteCTe.NAO_CREDENCIADO_PARA_EMISSAO_CTE, NFIndicadorContribuinteCTe.valueOfCodigo(0));
        Assert.assertEquals(NFIndicadorContribuinteCTe.CREDENCIADO, NFIndicadorContribuinteCTe.valueOfCodigo(1));
        Assert.assertEquals(NFIndicadorContribuinteCTe.CREDENCIADO_COM_OBRIGATORIEDADE_PARA_TODAS_OPERACOES, NFIndicadorContribuinteCTe.valueOfCodigo(2));
        Assert.assertEquals(NFIndicadorContribuinteCTe.CREDENCIADO_COM_OBRIGATORIEDADE_PARCIAL, NFIndicadorContribuinteCTe.valueOfCodigo(3));
        Assert.assertEquals(NFIndicadorContribuinteCTe.SEFAZ_NAO_FORNECE_ESSA_INFO, NFIndicadorContribuinteCTe.valueOfCodigo(4));
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoNaoEncontreCodigo() {
        NFIndicadorContribuinteCTe.valueOfCodigo(5);
    }
}