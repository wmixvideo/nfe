package com.fincatto.nfe310.classes.evento;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import com.fincatto.nfe310.classes.NFAmbiente;
import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;

@Root(name = "retEnvEvento")
public class NFEnviaEventoRetorno extends NFBase {

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "idLote", required = true)
    private String idLote;

    @Element(name = "tpAmb", required = true)
    private NFAmbiente ambiente;

    @Element(name = "verAplic", required = true)
    private String versaoAplicativo;

    @Element(name = "cOrgao", required = true)
    private NFUnidadeFederativa orgao;

    @Element(name = "cStat", required = true)
    private Integer codigoStatusReposta;

    @Element(name = "xMotivo", required = true)
    private String motivo;

    @ElementList(entry = "retEvento", inline = true, required = true)
    private List<NFEventoRetorno> eventoRetorno;

    public String getVersao() {
        return this.versao;
    }

    public String getIdLote() {
        return this.idLote;
    }

    public NFAmbiente getAmbiente() {
        return this.ambiente;
    }

    public String getVersaoAplicativo() {
        return this.versaoAplicativo;
    }

    public NFUnidadeFederativa getOrgao() {
        return this.orgao;
    }

    public Integer getCodigoStatusReposta() {
        return this.codigoStatusReposta;
    }

    public String getMotivo() {
        return this.motivo;
    }

    public List<NFEventoRetorno> getEventoRetorno() {
        return this.eventoRetorno;
    }

    public void setVersao(final String versao) {
        this.versao = versao;
    }

    public void setIdLote(final String idLote) {
        this.idLote = idLote;
    }

    public void setAmbiente(final NFAmbiente ambiente) {
        this.ambiente = ambiente;
    }

    public void setVersaoAplicativo(final String versaoAplicativo) {
        this.versaoAplicativo = versaoAplicativo;
    }

    public void setOrgao(final NFUnidadeFederativa orgao) {
        this.orgao = orgao;
    }

    public void setCodigoStatusReposta(final Integer codigoStatusReposta) {
        this.codigoStatusReposta = codigoStatusReposta;
    }

    public void setMotivo(final String motivo) {
        this.motivo = motivo;
    }

    public void setEventoRetorno(final List<NFEventoRetorno> eventoRetorno) {
        this.eventoRetorno = eventoRetorno;
    }
}