package com.fincatto.documentofiscal.cte400.classes;

public enum CTeModalDutoTpContratacao {

  PONTO_A_PONTO("0", "Ponto a Ponto"),
  CAPACIDADE_ENTRADA("1", "Capacidade de Entrada"),
  CAPACIDADE_SAIDA("2", "Capacidade de Saída");

  private final String codigo;
  private final String descricao;

  CTeModalDutoTpContratacao(final String codigo, final String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public String getCodigo() {
    return this.codigo;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public static CTeModalDutoTpContratacao valueOfCodigo(final String codigo) {
    for (final CTeModalDutoTpContratacao tipo : CTeModalDutoTpContratacao.values()) {
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
