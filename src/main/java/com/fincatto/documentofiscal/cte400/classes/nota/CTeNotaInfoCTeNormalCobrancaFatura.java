package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

/**
 * Dados da fatura
 */

@Root(name = "fat")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoCTeNormalCobrancaFatura extends DFBase {
    private static final long serialVersionUID = 2053903392808275784L;

    @Element(name = "nFat", required = false)
    private String numero;

    @Element(name = "vOrig", required = false)
    private String valorOriginal;

    @Element(name = "vDesc", required = false)
    private String valorDesconto;

    @Element(name = "vLiq", required = false)
    private String valorLiquido;

    public String getNumero() {
        return this.numero;
    }

    /**
     * Número da fatura
     */
    public void setNumero(final String numero) {
        DFStringValidador.tamanho60(numero, "Número da fatura");
        this.numero = numero;
    }

    public String getValorOriginal() {
        return this.valorOriginal;
    }

    /**
     * Valor original da fatura
     */
    public void setValorOriginal(final BigDecimal valorOriginal) {
        this.valorOriginal = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorOriginal, "Valor original da fatura");
    }

    public String getValorDesconto() {
        return this.valorDesconto;
    }

    /**
     * Valor do desconto da fatura
     */
    public void setValorDesconto(final BigDecimal valorDesconto) {
        this.valorDesconto = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorDesconto, "Valor do desconto da fatura");
    }

    public String getValorLiquido() {
        return this.valorLiquido;
    }

    /**
     * Valor líquido da fatura
     */
    public void setValorLiquido(final BigDecimal valorLiquido) {
        this.valorLiquido = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorLiquido, "Valor líquido da fatura");
    }
}
