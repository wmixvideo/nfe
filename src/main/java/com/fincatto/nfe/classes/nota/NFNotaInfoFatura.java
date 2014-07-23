package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.validadores.BigDecimalParser;
import com.fincatto.nfe.validadores.StringValidador;

public class NFNotaInfoFatura extends NFBase {
    @Element(name = "nFat", required = false)
    private String numeroFatura;

    @Element(name = "vOrig", required = false)
    private String valorOriginalFatura;

    @Element(name = "vDesc", required = false)
    private String valorDesconto;

    @Element(name = "vLiq", required = false)
    private String valorLiquidoFatura;

    public String getNumeroFatura() {
        return this.numeroFatura;
    }

    public void setNumeroFatura(final String numeroFatura) {
        StringValidador.tamanho60(numeroFatura);
        this.numeroFatura = numeroFatura;
    }

    public BigDecimal getValorOriginalFatura() {
        return new BigDecimal(this.valorOriginalFatura);
    }

    public void setValorOriginalFatura(final BigDecimal valorOriginalFatura) {
        this.valorOriginalFatura = BigDecimalParser.tamanho15Com2CasasDecimais(valorOriginalFatura);
    }

    public BigDecimal getValorDesconto() {
        return new BigDecimal(this.valorDesconto);
    }

    public void setValorDesconto(final BigDecimal valorDesconto) {
        this.valorDesconto = BigDecimalParser.tamanho15Com2CasasDecimais(valorDesconto);
    }

    public BigDecimal getValorLiquidoFatura() {
        return new BigDecimal(this.valorLiquidoFatura);
    }

    public void setValorLiquidoFatura(final BigDecimal valorLiquidoFatura) {
        this.valorLiquidoFatura = BigDecimalParser.tamanho15Com2CasasDecimais(valorLiquidoFatura);
    }
}