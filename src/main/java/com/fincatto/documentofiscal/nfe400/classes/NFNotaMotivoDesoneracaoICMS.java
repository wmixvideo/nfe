package com.fincatto.documentofiscal.nfe400.classes;

public enum NFNotaMotivoDesoneracaoICMS {

    TAXI("1", "T\u00e1xi"),
    PRODUTOR_AGROPECUARIO("3", "Produtor agropecu\u00e1rio"),
    FROTISTA_LOCADORA("4", "Frotista locadora"),
    DIPLOMATICO_CONSULAR("5", "Diplom\u00e1tico consular"),
    UTILITARIOS_MOTOCICLETAS_AMAZONIA_OCIDENTAL_AREAS_LIVRE_COMERCIO("6", "Utilit\u00e1rios motocicletas Amaz\u00f4nia Ocidental \u00e1reas livre com\u00e9rcio"),
    SUFRAMA("7", "Suframa"),
    VENDA_ORGAOS_PUBLICOS("8", "Venda \u00f3rg\u00e3os p\u00fablicos"),
    OUTROS("9", "Outros"),
    DEFICIENTE_CONDUTOR("10", "Deficiente condutor"),
    DEFICIENTE_NAO_CONDUTOR("11", "Deficiente n\u00e3o condutor"),
    ORGAO_DE_FOMENTO_DESENVOLVIMENTO_AGROPECUARIO("12", "\u00d5rg\u00e3o de fomento desenvolvimento agropecu\u00e1rio"),
    SOLICITADO_PELO_FISCO("90", "Solicitado pelo Fisco");

    private final String codigo;
    private final String descricao;

    NFNotaMotivoDesoneracaoICMS(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFNotaMotivoDesoneracaoICMS valueOfCodigo(final String codigo) {
        for (final NFNotaMotivoDesoneracaoICMS motivoDesonaracao : NFNotaMotivoDesoneracaoICMS.values()) {
            if (motivoDesonaracao.getCodigo().equals(codigo)) {
                return motivoDesonaracao;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}