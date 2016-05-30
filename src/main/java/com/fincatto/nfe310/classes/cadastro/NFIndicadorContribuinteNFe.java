package com.fincatto.nfe310.classes.cadastro;

public enum NFIndicadorContribuinteNFe {

    NAO_CREDENCIADO_PARA_EMISSAO_NFE(0, "Não credenciado para emissão de NFe"),
    CREDENCIADO(1, "Credenciado"),
    CREDENCIADO_COM_OBRIGATORIEDADE_PARA_TODAS_OPERACOES(2, "Credenciado com obrigatoriedade para todas operações"),
    CREDENCIADO_COM_OBRIGATORIEDADE_PARCIAL(3, "Credenciado com obrigatoriedade parcial"),
    SEFAZ_NAO_FORNECE_ESSA_INFO(4, "Sefaz não fornece essa informação");

    private final int codigo;
    private final String desc;

    NFIndicadorContribuinteNFe(final int codigo, final String desc) {
        this.codigo = codigo;
        this.desc = desc;
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
    	return codigo+" - "+desc;
    }
}