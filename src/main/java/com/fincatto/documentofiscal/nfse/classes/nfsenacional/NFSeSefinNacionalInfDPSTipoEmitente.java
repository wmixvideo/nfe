package com.fincatto.documentofiscal.nfse.classes.nfsenacional;


import org.simpleframework.xml.Root;

@Root(name = "tpEmit")
public enum NFSeSefinNacionalInfDPSTipoEmitente {

    PRESTADOR("1", "Prestador"),
    TOMADOR("2", "Tomador"),
    INTERMEDIARIO("3", "intermediário");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalInfDPSTipoEmitente(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalInfDPSTipoEmitente valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalInfDPSTipoEmitente tipo : NFSeSefinNacionalInfDPSTipoEmitente.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}