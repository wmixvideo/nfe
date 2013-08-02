package com.fincatto.nfe.classes;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.NFUnidadeFederativa;

public class NFEndereco extends NFBase {
	
	@Element(name = "xLgr", required = true)
	private String logradouro;
	
	@Element(name = "nro", required = true)
	private String numero;
	
	@Element(name = "xCpl", required = false)
	private String complemento;
	
	@Element(name = "xBairro", required = true)
	private String bairro;
	
	@Element(name = "cMun", required = true)
	private String codigoMunicipio;
	
	@Element(name = "xMun", required = true)
	private String descricaoMunicipio;
	
	@Element(name = "UF", required = true)
	private NFUnidadeFederativa uf;
	
	@Element(name = "CEP", required = true)
	private String cep;
	
	@Element(name = "cPais", required = false)
	private String codigoPais;
	
	@Element(name = "xPais", required = false)
	private String descricaoPais;
	
	@Element(name = "fone", required = false)
	private String telefone;
	
	public NFEndereco() {
		this.logradouro = null;
		this.numero = null;
		this.complemento = null;
		this.bairro = null;
		this.codigoMunicipio = null;
		this.descricaoMunicipio = null;
		this.uf = null;
		this.cep = null;
		this.codigoPais = null;
		this.descricaoPais = null;
		this.telefone = null;
	}
	
	public String getLogradouro() {
		return this.logradouro;
	}
	
	public void setLogradouro(final String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getNumero() {
		return this.numero;
	}
	
	public void setNumero(final String numero) {
		this.numero = numero;
	}
	
	public String getComplemento() {
		return this.complemento;
	}
	
	public void setComplemento(final String complemento) {
		this.complemento = complemento;
	}
	
	public String getBairro() {
		return this.bairro;
	}
	
	public void setBairro(final String bairro) {
		this.bairro = bairro;
	}
	
	public String getCodigoMunicipio() {
		return this.codigoMunicipio;
	}
	
	public void setCodigoMunicipio(final String codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}
	
	public String getDescricaoMunicipio() {
		return this.descricaoMunicipio;
	}
	
	public void setDescricaoMunicipio(final String descricaoMunicipio) {
		this.descricaoMunicipio = descricaoMunicipio;
	}
	
	public NFUnidadeFederativa getUf() {
		return this.uf;
	}
	
	public void setUf(final NFUnidadeFederativa uf) {
		this.uf = uf;
	}
	
	public String getCep() {
		return this.cep;
	}
	
	public void setCep(final String cep) {
		this.cep = cep;
	}
	
	public String getCodigoPais() {
		return this.codigoPais;
	}
	
	public void setCodigoPais(final String codigoPais) {
		this.codigoPais = codigoPais;
	}
	
	public String getDescricaoPais() {
		return this.descricaoPais;
	}
	
	public void setDescricaoPais(final String descricaoPais) {
		this.descricaoPais = descricaoPais;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	
	public void setTelefone(final String telefone) {
		this.telefone = telefone;
	}
}