package com.fincatto.documentofiscal.nfse.classes.nfsenacional;


public enum NFSeSefinNacionalComercioExteriorCompartilharComMDIC {

    NAO_ENVIAR("0", "Não enviar para o MDIC"),
    ENVIAR("1", "Enviar para o MDIC");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalComercioExteriorCompartilharComMDIC(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalComercioExteriorCompartilharComMDIC valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalComercioExteriorCompartilharComMDIC tipo : NFSeSefinNacionalComercioExteriorCompartilharComMDIC.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}