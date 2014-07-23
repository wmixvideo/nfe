package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.validadores.StringValidador;

public class NFNotaInfoLacre extends NFBase {
    @Element(name = "nLacre", required = true)
    private String numeroLacres;

    public String getNumeroLacres() {
        return this.numeroLacres;
    }

    public void setNumeroLacre(final String numeroLacres) {
        StringValidador.tamanho60(numeroLacres);
        this.numeroLacres = numeroLacres;
    }
}