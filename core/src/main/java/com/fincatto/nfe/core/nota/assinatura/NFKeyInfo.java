package com.fincatto.nfe.core.nota.assinatura;

import com.fincatto.nfe.core.NFBase;
import org.simpleframework.xml.Element;

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