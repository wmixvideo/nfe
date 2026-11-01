package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFOrigemTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("0", NFOrigem.NACIONAL.getCodigo());
        Assertions.assertEquals("1", NFOrigem.ESTRANGEIRA_IMPORTACAO_DIRETA.getCodigo());
        Assertions.assertEquals("2", NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO.getCodigo());
        Assertions.assertEquals("3", NFOrigem.NACIONAL_MERCADORIA_OU_BEM_CONTEUDO_IMPORTACAO_SUPERIOR_40_P.getCodigo());
        Assertions.assertEquals("4", NFOrigem.NACIONAL_PRODUCAO_EM_CONFORMIDADE_COM_PROCESSOS_PRODUTIVOS_BASICOS.getCodigo());
        Assertions.assertEquals("5", NFOrigem.NACIONAL_MERCADORIA_OU_BEM_CONTEUDO_IMPORTACAO_INFERIOR_40_P.getCodigo());
        Assertions.assertEquals("6", NFOrigem.ESTRANGEIRA_IMPORTACAO_DIRETA_SEM_SIMILAR_NACIONAL_CONSTANTE_EM_LISTA_CAMEX.getCodigo());
        Assertions.assertEquals("7", NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO_SEM_SIMILAR_NACIONAL_CONSTANTE_EM_LISTA_CAMEX.getCodigo());
        Assertions.assertEquals("8", NFOrigem.NACIONAL_MERCADORIA_OU_BEM_COM_CONTEUDO_IMPORTACAO_SUPERIOR_70_P.getCodigo());
    }

    @Test
    public void deveObterPeloCodigoCorretamente() {
        Assertions.assertEquals(NFOrigem.NACIONAL, NFOrigem.valueOfCodigo("0"));
        Assertions.assertEquals(NFOrigem.ESTRANGEIRA_IMPORTACAO_DIRETA, NFOrigem.valueOfCodigo("1"));
        Assertions.assertEquals(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO, NFOrigem.valueOfCodigo("2"));
        Assertions.assertEquals(NFOrigem.NACIONAL_MERCADORIA_OU_BEM_CONTEUDO_IMPORTACAO_SUPERIOR_40_P, NFOrigem.valueOfCodigo("3"));
        Assertions.assertEquals(NFOrigem.NACIONAL_PRODUCAO_EM_CONFORMIDADE_COM_PROCESSOS_PRODUTIVOS_BASICOS, NFOrigem.valueOfCodigo("4"));
        Assertions.assertEquals(NFOrigem.NACIONAL_MERCADORIA_OU_BEM_CONTEUDO_IMPORTACAO_INFERIOR_40_P, NFOrigem.valueOfCodigo("5"));
        Assertions.assertEquals(NFOrigem.ESTRANGEIRA_IMPORTACAO_DIRETA_SEM_SIMILAR_NACIONAL_CONSTANTE_EM_LISTA_CAMEX, NFOrigem.valueOfCodigo("6"));
        Assertions.assertEquals(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO_SEM_SIMILAR_NACIONAL_CONSTANTE_EM_LISTA_CAMEX, NFOrigem.valueOfCodigo("7"));
        Assertions.assertEquals(NFOrigem.NACIONAL_MERCADORIA_OU_BEM_COM_CONTEUDO_IMPORTACAO_SUPERIOR_70_P, NFOrigem.valueOfCodigo("8"));
        Assertions.assertNull(NFOrigem.valueOfCodigo("9"));
    }

    @Test
    public void deveRetornarStringficadoCorretamente() {
        Assertions.assertEquals("0 - Nacional", NFOrigem.NACIONAL.toString());
    }
}