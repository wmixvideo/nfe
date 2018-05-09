package com.fincatto.documentofiscal.nfe400.classes.nota.assinatura;

import java.io.Serializable;

import org.simpleframework.xml.Attribute;

public class NFSignatureMethod implements Serializable {
    private static final long serialVersionUID = 4525403507445216913L;

    @Attribute(name = "Algorithm", required = false)
    private String algorithm;

    public String getAlgorithm() {
        return this.algorithm;
    }

    public void setAlgorithm(final String algorithm) {
        this.algorithm = algorithm;
    }

}
