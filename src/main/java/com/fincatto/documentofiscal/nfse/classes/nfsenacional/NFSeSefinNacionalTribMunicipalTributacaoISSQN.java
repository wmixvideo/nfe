package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

public enum NFSeSefinNacionalTribMunicipalTributacaoISSQN {

    OPERACAO_TRIBUTAVEL("1", "Operação tributável"),
    EXPORTACAO_SERVICO("2", "Exportação de serviço"),
    NAO_INCIDENCIA("3", "Não Incidência"),
    IMUNIDADE("4", "Imunidade");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalTribMunicipalTributacaoISSQN(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalTribMunicipalTributacaoISSQN valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalTribMunicipalTributacaoISSQN tipo : NFSeSefinNacionalTribMunicipalTributacaoISSQN.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}