package com.fincatto.nfe310.classes.evento.manifestacaodestinatario;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.nfe310.classes.evento.NFTipoEvento;

@Root(name = "detEvento")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFInfoManifestacaoDestinatario extends NFTipoEvento {

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