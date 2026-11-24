package com.fincatto.documentofiscal.nfe400.classes.evento.conciliacaofinanceira;

import org.simpleframework.xml.Element;

public class NFInfoEventoEconf extends AbstractNFInfoEventoEconf {
    private static final long serialVersionUID = 1936402857713840026L;

    @Element(name = "detEvento")
    private NFDetEventoEconf detalhesEvento;

    public NFDetEventoEconf getDetalhesEvento() {
        return this.detalhesEvento;
    }

    public void setDetalhesEvento(final NFDetEventoEconf detalhesEvento) {
        this.detalhesEvento = detalhesEvento;
    }
}
