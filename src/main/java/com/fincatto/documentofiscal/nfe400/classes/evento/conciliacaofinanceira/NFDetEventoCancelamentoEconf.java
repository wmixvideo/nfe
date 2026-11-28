package com.fincatto.documentofiscal.nfe400.classes.evento.conciliacaofinanceira;

import com.fincatto.documentofiscal.nfe400.classes.evento.NFTipoEvento;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "detEvento")
public class NFDetEventoCancelamentoEconf extends NFTipoEvento {
    private static final long serialVersionUID = 3948261705583172946L;

    @Element(name = "verAplic")
    private String versaoAplicativo;

    @Element(name = "nProtEvento")
    private String numeroProtocoloEvento;

    public String getVersaoAplicativo() {
        return this.versaoAplicativo;
    }

    public void setVersaoAplicativo(final String versaoAplicativo) {
        DFStringValidador.tamanho20(versaoAplicativo, "Versao Aplicativo");
        this.versaoAplicativo = versaoAplicativo;
    }

    public String getNumeroProtocoloEvento() {
        return this.numeroProtocoloEvento;
    }

    public void setNumeroProtocoloEvento(final String numeroProtocoloEvento) {
        DFStringValidador.exatamente15N(numeroProtocoloEvento, "Numero Protocolo Evento");
        this.numeroProtocoloEvento = numeroProtocoloEvento;
    }
}
