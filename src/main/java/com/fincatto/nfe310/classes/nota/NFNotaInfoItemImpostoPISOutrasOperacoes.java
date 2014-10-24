package com.fincatto.nfe310.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.classes.NFNotaInfoSituacaoTributariaPIS;
import com.fincatto.nfe310.validadores.BigDecimalParser;

public class NFNotaInfoItemImpostoPISOutrasOperacoes extends NFBase {

    @Element(name = "CST", required = true)
    private NFNotaInfoSituacaoTributariaPIS situacaoTributaria;

    @Element(name = "vBC", required = false)
    private String valorBaseCalculo;

    @Element(name = "pPIS", required = false)
    private String percentualAliquota;

    @Element(name = "qBCProd", required = false)
    private String quantidadeVendida;

    @Element(name = "vAliqProd", required = false)
    private String valorAliquota;

    @Element(name = "vPIS", required = true)
    private String valorTributo;

    public void setSituacaoTributaria(final NFNotaInfoSituacaoTributariaPIS situacaoTributaria) {
        this.situacaoTributaria = situacaoTributaria;
    }

    public void setValorBaseCalculo(final BigDecimal valorBaseCalculo) {
        if (this.valorAliquota != null || this.quantidadeVendida != null) {
            throw new IllegalStateException("Nao pode setar percentual aliquota caso valor aliquota ou quantidade vendida esteja setado");
        }
        this.valorBaseCalculo = BigDecimalParser.tamanho15Com2CasasDecimais(valorBaseCalculo);
    }

    public void setPercentualAliquota(final BigDecimal aliquota) {
        if (this.valorAliquota != null || this.quantidadeVendida != null) {
            throw new IllegalStateException("Nao pode setar percentual aliquota caso valor aliquota ou quantidade vendida esteja setado");
        }
        this.percentualAliquota = BigDecimalParser.tamanho7ComAte4CasasDecimais(aliquota);
    }

    public void setQuantidadeVendida(final BigDecimal quantidadeVendida) {
        if (this.percentualAliquota != null || this.valorBaseCalculo != null) {
            throw new IllegalStateException("Nao pode setar valor aliquota caso percentual aliquota ou valor base calculo esteja setado");
        }
        this.quantidadeVendida = BigDecimalParser.tamanho16ComAte4CasasDecimais(quantidadeVendida);
    }

    public void setValorAliquota(final BigDecimal valorAliquota) {
        if (this.percentualAliquota != null || this.valorBaseCalculo != null) {
            throw new IllegalStateException("Nao pode setar valor aliquota caso percentual aliquota ou valor base calculo esteja setado");
        }
        this.valorAliquota = BigDecimalParser.tamanho15Com4CasasDecimais(valorAliquota);
    }

    public void setValorTributo(final BigDecimal valorTributo) {
        this.valorTributo = BigDecimalParser.tamanho15Com2CasasDecimais(valorTributo);
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

    public String getValorAliquota() {
        return this.valorAliquota;
    }

    public String getValorTributo() {
        return this.valorTributo;
    }

    public NFNotaInfoSituacaoTributariaPIS getSituacaoTributaria() {
        return this.situacaoTributaria;
    }
}