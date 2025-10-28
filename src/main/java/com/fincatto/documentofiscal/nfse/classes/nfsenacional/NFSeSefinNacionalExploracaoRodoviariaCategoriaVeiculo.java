package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

public enum NFSeSefinNacionalExploracaoRodoviariaCategoriaVeiculo {

    NAO_INFORMADO("00", "Categoria de Veículos (tipo não informado na nota de origem)"),
    AUTOMOVEL_LEVE("01", "Automóvel, caminhonete e furgão"),
    CAMINHAO_LEVE("02", "Caminhão leve, ônibus, caminhão trator e furgão"),
    AUTOMOVEL_SEMIREBOQUE("03", "Automóvel e caminhonete com semireboque"),
    CAMINHAO_SEMIREBOQUE("04", "Caminhão, caminhão-trator, caminhão-trator com semi-reboque e ônibus"),
    AUTOMOVEL_REBOQUE("05", "Automóvel e caminhonete com reboque"),
    CAMINHAO_REBOQUE_TRATOR_SEMIREBOQUE_06("06", "Caminhão com reboque e caminhãotrator com semi-reboque"),
    CAMINHAO_REBOQUE_TRATOR_SEMIREBOQUE_07("07", "Caminhão com reboque e caminhãotrator com semi-reboque"),
    CAMINHAO_REBOQUE_TRATOR_SEMIREBOQUE_08("08", "Caminhão com reboque e caminhãotrator com semi-reboque"),
    MOTOCICLETAS("09", "Motocicletas, motonetas e bicicletas motorizadas"),
    ESPECIAL("10", "Veículo especial"),
    ISENTO("11", "Veículo Isento");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalExploracaoRodoviariaCategoriaVeiculo(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalExploracaoRodoviariaCategoriaVeiculo valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalExploracaoRodoviariaCategoriaVeiculo tipo : NFSeSefinNacionalExploracaoRodoviariaCategoriaVeiculo.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}