package com.fincatto.documentofiscal.cte200.classes.cte;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoImpostoTributacaoICMS;

public class CTInfoImpostoICMS00 extends DFBase {
    private static final long serialVersionUID = -1711586958075697747L;

    @Element(name = "CST")
    private NFNotaInfoImpostoTributacaoICMS situacaoTributaria;

    @Element(name = "vBC")
    private String valorBaseCalculo;

    @Element(name = "pICMS")
    private String percentualAliquota;

    @Element(name = "vICMS")
    private String valorTributo;

    public NFNotaInfoImpostoTributacaoICMS getSituacaoTributaria() {
        return this.situacaoTributaria;
    }

    public void setSituacaoTributaria(final NFNotaInfoImpostoTributacaoICMS situacaoTributaria) {
        this.situacaoTributaria = situacaoTributaria;
    }

    public String getValorBaseCalculo() {
        return this.valorBaseCalculo;
    }

    public void setValorBaseCalculo(final String valorBaseCalculo) {
        this.valorBaseCalculo = valorBaseCalculo;
    }

    public String getPercentualAliquota() {
        return this.percentualAliquota;
    }

    public void setPercentualAliquota(final String percentualAliquota) {
        this.percentualAliquota = percentualAliquota;
    }

    public String getValorTributo() {
        return this.valorTributo;
    }

    public void setValorTributo(final String valorTributo) {
        this.valorTributo = valorTributo;
    }

}
