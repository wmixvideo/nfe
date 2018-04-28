package com.fincatto.documentofiscal.cte300.classes.evento.cancelamento;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;

@Root(name = "evCancCTe")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeEnviaEventoCancelamento extends DFBase {
    private static final long serialVersionUID = -6990304145768185274L;

    @Element(name = "descEvento")
    private String descricaoEvento = "Cancelamento";

    @Element(name = "nProt")
    private String protocoloAutorizacao;

    @Element(name = "xJust")
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

    public void setDescricaoEvento(final String descricaoEvento) {
        final String defaultValue = "Cancelamento";
        StringValidador.tamanho12(descricaoEvento, defaultValue);
        StringValidador.equals(defaultValue, descricaoEvento);
        this.descricaoEvento = descricaoEvento;
    }

    public String getDescricaoEvento() {
        return this.descricaoEvento;
    }

}