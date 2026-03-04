package com.fincatto.documentofiscal.mdfe3.classes.def;

/**
 * @Author FAGNER ROGER
 */
public enum MDFTipoCategoriaCombinacaoVeicular {

    VEICULO_COMERCIAL_2_EIXOS("02", "Ve\u00EDculo Comercial 2 eixos"),
    VEICULO_COMERCIAL_3_EIXOS("04", "Ve\u00EDculo Comercial 3 eixos"),
    VEICULO_COMERCIAL_4_EIXOS("06", "Ve\u00EDculo Comercial 4 eixos"),
    VEICULO_COMERCIAL_5_EIXOS("07", "Ve\u00EDculo Comercial 5 eixos"),
    VEICULO_COMERCIAL_6_EIXOS("08", "Ve\u00EDculo Comercial 6 eixos"),
    VEICULO_COMERCIAL_7_EIXOS("10", "Ve\u00EDculo Comercial 7 eixos"),
    VEICULO_COMERCIAL_8_EIXOS("11", "Ve\u00EDculo Comercial 8 eixos"),
    VEICULO_COMERCIAL_9_EIXOS("12", "Ve\u00EDculo Comercial 9 eixos"),
    VEICULO_COMERCIAL_10_EIXOS("13", "Ve\u00EDculo Comercial 10 eixos"),
    VEICULO_COMERCIAL_ACIMA_10_EIXOS("14", "Ve\u00EDculo Comercial Acima de 10 eixos");

    private final String codigo;
    private final String descricao;

    MDFTipoCategoriaCombinacaoVeicular(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static MDFTipoCategoriaCombinacaoVeicular valueOfCodigo(final String codigo) {
        for (MDFTipoCategoriaCombinacaoVeicular tipoEmitente : MDFTipoCategoriaCombinacaoVeicular.values()) {
            if (tipoEmitente.getCodigo().equalsIgnoreCase(codigo)) {
                return tipoEmitente;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}
