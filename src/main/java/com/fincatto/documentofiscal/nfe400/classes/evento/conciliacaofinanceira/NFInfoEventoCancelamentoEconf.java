package com.fincatto.documentofiscal.nfe400.classes.evento.conciliacaofinanceira;

import org.simpleframework.xml.Element;

public class NFInfoEventoCancelamentoEconf extends AbstractNFInfoEventoEconf {
    private static final long serialVersionUID = 6104827395518264073L;

    @Element(name = "detEvento")
    private NFDetEventoCancelamentoEconf detalhesEvento;

    public NFDetEventoCancelamentoEconf getDetalhesEvento() {
        return this.detalhesEvento;
    }

    public void setDetalhesEvento(final NFDetEventoCancelamentoEconf detalhesEvento) {
        this.detalhesEvento = detalhesEvento;
    }
}
