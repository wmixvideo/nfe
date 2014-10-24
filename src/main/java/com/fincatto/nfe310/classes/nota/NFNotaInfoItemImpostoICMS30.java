package com.fincatto.nfe310.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.nfe310.classes.NFNotaInfoItemModalidadeBCICMSST;
import com.fincatto.nfe310.classes.NFNotaMotivoDesoneracaoICMS;
import com.fincatto.nfe310.classes.NFOrigem;
import com.fincatto.nfe310.validadores.BigDecimalParser;

public class NFNotaInfoItemImpostoICMS30 extends NFBase {
    @Element(name = "orig", required = true)
    private NFOrigem origem;

    @Element(name = "CST", required = true)
    private NFNotaInfoImpostoTributacaoICMS situacaoTributaria;

    @Element(name = "modBCST", required = true)
    private NFNotaInfoItemModalidadeBCICMSST modalidadeDeterminacaoBC;

    @Element(name = "pMVAST", required = false)
    private String percentualMargemValorAdicionadoICMSST;

    @Element(name = "pRedBCST", required = false)
    private String percentualReducaoBCICMSST;

    @Element(name = "vBCST", required = true)
    private String valorBCICMSST;

    @Element(name = "pICMSST", required = true)
    private String percentualAliquotaImpostoICMSST;

    @Element(name = "vICMSST", required = true)
    private String valorImpostoICMSST;

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

    public void setModalidadeDeterminacaoBC(final NFNotaInfoItemModalidadeBCICMSST modalidadeDeterminacaoBC) {
        this.modalidadeDeterminacaoBC = modalidadeDeterminacaoBC;
    }

    public void setPercentualMargemValorAdicionadoICMSST(final BigDecimal percentualMargemValorAdicionadoICMSST) {
        this.percentualMargemValorAdicionadoICMSST = BigDecimalParser.tamanho7ComAte4CasasDecimais(percentualMargemValorAdicionadoICMSST);
    }

    public void setPercentualReducaoBCICMSST(final BigDecimal percentualReducaoBCICMSST) {
        this.percentualReducaoBCICMSST = BigDecimalParser.tamanho7ComAte4CasasDecimais(percentualReducaoBCICMSST);
    }

    public void setValorBCICMSST(final BigDecimal valorBCICMSST) {
        this.valorBCICMSST = BigDecimalParser.tamanho15Com2CasasDecimais(valorBCICMSST);
    }

    public void setPercentualAliquotaImpostoICMSST(final BigDecimal aliquotaImpostoICMSST) {
        this.percentualAliquotaImpostoICMSST = BigDecimalParser.tamanho7ComAte4CasasDecimais(aliquotaImpostoICMSST);
    }

    public void setValorImpostoICMSST(final BigDecimal valorImpostoICMSST) {
        this.valorImpostoICMSST = BigDecimalParser.tamanho15Com2CasasDecimais(valorImpostoICMSST);
    }

    public void setDesoneracao(final NFNotaMotivoDesoneracaoICMS nfNotaMotivoDesoneracaoICMS) {
        this.desoneracao = nfNotaMotivoDesoneracaoICMS;
    }

    public void setValorICMSDesoneracao(final BigDecimal valorICMSDesoneracao) {
        this.valorICMSDesoneracao = BigDecimalParser.tamanho15Com2CasasDecimais(valorICMSDesoneracao);
    }

    public NFOrigem getOrigem() {
        return this.origem;
    }

    public NFNotaInfoImpostoTributacaoICMS getSituacaoTributaria() {
        return this.situacaoTributaria;
    }

    public NFNotaInfoItemModalidadeBCICMSST getModalidadeDeterminacaoBC() {
        return this.modalidadeDeterminacaoBC;
    }

    public String getPercentualMargemValorAdicionadoICMSST() {
        return this.percentualMargemValorAdicionadoICMSST;
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

    public String getValorImpostoICMSST() {
        return this.valorImpostoICMSST;
    }

    public String getValorICMSDesoneracao() {
        return this.valorICMSDesoneracao;
    }

    public NFNotaMotivoDesoneracaoICMS getDesoneracao() {
        return this.desoneracao;
    }
}