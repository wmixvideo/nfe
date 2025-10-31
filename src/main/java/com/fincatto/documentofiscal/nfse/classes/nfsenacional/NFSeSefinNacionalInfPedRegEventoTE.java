package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.Element;

public abstract class NFSeSefinNacionalInfPedRegEventoTE {

    @Element(name = "xDesc")
    private String xDesc;

    private String codigoEvento;

    public NFSeSefinNacionalInfPedRegEventoTE(String xDesc, String codigoEvento) {
        this.xDesc = xDesc;
        this.codigoEvento = codigoEvento;
    }

    public String getxDesc(){
        return this.xDesc;
    };

    public void setxDesc(String xDesc){
        this.xDesc = xDesc;
    };

    public String getCodigoEvento() {
        return codigoEvento;
    }

    public NFSeSefinNacionalInfPedRegEventoTE setCodigoEvento(String codigoEvento) {
        this.codigoEvento = codigoEvento;
        return this;
    }
}
