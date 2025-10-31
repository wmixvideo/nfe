package com.fincatto.documentofiscal.nfse.classes.nfsenacional;


import org.simpleframework.xml.Root;

@Root(name = "cMotivo")
public enum NFSeSefinNacionalTSCodJustCanc {

    ERRO_EMISSAO("1", "Erro na Emissão"),
    SERVICO_NAO_PRESTADO("2", "Serviço não Prestado"),
    OUTROS("9", "Outros");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalTSCodJustCanc(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalTSCodJustCanc valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalTSCodJustCanc tipo : NFSeSefinNacionalTSCodJustCanc.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}