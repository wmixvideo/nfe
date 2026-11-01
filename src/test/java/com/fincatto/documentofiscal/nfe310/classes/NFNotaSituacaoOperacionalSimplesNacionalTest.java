package com.fincatto.documentofiscal.nfe310.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaSituacaoOperacionalSimplesNacionalTest {

    @Test
    public void deveObterSituacaoOperacionalSimplesNacionalApartirDoSeuCodigo() {
        Assertions.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.TRIBUTADA_COM_PERMISSAO_CREDITO, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("101"));
        Assertions.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.TRIBUTADA_SEM_PERMISSAO_CREDITO, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("102"));
        Assertions.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.ISENCAO_ICMS_FAIXA_RECEITA_BRUTA, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("103"));
        Assertions.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.TRIBUTADA_SIMPLES_NACIONAL_COM_PERMISSAO_DE_CREDITO_E_COBRANCA_ICMS_SUBSTITUICAO_TRIBUTARIA, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("201"));
        Assertions.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.TRIBUTADA_SIMPLES_NACIONAL_SEM_PERMISSAO_DE_CREDITO_E_COBRANCA_ICMS_SUBSTITUICAO_TRIBUTARIA, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("202"));
        Assertions.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.TRIBUTADA_SIMPLES_NACIONAL_PARA_FAIXA_RECEITA_BRUTA_E_COBRANCA_ICMS_SUBSTITUICAO_TRIBUTARIA, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("203"));
        Assertions.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.IMUNE, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("300"));
        Assertions.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.NAO_TRIBUTADA, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("400"));
        Assertions.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.ICMS_COBRADO_ANTERIORMENTE_POR_SUBSTITUICAO_TRIBUTARIA_SUBSIDIO_OU_POR_ANTECIPACAO, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("500"));
        Assertions.assertEquals(NFNotaSituacaoOperacionalSimplesNacional.OUTROS, NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo("900"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("101", NFNotaSituacaoOperacionalSimplesNacional.TRIBUTADA_COM_PERMISSAO_CREDITO.getCodigo());
        Assertions.assertEquals("102", NFNotaSituacaoOperacionalSimplesNacional.TRIBUTADA_SEM_PERMISSAO_CREDITO.getCodigo());
        Assertions.assertEquals("103", NFNotaSituacaoOperacionalSimplesNacional.ISENCAO_ICMS_FAIXA_RECEITA_BRUTA.getCodigo());
        Assertions.assertEquals("201", NFNotaSituacaoOperacionalSimplesNacional.TRIBUTADA_SIMPLES_NACIONAL_COM_PERMISSAO_DE_CREDITO_E_COBRANCA_ICMS_SUBSTITUICAO_TRIBUTARIA.getCodigo());
        Assertions.assertEquals("202", NFNotaSituacaoOperacionalSimplesNacional.TRIBUTADA_SIMPLES_NACIONAL_SEM_PERMISSAO_DE_CREDITO_E_COBRANCA_ICMS_SUBSTITUICAO_TRIBUTARIA.getCodigo());
        Assertions.assertEquals("203", NFNotaSituacaoOperacionalSimplesNacional.TRIBUTADA_SIMPLES_NACIONAL_PARA_FAIXA_RECEITA_BRUTA_E_COBRANCA_ICMS_SUBSTITUICAO_TRIBUTARIA.getCodigo());
        Assertions.assertEquals("300", NFNotaSituacaoOperacionalSimplesNacional.IMUNE.getCodigo());
        Assertions.assertEquals("400", NFNotaSituacaoOperacionalSimplesNacional.NAO_TRIBUTADA.getCodigo());
        Assertions.assertEquals("500", NFNotaSituacaoOperacionalSimplesNacional.ICMS_COBRADO_ANTERIORMENTE_POR_SUBSTITUICAO_TRIBUTARIA_SUBSIDIO_OU_POR_ANTECIPACAO.getCodigo());
        Assertions.assertEquals("900", NFNotaSituacaoOperacionalSimplesNacional.OUTROS.getCodigo());
    }
}