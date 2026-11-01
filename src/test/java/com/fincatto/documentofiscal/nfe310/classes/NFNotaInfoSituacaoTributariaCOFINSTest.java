package com.fincatto.documentofiscal.nfe310.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoSituacaoTributariaCOFINSTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("01", NFNotaInfoSituacaoTributariaCOFINS.OPERACAO_TRIBUTAVEL_CUMULATIVO_NAO_CUMULATIVO.getCodigo());
        Assertions.assertEquals("02", NFNotaInfoSituacaoTributariaCOFINS.OPERACAO_TRIBUTAVEL_ALIQUOTA_DIFERENCIADA.getCodigo());
        Assertions.assertEquals("03", NFNotaInfoSituacaoTributariaCOFINS.OPERACAO_TRIBUTAVEL_QUANTIDADE_VENDIDA_POR_ALIQUOTA_POR_UNIDADE_PRODUTO.getCodigo());
        Assertions.assertEquals("04", NFNotaInfoSituacaoTributariaCOFINS.OPERACAO_TRIBUTAVEL_MONOFASICA_ALIQUOTA_ZERO.getCodigo());
        Assertions.assertEquals("05", NFNotaInfoSituacaoTributariaCOFINS.OPERACAO_TRIBUTAVEL_SUBSTITUICAO_TRIBUTARIA.getCodigo());
        Assertions.assertEquals("06", NFNotaInfoSituacaoTributariaCOFINS.OPERACAO_TRIBUTAVEL_ALIQUOTA_ZERO.getCodigo());
        Assertions.assertEquals("07", NFNotaInfoSituacaoTributariaCOFINS.OPERACAO_ISENTA_CONTRIBUICAO.getCodigo());
        Assertions.assertEquals("08", NFNotaInfoSituacaoTributariaCOFINS.OPERACAO_SEM_INCIDENCIA_CONTRIBUICAO.getCodigo());
        Assertions.assertEquals("09", NFNotaInfoSituacaoTributariaCOFINS.OPERACAO_COM_SUSPENSAO_CONTRIBUICAO.getCodigo());
        Assertions.assertEquals("49", NFNotaInfoSituacaoTributariaCOFINS.OUTRAS_OPERACOES_SAIDA.getCodigo());
        Assertions.assertEquals("50", NFNotaInfoSituacaoTributariaCOFINS.OPERACAO_DIREITO_CREDITO_VINCULADA_EXCLUSIVAMENTE_RECEITA_TRIBUTADA_MERCADO_INTERNO.getCodigo());
        Assertions.assertEquals("51", NFNotaInfoSituacaoTributariaCOFINS.OPERACAO_DIREITO_CREDITO_VINCULADA_EXCLUSIVAMENTE_RECEITA_NAO_TRIBUTADA_MERCADO_INTERNO.getCodigo());
        Assertions.assertEquals("52", NFNotaInfoSituacaoTributariaCOFINS.OPERACAO_DIREITO_CREDITO_VINCULADA_EXCLUSIVAMENTE_RECEITA_EXPORTACAO.getCodigo());
        Assertions.assertEquals("53", NFNotaInfoSituacaoTributariaCOFINS.OPERACAO_DIREITO_CREDITO_VINCULADA_RECEITAS_TRIBUTADA_E_NAO_TRIBUTADA_MERCADO_INTERNO.getCodigo());
        Assertions.assertEquals("54", NFNotaInfoSituacaoTributariaCOFINS.OPERACAO_DIREITO_CREDITO_VINCULADA_RECEITAS_TRIBUTADAS_NO_MERCADO_INTERNO_EXPORTACAO.getCodigo());
        Assertions.assertEquals("55", NFNotaInfoSituacaoTributariaCOFINS.OPERACAO_DIREITO_CREDITO_VINCULADA_RECEITAS_NAO_TRIBUTADA_NO_MERCADO_INTERNO_EXPORTACAO.getCodigo());
        Assertions.assertEquals("56", NFNotaInfoSituacaoTributariaCOFINS.OPERACAO_DIREITO_CREDITO_VINCULADA_RECEITAS_TRIBUTADAS_E_NAO_TRIBUTADAS_MERCADO_INTERNO_EXPORTACAO.getCodigo());
        Assertions.assertEquals("60", NFNotaInfoSituacaoTributariaCOFINS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_EXCLUSIVAMENTE_RECEITA_TRIBUTADA_MERCADO_INTERNO.getCodigo());
        Assertions.assertEquals("61", NFNotaInfoSituacaoTributariaCOFINS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_EXCLUSIVAMENTE_A_RECEITA_NAO_TRIBUTADA_MERCADO_INTERNO.getCodigo());
        Assertions.assertEquals("62", NFNotaInfoSituacaoTributariaCOFINS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_EXCLUSIVAMENTE_RECEITA_EXPORTACAO.getCodigo());
        Assertions.assertEquals("63", NFNotaInfoSituacaoTributariaCOFINS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_RECEITAS_TRIBUTADAS_E_NAO_TRIBUTADAS_MERCADO_INTERNO.getCodigo());
        Assertions.assertEquals("63", NFNotaInfoSituacaoTributariaCOFINS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_RECEITAS_TRIBUTADAS_E_NAO_TRIBUTADAS_MERCADO_INTERNO.getCodigo());
        Assertions.assertEquals("64", NFNotaInfoSituacaoTributariaCOFINS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_RECEITAS_TRIBUTADA_MERCADO_INTERNO_EXPORTACAO.getCodigo());
        Assertions.assertEquals("65", NFNotaInfoSituacaoTributariaCOFINS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_RECEITAS_NAO_TRIBUTADAS_MERCADO_INTERNO_EXPORTACAO.getCodigo());
        Assertions.assertEquals("66", NFNotaInfoSituacaoTributariaCOFINS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_RECEITAS_TRIBUTADAS_E_NAO_TRIBUTADAS_MERCADO_INTERNO_EXPORTACAO.getCodigo());
        Assertions.assertEquals("67", NFNotaInfoSituacaoTributariaCOFINS.CREDITO_PRESUMIDO_OUTRAS_OPERACOES.getCodigo());
        Assertions.assertEquals("70", NFNotaInfoSituacaoTributariaCOFINS.OPERACAO_AQUISICAO_SEM_DIREITO_CREDITO.getCodigo());
        Assertions.assertEquals("71", NFNotaInfoSituacaoTributariaCOFINS.OPERACAO_AQUISICAO_COM_ISENCAO.getCodigo());
        Assertions.assertEquals("72", NFNotaInfoSituacaoTributariaCOFINS.OPERACAO_AQUISICAO_COM_SUSPENSAO.getCodigo());
        Assertions.assertEquals("73", NFNotaInfoSituacaoTributariaCOFINS.OPERACAO_AQUISICAO_ALIQUOTA_ZERO.getCodigo());
        Assertions.assertEquals("74", NFNotaInfoSituacaoTributariaCOFINS.OPERACAO_AQUISICAO_SEM_INCIDENCIA_CONTRIBUICAO.getCodigo());
        Assertions.assertEquals("75", NFNotaInfoSituacaoTributariaCOFINS.OPERACAO_AQUISICAO_POR_SUBSTITUICAO_TRIBUTARIA.getCodigo());
        Assertions.assertEquals("98", NFNotaInfoSituacaoTributariaCOFINS.OUTRAS_OPERACOES_ENTRADA.getCodigo());
        Assertions.assertEquals("99", NFNotaInfoSituacaoTributariaCOFINS.OUTRAS_OPERACOES.getCodigo());
    }
}