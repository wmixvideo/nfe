package com.fincatto.nfe310.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.classes.NFOrigemProcesso;
import com.fincatto.nfe310.validadores.StringValidador;

public class NFNotaInfoProcessoReferenciado extends NFBase {

    @Element(name = "nProc", required = true)
    private String identificadorProcessoOuAtoConcessorio;

    @Element(name = "indProc", required = true)
    private NFOrigemProcesso indicadorOrigemProcesso;

    public void setIdentificadorProcessoOuAtoConcessorio(final String identificadorProcessoOuAtoConcessorio) {
        StringValidador.tamanho60(identificadorProcessoOuAtoConcessorio);
        this.identificadorProcessoOuAtoConcessorio = identificadorProcessoOuAtoConcessorio;
    }

    public void setIndicadorOrigemProcesso(final NFOrigemProcesso indicadorOrigemProcesso) {
        this.indicadorOrigemProcesso = indicadorOrigemProcesso;
    }

    public String getIdentificadorProcessoOuAtoConcessorio() {
        return this.identificadorProcessoOuAtoConcessorio;
    }

    public NFOrigemProcesso getIndicadorOrigemProcesso() {
        return this.indicadorOrigemProcesso;
    }
}