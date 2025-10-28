package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

public enum NFSeSefinNacionalBeneficioMunicipalTipoBeneficio {

    ALIQUOTA_DIFERENCIADA("1", "Alíquota Diferenciada"),
    REDUCAO("2", "Redução da BC"),
    ISENCAO("3", "Isenção");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalBeneficioMunicipalTipoBeneficio(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalBeneficioMunicipalTipoBeneficio valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalBeneficioMunicipalTipoBeneficio tipo : NFSeSefinNacionalBeneficioMunicipalTipoBeneficio.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}