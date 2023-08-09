package com.fincatto.documentofiscal.nfe400.classes;

public enum NFNotaMotivoReducaoADREM {

    TRANSPORTE_COLETIVO_DE_PASSAGEIROS("1", "Transporte coletivo de passageiros"),
    OUTROS("9", "Outros");

    private final String codigo;
    private final String descricao;

    NFNotaMotivoReducaoADREM(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFNotaMotivoReducaoADREM valueOfCodigo(final String codigo) {
        for (final NFNotaMotivoReducaoADREM motivo : NFNotaMotivoReducaoADREM.values()) {
            if (motivo.getCodigo().equals(codigo)) {
                return motivo;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}