package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemModalidadeBCICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemModalidadeBCICMSST;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMS10 extends DFBase {
    private static final long serialVersionUID = 3531314516853056385L;

    @Element(name = "orig", required = true)
    private NFOrigem origem;

    @Element(name = "CST", required = true)
    private NFNotaInfoImpostoTributacaoICMS situacaoTributaria;

    @Element(name = "modBC", required = true)
    private NFNotaInfoItemModalidadeBCICMS modalidadeBCICMS;

    @Element(name = "vBC", required = true)
    private String valorBaseCalculo;

    @Element(name = "pICMS", required = true)
    private String percentualAliquota;

    @Element(name = "vICMS", required = true)
    private String valorTributo;

    @Element(name = "vBCFCP", required = false)
    private String valorBaseCalculoFundoCombatePobreza;

    @Element(name = "pFCP", required = false)
    private String percentualFundoCombatePobreza;

    @Element(name = "vFCP", required = false)
    private String valorFundoCombatePobreza;

    @Element(name = "modBCST", required = true)
    private NFNotaInfoItemModalidadeBCICMSST modalidadeBCICMSST;

    @Element(name = "pMVAST", required = false)
    private String percentualMargemValorICMSST;

    @Element(name = "pRedBCST", required = false)
    private String percentualReducaoBCICMSST;

    @Element(name = "vBCST", required = true)
    private String valorBCICMSST;

    @Element(name = "pICMSST", required = true)
    private String percentualAliquotaImpostoICMSST;

    @Element(name = "vICMSST", required = true)
    private String valorICMSST;

    @Element(name = "vBCFCPST", required = false)
    private String valorBCFundoCombatePobrezaST;

    @Element(name = "pFCPST", required = false)
    private String percentualFundoCombatePobrezaST;

    @Element(name = "vFCPST", required = false)
    private String valorFundoCombatePobrezaST;

    public void setOrigem(final NFOrigem origem) {
        this.origem = origem;
    }

    public void setSituacaoTributaria(final NFNotaInfoImpostoTributacaoICMS situacaoTributaria) {
        this.situacaoTributaria = situacaoTributaria;
    }

    public void setModalidadeBCICMS(final NFNotaInfoItemModalidadeBCICMS modalidadeBCICMS) {
        this.modalidadeBCICMS = modalidadeBCICMS;
    }

    public void setValorBaseCalculo(final BigDecimal valorBaseCalculo) {
        this.valorBaseCalculo = BigDecimalParser.tamanho15Com2CasasDecimais(valorBaseCalculo, "Valor Base Calculo ICMS10 Item");
    }

    public void setPercentualAliquota(final BigDecimal aliquota) {
        this.percentualAliquota = BigDecimalParser.tamanho7ComAte4CasasDecimais(aliquota, "Aliquota ICMS10 Item");
    }

    public void setValorTributo(final BigDecimal valorTributo) {
        this.valorTributo = BigDecimalParser.tamanho15Com2CasasDecimais(valorTributo, "Valor Tributo ICMS10 Item");
    }

    public void setModalidadeBCICMSST(final NFNotaInfoItemModalidadeBCICMSST modalidadeBCICMSST) {
        this.modalidadeBCICMSST = modalidadeBCICMSST;
    }

    public void setPercentualMargemValorICMSST(final BigDecimal percentualMargemValorICMSST) {
        this.percentualMargemValorICMSST = BigDecimalParser.tamanho7ComAte4CasasDecimais(percentualMargemValorICMSST, "Percentual MVA ICMS ST ICMS10 Item");
    }

    public void setPercentualReducaoBCICMSST(final BigDecimal percentualReducaoBCICMSST) {
        this.percentualReducaoBCICMSST = BigDecimalParser.tamanho7ComAte4CasasDecimais(percentualReducaoBCICMSST, "Percentual Reducao BC ICMS ST ICMS10 Item");
    }

    public void setValorBCICMSST(final BigDecimal valorBCICMSST) {
        this.valorBCICMSST = BigDecimalParser.tamanho15Com2CasasDecimais(valorBCICMSST, "Valor BC ICMS ST ICMS10 Item");
    }

    public void setPercentualAliquotaImpostoICMSST(final BigDecimal aliquotaImpostoICMSST) {
        this.percentualAliquotaImpostoICMSST = BigDecimalParser.tamanho7ComAte4CasasDecimais(aliquotaImpostoICMSST, "Aliquota Imposto ICMS ST ICMS10 Item");
    }

    public void setValorICMSST(final BigDecimal valorICMSST) {
        this.valorICMSST = BigDecimalParser.tamanho15Com2CasasDecimais(valorICMSST, "Valor ICMS ST ICMS10 Item");
    }

    public void setValorBaseCalculoFundoCombatePobreza(final BigDecimal valorBaseCalculoFundoCombatePobreza) {
        this.valorBaseCalculoFundoCombatePobreza = BigDecimalParser.tamanho15Com2CasasDecimais(valorBaseCalculoFundoCombatePobreza, "Base calculo fundo combate pobreza");
    }

    public void setPercentualFundoCombatePobreza(final BigDecimal percentualFundoCombatePobreza) {
        if (percentualFundoCombatePobreza.signum() <= 0) {
            throw new IllegalStateException("Percentual fundo de combate a pobreza precisa ser maior que zero!");
        }
        this.percentualFundoCombatePobreza = BigDecimalParser.tamanho7ComAte4CasasDecimais(percentualFundoCombatePobreza, "Percentual fundo combate pobreza");
    }

    public void setValorFundoCombatePobreza(final BigDecimal valorFundoCombatePobreza) {
        this.valorFundoCombatePobreza = BigDecimalParser.tamanho15Com2CasasDecimais(valorFundoCombatePobreza, "Valor fundo combate pobreza");
    }

    public void setValorBCFundoCombatePobrezaST(final BigDecimal valorBCFundoCombatePobrezaST) {
        this.valorBCFundoCombatePobrezaST = BigDecimalParser.tamanho15Com2CasasDecimais(valorBCFundoCombatePobrezaST, "Base calculo fundo combate pobreza ST");
    }

    public void setPercentualFundoCombatePobrezaST(final BigDecimal percentualFundoCombatePobrezaST) {
        if (percentualFundoCombatePobrezaST.signum() < 0) {
            throw new IllegalStateException("Percentual fundo de combate a pobreza precisa ser maior que zero!");
        }
        this.percentualFundoCombatePobrezaST = BigDecimalParser.tamanho7ComAte4CasasDecimais(percentualFundoCombatePobrezaST, "Percentual fundo combate pobreza ST");
    }

    public void setValorFundoCombatePobrezaST(final BigDecimal valorFundoCombatePobrezaST) {
        this.valorFundoCombatePobrezaST = BigDecimalParser.tamanho15Com2CasasDecimais(valorFundoCombatePobrezaST, "Valor fundo combate pobreza ST");
    }

    public NFOrigem getOrigem() {
        return this.origem;
    }

    public NFNotaInfoImpostoTributacaoICMS getSituacaoTributaria() {
        return this.situacaoTributaria;
    }

    public NFNotaInfoItemModalidadeBCICMS getModalidadeBCICMS() {
        return this.modalidadeBCICMS;
    }

    public String getValorBaseCalculo() {
        return this.valorBaseCalculo;
    }

    public String getPercentualAliquota() {
        return this.percentualAliquota;
    }

    public String getValorTributo() {
        return this.valorTributo;
    }

    public NFNotaInfoItemModalidadeBCICMSST getModalidadeBCICMSST() {
        return this.modalidadeBCICMSST;
    }

    public String getPercentualMargemValorICMSST() {
        return this.percentualMargemValorICMSST;
    }

    public String getPercentualReducaoBCICMSST() {
        return this.percentualReducaoBCICMSST;
    }

    public String getValorBCICMSST() {
        return this.valorBCICMSST;
    }

    public String getPercentualAliquotaImpostoICMSST() {
        return this.percentualAliquotaImpostoICMSST;
    }

    public String getValorICMSST() {
        return this.valorICMSST;
    }

    public String getValorBaseCalculoFundoCombatePobreza() {
        return this.valorBaseCalculoFundoCombatePobreza;
    }

    public String getPercentualFundoCombatePobreza() {
        return this.percentualFundoCombatePobreza;
    }

    public String getValorFundoCombatePobreza() {
        return this.valorFundoCombatePobreza;
    }

    public String getValorBCFundoCombatePobrezaST() {
        return this.valorBCFundoCombatePobrezaST;
    }

    public String getPercentualFundoCombatePobrezaST() {
        return this.percentualFundoCombatePobrezaST;
    }

    public String getValorFundoCombatePobrezaST() {
        return this.valorFundoCombatePobrezaST;
    }
}
