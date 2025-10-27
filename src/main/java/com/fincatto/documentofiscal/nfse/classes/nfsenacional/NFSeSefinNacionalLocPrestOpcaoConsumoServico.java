package com.fincatto.documentofiscal.nfse.classes.nfsenacional;


public enum NFSeSefinNacionalLocPrestOpcaoConsumoServico {

    MUNICIPIO_PRESTACAO("0", "Consumo do serviço prestado ocorrido no município do local da prestação"),
    EXTERIOR("1", "Consumo do serviço prestado ocorrido ocorrido no exterior");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalLocPrestOpcaoConsumoServico(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalLocPrestOpcaoConsumoServico valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalLocPrestOpcaoConsumoServico tipo : NFSeSefinNacionalLocPrestOpcaoConsumoServico.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}