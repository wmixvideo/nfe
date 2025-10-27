package com.fincatto.documentofiscal.nfse.classes.nfsenacional;


public enum NFSeSefinNacionalComercioExteriorMovimentacaoTemporariaBens {

    DESCONHECIDO("0", "Desconhecido (tipo não informado na nota de origem)"),
    NAO("1", "Não"),
    VINCULADA_IMPORTACAO("2", "Vinculada - Declaração de Importação"),
    VINCULADA_EXPORTACAO("3", "Vinculada - Declaração de Exportação");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalComercioExteriorMovimentacaoTemporariaBens(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalComercioExteriorMovimentacaoTemporariaBens valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalComercioExteriorMovimentacaoTemporariaBens tipo : NFSeSefinNacionalComercioExteriorMovimentacaoTemporariaBens.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}