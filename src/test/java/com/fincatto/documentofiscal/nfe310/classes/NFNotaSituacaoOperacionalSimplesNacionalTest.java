package com.fincatto.documentofiscal.nfe310.classes;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.classes.NFNotaSituacaoOperacionalSimplesNacional;

public class NFNotaSituacaoOperacionalSimplesNacionalTest {

    @Test
    public void deveObterSituacaoOperacionalSimplesNacionalApartirDoSeuCodigo() {
        Assert.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.TRIBUTADA_COM_PERMISSAO_CREDITO, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("101"));
        Assert.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.TRIBUTADA_SEM_PERMISSAO_CREDITO, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("102"));
        Assert.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.ISENCAO_ICMS_FAIXA_RECEITA_BRUTA, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("103"));
        Assert.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.TRIBUTADA_SIMPLES_NACIONAL_COM_PERMISSAO_DE_CREDITO_E_COBRANCA_ICMS_SUBSTITUICAO_TRIBUTARIA, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("201"));
        Assert.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.TRIBUTADA_SIMPLES_NACIONAL_SEM_PERMISSAO_DE_CREDITO_E_COBRANCA_ICMS_SUBSTITUICAO_TRIBUTARIA, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("202"));
        Assert.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.TRIBUTADA_SIMPLES_NACIONAL_PARA_FAIXA_RECEITA_BRUTA_E_COBRANCA_ICMS_SUBSTITUICAO_TRIBUTARIA, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("203"));
        Assert.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.IMUNE, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("300"));
        Assert.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.NAO_TRIBUTADA, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("400"));
        Assert.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.ICMS_COBRADO_ANTERIORMENTE_POR_SUBSTITUICAO_TRIBUTARIA_SUBSIDIO_OU_POR_ANTECIPACAO, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("500"));
        Assert.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.OUTROS, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("900"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("101", NFNotaSituacaoOperacionalSimplesNacional.TRIBUTADA_COM_PERMISSAO_CREDITO.getCodigo());
        Assert.assertEquals("102", NFNotaSituacaoOperacionalSimplesNacional.TRIBUTADA_SEM_PERMISSAO_CREDITO.getCodigo());
        Assert.assertEquals("103", NFNotaSituacaoOperacionalSimplesNacional.ISENCAO_ICMS_FAIXA_RECEITA_BRUTA.getCodigo());
        Assert.assertEquals("201", NFNotaSituacaoOperacionalSimplesNacional.TRIBUTADA_SIMPLES_NACIONAL_COM_PERMISSAO_DE_CREDITO_E_COBRANCA_ICMS_SUBSTITUICAO_TRIBUTARIA.getCodigo());
        Assert.assertEquals("202", NFNotaSituacaoOperacionalSimplesNacional.TRIBUTADA_SIMPLES_NACIONAL_SEM_PERMISSAO_DE_CREDITO_E_COBRANCA_ICMS_SUBSTITUICAO_TRIBUTARIA.getCodigo());
        Assert.assertEquals("203", NFNotaSituacaoOperacionalSimplesNacional.TRIBUTADA_SIMPLES_NACIONAL_PARA_FAIXA_RECEITA_BRUTA_E_COBRANCA_ICMS_SUBSTITUICAO_TRIBUTARIA.getCodigo());
        Assert.assertEquals("300", NFNotaSituacaoOperacionalSimplesNacional.IMUNE.getCodigo());
        Assert.assertEquals("400", NFNotaSituacaoOperacionalSimplesNacional.NAO_TRIBUTADA.getCodigo());
        Assert.assertEquals("500", NFNotaSituacaoOperacionalSimplesNacional.ICMS_COBRADO_ANTERIORMENTE_POR_SUBSTITUICAO_TRIBUTARIA_SUBSIDIO_OU_POR_ANTECIPACAO.getCodigo());
        Assert.assertEquals("900", NFNotaSituacaoOperacionalSimplesNacional.OUTROS.getCodigo());
    }
}