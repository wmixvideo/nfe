package com.fincatto.documentofiscal.mdfe3.classes.def;

/**
 * @Author Edivaldo Ramos on 19/11/22.
 */
public enum MDFCategoriaCombinacaoVeicular {

    /**
     * 02 Veículo Comercial 2 eixos;
     * 04 Veículo Comercial 3 eixos;
     * 06 Veículo Comercial 4 eixos;
     * 07 Veículo Comercial 5 eixos;
     * 8 Veículo Comercial 6 eixos;
     * 10 Veículo Comercial 7 eixos;
     * 11 Veículo Comercial 8 eixos;
     * 12 Veículo Comercial 9 eixos;
     * 13 Veículo Comercial 10 eixos;
     * 14 Veículo Comercial Acima de 10 eixos;
     */
    VEICULO_COMERCIAL_2_EIXOS("02","Ve\u00edculo Comercial 2 eixos"),
    VEICULO_COMERCIAL_3_EIXOS("04","Ve\u00edculo Comercial 3 eixos"),
    VEICULO_COMERCIAL_4_EIXOS("06","Ve\u00edculo Comercial 4 eixos"),
    VEICULO_COMERCIAL_5_EIXOS("07","Ve\u00edculo Comercial 5 eixos"),
    VEICULO_COMERCIAL_6_EIXOS("08","Ve\u00edculo Comercial 6 eixos"),
    VEICULO_COMERCIAL_7_EIXOS("10","Ve\u00edculo Comercial 7 eixos"),
    VEICULO_COMERCIAL_8_EIXOS("11","Ve\u00edculo Comercial 8 eixos"),
    VEICULO_COMERCIAL_9_EIXOS("12","Ve\u00edculo Comercial 9 eixos"),
    VEICULO_COMERCIAL_10_EIXOS("13","Ve\u00edculo Comercial 10 eixos"),
    VEICULO_COMERCIAL_ACIMA_10_EIXOS("13","Ve\u00edculo Comercial Acima de 10 eixos");

    private final String codigo;
    private final String descricao;

    MDFCategoriaCombinacaoVeicular(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static MDFCategoriaCombinacaoVeicular valueOfCodigo(final String codigo) {
        for (MDFCategoriaCombinacaoVeicular catCombVeic : MDFCategoriaCombinacaoVeicular.values()) {
            if (catCombVeic.getCodigo().equalsIgnoreCase(codigo)) {
                return catCombVeic;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}
