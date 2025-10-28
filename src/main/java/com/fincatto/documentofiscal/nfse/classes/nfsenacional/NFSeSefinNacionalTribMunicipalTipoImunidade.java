package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

public enum NFSeSefinNacionalTribMunicipalTipoImunidade {

    NAO_INFORMADA("0", "Imunidade (tipo não informado na nota de origem)"),
    SERVICOS_UNS_DOS_OUTROS("1", "Patrimônio, renda ou serviços, uns dos outros (CF88, Art 150, VI, a)"),
    TEMPLOS("2", "Templos de qualquer culto (CF88, Art 150, VI, b)"),
    PARTIDOS_POLITICOS("3", "Patrimônio, renda ou serviços dos partidos políticos, inclusive suas fundações, das entidades sindicais dos trabalhadores, das instituições de        educação e de assistência social, sem fins lucrativos, atendidos os requisitos da lei (CF88, Art 150, VI, c)"),
    LIVROS_JORNAIS_PERIODICOS("4", "Livros, jornais, periódicos e o papel destinado a sua impressão (CF88, Art 150, VI, d)"),
    FONOGRAMAS("5", "Fonogramas e videofonogramas musicais produzidos no Brasil contendo obras musicais ou literomusicais de autores brasileiros e/ou obras em geral interpretadas por artistas brasileiros bem como os suportes materiais ou arquivos digitais que os contenham, salvo na etapa de replicação industrial de mídias ópticas de leitura a laser. (CF88, Art 150, VI, e)");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalTribMunicipalTipoImunidade(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalTribMunicipalTipoImunidade valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalTribMunicipalTipoImunidade tipo : NFSeSefinNacionalTribMunicipalTipoImunidade.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}