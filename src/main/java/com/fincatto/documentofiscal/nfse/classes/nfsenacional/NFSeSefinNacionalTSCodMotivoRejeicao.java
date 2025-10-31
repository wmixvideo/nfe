package com.fincatto.documentofiscal.nfse.classes.nfsenacional;


import org.simpleframework.xml.Root;

public enum NFSeSefinNacionalTSCodMotivoRejeicao {

        DUPLICIDADE("1", "NFS-e em duplicidade"),
        EMITIDA_TOMADOR("2", "NFS-e já emitida pelo tomador"),
        NAO_OCORRENCIA_FATO_GERADOR("3", "Não ocorrência do fato gerador"),
        RESPONSABILIDADE_TRIBUTA("4", "Erro quanto a responsabilidade tributária"),
        VALORES("5", "Erro quanto ao valor do serviço, valor das deduções ou serviço prestado ou data do fato gerador"),
        OUTROS("9", "Outros");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalTSCodMotivoRejeicao(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalTSCodMotivoRejeicao valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalTSCodMotivoRejeicao tipo : NFSeSefinNacionalTSCodMotivoRejeicao.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}