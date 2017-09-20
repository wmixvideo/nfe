package com.fincatto.documentofiscal.mdfe3.classes.def;

/**
 * @Author Eldevan Nery Junior on 30/05/17.
 */
public enum MDFTipoTranportador {

    /**
     * 1 - ETC
     * 2 - TAC
     * 3 - CTC
     */
    ETC("1", "ETC"),
    TAC("2", "TAC"),
    CTC("3", "CTC");

    private final String codigo;
    private final String descricao;

    MDFTipoTranportador(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static MDFTipoTranportador valueOfCodigo(final String codigo) {
        for (MDFTipoTranportador tipoTranportador : MDFTipoTranportador.values()) {
            if (tipoTranportador.getCodigo().equalsIgnoreCase(codigo)) {
                return tipoTranportador;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}
