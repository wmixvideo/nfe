package com.fincatto.documentofiscal.cte200.classes.cte;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;

public class CTInfoImpostoICMS extends DFBase {
    private static final long serialVersionUID = -4360892061626122758L;

    @Element(name = "ICMS00", required = false)
    private CTInfoImpostoICMS00 icms00;

    @Element(name = "ICMS20", required = false)
    private CTInfoImpostoICMS20 icms20;

    @Element(name = "ICMS45", required = false)
    private CTInfoImpostoICMS45 icms45;

    @Element(name = "ICMS60", required = false)
    private CTInfoImpostoICMS60 icms60;

    @Element(name = "ICMS90", required = false)
    private CTInfoImpostoICMS90 icms90;

    @Element(name = "ICMSOutraUF", required = false)
    private CTInfoImpostoICMSOutraUF icmsOutraUF;

    @Element(name = "ICMSSN", required = false)
    private CTInfoImpostoICMSSimplesNacional icmsSimplesNacional;

    public CTInfoImpostoICMS00 getIcms00() {
        return this.icms00;
    }

    public void setIcms00(final CTInfoImpostoICMS00 icms00) {
        this.icms00 = icms00;
    }

    public CTInfoImpostoICMS20 getIcms20() {
        return this.icms20;
    }

    public void setIcms20(final CTInfoImpostoICMS20 icms20) {
        this.icms20 = icms20;
    }

    public CTInfoImpostoICMS45 getIcms45() {
        return this.icms45;
    }

    public void setIcms45(final CTInfoImpostoICMS45 icms45) {
        this.icms45 = icms45;
    }

    public CTInfoImpostoICMS60 getIcms60() {
        return this.icms60;
    }

    public void setIcms60(final CTInfoImpostoICMS60 icms60) {
        this.icms60 = icms60;
    }

    public CTInfoImpostoICMS90 getIcms90() {
        return this.icms90;
    }

    public void setIcms90(final CTInfoImpostoICMS90 icms90) {
        this.icms90 = icms90;
    }

    public CTInfoImpostoICMSOutraUF getIcmsOutraUF() {
        return this.icmsOutraUF;
    }

    public void setIcmsOutraUF(final CTInfoImpostoICMSOutraUF icmsOutraUF) {
        this.icmsOutraUF = icmsOutraUF;
    }

    public CTInfoImpostoICMSSimplesNacional getIcmsSimplesNacional() {
        return this.icmsSimplesNacional;
    }

    public void setIcmsSimplesNacional(final CTInfoImpostoICMSSimplesNacional icmsSimplesNacional) {
        this.icmsSimplesNacional = icmsSimplesNacional;
    }

}