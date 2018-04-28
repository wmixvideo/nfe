package com.fincatto.documentofiscal.nfe400.classes;

public enum NFNotaInfoItemModalidadeBCICMS {

    MVA("0", "Margem de valor agregado"),
    PAUTA("1", "Pauta"),
    PRECO_TABELADO_MAXIMO("2", "Pre\u00e7o tabelado m\u00e1ximo"),
    VALOR_OPERACAO("3", "Valor da opera\u00e7\u00e3o");

    private final String codigo;
    private final String descricao;

    NFNotaInfoItemModalidadeBCICMS(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static NFNotaInfoItemModalidadeBCICMS valueOfCodigo(final String codigo) {
        for (final NFNotaInfoItemModalidadeBCICMS modalidade : NFNotaInfoItemModalidadeBCICMS.values()) {
            if (modalidade.getCodigo().equals(codigo)) {
                return modalidade;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}