package com.fincatto.documentofiscal.nfe310.classes;

public enum NFProcessoEmissor {

    CONTRIBUINTE("0", "Aplicativo do contribuinte"),
    AVULSA_FISCO("1", "Emiss\u00e3o de NF-e avulsa pelo Fisco"),
    AVULSA_CONTRIBUINTE_COM_CERTIFICADO_DIGITAL_FISCO("2", "Emiss\u00e3o de NF-e avulsa, pelo contribuinte com certificado digital atrav\u00e9s do Fisco"),
    CONTRIBUINTE_APLICATIVO_FISCO("3", "Emiss\u00e3o de NF-e pelo contribuinte com aplicativo fornecido pelo Fisco");

    private final String codigo;
    private final String descricao;

    NFProcessoEmissor(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static NFProcessoEmissor valueOfCodigo(final String codigo) {
        for (final NFProcessoEmissor tipo : NFProcessoEmissor.values()) {
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