package com.fincatto.documentofiscal.nfe400.classes.evento.apropriacaocredito;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEventoRetorno;
import com.fincatto.documentofiscal.nfe400.classes.evento.apropriacaocomb.NFEventoSolicitacaoApropriacaoCreditoCombustivel;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "procEventoNFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFProtocoloEventoSolicitacaoApropriacaoCreditoPresumido extends DFBase {

    @Attribute(name = "versao")
    private String versao;

    @Element(name = "evento")
    private NFEventoSolicitacaoApropriacaoCreditoPresumido evento;

    @Element(name = "retEvento")
    private NFEventoRetorno eventoRetorno;

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public NFEventoSolicitacaoApropriacaoCreditoPresumido getEvento() {
        return evento;
    }

    public void setEvento(NFEventoSolicitacaoApropriacaoCreditoPresumido evento) {
        this.evento = evento;
    }

    public NFEventoRetorno getEventoRetorno() {
        return eventoRetorno;
    }

    public void setEventoRetorno(NFEventoRetorno eventoRetorno) {
        this.eventoRetorno = eventoRetorno;
    }

}
