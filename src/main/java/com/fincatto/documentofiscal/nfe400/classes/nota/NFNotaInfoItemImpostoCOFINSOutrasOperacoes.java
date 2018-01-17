package com.fincatto.documentofiscal.nfe400.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoSituacaoTributariaCOFINS;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;

public class NFNotaInfoItemImpostoCOFINSOutrasOperacoes extends DFBase {
    private static final long serialVersionUID = -7291550051334950307L;

    @Element(name = "CST", required = true)
    private NFNotaInfoSituacaoTributariaCOFINS situacaoTributaria;

    @Element(name = "vBC", required = false)
    private String valorBaseCalculo;

    @Element(name = "pCOFINS", required = false)
    private String percentualCOFINS;

    @Element(name = "qBCProd", required = false)
    private String quantidadeVendida;

    @Element(name = "vAliqProd", required = false)
    private String valorAliquota;

    @Element(name = "vCOFINS", required = false)
    private String valorCOFINS;

    public void setSituacaoTributaria(final NFNotaInfoSituacaoTributariaCOFINS situacaoTributaria) {
        this.situacaoTributaria = situacaoTributaria;
    }

    public void setValorBaseCalculo(final BigDecimal valorBaseCalculo) {
        this.valorBaseCalculo = BigDecimalParser.tamanho15Com2CasasDecimais(valorBaseCalculo, "Valor Base Calculo COFINS OA Item");
    }

    public void setPercentualCOFINS(final BigDecimal percentualCOFINS) {
        this.percentualCOFINS = BigDecimalParser.tamanho7ComAte4CasasDecimais(percentualCOFINS, "Percentual COFINS OA Item");
    }

    public void setQuantidadeVendida(final BigDecimal quantidadeVendida) {
        this.quantidadeVendida = BigDecimalParser.tamanho16ComAte4CasasDecimais(quantidadeVendida, "Quantidade Vendida COFINS OA Item");
    }

    public void setValorAliquota(final BigDecimal valorAliquota) {
        this.valorAliquota = BigDecimalParser.tamanho15Com4CasasDecimais(valorAliquota, "Valor Aliquota COFINS OA Item");
    }

    public void setValorCOFINS(final BigDecimal valorTributo) {
        this.valorCOFINS = BigDecimalParser.tamanho15Com2CasasDecimais(valorTributo, "Valor Tributo COFINS OA Item");
    }

    public NFNotaInfoSituacaoTributariaCOFINS getSituacaoTributaria() {
        return this.situacaoTributaria;
    }

    public String getValorBaseCalculo() {
        return this.valorBaseCalculo;
    }

    public String getPercentualCOFINS() {
        return this.percentualCOFINS;
    }

    public String getQuantidadeVendida() {
        return this.quantidadeVendida;
    }

    public String getValorAliquota() {
        return this.valorAliquota;
    }

    public String getValorCOFINS() {
        return this.valorCOFINS;
    }
}