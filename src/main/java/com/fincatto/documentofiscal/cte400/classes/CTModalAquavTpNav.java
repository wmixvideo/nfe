package com.fincatto.documentofiscal.cte400.classes;

public enum CTModalAquavTpNav {

  INTERIOR("0", "Interior"),
  CABOTAGEM("1", "Cabotagem");

  private final String codigo;
  private final String descricao;

  CTModalAquavTpNav(final String codigo, final String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public String getCodigo() {
    return this.codigo;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public static CTModalAquavTpNav valueOfCodigo(final String codigo) {
    for (final CTModalAquavTpNav tipo : CTModalAquavTpNav.values()) {
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
