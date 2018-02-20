package com.fincatto.documentofiscal.cte300.classes.nota.consulta;

import java.util.List;

import org.simpleframework.xml.*;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.cte300.classes.enviolote.consulta.CTeProtocolo;
import com.fincatto.documentofiscal.cte300.classes.evento.cancelamento.CTeProtocoloEventoCancelamento;
import com.fincatto.documentofiscal.cte300.classes.evento.cancelamento.CTeRetornoCancelamento;

@Root(name = "retConsSitCTe", strict = false)
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaConsultaRetorno extends DFBase {
    private static final long serialVersionUID = 3229234247371007557L;

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

    @Element(name = "cUF", required = true)
    private DFUnidadeFederativa uf;

    @Element(name = "protCTe", required = false)
    protected CTeProtocolo protocolo;

    @Element(name = "retCancCTe", required = false)
    private CTeRetornoCancelamento protocoloCancelamento;

    @ElementList(entry = "procEventoCTe", inline = true, required = false)
    private List<CTeProtocoloEventoCancelamento> protocoloEvento;

    public CTeNotaConsultaRetorno() {
        this.versao = null;
        this.ambiente = null;
        this.versaoAplicacao = null;
        this.status = null;
        this.motivo = null;
        this.uf = null;
        this.protocolo = null;
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

    public DFUnidadeFederativa getUf() {
        return this.uf;
    }

    public void setUf(final DFUnidadeFederativa uf) {
        this.uf = uf;
    }

    public CTeProtocolo getProtocolo() {
        return this.protocolo;
    }

    public void setProtocolo(final CTeProtocolo protocolo) {
        this.protocolo = protocolo;
    }

}