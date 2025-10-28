package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

public enum NFSeSefinNacionalExigSuspensaTipoSuspensao {

    DECISAO_JUDICIAL("1", "Exigibilidade Suspensa por Decisão Judicial"),
    PROCESSO_ADMINISTRATIVO("2", "Exigibilidade Suspensa por Processo Administrativo");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalExigSuspensaTipoSuspensao(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalExigSuspensaTipoSuspensao valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalExigSuspensaTipoSuspensao tipo : NFSeSefinNacionalExigSuspensaTipoSuspensao.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}