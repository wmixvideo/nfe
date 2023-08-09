package com.fincatto.documentofiscal.cte400.classes;

public enum CTCodigoSituacaoTributariaICMS {

    TRIBUTACAO_INTEGRALMENTE("00", "Tributada integralmente"),
    TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA("10", "Tributada com cobrança de ICMS por ST"),
    COM_REDUCAO_BASE_CALCULO("20", "Com redução da base de cálculo"),
    ISENTA_OU_NAO_TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA("30", "Isenta ou não tributada com cobrança de ICMS por ST"),
    ISENTA("40", "Isenta"),
    NAO_TRIBUTADO("41", "Não tributada"),
    SUSPENSAO("50", "Suspensão"),
    DIFERIMENTO("51", "Diferimento"),
    ICMS_COBRADO_ANTERIORMENTE_POR_SUBSTITUICAO_TRIBUTARIA("60", "ICMS cobrado anteriormente por ST"),
    COM_REDUCAO_BASE_CALCULO_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA_ICMS_SUBSTITUICAO_TRIBUTARIA("70", "Com redução da base de cálculo Cobrança ICMS por ST/ICMS ST"),
    OUTROS("90", "Outros");

    private final String codigo;
    private final String descricao;

    CTCodigoSituacaoTributariaICMS(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }
    
    public String getDescricao() {
        return this.descricao;
    }

    public static CTCodigoSituacaoTributariaICMS valueOfCodigo(final String codigoICMS) {
        for (final CTCodigoSituacaoTributariaICMS icms : CTCodigoSituacaoTributariaICMS.values()) {
            if (icms.getCodigo().equals(codigoICMS)) {
                return icms;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}