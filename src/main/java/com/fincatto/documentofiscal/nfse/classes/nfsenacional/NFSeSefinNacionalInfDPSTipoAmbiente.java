package com.fincatto.documentofiscal.nfse.classes.nfsenacional;


public enum NFSeSefinNacionalInfDPSTipoAmbiente {

    PRODUCAO("1", "Produção"),
    HOMOLOGACAO("2", "Homologação");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalInfDPSTipoAmbiente(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalInfDPSTipoAmbiente valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalInfDPSTipoAmbiente tipo : NFSeSefinNacionalInfDPSTipoAmbiente.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}