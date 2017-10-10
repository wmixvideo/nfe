package com.fincatto.documentofiscal.cte300.classes.evento.cancelamento;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.evento.CTeEventoRetorno;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "procEventoCTe")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeProtocoloEventoCancelamento extends DFBase {

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "eventoCTe", required = true)
    private CTeEventoCancelamento evento;

    @Element(name = "retEventoCTe", required = true)
    private CTeEventoRetorno eventoRetorno;



    public CTeEventoRetorno getInfoEventoRetorno() {
        return this.eventoRetorno;
    }

    public void setEventoRetorno(final CTeEventoRetorno infoEventoRetorno) {
        this.eventoRetorno = infoEventoRetorno;
    }

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final String versao) {
        this.versao = versao;
    }
}
