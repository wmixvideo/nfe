package com.fincatto.documentofiscal.nfe310.classes.evento.cartacorrecao;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe310.classes.evento.NFEvento;
import com.fincatto.documentofiscal.nfe310.classes.evento.NFEventoRetorno;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "procEventoNFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFProtocoloEventoCartaCorrecao extends DFBase {
    private static final long serialVersionUID = 5835358558255982305L;
    
    @Attribute(name = "versao")
    private String versao;
    
    @Element(name = "evento")
    private NFEvento evento;
    
    @Element(name = "retEvento")
    private NFEventoRetorno eventoRetorno;

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final String versao) {
        this.versao = versao;
    }

    public NFEvento getEvento() {
        return this.evento;
    }

    public void setEvento(final NFEvento evento) {
        this.evento = evento;
    }

    public NFEventoRetorno getEventoRetorno() {
        return this.eventoRetorno;
    }

    public void setEventoRetorno(final NFEventoRetorno eventoRetorno) {
        this.eventoRetorno = eventoRetorno;
    }

}