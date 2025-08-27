package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Campo de uso livre do contribuinte
 */

@Root(name = "ObsFisco")
public class CTeNotaInfoDadosComplementaresObservacaoFisco extends DFBase {
    private static final long serialVersionUID = 3201619138594155180L;

    @Attribute(name = "xCampo")
    private String campo;
    
    @Element(name = "xTexto")
    private String texto;

    public String getCampo() {
        return this.campo;
    }

    /**
     * Identificação do campo
     */
    public void setCampo(final String campo) {
        DFStringValidador.tamanho20(campo, "Identificação do campo");
        this.campo = campo;
    }

    public String getTexto() {
        return this.texto;
    }

    /**
     * Identificação do texto
     */
    public void setTexto(final String texto) {
        DFStringValidador.tamanho60(texto, "Identificação do texto");
        this.texto = texto;
    }
}
