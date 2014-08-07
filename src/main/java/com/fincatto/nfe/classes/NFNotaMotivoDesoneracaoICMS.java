package com.fincatto.nfe.classes;

public enum NFNotaMotivoDesoneracaoICMS {
    TAXI(1),
    DEFICIENTE_FISICO(2),
    PRODUTOR_AGROPECUARIO(3),
    FROTISTA_LOCADORA(4),
    DIPLOMATICO_CONSULAR(5),
    UTILITARIOS_MOTOCICLETAS_AMAZONIA_OCIDENTAL_AREAS_LIVRE_COMERCIO(6),
    SUFRAMA(7),
    VENDA_ORGAOS_PUBLICOS(8),
    OUTROS(9);

    private final int codigo;

    private NFNotaMotivoDesoneracaoICMS(final int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public static NFNotaMotivoDesoneracaoICMS valueOfCodigo(final int codigo) {
        for (final NFNotaMotivoDesoneracaoICMS motivoDesonaracao : NFNotaMotivoDesoneracaoICMS.values()) {
            if (motivoDesonaracao.getCodigo() == codigo) {
                return motivoDesonaracao;
            }
        }
        return null;
    }
}