package com.fincatto.documentofiscal.cte400.classes;

public enum CTTipoDocumentoTransporteAnterior {

	ATRE("07", "Atre"),
	DTA("08", "DTA (Despacho de Transito Aduaneiro"),
	CONHECIMENTO_AEREO_INTERNACIONAL("09", "Conhecimento Aéreo Internacional"),
	CONHECIMENTO_CARTA_DE_PORTE_INTERNACIONAL("10", "Conhecimento de Transporte Internacional"),
	CONHECIMENTO_AVULSO("11", "Conhecimento Avulso"),
	TIF("12", "TIF (Trasnporte Internacional Ferroviário)"),
	BL("13", "BL (Bill of Loading)");

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
        for (final CTTipoDocumentoTransporteAnterior tipo : CTTipoDocumentoTransporteAnterior.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}