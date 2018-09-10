package com.fincatto.documentofiscal.mdfe3.classes.nota.evento;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;

public class MDFeRetorno extends DFBase {
    private static final long serialVersionUID = -3320099037774115533L;

    @Attribute(name = "versao", required = false)
    private String versao;

    @Element(name = "infEvento")
    private MDFeInfoEventoRetorno eventoRetorno;

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final String versao) {
        this.versao = versao;
    }

    public MDFeInfoEventoRetorno getEventoRetorno() {
        return this.eventoRetorno;
    }

    public void setEventoRetorno(final MDFeInfoEventoRetorno eventoRetorno) {
        this.eventoRetorno = eventoRetorno;
    }
}