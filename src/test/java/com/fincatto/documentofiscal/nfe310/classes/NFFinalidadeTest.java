package com.fincatto.documentofiscal.nfe310.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFFinalidadeTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("1", NFFinalidade.NORMAL.getCodigo());
        Assertions.assertEquals("2", NFFinalidade.COMPLEMENTAR.getCodigo());
        Assertions.assertEquals("3", NFFinalidade.AJUSTE.getCodigo());
        Assertions.assertEquals("4", NFFinalidade.DEVOLUCAO_OU_RETORNO.getCodigo());
    }
}