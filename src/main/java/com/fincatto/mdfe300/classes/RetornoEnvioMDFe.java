package com.fincatto.mdfe300.classes;

import br.inf.portalfiscal.mdfe.TRetEnviMDFe;

public class RetornoEnvioMDFe {

    private final String documentoAssinado;
    private final TRetEnviMDFe tRetEnviMDFe;

    public RetornoEnvioMDFe(String documentoAssinado, TRetEnviMDFe tRetEnviMDFe) {
        this.documentoAssinado = documentoAssinado;
        this.tRetEnviMDFe = tRetEnviMDFe;
    }

    /**
     * Método que retorna o XML assinado que foi enviado para a SEFAZ
     * @return
     */
    public String getDocumentoAssinado() {
        return documentoAssinado;
    }

    public TRetEnviMDFe gettRetEnviMDFe() {
        return tRetEnviMDFe;
    }

}