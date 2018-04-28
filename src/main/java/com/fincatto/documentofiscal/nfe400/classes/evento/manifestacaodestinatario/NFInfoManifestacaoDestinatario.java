package com.fincatto.documentofiscal.nfe400.classes.evento.manifestacaodestinatario;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.nfe400.classes.evento.NFTipoEvento;

public class NFInfoManifestacaoDestinatario extends NFTipoEvento {
    private static final long serialVersionUID = 8512309132142299111L;

    @Element(name = "xJust", required = false)
    private String justificativa;

    public void setJustificativa(final String justificativa) {
        this.justificativa = justificativa;
    }

    public String getJustificativa() {
        return this.justificativa;
    }

    @Override
    public void setCondicaoUso(final String condicaoUso) {
        throw new UnsupportedOperationException("Evento de cancelamento nao possui condicao de uso");
    }

    @Override
    public void setTextoCorrecao(final String textoCorrecao) {
        throw new UnsupportedOperationException("Evento de cancelamento nao possui texto de correcao");
    }
}