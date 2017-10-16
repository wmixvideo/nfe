package com.fincatto.documentofiscal.nfe310.classes.nota.assinatura;

import java.io.Serializable;

import org.simpleframework.xml.Attribute;

public class NFCanonicalizationMethod implements Serializable {
    private static final long serialVersionUID = 8973536078416422021L;

    @Attribute(name = "Algorithm", required = false)
    private String algorithm;

    public String getAlgorithm() {
        return this.algorithm;
    }

    public void setAlgorithm(final String algorithm) {
        this.algorithm = algorithm;
    }

}
