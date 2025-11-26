package com.fincatto.documentofiscal.nfe400.classes.evento;

public enum NFEventoTipoAutor {

    EMPRESA_EMITENTE("1", "Empresa emitente"),
    EMPRESA_DESTINADA("2", "Empresa destinada"),
    EMPRESA("3", "Empresa"),
    FISCO("5", "FISCO"),
    RFB("6", "RFB"),
    EMPRESA_SUCESSORA("8", "Empresa sucessora"),
    OUTROS_ORGAOS("9", "Outros org\\u00E3os");

    private final String codigo;
    private final String descricao;

    NFEventoTipoAutor(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static NFEventoTipoAutor valueOfCodigo(final String codigo) {
        for (final NFEventoTipoAutor tipo : NFEventoTipoAutor.values()) {
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
