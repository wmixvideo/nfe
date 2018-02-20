package com.fincatto.documentofiscal.nfe400.classes.evento.manifestacaodestinatario;

public enum NFTipoEventoManifestacaoDestinatario {

    CONFIRMACAO_DA_OPERACAO("210200", "Confirmacao da Operacao"),
    CIENCIA_DA_EMISSAO("210210", "Ciencia da Operacao"),
    DESCONHECIMENTO_DA_OPERACAO("210220", "Desconhecimento da Operacao"),
    OPERACAO_NAO_REALIZADA("210240", "Operacao nao Realizada");

    private final String codigo;
    private final String descricao;

    NFTipoEventoManifestacaoDestinatario(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFTipoEventoManifestacaoDestinatario valueOfCodigo(final String codigo) {
        for (NFTipoEventoManifestacaoDestinatario tipoEvento : NFTipoEventoManifestacaoDestinatario.values()) {
            if (tipoEvento.getCodigo().equalsIgnoreCase(codigo)) {
                return tipoEvento;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }

}