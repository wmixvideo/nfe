package com.fincatto.documentofiscal.nfse.classes.nfsenacional;


public enum NFSeSefinNacionalLocacaoSublocacaoCategoriaServico {

    LOCACAO("1", "Locação"),
    SUBLOCACAO("2", "Sublocação"),
    ARRENDAMENTO("3", "Arrendamento"),
    DIREITO("4", "Direito de passagem"),
    PERMISSAO("5", "Permissão de uso");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalLocacaoSublocacaoCategoriaServico(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalLocacaoSublocacaoCategoriaServico valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalLocacaoSublocacaoCategoriaServico tipo : NFSeSefinNacionalLocacaoSublocacaoCategoriaServico.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}