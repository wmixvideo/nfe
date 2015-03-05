package com.fincatto.nfe200.classes.nota.consulta;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import com.fincatto.nfe200.classes.NFBase;
import com.fincatto.nfe200.classes.evento.NFEventoRetorno;
import com.fincatto.nfe200.classes.evento.cartacorrecao.NFEventoCartaCorrecao;

public class NFProtocoloEvento extends NFBase {

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "evento", required = true)
    private NFEventoCartaCorrecao eventoCartaCorrecao;

    @Element(name = "retEvento", required = true)
    private NFEventoRetorno eventoRetorno;

    public NFEventoCartaCorrecao getEventoCartaCorrecao() {
        return this.eventoCartaCorrecao;
    }

    public void setEventoCartaCorrecao(final NFEventoCartaCorrecao eventoCartaCorrecao) {
        this.eventoCartaCorrecao = eventoCartaCorrecao;
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