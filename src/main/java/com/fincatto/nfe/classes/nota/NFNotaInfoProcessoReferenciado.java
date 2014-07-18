package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoProcessoReferenciado extends NFBase {

    @Element(name = "nProc", required = true)
    private String indentificadorProcessoOuAtoCOncessorio;

    @Element(name = "indProc", required = true)
    private NFOrigemProcesso indicadorOrigemProcesso;

    public String getIndentificadorProcessoOuAtoCOncessorio() {
        return this.indentificadorProcessoOuAtoCOncessorio;
    }

    public void setIndentificadorProcessoOuAtoCOncessorio(final String indentificadorProcessoOuAtoCOncessorio) {
        this.indentificadorProcessoOuAtoCOncessorio = indentificadorProcessoOuAtoCOncessorio;
    }

    public NFOrigemProcesso getIndicadorOrigemProcesso() {
        return this.indicadorOrigemProcesso;
    }

    public void setIndicadorOrigemProcesso(final NFOrigemProcesso indicadorOrigemProcesso) {
        this.indicadorOrigemProcesso = indicadorOrigemProcesso;
    }
}