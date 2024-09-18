package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe400.classes.*;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import java.math.BigDecimal;
import org.simpleframework.xml.Element;

public class NFNotaInfoItemImpostoICMS90 extends DFBase {

    private static final long serialVersionUID = 5614463736855881160L;

    @Element(name = "orig")
    private NFOrigem origem;

    @Element(name = "CST")
    private NFNotaInfoImpostoTributacaoICMS situacaoTributaria;

    @Element(name = "modBC", required = false)
    private NFNotaInfoItemModalidadeBCICMS modalidadeBCICMS;

    @Element(name = "vBC", required = false)
    private String valorBC;

    @Element(name = "pRedBC", required = false)
    private String percentualReducaoBC;

    @Element(name = "pICMS", required = false)
    private String percentualAliquota;

    @Element(name = "vICMS", required = false)
    private String valorTributo;

    @Element(name = "vBCFCP", required = false)
    private String valorBCFundoCombatePobreza;

    @Element(name = "pFCP", required = false)
    private String percentualFundoCombatePobreza;

    @Element(name = "vFCP", required = false)
    private String valorFundoCombatePobreza;

    @Element(name = "modBCST", required = false)
    private NFNotaInfoItemModalidadeBCICMSST modalidadeBCICMSST;

    @Element(name = "pMVAST", required = false)
    private String percentualMargemValorAdicionadoICMSST;

    @Element(name = "pRedBCST", required = false)
    private String percentualReducaoBCICMSST;

    @Element(name = "vBCST", required = false)
    private String valorBCST;

    @Element(name = "pICMSST", required = false)
    private String percentualAliquotaImpostoICMSST;

    @Element(name = "vICMSST", required = false)
    private String valorICMSST;

    @Element(name = "vBCFCPST", required = false)
    private String valorBCFundoCombatePobrezaST;

    @Element(name = "pFCPST", required = false)
    private String percentualFundoCombatePobrezaST;

    @Element(name = "vFCPST", required = false)
    private String valorFundoCombatePobrezaST;

    @Element(name = "vICMSDeson", required = false)
    private String valorICMSDesoneracao;

    @Element(name = "motDesICMS", required = false)
    private NFNotaMotivoDesoneracaoICMS desoneracao;

    @Element(name = "vICMSSTDeson", required = false)
    private String valorICMSSTDesonerado;

    @Element(name = "motDesICMSST", required = false)
    private NFNotaMotivoDesoneracaoICMS motivoDesoneracaoICMSST;

    @Element(name = "indDeduzDeson", required = false)
    private NFTipoDeducaoIcms indicaDeduzDesoneracao;

    public void setOrigem(final NFOrigem origem) {
        this.origem = origem;
    }

    public void setSituacaoTributaria(final NFNotaInfoImpostoTributacaoICMS situacaoTributaria) {
        this.situacaoTributaria = situacaoTributaria;
    }

    public void setModalidadeBCICMS(final NFNotaInfoItemModalidadeBCICMS modalidadeBCICMS) {
        this.modalidadeBCICMS = modalidadeBCICMS;
    }

    public void setValorBC(final BigDecimal valorBC) {
        this.valorBC = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorBC, "Valor BC ICMS90 Item");
    }

    public void setPercentualReducaoBC(final BigDecimal percentualReducaoBC) {
        this.percentualReducaoBC = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(percentualReducaoBC, "Percentual Reducao BC ICMS90 Item");
    }

    public void setPercentualAliquota(final BigDecimal aliquota) {
        this.percentualAliquota = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(aliquota, "Aliquota ICMS90 Item");
    }

    public void setValorTributo(final BigDecimal valorTributo) {
        this.valorTributo = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTributo, "Valor Tributo ICMS90 Item");
    }

    public void setModalidadeBCICMSST(final NFNotaInfoItemModalidadeBCICMSST modalidadeBCICMSST) {
        this.modalidadeBCICMSST = modalidadeBCICMSST;
    }

    public void setPercentualMargemValorAdicionadoICMSST(final BigDecimal percentualMargemValorAdicionadoICMSST) {
        this.percentualMargemValorAdicionadoICMSST = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(percentualMargemValorAdicionadoICMSST, "Percentual Margem Valor Adicionado ICMS ST ICMS90 Item");
    }

    public void setPercentualReducaoBCICMSST(final BigDecimal percentualReducaoBCICMSST) {
        this.percentualReducaoBCICMSST = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(percentualReducaoBCICMSST, "Percentual Reducao BC ICMS ST ICMS90 Item");
    }

    public void setValorBCST(final BigDecimal valorBCST) {
        this.valorBCST = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorBCST, "Valor BC ST ICMS90 Item");
    }

    public void setPercentualAliquotaImpostoICMSST(final BigDecimal aliquotaImpostoICMSST) {
        this.percentualAliquotaImpostoICMSST = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(aliquotaImpostoICMSST, "Aliquota Imposto ICMS ST ICMS90 Item");
    }

    public void setValorICMSST(final BigDecimal valorICMSST) {
        this.valorICMSST = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorICMSST, "Valor ICMS ST ICMS90 Item");
    }

    public void setDesoneracao(final NFNotaMotivoDesoneracaoICMS desoneracao) {
        this.desoneracao = desoneracao;
    }

    public void setValorICMSDesoneracao(final BigDecimal valorICMSDesoneracao) {
        this.valorICMSDesoneracao = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorICMSDesoneracao, "Valor ICMS Desoneracao ICMS90 Item");
    }

    public void setValorBCFundoCombatePobreza(final BigDecimal valorBCFundoCombatePobreza) {
        this.valorBCFundoCombatePobreza = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorBCFundoCombatePobreza, "Valor base calculo fundo combate pobreza");
    }

    public void setPercentualFundoCombatePobreza(final BigDecimal percentualFundoCombatePobreza) {
        if (percentualFundoCombatePobreza.signum() <= 0) {
            throw new IllegalStateException("Percentual fundo de combate a pobreza precisa ser maior que zero!");
        }
        this.percentualFundoCombatePobreza = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(percentualFundoCombatePobreza, "Percentual fundo combate pobreza");
    }

    public void setValorFundoCombatePobreza(final BigDecimal valorFundoCombatePobreza) {
        this.valorFundoCombatePobreza = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorFundoCombatePobreza, "Valor fundo combate pobreza");
    }

    public void setValorBCFundoCombatePobrezaST(final BigDecimal valorBCFundoCombatePobrezaST) {
        this.valorBCFundoCombatePobrezaST = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorBCFundoCombatePobrezaST, "Base calculo fundo combate pobreza ST");
    }

    public void setPercentualFundoCombatePobrezaST(final BigDecimal percentualFundoCombatePobrezaST) {
        if (percentualFundoCombatePobrezaST.signum() <= 0) {
            throw new IllegalStateException("Percentual fundo de combate a pobreza precisa ser maior que zero!");
        }
        this.percentualFundoCombatePobrezaST = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(percentualFundoCombatePobrezaST, "Percentual fundo combate pobreza ST");
    }

    public void setValorFundoCombatePobrezaST(final BigDecimal valorFundoCombatePobrezaST) {
        this.valorFundoCombatePobrezaST = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorFundoCombatePobrezaST, "Valor fundo combate pobreza ST");
    }

    public void setValorICMSSTDesonerado(BigDecimal valorICMSSTDesonerado) {
        this.valorICMSSTDesonerado = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorICMSSTDesonerado, "Valor do ICMS-ST desonerado");
    }

    public void setMotivoDesoneracaoICMSST(NFNotaMotivoDesoneracaoICMS motivoDesoneracaoICMSST) {
        this.motivoDesoneracaoICMSST = motivoDesoneracaoICMSST;
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

    public String getValorBC() {
        return this.valorBC;
    }

    public String getPercentualReducaoBC() {
        return this.percentualReducaoBC;
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

    public String getPercentualMargemValorAdicionadoICMSST() {
        return this.percentualMargemValorAdicionadoICMSST;
    }

    public String getPercentualReducaoBCICMSST() {
        return this.percentualReducaoBCICMSST;
    }

    public String getValorBCST() {
        return this.valorBCST;
    }

    public String getPercentualAliquotaImpostoICMSST() {
        return this.percentualAliquotaImpostoICMSST;
    }

    public String getValorICMSST() {
        return this.valorICMSST;
    }

    public String getValorICMSDesoneracao() {
        return this.valorICMSDesoneracao;
    }

    public NFNotaMotivoDesoneracaoICMS getDesoneracao() {
        return this.desoneracao;
    }

    public String getValorBCFundoCombatePobreza() {
        return this.valorBCFundoCombatePobreza;
    }

    public String getPercentualFundoCombatePobreza() {
        return this.percentualFundoCombatePobreza;
    }

    public String getValorFundoCombatePobreza() {
        return this.valorFundoCombatePobreza;
    }

    public String getPercentualFundoCombatePobrezaST() {
        return this.percentualFundoCombatePobrezaST;
    }

    public String getValorBCFundoCombatePobrezaST() {
        return this.valorBCFundoCombatePobrezaST;
    }

    public String getValorFundoCombatePobrezaST() {
        return this.valorFundoCombatePobrezaST;
    }

    public String getValorICMSSTDesonerado() {
        return valorICMSSTDesonerado;
    }

    public NFNotaMotivoDesoneracaoICMS getMotivoDesoneracaoICMSST() {
        return motivoDesoneracaoICMSST;
    }

    public NFTipoDeducaoIcms getIndicaDeduzDesoneracao() {
        return indicaDeduzDesoneracao;
    }

    public void setIndicaDeduzDesoneracao(NFTipoDeducaoIcms indicaDeduzDesoneracao) {
        this.indicaDeduzDesoneracao = indicaDeduzDesoneracao;
    }
}
