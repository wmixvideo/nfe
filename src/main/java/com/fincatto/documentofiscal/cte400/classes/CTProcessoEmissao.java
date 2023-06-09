package com.fincatto.documentofiscal.cte400.classes;

public enum CTProcessoEmissao {

    EMISSOR_CONTRIBUINTE("0", "Emissão de CT-e com aplicativo do contribuinte"),
    EMISSOR_FISCO("3", "Emissão de CT-e pelo contribuinte com aplicativo fornecido pelo Fisco");

    private final String codigo;
    private final String descricao;

    CTProcessoEmissao(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static CTProcessoEmissao valueOfCodigo(final String codigo) {
        for (final CTProcessoEmissao tipo : CTProcessoEmissao.values()) {
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