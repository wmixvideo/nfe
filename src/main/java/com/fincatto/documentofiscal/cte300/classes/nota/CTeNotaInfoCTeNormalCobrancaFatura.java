package com.fincatto.documentofiscal.cte300.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * @author Caio
 * @info Dados da fatura
 */

@Root(name = "fat")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalCobrancaFatura extends DFBase {
    private static final long serialVersionUID = -1932996967635387615L;

    @Element(name = "nFat", required = false)
    private String numero;

    @Element(name = "vOrig", required = false)
    private String valorOriginal;

    @Element(name = "vDesc", required = false)
    private String valorDesconto;

    @Element(name = "vLiq", required = false)
    private String valorLiquido;

    public CTeNotaInfoCTeNormalCobrancaFatura() {
        this.numero = null;
        this.valorOriginal = null;
        this.valorDesconto = null;
        this.valorLiquido = null;
    }

    public String getNumero() {
        return this.numero;
    }

    /**
     * Número da fatura
     */
    public void setNumero(final String numero) {
        StringValidador.tamanho60(numero, "Número da fatura");
        this.numero = numero;
    }

    public String getValorOriginal() {
        return this.valorOriginal;
    }

    /**
     * Valor original da fatura
     */
    public void setValorOriginal(final BigDecimal valorOriginal) {
        this.valorOriginal = BigDecimalParser.tamanho15Com2CasasDecimais(valorOriginal, "Valor original da fatura");
    }

    public String getValorDesconto() {
        return this.valorDesconto;
    }

    /**
     * Valor do desconto da fatura
     */
    public void setValorDesconto(final BigDecimal valorDesconto) {
        this.valorDesconto = BigDecimalParser.tamanho15Com2CasasDecimais(valorDesconto, "Valor do desconto da fatura");
    }

    public String getValorLiquido() {
        return this.valorLiquido;
    }

    /**
     * Valor líquido da fatura
     */
    public void setValorLiquido(final BigDecimal valorLiquido) {
        this.valorLiquido = BigDecimalParser.tamanho15Com2CasasDecimais(valorLiquido, "Valor líquido da fatura");
    }
}
