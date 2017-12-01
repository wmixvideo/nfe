package com.fincatto.documentofiscal.mdfe3.classes.consultanaoencerrados;

import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Eldevan Nery Junior on 22/11/17.
 */
@Root(name = "infMDFe")
public class MDFeConsultaNaoEncerradosRetornoInfMDFe extends DFBase{

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
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getNumeroProtocolo() {
        return numeroProtocolo;
    }

    public void setNumeroProtocolo(String numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }
}
