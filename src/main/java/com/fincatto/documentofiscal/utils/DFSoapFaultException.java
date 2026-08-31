package com.fincatto.documentofiscal.utils;

/**
 * Representa um {@code soap:Fault} devolvido pelo webservice da SEFAZ;
 *
 * @see DFSoapEnvelope#desempacotar(String)
 */
public class DFSoapFaultException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * @param motivo texto do {@code soap:Reason}/{@code soap:Text} do Fault devolvido pela SEFAZ.
     */
    public DFSoapFaultException(final String motivo) {
        super(motivo);
    }
}
