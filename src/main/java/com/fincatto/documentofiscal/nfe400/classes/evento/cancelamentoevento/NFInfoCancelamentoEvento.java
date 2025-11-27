package com.fincatto.documentofiscal.nfe400.classes.evento.cancelamentoevento;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFTipoEvento;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;

public class NFInfoCancelamentoEvento extends NFTipoEvento {

    @Element(name = "cOrgaoAutor", required = false)
    private DFUnidadeFederativa ufEmitenteEvento;

    @Element(name = "verAplic", required = false)
    private String versaoAplicativo;

    @Element(name = "tpEventoAut")
    private String tipoEventoAutorizado;

    @Element(name = "nProtEvento")
    private String numeroProtocoloEvento;

    public DFUnidadeFederativa getUfEmitenteEvento() {
        return this.ufEmitenteEvento;
    }

    public void setUfEmitenteEvento(DFUnidadeFederativa ufEmitenteEvento) {
        this.ufEmitenteEvento = ufEmitenteEvento;
    }

    public String getVersaoAplicativo() {
        return this.versaoAplicativo;
    }

    public void setVersaoAplicativo(String versaoAplicativo) {
        this.versaoAplicativo = versaoAplicativo;
    }

    public String getNumeroProtocoloEvento() { return this.numeroProtocoloEvento; }

    public void setNumeroProtocoloEvento(String numeroProtocoloEvento) {
        DFStringValidador.tamanho15ou17N(numeroProtocoloEvento, "Protocolo de Autorizacao");
        this.numeroProtocoloEvento = numeroProtocoloEvento;
    }

    public String getTipoEventoAutorizado() { return this.tipoEventoAutorizado; }

    public void setTipoEventoAutorizado(String tipoEventoAutorizado) { this.tipoEventoAutorizado = tipoEventoAutorizado; }

}
