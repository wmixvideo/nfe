package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.joda.time.LocalDate;
import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.validadores.BigDecimalParser;
import com.fincatto.nfe.validadores.StringValidador;

public class NFNotaInfoDuplicata extends NFBase {
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
        StringValidador.tamanho60(numeroDuplicata);
        this.numeroDuplicata = numeroDuplicata;
    }

    public LocalDate getDataVencimento() {
        return this.dataVencimento;
    }

    public void setDataVencimento(final LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public BigDecimal getValorDuplicata() {
        return new BigDecimal(this.valorDuplicata);
    }

    public void setValorDuplicata(final BigDecimal valorDuplicata) {
        this.valorDuplicata = BigDecimalParser.tamanho15Com2CasasDecimais(valorDuplicata);
    }
}