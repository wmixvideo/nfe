package com.fincatto.documentofiscal.nfse.classes.nfsenacional;


public enum NFSeSefinNacionalLocacaoSublocacaoObjeto {

    FERROVIA("1", "Ferrovia"),
    RODOVIA("2", "Rodovia"),
    POSTES("3", "Postes"),
    CABOS("4", "Cabos"),
    DUTOS("5", "Dutos"),
    QUALQUER_NATUREZA("6","Condutos de qualquer natureza");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalLocacaoSublocacaoObjeto(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalLocacaoSublocacaoObjeto valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalLocacaoSublocacaoObjeto tipo : NFSeSefinNacionalLocacaoSublocacaoObjeto.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
    }