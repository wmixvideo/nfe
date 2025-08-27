package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.Element;

public class CTePAARSAKeyValue extends DFBase {
    private static final long serialVersionUID = -3231751006992452317L;

    @Element(name = "Modulus")
    private String modulus;

    @Element(name = "Exponent")
    private String exponent;

    public String getExponent() {
        return exponent;
    }

    public void setExponent(String exponent) {
        this.exponent = exponent;
    }
}
