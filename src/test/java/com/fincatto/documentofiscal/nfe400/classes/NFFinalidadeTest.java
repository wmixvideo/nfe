package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFFinalidadeTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("1", NFFinalidade.NORMAL.getCodigo());
        Assert.assertEquals("2", NFFinalidade.COMPLEMENTAR.getCodigo());
        Assert.assertEquals("3", NFFinalidade.AJUSTE.getCodigo());
        Assert.assertEquals("4", NFFinalidade.DEVOLUCAO_OU_RETORNO.getCodigo());
    }
    
    @Test
    public void deveObterTipoApartirDoSeuCodigo() {
        Assert.assertEquals(NFFinalidade.NORMAL, NFFinalidade.valueOfCodigo("1"));
        Assert.assertEquals(NFFinalidade.COMPLEMENTAR, NFFinalidade.valueOfCodigo("2"));
        Assert.assertEquals(NFFinalidade.AJUSTE, NFFinalidade.valueOfCodigo("3"));
        Assert.assertEquals(NFFinalidade.DEVOLUCAO_OU_RETORNO, NFFinalidade.valueOfCodigo("4"));
    }
}