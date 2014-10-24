package com.fincatto.nfe310.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.classes.NFNotaInfoSituacaoTributariaIPI;
import com.fincatto.nfe310.validadores.BigDecimalParser;

public class NFNotaInfoItemImpostoIPITributado extends NFBase {

    @Element(name = "CST", required = true)
    private NFNotaInfoSituacaoTributariaIPI situacaoTributaria;

    @Element(name = "vBC", required = false)
    private String valorBaseCalculo;

    @Element(name = "pIPI", required = false)
    private String percentualAliquota;

    @Element(name = "qUnid", required = false)
    private String quantidade;

    @Element(name = "vUnid", required = false)
    private String valorUnidadeTributavel;

    @Element(name = "vIPI", required = true)
    private String valorTributo;

    public NFNotaInfoItemImpostoIPITributado() {
        this.situacaoTributaria = null;
        this.valorBaseCalculo = null;
        this.percentualAliquota = null;
        this.quantidade = null;
        this.valorUnidadeTributavel = null;
        this.valorTributo = null;
    }

    public void setSituacaoTributaria(final NFNotaInfoSituacaoTributariaIPI situacaoTributaria) {
        if (!situacaoTributaria.equals(NFNotaInfoSituacaoTributariaIPI.ENTRADA_RECUPERACAO_CREDITO) && !situacaoTributaria.equals(NFNotaInfoSituacaoTributariaIPI.OUTRAS_ENTRADAS) && !situacaoTributaria.equals(NFNotaInfoSituacaoTributariaIPI.SAIDA_TRIBUTADA) && !situacaoTributaria.equals(NFNotaInfoSituacaoTributariaIPI.OUTRAS_SAIDAS)) {
            throw new IllegalStateException("Situacao tributaria invalido");
        }
        this.situacaoTributaria = situacaoTributaria;
    }

    public void setValorBaseCalculo(final BigDecimal valorBaseCalculo) {
        if (this.quantidade != null || this.valorUnidadeTributavel != null) {
            throw new IllegalStateException("Nao pode setar valor base calculo se quantidade ou valor unidade tributavel esta setado");
        }
        this.valorBaseCalculo = BigDecimalParser.tamanho15Com2CasasDecimais(valorBaseCalculo);
    }

    public void setPercentualAliquota(final BigDecimal aliquota) {
        if (this.quantidade != null || this.valorUnidadeTributavel != null) {
            throw new IllegalStateException("Nao pode setar percentual aliquota se quantidade ou valor unidade tributavel esta setado");
        }
        this.percentualAliquota = BigDecimalParser.tamanho7ComAte4CasasDecimais(aliquota);
    }

    public void setQuantidade(final BigDecimal quantidade) {
        if (this.valorBaseCalculo != null || this.percentualAliquota != null) {
            throw new IllegalStateException("Nao pode setar quantidade se valorBaseCalculo ou PercentualAliquota esta setado");
        }
        this.quantidade = BigDecimalParser.tamanho16ComAte4CasasDecimais(quantidade);
    }

    public void setValorUnidadeTributavel(final BigDecimal valorUnitario) {
        if (this.valorBaseCalculo != null || this.percentualAliquota != null) {
            throw new IllegalStateException("Nao pode setar valor unidade tributavel se valorBaseCalculo ou PercentualAliquota esta setado");
        }
        this.valorUnidadeTributavel = BigDecimalParser.tamanho15comAte4CasasDecimais(valorUnitario);
    }

    public void setValorTributo(final BigDecimal valorTributo) {
        this.valorTributo = BigDecimalParser.tamanho15Com2CasasDecimais(valorTributo);
    }

    public NFNotaInfoSituacaoTributariaIPI getSituacaoTributaria() {
        return this.situacaoTributaria;
    }

    public String getValorBaseCalculo() {
        return this.valorBaseCalculo;
    }

    public String getPercentualAliquota() {
        return this.percentualAliquota;
    }

    public String getQuantidade() {
        return this.quantidade;
    }

    public String getValorUnidadeTributavel() {
        return this.valorUnidadeTributavel;
    }

    public String getValorTributo() {
        return this.valorTributo;
    }
}