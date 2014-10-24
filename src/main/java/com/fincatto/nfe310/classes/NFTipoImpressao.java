package com.fincatto.nfe310.classes;

public enum NFTipoImpressao {
    SEM_GERACAO_DANFE("0"),
    DANFE_NORMAL_RETRATO("1"),
    DANFE_NORMAL_PAISAGEM("2"),
    DANFE_SIMPLIFICADO("3"),
    DANFE_NFCE("4"),
    DANFE_NFCE_MENSAGEM_ELETRONICA("5");

    private final String codigo;

    private NFTipoImpressao(final String codigo) {
        this.codigo = codigo;
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
}