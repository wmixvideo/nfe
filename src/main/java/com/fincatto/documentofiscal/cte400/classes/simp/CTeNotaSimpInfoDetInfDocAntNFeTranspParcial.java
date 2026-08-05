package com.fincatto.documentofiscal.cte400.classes.simp;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Chaves das NF-e transportadas parcialmente em relação ao documento anterior
 * (CT-e Simplificado - grupo det/infDocAnt). Informado quando tpPrest = 2 (Parcial).
 */
@Root(name = "infNFeTranspParcial")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaSimpInfoDetInfDocAntNFeTranspParcial extends DFBase {
    private static final long serialVersionUID = 1L;

    @Element(name = "chNFe")
    private String chNFe;

    public String getChNFe() {
        return this.chNFe;
    }

    /**
     * Chave de acesso da NF-e transportada parcialmente
     */
    public void setChNFe(final String chNFe) {
        DFStringValidador.exatamente44(chNFe, "Chave de acesso da NF-e (transporte parcial)");
        this.chNFe = chNFe;
    }
}
