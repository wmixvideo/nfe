package com.fincatto.documentofiscal.cte200.classes;

import java.util.Arrays;
import java.util.List;

public enum CTTipoEntregaHorario {

    SEM_HORARIO("0", "Sem hor\u00e1rio definido"),
    NO_HORARIO("1", "No hor\u00e1rio"),
    ATE_HORARIO("2", "Ate\u0301 o hor\u00e1rio"),
    A_PARTIR_HORARIO("3", "A partir do hor\u00e1rio"),
    NO_INTERVALO("4", "No intervalo de tempo");

    public static final List<CTTipoEntregaHorario> COM_HORARIO = Arrays.asList(CTTipoEntregaHorario.NO_HORARIO, CTTipoEntregaHorario.ATE_HORARIO, CTTipoEntregaHorario.A_PARTIR_HORARIO);

    private final String codigo;
    private final String descricao;

    CTTipoEntregaHorario(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static CTTipoEntregaHorario valueOfCodigo(final String codigo) {
        for (final CTTipoEntregaHorario tipo : CTTipoEntregaHorario.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.codigo + " - " + this.descricao;
    }
}