package com.fincatto.nfe200.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe200.classes.NFBase;
import com.fincatto.nfe200.validadores.StringValidador;

public class NFNotaInfoLacre extends NFBase {
    @Element(name = "nLacre", required = true)
    private String numeroLacres;

    public void setNumeroLacre(final String numeroLacres) {
        StringValidador.tamanho60(numeroLacres);
        this.numeroLacres = numeroLacres;
    }

    public String getNumeroLacres() {
        return this.numeroLacres;
    }
}