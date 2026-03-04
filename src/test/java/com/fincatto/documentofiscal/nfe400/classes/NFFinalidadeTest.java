package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFFinalidadeTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("1", NFFinalidade.NORMAL.getCodigo());
        Assert.assertEquals("2", NFFinalidade.COMPLEMENTAR.getCodigo());
        Assert.assertEquals("3", NFFinalidade.AJUSTE.getCodigo());
        Assert.assertEquals("4", NFFinalidade.DEVOLUCAO_MERCADORIA.getCodigo());
        Assert.assertEquals("5", NFFinalidade.NOTA_CREDITO.getCodigo());
        Assert.assertEquals("6", NFFinalidade.NOTA_DEBITO.getCodigo());
    }
    
    @Test
    public void deveObterTipoApartirDoSeuCodigo() {
        Assert.assertEquals(NFFinalidade.NORMAL, NFFinalidade.valueOfCodigo("1"));
        Assert.assertEquals(NFFinalidade.COMPLEMENTAR, NFFinalidade.valueOfCodigo("2"));
        Assert.assertEquals(NFFinalidade.AJUSTE, NFFinalidade.valueOfCodigo("3"));
        Assert.assertEquals(NFFinalidade.DEVOLUCAO_MERCADORIA, NFFinalidade.valueOfCodigo("4"));
        Assert.assertEquals(NFFinalidade.NOTA_CREDITO, NFFinalidade.valueOfCodigo("5"));
        Assert.assertEquals(NFFinalidade.NOTA_DEBITO, NFFinalidade.valueOfCodigo("6"));
    }
    
    @Test
    public void deveRepresentarADescricaoCorretamente() {
    	Assert.assertEquals("NF-e normal", NFFinalidade.NORMAL.getDescricao());
    	Assert.assertEquals("NF-e complementar", NFFinalidade.COMPLEMENTAR.getDescricao());
    	Assert.assertEquals("NF-e de ajuste", NFFinalidade.AJUSTE.getDescricao());
    	Assert.assertEquals("Devolução de mercadoria", NFFinalidade.DEVOLUCAO_MERCADORIA.getDescricao());
    	Assert.assertEquals("Nota de crédito", NFFinalidade.NOTA_CREDITO.getDescricao());
    	Assert.assertEquals("Nota de débito", NFFinalidade.NOTA_DEBITO.getDescricao());
    }
}