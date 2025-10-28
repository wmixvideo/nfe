package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

public enum NFSeSefinNacionalDocDedRedTipoDeducaoReducao {

    ALIMENTACAO("1", "Alimentação e bebidas/frigobar"),
    MATERIAIS("2", "Materiais"),
    PRODUCAO_EXTERNA("3", "Produção externa"),
    REEMBOLSO("4", "Reembolso de despesas"),
    REPASSE_CONSORCIADO("5", "Repasse consorciado"),
    REPASSE_PLANO_SAUDE("6", "Repasse plano de saúde"),
    SERVICOS("7", "Serviços"),
    SUBEMPREITADA("8", "Subempreitada de mão de obra"),
    OUTRAS("99", "Outras deduções");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalDocDedRedTipoDeducaoReducao(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalDocDedRedTipoDeducaoReducao valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalDocDedRedTipoDeducaoReducao tipo : NFSeSefinNacionalDocDedRedTipoDeducaoReducao.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}