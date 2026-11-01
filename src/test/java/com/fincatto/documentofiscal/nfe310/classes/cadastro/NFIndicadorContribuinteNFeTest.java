package com.fincatto.documentofiscal.nfe310.classes.cadastro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFIndicadorContribuinteNFeTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals(NFIndicadorContribuinteNFe.NAO_CREDENCIADO_PARA_EMISSAO_NFE, NFIndicadorContribuinteNFe.valueOfCodigo(0));
        Assertions.assertEquals(NFIndicadorContribuinteNFe.CREDENCIADO, NFIndicadorContribuinteNFe.valueOfCodigo(1));
        Assertions.assertEquals(NFIndicadorContribuinteNFe.CREDENCIADO_COM_OBRIGATORIEDADE_PARA_TODAS_OPERACOES, NFIndicadorContribuinteNFe.valueOfCodigo(2));
        Assertions.assertEquals(NFIndicadorContribuinteNFe.CREDENCIADO_COM_OBRIGATORIEDADE_PARCIAL, NFIndicadorContribuinteNFe.valueOfCodigo(3));
        Assertions.assertEquals(NFIndicadorContribuinteNFe.SEFAZ_NAO_FORNECE_ESSA_INFO, NFIndicadorContribuinteNFe.valueOfCodigo(4));
    }

    @Test
    public void deveLancarExcecaoCasoNaoEncontreCodigo() {
        Assertions.assertThrows(IllegalStateException.class, () -> NFIndicadorContribuinteNFe.valueOfCodigo(5));
    }
}