package com.fincatto.documentofiscal.cte300.classes.evento.cancelamento;

import com.fincatto.documentofiscal.cte300.classes.evento.CTeTipoEvento;
import com.fincatto.documentofiscal.validadores.StringValidador;
import org.simpleframework.xml.Element;

public class CTeInfoCancelamento extends CTeTipoEvento {

    @Element(name = "nProt", required = true)
    private String protocoloAutorizacao;

    @Element(name = "xJust", required = true)
    private String justificativa;

    public void setJustificativa(final String justificativa) {
        StringValidador.tamanho15a256(justificativa, "Justificativa");
        this.justificativa = justificativa;
    }

    public void setProtocoloAutorizacao(final String protocoloAutorizacao) {
        StringValidador.exatamente15N(protocoloAutorizacao, "Protocolo de Autorizacao");
        this.protocoloAutorizacao = protocoloAutorizacao;
    }

    public String getJustificativa() {
        return this.justificativa;
    }

    public String getProtocoloAutorizacao() {
        return this.protocoloAutorizacao;
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