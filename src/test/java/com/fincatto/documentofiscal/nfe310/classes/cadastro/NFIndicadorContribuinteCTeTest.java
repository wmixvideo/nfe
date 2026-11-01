package com.fincatto.documentofiscal.nfe310.classes.cadastro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFIndicadorContribuinteCTeTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals(NFIndicadorContribuinteCTe.NAO_CREDENCIADO_PARA_EMISSAO_CTE, NFIndicadorContribuinteCTe.valueOfCodigo(0));
        Assertions.assertEquals(NFIndicadorContribuinteCTe.CREDENCIADO, NFIndicadorContribuinteCTe.valueOfCodigo(1));
        Assertions.assertEquals(NFIndicadorContribuinteCTe.CREDENCIADO_COM_OBRIGATORIEDADE_PARA_TODAS_OPERACOES, NFIndicadorContribuinteCTe.valueOfCodigo(2));
        Assertions.assertEquals(NFIndicadorContribuinteCTe.CREDENCIADO_COM_OBRIGATORIEDADE_PARCIAL, NFIndicadorContribuinteCTe.valueOfCodigo(3));
        Assertions.assertEquals(NFIndicadorContribuinteCTe.SEFAZ_NAO_FORNECE_ESSA_INFO, NFIndicadorContribuinteCTe.valueOfCodigo(4));
    }

    @Test
    public void deveLancarExcecaoCasoNaoEncontreCodigo() {
        Assertions.assertThrows(IllegalStateException.class, () -> NFIndicadorContribuinteCTe.valueOfCodigo(5));
    }
}