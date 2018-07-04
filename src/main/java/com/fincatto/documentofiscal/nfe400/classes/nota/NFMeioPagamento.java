package com.fincatto.documentofiscal.nfe400.classes.nota;

public enum NFMeioPagamento {

    DINHEIRO("01", "Dinheiro"),
    CHEQUE("02", "Cheque"),
    CARTAO_CREDITO("03", "Cart\u00e3o de cr\u00e9dito"),
    CARTAO_DEBITO("04", "Cart\u00e3o de d\u00e9bito"),
    CARTAO_LOJA("05", "Cart\u00e3o da loja"),
    VALE_ALIMENTACAO("10", "Vale alimenta\u00e7\u00e3o"),
    VALE_REFEICAO("11", "Vale refei\u00e7\u00e3o"),
    VALE_PRESENTE("12", "Vale presente"),
    VALE_COMBUSTIVEL("13", "Vale combust\u00edvel"),
    DUPLICATA_MERCANTIL("14", "Duplicata mercantil"),
    BOLETO_BANCARIO("15", "Boleto Bancario"),
    SEM_PAGAMENTO("90", "Sem pagamento"),
    OUTRO("99", "Outro");

    private final String codigo;
    private final String descricao;

    NFMeioPagamento(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFMeioPagamento valueOfCodigo(final String codigo) {
        for (final NFMeioPagamento formaPagamentoMoeda : NFMeioPagamento.values()) {
            if (formaPagamentoMoeda.getCodigo().equals(codigo)) {
                return formaPagamentoMoeda;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.codigo + " - " + this.descricao;
    }

	public String getDescricao() {
		return descricao;
	}
    
    
}