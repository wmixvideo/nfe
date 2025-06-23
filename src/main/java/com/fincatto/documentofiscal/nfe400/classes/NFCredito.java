package com.fincatto.documentofiscal.nfe400.classes;

public enum NFCredito {

  MULTA_JUROS("01", "Multa e juros"),
  APROPRIACAO_CREDITO_PRESUMIDO_IBS_SALDO_DEVEDOR_ZFM("02", "Apropriação de crédito presumido de IBS sobre o saldo devedor na ZFM (art. 450, § 1º, LC 214/25)");

  private final String codigo;
  private final String descricao;

  NFCredito(final String codigo, final String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public String getCodigo() {
    return this.codigo;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public static NFCredito valueOfCodigo(final String codigo) {
    for (final NFCredito tipo : NFCredito.values()) {
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
