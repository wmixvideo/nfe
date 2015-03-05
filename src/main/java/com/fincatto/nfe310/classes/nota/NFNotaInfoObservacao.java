package com.fincatto.nfe310.classes.nota;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.validadores.StringValidador;

public class NFNotaInfoObservacao extends NFBase {
    @Attribute(name = "xCampo", required = true)
    private String identificacaoCampo;

    @Element(name = "xTexto", required = true)
    private String conteudoCampo;

    public void setIdentificacaoCampo(final String identificacaoCampo) {
        StringValidador.tamanho20(identificacaoCampo);
        this.identificacaoCampo = identificacaoCampo;
    }

    public void setConteudoCampo(final String conteudoCampo) {
        StringValidador.tamanho60(conteudoCampo);
        this.conteudoCampo = conteudoCampo;
    }

    public String getConteudoCampo() {
        return this.conteudoCampo;
    }

    public String getIdentificacaoCampo() {
        return this.identificacaoCampo;
    }
}