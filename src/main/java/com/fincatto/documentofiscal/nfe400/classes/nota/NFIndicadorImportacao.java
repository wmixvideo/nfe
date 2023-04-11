package com.fincatto.documentofiscal.nfe400.classes.nota;

public enum NFIndicadorImportacao {

    NACIONAL("0", "Nacional"),
    IMPORTADO("1", "Importado");

    private final String codigo;
    private final String descricao;

    NFIndicadorImportacao(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static NFIndicadorImportacao valueOfCodigo(final String codigo) {
        for (final NFIndicadorImportacao indicador : NFIndicadorImportacao.values()) {
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
