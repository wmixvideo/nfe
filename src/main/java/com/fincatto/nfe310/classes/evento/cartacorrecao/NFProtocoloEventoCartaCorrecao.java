package com.fincatto.nfe310.classes.evento.cartacorrecao;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.classes.evento.NFEvento;
import com.fincatto.nfe310.classes.evento.NFEventoRetorno;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "procEventoNFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFProtocoloEventoCartaCorrecao extends NFBase{
    
    @Attribute(name = "versao", required = true)
    private String versao;
    
    @Element(name = "evento", required = true)
    private NFEvento evento;
    
    @Element(name = "retEvento", required = true)
    private NFEventoRetorno eventoRetorno;

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public NFEvento getEvento() {
        return evento;
    }

    public void setEvento(NFEvento evento) {
        this.evento = evento;
    }

    public NFEventoRetorno getEventoRetorno() {
        return eventoRetorno;
    }

    public void setEventoRetorno(NFEventoRetorno eventoRetorno) {
        this.eventoRetorno = eventoRetorno;
    }
    
}