package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoItemImpostoIPI extends NFBase {
	
	@Element(name = "clEnq", required = false)
	private String classeEnquadramento;
	
	@Element(name = "cnpjProd", required = false)
	private String cnpjProdutor;
	
	@Element(name = "cSelo", required = false)
	private String codigoSelo;
	
	@Element(name = "qSelo", required = false)
	private BigDecimal quantidadeSelo;
	
	@Element(name = "cEnq", required = true)
	private String codigoEnquadramento;
	
	@Element(name = "IPITrib", required = false)
	private NFNotaInfoItemImpostoIPITributado tributado;
	
	@Element(name = "IPINT", required = false)
	private NFNotaInfoItemImpostoIPINaoTributado naoTributado;
	
	public NFNotaInfoItemImpostoIPI() {
		this.classeEnquadramento = null;
		this.cnpjProdutor = null;
		this.codigoSelo = null;
		this.quantidadeSelo = null;
		this.codigoEnquadramento = null;
		this.tributado = null;
		this.naoTributado = null;
	}
	
	public String getClasseEnquadramento() {
		return this.classeEnquadramento;
	}
	
	public void setClasseEnquadramento(final String classeEnquadramento) {
		this.classeEnquadramento = classeEnquadramento;
	}
	
	public String getCnpjProdutor() {
		return this.cnpjProdutor;
	}
	
	public void setCnpjProdutor(final String cnpjProdutor) {
		this.cnpjProdutor = cnpjProdutor;
	}
	
	public String getCodigoSelo() {
		return this.codigoSelo;
	}
	
	public void setCodigoSelo(final String codigoSelo) {
		this.codigoSelo = codigoSelo;
	}
	
	public BigDecimal getQuantidadeSelo() {
		return this.quantidadeSelo;
	}
	
	public void setQuantidadeSelo(final BigDecimal quantidadeSelo) {
		this.quantidadeSelo = quantidadeSelo;
	}
	
	public String getCodigoEnquadramento() {
		return this.codigoEnquadramento;
	}
	
	public void setCodigoEnquadramento(final String codigoEnquadramento) {
		this.codigoEnquadramento = codigoEnquadramento;
	}
	
	public NFNotaInfoItemImpostoIPITributado getTributado() {
		return this.tributado;
	}
	
	public void setTributado(final NFNotaInfoItemImpostoIPITributado tributado) {
		this.tributado = tributado;
	}
	
	public NFNotaInfoItemImpostoIPINaoTributado getNaoTributado() {
		return this.naoTributado;
	}
	
	public void setNaoTributado(final NFNotaInfoItemImpostoIPINaoTributado naoTributado) {
		this.naoTributado = naoTributado;
	}
}