package com.fincatto.documentofiscal.nfe310.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoSituacaoTributariaPISTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("01", NFNotaInfoSituacaoTributariaPIS.OPERACAO_TRIBUTAVEL_CUMULATIVO_NAO_CUMULATIVO.getCodigo());
        Assertions.assertEquals("02", NFNotaInfoSituacaoTributariaPIS.OPERACAO_TRIBUTAVEL_ALIQUOTA_DIFERENCIADA.getCodigo());
        Assertions.assertEquals("03", NFNotaInfoSituacaoTributariaPIS.OPERACAO_TRIBUTAVEL_QUANTIDADE_VENDIDA_POR_ALIQUOTA_POR_UNIDADE_PRODUTO.getCodigo());
        Assertions.assertEquals("04", NFNotaInfoSituacaoTributariaPIS.OPERACAO_TRIBUTAVEL_MONOFASICA_ALIQUOTA_ZERO.getCodigo());
        Assertions.assertEquals("06", NFNotaInfoSituacaoTributariaPIS.OPERACAO_TRIBUTAVEL_ALIQUOTA_ZERO.getCodigo());
        Assertions.assertEquals("07", NFNotaInfoSituacaoTributariaPIS.OPERACAO_ISENTA_CONTRIBUICAO.getCodigo());
        Assertions.assertEquals("08", NFNotaInfoSituacaoTributariaPIS.OPERACAO_SEM_INCIDENCIA_CONTRIBUICAO.getCodigo());
        Assertions.assertEquals("09", NFNotaInfoSituacaoTributariaPIS.OPERACAO_COM_SUSPENSAO_CONTRIBUICAO.getCodigo());
        Assertions.assertEquals("49", NFNotaInfoSituacaoTributariaPIS.OUTRAS_OPERACOES_SAIDA.getCodigo());
        Assertions.assertEquals("50", NFNotaInfoSituacaoTributariaPIS.OPERACAO_DIREITO_CREDITO_VINCULADA_EXCLUSIVAMENTE_RECEITA_TRIBUTADA_MERCADO_INTERNO.getCodigo());
        Assertions.assertEquals("51", NFNotaInfoSituacaoTributariaPIS.OPERACAO_DIREITO_CREDITO_VINCULADA_EXCLUSIVAMENTE_RECEITA_NAO_TRIBUTADA_MERCADO_INTERNO.getCodigo());
        Assertions.assertEquals("52", NFNotaInfoSituacaoTributariaPIS.OPERACAO_DIREITO_CREDITO_VINCULADA_EXCLUSIVAMENTE_RECEITA_EXPORTACAO.getCodigo());
        Assertions.assertEquals("53", NFNotaInfoSituacaoTributariaPIS.OPERACAO_DIREITO_CREDITO_VINCULADA_RECEITAS_TRIBUTADA_E_NAO_TRIBUTADA_MERCADO_INTERNO.getCodigo());
        Assertions.assertEquals("54", NFNotaInfoSituacaoTributariaPIS.OPERACAO_DIREITO_CREDITO_VINCULADA_RECEITAS_TRIBUTADAS_NO_MERCADO_INTERNO_EXPORTACAO.getCodigo());
        Assertions.assertEquals("55", NFNotaInfoSituacaoTributariaPIS.OPERACAO_DIREITO_CREDITO_VINCULADA_RECEITAS_NAO_TRIBUTADA_NO_MERCADO_INTERNO_EXPORTACAO.getCodigo());
        Assertions.assertEquals("56", NFNotaInfoSituacaoTributariaPIS.OPERACAO_DIREITO_CREDITO_VINCULADA_RECEITAS_TRIBUTADAS_E_NAO_TRIBUTADAS_MERCADO_INTERNO_EXPORTACAO.getCodigo());
        Assertions.assertEquals("60", NFNotaInfoSituacaoTributariaPIS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_EXCLUSIVAMENTE_RECEITA_TRIBUTADA_MERCADO_INTERNO.getCodigo());
        Assertions.assertEquals("61", NFNotaInfoSituacaoTributariaPIS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_EXCLUSIVAMENTE_A_RECEITA_NAO_TRIBUTADA_MERCADO_INTERNO.getCodigo());
        Assertions.assertEquals("62", NFNotaInfoSituacaoTributariaPIS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_EXCLUSIVAMENTE_RECEITA_EXPORTACAO.getCodigo());
        Assertions.assertEquals("63", NFNotaInfoSituacaoTributariaPIS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_RECEITAS_TRIBUTADAS_E_NAO_TRIBUTADAS_MERCADO_INTERNO.getCodigo());
        Assertions.assertEquals("64", NFNotaInfoSituacaoTributariaPIS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_RECEITAS_TRIBUTADA_MERCADO_INTERNO_EXPORTACAO.getCodigo());
        Assertions.assertEquals("65", NFNotaInfoSituacaoTributariaPIS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_RECEITAS_NAO_TRIBUTADAS_MERCADO_INTERNO_EXPORTACAO.getCodigo());
        Assertions.assertEquals("66", NFNotaInfoSituacaoTributariaPIS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_RECEITAS_TRIBUTADAS_E_NAO_TRIBUTADAS_MERCADO_INTERNO_EXPORTACAO.getCodigo());
        Assertions.assertEquals("67", NFNotaInfoSituacaoTributariaPIS.CREDITO_PRESUMIDO_OUTRAS_OPERACOES.getCodigo());
        Assertions.assertEquals("70", NFNotaInfoSituacaoTributariaPIS.OPERACAO_AQUISICAO_SEM_DIREITO_CREDITO.getCodigo());
        Assertions.assertEquals("71", NFNotaInfoSituacaoTributariaPIS.OPERACAO_AQUISICAO_COM_ISENCAO.getCodigo());
        Assertions.assertEquals("72", NFNotaInfoSituacaoTributariaPIS.OPERACAO_AQUISICAO_COM_SUSPENSAO.getCodigo());
        Assertions.assertEquals("73", NFNotaInfoSituacaoTributariaPIS.OPERACAO_AQUISICAO_ALIQUOTA_ZERO.getCodigo());
        Assertions.assertEquals("74", NFNotaInfoSituacaoTributariaPIS.OPERACAO_AQUISICAO_SEM_INCIDENCIA_CONTRIBUICAO.getCodigo());
        Assertions.assertEquals("75", NFNotaInfoSituacaoTributariaPIS.OPERACAO_AQUISICAO_POR_SUBSTITUICAO_TRIBUTARIA.getCodigo());
        Assertions.assertEquals("98", NFNotaInfoSituacaoTributariaPIS.OUTRAS_OPERACOES_ENTRADA.getCodigo());
        Assertions.assertEquals("99", NFNotaInfoSituacaoTributariaPIS.OUTRAS_OPERACOES.getCodigo());
    }
}