package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoItemModalidadeBCICMS;
import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoItemModalidadeBCICMSST;
import com.fincatto.documentofiscal.nfe310.classes.NFOrigem;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMS10 extends DFBase {
    private static final long serialVersionUID = 3531314516853056385L;
    
    @Element(name = "orig")
    private NFOrigem origem;
    
    @Element(name = "CST")
    private NFNotaInfoImpostoTributacaoICMS situacaoTributaria;
    
    @Element(name = "modBC")
    private NFNotaInfoItemModalidadeBCICMS modalidadeBCICMS;
    
    @Element(name = "vBC")
    private String valorBaseCalculo;
    
    @Element(name = "pICMS")
    private String percentualAliquota;
    
    @Element(name = "vICMS")
    private String valorTributo;
    
    @Element(name = "modBCST")
    private NFNotaInfoItemModalidadeBCICMSST modalidadeBCICMSST;

    @Element(name = "pMVAST", required = false)
    private String percentualMargemValorICMSST;

    @Element(name = "pRedBCST", required = false)
    private String percentualReducaoBCICMSST;
    
    @Element(name = "vBCST")
    private String valorBCICMSST;
    
    @Element(name = "pICMSST")
    private String percentualAliquotaImpostoICMSST;
    
    @Element(name = "vICMSST")
    private String valorICMSST;

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
        this.valorBaseCalculo = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorBaseCalculo, "Valor Base Calculo ICMS10 Item");
    }

    public void setPercentualAliquota(final BigDecimal aliquota) {
        this.percentualAliquota = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(aliquota, "Aliquota ICMS10 Item");
    }

    public void setValorTributo(final BigDecimal valorTributo) {
        this.valorTributo = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTributo, "Valor Tributo ICMS10 Item");
    }

    public void setModalidadeBCICMSST(final NFNotaInfoItemModalidadeBCICMSST modalidadeBCICMSST) {
        this.modalidadeBCICMSST = modalidadeBCICMSST;
    }

    public void setPercentualMargemValorICMSST(final BigDecimal percentualMargemValorICMSST) {
        this.percentualMargemValorICMSST = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(percentualMargemValorICMSST, "Percentual MVA ICMS ST ICMS10 Item");
    }

    public void setPercentualReducaoBCICMSST(final BigDecimal percentualReducaoBCICMSST) {
        this.percentualReducaoBCICMSST = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(percentualReducaoBCICMSST, "Percentual Reducao BC ICMS ST ICMS10 Item");
    }

    public void setValorBCICMSST(final BigDecimal valorBCICMSST) {
        this.valorBCICMSST = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorBCICMSST, "Valor BC ICMS ST ICMS10 Item");
    }

    public void setPercentualAliquotaImpostoICMSST(final BigDecimal aliquotaImpostoICMSST) {
        this.percentualAliquotaImpostoICMSST = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(aliquotaImpostoICMSST, "Aliquota Imposto ICMS ST ICMS10 Item");
    }

    public void setValorICMSST(final BigDecimal valorICMSST) {
        this.valorICMSST = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorICMSST, "Valor ICMS ST ICMS10 Item");
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
}
