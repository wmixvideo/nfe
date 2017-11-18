package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.validadores.StringValidador;
import org.simpleframework.xml.Element;

/**
 * Numero lacre de 1 a 20 caracteres.
 */
public class MDFInfoLacre1A20 {

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