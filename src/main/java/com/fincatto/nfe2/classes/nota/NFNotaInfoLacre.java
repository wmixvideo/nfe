package com.fincatto.nfe2.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe2.classes.NFBase;
import com.fincatto.nfe2.validadores.StringValidador;

public class NFNotaInfoLacre extends NFBase {
    @Element(name = "nLacre", required = true)
    private String numeroLacres;

    public void setNumeroLacre(final String numeroLacres) {
        StringValidador.tamanho60(numeroLacres);
        this.numeroLacres = numeroLacres;
    }
}