package com.fincatto.nfe.core.nota;

import com.fincatto.nfe.core.NFBase;
import com.fincatto.nfe.core.NFOrigemProcesso;
import com.fincatto.nfe.core.validadores.StringValidador;
import org.simpleframework.xml.Element;

public class NFNotaInfoProcessoReferenciado extends NFBase {

    @Element(name = "nProc", required = true)
    private String identificadorProcessoOuAtoConcessorio;

    @Element(name = "indProc", required = true)
    private NFOrigemProcesso indicadorOrigemProcesso;

    public void setIdentificadorProcessoOuAtoConcessorio(final String identificadorProcessoOuAtoConcessorio) {
        StringValidador.tamanho60(identificadorProcessoOuAtoConcessorio, "Identificador Processo Ou Ato Concessorio Processo Referenciado");
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