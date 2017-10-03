package com.fincatto.documentofiscal.cte200.classes.cte;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;

@Root(name = "ObsFisco")
public class CTInfoObservacaoFisco extends DFBase {
    private static final long serialVersionUID = -1816423666185748482L;

    @Attribute(name = "xCampo")
    private String identificador;

    @Element(name = "xTexto")
    private String conteudo;

    public String getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(final String identificador) {
        this.identificador = identificador;
    }

    public String getConteudo() {
        return this.conteudo;
    }

    public void setConteudo(final String conteudo) {
        this.conteudo = conteudo;
    }

}
