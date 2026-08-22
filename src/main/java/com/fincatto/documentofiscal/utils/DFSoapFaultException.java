package com.fincatto.documentofiscal.utils;

/**
 * Representa um {@code soap:Fault} devolvido pelo webservice da SEFAZ - equivalente,
 * neste novo transporte, ao {@code org.apache.axis2.AxisFault} que o Axis2 lancava
 * para o mesmo cenario.
 * @author Marcos Lombardi de Andrade
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
