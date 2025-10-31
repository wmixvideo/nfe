package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.Element;

public class NFSeSefinNacionalInfPedRegTE204207 extends NFSeSefinNacionalInfPedRegEventoTE{
    @Element(name = "infRej")
    protected NFSeSefinNacionalTCInfoEventoRejeicao infRej;

    public NFSeSefinNacionalInfPedRegTE204207() {
        super("Rejeição do Intermediário", "204207");
    }
}
