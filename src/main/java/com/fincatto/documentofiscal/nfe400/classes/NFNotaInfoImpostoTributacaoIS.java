package com.fincatto.documentofiscal.nfe400.classes;

public enum NFNotaInfoImpostoTributacaoIS {

  TRIBUTACAO_INTEGRAL("000", "Tributação Integral"),
  TRIBUTACAO_COM_ALIQUOTAS_UNIFORMES("010", "Tributação com Alíquotas Uniformes"),
  TRIBUTACAO_COM_ALIQUOTAS_UNIFORMES_REDUZIDAS("011", "Tributação com Alíquotas Uniformes Reduzidas"),
  ALIQUOTA_REDUZIDA("200", "Alíquota Reduzida"),
  ALIQUOTA_FIXA("220", "Alíquota Fixa"),
  ALIQUOTA_FIXA_PROPORCIONAL("221", "Alíquota Fixa Proporcional"),
  REDUCAO_DE_BASE_DE_CALCULO("222", "Redução de Base de Cálculo"),
  ISENCAO("400", "Isenção"),
  IMUNIDADE_E_NAO_INCIDENCIA("410", "Imunidade e Não Incidência"),
  DIFERIMENTO("510", "Diferimento"),
  DIFERIMENTO_COM_REDUCAO_DE_ALIQUOTA("515", "Diferimento com Redução de Alíquota"),
  SUSPENSAO("550", "Suspensão"),
  TRIBUTACAO_MONOFASICA("620", "Tributação Monofásica"),
  TRANSFERENCIA_CREDITO("800", "Transferência de Crédito"),
  AJUSTE_DE_IBS_NA_ZFM("810", "Ajuste de IBS na ZFM"),
  AJUSTES("811", "Ajustes"),
  TRIBUTACAO_EM_DECLARACAO_DE_REGIME_ESPECIFICO("820", "Tributação em Declaração de Regime Específico"),
  EXCLUSAO_DE_BASE_DE_CALCULO("830", "Exclusão de Base de Cálculo");

  private final String codigo;
  private final String descricao;

  NFNotaInfoImpostoTributacaoIS(final String codigo, final String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public String getCodigo() {
    return this.codigo;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public static NFNotaInfoImpostoTributacaoIS valueOfCodigo(final String codigoICMS) {
    for (final NFNotaInfoImpostoTributacaoIS icms : NFNotaInfoImpostoTributacaoIS.values()) {
      if (icms.getCodigo().equals(codigoICMS)) {
        return icms;
      }
    }
    return null;
  }

  @Override
  public String toString() {
    return codigo + " - " + descricao;
  }
}
