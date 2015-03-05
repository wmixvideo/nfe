package com.fincatto.nfe310.classes.evento.cartacorrecao;

import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.evento.NFTipoEvento;
import com.fincatto.nfe310.validadores.StringValidador;

public class NFInfoCartaCorrecao extends NFTipoEvento {
    @Element(name = "xCorrecao", required = true)
    private String correcao;

    @Element(name = "xCondUso", required = true)
    private String condicaoDeUso;

    public void setCondicaoDeUso(final String condicaoDeUso) {
        this.condicaoDeUso = condicaoDeUso;
    }

    public void setCorrecao(final String correcao) {
        StringValidador.tamanho15a1000(correcao);
        this.correcao = correcao;
    }

    @Override
    public String getVersao() {
        return super.getVersao();
    }

    @Override
    public String getDescricaoEvento() {
        return super.getDescricaoEvento();
    }

    public String getCondicaoDeUso() {
        return this.condicaoDeUso;
    }

    public String getCorrecao() {
        return this.correcao;
    }
}