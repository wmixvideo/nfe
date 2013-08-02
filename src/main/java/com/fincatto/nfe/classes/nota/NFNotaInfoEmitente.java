package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.classes.NFEndereco;
import com.fincatto.nfe.classes.NFRegimeTributario;

public class NFNotaInfoEmitente extends NFBase {
	
	@Element(name = "CNPJ", required = false)
	private String cnpj;
	
	@Element(name = "CPF", required = false)
	private String cpf;
	
	@Element(name = "xNome", required = true)
	private String razaoSocial;
	
	@Element(name = "xFant", required = false)
	private String nomeFantasia;
	
	@Element(name = "enderEmit", required = true)
	private NFEndereco endereco;
	
	@Element(name = "IE", required = true)
	private String inscricaoEstadual;
	
	@Element(name = "IEST", required = false)
	private String inscricaoEstadualSubstituicaoTributaria;
	
	@Element(name = "IM", required = false)
	private String inscricaoMunicipal;
	
	@Element(name = "CNAE", required = false)
	private String classificacaoNacionalAtividadesEconomicas;
	
	@Element(name = "CRT", required = true)
	private NFRegimeTributario regimeTributario;
	
	public NFNotaInfoEmitente() {
		this.cnpj = null;
		this.cpf = null;
		this.razaoSocial = null;
		this.nomeFantasia = null;
		this.endereco = null;
		this.inscricaoEstadual = null;
		this.inscricaoEstadualSubstituicaoTributaria = null;
		this.inscricaoMunicipal = null;
		this.classificacaoNacionalAtividadesEconomicas = null;
		this.regimeTributario = null;
	}
	
	public String getCnpj() {
		return this.cnpj;
	}
	
	public void setCnpj(final String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public void setCpf(final String cpf) {
		this.cpf = cpf;
	}
	
	public String getRazaoSocial() {
		return this.razaoSocial;
	}
	
	public void setRazaoSocial(final String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public String getNomeFantasia() {
		return this.nomeFantasia;
	}
	
	public void setNomeFantasia(final String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	
	public NFEndereco getEndereco() {
		return this.endereco;
	}
	
	public void setEndereco(final NFEndereco endereco) {
		this.endereco = endereco;
	}
	
	public String getInscricaoEstadual() {
		return this.inscricaoEstadual;
	}
	
	public void setInscricaoEstadual(final String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	
	public String getInscricaoEstadualSubstituicaoTributaria() {
		return this.inscricaoEstadualSubstituicaoTributaria;
	}
	
	public void setInscricaoEstadualSubstituicaoTributaria(final String inscricaoEstadualSubstituicaoTributaria) {
		this.inscricaoEstadualSubstituicaoTributaria = inscricaoEstadualSubstituicaoTributaria;
	}
	
	public String getInscricaoMunicipal() {
		return this.inscricaoMunicipal;
	}
	
	public void setInscricaoMunicipal(final String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}
	
	public String getClassificacaoNacionalAtividadesEconomicas() {
		return this.classificacaoNacionalAtividadesEconomicas;
	}
	
	public void setClassificacaoNacionalAtividadesEconomicas(final String classificacaoNacionalAtividadesEconomicas) {
		this.classificacaoNacionalAtividadesEconomicas = classificacaoNacionalAtividadesEconomicas;
	}
	
	public NFRegimeTributario getRegimeTributario() {
		return this.regimeTributario;
	}
	
	public void setRegimeTributario(final NFRegimeTributario regimeTributario) {
		this.regimeTributario = regimeTributario;
	}
}