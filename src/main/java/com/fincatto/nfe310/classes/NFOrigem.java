package com.fincatto.nfe310.classes;

public enum NFOrigem {

    NACIONAL("0", "Nacional"),
    ESTRANGEIRA_IMPORTACAO_DIRETA("1", "Estrangeira importação direta"),
    ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO("2", "Estrangeira adquirida mercado interno"),
    NACIONAL_MERCADORIA_OU_BEM_CONTEUDO_IMPORTACAO_SUPERIOR_40_P("3", "Nacional mercadoria ou bem conteúdo importação superior 40 P"),
    NACIONAL_PRODUCAO_EM_CONFORMIDADE_COM_PROCESSOS_PRODUTIVOS_BASICOS("4", "Nacional produção em conformidade com processos produtivos básicos"),
    NACIONAL_MERCADORIA_OU_BEM_CONTEUDO_IMPORTACAO_INFERIOR_40_P("5", "Nacional mercadoria ou bem conteúdo importação inferior 40 P"),
    ESTRANGEIRA_IMPORTACAO_DIRETA_SEM_SIMILAR_NACIONAL_CONSTANTE_EM_LISTA_CAMEX("6", "Estrangeira importação direta sem similar nacional constante em lista Camex"),
    ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO_SEM_SIMILAR_NACIONAL_CONSTANTE_EM_LISTA_CAMEX("7", "Estrangeira adquirida mercado interno sem similar nacional constante em lista Camex"),
    NACIONAL_MERCADORIA_OU_BEM_COM_CONTEUDO_IMPORTACAO_SUPERIOR_70_P("8", "Nacional mercadoria ou bem conteúdo importação superior 70 P");

    private final String codigo;
    private final String desc;

    NFOrigem(final String codigo, final String desc) {
        this.codigo = codigo;
        this.desc = desc;
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
    	return codigo+" - "+desc;
    }
}
