package com.fincatto.documentofiscal.nfe400.classes.nota;

public enum NFIndicadorEscalaRelevante {

    PRODUZIDO_EM_ESCALA_RELEVANTE("S", "Produzido em escala relevante"),
    PRODUZIDO_EM_ESCALA_NAO_RELEVANTE("N", "Produzido em escala n\u00e3o relevante");

    private final String codigo;
    private final String descricao;

    NFIndicadorEscalaRelevante(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static NFIndicadorEscalaRelevante valueOfCodigo(final String codigo) {
        for (final NFIndicadorEscalaRelevante indicador : NFIndicadorEscalaRelevante.values()) {
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