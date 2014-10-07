package com.fincatto.nfe.classes.nota.assinatura;

import org.simpleframework.xml.Attribute;

import com.fincatto.nfe.classes.NFBase;

public class NFTransform extends NFBase {
    @Attribute(name = "Algorithm", required = false)
    private String algorithm;
}
