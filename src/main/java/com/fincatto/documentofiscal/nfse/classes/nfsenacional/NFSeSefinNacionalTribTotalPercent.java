
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

@Root(name = "TribTotalPercent")
public class NFSeSefinNacionalTribTotalPercent {

    @Element(name = "pTotTribFed")
    protected String percentualTributosFederais;
    @Element(name = "pTotTribEst")
    protected String percentualTributosEstaduais;
    @Element(name = "pTotTribMun")
    protected String percentualTributosMunicipais;

    public String getPercentualTributosFederais() {
        return percentualTributosFederais;
    }

    public void setPercentualTributosFederais(String value) {
        this.percentualTributosFederais = value;
    }

    public String getPercentualTributosEstaduais() {
        return percentualTributosEstaduais;
    }

    public void setPercentualTributosEstaduais(String value) {
        this.percentualTributosEstaduais = value;
    }

    public String getPercentualTributosMunicipais() {
        return percentualTributosMunicipais;
    }

    public void setPercentualTributosMunicipais(String value) {
        this.percentualTributosMunicipais = value;
    }

}
