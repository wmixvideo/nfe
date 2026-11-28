package com.fincatto.documentofiscal.nfe400.classes;

/**
 * I17d - Código de atividade do Simples Nacional (NT 2026.005).
 */
public enum NFCodigoAtividadeSimplesNacional {

    REVENDA_OU_INDUSTRIALIZACAO_ANEXO_I("01", "Revenda de mercadorias, venda de mercadorias industrializadas pelo contribuinte - Anexo I"),
    DEMAIS_BENS_SEM_ICMS_ANEXO_I("02", "Operações com os demais bens materiais, sem incidência de ICMS - Anexo I"),
    INDUSTRIALIZACAO_INCENTIVADA_ZFM_ANEXO_II("03", "Venda de mercadorias industrializadas pelo contribuinte, com industrialização incentivada na Zona Franca de Manaus - Anexo II"),
    DEMAIS_BENS_INDUSTRIALIZACAO_INCENTIVADA_ZFM_SEM_ICMS_ANEXO_II("04", "Operações com os demais bens materiais, com industrialização incentivada na Zona Franca de Manaus, sem incidência de ICMS - Anexo II"),
    OPERACOES_NAO_TRIBUTAVEIS("90", "Operações não tributáveis");

    private final String codigo;
    private final String descricao;

    NFCodigoAtividadeSimplesNacional(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static NFCodigoAtividadeSimplesNacional valueOfCodigo(final String codigo) {
        for (final NFCodigoAtividadeSimplesNacional valor : NFCodigoAtividadeSimplesNacional.values()) {
            if (valor.getCodigo().equals(codigo)) {
                return valor;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}
