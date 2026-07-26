package com.fincatto.documentofiscal.cte400.classes.simp;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.time.LocalDate;

/**
 * Informações das NF-e (CT-e Simplificado - grupo det)
 */
@Root(name = "infNFe")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaSimpInfoDetInfNFe extends DFBase {
    private static final long serialVersionUID = 1L;

    @Element(name = "chNFe")
    private String chNFe;

    @Element(name = "PIN", required = false)
    private String PIN;

    @Element(name = "dPrev", required = false)
    private LocalDate dPrev;

    public String getChNFe() {
        return this.chNFe;
    }

    /**
     * Chave de acesso da NF-e
     */
    public void setChNFe(final String chNFe) {
        DFStringValidador.exatamente44(chNFe, "Chave de acesso da NF-e");
        this.chNFe = chNFe;
    }

    public String getPIN() {
        return this.PIN;
    }

    /**
     * PIN atribuído pela SUFRAMA para a operação
     */
    public void setPIN(final String PIN) {
        this.PIN = PIN;
    }

    public LocalDate getDPrev() {
        return this.dPrev;
    }

    /**
     * Data prevista de entrega (AAAA-MM-DD)
     */
    public void setDPrev(final LocalDate dPrev) {
        this.dPrev = dPrev;
    }
}
