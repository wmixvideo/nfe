package com.fincatto.documentofiscal.nfe310.classes;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.classes.NFOrigem;

public class NFOrigemTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", NFOrigem.NACIONAL.getCodigo());
        Assert.assertEquals("1", NFOrigem.ESTRANGEIRA_IMPORTACAO_DIRETA.getCodigo());
        Assert.assertEquals("2", NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO.getCodigo());
        Assert.assertEquals("3", NFOrigem.NACIONAL_MERCADORIA_OU_BEM_CONTEUDO_IMPORTACAO_SUPERIOR_40_P.getCodigo());
        Assert.assertEquals("4", NFOrigem.NACIONAL_PRODUCAO_EM_CONFORMIDADE_COM_PROCESSOS_PRODUTIVOS_BASICOS.getCodigo());
        Assert.assertEquals("5", NFOrigem.NACIONAL_MERCADORIA_OU_BEM_CONTEUDO_IMPORTACAO_INFERIOR_40_P.getCodigo());
        Assert.assertEquals("6", NFOrigem.ESTRANGEIRA_IMPORTACAO_DIRETA_SEM_SIMILAR_NACIONAL_CONSTANTE_EM_LISTA_CAMEX.getCodigo());
        Assert.assertEquals("7", NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO_SEM_SIMILAR_NACIONAL_CONSTANTE_EM_LISTA_CAMEX.getCodigo());
        Assert.assertEquals("8", NFOrigem.NACIONAL_MERCADORIA_OU_BEM_COM_CONTEUDO_IMPORTACAO_SUPERIOR_70_P.getCodigo());
    }

    @Test
    public void deveObterPeloCodigoCorretamente() {
        Assert.assertEquals(NFOrigem.NACIONAL, NFOrigem.valueOfCodigo("0"));
        Assert.assertEquals(NFOrigem.ESTRANGEIRA_IMPORTACAO_DIRETA, NFOrigem.valueOfCodigo("1"));
        Assert.assertEquals(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO, NFOrigem.valueOfCodigo("2"));
        Assert.assertEquals(NFOrigem.NACIONAL_MERCADORIA_OU_BEM_CONTEUDO_IMPORTACAO_SUPERIOR_40_P, NFOrigem.valueOfCodigo("3"));
        Assert.assertEquals(NFOrigem.NACIONAL_PRODUCAO_EM_CONFORMIDADE_COM_PROCESSOS_PRODUTIVOS_BASICOS, NFOrigem.valueOfCodigo("4"));
        Assert.assertEquals(NFOrigem.NACIONAL_MERCADORIA_OU_BEM_CONTEUDO_IMPORTACAO_INFERIOR_40_P, NFOrigem.valueOfCodigo("5"));
        Assert.assertEquals(NFOrigem.ESTRANGEIRA_IMPORTACAO_DIRETA_SEM_SIMILAR_NACIONAL_CONSTANTE_EM_LISTA_CAMEX, NFOrigem.valueOfCodigo("6"));
        Assert.assertEquals(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO_SEM_SIMILAR_NACIONAL_CONSTANTE_EM_LISTA_CAMEX, NFOrigem.valueOfCodigo("7"));
        Assert.assertEquals(NFOrigem.NACIONAL_MERCADORIA_OU_BEM_COM_CONTEUDO_IMPORTACAO_SUPERIOR_70_P, NFOrigem.valueOfCodigo("8"));
        Assert.assertNull(NFOrigem.valueOfCodigo("9"));
    }

    @Test
    public void deveRetornarStringficadoCorretamente() {
        Assert.assertEquals("0 - Nacional", NFOrigem.NACIONAL.toString());
    }
}