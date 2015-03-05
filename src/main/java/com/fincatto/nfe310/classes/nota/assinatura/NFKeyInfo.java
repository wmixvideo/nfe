package com.fincatto.nfe310.classes.nota.assinatura;

import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFBase;

public class NFKeyInfo extends NFBase {

    @Element(name = "X509Data", required = false)
    private NFX509Data data;

    public NFX509Data getData() {
        return this.data;
    }

    public void setData(final NFX509Data data) {
        this.data = data;
    }
}