package com.fincatto.documentofiscal.mdfe3.classes.def;

/**
 * @Author FAGNER ROGER
 */
public enum MDFTipoPermissaoAntecipacao {

    NAO_PERMITE_ANTECIPAR("0", "N\u00e3o permite antecipar"),
    PERMITE_ANTECIPAR("1", "Permite antecipar as parcelas"),
    PERMITE_ANTECIPAR_COM_CONFIRMACAO("2", "Permite antecipar as parcelas mediante confirma\u00e7\u00e3o");

    private final String codigo;
    private final String descricao;

    MDFTipoPermissaoAntecipacao(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static MDFTipoPermissaoAntecipacao valueOfCodigo(final String codigo) {
        for (MDFTipoPermissaoAntecipacao tipoEmitente : MDFTipoPermissaoAntecipacao.values()) {
            if (tipoEmitente.getCodigo().equalsIgnoreCase(codigo)) {
                return tipoEmitente;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}
