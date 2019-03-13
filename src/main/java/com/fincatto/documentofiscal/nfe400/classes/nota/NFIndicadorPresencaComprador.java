package com.fincatto.documentofiscal.nfe400.classes.nota;

public enum NFIndicadorPresencaComprador {

    NAO_APLICA("0", "N\u00e3o se aplica"),
    OPERACAO_PRESENCIAL("1", "Opera\u00e7\u00e3o presencial"),
    OPERACAO_NAO_PRESENCIAL_INTERNET("2", "Opera\u00e7\u00e3o n\u00e3o presencial - Internet"),
    OPERACAO_NAO_PRESENCIAL_TELEATENDIMENTO("3", "Opera\u00e7\u00e3o n\u00e3o presencial - Teleatendimento"),
    NFCE_EM_OPERACAO_COM_ENTREGA_DOMICILIO("4", "NFC-e em opera\u00e7\u00e3o com entrega a domic\u00edlio"),
    OPERACAO_PRESENCIAL_FORA_ESTABELECIMENTO("5", "Opera\u00e7\u00e3o presencial, fora do estabelecimento"),
    OPERACAO_NAO_PRESENCIAL_OUTROS("9", "Opera\u00e7\u00e3o n\u00e3o presencial - Outros");

    private final String codigo;
    private final String descricao;

    NFIndicadorPresencaComprador(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static NFIndicadorPresencaComprador valueOfCodigo(final String codigo) {
        for (final NFIndicadorPresencaComprador indicador : NFIndicadorPresencaComprador.values()) {
            if (indicador.getCodigo().equals(codigo)) {
                return indicador;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.codigo + " - " + this.descricao;
    }
    
    
}