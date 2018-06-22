package com.fincatto.documentofiscal.cte200.classes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum CTTomadorServico {

    REMETENTE("0", "Remetente"),
    EXPEDIDOR("1", "Expedidor"),
    RECEBEDOR("2", "Recebedor"),
    DESTINATARIO("3", "Destinata\u0301rio"),
    OUTROS("4", "Outros");

    public static final List<CTTomadorServico> TOMADOR_3 = Arrays.asList(CTTomadorServico.REMETENTE, CTTomadorServico.EXPEDIDOR, CTTomadorServico.RECEBEDOR, CTTomadorServico.DESTINATARIO);
    public static final List<CTTomadorServico> TOMADOR_4 = Collections.singletonList(CTTomadorServico.OUTROS);

    private final String codigo;
    private final String descricao;

    CTTomadorServico(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static CTTomadorServico valueOfCodigo(final String codigo) {
        for (final CTTomadorServico formaPagamento : CTTomadorServico.values()) {
            if (formaPagamento.getCodigo().equals(codigo)) {
                return formaPagamento;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.codigo + " - " + this.descricao;
    }
}