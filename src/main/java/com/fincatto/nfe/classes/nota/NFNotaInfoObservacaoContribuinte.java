package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoObservacaoContribuinte extends NFBase {
    @Attribute(name = "xCampo", required = true)
    private String identificacaoCampo;

    @Element(name = "xTexto", required = true)
    private String conteudoCampo;

    public String getIdentificacaoCampo() {
        return this.identificacaoCampo;
    }

    public void setIdentificacaoCampo(final String identificacaoCampo) {
        this.identificacaoCampo = identificacaoCampo;
    }

    public String getConteudoCampo() {
        return this.conteudoCampo;
    }

    public void setConteudoCampo(final String conteudoCampo) {
        this.conteudoCampo = conteudoCampo;
    }
}