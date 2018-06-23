package com.fincatto.documentofiscal.nfe400.classes;

public enum NFNotaInfoSituacaoTributariaIPI {

    ENTRADA_RECUPERACAO_CREDITO("00", "Entrada recupera\u00e7\u00e3o cr\u00e9dito"),
    ENTRADA_TRIBUTADA_ALIQUOTA_ZERO("01", "Entrada tributada al\u00edquota zero"),
    ENTRADA_ISENTA("02", "Entrada isenta"),
    ENTRADA_NAO_TRIBUTADA("03", "Entrada n\u00e3o tributada"),
    ENTRADA_IMUNE("04", "Entrada imune"),
    ENTRADA_COM_SUSPENSAO("05", "Entrada com suspens\u00e3o"),
    OUTRAS_ENTRADAS("49", "Outras entradas"),
    SAIDA_TRIBUTADA("50", "Sa\u00edda tributada"),
    SAIDA_TRIBUTADA_COM_ALIQUOTA_ZERO("51", "Sa\u00edda tributada com al\u00edquota zero"),
    SAIDA_ISENTA("52", "Sa\u00edda isenta"),
    SAIDA_NAO_TRIBUTADA("53", "Sa\u00edda n\u00e3o tributada"),
    SAIDA_IMUNE("54", "Sa\u00edda imune"),
    SAIDA_COM_SUSPENSAO("55", "Sa\u00edda com suspens\u00e3o"),
    OUTRAS_SAIDAS("99", "Outras sa\u00eddas");

    private final String codigo;
    private final String descricao;

    NFNotaInfoSituacaoTributariaIPI(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFNotaInfoSituacaoTributariaIPI valueOfCodigo(final String codigo) {
        for (final NFNotaInfoSituacaoTributariaIPI situacaoTributariaIPI : NFNotaInfoSituacaoTributariaIPI.values()) {
            if (situacaoTributariaIPI.getCodigo().equals(codigo)) {
                return situacaoTributariaIPI;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }

	public String getDescricao() {
		return descricao;
	}
    
}