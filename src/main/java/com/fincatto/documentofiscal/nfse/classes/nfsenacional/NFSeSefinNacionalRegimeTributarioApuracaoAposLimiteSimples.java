package com.fincatto.documentofiscal.nfse.classes.nfsenacional;


public enum NFSeSefinNacionalRegimeTributarioApuracaoAposLimiteSimples {

    SN("1", "Apuração dos tributos federais e municipal pelo SN"),
    SN_E_ISSQN("2", "Apuração dos tributos federais pelo SN e ISSQN  por fora do SN conforme respectiva legislação municipal do tributo"),
    TRIBUTOS_INDIVIDUAIS_POR_AMBITO("3", "Apuração dos tributos federais e municipal por fora do SN conforme respectivas legilações federal e municipal de cada tributo");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalRegimeTributarioApuracaoAposLimiteSimples(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalRegimeTributarioApuracaoAposLimiteSimples valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalRegimeTributarioApuracaoAposLimiteSimples tipo : NFSeSefinNacionalRegimeTributarioApuracaoAposLimiteSimples.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}