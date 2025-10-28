
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

@Root(name = "TribTotalMonet")
public class NFSeSefinNacionalTribTotalMonet {

    @Element(name = "vTotTribFed")
    protected String valorTributosFederais;
    @Element(name = "vTotTribEst")
    protected String valorTributosEstaduais;
    @Element(name = "vTotTribMun")
    protected String valorTributosMunicipais;

    public String getValorTributosFederais() {
        return valorTributosFederais;
    }

    public void setValorTributosFederais(String valorTributosFederais) {
        this.valorTributosFederais = valorTributosFederais;
    }

    public String getValorTributosEstaduais() {
        return valorTributosEstaduais;
    }

    public void setValorTributosEstaduais(String valorTributosFederais) {
        this.valorTributosEstaduais = valorTributosFederais;
    }

    public String getValorTributosMunicipais() {
        return valorTributosMunicipais;
    }

    public void setValorTributosMunicipais(String valorTributosFederais) {
        this.valorTributosMunicipais = valorTributosFederais;
    }

}
