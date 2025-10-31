package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.Element;

public class NFSeSefinNacionalInfPedRegTE202205 extends NFSeSefinNacionalInfPedRegEventoTE{
    @Element(name = "infRej")
    protected NFSeSefinNacionalTCInfoEventoRejeicao infRej;

    public NFSeSefinNacionalInfPedRegTE202205() {
        super("Rejeição do Prestador", "202205");
    }
}
