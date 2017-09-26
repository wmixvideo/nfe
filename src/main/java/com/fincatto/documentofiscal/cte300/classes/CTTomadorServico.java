package com.fincatto.documentofiscal.cte300.classes;

public enum CTTomadorServico {

    REMETENTE("0", "Remetente"),
    EXPEDIDOR("1", "Expedidor"),
    RECEBEDOR("2", "Recebedor"),
    DESTINATARIO("3", "Destinatário"),
    OUTROS("4", "Outros");

    private final String codigo;
    private final String descricao;

    CTTomadorServico(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static CTTomadorServico valueOfCodigo(final String codigo) {
        for (final CTTomadorServico tipo : CTTomadorServico.values()) {
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