package com.fincatto.documentofiscal.nfe400.classes.evento.atualizacaodataprevisaoentrega;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEventoTipoAutor;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFTipoEvento;
import org.simpleframework.xml.Element;

import java.time.LocalDate;

public class NFInfoAtualizacaoDataPrevisaoEntrega extends NFTipoEvento {

    @Element(name = "cOrgaoAutor", required = false)
    private DFUnidadeFederativa ufAutorEvento;

    @Element(name = "tpAutor", required = false)
    private NFEventoTipoAutor tipoAutor;

    @Element(name = "verAplic", required = false)
    private String versaoAplicativo;

    @Element(name = "dPrevEntrega", required = false)
    private LocalDate dataPrevisaoEntrega;

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

    public LocalDate getDataPrevisaoEntrega() { return dataPrevisaoEntrega; };

    public void setDataPrevisaoEntrega(LocalDate dataPrevisaoEntrega) { this.dataPrevisaoEntrega = dataPrevisaoEntrega; };
}
