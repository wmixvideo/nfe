package com.fincatto.nfe200.classes.nota.assinatura;

import org.simpleframework.xml.Element;

import com.fincatto.nfe200.classes.NFBase;

public class NFX509Data extends NFBase {

    @Element(name = "X509Certificate", required = false)
    private String x509certificate;

    public String getX509certificate() {
        return this.x509certificate;
    }
}