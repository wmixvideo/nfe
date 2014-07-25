package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.validadores.BigDecimalParser;

public class NFNotaInfoItemImpostoCOFINSST extends NFBase {

    @Element(name = "vBC", required = false)
    private String valorBaseCalculo;

    @Element(name = "pCOFINS", required = false)
    private String aliquota;

    @Element(name = "qBCProd", required = false)
    private String quantidadeVendida;

    @Element(name = "vAliqProd", required = false)
    private String valorAliquotaCOFINS;

    @Element(name = "vCOFINS", required = true)
    private String valorCOFINS;

    public NFNotaInfoItemImpostoCOFINSST() {
        this.valorBaseCalculo = null;
        this.aliquota = null;
        this.quantidadeVendida = null;
        this.valorAliquotaCOFINS = null;
        this.valorCOFINS = null;
    }

    public BigDecimal getValorBaseCalculo() {
        return new BigDecimal(this.valorBaseCalculo);
    }

    public void setValorBaseCalculo(final BigDecimal valorBaseCalculo) {
        if (this.quantidadeVendida != null && this.valorAliquotaCOFINS != null) {
            throw new IllegalStateException("Ja foi setado quantidade vendida ou valor aliquota COFINS");
        }
        this.valorBaseCalculo = BigDecimalParser.tamanho15Com2CasasDecimais(valorBaseCalculo);
    }

    public BigDecimal getPercentualAliquota() {
        return new BigDecimal(this.aliquota);
    }

    public void setPercentualAliquota(final BigDecimal aliquota) {
        if (this.quantidadeVendida != null && this.valorAliquotaCOFINS != null) {
            throw new IllegalStateException("Ja foi setado quantidade vendida ou valor aliquota COFINS");
        }
        this.aliquota = BigDecimalParser.tamanho5Com2CasasDecimais(aliquota);
    }

    public BigDecimal getQuantidadeVendida() {
        return new BigDecimal(this.quantidadeVendida);
    }

    public void setQuantidadeVendida(final BigDecimal quantidadeVendida) {
        if (this.valorBaseCalculo != null && this.aliquota != null) {
            throw new IllegalStateException("Ja foi setado valor da base de calculo ou percentual aliquota COFINS");
        }
        this.quantidadeVendida = BigDecimalParser.tamanho16ComAte4CasasDecimais(quantidadeVendida);
    }

    public BigDecimal getValorAliquotaCOFINS() {
        return new BigDecimal(this.valorAliquotaCOFINS);
    }

    public void setValorAliquotaCOFINS(final BigDecimal valorAliquota) {
        if (this.valorBaseCalculo != null && this.aliquota != null) {
            throw new IllegalStateException("Ja foi setado valor da base de calculo ou percentual aliquota COFINS");
        }
        this.valorAliquotaCOFINS = BigDecimalParser.tamanho15Com4CasasDecimais(valorAliquota);
    }

    public BigDecimal getValorCOFINS() {
        return new BigDecimal(this.valorCOFINS);
    }

    public void setValorCOFINS(final BigDecimal valorTributo) {
        this.valorCOFINS = BigDecimalParser.tamanho15Com2CasasDecimais(valorTributo);
    }
}