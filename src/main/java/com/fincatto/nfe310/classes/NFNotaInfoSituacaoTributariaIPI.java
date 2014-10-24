package com.fincatto.nfe310.classes;

public enum NFNotaInfoSituacaoTributariaIPI {
    ENTRADA_RECUPERACAO_CREDITO("00"),
    ENTRADA_TRIBUTADA_ALIQUOTA_ZERO("01"),
    ENTRADA_ISENTA("02"),
    ENTRADA_NAO_TRIBUTADA("03"),
    ENTRADA_IMUNE("04"),
    ENTRADA_COM_SUSPENSAO("05"),
    OUTRAS_ENTRADAS("49"),
    SAIDA_TRIBUTADA("50"),
    SAIDA_TRIBUTADA_COM_ALIQUOTA_ZERO("51"),
    SAIDA_ISENTA("52"),
    SAIDA_NAO_TRIBUTADA("53"),
    SAIDA_IMUNE("54"),
    SAIDA_COM_SUSPENSAO("55"),
    OUTRAS_SAIDAS("99");

    private final String codigo;

    private NFNotaInfoSituacaoTributariaIPI(final String codigo) {
        this.codigo = codigo;
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
}