package com.fincatto.documentofiscal.cte400.classes.os;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.envio.CTeProtocolo;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.time.ZonedDateTime;

@Root(name = "cteOSProc")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeOSProcessado extends DFBase {
    private static final long serialVersionUID = 137030186528448628L;

    /**
     * Tipo IP versão 4
     */
    @Attribute(name = "ipTransmissor", required = false)
    private String ipTransmissor;

    @Attribute(name = "nPortaCon", required = false)
    private String portaConexao;

    @Attribute(name = "dhConexao", required = false)
    private ZonedDateTime dataHoraConexao;

    @Attribute(name = "versao")
    private String versao;

    @Element(name = "CTeOS")
    private CTeOS cte;

    @Element(name = "protCTe")
    private CTeProtocolo protocolo;

    public String getIpTransmissor() {
        return this.ipTransmissor;
    }

    public void setIpTransmissor(final String ipTransmissor) {
        this.ipTransmissor = ipTransmissor;
    }

    public String getPortaConexao() {
        return portaConexao;
    }

    public void setPortaConexao(String portaConexao) {
        this.portaConexao = portaConexao;
    }

    public ZonedDateTime getDataHoraConexao() {
        return dataHoraConexao;
    }

    public void setDataHoraConexao(ZonedDateTime dataHoraConexao) {
        this.dataHoraConexao = dataHoraConexao;
    }

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final String versao) {
        this.versao = versao;
    }

    public CTeOS getCte() {
        return this.cte;
    }

    public void setCte(final CTeOS cte) {
        this.cte = cte;
    }

    public CTeProtocolo getProtocolo() {
        return this.protocolo;
    }

    public void setProtocolo(final CTeProtocolo protocolo) {
        this.protocolo = protocolo;
    }
}
