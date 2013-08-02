package com.fincatto.nfe.classes.nota;

import org.joda.time.LocalDate;
import org.simpleframework.xml.Element;

import com.fincatto.nfe.NFAmbiente;
import com.fincatto.nfe.NFUnidadeFederativa;
import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.classes.NFFinalidade;
import com.fincatto.nfe.classes.NFFormaPagamento;
import com.fincatto.nfe.classes.NFProgramaEmissor;
import com.fincatto.nfe.classes.NFTipo;
import com.fincatto.nfe.classes.NFTipoEmissao;
import com.fincatto.nfe.classes.NFTipoImpressao;

public class NFNotaInfoIdentificacao extends NFBase {
	
	@Element(name = "cUF", required = true)
	private NFUnidadeFederativa uf;
	
	@Element(name = "cNF", required = true)
	private String codigoRandomico;
	
	@Element(name = "natOp", required = true)
	private String naturezaOperacao;
	
	@Element(name = "indPag", required = true)
	private NFFormaPagamento formaPagamento;
	
	@Element(name = "mod", required = true)
	private String modelo;
	
	@Element(name = "serie", required = true)
	private String serie;
	
	@Element(name = "nNF", required = true)
	private String numeroNota;
	
	@Element(name = "dEmi", required = true)
	private LocalDate dataEmissao;
	
	@Element(name = "dSaiEnt", required = true)
	private LocalDate dataSaida;
	
	@Element(name = "tpNF", required = true)
	private NFTipo tipo;
	
	@Element(name = "cMunFG", required = true)
	private String codigoMunicipio;
	
	@Element(name = "tpImp", required = true)
	private NFTipoImpressao tipoImpressao;
	
	@Element(name = "tpEmis", required = true)
	private NFTipoEmissao tipoEmissao;
	
	@Element(name = "cDV", required = true)
	private String digitoVerificador;
	
	@Element(name = "tpAmb", required = true)
	private NFAmbiente ambiente;
	
	@Element(name = "finNFe", required = true)
	private NFFinalidade finalidade;
	
	@Element(name = "procEmi", required = true)
	private NFProgramaEmissor programaEmissor;
	
	@Element(name = "verProc", required = true)
	private String versaoEmissor;
	
	public NFNotaInfoIdentificacao() {
		this.uf = null;
		this.codigoRandomico = null;
		this.naturezaOperacao = null;
		this.formaPagamento = null;
		this.modelo = null;
		this.serie = null;
		this.numeroNota = null;
		this.dataEmissao = null;
		this.dataSaida = null;
		this.tipo = null;
		this.codigoMunicipio = null;
		this.tipoImpressao = null;
		this.tipoEmissao = null;
		this.digitoVerificador = null;
		this.ambiente = null;
		this.finalidade = null;
		this.programaEmissor = null;
		this.versaoEmissor = null;
	}
	
	public NFUnidadeFederativa getUf() {
		return this.uf;
	}
	
	public void setUf(final NFUnidadeFederativa uf) {
		this.uf = uf;
	}
	
	public String getCodigoRandomico() {
		return this.codigoRandomico;
	}
	
	public void setCodigoRandomico(final String codigoRandomico) {
		this.codigoRandomico = codigoRandomico;
	}
	
	public String getNaturezaOperacao() {
		return this.naturezaOperacao;
	}
	
	public void setNaturezaOperacao(final String naturezaOperacao) {
		this.naturezaOperacao = naturezaOperacao;
	}
	
	public NFFormaPagamento getFormaPagamento() {
		return this.formaPagamento;
	}
	
	public void setFormaPagamento(final NFFormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	public String getModelo() {
		return this.modelo;
	}
	
	public void setModelo(final String modelo) {
		this.modelo = modelo;
	}
	
	public String getSerie() {
		return this.serie;
	}
	
	public void setSerie(final String serie) {
		this.serie = serie;
	}
	
	public String getNumeroNota() {
		return this.numeroNota;
	}
	
	public void setNumeroNota(final String numeroNota) {
		this.numeroNota = numeroNota;
	}
	
	public LocalDate getDataEmissao() {
		return this.dataEmissao;
	}
	
	public void setDataEmissao(final LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	
	public LocalDate getDataSaida() {
		return this.dataSaida;
	}
	
	public void setDataSaida(final LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}
	
	public NFTipo getTipo() {
		return this.tipo;
	}
	
	public void setTipo(final NFTipo tipo) {
		this.tipo = tipo;
	}
	
	public String getCodigoMunicipio() {
		return this.codigoMunicipio;
	}
	
	public void setCodigoMunicipio(final String codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}
	
	public NFTipoImpressao getTipoImpressao() {
		return this.tipoImpressao;
	}
	
	public void setTipoImpressao(final NFTipoImpressao tipoImpressao) {
		this.tipoImpressao = tipoImpressao;
	}
	
	public NFTipoEmissao getTipoEmissao() {
		return this.tipoEmissao;
	}
	
	public void setTipoEmissao(final NFTipoEmissao tipoEmissao) {
		this.tipoEmissao = tipoEmissao;
	}
	
	public String getDigitoVerificador() {
		return this.digitoVerificador;
	}
	
	public void setDigitoVerificador(final String digitoVerificador) {
		this.digitoVerificador = digitoVerificador;
	}
	
	public NFAmbiente getAmbiente() {
		return this.ambiente;
	}
	
	public void setAmbiente(final NFAmbiente ambiente) {
		this.ambiente = ambiente;
	}
	
	public NFFinalidade getFinalidade() {
		return this.finalidade;
	}
	
	public void setFinalidade(final NFFinalidade finalidade) {
		this.finalidade = finalidade;
	}
	
	public NFProgramaEmissor getProgramaEmissor() {
		return this.programaEmissor;
	}
	
	public void setProgramaEmissor(final NFProgramaEmissor programaEmissor) {
		this.programaEmissor = programaEmissor;
	}
	
	public String getVersaoEmissor() {
		return this.versaoEmissor;
	}
	
	public void setVersaoEmissor(final String versaoEmissor) {
		this.versaoEmissor = versaoEmissor;
	}
}
