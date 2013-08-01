package com.fincatto.nfe.classes.lote.consulta.recibo;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.nfe.NFAmbiente;
import com.fincatto.nfe.NFUnidadeFederativa;
import com.fincatto.nfe.classes.NFe;

@Root(name = "retConsReciNFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class TRetConsReciNFe extends NFe {
	
	@Attribute(name = "versao", required = true)
	private String versao;
	
	@Element(name = "tpAmb", required = true)
	private NFAmbiente ambiente;
	
	@Element(name = "verAplic", required = true)
	private String versaoAplicacao;
	
	@Element(name = "nRec", required = false)
	private String numeroRecibo;
	
	@Element(name = "cStat", required = true)
	private String status;
	
	@Element(name = "xMotivo", required = true)
	private String motivo;
	
	@Element(name = "cUF", required = true)
	private NFUnidadeFederativa uf;
	
	@ElementList(entry = "protNFe", inline = true, required = false)
	protected List<TProtNFe> protocolos;
	
	public TRetConsReciNFe() {
		this.versao = null;
		this.ambiente = null;
		this.versaoAplicacao = null;
		this.numeroRecibo = null;
		this.status = null;
		this.motivo = null;
		this.uf = null;
		this.protocolos = null;
	}
	
	public String getVersao() {
		return this.versao;
	}
	
	public void setVersao(final String versao) {
		this.versao = versao;
	}
	
	public NFAmbiente getAmbiente() {
		return this.ambiente;
	}
	
	public void setAmbiente(final NFAmbiente ambiente) {
		this.ambiente = ambiente;
	}
	
	public String getVersaoAplicacao() {
		return this.versaoAplicacao;
	}
	
	public void setVersaoAplicacao(final String versaoAplicacao) {
		this.versaoAplicacao = versaoAplicacao;
	}
	
	public String getNumeroRecibo() {
		return this.numeroRecibo;
	}
	
	public void setNumeroRecibo(final String numeroRecibo) {
		this.numeroRecibo = numeroRecibo;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(final String status) {
		this.status = status;
	}
	
	public String getMotivo() {
		return this.motivo;
	}
	
	public void setMotivo(final String motivo) {
		this.motivo = motivo;
	}
	
	public NFUnidadeFederativa getUf() {
		return this.uf;
	}
	
	public void setUf(final NFUnidadeFederativa uf) {
		this.uf = uf;
	}
	
	public List<TProtNFe> getProtocolos() {
		return this.protocolos;
	}
	
	public void setProtocolos(final List<TProtNFe> protocolos) {
		this.protocolos = protocolos;
	}
}