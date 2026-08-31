package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFFinalidadeTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("1", NFFinalidade.NORMAL.getCodigo());
        Assertions.assertEquals("2", NFFinalidade.COMPLEMENTAR.getCodigo());
        Assertions.assertEquals("3", NFFinalidade.AJUSTE.getCodigo());
        Assertions.assertEquals("4", NFFinalidade.DEVOLUCAO_MERCADORIA.getCodigo());
        Assertions.assertEquals("5", NFFinalidade.NOTA_CREDITO.getCodigo());
        Assertions.assertEquals("6", NFFinalidade.NOTA_DEBITO.getCodigo());
    }
    
    @Test
    public void deveObterTipoApartirDoSeuCodigo() {
        Assertions.assertEquals(NFFinalidade.NORMAL, NFFinalidade.valueOfCodigo("1"));
        Assertions.assertEquals(NFFinalidade.COMPLEMENTAR, NFFinalidade.valueOfCodigo("2"));
        Assertions.assertEquals(NFFinalidade.AJUSTE, NFFinalidade.valueOfCodigo("3"));
        Assertions.assertEquals(NFFinalidade.DEVOLUCAO_MERCADORIA, NFFinalidade.valueOfCodigo("4"));
        Assertions.assertEquals(NFFinalidade.NOTA_CREDITO, NFFinalidade.valueOfCodigo("5"));
        Assertions.assertEquals(NFFinalidade.NOTA_DEBITO, NFFinalidade.valueOfCodigo("6"));
    }
    
    @Test
    public void deveRepresentarADescricaoCorretamente() {
    	Assertions.assertEquals("NF-e normal", NFFinalidade.NORMAL.getDescricao());
    	Assertions.assertEquals("NF-e complementar", NFFinalidade.COMPLEMENTAR.getDescricao());
    	Assertions.assertEquals("NF-e de ajuste", NFFinalidade.AJUSTE.getDescricao());
    	Assertions.assertEquals("Devolução de mercadoria", NFFinalidade.DEVOLUCAO_MERCADORIA.getDescricao());
    	Assertions.assertEquals("Nota de crédito", NFFinalidade.NOTA_CREDITO.getDescricao());
    	Assertions.assertEquals("Nota de débito", NFFinalidade.NOTA_DEBITO.getDescricao());
    }
}