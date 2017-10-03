package com.fincatto.documentofiscal.nfe310.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoSituacaoTributariaPIS;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;

public class NFNotaInfoItemImpostoPISOutrasOperacoes extends DFBase {
    private static final long serialVersionUID = 5707508769646733720L;

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
        this.valorBaseCalculo = BigDecimalParser.tamanho15Com2CasasDecimais(valorBaseCalculo, "Valor BC PIS OA Item");
    }

    public void setPercentualAliquota(final BigDecimal aliquota) {
        if (this.valorAliquota != null || this.quantidadeVendida != null) {
            throw new IllegalStateException("Nao pode setar percentual aliquota caso valor aliquota ou quantidade vendida esteja setado");
        }
        this.percentualAliquota = BigDecimalParser.tamanho7ComAte4CasasDecimais(aliquota, "Aliquota PIS OA Item");
    }

    public void setQuantidadeVendida(final BigDecimal quantidadeVendida) {
        if (this.percentualAliquota != null || this.valorBaseCalculo != null) {
            throw new IllegalStateException("Nao pode setar valor aliquota caso percentual aliquota ou valor base calculo esteja setado");
        }
        this.quantidadeVendida = BigDecimalParser.tamanho16ComAte4CasasDecimais(quantidadeVendida, "Qtde Vendida PIS OA Item");
    }

    public void setValorAliquota(final BigDecimal valorAliquota) {
        if (this.percentualAliquota != null || this.valorBaseCalculo != null) {
            throw new IllegalStateException("Nao pode setar valor aliquota caso percentual aliquota ou valor base calculo esteja setado");
        }
        this.valorAliquota = BigDecimalParser.tamanho15Com4CasasDecimais(valorAliquota, "Valor Aliquota PIS OA Item");
    }

    public void setValorTributo(final BigDecimal valorTributo) {
        this.valorTributo = BigDecimalParser.tamanho15Com2CasasDecimais(valorTributo, "Valor Tributo PIS OA Item");
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