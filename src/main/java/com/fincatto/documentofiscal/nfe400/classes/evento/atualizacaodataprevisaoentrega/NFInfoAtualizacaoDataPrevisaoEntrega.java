package com.fincatto.documentofiscal.nfe400.classes.evento.atualizacaodataprevisaoentrega;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFInfoAtualizacaoDataPrevisaoEntrega extends DFBase {

    @Attribute(name = "versao")
    private String versao;

    @Element(name = "descEvento")
    private String descricaoEvento;

    @Element(name = "cOrgaoAutor")
    private DFUnidadeFederativa codigoOrgaoAutorEvento;

    @Element(name = "tpAutor")
    private Integer codigoAutorEvento;

    @Element(name = "verAplic")
    private String versaoAplicativoAutorEvento;

    public String getVersao() {
        return versao;
    }

    public void setVersao(final BigDecimal versao) {
        this.versao = DFBigDecimalValidador.tamanho5Com2CasasDecimais(versao, "Versao");
    }

    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public DFUnidadeFederativa getOrgao() {
        return this.codigoOrgaoAutorEvento;
    }

    public void setOrgao(final DFUnidadeFederativa orgao) {
        this.codigoOrgaoAutorEvento = orgao;
    }

    public Integer getCodigoAutorEvento() {
        return codigoAutorEvento;
    }

    public void setCodigoAutorEvento(Integer codigoAutorEvento) {
        this.codigoAutorEvento = codigoAutorEvento;
    }

    public String getVersaoAplicativoAutorEvento() {
        return versaoAplicativoAutorEvento;
    }

    public void setVersaoAplicativoAutorEvento(String versaoAplicativoAutorEvento) {
        this.versaoAplicativoAutorEvento = versaoAplicativoAutorEvento;
    }

}
