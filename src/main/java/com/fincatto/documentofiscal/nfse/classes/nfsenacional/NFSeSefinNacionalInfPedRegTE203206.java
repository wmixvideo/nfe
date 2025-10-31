package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.Element;

public class NFSeSefinNacionalInfPedRegTE203206 extends NFSeSefinNacionalInfPedRegEventoTE{
    @Element(name = "infRej")
    protected NFSeSefinNacionalTCInfoEventoRejeicao infRej;

    public NFSeSefinNacionalInfPedRegTE203206() {
        super("Rejeição do Tomador", "203206");
    }
}
