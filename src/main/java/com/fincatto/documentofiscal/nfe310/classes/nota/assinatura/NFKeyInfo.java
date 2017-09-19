package com.fincatto.documentofiscal.nfe310.classes.nota.assinatura;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;

public class NFKeyInfo extends DFBase {

    @Element(name = "X509Data", required = false)
    private NFX509Data data;

    public NFX509Data getData() {
        return this.data;
    }

    public void setData(final NFX509Data data) {
        this.data = data;
    }
}