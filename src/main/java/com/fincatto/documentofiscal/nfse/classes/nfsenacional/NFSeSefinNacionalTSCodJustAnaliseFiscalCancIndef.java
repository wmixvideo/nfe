package com.fincatto.documentofiscal.nfse.classes.nfsenacional;


import org.simpleframework.xml.Root;

public enum NFSeSefinNacionalTSCodJustAnaliseFiscalCancIndef {

    EXTEMPORANEO("1", "Cancelamento Extemporâneo Indeferido"),
    EXTEMPORANEO_SEM_ANALISE_MERITO("2", "Cancelamento Extemporâneo Indeferido Sem Análise de Mérito.");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalTSCodJustAnaliseFiscalCancIndef(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalTSCodJustAnaliseFiscalCancIndef valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalTSCodJustAnaliseFiscalCancIndef tipo : NFSeSefinNacionalTSCodJustAnaliseFiscalCancIndef.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}