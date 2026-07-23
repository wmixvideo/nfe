package com.fincatto.documentofiscal.cte400.classes.simp;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Documentos anteriores (CT-e Simplificado - grupo det)
 */
@Root(name = "infDocAnt")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaSimpInfoDetInfDocAnt extends DFBase {
    private static final long serialVersionUID = 1L;

    @Element(name = "chCTe")
    private String chCTe;

    @Element(name = "tpPrest")
    private String tpPrest;

    @ElementList(name = "infNFeTranspParcial", inline = true, required = false)
    private List<CTeNotaSimpInfoDetInfDocAntNFeTranspParcial> infNFeTranspParcial;

    public String getChCTe() {
        return this.chCTe;
    }

    /**
     * Chave de acesso do CT-e anterior
     */
    public void setChCTe(final String chCTe) {
        DFStringValidador.exatamente44(chCTe, "Chave de acesso do CT-e anterior");
        this.chCTe = chCTe;
    }

    public String getTpPrest() {
        return this.tpPrest;
    }

    /**
     * Indica se a prestação é total ou parcial em relação às notas do documento
     * anterior. Preencher com: 1 - Total; 2 - Parcial.
     */
    public void setTpPrest(final String tpPrest) {
        DFStringValidador.exatamente1(tpPrest, "Tipo da prestação do documento anterior");
        if (!"1".equals(tpPrest) && !"2".equals(tpPrest)) {
            throw new IllegalStateException("Tipo da prestação do documento anterior deve ser 1 (Total) ou 2 (Parcial)");
        }
        this.tpPrest = tpPrest;
    }

    public List<CTeNotaSimpInfoDetInfDocAntNFeTranspParcial> getInfNFeTranspParcial() {
        return this.infNFeTranspParcial;
    }

    /**
     * Chaves das NF-e transportadas parcialmente (obrigatório quando tpPrest = 2).
     */
    public void setInfNFeTranspParcial(final List<CTeNotaSimpInfoDetInfDocAntNFeTranspParcial> infNFeTranspParcial) {
        this.infNFeTranspParcial = infNFeTranspParcial;
    }
}
