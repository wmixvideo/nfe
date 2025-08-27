package com.fincatto.documentofiscal.nfe400.classes;

public enum NFTipoDeducaoIcms {

    NAO_DEDUZ_VALOR_ITEM("0", "Sem Dedu\u00e7\u00e3o do Valor do Item"),
    DEDUZ_VALOR_ITEM("1", "Deduz do Valor do Item");

    private final String codigo;
    private final String descricao;

    NFTipoDeducaoIcms(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFTipoDeducaoIcms valueOfCodigo(final String codigo) {
        for (final NFTipoDeducaoIcms tipo : NFTipoDeducaoIcms.values()) {
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