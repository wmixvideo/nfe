package com.fincatto.documentofiscal.nfe310.classes;

public enum NFTipoImpressao {

    SEM_GERACAO_DANFE("0", "Sem gera\u00e7\u00e3o de DANFe"),
    DANFE_NORMAL_RETRATO("1", "DANFe normal retrato"),
    DANFE_NORMAL_PAISAGEM("2", "DANFe normal paisagem"),
    DANFE_SIMPLIFICADO("3", "DANFe simplificado"),
    DANFE_NFCE("4", "DANFe NFCe"),
    DANFE_NFCE_MENSAGEM_ELETRONICA("5", "DANFe NFCe mensagem eletr\u00f4nica");

    private final String codigo;
    private final String descricao;

    NFTipoImpressao(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFTipoImpressao valueOfCodigo(final String codigo) {
        for (final NFTipoImpressao tipo : NFTipoImpressao.values()) {
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