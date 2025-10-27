package com.fincatto.documentofiscal.nfse.classes.nfsenacional;


public enum NFSeSefinNacionalComercioExteriorVinculoEntrePartes {

    SEM_VINCULO("0", "Sem vínculo com o tomador/ Prestador"),
    CONTROLADA("1", "Controlada"),
    CONTROLADORA("2", "Controladora"),
    COLIGADA("3", "Coligada"),
    MATRIZ("4", "Matriz"),
    FILIAL("5", "Filial ou sucursal"),
    OUTRO("6", "Outro vínculo");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalComercioExteriorVinculoEntrePartes(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalComercioExteriorVinculoEntrePartes valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalComercioExteriorVinculoEntrePartes tipo : NFSeSefinNacionalComercioExteriorVinculoEntrePartes.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}