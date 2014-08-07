package com.fincatto.nfe.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFNotaSituacaoOperacionalSimplesNacionalTest {

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