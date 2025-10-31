package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.Element;

public class NFSeSefinNacionalInfPedRegTE305101 extends NFSeSefinNacionalInfPedRegEventoTE{
    @Element(name = "CPFAgTrib")
    protected String cPFAgTrib;
    @Element(name = "nProcAdm")
    protected String nProcAdm;
    @Element(name = "xProcAdm")
    protected String xProcAdm;

    public NFSeSefinNacionalInfPedRegTE305101() {
        super("Cancelamento de NFS-e por Ofício", "305101");
    }

    public String getcPFAgTrib() {
        return cPFAgTrib;
    }

    public NFSeSefinNacionalInfPedRegTE305101 setcPFAgTrib(String cPFAgTrib) {
        this.cPFAgTrib = cPFAgTrib;
        return this;
    }

    public String getnProcAdm() {
        return nProcAdm;
    }

    public NFSeSefinNacionalInfPedRegTE305101 setnProcAdm(String nProcAdm) {
        this.nProcAdm = nProcAdm;
        return this;
    }

    public String getxProcAdm() {
        return xProcAdm;
    }

    public NFSeSefinNacionalInfPedRegTE305101 setxProcAdm(String xProcAdm) {
        this.xProcAdm = xProcAdm;
        return this;
    }
}
