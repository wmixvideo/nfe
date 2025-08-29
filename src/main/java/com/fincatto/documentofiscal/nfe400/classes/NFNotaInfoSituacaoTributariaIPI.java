package com.fincatto.documentofiscal.nfe400.classes;

public enum NFNotaInfoSituacaoTributariaIPI {

    CST_00("00", "Entrada recupera\u00e7\u00e3o cr\u00e9dito"),
    CST_01("01", "Entrada tributada al\u00edquota zero"),
    CST_02("02", "Entrada isenta"),
    CST_03("03", "Entrada n\u00e3o tributada"),
    CST_04("04", "Entrada imune"),
    CST_05("05", "Entrada com suspens\u00e3o"),
    CST_49("49", "Outras entradas"),
    CST_50("50", "Sa\u00edda tributada"),
    CST_51("51", "Sa\u00edda tributada com al\u00edquota zero"),
    CST_52("52", "Sa\u00edda isenta"),
    CST_53("53", "Sa\u00edda n\u00e3o tributada"),
    CST_54("54", "Sa\u00edda imune"),
    CST_55("55", "Sa\u00edda com suspens\u00e3o"),
    CST_99("99", "Outras sa\u00eddas");

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