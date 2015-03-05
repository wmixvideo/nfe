package com.fincatto.nfe310.classes.nota.assinatura;

import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFBase;

public class NFX509Data extends NFBase {

    @Element(name = "X509Certificate", required = false)
    private String x509certificate;

    public String getX509certificate() {
        return this.x509certificate;
    }

    public void setX509certificate(final String x509certificate) {
        this.x509certificate = x509certificate;
    }
}