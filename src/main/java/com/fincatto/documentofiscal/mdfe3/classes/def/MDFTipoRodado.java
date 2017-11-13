package com.fincatto.documentofiscal.mdfe3.classes.def;

/**
 * Created by Eldevan Nery Junior on 01/11/17.
 *
 * <h1>Tipo de Rodado.</h1>
 * <pre>Preencher com:
         01 - Truck;
         02 - Toco;
         03 - Cavalo Mecânico;
         04 - VAN;
         05 - Utilitário;
         06 - Outros.
    </pre>
 *
 */
public enum MDFTipoRodado {

    TRUCK("01", "Truck"),
    TOCO("02", "Toco"),
    CAVALO_MECANICO("03", "Cavalo Mecânico"),
    VAN("04", "VAN"),
    UTILITARIO("05", "Utilitário"),
    OUTROS("06", "Outros");

    private final String codigo;
    private final String descricao;

    MDFTipoRodado(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static MDFTipoRodado valueOfCodigo(final String codigo) {
        for (MDFTipoRodado tipoUnidadeTransporte : MDFTipoRodado.values()) {
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
