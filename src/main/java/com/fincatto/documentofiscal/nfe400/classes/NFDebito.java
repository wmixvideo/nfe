package com.fincatto.documentofiscal.nfe400.classes;

public enum NFDebito {

  TRANSFERENCIA_CREDITO_COOPERATIVA("01", "Transferência de créditos para Cooperativas"),
  ANULACAO_CREDITO_SAIDA_IMUNE_ISENTA("02", "Anulação de Crédito por Saídas Imunes/Isentas"),
  DEBITO_NOTAS_NAO_PROCESSADAS_APURACAO("03", "Débitos de notas fiscais não processadas na apuração"),
  MULTA_JUROS("04", "Multa e juros"),
  TRANSFERENCIA_CREDITO_SUCESSAO("05", "Transferência de crédito de sucessão"),
  PAGAMENTO_ANTECIPADO("06", "Pagamento antecipado"),
  PERDA_ESTOQUE("07", "Perda em estoque");

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
