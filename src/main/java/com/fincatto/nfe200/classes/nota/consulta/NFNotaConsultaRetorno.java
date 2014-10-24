package com.fincatto.nfe200.classes.nota.consulta;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.nfe200.classes.NFAmbiente;
import com.fincatto.nfe200.classes.NFBase;
import com.fincatto.nfe200.classes.NFProtocolo;
import com.fincatto.nfe200.classes.NFUnidadeFederativa;

@Root(name = "retConsSitNFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFNotaConsultaRetorno extends NFBase {

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "tpAmb", required = true)
    private NFAmbiente ambiente;

    @Element(name = "verAplic", required = true)
    private String versaoAplicacao;

    @Element(name = "cStat", required = true)
    private String status;

    @Element(name = "xMotivo", required = true)
    private String motivo;

    @Element(name = "cUF", required = true)
    private NFUnidadeFederativa uf;

    @Element(name = "chNFe", required = true)
    private String chave;

    @Element(name = "protNFe", required = false)
    protected NFProtocolo protocolo;

    public NFNotaConsultaRetorno() {
        this.versao = null;
        this.ambiente = null;
        this.versaoAplicacao = null;
        this.status = null;
        this.motivo = null;
        this.uf = null;
        this.chave = null;
        this.protocolo = null;
    }

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final String versao) {
        this.versao = versao;
    }

    public NFAmbiente getAmbiente() {
        return this.ambiente;
    }

    public void setAmbiente(final NFAmbiente ambiente) {
        this.ambiente = ambiente;
    }

    public String getVersaoAplicacao() {
        return this.versaoAplicacao;
    }

    public void setVersaoAplicacao(final String versaoAplicacao) {
        this.versaoAplicacao = versaoAplicacao;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public String getMotivo() {
        return this.motivo;
    }

    public void setMotivo(final String motivo) {
        this.motivo = motivo;
    }

    public NFUnidadeFederativa getUf() {
        return this.uf;
    }

    public void setUf(final NFUnidadeFederativa uf) {
        this.uf = uf;
    }

    public String getChave() {
        return this.chave;
    }

    public void setChave(final String chave) {
        this.chave = chave;
    }

    public NFProtocolo getProtocolo() {
        return this.protocolo;
    }

    public void setProtocolo(final NFProtocolo protocolo) {
        this.protocolo = protocolo;
    }
}