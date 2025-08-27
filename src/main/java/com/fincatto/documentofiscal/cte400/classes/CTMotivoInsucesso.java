package com.fincatto.documentofiscal.cte400.classes;

public enum CTMotivoInsucesso {
    RECEBEDOR_NAO_ENCONTRADO("1", "Recebedor não encontrado"),
    RECUSA_DO_RECEBEDOR("2", "Recusa do recebedor"),
    ENDERECO_INEXISTENTE("3", "Endereço inexistente"),
    OUTROS("4", "Outros");

    private final String codigo;
    private final String descricao;

    CTMotivoInsucesso(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static CTMotivoInsucesso valueOfCodigo(final String codigo) {
        for (final CTMotivoInsucesso valor : CTMotivoInsucesso.values()) {
            if (valor.getCodigo().equals(codigo)) {
                return valor;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}
