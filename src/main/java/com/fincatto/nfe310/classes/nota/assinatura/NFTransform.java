package com.fincatto.nfe310.classes.nota.assinatura;

import org.simpleframework.xml.Attribute;

import com.fincatto.nfe310.classes.NFBase;

public class NFTransform extends NFBase {
    @Attribute(name = "Algorithm", required = false)
    private String algorithm;
}
