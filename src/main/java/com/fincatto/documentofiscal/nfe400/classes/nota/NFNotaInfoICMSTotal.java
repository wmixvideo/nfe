package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFNotaInfoICMSTotal extends DFBase {
    private static final long serialVersionUID = 1644701343314788528L;
    
    @Element(name = "vBC")
    private String baseCalculoICMS;
    
    @Element(name = "vICMS")
    private String valorTotalICMS;
    
    @Element(name = "vICMSDeson")
    private String valorICMSDesonerado;

    @Element(name = "vFCPUFDest", required = false)
    private String valorICMSFundoCombatePobreza;

    @Element(name = "vICMSUFDest", required = false)
    private String valorICMSPartilhaDestinatario;

    @Element(name = "vICMSUFRemet", required = false)
    private String valorICMSPartilhaRementente;
    
    @Element(name = "vFCP")
    private String valorTotalFundoCombatePobreza;
    
    @Element(name = "vBCST")
    private String baseCalculoICMSST;
    
    @Element(name = "vST")
    private String valorTotalICMSST;
    
    @Element(name = "vFCPST")
    private String valorTotalFundoCombatePobrezaST;
    
    @Element(name = "vFCPSTRet")
    private String valorTotalFundoCombatePobrezaSTRetido;

    @Element(name = "qBCMono", required = false)
    private String quantidadeTributadaIcmsMonofasico;

    @Element(name = "vICMSMono", required = false)
    private String valorTotalIcmsMonofasico;

    @Element(name = "qBCMonoReten", required = false)
    private String quantidadeTributadaMonofasicoSujeitoRetencao;

    @Element(name = "vICMSMonoReten", required = false)
    private String valorTotalIcmsSujeitoRetencao;

    @Element(name = "qBCMonoRet", required = false)
    private String quantidadeTributadaMonofasicoRetiroAnteriormente;

    @Element(name = "vICMSMonoRet", required = false)
    private String valorTotalIcmsMonofasicoRetidoAnteriormente;

    @Element(name = "vProd")
    private String valorTotalDosProdutosServicos;
    
    @Element(name = "vFrete")
    private String valorTotalFrete;
    
    @Element(name = "vSeg")
    private String valorTotalSeguro;
    
    @Element(name = "vDesc")
    private String valorTotalDesconto;
    
    @Element(name = "vII")
    private String valorTotalII;
    
    @Element(name = "vIPI")
    private String valorTotalIPI;
    
    @Element(name = "vIPIDevol")
    private String valorTotalIPIDevolvido;
    
    @Element(name = "vPIS")
    private String valorPIS;
    
    @Element(name = "vCOFINS")
    private String valorCOFINS;
    
    @Element(name = "vOutro")
    private String outrasDespesasAcessorias;
    
    @Element(name = "vNF")
    private String valorTotalNFe;

    @Element(name = "vTotTrib", required = false)
    private String valorTotalTributos;

    public void setBaseCalculoICMS(final BigDecimal baseCalculoICMS) {
        this.baseCalculoICMS = DFBigDecimalValidador.tamanho15Com2CasasDecimais(baseCalculoICMS, "Base de Calculo ICMS Total");
    }

    public void setValorTotalICMS(final BigDecimal valorTotalICMS) {
        this.valorTotalICMS = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTotalICMS, "Valalor Total ICMS");
    }

    public void setBaseCalculoICMSST(final BigDecimal baseCalculoICMSST) {
        this.baseCalculoICMSST = DFBigDecimalValidador.tamanho15Com2CasasDecimais(baseCalculoICMSST, "Base de Calculo ICMS ST Total");
    }

    public void setValorTotalICMSST(final BigDecimal valorTotalICMSST) {
        this.valorTotalICMSST = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTotalICMSST, "Valor Total ICMS ST");
    }

    public void setValorTotalDosProdutosServicos(final BigDecimal valorTotalDosProdutosServicos) {
        this.valorTotalDosProdutosServicos = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTotalDosProdutosServicos, "Valor Total Produtos e Servicos");
    }

    public void setValorTotalFrete(final BigDecimal valorTotalFrete) {
        this.valorTotalFrete = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTotalFrete, "Valor Total Frete");
    }

    public void setValorTotalSeguro(final BigDecimal valorTotalSeguro) {
        this.valorTotalSeguro = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTotalSeguro, "Valor Total Seguro");
    }

    public void setValorTotalDesconto(final BigDecimal valorTotalDesconto) {
        this.valorTotalDesconto = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTotalDesconto, "Valor Total Desconto");
    }

    public void setValorTotalII(final BigDecimal valorTotalII) {
        this.valorTotalII = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTotalII, "Valor Total II");
    }

    public void setValorTotalIPI(final BigDecimal valorTotalIPI) {
        this.valorTotalIPI = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTotalIPI, "Valor Total IPI");
    }

    public void setValorPIS(final BigDecimal valorPIS) {
        this.valorPIS = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorPIS, "Valor Total PIS");
    }

    public void setValorCOFINS(final BigDecimal valorCOFINS) {
        this.valorCOFINS = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorCOFINS, "Valor Total COFINS");
    }

    public void setOutrasDespesasAcessorias(final BigDecimal outrasDespesasAcessorias) {
        this.outrasDespesasAcessorias = DFBigDecimalValidador.tamanho15Com2CasasDecimais(outrasDespesasAcessorias, "Outras Despesas Acessorias");
    }

    public void setValorTotalNFe(final BigDecimal valorTotalNFe) {
        this.valorTotalNFe = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTotalNFe, "Valor Total NFe");
    }

    public void setValorTotalTributos(final BigDecimal valorTotalTributos) {
        this.valorTotalTributos = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTotalTributos, "Valor Total Tributos");
    }

    public void setValorICMSDesonerado(final BigDecimal valorICMSDesonerado) {
        this.valorICMSDesonerado = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorICMSDesonerado, "Valor ICMS Desonerado");
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

    public String getBaseCalculoICMSST() {
        return this.baseCalculoICMSST;
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
        this.valorICMSFundoCombatePobreza = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorICMSFundoCombatePobreza, "Valor ICMS Fundo Combate a Pobreza");
    }

    public String getValorICMSPartilhaDestinatario() {
        return this.valorICMSPartilhaDestinatario;
    }

    public void setValorICMSPartilhaDestinatario(final BigDecimal valorICMSPartilhaDestinatario) {
        this.valorICMSPartilhaDestinatario = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorICMSPartilhaDestinatario, "Valor ICMS Partilha Destinatario");
    }

    public String getValorICMSPartilhaRementente() {
        return this.valorICMSPartilhaRementente;
    }

    public void setValorICMSPartilhaRementente(final BigDecimal valorICMSPartilhaRementente) {
        this.valorICMSPartilhaRementente = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorICMSPartilhaRementente, "Valor ICMS Partilha Remetente");
    }

    public void setValorTotalFundoCombatePobreza(final BigDecimal valorTotalFundoCombatePobreza) {
        this.valorTotalFundoCombatePobreza = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTotalFundoCombatePobreza, "Valor total fundo combate a pobreza");
    }

    public String getValorTotalFundoCombatePobreza() {
        return this.valorTotalFundoCombatePobreza;
    }

    public void setValorTotalFundoCombatePobrezaST(final BigDecimal valorTotalFundoCombatePobrezaST) {
        this.valorTotalFundoCombatePobrezaST = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTotalFundoCombatePobrezaST, "Valor total fundo combate a pobreza ST");
    }

    public String getValorTotalFundoCombatePobrezaST() {
        return this.valorTotalFundoCombatePobrezaST;
    }

    public void setValorTotalFundoCombatePobrezaSTRetido(final BigDecimal valorTotalFundoCombatePobrezaSTRetido) {
        this.valorTotalFundoCombatePobrezaSTRetido = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTotalFundoCombatePobrezaSTRetido, "Valor total fundo combate a pobreza ST retido");
    }

    public String getValorTotalFundoCombatePobrezaSTRetido() {
        return this.valorTotalFundoCombatePobrezaSTRetido;
    }

    public void setValorTotalIPIDevolvido(final BigDecimal valorTotalIPIDevolvido) {
        this.valorTotalIPIDevolvido = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTotalIPIDevolvido, "Valor total IPI devolvido");
    }

    public String getValorTotalIPIDevolvido() {
        return this.valorTotalIPIDevolvido;
    }

    public String getQuantidadeTributadaIcmsMonofasico() {
        return quantidadeTributadaIcmsMonofasico;
    }

    public void setQuantidadeTributadaIcmsMonofasico(BigDecimal quantidadeTributadaIcmsMonofasico) {
        this.quantidadeTributadaIcmsMonofasico = DFBigDecimalValidador.tamanho15Com2CasasDecimais(quantidadeTributadaIcmsMonofasico, "Valor total da quantidade tributada do ICMS monofásico próprio");
    }

    public String getValorTotalIcmsMonofasico() {
        return valorTotalIcmsMonofasico;
    }

    public void setValorTotalIcmsMonofasico(BigDecimal valorTotalIcmsMonofasico) {
        this.valorTotalIcmsMonofasico = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTotalIcmsMonofasico, "Valor total do ICMS monofásico próprio");
    }

    public String getQuantidadeTributadaMonofasicoSujeitoRetencao() {
        return quantidadeTributadaMonofasicoSujeitoRetencao;
    }

    public void setQuantidadeTributadaMonofasicoSujeitoRetencao(BigDecimal quantidadeTributadaMonofasicoSujeitoRetencao) {
        this.quantidadeTributadaMonofasicoSujeitoRetencao = DFBigDecimalValidador.tamanho15Com2CasasDecimais(quantidadeTributadaMonofasicoSujeitoRetencao, "Valor total da quantidade tributada do ICMS monofásico sujeito a retenção");
    }

    public String getValorTotalIcmsSujeitoRetencao() {
        return valorTotalIcmsSujeitoRetencao;
    }

    public void setValorTotalIcmsSujeitoRetencao(BigDecimal valorTotalIcmsSujeitoRetencao) {
        this.valorTotalIcmsSujeitoRetencao = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTotalIcmsSujeitoRetencao, "Valor total do ICMS monofásico sujeito a retenção");
    }

    public String getQuantidadeTributadaMonofasicoRetiroAnteriormente() {
        return quantidadeTributadaMonofasicoRetiroAnteriormente;
    }

    public void setQuantidadeTributadaMonofasicoRetiroAnteriormente(BigDecimal quantidadeTributadaMonofasicoRetiroAnteriormente) {
        this.quantidadeTributadaMonofasicoRetiroAnteriormente = DFBigDecimalValidador.tamanho15Com2CasasDecimais(quantidadeTributadaMonofasicoRetiroAnteriormente, "Valor total da quantidade tributada do ICMS monofásico retido anteriormente");
    }

    public String getValorTotalIcmsMonofasicoRetidoAnteriormente() {
        return valorTotalIcmsMonofasicoRetidoAnteriormente;
    }

    public void setValorTotalIcmsMonofasicoRetidoAnteriormente(BigDecimal valorTotalIcmsMonofasicoRetidoAnteriormente) {
        this.valorTotalIcmsMonofasicoRetidoAnteriormente = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTotalIcmsMonofasicoRetidoAnteriormente, "Valor total do ICMS monofásico retido anteriormente");
    }
}