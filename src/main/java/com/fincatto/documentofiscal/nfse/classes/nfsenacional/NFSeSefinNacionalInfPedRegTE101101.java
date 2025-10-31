package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.Element;

public class NFSeSefinNacionalInfPedRegTE101101 extends NFSeSefinNacionalInfPedRegEventoTE{

    @Element(name = "cMotivo")
    protected NFSeSefinNacionalTSCodJustCanc cMotivo;
    @Element(name = "xMotivo")
    protected String xMotivo;

    public NFSeSefinNacionalInfPedRegTE101101() {
        super("Cancelamento de NFS-e", "101101");
    }

    public NFSeSefinNacionalTSCodJustCanc getcMotivo() {
        return cMotivo;
    }

    public NFSeSefinNacionalInfPedRegTE101101 setcMotivo(NFSeSefinNacionalTSCodJustCanc cMotivo) {
        this.cMotivo = cMotivo;
        return this;
    }

    public String getxMotivo() {
        return xMotivo;
    }

    public NFSeSefinNacionalInfPedRegTE101101 setxMotivo(String xMotivo) {
        this.xMotivo = xMotivo;
        return this;
    }
}
