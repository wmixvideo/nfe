package com.fincatto.documentofiscal.cte200.classes;

public enum CTTipoServico {

    NORMAL("0", "Normal"),
    SUBCONTRATACAO("1", "Subcontratac\u0327a\u0303o"),
    REDESPACHO("2", "Redespacho"),
    REDESPACHO_INTERMEDIARIO("3", "Redespacho Intermedia\u0301rio"),
    SERVICO_VINCULADO_MULTIMODAL("4", "Servic\u0327o Vinculado a Multimodal");

    private final String codigo;
    private final String descricao;

    CTTipoServico(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static CTTipoServico valueOfCodigo(final String codigo) {
        for (final CTTipoServico tipo : CTTipoServico.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.codigo + " - " + this.descricao;
    }
}