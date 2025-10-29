package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.Root;

@Root(name = "cNaoNIF")
public enum NFSeSefinNacionalInfoPrestadorCodigoNaoNIF {

    DISPENSADO("1", "Dispensado do NIF"),
    NAO_EXIGENCIA("2", "Não exigência do NIF");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalInfoPrestadorCodigoNaoNIF(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalInfoPrestadorCodigoNaoNIF valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalInfoPrestadorCodigoNaoNIF tipo : NFSeSefinNacionalInfoPrestadorCodigoNaoNIF.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}