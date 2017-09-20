package com.fincatto.documentofiscal.cte200.classes.cte;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;

public class CTInfoImposto extends DFBase {

    @Element(name = "ICMS")
    private CTInfoImpostoICMS icms;

    @Element(name = "vTotTrib", required = false)
    private String vTotTrib;

    @Element(name = "infAdFisco", required = false)
    private String infAdFisco;

    public CTInfoImpostoICMS getIcms() {
        return this.icms;
    }

    public void setIcms(final CTInfoImpostoICMS icms) {
        this.icms = icms;
    }

    public String getvTotTrib() {
        return this.vTotTrib;
    }

    public void setvTotTrib(final String vTotTrib) {
        this.vTotTrib = vTotTrib;
    }

    public String getInfAdFisco() {
        return this.infAdFisco;
    }

    public void setInfAdFisco(final String infAdFisco) {
        this.infAdFisco = infAdFisco;
    }

}
