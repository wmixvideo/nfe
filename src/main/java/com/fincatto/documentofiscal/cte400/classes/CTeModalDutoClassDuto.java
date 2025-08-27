package com.fincatto.documentofiscal.cte400.classes;

public enum CTeModalDutoClassDuto {

  GASODUTO("1", "Gasoduto"),
  MINERODUTO("2", "Mineroduto"),
  OLEODUTO("3", "Oleoduto");

  private final String codigo;
  private final String descricao;

  CTeModalDutoClassDuto(final String codigo, final String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public String getCodigo() {
    return this.codigo;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public static CTeModalDutoClassDuto valueOfCodigo(final String codigo) {
    for (final CTeModalDutoClassDuto tipo : CTeModalDutoClassDuto.values()) {
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
