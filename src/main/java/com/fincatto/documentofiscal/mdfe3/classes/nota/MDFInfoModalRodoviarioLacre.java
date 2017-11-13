package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.validadores.StringValidador;
import org.simpleframework.xml.Element;

public class MDFInfoModalRodoviarioLacre {

    /**
     * Número do Lacre
     */
    @Element(name = "nLacre")
    private String numeroDoLacre;

    public String getNumeroDoLacre() {
        return numeroDoLacre;
    }

    public void setNumeroDoLacre(String numeroDoLacre) {
        StringValidador.validaIntervalo(numeroDoLacre, 1, 20, "numero do lacre");
        this.numeroDoLacre = numeroDoLacre;
    }
}