package com.fincatto.nfe.core.nota;

import com.fincatto.nfe.core.*;
import com.fincatto.nfe.core.validadores.BigDecimalParser;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMS20 extends NFBase {

    @Element(name = "orig", required = true)
    private NFOrigem origem;

    @Element(name = "CST", required = true)
    private NFNotaInfoImpostoTributacaoICMS situacaoTributaria;

    @Element(name = "modBC", required = true)
    private NFNotaInfoItemModalidadeBCICMS modalidadeBCICMS;

    @Element(name = "pRedBC", required = true)
    private String percentualReducaoBC;

    @Element(name = "vBC", required = true)
    private String valorBCICMS;

    @Element(name = "pICMS", required = true)
    private String percentualAliquota;

    @Element(name = "vICMS", required = true)
    private String valorTributo;

    @Element(name = "vICMSDeson", required = false)
    private String valorICMSDesoneracao;

    @Element(name = "motDesICMS", required = false)
    private NFNotaMotivoDesoneracaoICMS desoneracao;

    public void setOrigem(final NFOrigem origem) {
        this.origem = origem;
    }

    public void setSituacaoTributaria(final NFNotaInfoImpostoTributacaoICMS situacaoTributaria) {
        this.situacaoTributaria = situacaoTributaria;
    }

    /**
     * @deprecated Utilizar setModalidadeBCICMS(...) 
     */
    @Deprecated
    public void setModalidadeBaseCalculo(final NFNotaInfoItemImpostoICMSModalidadeBaseCalculo modalidadeBaseCalculo) {
    	this.modalidadeBCICMS = NFNotaInfoItemModalidadeBCICMS.valueOfCodigo(modalidadeBaseCalculo.getCodigo());
    }
    
    public void setModalidadeBCICMS(final NFNotaInfoItemModalidadeBCICMS modalidadeBCICMS) {
        this.modalidadeBCICMS = modalidadeBCICMS;
    }

    public void setPercentualReducaoBC(final BigDecimal percentualReducaoBC) {
        this.percentualReducaoBC = BigDecimalParser.tamanho7ComAte4CasasDecimais(percentualReducaoBC, "Percentual Reducao BC ICMS20 Item");
    }

    public void setValorBCICMS(final BigDecimal valorBCICMS) {
        this.valorBCICMS = BigDecimalParser.tamanho15Com2CasasDecimais(valorBCICMS, "Valor BC ICMS ICMS20 Item");
    }

    public void setPercentualAliquota(final BigDecimal aliquota) {
        this.percentualAliquota = BigDecimalParser.tamanho5Com2CasasDecimais(aliquota, "Aliquota ICMS20 Item");
    }

    public void setValorTributo(final BigDecimal valorTributo) {
        this.valorTributo = BigDecimalParser.tamanho15Com2CasasDecimais(valorTributo, "Valor Tributo ICMS20 Item");
    }

    public void setDesoneracao(final NFNotaMotivoDesoneracaoICMS outros) {
        this.desoneracao = outros;
    }

    public void setValorICMSDesoneracao(final BigDecimal valorICMSDesoneracao) {
        this.valorICMSDesoneracao = BigDecimalParser.tamanho15Com2CasasDecimais(valorICMSDesoneracao, "Valor ICMS Desoneracao ICMS20 Item");
    }

    public NFOrigem getOrigem() {
        return this.origem;
    }

    public NFNotaInfoImpostoTributacaoICMS getSituacaoTributaria() {
        return this.situacaoTributaria;
    }
    
    /**
     * @deprecated Utilizar getModalidadeBCICMS()  
     */
    @Deprecated
    public NFNotaInfoItemImpostoICMSModalidadeBaseCalculo getModalidadeBaseCalculo() {
    	return NFNotaInfoItemImpostoICMSModalidadeBaseCalculo.valueOfCodigo(this.modalidadeBCICMS.getCodigo());
    }
    
    public NFNotaInfoItemModalidadeBCICMS getModalidadeBCICMS() {
        return this.modalidadeBCICMS;
    }

    public String getPercentualReducaoBC() {
        return this.percentualReducaoBC;
    }

    public String getValorBCICMS() {
        return this.valorBCICMS;
    }

    public String getPercentualAliquota() {
        return this.percentualAliquota;
    }

    public String getValorTributo() {
        return this.valorTributo;
    }

    public String getValorICMSDesoneracao() {
        return this.valorICMSDesoneracao;
    }

    public NFNotaMotivoDesoneracaoICMS getDesoneracao() {
        return this.desoneracao;
    }
}