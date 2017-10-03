package com.fincatto.documentofiscal.cte200.classes.cte;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoImpostoTributacaoICMS;

public class CTInfoImpostoICMS60 extends DFBase {
    private static final long serialVersionUID = -7709492258099941326L;

    @Element(name = "CST")
    private NFNotaInfoImpostoTributacaoICMS situacaoTributaria;

    @Element(name = "vBCSTRet")
    private String valorBaseCalculoRetencao;

    @Element(name = "vICMSSTRet")
    private String valorRetido;

    @Element(name = "pICMSSTRet")
    private String percentualAliquota;

    @Element(name = "vCred", required = false)
    private String valorCredito;

    public NFNotaInfoImpostoTributacaoICMS getSituacaoTributaria() {
        return this.situacaoTributaria;
    }

    public void setSituacaoTributaria(final NFNotaInfoImpostoTributacaoICMS situacaoTributaria) {
        this.situacaoTributaria = situacaoTributaria;
    }

    public String getValorBaseCalculoRetencao() {
        return this.valorBaseCalculoRetencao;
    }

    public void setValorBaseCalculoRetencao(final String valorBaseCalculoRetencao) {
        this.valorBaseCalculoRetencao = valorBaseCalculoRetencao;
    }

    public String getValorRetido() {
        return this.valorRetido;
    }

    public void setValorRetido(final String valorRetido) {
        this.valorRetido = valorRetido;
    }

    public String getPercentualAliquota() {
        return this.percentualAliquota;
    }

    public void setPercentualAliquota(final String percentualAliquota) {
        this.percentualAliquota = percentualAliquota;
    }

    public String getValorCredito() {
        return this.valorCredito;
    }

    public void setValorCredito(final String valorCredito) {
        this.valorCredito = valorCredito;
    }

}
