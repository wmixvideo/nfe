package com.fincatto.documentofiscal.mdfe3.classes.def;

/**
 * @Author Edivaldo Ramos on 07/10/25.
 */
public enum MDFTipoIndAltoDesempenho {

    OPERACAO_TRANSPORTE_VEIC_FROTA_DEDICADA_FIDELIZADA("1", "Opera\u00e7\u00e3o de transporte com utiliza\u00e7\u00e3o de ve\u00edculos de frotas dedicadas ou fidelizadas");

    private final String codigo;
    private final String descricao;

    MDFTipoIndAltoDesempenho(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static MDFTipoIndAltoDesempenho valueOfCodigo(final String codigo) {
        for (MDFTipoIndAltoDesempenho indAltoDesempenho : MDFTipoIndAltoDesempenho.values()) {
            if (indAltoDesempenho.getCodigo().equalsIgnoreCase(codigo)) {
                return indAltoDesempenho;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}
