package com.fincatto.documentofiscal.mdfe3.classes.def;

/**
 * Created by Edivaldo Merlo Stens on 29/06/20.
 * <h1>Tipo da Carga. Conforme Resolução ANTT nº. 5.849/2019.</h1>
 * 01-Granel sólido; 02-Granel líquido; 03-Frigorificada; 04-Conteinerizada;
 * 05-Carga Geral; 06-Neogranel; 07-Perigosa (granel sólido); 08-Perigosa
 * (granel líquido); 09-Perigosa (carga frigorificada); 10-Perigosa
 * (conteinerizada); 11-Perigosa (carga geral).
 */
public enum MDFTipoCargaProdutoPredominante {

    GRANEL_SOLIDO("01", "Granel s\u00f3lido"),
    GRANEL_LIQUIDO("02", "Granel l\u00edquido"),
    FRIGORIFICADA("03", "Frigorificada"),
    CONTEINERIZADA("04", "Conteinerizada"),
    CARGA_GERAL("05", "Carga Geral"),
    NEOGRANEL("06", "Neogranel"),
    PERIGOSA_GRANEL_SOLIDO("07", "Perigosa (granel s\u00f3lido)"),
    PERIGOSA_GRANEL_LIQUIDO("08", "Perigosa (granel l\u00edquido)"),
    PERIGOSA_CARGA_FRIGORIFICADA("09", "Perigosa (carga frigorificada)"),
    PERIGOSA_CONTEINERIZADA("10", "Perigosa (conteinerizada)"),
    PERIGOSA_CARGA_TOTAL("11", "Perigosa (carga geral)");

    private final String codigo;
    private final String descricao;

    MDFTipoCargaProdutoPredominante(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static MDFTipoCargaProdutoPredominante valueOfCodigo(final String codigo) {
        for (final MDFTipoCargaProdutoPredominante tipo : MDFTipoCargaProdutoPredominante.values()) {
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
