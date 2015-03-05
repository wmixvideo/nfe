package com.fincatto.nfe310.classes.nota;

public enum NFNotaInfoRegimeEspecialTributacao {

    MICROEMPRESA_MUNICIPAL("1"),
    ESTIMATIVA("2"),
    SOCIEDADE_PROFISSIONAIS("3"),
    COOPERATIVA("4"),
    MICROEMPRESARIO_INDIVIDUAL_MEI("5"),
    MICROEMPRESARIO_E_EMPRESA_PEQUENOPORTE("6");

    private String codigo;

    private NFNotaInfoRegimeEspecialTributacao(final String codigo) {
        this.codigo = codigo;
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
}