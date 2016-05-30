package com.fincatto.nfe310.classes.nota;

public enum NFNotaInfoRegimeEspecialTributacao {

    MICROEMPRESA_MUNICIPAL("1", "Microempresa municipal"),
    ESTIMATIVA("2", "Estimativa"),
    SOCIEDADE_PROFISSIONAIS("3", "Sociedade profissionais"),
    COOPERATIVA("4", "Cooperativa"),
    MICROEMPRESARIO_INDIVIDUAL_MEI("5", "Microempresário individual MEI"),
    MICROEMPRESARIO_E_EMPRESA_PEQUENOPORTE("6", "Microempresário e empresa de pequeno porte");

    private final String codigo;
    private final String desc;

    NFNotaInfoRegimeEspecialTributacao(final String codigo, final String desc) {
        this.codigo = codigo;
        this.desc = desc;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFNotaInfoRegimeEspecialTributacao valueOfCodigo(final String codigo) {
        for (final NFNotaInfoRegimeEspecialTributacao tributacao : NFNotaInfoRegimeEspecialTributacao.values()) {
            if (tributacao.getCodigo().equals(codigo)) {
                return tributacao;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
    	return codigo+" - "+desc;
    }
}