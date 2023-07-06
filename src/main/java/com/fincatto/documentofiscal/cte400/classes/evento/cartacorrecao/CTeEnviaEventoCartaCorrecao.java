package com.fincatto.documentofiscal.cte400.classes.evento.cartacorrecao;

import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.evento.CTeTipoEvento;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.util.List;
import org.simpleframework.xml.ElementList;

@Root(name = "evCCeCTe")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeEnviaEventoCartaCorrecao extends CTeTipoEvento {
    private static final long serialVersionUID = -6818585208080376005L;

    @ElementList(name = "infCorrecao", inline = true, required = true)
    private List<CTeInformacaoCartaCorrecao> correcoes;

    @Element(name = "xCondUso")
    private String condicaoUso;

    public List<CTeInformacaoCartaCorrecao> getCorrecoes() {
        return correcoes;
    }

    public void setCorrecoes(List<CTeInformacaoCartaCorrecao> correcoes) {
        this.correcoes = correcoes;
    }

    public String getCondicaoUso() {
        return condicaoUso;
    }

    public void setCondicaoUso(String condicaoUso) {
        this.condicaoUso = condicaoUso;
    }
}