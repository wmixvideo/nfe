package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.Element;

public class NFSeSefinNacionalTCInfoEventoAnulacaoRejeicao {
    @Element(name = "CPFAgTrib")
    protected String cPFAgTrib;
    @Element(name = "idEvManifRej")
    protected String idEvManifRej;
    @Element(name = "xMotivo")
    protected String xMotivo;

    public String getcPFAgTrib() {
        return cPFAgTrib;
    }

    public NFSeSefinNacionalTCInfoEventoAnulacaoRejeicao setcPFAgTrib(String cPFAgTrib) {
        this.cPFAgTrib = cPFAgTrib;
        return this;
    }

    public String getIdEvManifRej() {
        return idEvManifRej;
    }

    public NFSeSefinNacionalTCInfoEventoAnulacaoRejeicao setIdEvManifRej(String idEvManifRej) {
        this.idEvManifRej = idEvManifRej;
        return this;
    }

    public String getxMotivo() {
        return xMotivo;
    }

    public NFSeSefinNacionalTCInfoEventoAnulacaoRejeicao setxMotivo(String xMotivo) {
        this.xMotivo = xMotivo;
        return this;
    }
}
