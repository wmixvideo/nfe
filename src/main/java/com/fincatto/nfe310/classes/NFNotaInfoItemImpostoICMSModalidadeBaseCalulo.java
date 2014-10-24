package com.fincatto.nfe310.classes;

public enum NFNotaInfoItemImpostoICMSModalidadeBaseCalulo {

    MVA("0", "Margem de valor agregado"),
    PAUTA("1", "Pauta"),
    PRECO_TABELADO_MAXIMO("2", "Preco tabelado maximo"),
    VALOR_OPERACAO("3", "Valor da operacao");

    private final String codigo;
    private final String descricao;

    private NFNotaInfoItemImpostoICMSModalidadeBaseCalulo(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static NFNotaInfoItemImpostoICMSModalidadeBaseCalulo valueOfCodigo(final String codigo) {
        for (final NFNotaInfoItemImpostoICMSModalidadeBaseCalulo modalidade : NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.values()) {
            if (modalidade.getCodigo().equals(codigo)) {
                return modalidade;
            }
        }
        return null;
    }
}