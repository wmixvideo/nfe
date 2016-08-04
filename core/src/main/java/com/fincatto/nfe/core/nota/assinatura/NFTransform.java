package com.fincatto.nfe.core.nota.assinatura;

import com.fincatto.nfe.core.NFBase;
import org.simpleframework.xml.Attribute;

public class NFTransform extends NFBase {
    @Attribute(name = "Algorithm", required = false)
    private String algorithm;

    public void setAlgorithm(final String algorithm) {
        this.algorithm = algorithm;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }
}