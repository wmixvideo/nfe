package com.fincatto.documentofiscal.nfse.classes.nfsenacional;


public enum NFSeSefinNacionalRegimeTributarioRegimeEspecialTributacao {

    NENHUM("0", "Nenhum"),
    COOPERATIVA("1", "Ato Cooperado (Cooperativa)"),
    ESTIMATIVA("2", "Estimativa"),
    MICROEMPRESA_MUNICIPAL("3", "Microempresa Municipal"),
    NOTARIO_REGISTRADOR("4", "Notário ou Registrador"),
    AUTONOMO("5", "Profissional Autônomo"),
    SOCIEDADE_PROFISSIONAIS("6", "Sociedade de Profissionais");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalRegimeTributarioRegimeEspecialTributacao(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalRegimeTributarioRegimeEspecialTributacao valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalRegimeTributarioRegimeEspecialTributacao tipo : NFSeSefinNacionalRegimeTributarioRegimeEspecialTributacao.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}