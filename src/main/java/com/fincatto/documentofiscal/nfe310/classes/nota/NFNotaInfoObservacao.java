package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

public class NFNotaInfoObservacao extends DFBase {
    private static final long serialVersionUID = 7420062278238333996L;
    
    @Attribute(name = "xCampo")
    private String identificacaoCampo;
    
    @Element(name = "xTexto")
    private String conteudoCampo;

    public void setIdentificacaoCampo(final String identificacaoCampo) {
        DFStringValidador.tamanho20(identificacaoCampo, "Identificacao Campo Obs");
        this.identificacaoCampo = identificacaoCampo;
    }

    public void setConteudoCampo(final String conteudoCampo) {
        DFStringValidador.tamanho60(conteudoCampo, "Conteudo Campo Obs");
        this.conteudoCampo = conteudoCampo;
    }

    public String getConteudoCampo() {
        return this.conteudoCampo;
    }

    public String getIdentificacaoCampo() {
        return this.identificacaoCampo;
    }
}