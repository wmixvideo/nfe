package com.fincatto.nfe.classes.nota;

public enum NFNotaInfoMotivoDesoneracaoICMS {

    USO_NA_AGROPECUARIA("3"),
    UTILITARIOS_MOTOCICLETAS_AMAZONIA_OCIDENTAL_AREAS_LIVRES_COMERCIO("6"),
    SUFRAMA("7"),
    OUTROS("9"),
    ORGAO_FOMENTO_DESENVOLVIMENTO_AGROPECUARIO("12");

    private String codigo;

    private NFNotaInfoMotivoDesoneracaoICMS(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFNotaInfoMotivoDesoneracaoICMS valueOfCodigo(final String codigo) {
        for (final NFNotaInfoMotivoDesoneracaoICMS desoneracaoICMS : NFNotaInfoMotivoDesoneracaoICMS.values()) {
            if (desoneracaoICMS.getCodigo().equals(codigo)) {
                return desoneracaoICMS;
            }
        }
        return null;
    }
}