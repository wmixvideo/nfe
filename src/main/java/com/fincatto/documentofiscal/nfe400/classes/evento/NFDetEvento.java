package com.fincatto.documentofiscal.nfe400.classes.evento;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "detEvento")
public abstract class NFDetEvento extends NFTipoEvento {

    @Element(name = "cOrgaoAutor")
    private DFUnidadeFederativa ufAutorEvento;

    @Element(name = "tpAutor")
    private NFEventoTipoAutor tipoAutor;

    @Element(name = "verAplic")
    private String versaoAplicativo;

    public DFUnidadeFederativa getUfAutorEvento() {
        return ufAutorEvento;
    }

    public void setUfAutorEvento(DFUnidadeFederativa ufAutorEvento) {
        this.ufAutorEvento = ufAutorEvento;
    }

    public NFEventoTipoAutor getTipoAutor() {
        return tipoAutor;
    }

    public void setTipoAutor(NFEventoTipoAutor tipoAutor) {
        this.tipoAutor = tipoAutor;
    }

    public String getVersaoAplicativo() {
        return versaoAplicativo;
    }

    public void setVersaoAplicativo(String versaoAplicativo) {
        this.versaoAplicativo = versaoAplicativo;
    }
}
