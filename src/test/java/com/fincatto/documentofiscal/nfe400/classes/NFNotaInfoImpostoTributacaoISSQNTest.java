package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoImpostoTributacaoISSQNTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("I", NFNotaInfoImpostoTributacaoISSQN.ISENTA.getCodigo());
        Assertions.assertEquals("S", NFNotaInfoImpostoTributacaoISSQN.SUBSTITUTA.getCodigo());
        Assertions.assertEquals("N", NFNotaInfoImpostoTributacaoISSQN.NORMAL.getCodigo());
        Assertions.assertEquals("R", NFNotaInfoImpostoTributacaoISSQN.RETIDA.getCodigo());
    }
}