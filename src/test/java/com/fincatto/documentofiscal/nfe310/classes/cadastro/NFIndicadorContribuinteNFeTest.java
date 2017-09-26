package com.fincatto.documentofiscal.nfe310.classes.cadastro;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.classes.cadastro.NFIndicadorContribuinteNFe;

public class NFIndicadorContribuinteNFeTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals(NFIndicadorContribuinteNFe.NAO_CREDENCIADO_PARA_EMISSAO_NFE, NFIndicadorContribuinteNFe.valueOfCodigo(0));
        Assert.assertEquals(NFIndicadorContribuinteNFe.CREDENCIADO, NFIndicadorContribuinteNFe.valueOfCodigo(1));
        Assert.assertEquals(NFIndicadorContribuinteNFe.CREDENCIADO_COM_OBRIGATORIEDADE_PARA_TODAS_OPERACOES, NFIndicadorContribuinteNFe.valueOfCodigo(2));
        Assert.assertEquals(NFIndicadorContribuinteNFe.CREDENCIADO_COM_OBRIGATORIEDADE_PARCIAL, NFIndicadorContribuinteNFe.valueOfCodigo(3));
        Assert.assertEquals(NFIndicadorContribuinteNFe.SEFAZ_NAO_FORNECE_ESSA_INFO, NFIndicadorContribuinteNFe.valueOfCodigo(4));
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoNaoEncontreCodigo() {
        NFIndicadorContribuinteNFe.valueOfCodigo(5);
    }
}