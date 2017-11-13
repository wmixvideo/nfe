package com.fincatto.documentofiscal.mdfe3.classes.def;

/**
 * Created by Eldevan Nery Junior on 03/11/17.
 * <h1>Forma de emissão do Manifesto (Normal ou Contingência)</h1>
 * 1 - Normal
 * 2 - Contingência
 */
public enum MDFTipoEmissao {

    NORMAL("1", "Normal"),
    CONTINGENCIA("2", "Contingência");

    private final String codigo;
    private final String descricao;

    MDFTipoEmissao(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static MDFTipoEmissao valueOfCodigo(final String codigo) {
        for (final MDFTipoEmissao tipo : MDFTipoEmissao.values()) {
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