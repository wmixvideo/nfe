package com.fincatto.documentofiscal.nfe400.classes.cadastro;

public enum NFIndicadorContribuinteNFe {

    NAO_CREDENCIADO_PARA_EMISSAO_NFE(0, "N\u00e3o credenciado para emiss\u00e3o de NFe"),
    CREDENCIADO(1, "Credenciado"),
    CREDENCIADO_COM_OBRIGATORIEDADE_PARA_TODAS_OPERACOES(2, "Credenciado com obrigatoriedade para todas opera\u00e7\u00f5es"),
    CREDENCIADO_COM_OBRIGATORIEDADE_PARCIAL(3, "Credenciado com obrigatoriedade parcial"),
    SEFAZ_NAO_FORNECE_ESSA_INFO(4, "Sefaz n\u00e3o fornece essa informa\u00e7\u00e3o");

    private final int codigo;
    private final String descricao;

    NFIndicadorContribuinteNFe(final int codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public static NFIndicadorContribuinteNFe valueOfCodigo(final int codigo) {
        for (final NFIndicadorContribuinteNFe indicador : NFIndicadorContribuinteNFe.values()) {
            if (indicador.getCodigo() == codigo) {
                return indicador;
            }
        }
        throw new IllegalStateException(String.format("Nao existe o codigo %s", codigo));
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}