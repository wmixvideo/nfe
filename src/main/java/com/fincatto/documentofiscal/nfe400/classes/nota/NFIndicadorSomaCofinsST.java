package com.fincatto.documentofiscal.nfe400.classes.nota;

public enum NFIndicadorSomaCofinsST {

    NAO_COMPOE_VALOR_TOTAL("0", "COFINS ST n\u00E3o comp\u00F5e o valor total da NFe"),
    COMPOE_VALOR_TOTAL("1", "COFINS ST comp\u00F5e o valor total da NFe");


    private final String codigo;
    private final String descricao;

    NFIndicadorSomaCofinsST(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static NFIndicadorSomaCofinsST valueOfCodigo(final String codigo) {
        for (final NFIndicadorSomaCofinsST indicador : NFIndicadorSomaCofinsST.values()) {
            if (indicador.getCodigo().equals(codigo)) {
                return indicador;
            }
        }
        throw new IllegalStateException(String.format("Nao existe o codigo %s", codigo));
    }

    @Override
    public String toString() {
        return this.codigo + " - " + this.descricao;
    }
}
