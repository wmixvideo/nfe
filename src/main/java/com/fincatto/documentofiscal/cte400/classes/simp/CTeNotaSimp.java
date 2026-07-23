package com.fincatto.documentofiscal.cte400.classes.simp;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.nota.CTeNotaInfoSuplementares;
import com.fincatto.documentofiscal.cte400.classes.nota.assinatura.CTeSignature;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Conhecimento de Transporte Eletrônico Simplificado (Modelo 57), conforme
 * NT 2024.002. Raiz do documento (elemento CTeSimp).
 */
@Root(name = "CTeSimp")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaSimp extends DFBase {
    private static final long serialVersionUID = 1L;

    @Element(name = "infCte")
    private CTeNotaSimpInfo infCte;

    @Element(name = "infCTeSupl", required = false)
    private CTeNotaInfoSuplementares infCTeSupl;

    @Element(name = "Signature", required = false)
    private CTeSignature signature;

    public CTeNotaSimpInfo getInfCte() {
        return this.infCte;
    }

    public void setInfCte(final CTeNotaSimpInfo infCte) {
        this.infCte = infCte;
    }

    public CTeNotaInfoSuplementares getInfCTeSupl() {
        return this.infCTeSupl;
    }

    public void setInfCTeSupl(final CTeNotaInfoSuplementares infCTeSupl) {
        this.infCTeSupl = infCTeSupl;
    }

    public CTeSignature getSignature() {
        return this.signature;
    }

    public void setSignature(final CTeSignature signature) {
        this.signature = signature;
    }
}
