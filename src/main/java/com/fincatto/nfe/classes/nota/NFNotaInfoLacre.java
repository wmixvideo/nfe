package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoLacre extends NFBase {
    @Element(name = "nLacre", required = true)
    private String numeroLacres;

    public String getNumeroLacres() {
        return this.numeroLacres;
    }

    public void setNumeroLacres(final String numeroLacres) {
        this.numeroLacres = numeroLacres;
    }
}