package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemModalidadeBCICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaMotivoDesoneracaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import com.fincatto.documentofiscal.nfe400.classes.NFTipoDeducaoIcms;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import java.math.BigDecimal;
import org.simpleframework.xml.Element;

public class NFNotaInfoItemImpostoICMS20 extends DFBase {

    private static final long serialVersionUID = -7632059708755735047L;

    @Element(name = "orig")
    private NFOrigem origem;

    @Element(name = "CST")
    private NFNotaInfoImpostoTributacaoICMS situacaoTributaria;

    @Element(name = "modBC")
    private NFNotaInfoItemModalidadeBCICMS modalidadeBCICMS;

    @Element(name = "pRedBC")
    private String percentualReducaoBC;

    @Element(name = "vBC")
    private String valorBCICMS;

    @Element(name = "pICMS")
    private String percentualAliquota;

    @Element(name = "vICMS")
    private String valorTributo;

    @Element(name = "vBCFCP", required = false)
    private String valorBCFundoCombatePobreza;

    @Element(name = "pFCP", required = false)
    private String percentualFundoCombatePobreza;

    @Element(name = "vFCP", required = false)
    private String valorFundoCombatePobreza;

    @Element(name = "vICMSDeson", required = false)
    private String valorICMSDesoneracao;

    @Element(name = "motDesICMS", required = false)
    private NFNotaMotivoDesoneracaoICMS desoneracao;

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

    public void setPercentualReducaoBC(final BigDecimal percentualReducaoBC) {
        this.percentualReducaoBC = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(percentualReducaoBC, "Percentual Reducao BC ICMS20 Item");
    }

    public void setValorBCICMS(final BigDecimal valorBCICMS) {
        this.valorBCICMS = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorBCICMS, "Valor BC ICMS ICMS20 Item");
    }

    public void setPercentualAliquota(final BigDecimal aliquota) {
        this.percentualAliquota = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(aliquota, "Aliquota ICMS20 Item");
    }

    public void setValorTributo(final BigDecimal valorTributo) {
        this.valorTributo = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTributo, "Valor Tributo ICMS20 Item");
    }

    public void setDesoneracao(final NFNotaMotivoDesoneracaoICMS outros) {
        this.desoneracao = outros;
    }

    public void setValorICMSDesoneracao(final BigDecimal valorICMSDesoneracao) {
        this.valorICMSDesoneracao = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorICMSDesoneracao, "Valor ICMS Desoneracao ICMS20 Item");
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

    public NFOrigem getOrigem() {
        return this.origem;
    }

    public NFNotaInfoImpostoTributacaoICMS getSituacaoTributaria() {
        return this.situacaoTributaria;
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

    public String getValorBCFundoCombatePobreza() {
        return this.valorBCFundoCombatePobreza;
    }

    public String getPercentualFundoCombatePobreza() {
        return this.percentualFundoCombatePobreza;
    }

    public String getValorFundoCombatePobreza() {
        return this.valorFundoCombatePobreza;
    }

    public NFTipoDeducaoIcms getIndicaDeduzDesoneracao() {
        return indicaDeduzDesoneracao;
    }

    public void setIndicaDeduzDesoneracao(NFTipoDeducaoIcms indicaDeduzDesoneracao) {
        this.indicaDeduzDesoneracao = indicaDeduzDesoneracao;
    }
}
