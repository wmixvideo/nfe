package com.fincatto.documentofiscal.cte400.classes.nota.consulta;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.envio.CTeProtocolo;
import org.simpleframework.xml.*;

import java.util.List;

@Root(name = "retConsSitCTe", strict = false)
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaConsultaRetorno extends DFBase {
    private static final long serialVersionUID = 3229234247371007557L;
    
    @Attribute(name = "versao", required = false)
    private String versao;
    
    @Element(name = "tpAmb")
    private DFAmbiente ambiente;
    
    @Element(name = "verAplic")
    private String versaoAplicacao;
    
    @Element(name = "cStat")
    private String status;
    
    @Element(name = "xMotivo")
    private String motivo;
    
    @Element(name = "cUF")
    private DFUnidadeFederativa uf;

    @Element(name = "protCTe", required = false)
    protected CTeProtocolo protocolo;

    @ElementList(entry = "procEventoCTe", inline = true, required = false)
    private List<CTeProtocoloEvento> protocoloEvento;

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

    public List<CTeProtocoloEvento> getProtocoloEvento() {
        return protocoloEvento;
    }

    public void setProtocoloEvento(List<CTeProtocoloEvento> protocoloEvento) {
        this.protocoloEvento = protocoloEvento;
    }
}