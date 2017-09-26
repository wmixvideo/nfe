package com.fincatto.documentofiscal.cte300.classes.nota;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.LocalDate;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.CTModeloNF;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * @author Caio
 * @info Informações das NF<br>
 * Este grupo deve ser informado quando o documento originário for NF
 * */

@Root(name = "infNF")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalInfoDocumentosInfoNF extends DFBase {

	@Element(name = "nRoma", required = false)
    private String numeroRomaneio;
	
	@Element(name = "nPed", required = false)
    private String numeroPedidoNF;
	
	@Element(name = "mod", required = true)
    private CTModeloNF modeloNF;
	
	@Element(name = "serie", required = true)
    private String serie;
	
	@Element(name = "nDoc", required = true)
    private String numeroDocumento;
	
	@Element(name = "dEmi", required = true)
    private LocalDate dataEmissao;
	
	@Element(name = "vBC", required = true)
    private String valorBcICMS;
	
	@Element(name = "vICMS", required = true)
    private String valorICMS;
	
	@Element(name = "vBCST", required = true)
    private String valorBcICMSST;
	
	@Element(name = "vST", required = true)
    private String valorICMSST;
	
	@Element(name = "vProd", required = true)
    private String valorTotalProdutos;
	
	@Element(name = "vNF", required = true)
    private String valorTotalNF;
	
	@Element(name = "nCFOP", required = true)
    private String CFOP;
	
	@Element(name = "nPeso", required = false)
    private String valorPesoTotal;
	
	@Element(name = "PIN", required = false)
    private String pinSUFRAMA;
	
	@Element(name = "dPrev", required = false)
    private LocalDate dataPrevistaEntrega;
	
	@Element(name = "infUnidCarga", required = false)
    private List<CTeNotaInfoCTeNormalInfoDocumentosInfoUnidadeCarga> infoUnidadeCarga;
	
	@Element(name = "infUnidTransp", required = false)
    private List<CTeNotaInfoCTeNormalInfoDocumentosInfoUnidadeTransporte> infoUnidadeTransporte;

	public CTeNotaInfoCTeNormalInfoDocumentosInfoNF() {
		this.numeroRomaneio = null;
		this.numeroPedidoNF = null;
		this.modeloNF = null;
		this.serie = null;
		this.numeroDocumento = null;
		this.dataEmissao = null;
		this.valorBcICMS = null;
		this.valorICMS = null;
		this.valorBcICMSST = null;
		this.valorICMSST = null;
		this.valorTotalProdutos = null;
		this.valorTotalNF = null;
		this.CFOP = null;
		this.valorPesoTotal = null;
		this.pinSUFRAMA = null;
		this.dataPrevistaEntrega = null;
		this.infoUnidadeCarga = null;
		this.infoUnidadeTransporte = null;
	}

	public String getNumeroRomaneio() {
		return numeroRomaneio;
	}

	/**
	 * Número do Romaneio da NF
	 * */
	public void setNumeroRomaneio(String numeroRomaneio) {
		StringValidador.tamanho20(numeroRomaneio, "Número do Romaneio da NF");
		this.numeroRomaneio = numeroRomaneio;
	}

	public String getNumeroPedidoNF() {
		return numeroPedidoNF;
	}

	/**
	 * Número do Pedido da NF
	 * */
	public void setNumeroPedidoNF(String numeroPedidoNF) {
		StringValidador.tamanho20(numeroPedidoNF, "Número do Pedido da NF");
		this.numeroPedidoNF = numeroPedidoNF;
	}

	public CTModeloNF getModeloNF() {
		return modeloNF;
	}

	/**
	 * Modelo da Nota Fiscal<br>
	 * Preencher com:<br>
	 * 01 - NF Modelo 01/1A e Avulsa;<br>
	 * 04 - NF de Produtor
	 * */
	public void setModeloNF(CTModeloNF modeloNF) {
		this.modeloNF = modeloNF;
	}

	public String getSerie() {
		return serie;
	}

	/**
	 * Série
	 * */
	public void setSerie(String serie) {
		StringValidador.tamanho3(serie, "Série");
		this.serie = serie;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	/**
	 * Número 
	 * */
	public void setNumeroDocumento(String numeroDocumento) {
		StringValidador.tamanho20(numeroDocumento, "Número");
		this.numeroDocumento = numeroDocumento;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	/**
	 * Data de Emissão<br>
	 * Formato AAAA-MM-DD
	 * */
	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getValorBcICMS() {
		return valorBcICMS;
	}

	/**
	 * Valor da Base de Cálculo do ICMS
	 * */
	public void setValorBcICMS(BigDecimal valorBcICMS) {
		this.valorBcICMS = BigDecimalParser.tamanho15Com2CasasDecimais(valorBcICMS, "Valor da Base de Cálculo do ICMS");
	}

	public String getValorICMS() {
		return valorICMS;
	}

	/**
	 * Valor Total do ICMS
	 * */
	public void setValorICMS(BigDecimal valorICMS) {
		this.valorICMS = BigDecimalParser.tamanho15Com2CasasDecimais(valorICMS, "Valor Total do ICMS");
	}

	public String getValorBcICMSST() {
		return valorBcICMSST;
	}

	/**
	 * Valor da Base de Cálculo do ICMS ST
	 * */
	public void setValorBcICMSST(BigDecimal valorBcICMSST) {
		this.valorBcICMSST = BigDecimalParser.tamanho15Com2CasasDecimais(valorBcICMSST, "Valor da Base de Cálculo do ICMS ST");
	}

	public String getValorICMSST() {
		return valorICMSST;
	}

	/**
	 * Valor Total do ICMS ST
	 * */
	public void setValorICMSST(BigDecimal valorICMSST) {
		this.valorICMSST = BigDecimalParser.tamanho15Com2CasasDecimais(valorICMSST, "Valor Total do ICMS ST");
	}

	public String getValorTotalProdutos() {
		return valorTotalProdutos;
	}

	/**
	 * Valor Total dos Produtos
	 * */
	public void setValorTotalProdutos(BigDecimal valorTotalProdutos) {
		this.valorTotalProdutos = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalProdutos, "Valor Total dos Produtos");
	}

	public String getValorTotalNF() {
		return valorTotalNF;
	}

	/**
	 * Valor Total da NF
	 * */
	public void setValorTotalNF(BigDecimal valorTotalNF) {
		this.valorTotalNF = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalNF, "Valor Total da NF");
	}

	public String getCFOP() {
		return CFOP;
	}

	/**
	 * CFOP Predominante<br>
	 * CFOP da NF ou, na existência de mais de um, predominância pelo critério de valor econômico.
	 * */
	public void setCFOP(String cFOP) {
		StringValidador.exatamente4N(cFOP, "CFOP");
		CFOP = cFOP;
	}

	public String getValorPesoTotal() {
		return valorPesoTotal;
	}

	/**
	 * Peso total em Kg
	 * */
	public void setValorPesoTotal(BigDecimal valorPesoTotal) {
		this.valorPesoTotal = BigDecimalParser.tamanho15Com3CasasDecimais(valorPesoTotal, "Peso total em Kg");
	}

	public String getPinSUFRAMA() {
		return pinSUFRAMA;
	}

	/**
	 * PIN SUFRAMA<br>
	 * PIN atribuído pela SUFRAMA para a operação.
	 * */
	public void setPinSUFRAMA(String pinSUFRAMA) {
		StringValidador.tamanho2a9N(pinSUFRAMA, "PIN SUFRAMA");
		this.pinSUFRAMA = pinSUFRAMA;
	}

	public LocalDate getDataPrevistaEntrega() {
		return dataPrevistaEntrega;
	}

	/**
	 * Data prevista de entrega<br>
	 * Formato AAAA-MM-DD
	 * */
	public void setDataPrevistaEntrega(LocalDate dataPrevistaEntrega) {
		this.dataPrevistaEntrega = dataPrevistaEntrega;
	}

	public List<CTeNotaInfoCTeNormalInfoDocumentosInfoUnidadeCarga> getInfoUnidadeCarga() {
		return infoUnidadeCarga;
	}

	/**
	 * Informações das Unidades de Carga (Containeres/ULD/Outros)<br>
	 * Dispositivo de carga utilizada (Unit Load Device - ULD) significa todo tipo de contêiner de carga, vagão, 
	 * contêiner de avião, palete de aeronave com rede ou palete de aeronave com rede sobre um iglu.
	 * */
	public void setInfoUnidadeCarga(List<CTeNotaInfoCTeNormalInfoDocumentosInfoUnidadeCarga> infoUnidadeCarga) {
		this.infoUnidadeCarga = infoUnidadeCarga;
	}

	public List<CTeNotaInfoCTeNormalInfoDocumentosInfoUnidadeTransporte> getInfoUnidadeTransporte() {
		return infoUnidadeTransporte;
	}

	/**
	 * Informações das Unidades de Transporte (Carreta/Reboque/Vagão)<br>
	 * Deve ser preenchido com as informações das unidades de transporte utilizadas.
	 * */
	public void setInfoUnidadeTransporte(List<CTeNotaInfoCTeNormalInfoDocumentosInfoUnidadeTransporte> infoUnidadeTransporte) {
		this.infoUnidadeTransporte = infoUnidadeTransporte;
	}
}
