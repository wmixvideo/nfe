package com.fincatto.documentofiscal.mdfe3.classes.def;

/**
 * @Author Eldevan Nery Junior on 30/05/17.
 */
public enum MDFTipoUnidadeTransporte {

    /**
     1 - Rodoviário Tração;
     2 - Rodoviário Reboque;
     3 - Navio;
     4 - Balsa;
     5 - Aeronave;
     6 - Vagão;
     7 - Outros
     */
    RODOVIARIO_TRACAO("1", "Rodoviário Tração"),
    RODOVIARIO_REBOQUE("2", "Rodoviário Reboque"),
    NAVIO("3", "Navio"),
    BALSA("4", "Balsa"),
    AERONAVE("5", "Aeronave"),
    VAGAO("6", "Vagão"),
    OUTROS("7", "Outros");

    private final String codigo;
    private final String descricao;

    MDFTipoUnidadeTransporte(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static MDFTipoUnidadeTransporte valueOfCodigo(final String codigo) {
        for (MDFTipoUnidadeTransporte tipoUnidadeTransporte : MDFTipoUnidadeTransporte.values()) {
            if (tipoUnidadeTransporte.getCodigo().equalsIgnoreCase(codigo)) {
                return tipoUnidadeTransporte;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}
