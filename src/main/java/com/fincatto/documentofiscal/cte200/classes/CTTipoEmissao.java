package com.fincatto.documentofiscal.cte200.classes;

public enum CTTipoEmissao {

    NORMAL("1", "Normal"),
    EPEC_SVC("4", "EPEC pela SVC"),
    CONTINGENCIA_FSDA("5", "Conting\u00eancia FSDA"),
    AUTORIZACAO_SVCRS("7", "Autoriza\u00e7\u00e3o pela SVC-RS"),
    AUTORIZACAO_SVCSP("8", "Autoriza\u00e7\u00e3o pela SVC-SP");

    private final String codigo;
    private final String descricao;

    CTTipoEmissao(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static CTTipoEmissao valueOfCodigo(final String codigo) {
        for (final CTTipoEmissao tipo : CTTipoEmissao.values()) {
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