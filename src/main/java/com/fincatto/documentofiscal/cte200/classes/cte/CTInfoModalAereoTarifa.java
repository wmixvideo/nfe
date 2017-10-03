package com.fincatto.documentofiscal.cte200.classes.cte;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;

public class CTInfoModalAereoTarifa extends DFBase {
    private static final long serialVersionUID = -1315294836315267992L;

    @Element(name = "CL")
    private String classe;

    @Element(name = "cTar", required = false)
    private String codigoTarifa;

    @Element(name = "vTar")
    private String valorTarifa;

    public String getClasse() {
        return this.classe;
    }

    public void setClasse(final String classe) {
        this.classe = classe;
    }

    public String getCodigoTarifa() {
        return this.codigoTarifa;
    }

    public void setCodigoTarifa(final String codigoTarifa) {
        this.codigoTarifa = codigoTarifa;
    }

    public String getValorTarifa() {
        return this.valorTarifa;
    }

    public void setValorTarifa(final String valorTarifa) {
        this.valorTarifa = valorTarifa;
    }

}
