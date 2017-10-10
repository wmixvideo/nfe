package com.fincatto.documentofiscal.cte300.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.enviolote.consulta.CTeProtocolo;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Eldevan Nery Junior on 09/10/17.
 */
@Root(name = "cteProc")
public class CTeProcessado extends DFBase {

    /**
     * Tipo IP versão 4
     *
     */
    @Attribute(name = "ipTransmissor", required = false)
    private String ipTransmissor;

    @Attribute(name = "versao")
    private String versao;

    @Element(name = "CTe")
    private CTeNota cte;

    @Element(name = "protCTe")
    private CTeProtocolo protocolo;

    public String getIpTransmissor() {
        return ipTransmissor;
    }

    public void setIpTransmissor(String ipTransmissor) {
        this.ipTransmissor = ipTransmissor;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public CTeNota getCte() {
        return cte;
    }

    public void setCte(CTeNota cte) {
        this.cte = cte;
    }

    public CTeProtocolo getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(CTeProtocolo protocolo) {
        this.protocolo = protocolo;
    }
}
