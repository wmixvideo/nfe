
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * Grupo de informações relativas ao valores para dedução/redução do valor da base de cálculo (valor do serviço)
 */

@Root(name = "vDedRed")
public class NFSeSefinNacionalInfoDedRed {

    @Element(name = "pDR")
    protected String percentualPadrao;
    @Element(name = "vDR")
    protected String valorMonetarioPadrao;
    @Element(name = "documentos")
    protected NFSeSefinNacionalListaDocDedRed documentos;

    public String getPercentualPadrao() {
        return percentualPadrao;
    }

    public void setPercentualPadrao(String percentualPadrao) {
        this.percentualPadrao = percentualPadrao;
    }

    public String getValorMonetarioPadrao() {
        return valorMonetarioPadrao;
    }

    public void setValorMonetarioPadrao(String valorMonetarioPadrao) {
        this.valorMonetarioPadrao = valorMonetarioPadrao;
    }

    public NFSeSefinNacionalListaDocDedRed getDocumentos() {
        return documentos;
    }

    public void setDocumentos(NFSeSefinNacionalListaDocDedRed documentos) {
        this.documentos = documentos;
    }

}
