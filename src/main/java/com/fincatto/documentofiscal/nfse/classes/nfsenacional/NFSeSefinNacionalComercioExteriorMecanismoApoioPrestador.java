package com.fincatto.documentofiscal.nfse.classes.nfsenacional;


public enum NFSeSefinNacionalComercioExteriorMecanismoApoioPrestador {

    DESCONHECIDO("00", "Desconhecido (tipo não informado na nota de origem)"),
    NENHUM("01", "Nenhum"),
    ACC("02", "ACC - Adiantamento sobre Contrato de Câmbio – Redução a Zero do IR e do IOF"),
    ACE("03", "ACE – Adiantamento sobre Cambiais Entregues - Redução a Zero do IR e do IOF"),
    BNDES_POS_EMBARQUE("04", "BNDES-Exim Pós-Embarque – Serviços"),
    BNDES_PRE_EMBARQUE("05", "BNDES-Exim Pré-Embarque - Serviços"),
    FGE("06", "FGE - Fundo de Garantia à Exportação"),
    PROEX_EQUALIZACAO("07", "PROEX - EQUALIZAÇÃO"),
    PROEX_FINANCIAMENTO("08", "PROEX - Financiamento");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalComercioExteriorMecanismoApoioPrestador(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalComercioExteriorMecanismoApoioPrestador valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalComercioExteriorMecanismoApoioPrestador tipo : NFSeSefinNacionalComercioExteriorMecanismoApoioPrestador.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}