package com.fincatto.documentofiscal.nfe400.classes.evento.aceitedebitoapuracao;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEventoTipoAutor;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFTipoEvento;
import org.simpleframework.xml.Element;

public class NFInfoAceiteDebitoApuracao extends NFTipoEvento {

    @Element(name = "cOrgaoAutor", required = false)
    private DFUnidadeFederativa ufEmitenteEvento;

    @Element(name = "tpAutor", required = false)
    private NFEventoTipoAutor tipoAutor;

    @Element(name = "verAplic", required = false)
    private String versaoAplicativo;

    @Element(name = "indAceitacao", required = false)
    private int indAceitacao;

    public DFUnidadeFederativa getUfEmitenteEvento() {
        return ufEmitenteEvento;
    }

    public void setUfEmitenteEvento(DFUnidadeFederativa ufEmitenteEvento) {
        this.ufEmitenteEvento = ufEmitenteEvento;
    }

    public void setTipoAutor(NFEventoTipoAutor tipoAutor) {
        this.tipoAutor = tipoAutor;
    }

    public NFEventoTipoAutor getTipoAutor() { return this.tipoAutor; }

    public String getVersaoAplicativo() {
        return this.versaoAplicativo;
    }

    public void setVersaoAplicativo(String versaoAplicativo) {
        this.versaoAplicativo = versaoAplicativo;
    }

    public int getIndAceitacao() { return this.indAceitacao; }

    public void setIndAceitacao(int indAceitacao) { this.indAceitacao = indAceitacao; }
}
