package com.fincatto.documentofiscal.cte400.classes.evento.comprovanteentrega;

import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.evento.CTeTipoEvento;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "evCancCECTe")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeEnviaEventoCancelamentoComprovanteEntrega extends CTeTipoEvento {
    private static final long serialVersionUID = -5488904753372508623L;

    @Element(name = "nProt")
    private String protocoloAutorizacao;

    @Element(name = "nProtCE")
    private String protocoloComprovanteEntrega;

    public String getProtocoloAutorizacao() {
        return protocoloAutorizacao;
    }

    public void setProtocoloAutorizacao(String protocoloAutorizacao) {
        DFStringValidador.exatamente15N(protocoloAutorizacao, "Protocolo de Autorizacao");
        this.protocoloAutorizacao = protocoloAutorizacao;
    }

    public String getProtocoloComprovanteEntrega() {
        return protocoloComprovanteEntrega;
    }

    public void setProtocoloComprovanteEntrega(String protocoloComprovanteEntrega) {
        DFStringValidador.exatamente15N(protocoloComprovanteEntrega, "Protocolo do Comprovante de Entrega");
        this.protocoloComprovanteEntrega = protocoloComprovanteEntrega;
    }
}