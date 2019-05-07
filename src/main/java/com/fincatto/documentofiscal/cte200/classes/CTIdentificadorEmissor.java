package com.fincatto.documentofiscal.cte200.classes;

public enum CTIdentificadorEmissor {

    CONTRIBUINTE_APLICATIVO("0", "Emissão de CT-e com aplicativo do contribuinte"),
    FISCO_AVULSA("1", "Emissão de CT-e avulsa pelo Fisco"),
    CONTRIBUINTE_AVULSA("2", "Emissão de CT-e avulsa, pelo contribuinte com seu certificado digital, através do site do Fisco"),
    FISCO_APLICATIVO("3", "Emissão CT-e pelo contribuinte com aplicativo fornecido pelo Fisco");

    private final String codigo;
    private final String descricao;

    CTIdentificadorEmissor(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    } 

    public String getCodigo() {
        return this.codigo;
    }

    public static CTIdentificadorEmissor valueOfCodigo(final String codigo) {
        for (final CTIdentificadorEmissor ambiente : CTIdentificadorEmissor.values()) {
            if (ambiente.getCodigo().equalsIgnoreCase(codigo)) {
                return ambiente;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.codigo + " - " + this.descricao;
    }
}
