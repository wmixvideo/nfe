package com.fincatto.documentofiscal.cte200.classes.cte;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;

public class CTInfoCobrancaFatura extends DFBase {
    private static final long serialVersionUID = 8102392581536329993L;

    @Element(name = "nFat", required = false)
    private String numeroFatura;

    @Element(name = "vOrig", required = false)
    private String valorOriginal;

    @Element(name = "vDesc", required = false)
    private String valorDesconto;

    @Element(name = "vLiq", required = false)
    private String valorLiquido;

    public String getNumeroFatura() {
        return this.numeroFatura;
    }

    public void setNumeroFatura(final String numeroFatura) {
        this.numeroFatura = numeroFatura;
    }

    public String getValorOriginal() {
        return this.valorOriginal;
    }

    public void setValorOriginal(final String valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public String getValorDesconto() {
        return this.valorDesconto;
    }

    public void setValorDesconto(final String valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public String getValorLiquido() {
        return this.valorLiquido;
    }

    public void setValorLiquido(final String valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

}
