package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoItemProdutoVeiculo extends NFBase {
	
	@Element(name = "tpOp", required = true)
	private NFNotaInfoItemProdutoVeiculoTipoOperacao tipoOperacao;
	
	@Element(name = "chassi", required = true)
	private String chassi;
	
	@Element(name = "cCor", required = true)
	private String codigoCor;
	
	@Element(name = "xCor", required = true)
	private String descricaoCor;
	
	@Element(name = "pot", required = true)
	private String potencia;
	
	@Element(name = "cilin", required = true)
	private String cilindrada;
	
	@Element(name = "pesoL", required = true)
	private BigDecimal pesoLiquido;
	
	@Element(name = "pesoB", required = true)
	private BigDecimal pesoBruto;
	
	@Element(name = "nSerie", required = true)
	private String numeroSerie;
	
	@Element(name = "tpComb", required = true)
	private String tipoCombustivel;
	
	@Element(name = "nMotor", required = true)
	private String numeroMotor;
	
	@Element(name = "CMT", required = true)
	private String capacidadeMaximaTracao;
	
	@Element(name = "dist", required = true)
	private String distanciaEntreEixos;
	
	@Element(name = "anoMod", required = true)
	private String anoModeloFabricacao;
	
	@Element(name = "anoFab", required = true)
	private String anoFabricacao;
	
	@Element(name = "tpPint", required = true)
	private String tipoPintura;
	
	@Element(name = "tpVeic", required = true)
	private String tipoVeiculo;
	
	@Element(name = "espVeic", required = true)
	private String especieVeiculo;
	
	@Element(name = "VIN", required = true)
	private NFNotaInfoItemProdutoVeiculoCondicaoChassi condicaoChassi;
	
	@Element(name = "condVeic", required = true)
	private NFNotaInfoItemProdutoVeiculoCondicao condicao;
	
	@Element(name = "cMod", required = true)
	private String codigoMarcaModelo;
	
	@Element(name = "cCorDENATRAN", required = true)
	private String codigoCorDENATRAN;
	
	@Element(name = "lota", required = true)
	private String lotacao;
	
	@Element(name = "tpRest", required = true)
	private NFNotaInfoItemProdutoVeiculoRestricao restricao;
	
	public NFNotaInfoItemProdutoVeiculo() {
		this.tipoOperacao = null;
		this.chassi = null;
		this.codigoCor = null;
		this.descricaoCor = null;
		this.potencia = null;
		this.cilindrada = null;
		this.pesoLiquido = null;
		this.pesoBruto = null;
		this.numeroSerie = null;
		this.tipoCombustivel = null;
		this.numeroMotor = null;
		this.capacidadeMaximaTracao = null;
		this.distanciaEntreEixos = null;
		this.anoModeloFabricacao = null;
		this.anoFabricacao = null;
		this.tipoPintura = null;
		this.tipoVeiculo = null;
		this.especieVeiculo = null;
		this.condicaoChassi = null;
		this.condicao = null;
		this.codigoMarcaModelo = null;
		this.codigoCorDENATRAN = null;
		this.lotacao = null;
		this.restricao = null;
	}
	
	public NFNotaInfoItemProdutoVeiculoTipoOperacao getTipoOperacao() {
		return this.tipoOperacao;
	}
	
	public void setTipoOperacao(final NFNotaInfoItemProdutoVeiculoTipoOperacao tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}
	
	public String getChassi() {
		return this.chassi;
	}
	
	public void setChassi(final String chassi) {
		this.chassi = chassi;
	}
	
	public String getCodigoCor() {
		return this.codigoCor;
	}
	
	public void setCodigoCor(final String codigoCor) {
		this.codigoCor = codigoCor;
	}
	
	public String getDescricaoCor() {
		return this.descricaoCor;
	}
	
	public void setDescricaoCor(final String descricaoCor) {
		this.descricaoCor = descricaoCor;
	}
	
	public String getPotencia() {
		return this.potencia;
	}
	
	public void setPotencia(final String potencia) {
		this.potencia = potencia;
	}
	
	public String getCilindrada() {
		return this.cilindrada;
	}
	
	public void setCilindrada(final String cilindrada) {
		this.cilindrada = cilindrada;
	}
	
	public BigDecimal getPesoLiquido() {
		return this.pesoLiquido;
	}
	
	public void setPesoLiquido(final BigDecimal pesoLiquido) {
		this.pesoLiquido = pesoLiquido;
	}
	
	public BigDecimal getPesoBruto() {
		return this.pesoBruto;
	}
	
	public void setPesoBruto(final BigDecimal pesoBruto) {
		this.pesoBruto = pesoBruto;
	}
	
	public String getNumeroSerie() {
		return this.numeroSerie;
	}
	
	public void setNumeroSerie(final String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	
	public String getTipoCombustivel() {
		return this.tipoCombustivel;
	}
	
	public void setTipoCombustivel(final String tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}
	
	public String getNumeroMotor() {
		return this.numeroMotor;
	}
	
	public void setNumeroMotor(final String numeroMotor) {
		this.numeroMotor = numeroMotor;
	}
	
	public String getCapacidadeMaximaTracao() {
		return this.capacidadeMaximaTracao;
	}
	
	public void setCapacidadeMaximaTracao(final String capacidadeMaximaTracao) {
		this.capacidadeMaximaTracao = capacidadeMaximaTracao;
	}
	
	public String getDistanciaEntreEixos() {
		return this.distanciaEntreEixos;
	}
	
	public void setDistanciaEntreEixos(final String distanciaEntreEixos) {
		this.distanciaEntreEixos = distanciaEntreEixos;
	}
	
	public String getAnoModeloFabricacao() {
		return this.anoModeloFabricacao;
	}
	
	public void setAnoModeloFabricacao(final String anoModeloFabricacao) {
		this.anoModeloFabricacao = anoModeloFabricacao;
	}
	
	public String getAnoFabricacao() {
		return this.anoFabricacao;
	}
	
	public void setAnoFabricacao(final String anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	
	public String getTipoPintura() {
		return this.tipoPintura;
	}
	
	public void setTipoPintura(final String tipoPintura) {
		this.tipoPintura = tipoPintura;
	}
	
	public String getTipoVeiculo() {
		return this.tipoVeiculo;
	}
	
	public void setTipoVeiculo(final String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}
	
	public String getEspecieVeiculo() {
		return this.especieVeiculo;
	}
	
	public void setEspecieVeiculo(final String especieVeiculo) {
		this.especieVeiculo = especieVeiculo;
	}
	
	public NFNotaInfoItemProdutoVeiculoCondicaoChassi getCondicaoChassi() {
		return this.condicaoChassi;
	}
	
	public void setCondicaoChassi(final NFNotaInfoItemProdutoVeiculoCondicaoChassi condicaoChassi) {
		this.condicaoChassi = condicaoChassi;
	}
	
	public NFNotaInfoItemProdutoVeiculoCondicao getCondicao() {
		return this.condicao;
	}
	
	public void setCondicao(final NFNotaInfoItemProdutoVeiculoCondicao condicao) {
		this.condicao = condicao;
	}
	
	public String getCodigoMarcaModelo() {
		return this.codigoMarcaModelo;
	}
	
	public void setCodigoMarcaModelo(final String codigoMarcaModelo) {
		this.codigoMarcaModelo = codigoMarcaModelo;
	}
	
	public String getCodigoCorDENATRAN() {
		return this.codigoCorDENATRAN;
	}
	
	public void setCodigoCorDENATRAN(final String codigoCorDENATRAN) {
		this.codigoCorDENATRAN = codigoCorDENATRAN;
	}
	
	public String getLotacao() {
		return this.lotacao;
	}
	
	public void setLotacao(final String lotacao) {
		this.lotacao = lotacao;
	}
	
	public NFNotaInfoItemProdutoVeiculoRestricao getRestricao() {
		return this.restricao;
	}
	
	public void setRestricao(final NFNotaInfoItemProdutoVeiculoRestricao restricao) {
		this.restricao = restricao;
	}
}