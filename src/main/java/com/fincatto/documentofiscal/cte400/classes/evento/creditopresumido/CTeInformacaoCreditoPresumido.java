package com.fincatto.documentofiscal.cte400.classes.evento.creditopresumido;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

/**
 * Informações do crédito presumido do IBS (gIBSCredPres) ou da CBS (gCBSCredPres)
 * no evento de apropriação de crédito presumido.
 */
public class CTeInformacaoCreditoPresumido extends DFBase {
    private static final long serialVersionUID = -5569024613428220351L;

    @Element(name = "pCredPres")
    private String percentualCreditoPresumido;

    @Element(name = "vCredPres")
    private String valorCreditoPresumido;

    public String getPercentualCreditoPresumido() {
        return this.percentualCreditoPresumido;
    }

    /**
     * Percentual do crédito presumido
     */
    public void setPercentualCreditoPresumido(final BigDecimal percentualCreditoPresumido) {
        this.percentualCreditoPresumido = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(percentualCreditoPresumido, "Percentual do Credito Presumido");
    }

    public String getValorCreditoPresumido() {
        return this.valorCreditoPresumido;
    }

    /**
     * Valor do crédito presumido (vBCCredPres x pCredPres, com tolerância de 0,01 na SEFAZ)
     */
    public void setValorCreditoPresumido(final BigDecimal valorCreditoPresumido) {
        this.valorCreditoPresumido = DFBigDecimalValidador.tamanho13Com2CasasDecimais(valorCreditoPresumido, "Valor do Credito Presumido");
    }
}
