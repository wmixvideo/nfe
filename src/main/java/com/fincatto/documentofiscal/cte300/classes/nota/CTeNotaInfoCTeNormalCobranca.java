package com.fincatto.documentofiscal.cte300.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * @author Caio
 * @info Dados da cobrança do CT-e
 */

@Root(name = "cobr")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalCobranca extends DFBase {
    private static final long serialVersionUID = 3613541664304195294L;

    @Element(name = "fat", required = false)
    private CTeNotaInfoCTeNormalCobrancaFatura fatura;

    @ElementList(entry = "dup", inline = true, required = false)
    private List<CTeNotaInfoCTeNormalCobrancaDuplicata> duplicata;

    public CTeNotaInfoCTeNormalCobranca() {
        this.fatura = null;
        this.duplicata = null;
    }

    public CTeNotaInfoCTeNormalCobrancaFatura getFatura() {
        return this.fatura;
    }

    /**
     * Dados da fatura
     */
    public void setFatura(final CTeNotaInfoCTeNormalCobrancaFatura fatura) {
        this.fatura = fatura;
    }

    public List<CTeNotaInfoCTeNormalCobrancaDuplicata> getDuplicata() {
        return this.duplicata;
    }

    /**
     * Dados das duplicatas
     */
    public void setDuplicata(final List<CTeNotaInfoCTeNormalCobrancaDuplicata> duplicata) {
        this.duplicata = duplicata;
    }
}
