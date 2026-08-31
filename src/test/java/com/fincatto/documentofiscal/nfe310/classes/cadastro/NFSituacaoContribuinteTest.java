package com.fincatto.documentofiscal.nfe310.classes.cadastro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFSituacaoContribuinteTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals(NFSituacaoContribuinte.NAO_HABILITADO, NFSituacaoContribuinte.valueOfCodigo(0));
        Assertions.assertEquals(NFSituacaoContribuinte.HABILITADO, NFSituacaoContribuinte.valueOfCodigo(1));
    }

    @Test
    public void deveLancarExcecaoCasoRecebaParametroNaoMapeado() {
        Assertions.assertThrows(IllegalStateException.class, () -> NFSituacaoContribuinte.valueOfCodigo(2));
    }
}