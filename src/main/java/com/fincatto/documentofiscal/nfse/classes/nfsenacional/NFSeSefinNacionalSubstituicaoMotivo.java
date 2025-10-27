package com.fincatto.documentofiscal.nfse.classes.nfsenacional;


public enum NFSeSefinNacionalSubstituicaoMotivo {

    DESENQUADRAMENTO_SIMPLES_NACIONAL("01", "Desenquadramento de NFS-e do Simples Nacional"),
    ENQUADRAMENTO_SIMPLES_NACIONAL("02", "Enquadramento de NFS-e no Simples Nacional"),
    INCLUSAO_RETROATIVA_ISENCAO("03", "Inclusão Retroativa de Imunidade/Isenção para NFS-e"),
    EXCLUSAO_RETROATIVA_ISENCAO("04", "Exclusão Retroativa de Imunidade/Isenção para NFS-e"),
    REJEICAO_RESPONSAVEL_RECOLHIMENTO_TRIBUTO("05", "Rejeição de NFS-e pelo tomador ou pelo intermediário se responsável pelo recolhimento do tributo"),
    OUTROS("99", "Outros");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalSubstituicaoMotivo(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalSubstituicaoMotivo valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalSubstituicaoMotivo tipo : NFSeSefinNacionalSubstituicaoMotivo.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}