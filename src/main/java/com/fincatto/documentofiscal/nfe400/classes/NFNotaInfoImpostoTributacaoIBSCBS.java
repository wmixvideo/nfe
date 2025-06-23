package com.fincatto.documentofiscal.nfe400.classes;

public enum NFNotaInfoImpostoTributacaoIBSCBS {

  A_DEFINIR("00", "A Definir");

  private final String codigo;
  private final String descricao;

  NFNotaInfoImpostoTributacaoIBSCBS(final String codigo, final String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public String getCodigo() {
    return this.codigo;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public static NFNotaInfoImpostoTributacaoIBSCBS valueOfCodigo(final String codigoICMS) {
    for (final NFNotaInfoImpostoTributacaoIBSCBS icms : NFNotaInfoImpostoTributacaoIBSCBS.values()) {
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
