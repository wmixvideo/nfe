package com.fincatto.documentofiscal.nfe310.classes.evento.downloadnf;

import java.util.List;

import org.simpleframework.xml.*;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;

@Root(name = "retDownloadNFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFDownloadNFeRetorno extends DFBase {
    private static final long serialVersionUID = 6195353603223024941L;

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "tpAmb", required = true)
    private DFAmbiente ambiente;

    @Element(name = "verAplic", required = true)
    private String versaoAplicacao;

    @Element(name = "cStat", required = true)
    private String status;

    @Element(name = "xMotivo", required = true)
    private String motivo;

    @Element(name = "dhResp", required = true)
    private String dataRetorno;

    @ElementList(name = "retNFe", inline = true, required = false)
    private List<NFDownloadNFeRetornoInfo> info;

    public NFDownloadNFeRetorno() {
        this.versao = null;
        this.ambiente = null;
        this.versaoAplicacao = null;
        this.status = null;
        this.motivo = null;
        this.dataRetorno = null;
        this.info = null;
    }

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final String versao) {
        this.versao = versao;
    }

    public DFAmbiente getAmbiente() {
        return this.ambiente;
    }

    public void setAmbiente(final DFAmbiente ambiente) {
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

    public String getDataRetorno() {
        return this.dataRetorno;
    }

    public void setDataRetorno(final String dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    public List<NFDownloadNFeRetornoInfo> getInfo() {
        return this.info;
    }

    public void setInfo(final List<NFDownloadNFeRetornoInfo> info) {
        this.info = info;
    }
}
