package com.fincatto.nfe310.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.validadores.BigDecimalParser;

public class NFNotaInfoICMSTotal extends NFBase {

    @Element(name = "vBC", required = true)
    private String baseCalculoICMS;

    @Element(name = "vICMS", required = true)
    private String valorTotalICMS;

    @Element(name = "vICMSDeson", required = true)
    private String valorICMSDesonerado;

    @Element(name = "vFCPUFDest", required = false)
    private String valorICMSFundoCombatePobreza;

    @Element(name = "vICMSUFDest", required = false)
    private String valorICMSPartilhaDestinatario;

    @Element(name = "vICMSUFRemet", required = false)
    private String valorICMSPartilhaRementente;

    @Element(name = "vBCST", required = true)
    private String valor;

    @Element(name = "vST", required = true)
    private String valorTotalICMSST;

    @Element(name = "vProd", required = true)
    private String valorTotalDosProdutosServicos;

    @Element(name = "vFrete", required = true)
    private String valorTotalFrete;

    @Element(name = "vSeg", required = true)
    private String valorTotalSeguro;

    @Element(name = "vDesc", required = true)
    private String valorTotalDesconto;

    @Element(name = "vII", required = true)
    private String valorTotalII;

    @Element(name = "vIPI", required = true)
    private String valorTotalIPI;

    @Element(name = "vPIS", required = true)
    private String valorPIS;

    @Element(name = "vCOFINS", required = true)
    private String valorCOFINS;

    @Element(name = "vOutro", required = true)
    private String outrasDespesasAcessorias;

    @Element(name = "vNF", required = true)
    private String valorTotalNFe;

    @Element(name = "vTotTrib", required = false)
    private String valorTotalTributos;

    public void setBaseCalculoICMS(final BigDecimal baseCalculoICMS) {
        this.baseCalculoICMS = BigDecimalParser.tamanho15Com2CasasDecimais(baseCalculoICMS);
    }

    public void setValorTotalICMS(final BigDecimal valorTotalICMS) {
        this.valorTotalICMS = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalICMS);
    }

    public void setValor(final BigDecimal valor) {
        this.valor = BigDecimalParser.tamanho15Com2CasasDecimais(valor);
    }

    public void setValorTotalICMSST(final BigDecimal valorTotalICMSST) {
        this.valorTotalICMSST = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalICMSST);
    }

    public void setValorTotalDosProdutosServicos(final BigDecimal valorTotalDosProdutosServicos) {
        this.valorTotalDosProdutosServicos = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalDosProdutosServicos);
    }

    public void setValorTotalFrete(final BigDecimal valorTotalFrete) {
        this.valorTotalFrete = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalFrete);
    }

    public void setValorTotalSeguro(final BigDecimal valorTotalSeguro) {
        this.valorTotalSeguro = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalSeguro);
    }

    public void setValorTotalDesconto(final BigDecimal valorTotalDesconto) {
        this.valorTotalDesconto = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalDesconto);
    }

    public void setValorTotalII(final BigDecimal valorTotalII) {
        this.valorTotalII = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalII);
    }

    public void setValorTotalIPI(final BigDecimal valorTotalIPI) {
        this.valorTotalIPI = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalIPI);
    }

    public void setValorPIS(final BigDecimal valorPIS) {
        this.valorPIS = BigDecimalParser.tamanho15Com2CasasDecimais(valorPIS);
    }

    public void setValorCOFINS(final BigDecimal valorCOFINS) {
        this.valorCOFINS = BigDecimalParser.tamanho15Com2CasasDecimais(valorCOFINS);
    }

    public void setOutrasDespesasAcessorias(final BigDecimal outrasDespesasAcessorias) {
        this.outrasDespesasAcessorias = BigDecimalParser.tamanho15Com2CasasDecimais(outrasDespesasAcessorias);
    }

    public void setValorTotalNFe(final BigDecimal valorTotalNFe) {
        this.valorTotalNFe = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalNFe);
    }

    public void setValorTotalTributos(final BigDecimal valorTotalTributos) {
        this.valorTotalTributos = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalTributos);
    }

    public void setValorICMSDesonerado(final BigDecimal valorICMSDesonerado) {
        this.valorICMSDesonerado = BigDecimalParser.tamanho15Com2CasasDecimais(valorICMSDesonerado);
    }

    public String getBaseCalculoICMS() {
        return this.baseCalculoICMS;
    }

    public String getValorTotalICMS() {
        return this.valorTotalICMS;
    }

    public String getValorICMSDesonerado() {
        return this.valorICMSDesonerado;
    }

    public String getValor() {
        return this.valor;
    }

    public String getValorTotalICMSST() {
        return this.valorTotalICMSST;
    }

    public String getValorTotalDosProdutosServicos() {
        return this.valorTotalDosProdutosServicos;
    }

    public String getValorTotalFrete() {
        return this.valorTotalFrete;
    }

    public String getValorTotalSeguro() {
        return this.valorTotalSeguro;
    }

    public String getValorTotalDesconto() {
        return this.valorTotalDesconto;
    }

    public String getValorTotalII() {
        return this.valorTotalII;
    }

    public String getValorTotalIPI() {
        return this.valorTotalIPI;
    }

    public String getValorPIS() {
        return this.valorPIS;
    }

    public String getValorCOFINS() {
        return this.valorCOFINS;
    }

    public String getOutrasDespesasAcessorias() {
        return this.outrasDespesasAcessorias;
    }

    public String getValorTotalNFe() {
        return this.valorTotalNFe;
    }

    public String getValorTotalTributos() {
        return this.valorTotalTributos;
    }

    public String getValorICMSFundoCombatePobreza() {
        return this.valorICMSFundoCombatePobreza;
    }

    public void setValorICMSFundoCombatePobreza(final BigDecimal valorICMSFundoCombatePobreza) {
        this.valorICMSFundoCombatePobreza = BigDecimalParser.tamanho15Com2CasasDecimais(valorICMSFundoCombatePobreza);
    }

    public String getValorICMSPartilhaDestinatario() {
        return this.valorICMSPartilhaDestinatario;
    }

    public void setValorICMSPartilhaDestinatario(final BigDecimal valorICMSPartilhaDestinatario) {
        this.valorICMSPartilhaDestinatario = BigDecimalParser.tamanho15Com2CasasDecimais(valorICMSPartilhaDestinatario);
    }

    public String getValorICMSPartilhaRementente() {
        return this.valorICMSPartilhaRementente;
    }

    public void setValorICMSPartilhaRementente(final BigDecimal valorICMSPartilhaRementente) {
        this.valorICMSPartilhaRementente = BigDecimalParser.tamanho15Com2CasasDecimais(valorICMSPartilhaRementente);
    }
}