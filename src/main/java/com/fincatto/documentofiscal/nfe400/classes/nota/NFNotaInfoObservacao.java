package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;

public class NFNotaInfoObservacao extends DFBase {
    private static final long serialVersionUID = 7420062278238333996L;

    @Attribute(name = "xCampo", required = true)
    private String identificacaoCampo;

    @Element(name = "xTexto", required = true)
    private String conteudoCampo;

    public void setIdentificacaoCampo(final String identificacaoCampo) {
        StringValidador.tamanho20(identificacaoCampo, "Identificacao Campo Obs");
        this.identificacaoCampo = identificacaoCampo;
    }

    public void setConteudoCampo(final String conteudoCampo) {
        StringValidador.tamanho60(conteudoCampo, "Conteudo Campo Obs");
        this.conteudoCampo = conteudoCampo;
    }

    public String getConteudoCampo() {
        return this.conteudoCampo;
    }

    public String getIdentificacaoCampo() {
        return this.identificacaoCampo;
    }
}