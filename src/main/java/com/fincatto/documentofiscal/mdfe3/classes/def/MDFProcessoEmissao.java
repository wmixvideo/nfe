package com.fincatto.documentofiscal.mdfe3.classes.def;

/**
 * Created by Eldevan Nery Junior on 03/11/17.
 * Identificação do processo de emissão do Manifesto
 * 0 - emissão de MDF-e com aplicativo do contribuinte;
 * 3- emissão MDF-e pelo contribuinte com aplicativo fornecido pelo Fisco.
 */
public enum MDFProcessoEmissao {

    EMISSOR_CONTRIBUINTE("0", "Emissão de MDF-e com aplicativo do contribuinte."),
    EMISSOR_FISCO("3", "Emissão MDF-e pelo contribuinte com aplicativo fornecido pelo Fisco.");

    private final String codigo;
    private final String descricao;

    MDFProcessoEmissao(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static MDFProcessoEmissao valueOfCodigo(final String codigo) {
        for (final MDFProcessoEmissao tipo : MDFProcessoEmissao.values()) {
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