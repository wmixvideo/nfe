package com.fincatto.documentofiscal.cte200.classes.cte;

import java.time.LocalDate;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;

@Root(name = "dup")
public class CTInfoCobrancaDuplicata extends DFBase {
    private static final long serialVersionUID = -7718510412836786705L;

    @Element(name = "nDup", required = false)
    private String numeroDuplicata;

    @Element(name = "dVenc", required = false)
    private LocalDate dataVencimento;

    @Element(name = "vDup", required = false)
    private String valorDuplicata;

    public String getNumeroDuplicata() {
        return this.numeroDuplicata;
    }

    public void setNumeroDuplicata(final String numeroDuplicata) {
        this.numeroDuplicata = numeroDuplicata;
    }

    public LocalDate getDataVencimento() {
        return this.dataVencimento;
    }

    public void setDataVencimento(final LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getValorDuplicata() {
        return this.valorDuplicata;
    }

    public void setValorDuplicata(final String valorDuplicata) {
        this.valorDuplicata = valorDuplicata;
    }

}
