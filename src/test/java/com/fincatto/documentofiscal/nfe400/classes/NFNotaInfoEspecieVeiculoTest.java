package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoEspecieVeiculoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("1", NFNotaInfoEspecieVeiculo.PASSAGEIRO.getCodigo());
        Assertions.assertEquals("2", NFNotaInfoEspecieVeiculo.CARGA.getCodigo());
        Assertions.assertEquals("3", NFNotaInfoEspecieVeiculo.MISTO.getCodigo());
        Assertions.assertEquals("4", NFNotaInfoEspecieVeiculo.CORRIDA.getCodigo());
        Assertions.assertEquals("5", NFNotaInfoEspecieVeiculo.TRACAO.getCodigo());
        Assertions.assertEquals("6", NFNotaInfoEspecieVeiculo.ESPECIAL.getCodigo());
        Assertions.assertEquals("7", NFNotaInfoEspecieVeiculo.COLECAO.getCodigo());
    }
}