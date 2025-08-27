package com.fincatto.documentofiscal.cte400.classes.evento.desacordo;

import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.evento.CTeTipoEvento;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "evCancPrestDesacordo")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeEnviaEventoCancelamentoPrestacaoEmDesacordo extends CTeTipoEvento {
    private static final long serialVersionUID = 3184000389270035873L;

    @Element(name = "nProtEvPrestDes")
    private String protocoloDesacordo;

    public String getProtocoloDesacordo() {
        return protocoloDesacordo;
    }

    public void setProtocoloDesacordo(String protocoloDesacordo) {
        DFStringValidador.exatamente15N(protocoloDesacordo, "Protocolo de autorização do evento de prestação de serviço em desacordo");
        this.protocoloDesacordo = protocoloDesacordo;
    }
}