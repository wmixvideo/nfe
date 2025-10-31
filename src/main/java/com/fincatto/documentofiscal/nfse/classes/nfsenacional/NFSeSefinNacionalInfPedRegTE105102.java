package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.Element;

public class NFSeSefinNacionalInfPedRegTE105102 extends NFSeSefinNacionalInfPedRegEventoTE{

    @Element(name = "cMotivo")
    protected NFSeSefinNacionalTSCodJustSubst cMotivo;
    @Element(name = "xMotivo", required = false)
    protected String xMotivo;
    @Element(name = "chSubstituta")
    protected String chSubstituta;

    public NFSeSefinNacionalInfPedRegTE105102() {
        super("Cancelamento de NFS-e por Substituição", "105102");
    }

    public NFSeSefinNacionalTSCodJustSubst getcMotivo() {
        return cMotivo;
    }

    public NFSeSefinNacionalInfPedRegTE105102 setcMotivo(NFSeSefinNacionalTSCodJustSubst cMotivo) {
        this.cMotivo = cMotivo;
        return this;
    }

    public String getxMotivo() {
        return xMotivo;
    }

    public NFSeSefinNacionalInfPedRegTE105102 setxMotivo(String xMotivo) {
        this.xMotivo = xMotivo;
        return this;
    }

    public String getChSubstituta() {
        return chSubstituta;
    }

    public NFSeSefinNacionalInfPedRegTE105102 setChSubstituta(String chSubstituta) {
        this.chSubstituta = chSubstituta;
        return this;
    }
}
