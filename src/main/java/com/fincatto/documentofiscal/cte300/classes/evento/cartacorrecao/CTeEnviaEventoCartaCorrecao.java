package com.fincatto.documentofiscal.cte300.classes.evento.cartacorrecao;

import com.fincatto.documentofiscal.cte300.classes.evento.CTeTipoEvento;
import org.simpleframework.xml.Element;

import java.util.List;

public class CTeEnviaEventoCartaCorrecao extends CTeTipoEvento {
    private static final long serialVersionUID = -6818585208080376005L;

    @Element(name = "infCorrecao")
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