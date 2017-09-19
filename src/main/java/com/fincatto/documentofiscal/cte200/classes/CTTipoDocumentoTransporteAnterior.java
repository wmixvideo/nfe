package com.fincatto.documentofiscal.cte200.classes;

public enum CTTipoDocumentoTransporteAnterior {

    CTRC("0", "CTRC"),
    CTAC("1", "CTAC"),
    ACT("2", "ACT"),
    NF_MODELO_7("3", "NF Modelo 7"),
    NF_MODELO_27("4", "NF Modelo 27"),
    CONHECIMENTO_AEREO_NACIONAL("5", "Conhecimento Aéreo Nacional"),
    CTMC("6", "CTMC"),
    ATRE("7", "ATRE"),
    DIA("8", "DTA (Despacho de Transito Aduaneiro)"),
    CONHECIMENTO_AEREO_INTERNACIONAL("9", "Conhecimento Aéreo Internacional"),
    CONHECIMENTO_CARTA_PORTE_INTERNACIONAL("10", "Conhecimento - Carta de Porte Internacional"),
    CONHECIMENTO_AVULSO("11", "Conhecimento Avulso"),
    TIF("12", "TIF (Transporte Internacional Ferroviário)"),
    OUTROS("99", "Outros");

    private final String codigo;
    private final String descricao;

    CTTipoDocumentoTransporteAnterior(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static CTTipoDocumentoTransporteAnterior valueOfCodigo(final String codigo) {
        for (final CTTipoDocumentoTransporteAnterior formaPagamento : CTTipoDocumentoTransporteAnterior.values()) {
            if (formaPagamento.getCodigo().equals(codigo)) {
                return formaPagamento;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.codigo + " - " + this.descricao;
    }
}