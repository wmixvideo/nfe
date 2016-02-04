package com.fincatto.nfe310.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.nfe310.classes.NFNotaInfoItemImpostoICMSModalidadeBaseCalculo;
import com.fincatto.nfe310.classes.NFOrigem;
import com.fincatto.nfe310.validadores.BigDecimalParser;

public class NFNotaInfoItemImpostoICMS51 extends NFBase {
    @Element(name = "orig", required = true)
    private NFOrigem origem;

    @Element(name = "CST", required = true)
    private NFNotaInfoImpostoTributacaoICMS situacaoTributaria;

    @Element(name = "modBC", required = false)
    private NFNotaInfoItemImpostoICMSModalidadeBaseCalculo modalidadeBC;

    @Element(name = "pRedBC", required = false)
    private String percentualReducaoBC;

    @Element(name = "vBC", required = false)
    private String valorBCICMS;

    @Element(name = "pICMS", required = false)
    private String percentualICMS;

    @Element(name = "vICMSOp", required = false)
    private String valorICMSOperacao;

    @Element(name = "pDif", required = false)
    private String percentualDiferimento;

    @Element(name = "vICMSDif", required = false)
    private String valorICMSDiferimento;

    @Element(name = "vICMS", required = false)
    private String valorICMS;

    public void setOrigem(final NFOrigem origem) {
        this.origem = origem;
    }

    public void setSituacaoTributaria(final NFNotaInfoImpostoTributacaoICMS situacaoTributaria) {
        this.situacaoTributaria = situacaoTributaria;
    }

    public void setModalidadeBC(final NFNotaInfoItemImpostoICMSModalidadeBaseCalculo modalidadeBC) {
        this.modalidadeBC = modalidadeBC;
    }

    public void setPercentualReducaoBC(final BigDecimal percentualReducaoBC) {
        this.percentualReducaoBC = BigDecimalParser.tamanho7ComAte4CasasDecimais(percentualReducaoBC);
    }

    public void setValorBCICMS(final BigDecimal valorBCICMS) {
        this.valorBCICMS = BigDecimalParser.tamanho15Com2CasasDecimais(valorBCICMS);
    }

    public void setPercentualICMS(final BigDecimal percentualICMS) {
        this.percentualICMS = BigDecimalParser.tamanho5Com2CasasDecimais(percentualICMS);
    }

    public void setValorICMS(final BigDecimal valorICMS) {
        this.valorICMS = BigDecimalParser.tamanho15Com2CasasDecimais(valorICMS);
    }

    public void setPercentualDiferimento(final BigDecimal percentualDiferimento) {
        this.percentualDiferimento = BigDecimalParser.tamanho7ComAte4CasasDecimais(percentualDiferimento);
    }

    public void setValorICMSDiferimento(final BigDecimal valorICMSDiferimento) {
        this.valorICMSDiferimento = BigDecimalParser.tamanho15Com2CasasDecimais(valorICMSDiferimento);
    }

    public void setValorICMSOperacao(final BigDecimal valorICMSOperacao) {
        this.valorICMSOperacao = BigDecimalParser.tamanho15Com2CasasDecimais(valorICMSOperacao);
    }

    public NFOrigem getOrigem() {
        return this.origem;
    }

    public NFNotaInfoImpostoTributacaoICMS getSituacaoTributaria() {
        return this.situacaoTributaria;
    }

    public NFNotaInfoItemImpostoICMSModalidadeBaseCalculo getModalidadeBC() {
        return this.modalidadeBC;
    }

    public String getPercentualReducaoBC() {
        return this.percentualReducaoBC;
    }

    public String getValorBCICMS() {
        return this.valorBCICMS;
    }

    public String getPercentualICMS() {
        return this.percentualICMS;
    }

    public String getValorICMSOperacao() {
        return this.valorICMSOperacao;
    }

    public String getPercentualDiferimento() {
        return this.percentualDiferimento;
    }

    public String getValorICMSDiferimento() {
        return this.valorICMSDiferimento;
    }

    public String getValorICMS() {
        return this.valorICMS;
    }
}