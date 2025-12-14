package com.fincatto.documentofiscal.nfe400.classes.evento.detevento;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEventoTipoAutor;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFTipoEvento;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

@Root(name = "detEvento")
public abstract class NFDetEvento extends NFTipoEvento {

    @Attribute(name = "versao")
    private String versao;

    @Element(name = "descEvento")
    private String descricaoEvento;

    @Element(name = "cOrgaoAutor")
    private DFUnidadeFederativa ufAutorEvento;

    @Element(name = "tpAutor")
    private NFEventoTipoAutor tipoAutor;

    @Element(name = "verAplic")
    private String versaoAplicativo;

    public void setVersao(final BigDecimal versao) {
        this.versao = DFBigDecimalValidador.tamanho5Com2CasasDecimais(versao, "Versao");
    }

    public void setDescricaoEvento(final String descricaoEvento) {
        DFStringValidador.tamanho2a85(descricaoEvento, "Descricao do Evento");
        this.descricaoEvento = descricaoEvento;
    }

    public String getDescricaoEvento() {
        return this.descricaoEvento;
    }

    public String getVersao() {
        return this.versao;
    }

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
