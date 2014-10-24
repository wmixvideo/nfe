package com.fincatto.nfe310.classes.nota;

import java.math.BigDecimal;

import org.joda.time.LocalDate;
import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.validadores.BigDecimalParser;
import com.fincatto.nfe310.validadores.StringValidador;

public class NFNotaInfoDuplicata extends NFBase {
    @Element(name = "nDup", required = false)
    private String numeroDuplicata;

    @Element(name = "dVenc", required = false)
    private LocalDate dataVencimento;

    @Element(name = "vDup", required = true)
    private String valorDuplicata;

    public void setNumeroDuplicata(final String numeroDuplicata) {
        StringValidador.tamanho60(numeroDuplicata);
        this.numeroDuplicata = numeroDuplicata;
    }

    public void setDataVencimento(final LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public void setValorDuplicata(final BigDecimal valorDuplicata) {
        this.valorDuplicata = BigDecimalParser.tamanho15Com2CasasDecimais(valorDuplicata);
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