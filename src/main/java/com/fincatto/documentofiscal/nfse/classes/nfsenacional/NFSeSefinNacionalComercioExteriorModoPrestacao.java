package com.fincatto.documentofiscal.nfse.classes.nfsenacional;


public enum NFSeSefinNacionalComercioExteriorModoPrestacao {

    DESCONHECIDO("0", "Desconhecido (tipo não informado na nota de origem)"),
    TRANSFRONTEIRICO("1", "Transfronteiriço"),
    CONSUMO("2", "Consumo no Brasil"),
    PRESENCA("3", "Presença Comercial no Exterior"),
    MOVIMENTO("4", "Movimento Temporário de Pessoas Físicas");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalComercioExteriorModoPrestacao(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalComercioExteriorModoPrestacao valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalComercioExteriorModoPrestacao tipo : NFSeSefinNacionalComercioExteriorModoPrestacao.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}