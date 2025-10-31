package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.Element;

public class NFSeSefinNacionalInfPedRegTE105105 extends NFSeSefinNacionalInfPedRegEventoTE{

    @Element(name = "CPFAgTrib")
    protected String cPFAgTrib;
    @Element(name = "nProcAdm", required = false)
    protected String nProcAdm;
    @Element(name = "cMotivo")
    protected NFSeSefinNacionalTSCodJustAnaliseFiscalCancIndef cMotivo;
    @Element(name = "xMotivo")
    protected String xMotivo;

    public NFSeSefinNacionalInfPedRegTE105105() {
        super("Cancelamento de NFS-e Indeferido por Análise Fiscal", "105105");
    }

    public String getcPFAgTrib() {
        return cPFAgTrib;
    }

    public NFSeSefinNacionalInfPedRegTE105105 setcPFAgTrib(String cPFAgTrib) {
        this.cPFAgTrib = cPFAgTrib;
        return this;
    }

    public String getnProcAdm() {
        return nProcAdm;
    }

    public NFSeSefinNacionalInfPedRegTE105105 setnProcAdm(String nProcAdm) {
        this.nProcAdm = nProcAdm;
        return this;
    }

    public NFSeSefinNacionalTSCodJustAnaliseFiscalCancIndef getcMotivo() {
        return cMotivo;
    }

    public NFSeSefinNacionalInfPedRegTE105105 setcMotivo(NFSeSefinNacionalTSCodJustAnaliseFiscalCancIndef cMotivo) {
        this.cMotivo = cMotivo;
        return this;
    }

    public String getxMotivo() {
        return xMotivo;
    }

    public NFSeSefinNacionalInfPedRegTE105105 setxMotivo(String xMotivo) {
        this.xMotivo = xMotivo;
        return this;
    }
}
