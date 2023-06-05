package com.fincatto.documentofiscal.cte400.classes;

public enum CTTipoServico {

    NORMAL("0", "Normal"),
    SUBCONTRATACAO("1", "Subcontratação"),
    REDESPACHO("2", "Redespacho"),
    REDESPACHO_INTERMEDIARIO("3", "Redespacho Intermediário"),
    SERVICO_VINCULADO_A_MULTIMODAL("4", "Serviço Vinculado a Multimodal");

    private final String codigo;
    private final String descricao;

    CTTipoServico(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
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
        return codigo + " - " + descricao;
    }
}