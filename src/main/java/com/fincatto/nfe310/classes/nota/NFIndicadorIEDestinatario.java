package com.fincatto.nfe310.classes.nota;

public enum NFIndicadorIEDestinatario {
    CONTRIBUINTE_ICMS("1", "Contribuinte ICMS"),
    CONTRIBUINTE_ISENTO_INSCRICAO_CONTRIBUINTES_ICMS("2", "Contribuinte isento inscrição contribuintes ICMS"),
    NAO_CONTRIBUINTE("9", "Não contribuinte");

    private final String codigo;
    private final String desc;

    NFIndicadorIEDestinatario(final String codigo, final String desc) {
        this.codigo = codigo;
        this.desc = desc;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFIndicadorIEDestinatario valueOfCodigo(final String codigo) {
        for (final NFIndicadorIEDestinatario indicador : NFIndicadorIEDestinatario.values()) {
            if (indicador.getCodigo().equals(codigo)) {
                return indicador;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
    	return codigo+" - "+desc;
    }
}