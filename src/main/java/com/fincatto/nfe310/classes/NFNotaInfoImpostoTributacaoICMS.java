package com.fincatto.nfe310.classes;

public enum NFNotaInfoImpostoTributacaoICMS {
    TRIBUTACAO_INTEGRALMENTE("00"),
    TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA("10"),
    COM_REDUCAO_BASE_CALCULO("20"),
    ISENTA_OU_NAO_TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA("30"),
    ISENTA("40"),
    NAO_TRIBUTADO("41"),
    SUSPENSAO("50"),
    DIFERIMENTO("51"),
    ICMS_COBRADO_ANTERIORMENTE_POR_SUBSTITUICAO_TRIBUTARIA("60"),
    COM_REDUCAO_BASE_CALCULO_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA_ICMS_SUBSTITUICAO_TRIBUTARIA("70"),
    OUTROS("90");

    String codigo;

    private NFNotaInfoImpostoTributacaoICMS(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFNotaInfoImpostoTributacaoICMS valueOfCodigo(final String codigoICMS) {
        for (final NFNotaInfoImpostoTributacaoICMS icms : NFNotaInfoImpostoTributacaoICMS.values()) {
            if (icms.getCodigo().equals(codigoICMS)) {
                return icms;
            }
        }
        return null;
    }
}