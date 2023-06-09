package com.fincatto.documentofiscal.cte400.classes;

public enum CTTipoPrazoHoraEntrega {

    SEM_HORA_DEFINIDA("0", "Sem hora definida"),
    NO_HORARIO("1", "No horário"),
    ATE_A_HORARIO("2", "Até o horário"),
    A_PARTIR_DO_HORARIO("3", "A partir do horário"),
    NO_INTERVALO_DE_TEMPO("4", "No intervalo de tempo");

    private final String codigo;
    private final String descricao;

    CTTipoPrazoHoraEntrega(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static CTTipoPrazoHoraEntrega valueOfCodigo(final String codigo) {
        for (final CTTipoPrazoHoraEntrega tipo : CTTipoPrazoHoraEntrega.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}