package com.fincatto.documentofiscal.mdfe3.classes.def;

/**
 * @Author Eldevan Nery Junior on 30/05/17.
 */
public enum MDFModalidadeTransporte {

    /**
     * 1 - Rodoviário; 2 - Aéreo; 3 - Aquaviário; 4 - Ferroviário.
     */
    RODOVIARIO("1", "Rodovi\u00e1rio"),
    AEREO("2", "A\u00e9reo"),
    AQUAVIARIO("3", "Aquavi\u00e1rio"),
    FERROVIARIO("4", "Ferrovi\u00e1rio") ;

    private final String codigo;
    private final String descricao;

    MDFModalidadeTransporte(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static MDFModalidadeTransporte valueOfCodigo(final String codigo) {
        for (MDFModalidadeTransporte modalidadeTransporte : MDFModalidadeTransporte.values()) {
            if (modalidadeTransporte.getCodigo().equalsIgnoreCase(codigo)) {
                return modalidadeTransporte;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}
