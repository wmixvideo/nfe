package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFNotaInfoSituacaoTributariaPISTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("01", NFNotaInfoSituacaoTributariaPIS.OPERACAO_TRIBUTAVEL_CUMULATIVO_NAO_CUMULATIVO.getCodigo());
        Assert.assertEquals("02", NFNotaInfoSituacaoTributariaPIS.OPERACAO_TRIBUTAVEL_ALIQUOTA_DIFERENCIADA.getCodigo());
        Assert.assertEquals("03", NFNotaInfoSituacaoTributariaPIS.OPERACAO_TRIBUTAVEL_QUANTIDADE_VENDIDA_POR_ALIQUOTA_POR_UNIDADE_PRODUTO.getCodigo());
        Assert.assertEquals("04", NFNotaInfoSituacaoTributariaPIS.OPERACAO_TRIBUTAVEL_MONOFASICA_ALIQUOTA_ZERO.getCodigo());
        Assert.assertEquals("06", NFNotaInfoSituacaoTributariaPIS.OPERACAO_TRIBUTAVEL_ALIQUOTA_ZERO.getCodigo());
        Assert.assertEquals("07", NFNotaInfoSituacaoTributariaPIS.OPERACAO_ISENTA_CONTRIBUICAO.getCodigo());
        Assert.assertEquals("08", NFNotaInfoSituacaoTributariaPIS.OPERACAO_SEM_INCIDENCIA_CONTRIBUICAO.getCodigo());
        Assert.assertEquals("09", NFNotaInfoSituacaoTributariaPIS.OPERACAO_COM_SUSPENSAO_CONTRIBUICAO.getCodigo());
        Assert.assertEquals("49", NFNotaInfoSituacaoTributariaPIS.OUTRAS_OPERACOES_SAIDA.getCodigo());
        Assert.assertEquals("50", NFNotaInfoSituacaoTributariaPIS.OPERACAO_DIREITO_CREDITO_VINCULADA_EXCLUSIVAMENTE_RECEITA_TRIBUTADA_MERCADO_INTERNO.getCodigo());
        Assert.assertEquals("51", NFNotaInfoSituacaoTributariaPIS.OPERACAO_DIREITO_CREDITO_VINCULADA_EXCLUSIVAMENTE_RECEITA_NAO_TRIBUTADA_MERCADO_INTERNO.getCodigo());
        Assert.assertEquals("52", NFNotaInfoSituacaoTributariaPIS.OPERACAO_DIREITO_CREDITO_VINCULADA_EXCLUSIVAMENTE_RECEITA_EXPORTACAO.getCodigo());
        Assert.assertEquals("53", NFNotaInfoSituacaoTributariaPIS.OPERACAO_DIREITO_CREDITO_VINCULADA_RECEITAS_TRIBUTADA_E_NAO_TRIBUTADA_MERCADO_INTERNO.getCodigo());
        Assert.assertEquals("54", NFNotaInfoSituacaoTributariaPIS.OPERACAO_DIREITO_CREDITO_VINCULADA_RECEITAS_TRIBUTADAS_NO_MERCADO_INTERNO_EXPORTACAO.getCodigo());
        Assert.assertEquals("55", NFNotaInfoSituacaoTributariaPIS.OPERACAO_DIREITO_CREDITO_VINCULADA_RECEITAS_NAO_TRIBUTADA_NO_MERCADO_INTERNO_EXPORTACAO.getCodigo());
        Assert.assertEquals("56", NFNotaInfoSituacaoTributariaPIS.OPERACAO_DIREITO_CREDITO_VINCULADA_RECEITAS_TRIBUTADAS_E_NAO_TRIBUTADAS_MERCADO_INTERNO_EXPORTACAO.getCodigo());
        Assert.assertEquals("60", NFNotaInfoSituacaoTributariaPIS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_EXCLUSIVAMENTE_RECEITA_TRIBUTADA_MERCADO_INTERNO.getCodigo());
        Assert.assertEquals("61", NFNotaInfoSituacaoTributariaPIS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_EXCLUSIVAMENTE_A_RECEITA_NAO_TRIBUTADA_MERCADO_INTERNO.getCodigo());
        Assert.assertEquals("62", NFNotaInfoSituacaoTributariaPIS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_EXCLUSIVAMENTE_RECEITA_EXPORTACAO.getCodigo());
        Assert.assertEquals("63", NFNotaInfoSituacaoTributariaPIS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_RECEITAS_TRIBUTADAS_E_NAO_TRIBUTADAS_MERCADO_INTERNO.getCodigo());
        Assert.assertEquals("64", NFNotaInfoSituacaoTributariaPIS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_RECEITAS_TRIBUTADA_MERCADO_INTERNO_EXPORTACAO.getCodigo());
        Assert.assertEquals("65", NFNotaInfoSituacaoTributariaPIS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_RECEITAS_NAO_TRIBUTADAS_MERCADO_INTERNO_EXPORTACAO.getCodigo());
        Assert.assertEquals("66", NFNotaInfoSituacaoTributariaPIS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_RECEITAS_TRIBUTADAS_E_NAO_TRIBUTADAS_MERCADO_INTERNO_EXPORTACAO.getCodigo());
        Assert.assertEquals("67", NFNotaInfoSituacaoTributariaPIS.CREDITO_PRESUMIDO_OUTRAS_OPERACOES.getCodigo());
        Assert.assertEquals("70", NFNotaInfoSituacaoTributariaPIS.OPERACAO_AQUISICAO_SEM_DIREITO_CREDITO.getCodigo());
        Assert.assertEquals("71", NFNotaInfoSituacaoTributariaPIS.OPERACAO_AQUISICAO_COM_ISENCAO.getCodigo());
        Assert.assertEquals("72", NFNotaInfoSituacaoTributariaPIS.OPERACAO_AQUISICAO_COM_SUSPENSAO.getCodigo());
        Assert.assertEquals("73", NFNotaInfoSituacaoTributariaPIS.OPERACAO_AQUISICAO_ALIQUOTA_ZERO.getCodigo());
        Assert.assertEquals("74", NFNotaInfoSituacaoTributariaPIS.OPERACAO_AQUISICAO_SEM_INCIDENCIA_CONTRIBUICAO.getCodigo());
        Assert.assertEquals("75", NFNotaInfoSituacaoTributariaPIS.OPERACAO_AQUISICAO_POR_SUBSTITUICAO_TRIBUTARIA.getCodigo());
        Assert.assertEquals("98", NFNotaInfoSituacaoTributariaPIS.OUTRAS_OPERACOES_ENTRADA.getCodigo());
        Assert.assertEquals("99", NFNotaInfoSituacaoTributariaPIS.OUTRAS_OPERACOES.getCodigo());
    }
}