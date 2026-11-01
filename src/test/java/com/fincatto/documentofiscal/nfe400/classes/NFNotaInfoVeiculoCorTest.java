package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoVeiculoCorTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("01", NFNotaInfoVeiculoCor.AMARELA.getCodigo());
        Assertions.assertEquals("02", NFNotaInfoVeiculoCor.AZUL.getCodigo());
        Assertions.assertEquals("03", NFNotaInfoVeiculoCor.BEGE.getCodigo());
        Assertions.assertEquals("04", NFNotaInfoVeiculoCor.BRANCA.getCodigo());
        Assertions.assertEquals("05", NFNotaInfoVeiculoCor.CINZA.getCodigo());
        Assertions.assertEquals("06", NFNotaInfoVeiculoCor.DOURADA.getCodigo());
        Assertions.assertEquals("07", NFNotaInfoVeiculoCor.GRENA.getCodigo());
        Assertions.assertEquals("08", NFNotaInfoVeiculoCor.LARANJA.getCodigo());
        Assertions.assertEquals("09", NFNotaInfoVeiculoCor.MARROM.getCodigo());
        Assertions.assertEquals("10", NFNotaInfoVeiculoCor.PRATA.getCodigo());
        Assertions.assertEquals("11", NFNotaInfoVeiculoCor.PRETA.getCodigo());
        Assertions.assertEquals("12", NFNotaInfoVeiculoCor.ROSA.getCodigo());
        Assertions.assertEquals("13", NFNotaInfoVeiculoCor.ROXA.getCodigo());
        Assertions.assertEquals("14", NFNotaInfoVeiculoCor.VERDE.getCodigo());
        Assertions.assertEquals("15", NFNotaInfoVeiculoCor.VERMELHA.getCodigo());
        Assertions.assertEquals("16", NFNotaInfoVeiculoCor.FANTASIA.getCodigo());
    }
}