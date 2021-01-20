package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;

public class NFNotaInfoLacre extends DFBase {
    private static final long serialVersionUID = -5184684979849337146L;
    
    @Element(name = "nLacre")
    private String numeroLacres;

    public void setNumeroLacre(final String numeroLacres) {
        DFStringValidador.tamanho60(numeroLacres, "Numero Lacre");
        this.numeroLacres = numeroLacres;
    }

    public String getNumeroLacres() {
        return this.numeroLacres;
    }
}