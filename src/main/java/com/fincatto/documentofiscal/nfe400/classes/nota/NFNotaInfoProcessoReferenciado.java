package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigemProcesso;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;

public class NFNotaInfoProcessoReferenciado extends DFBase {
    private static final long serialVersionUID = -5213086059996742347L;
    
    @Element(name = "nProc")
    private String identificadorProcessoOuAtoConcessorio;
    
    @Element(name = "indProc")
    private NFOrigemProcesso indicadorOrigemProcesso;

    public void setIdentificadorProcessoOuAtoConcessorio(final String identificadorProcessoOuAtoConcessorio) {
        DFStringValidador.tamanho60(identificadorProcessoOuAtoConcessorio, "Identificador Processo Ou Ato Concessorio Processo Referenciado");
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