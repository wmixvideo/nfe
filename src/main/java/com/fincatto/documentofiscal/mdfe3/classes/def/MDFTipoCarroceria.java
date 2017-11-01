package com.fincatto.documentofiscal.mdfe3.classes.def;

/**
 * Created by Eldevan Nery Junior on 01/11/17.
 *
 * <h1>Tipo de Carroceria.</h1>
 * <pre>Preencher com:
         00 - não aplicável;
         01 - Aberta;
         02 - Fechada/Baú;
         03 - Granelera;
         04 - Porta Container;
         05 - Sider
    </pre>
 *
 */
public enum MDFTipoCarroceria {

    NAO_APLICAVEL("00", "Não aplicável"),
    ABERTA("01", "Aberta"),
    FECHADA_BAU("02", "Fechada/Baú"),
    GRANELERA("03", "Granelera"),
    PORTA_CONTAINER("04", "Porta Container"),
    SIDER("05", "Sider");

    private final String codigo;
    private final String descricao;

    MDFTipoCarroceria(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static MDFTipoCarroceria valueOfCodigo(final String codigo) {
        for (MDFTipoCarroceria tipoUnidadeTransporte : MDFTipoCarroceria.values()) {
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
