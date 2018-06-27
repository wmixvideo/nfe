package com.fincatto.documentofiscal.mdfe3.classes.consultanaoencerrados;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;

/**
 * Created by Eldevan Nery Junior on 22/11/17.
 */
@Root(name = "infMDFe")
public class MDFeConsultaNaoEncerradosRetornoInfMDFe extends DFBase {
    private static final long serialVersionUID = 1971335524222923251L;

    /**
     * Chaves de acesso do MDF-e não encerrado
     */
    @Element(name = "chMDFe", required = true)
    private String chave;

    /**
     * Número do Protocolo de autorização do MDF-e não encerrado.
     */
    @Element(name = "nProt", required = false)
    private String numeroProtocolo;

    public String getChave() {
        return this.chave;
    }

    public void setChave(final String chave) {
        this.chave = chave;
    }

    public String getNumeroProtocolo() {
        return this.numeroProtocolo;
    }

    public void setNumeroProtocolo(final String numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }
}
