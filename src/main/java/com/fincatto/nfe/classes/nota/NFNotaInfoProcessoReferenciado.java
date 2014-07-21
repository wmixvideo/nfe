package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoProcessoReferenciado extends NFBase {

    @Element(name = "nProc", required = true)
    private String identificadorProcessoOuAtoConcessorio;

    @Element(name = "indProc", required = true)
    private NFOrigemProcesso indicadorOrigemProcesso;

    public String getIdentificadorProcessoOuAtoConcessorio() {
        return this.identificadorProcessoOuAtoConcessorio;
    }

    public void setIdentificadorProcessoOuAtoConcessorio(final String identificadorProcessoOuAtoConcessorio) {
        if (identificadorProcessoOuAtoConcessorio.length() < 1 || identificadorProcessoOuAtoConcessorio.length() > 60) {
            throw new IllegalStateException("Identificador processo ou ato concessorio deve ter entre 1-60 caracteres");
        }
        this.identificadorProcessoOuAtoConcessorio = identificadorProcessoOuAtoConcessorio;
    }

    public NFOrigemProcesso getIndicadorOrigemProcesso() {
        return this.indicadorOrigemProcesso;
    }

    public void setIndicadorOrigemProcesso(final NFOrigemProcesso indicadorOrigemProcesso) {
        this.indicadorOrigemProcesso = indicadorOrigemProcesso;
    }
}