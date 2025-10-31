package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.Element;

public class NFSeSefinNacionalInfPedRegTE305103 extends NFSeSefinNacionalInfPedRegEventoTE{
    @Element(name = "CPFAgTrib")
    protected String cPFAgTrib;
    @Element(name = "idBloqOfic")
    protected String idBloqOfic;

    public NFSeSefinNacionalInfPedRegTE305103() {
        super("Desbloqueio de NFS-e por Ofício", "305103");
    }

    public String getcPFAgTrib() {
        return cPFAgTrib;
    }

    public NFSeSefinNacionalInfPedRegTE305103 setcPFAgTrib(String cPFAgTrib) {
        this.cPFAgTrib = cPFAgTrib;
        return this;
    }

    public String getIdBloqOfic() {
        return idBloqOfic;
    }

    public NFSeSefinNacionalInfPedRegTE305103 setIdBloqOfic(String idBloqOfic) {
        this.idBloqOfic = idBloqOfic;
        return this;
    }
}
