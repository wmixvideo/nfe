package com.fincatto.documentofiscal.nfe400.classes;

public enum NFDebito {

  TRANSFERENCIA_CREDITO_COOPERATIVA("01", "Transfer\u00eancia de cr\u00e9ditos para Cooperativas"),
  ANULACAO_CREDITO_SAIDA_IMUNE_ISENTA("02", "Anula\u00e7\u00e3o de Cr\u00e9dito por Sa\u00eddas Imunes/Isentas"),
  DEBITO_NOTAS_NAO_PROCESSADAS_APURACAO("03", "D\u00e9bitos de notas fiscais n\u00e3o processadas na apura\u00e7\u00e3o"),
  MULTA_JUROS("04", "Multa e juros"),
  TRANSFERENCIA_CREDITO_SUCESSAO("05", "Transfer\u00eancia de cr\u00e9dito na sucess\u00e3o"),
  PAGAMENTO_ANTECIPADO("06", "Pagamento antecipado"),
  PERDA_ESTOQUE("07", "Perda em estoque"),
  DESENQUADRAMENTO_SN("08", "Desenquadramento do SN");

  private final String codigo;
  private final String descricao;

  NFDebito(final String codigo, final String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public String getCodigo() {
    return this.codigo;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public static NFDebito valueOfCodigo(final String codigo) {
    for (final NFDebito tipo : NFDebito.values()) {
      if (tipo.getCodigo().equals(codigo)) {
        return tipo;
      }
    }
    return null;
  }

  @Override
  public String toString() {
    return codigo + " - " + descricao;
  }
}
