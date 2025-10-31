package com.fincatto.documentofiscal.nfse.classes.nfsenacional;


import org.simpleframework.xml.Root;

@Root(name = "ambGer")
public enum NFSeSefinNacionalInfEventoAmbienteGeracao {

    PREFEITURA("1", "Prefeitura"),
    SEFIN_NACIONAL("2", "Sefin Nacional"),
    AMBIENTE_NACIONAL("3", "Ambiente Nacional");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalInfEventoAmbienteGeracao(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalInfEventoAmbienteGeracao valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalInfEventoAmbienteGeracao tipo : NFSeSefinNacionalInfEventoAmbienteGeracao.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}