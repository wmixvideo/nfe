package com.fincatto.documentofiscal.nfe400.classes;

public enum NFCredito {

  MULTA_JUROS("01", "Multa e juros"),
  APROPRIACAO_CREDITO_PRESUMIDO_IBS_SALDO_DEVEDOR_ZFM("02", "Apropria\u00e7\u00e3o de cr\u00e9dito presumido de IBS sobre o saldo devedor na ZFM (art. 450, § 1º, LC 214/25)"),
  RETORNO_RECUSA_ENTREGA_DESTINATARIO_NAO_LOCALIZADO("03", "Retorno por recusa na entrega ou por n\u00e3o localiza\u00e7\u00e3o do destinat\u00e1rio na tentativa de entrega"),
  REDUCAO_VALORES("04", "Redu\u00e7\u00e3o de valores"),
  TRANSFERENCIA_CREDITO_SUCESSAO("05", "Transfer\u00eancia de cr\u00e9dito na sucess\u00e3o");

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
