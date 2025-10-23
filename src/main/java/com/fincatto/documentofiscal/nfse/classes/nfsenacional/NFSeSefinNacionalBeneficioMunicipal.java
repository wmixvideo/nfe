
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

@Root(name = "BeneficioMunicipal")
public class NFSeSefinNacionalBeneficioMunicipal {

    @Element(required = true)
    protected String tpBM;
    @Element(name = "nBM", required = false)
    protected String nbm;
    protected String vRedBCBM;
    protected String pRedBCBM;

    public String getTpBM() {
        return tpBM;
    }

    public void setTpBM(String value) {
        this.tpBM = value;
    }

    public String getNBM() {
        return nbm;
    }

    public void setNBM(String value) {
        this.nbm = value;
    }

    public String getVRedBCBM() {
        return vRedBCBM;
    }

    public void setVRedBCBM(String value) {
        this.vRedBCBM = value;
    }

    public String getPRedBCBM() {
        return pRedBCBM;
    }

    public void setPRedBCBM(String value) {
        this.pRedBCBM = value;
    }

}
