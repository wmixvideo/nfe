package com.fincatto.documentofiscal.cte200.classes.cte;

import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "fluxo")
public class CTInfoPrevisaoFluxo extends DFBase {
    private static final long serialVersionUID = 5781078010759179146L;

    @Element(name = "xOrig", required = false)
    private String codigoOrigem;

    @ElementList(name = "pass", required = false, inline = true)
    private List<CTInfoPrevisaoFluxoPassagem> passagem;

    @Element(name = "xDest", required = false)
    private String codigoDestino;

    @Element(name = "xRota", required = false)
    private String codigoRota;

    public String getCodigoOrigem() {
        return this.codigoOrigem;
    }

    public void setCodigoOrigem(final String codigoOrigem) {
        this.codigoOrigem = codigoOrigem;
    }

    public List<CTInfoPrevisaoFluxoPassagem> getPassagem() {
        return this.passagem;
    }

    public void setPassagem(final List<CTInfoPrevisaoFluxoPassagem> passagem) {
        this.passagem = passagem;
    }

    public String getCodigoDestino() {
        return this.codigoDestino;
    }

    public void setCodigoDestino(final String codigoDestino) {
        this.codigoDestino = codigoDestino;
    }

    public String getCodigoRota() {
        return this.codigoRota;
    }

    public void setCodigoRota(final String codigoRota) {
        this.codigoRota = codigoRota;
    }

}
