package com.fincatto.nfe310.classes;

public enum NFNotaMotivoDesoneracaoICMS {
    TAXI("1", "Táxi"),
    PRODUTOR_AGROPECUARIO("3", "Produtor agropecuário"),
    FROTISTA_LOCADORA("4", "Frotista locadora"),
    DIPLOMATICO_CONSULAR("5", "Diplomático consular"),
    UTILITARIOS_MOTOCICLETAS_AMAZONIA_OCIDENTAL_AREAS_LIVRE_COMERCIO("6", "Utilitários motocicletas Amazônia Ocidental áreas livre comércio"),
    SUFRAMA("7", "Suframa"),
    VENDA_ORGAOS_PUBLICOS("8", "Venda órgãos públicos"),
    OUTROS("9", "Outros"),
    DEFICIENTE_CONDUTOR("10", "Deficiente condutor"),
    DEFICIENTE_NAO_CONDUTOR("11", "Deficiente não condutor"),
    ORGAO_DE_FOMENTO_DESENVOLVIMENTO_AGROPECUARIO("12", "Õrgão de fomento desenvolvimento agropecuário");

    private final String codigo;
    private final String desc;

    NFNotaMotivoDesoneracaoICMS(final String codigo, final String desc) {
        this.codigo = codigo;
        this.desc = desc;
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
    	return codigo+" - "+desc;
    }
}