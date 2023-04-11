package com.fincatto.documentofiscal.nfe400.classes;

public enum NFNotaInfoImpostoTributacaoICMS {

    TRIBUTACAO_INTEGRALMENTE("00", "Tributada integralmente"),
    TRIBUTACAO_MONOFASICA_PROPRIA_SOBRE_IMPOSTO("02", "Tributação monofásica própria sobre combustíveis"),
    TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA("10", "Tributada com cobran\u00e7a de ICMS por ST"),
    TRIBUTACAO_MONOFASICA_PROPRIA_E_COM_RESPONSABILIDADE_PELO_RETENCAO_SOBRE_COMBUSTIVES("15", "Tributação monofásica própria e com responsabilidade pela retenção sobre combustíveis"),
    COM_REDUCAO_BASE_CALCULO("20", "Com redu\u00e7\u00e3o da base de c\u00e1lculo"),
    ISENTA_OU_NAO_TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA("30", "Isenta ou n\u00e3o tributada com cobran\u00e7a de ICMS por ST"),
    ISENTA("40", "Isenta"),
    NAO_TRIBUTADO("41", "N\u00e3o tributada"),
    SUSPENSAO("50", "Suspens\u00e3o"),
    DIFERIMENTO("51", "Diferimento"),
    TRIBUTACAO_MONOFASICA_SOBRE_COMBUSTIVEIS_COM_RECOLHIMENTO_DIFERIDO("53", "Tributação monofásica sobre combustíveis com recolhimento diferido"),
    ICMS_COBRADO_ANTERIORMENTE_POR_SUBSTITUICAO_TRIBUTARIA("60", "ICMS cobrado anteriormente por ST"),
    TRIBUTACAO_MONOFASICA_SOBRE_COMBUSTIVEIS_COBRADA_ANTERIORMENTE("61", "Tributação monofásica sobre combustíveis cobrada anteriormente"),
    COM_REDUCAO_BASE_CALCULO_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA_ICMS_SUBSTITUICAO_TRIBUTARIA("70", "Com redu\u00e7\u00e3o da base de c\u00e1lculo/Cobran\u00e7a ICMS por ST/ICMS ST"),
    OUTROS("90", "Outros");

    private final String codigo;
    private final String descricao;

    NFNotaInfoImpostoTributacaoICMS(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }
    
    public String getDescricao() {
        return this.descricao;
    }

    public static NFNotaInfoImpostoTributacaoICMS valueOfCodigo(final String codigoICMS) {
        for (final NFNotaInfoImpostoTributacaoICMS icms : NFNotaInfoImpostoTributacaoICMS.values()) {
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