package com.fincatto.documentofiscal.nfe400.classes;

public enum NFModalidadeFrete {
    CONTRATACAO_POR_CONTA_DO_REMETENTE("0", "Contrata\u00e7\u00e3o do frete por conta do remetente (CIF)"),
    CONTRATACAO_POR_CONTA_DO_DESTINATARIO("1", "Contrata\u00e7\u00e3o do frete por conta do destinat\u00e1rio (FOB)"),
    CONTRATACAO_POR_CONTA_DE_TERCEIROS("2", "Contrata\u00e7\u00e3o do frete por conta de terceiros"),
    PROPRIO_POR_CONTA_DO_REMETENTE("3", "Transporte pr\u00f3prio por conta do remetente"),
    PROPRIO_POR_CONTA_DO_DESTINATARIO("4", "Transporte pr\u00f3prio por conta do destinat\u00e1rio"),
    SEM_OCORRENCIA_TRANSPORTE("9", "Sem ocorr\u00eancia de transporte");

    private final String codigo;
    private final String descricao;

    NFModalidadeFrete(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFModalidadeFrete valueOfCodigo(final String codigo) {
        for (final NFModalidadeFrete modalidadeFrete : NFModalidadeFrete.values()) {
            if (modalidadeFrete.getCodigo().equals(codigo)) {
                return modalidadeFrete;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.codigo + " - " + this.descricao;
    }

	public String getDescricao() {
		return descricao;
	}
    
}