package com.fincatto.documentofiscal.utils;

/**
 * Lancada quando a SEFAZ responde a um envio de evento com status diferente de
 * "Lote de Evento Processado", expondo o codigo e o motivo devolvidos para que o
 * chamador possa trata-los programaticamente, sem parsear a mensagem.
 */
public class DFEventoNaoProcessadoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final int codigoStatus;
    private final String motivo;

    public DFEventoNaoProcessadoException(final int codigoStatus, final String motivo) {
        super("Status: " + codigoStatus + " - Motivo: " + motivo);
        this.codigoStatus = codigoStatus;
        this.motivo = motivo;
    }

    public int getCodigoStatus() {
        return this.codigoStatus;
    }

    public String getMotivo() {
        return this.motivo;
    }
}
