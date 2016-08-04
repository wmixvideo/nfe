package com.fincatto.nfe.core.nota;

import com.fincatto.nfe.core.NFBase;
import com.fincatto.nfe.core.validadores.BigDecimalParser;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoCOFINSST extends NFBase {

    @Element(name = "vBC", required = false)
    private String valorBaseCalculo;

    @Element(name = "pCOFINS", required = false)
    private String percentualAliquota;

    @Element(name = "qBCProd", required = false)
    private String quantidadeVendida;

    @Element(name = "vAliqProd", required = false)
    private String valorAliquotaCOFINS;

    @Element(name = "vCOFINS", required = true)
    private String valorCOFINS;

    public NFNotaInfoItemImpostoCOFINSST() {
        this.valorBaseCalculo = null;
        this.percentualAliquota = null;
        this.quantidadeVendida = null;
        this.valorAliquotaCOFINS = null;
        this.valorCOFINS = null;
    }

    public void setValorBaseCalculo(final BigDecimal valorBaseCalculo) {
        if (this.quantidadeVendida != null || this.valorAliquotaCOFINS != null) {
            throw new IllegalStateException("Ja foi setado quantidade vendida ou valor aliquota COFINS");
        }
        this.valorBaseCalculo = BigDecimalParser.tamanho15Com2CasasDecimais(valorBaseCalculo, "Valor Base Calculo COFINS ST Item");
    }

    public void setPercentualAliquota(final BigDecimal aliquota) {
        if (this.quantidadeVendida != null || this.valorAliquotaCOFINS != null) {
            throw new IllegalStateException("Ja foi setado quantidade vendida ou valor aliquota COFINS");
        }
        this.percentualAliquota = BigDecimalParser.tamanho7ComAte4CasasDecimais(aliquota, "Aliquota COFINS ST Item");
    }

    public void setQuantidadeVendida(final BigDecimal quantidadeVendida) {
        if (this.valorBaseCalculo != null || this.percentualAliquota != null) {
            throw new IllegalStateException("Ja foi setado valor da base de calculo ou percentual aliquota COFINS");
        }
        this.quantidadeVendida = BigDecimalParser.tamanho16ComAte4CasasDecimais(quantidadeVendida, "Quantidade COFINS ST Item");
    }

    public void setValorAliquotaCOFINS(final BigDecimal valorAliquota) {
        if (this.valorBaseCalculo != null || this.percentualAliquota != null) {
            throw new IllegalStateException("Ja foi setado valor da base de calculo ou percentual aliquota COFINS");
        }
        this.valorAliquotaCOFINS = BigDecimalParser.tamanho15Com4CasasDecimais(valorAliquota, "Valor Aliquota COFINS ST Item");
    }

    public void setValorCOFINS(final BigDecimal valorTributo) {
        this.valorCOFINS = BigDecimalParser.tamanho15Com2CasasDecimais(valorTributo, "Valor Tributo COFINS ST Item");
    }

    public String getValorBaseCalculo() {
        return this.valorBaseCalculo;
    }

    public String getPercentualAliquota() {
        return this.percentualAliquota;
    }

    public String getQuantidadeVendida() {
        return this.quantidadeVendida;
    }

    public String getValorAliquotaCOFINS() {
        return this.valorAliquotaCOFINS;
    }

    public String getValorCOFINS() {
        return this.valorCOFINS;
    }
}