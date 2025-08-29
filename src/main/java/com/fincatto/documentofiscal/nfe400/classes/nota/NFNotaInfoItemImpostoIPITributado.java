package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoSituacaoTributariaIPI;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoIPITributado extends DFBase {
    private static final long serialVersionUID = 8601910032276263880L;
    
    @Element(name = "CST")
    private NFNotaInfoSituacaoTributariaIPI situacaoTributaria;

    @Element(name = "vBC", required = false)
    private String valorBaseCalculo;

    @Element(name = "pIPI", required = false)
    private String percentualAliquota;

    @Element(name = "qUnid", required = false)
    private String quantidade;

    @Element(name = "vUnid", required = false)
    private String valorUnidadeTributavel;
    
    @Element(name = "vIPI")
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
        if (!situacaoTributaria.equals(NFNotaInfoSituacaoTributariaIPI.CST_00) && !situacaoTributaria.equals(NFNotaInfoSituacaoTributariaIPI.CST_49) && !situacaoTributaria.equals(NFNotaInfoSituacaoTributariaIPI.CST_50) && !situacaoTributaria.equals(NFNotaInfoSituacaoTributariaIPI.CST_99)) {
            throw new IllegalStateException("Situacao tributaria invalido no item IPI tributado.");
        }
        this.situacaoTributaria = situacaoTributaria;
    }

    public void setValorBaseCalculo(final BigDecimal valorBaseCalculo) {
        if (this.quantidade != null || this.valorUnidadeTributavel != null) {
            throw new IllegalStateException("Nao pode setar valor base calculo se quantidade ou valor unidade tributavel esta setado");
        }
        this.valorBaseCalculo = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorBaseCalculo, "Valor BC IPI Tributado");
    }

    public void setPercentualAliquota(final BigDecimal aliquota) {
        if (this.quantidade != null || this.valorUnidadeTributavel != null) {
            throw new IllegalStateException("Nao pode setar percentual aliquota se quantidade ou valor unidade tributavel esta setado");
        }
        this.percentualAliquota = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(aliquota, "Aliquota IPI Tributado");
    }

    public void setQuantidade(final BigDecimal quantidade) {
        if (this.valorBaseCalculo != null || this.percentualAliquota != null) {
            throw new IllegalStateException("Nao pode setar quantidade se valorBaseCalculo ou PercentualAliquota esta setado");
        }
        this.quantidade = DFBigDecimalValidador.tamanho16ComAte4CasasDecimais(quantidade, "Quantidade IPI Tributado");
    }

    public void setValorUnidadeTributavel(final BigDecimal valorUnitario) {
        if (this.valorBaseCalculo != null || this.percentualAliquota != null) {
            throw new IllegalStateException("Nao pode setar valor unidade tributavel se valorBaseCalculo ou PercentualAliquota esta setado");
        }
        this.valorUnidadeTributavel = DFBigDecimalValidador.tamanho15comAte4CasasDecimais(valorUnitario, "Valor Unitario IPI Tributado");
    }

    public void setValorTributo(final BigDecimal valorTributo) {
        this.valorTributo = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTributo, "Valor Tributo IPI Tributado");
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