package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaMotivoReducaoADREM;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMS15 extends DFBase {
    private static final long serialVersionUID = -941691712925083232L;

    @Element(name = "orig")
    private NFOrigem origem;
    
    @Element(name = "CST")
    private NFNotaInfoImpostoTributacaoICMS situacaoTributaria;

    @Element(name = "qBCMono", required = false)
    private String quantidadeBaseCalculo;

    @Element(name = "adRemICMS")
    private String percentualAliquota;

    @Element(name = "vICMSMono")
    private String valorTributo;

    @Element(name = "qBCMonoReten", required = false)
    private String quantidadeBaseCalculoTributadaSujeitaRetencao;

    @Element(name = "adRemICMSReten")
    private String percentualAliquotaRetencao;

    @Element(name = "vICMSMonoReten")
    private String valorTributoRetencao;

    @Element(name = "pRedAdRem", required = false)
    private String percentualReducaoAliquota;

    @Element(name = "motRedAdRem", required = false)
    private NFNotaMotivoReducaoADREM motivoReducao;

    public void setOrigem(final NFOrigem origem) {
        this.origem = origem;
    }

    public void setSituacaoTributaria(final NFNotaInfoImpostoTributacaoICMS situacaoTributaria) {
        if (!situacaoTributaria.equals(NFNotaInfoImpostoTributacaoICMS.TRIBUTACAO_MONOFASICA_PROPRIA_E_COM_RESPONSABILIDADE_PELO_RETENCAO_SOBRE_COMBUSTIVES)) {
            throw new IllegalStateException("Situacao tributaria invalida no item ICMS15 ");
        }
        this.situacaoTributaria = situacaoTributaria;
    }

    public void setQuantidadeBaseCalculo(BigDecimal quantidadeBaseCalculo) {
        this.quantidadeBaseCalculo = DFBigDecimalValidador.tamanho15Com2CasasDecimais(quantidadeBaseCalculo, "Quantidade Tributada");
    }

    public void setPercentualAliquota(BigDecimal percentualAliquota) {
        this.percentualAliquota = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(percentualAliquota, "Alíquota ad rem do imposto");
    }

    public void setValorTributo(BigDecimal valorTributo) {
        this.valorTributo = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTributo, "ICMS próprio");
    }

    public void setQuantidadeBaseCalculoTributadaSujeitaRetencao(BigDecimal quantidadeBaseCalculoTributadaSujeitaRetencao) {
        this.quantidadeBaseCalculoTributadaSujeitaRetencao = DFBigDecimalValidador.tamanho15Com2CasasDecimais(quantidadeBaseCalculoTributadaSujeitaRetencao, "Quantidade tributada sujeita a retenção");
    }

    public void setPercentualAliquotaRetencao(BigDecimal percentualAliquotaRetencao) {
        this.percentualAliquotaRetencao = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(percentualAliquotaRetencao, "Alíquota ad rem do imposto com retenção");
    }

    public void setValorTributoRetencao(BigDecimal valorTributoRetencao) {
        this.valorTributoRetencao = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTributoRetencao, "ICMS com retenção");
    }

    public void setPercentualReducaoAliquota(BigDecimal percentualReducaoAliquota) {
        this.percentualReducaoAliquota = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(percentualReducaoAliquota, "Percentual de redução do valor da alíquota adrem do ICMS");
    }

    public void setMotivoReducao(NFNotaMotivoReducaoADREM motivoReducao) {
        this.motivoReducao = motivoReducao;
    }

    public NFOrigem getOrigem() {
        return origem;
    }

    public NFNotaInfoImpostoTributacaoICMS getSituacaoTributaria() {
        return situacaoTributaria;
    }

    public String getQuantidadeBaseCalculo() {
        return quantidadeBaseCalculo;
    }

    public String getPercentualAliquota() {
        return percentualAliquota;
    }

    public String getValorTributo() {
        return valorTributo;
    }

    public String getQuantidadeBaseCalculoTributadaSujeitaRetencao() {
        return quantidadeBaseCalculoTributadaSujeitaRetencao;
    }

    public String getPercentualAliquotaRetencao() {
        return percentualAliquotaRetencao;
    }

    public String getValorTributoRetencao() {
        return valorTributoRetencao;
    }

    public String getPercentualReducaoAliquota() {
        return percentualReducaoAliquota;
    }

    public NFNotaMotivoReducaoADREM getMotivoReducao() {
        return motivoReducao;
    }
}
