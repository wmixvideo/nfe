package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.Element;

public class NFSeSefinNacionalTCInfoEventoRejeicao {
    @Element(name = "cMotivo")
    protected NFSeSefinNacionalTSCodMotivoRejeicao cMotivo;
    @Element(name = "xMotivo", required = false)
    protected String xMotivo;

    public NFSeSefinNacionalTSCodMotivoRejeicao getcMotivo() {
        return cMotivo;
    }

    public NFSeSefinNacionalTCInfoEventoRejeicao setcMotivo(NFSeSefinNacionalTSCodMotivoRejeicao cMotivo) {
        this.cMotivo = cMotivo;
        return this;
    }

    public String getxMotivo() {
        return xMotivo;
    }

    public NFSeSefinNacionalTCInfoEventoRejeicao setxMotivo(String xMotivo) {
        this.xMotivo = xMotivo;
        return this;
    }
}
