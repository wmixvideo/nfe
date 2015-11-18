package com.fincatto.nfe310.classes;

public enum NFTipoEmissao {

    EMISSAO_NORMAL("1", "Normal"),
    CONTINGENCIA_FS_IA("2", "Conting\u00eancia FS"),
    CONTINGENCIA_SCAN("3", "Conting\u00eancia SCAN"),
    CONTINGENCIA_DPEC("4", "Conting\u00eancia DPEC"),
    CONTINGENCIA_FSDA("5", "Conting\u00eancia FSDA"),
    CONTINGENCIA_SVCAN("6", "Conting\u00eancia SVCAN"),
    CONTINGENCIA_SVCRS("7", "Conting\u00eancia SVCRS"),
    CONTIGENCIA_OFFLINE("9", "Contig\u00eancia offline NFC-e");

    private final String codigo;
    private final String descricao;

    NFTipoEmissao(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static NFTipoEmissao valueOfCodigo(final String codigo) {
        for (final NFTipoEmissao tipo : NFTipoEmissao.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}