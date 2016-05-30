package com.fincatto.nfe310.classes;

public enum NFNotaInfoSituacaoTributariaIPI {
    ENTRADA_RECUPERACAO_CREDITO("00", "Entrada recuperação crédito"),
    ENTRADA_TRIBUTADA_ALIQUOTA_ZERO("01", "Entrada tributada alíquota zero"),
    ENTRADA_ISENTA("02", "Entrada isenta"),
    ENTRADA_NAO_TRIBUTADA("03", "Entrada não tributada"),
    ENTRADA_IMUNE("04", "Entrada imune"),
    ENTRADA_COM_SUSPENSAO("05", "Entrada com suspensão"),
    OUTRAS_ENTRADAS("49", "Outras entradas"),
    SAIDA_TRIBUTADA("50", "Saída tributada"),
    SAIDA_TRIBUTADA_COM_ALIQUOTA_ZERO("51", "Saída tributada com alíquota zero"),
    SAIDA_ISENTA("52", "Saída isenta"),
    SAIDA_NAO_TRIBUTADA("53", "Saída não tributada"),
    SAIDA_IMUNE("54", "Saída imune"),
    SAIDA_COM_SUSPENSAO("55", "Saída com suspensão"),
    OUTRAS_SAIDAS("99", "Outras saídas");

    private final String codigo;
    private final String desc;

    NFNotaInfoSituacaoTributariaIPI(final String codigo, final String desc) {
        this.codigo = codigo;
        this.desc = desc;
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
    	return codigo+" - "+desc;
    }
}