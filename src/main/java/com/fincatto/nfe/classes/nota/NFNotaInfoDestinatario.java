package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.classes.NFEndereco;

public class NFNotaInfoDestinatario extends NFBase {
	
	@Element(name = "CNPJ", required = false)
	private String cnpj;
	
	@Element(name = "CPF", required = false)
	private String cpf;
	
	@Element(name = "xNome", required = true)
	private String razaoSocial;
	
	@Element(name = "enderDest", required = true)
	private NFEndereco endereco;
	
	@Element(name = "IE", required = false)
	private String inscricaoEstadual;
	
	@Element(name = "ISUF", required = false)
	private String inscricaoSuframa;
	
	@Element(name = "email", required = false)
	private String email;
	
	public NFNotaInfoDestinatario() {
		this.cnpj = null;
		this.cpf = null;
		this.razaoSocial = null;
		this.endereco = null;
		this.inscricaoEstadual = null;
		this.inscricaoSuframa = null;
		this.email = null;
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
	
	public String getInscricaoSuframa() {
		return this.inscricaoSuframa;
	}
	
	public void setInscricaoSuframa(final String inscricaoSuframa) {
		this.inscricaoSuframa = inscricaoSuframa;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(final String email) {
		this.email = email;
	}
}