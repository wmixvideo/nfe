package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;
import java.time.LocalDate;

public class NFNotaInfoDuplicata extends DFBase {
    private static final long serialVersionUID = 4401957395684813604L;

    @Element(name = "nDup", required = false)
    private String numeroDuplicata;

    @Element(name = "dVenc", required = false)
    private LocalDate dataVencimento;
    
    @Element(name = "vDup")
    private String valorDuplicata;

    public void setNumeroDuplicata(final String numeroDuplicata) {
        DFStringValidador.tamanho60(numeroDuplicata, "Numero Duplicata");
        this.numeroDuplicata = numeroDuplicata;
    }

    public void setDataVencimento(final LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public void setValorDuplicata(final BigDecimal valorDuplicata) {
        this.valorDuplicata = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorDuplicata, "Valor Duplicata");
    }

    public String getValorDuplicata() {
        return this.valorDuplicata;
    }

    public void setValorDuplicata(final String valorDuplicata) {
        this.valorDuplicata = valorDuplicata;
    }

    public String getNumeroDuplicata() {
        return this.numeroDuplicata;
    }

    public LocalDate getDataVencimento() {
        return this.dataVencimento;
    }
}