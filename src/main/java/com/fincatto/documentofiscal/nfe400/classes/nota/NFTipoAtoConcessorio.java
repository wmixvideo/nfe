package com.fincatto.documentofiscal.nfe400.classes.nota;

public enum NFTipoAtoConcessorio {

    TERMO_DE_ACORDO("08", "Termo de Acordo"),
    REGIME_ESPECIAL("10", "Regime Especial"),
    AUTORIZACAO_ESPECIFICA("12", "Autoriza\u00E7\u00E3o espec\u00EDfica"),
    AJUSTE_SINIEF("14", "Ajuste SINIEF"),
    CONVENIO_ICMA("15", "Conv\u00EAnio ICMS");

    private final String codigo;
    private final String descricao;

    NFTipoAtoConcessorio(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFTipoAtoConcessorio valueOfCodigo(final String codigo) {
        for (final NFTipoAtoConcessorio indicador : NFTipoAtoConcessorio.values()) {
            if (indicador.getCodigo().equals(codigo)) {
                return indicador;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}