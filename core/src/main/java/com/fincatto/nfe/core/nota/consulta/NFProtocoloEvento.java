package com.fincatto.nfe.core.nota.consulta;

import com.fincatto.nfe.core.NFBase;
import com.fincatto.nfe.core.evento.NFEvento;
import com.fincatto.nfe.core.evento.NFEventoRetorno;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

public class NFProtocoloEvento extends NFBase {

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "evento", required = true)
    private NFEvento evento;

    @Element(name = "retEvento", required = true)
    private NFEventoRetorno eventoRetorno;

    public NFEvento getEvento() {
        return this.evento;
    }

    public void setEvento(final NFEvento evento) {
        this.evento = evento;
    }

    public NFEventoRetorno getInfoEventoRetorno() {
        return this.eventoRetorno;
    }

    public void setEventoRetorno(final NFEventoRetorno infoEventoRetorno) {
        this.eventoRetorno = infoEventoRetorno;
    }

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final String versao) {
        this.versao = versao;
    }
}