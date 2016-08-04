package com.fincatto.nfe.core.nota;

import com.fincatto.nfe.core.NFBase;
import com.fincatto.nfe.core.NFNotaSituacaoOperacionalSimplesNacional;
import com.fincatto.nfe.core.NFOrigem;
import org.simpleframework.xml.Element;

public class NFNotaInfoItemImpostoICMSSN102 extends NFBase {
    @Element(name = "orig", required = true)
    private NFOrigem origem;

    @Element(name = "CSOSN", required = true)
    private NFNotaSituacaoOperacionalSimplesNacional situacaoOperacaoSN;

    public void setOrigem(final NFOrigem origem) {
        this.origem = origem;
    }

    public void setSituacaoOperacaoSN(final NFNotaSituacaoOperacionalSimplesNacional situacaoOperacaoSN) {
        this.situacaoOperacaoSN = situacaoOperacaoSN;
    }

    public NFOrigem getOrigem() {
        return this.origem;
    }

    public NFNotaSituacaoOperacionalSimplesNacional getSituacaoOperacaoSN() {
        return this.situacaoOperacaoSN;
    }
}