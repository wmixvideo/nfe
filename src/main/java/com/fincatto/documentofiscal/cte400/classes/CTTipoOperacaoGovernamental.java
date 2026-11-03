package com.fincatto.documentofiscal.cte400.classes;

public enum CTTipoOperacaoGovernamental {
    FORNECIMENTO_PAGAMENTO_POSTERIOR("1", "Fornecimento com pagamento posterior"),
    RECEBIMENTO_PAGAMENTO_REALIZADO("2", "Recebimento do pagamento com fornecimento já realizado"),
    FORNECIMENTO_PAGAMENTO_REALIZADO("3", "Fornecimento com pagamento já realizado"),
    RECEBIMENTO_PAGAMENTO_POSTERIOR("4", "Recebimento do pagamento com fornecimento posterior");

    private String codigo;
    private String descricao;

    CTTipoOperacaoGovernamental(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static CTTipoOperacaoGovernamental valueOfCodigo(String codigo) {
        for (CTTipoOperacaoGovernamental tipo : CTTipoOperacaoGovernamental.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        throw null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}
