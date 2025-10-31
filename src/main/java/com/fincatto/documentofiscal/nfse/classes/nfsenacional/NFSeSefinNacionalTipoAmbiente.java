package com.fincatto.documentofiscal.nfse.classes.nfsenacional;


import org.simpleframework.xml.Root;

@Root(name = "tpAmb")
public enum NFSeSefinNacionalTipoAmbiente {

    PRODUCAO("1", "Produção"),
    HOMOLOGACAO("2", "Homologação");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalTipoAmbiente(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalTipoAmbiente valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalTipoAmbiente tipo : NFSeSefinNacionalTipoAmbiente.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}