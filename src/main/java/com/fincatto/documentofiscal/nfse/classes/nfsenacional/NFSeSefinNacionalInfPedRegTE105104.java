package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.Element;

public class NFSeSefinNacionalInfPedRegTE105104 extends NFSeSefinNacionalInfPedRegEventoTE{

    @Element(name = "CPFAgTrib")
    protected String CPFAgTrib;
    @Element(name = "nProcAdm", required = false)
    protected String nProcAdm;
    @Element(name = "cMotivo")
    protected String cMotivo;
    @Element(name = "xMotivo")
    protected String xMotivo;

    public NFSeSefinNacionalInfPedRegTE105104() {
        super("Cancelamento de NFS-e Deferido por Análise Fiscal", "105104");
    }

    public String getCPFAgTrib() {
        return CPFAgTrib;
    }

    public NFSeSefinNacionalInfPedRegTE105104 setCPFAgTrib(String CPFAgTrib) {
        this.CPFAgTrib = CPFAgTrib;
        return this;
    }

    public String getnProcAdm() {
        return nProcAdm;
    }

    public NFSeSefinNacionalInfPedRegTE105104 setnProcAdm(String nProcAdm) {
        this.nProcAdm = nProcAdm;
        return this;
    }

    public String getcMotivo() {
        return cMotivo;
    }

    public NFSeSefinNacionalInfPedRegTE105104 setcMotivo(String cMotivo) {
        this.cMotivo = cMotivo;
        return this;
    }

    public String getxMotivo() {
        return xMotivo;
    }

    public NFSeSefinNacionalInfPedRegTE105104 setxMotivo(String xMotivo) {
        this.xMotivo = xMotivo;
        return this;
    }
}
