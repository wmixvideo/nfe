package com.fincatto.nfe.core.nota;

import com.fincatto.nfe.core.NFBase;
import com.fincatto.nfe.core.validadores.StringValidador;
import org.simpleframework.xml.Element;

public class NFNotaInfoLacre extends NFBase {
    @Element(name = "nLacre", required = true)
    private String numeroLacres;

    public void setNumeroLacre(final String numeroLacres) {
        StringValidador.tamanho60(numeroLacres, "Numero Lacre");
        this.numeroLacres = numeroLacres;
    }

    public String getNumeroLacres() {
        return this.numeroLacres;
    }
}