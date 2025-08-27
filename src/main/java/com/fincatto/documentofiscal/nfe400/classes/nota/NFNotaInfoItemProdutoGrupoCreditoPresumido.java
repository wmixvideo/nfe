package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFNotaInfoItemProdutoGrupoCreditoPresumido extends DFBase {

    private static final long serialVersionUID = 3442235647525896376L;

    @Element(name = "cCredPresumido")
    private String codigoBeneficioFiscalCreditoPresumido;

    @Element(name = "pCredPresumido")
    private String percentualCreditoPresumido;

    @Element(name = "vCredPresumido")
    private String valorCreditoPresumido;

    public NFNotaInfoItemProdutoGrupoCreditoPresumido() {
        this.codigoBeneficioFiscalCreditoPresumido = null;
        this.percentualCreditoPresumido = null;
        this.valorCreditoPresumido = null;
    }

    public String getCodigoBeneficioFiscalCreditoPresumido() {
        return codigoBeneficioFiscalCreditoPresumido;
    }

    public NFNotaInfoItemProdutoGrupoCreditoPresumido setCodigoBeneficioFiscalCreditoPresumido(
        final String codigoBeneficioFiscalCreditoPresumido) {
        DFStringValidador.validaIntervalo(codigoBeneficioFiscalCreditoPresumido, 8, 10,
            "Codigo de beneficio fiscal de credito presumido");
        this.codigoBeneficioFiscalCreditoPresumido = codigoBeneficioFiscalCreditoPresumido;
        return this;
    }

    public String getPercentualCreditoPresumido() {
        return percentualCreditoPresumido;
    }

    public NFNotaInfoItemProdutoGrupoCreditoPresumido setPercentualCreditoPresumido(
        final BigDecimal percentualCreditoPresumido) {
        this.percentualCreditoPresumido = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(
            percentualCreditoPresumido, "Percentual de credito presumido");
        return this;
    }

    public String getValorCreditoPresumido() {
        return valorCreditoPresumido;
    }

    public NFNotaInfoItemProdutoGrupoCreditoPresumido setValorCreditoPresumido(
        final BigDecimal valorCreditoPresumido) {
        this.valorCreditoPresumido = DFBigDecimalValidador.tamanho13Com2CasasDecimais(
            valorCreditoPresumido, "Valor de credito presumido");
        return this;
    }

}