package com.fincatto.nfe.core.nota;

import com.fincatto.nfe.core.NFBase;
import com.fincatto.nfe.core.NFNotaInfoSituacaoTributariaIPI;
import org.simpleframework.xml.Element;

public class NFNotaInfoItemImpostoIPINT extends NFBase {

    @Element(name = "IPINT", required = true)
    private NFNotaInfoSituacaoTributariaIPI situacaoTributariaIPI;

    public NFNotaInfoSituacaoTributariaIPI getSituacaoTributariaIPI() {
        return this.situacaoTributariaIPI;
    }

    public void setSituacaoTributariaIPI(final NFNotaInfoSituacaoTributariaIPI situacaoTributariaIPI) {
        this.situacaoTributariaIPI = situacaoTributariaIPI;
    }
}