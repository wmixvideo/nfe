package com.fincatto.nfe310.classes;

public enum NFOrigem {

    NACIONAL("0"),
    ESTRANGEIRA_IMPORTACAO_DIRETA("1"),
    ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO("2"),
    NACIONAL_MERCADORIA_OU_BEM_CONTEUDO_IMPORTACAO_SUPERIOR_40_P("3"),
    NACIONAL_PRODUCAO_EM_CONFORMIDADE_COM_PROCESSOS_PRODUTIVOS_BASICOS("4"),
    NACIONAL_MERCADORIA_OU_BEM_CONTEUDO_IMPORTACAO_INFERIOR_40_P("5"),
    ESTRANGEIRA_IMPORTACAO_DIRETA_SEM_SIMILAR_NACIONAL_CONSTANTE_EM_LISTA_CAMEX("6"),
    ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO_SEM_SIMILAR_NACIONAL_CONSTANTE_EM_LISTA_CAMEX("7"),
    NACIONAL_MERCADORIA_OU_BEM_COM_CONTEUDO_IMPORTACAO_SUPERIOR_70_P("8");

    private final String codigo;

    private NFOrigem(final String codigo) {
        this.codigo = codigo;
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
}
