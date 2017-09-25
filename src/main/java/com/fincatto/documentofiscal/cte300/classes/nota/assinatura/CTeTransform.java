package com.fincatto.documentofiscal.cte300.classes.nota.assinatura;

import org.simpleframework.xml.Attribute;

import com.fincatto.documentofiscal.DFBase;

public class CTeTransform extends DFBase {
    @Attribute(name = "Algorithm", required = false)
    private String algorithm;

    public void setAlgorithm(final String algorithm) {
        this.algorithm = algorithm;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }
}