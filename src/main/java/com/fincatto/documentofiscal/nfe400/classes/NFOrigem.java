package com.fincatto.documentofiscal.nfe400.classes;

public enum NFOrigem {

    NACIONAL("0", "Nacional"),
    ESTRANGEIRA_IMPORTACAO_DIRETA("1", "Estrangeira importa\u00e7\u00e3o direta"),
    ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO("2", "Estrangeira adquirida mercado interno"),
    NACIONAL_MERCADORIA_OU_BEM_CONTEUDO_IMPORTACAO_SUPERIOR_40_P("3", "Nacional mercadoria ou bem conte\u00fado importa\u00e7\u00e3o superior 40 P"),
    NACIONAL_PRODUCAO_EM_CONFORMIDADE_COM_PROCESSOS_PRODUTIVOS_BASICOS("4", "Nacional produ\u00e7\u00e3o em conformidade com processos produtivos b\u00e1sicos"),
    NACIONAL_MERCADORIA_OU_BEM_CONTEUDO_IMPORTACAO_INFERIOR_40_P("5", "Nacional mercadoria ou bem conte\u00fado importa\u00e7\u00e3o inferior 40 P"),
    ESTRANGEIRA_IMPORTACAO_DIRETA_SEM_SIMILAR_NACIONAL_CONSTANTE_EM_LISTA_CAMEX("6", "Estrangeira importa\u00e7\u00e3o direta sem similar nacional constante em lista Camex"),
    ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO_SEM_SIMILAR_NACIONAL_CONSTANTE_EM_LISTA_CAMEX("7", "Estrangeira adquirida mercado interno sem similar nacional constante em lista Camex"),
    NACIONAL_MERCADORIA_OU_BEM_COM_CONTEUDO_IMPORTACAO_SUPERIOR_70_P("8", "Nacional mercadoria ou bem conte\u00fado importa\u00e7\u00e3o superior 70 P");

    private final String codigo;
    private final String descricao;

    NFOrigem(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFOrigem valueOfCodigo(final String codigo) {
        for (final NFOrigem origem : NFOrigem.values()) {
            if (origem.getCodigo().equals(codigo)) {
                return origem;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }

	public String getDescricao() {
		return descricao;
	}
    
}
